package io.antur.decathlon.quotes.dao;

import io.antur.decathlon.quotes.entity.Quote;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, K extends Serializable> {
    K save(T object);

    void saveOrUpdate(T object);
    void delete(T object);
    T getById(K key);
    List<T> getAll();
    List<T> getTOPorFLOP10(Integer firstLine, Integer addLine, String sortBy, String sortOrder);
    List<T> getLAST();
    Quote getRandom();

}
