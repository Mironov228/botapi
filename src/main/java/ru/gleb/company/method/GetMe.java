package ru.gleb.company.method;

import ru.gleb.company.model.User;
import ru.gleb.company.model.mapper.Mapper;
import ru.gleb.company.model.mapper.UserMapper;

public class GetMe implements Method<User> {
	@Override
	public String methodName() {
		return "getMe";
	}

	@Override
	public Mapper<User> getMapper() {
		return UserMapper::map;
	}
}