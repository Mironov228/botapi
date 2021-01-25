package ru.gleb.company.method;

import ru.gleb.company.model.mapper.Mapper;

public interface ArrayMethod<T> extends Method<T> {
	Class<T> getModelClass(); // class of result
}