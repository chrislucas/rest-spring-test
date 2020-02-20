package br.com.sample.restapi.services;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface ISimpleService<T> extends IService<T>{

	@Override
	default List<T> getAll() {
		return null;
	}

	@Override
	default T get(long id) {
		return null;
	}

	@Override
	default void save(T model) {}

	@Override
	default void delete(long id) {}

	@Override
	default void update(T model) {}

	@Override
	default T updateById(long id, T model) {
		return null;
	}
}
