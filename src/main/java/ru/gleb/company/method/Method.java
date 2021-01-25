package ru.gleb.company.method;

import ru.gleb.company.model.mapper.Mapper;

public interface Method<T> {
	String methodName();
	Mapper<T> getMapper();
	default Object[] parameters() { return new Object[0]; };
}