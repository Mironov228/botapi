package ru.gleb.company.model;

public abstract class Model {
	public abstract String toString(int repeatCount);

	@Override
	public String toString() {
		return toString(1);
	}
}