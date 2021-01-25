package ru.gleb.company.general;

import ru.gleb.company.model.*;
import ru.gleb.company.method.Method;
import ru.gleb.company.method.ArrayMethod;
import ru.gleb.company.method.GetUpdates;
import ru.gleb.company.method.GetMe;
import ru.gleb.company.model.mapper.*;
import org.json.JSONObject;
import org.json.JSONArray;
import ru.gleb.company.general.UpdateHandler;
import java.nio.charset.StandardCharsets;
import java.net.*;
import java.util.*;
import java.io.*;

public class BotAPI {
	private String botToken;
	
	public BotAPI(String botToken) {
		this.botToken = botToken;
		User user = executeMethod(new GetMe());
		if (user == null)
			throw new IllegalArgumentException("bot token incorrect");
	}

	public JSONObject sendRequest(String method, Object ... params) throws IOException {
		if (params.length%2 != 0)
			throw new IllegalArgumentException("Not available create pairs from params, params length must be divisible by two");
		if (params.length == 0)
			return sendRequest(method, Collections.<String, String>emptyMap());
		Map<String, String> map = new HashMap<>();
		for (int i = 0; i < params.length; i+=2) {
			map.put(String.valueOf(params[i]), String.valueOf(params[i+1]));
		}
		return sendRequest(method, map);
	}

	public JSONObject sendRequest(String method, Map<String, String> params) throws IOException {
		if (botToken == null)
			throw new IllegalStateException("botToken is null");

		StringBuilder urlString = new StringBuilder("https://api.telegram.org/bot");
		urlString.append(botToken).append("/").append(method).append("?");
		for (Map.Entry<String, String> param : params.entrySet()) {
			String value = URLEncoder.encode(param.getValue(), "utf8");
			urlString.append(param.getKey()).append("=").append(value).append("&");
		}
		URL url = new URL(urlString.toString());
		URLConnection con = url.openConnection();
		String content = readFromRequest(con.getInputStream());
		return new JSONObject(content);
	}

	private String readFromRequest(InputStream in) throws IOException {
		return new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8)).lines()
			.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
	}

	public void startListenUpdates(UpdateHandler updateHandler) {
		if (botToken == null)
			throw new IllegalStateException("botToken is null");
		new Thread(() -> {
			GetUpdates getUpdates = new GetUpdates();
			while (true) {
				try {
					Update[] updates = executeArrayMethod(getUpdates);
					if (updates.length != 0) {
						Update max = Arrays.stream(updates).peek(updateHandler::handleUpdate)
							.max(Comparator.comparingInt(Update::getUpdateId)).get();
						executeArrayMethod(new GetUpdates(max.getUpdateId()+1));
					}
					Thread.sleep(100);
				} catch(InterruptedException e) {
					System.out.println(e);
				}
			}
		}).start();
	}

	public <T> T executeMethod(Method<T> method) {
		try {
			return method.getMapper().map(sendRequest(method.methodName(), method.parameters()).getJSONObject("result"));
		} catch(IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public <T> T[] executeArrayMethod(ArrayMethod<T> method) {
		try {
			return Mapper.mapArray(sendRequest(method.methodName(), method.parameters()).getJSONArray("result"),
				method.getMapper(), method.getModelClass());
		} catch(IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}