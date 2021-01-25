package ru.gleb.company.method;

import ru.gleb.company.model.Update;
import ru.gleb.company.model.mapper.Mapper;
import ru.gleb.company.model.mapper.UpdateMapper;
import java.util.Optional;

public class GetUpdates implements ArrayMethod<Update> {
	private Optional<Integer> offset;

	public GetUpdates() {
		offset = Optional.empty();
	}

	public GetUpdates(int offset) {
		this.offset = Optional.of(offset);
	}

	@Override
	public String methodName() {
		return "getUpdates";
	}

	@Override
	public Mapper<Update> getMapper() {
		return UpdateMapper::map;
	}

	@Override
	public Class<Update> getModelClass() {
		return Update.class;
	}

	@Override
	public Object[] parameters() {
		if (offset.isPresent()) {
			return new Object[] { "offset", offset.get() };
		}
		return new Object[0];
	}
}