package io.antur.decathlon.quotes.dao.impl;

import io.antur.decathlon.quotes.dao.GenericDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Transactional
public class GenericDaoImpl<T, K extends Serializable> implements GenericDao<T, K> {
    private Class<T> type;

    @Autowired
    private SessionFactory sessionFactory;

    public GenericDaoImpl(Class<T> type) {
        this.type = type;
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }


    @SuppressWarnings("unchecked")
    public K save(T entity) {
        return (K) getSession().save(entity);
    }

    public void update(T entity) {
        getSession().update(entity);
    }

    public void saveOrUpdate(T entity) {
        getSession().saveOrUpdate(entity);
    }

    public void delete(T entity) {
        getSession().delete(entity);
    }

    public T getById(K key) {
        return getSession().get(type, key);
    }

    //получение всего списка из БД
    @SuppressWarnings("unchecked")
    public List<T> getAll() {
        org.hibernate.query.Query query = getSession().createQuery(String.format("from %s", type.getName()));
        return query.list();
    }



    @SuppressWarnings("unchecked")
    public List<T> getTOPorFLOP10(Integer firstLine, Integer addLine, String sortBy, String sortOrder) {
        Query query = getSession().createQuery(String.format("FROM %s f ORDER BY f.%s %s ", type.getName(), sortBy, sortOrder));
        query.setFirstResult(firstLine);
        query.setMaxResults(addLine);
        return query.list();
    }

    @SuppressWarnings("unchecked")
    public List<T> getLAST() {
        Query query = getSession().createQuery(String.format("FROM %s f ORDER BY f.quoteId DESC", type.getName()));
        query.setFirstResult(0);
        query.setMaxResults(1);
        return query.list();
    }

/*    SELECT *
    FROM quotes
    ORDER BY quote_id DESC
    LIMIT 1;*/

    //поиск в БД по тексту "findText"
    //принять от пользователя тексовое значение поиска findText
    //сделать запрос к БД - найти все строки, в которых "reading" или "text" равно "findText"
    // вернуть список
    @SuppressWarnings("unchecked")
    public List<T> getAll(String findText) {
        org.hibernate.query.Query query = getSession().createQuery(String.format("FROM %s f WHERE f.reading like ? OR f.text like ?", type.getName()));
        query.setParameter(0, "%" + findText + "%");
        query.setParameter(1, "%" + findText + "%");
        return query.list();
    }
}
