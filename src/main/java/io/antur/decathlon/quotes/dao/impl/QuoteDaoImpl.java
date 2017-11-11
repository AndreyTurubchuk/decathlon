package io.antur.decathlon.quotes.dao.impl;

import io.antur.decathlon.quotes.dao.GenericDao;
import io.antur.decathlon.quotes.dao.QuoteDao;
import io.antur.decathlon.quotes.entity.Quote;
import org.springframework.stereotype.Repository;

@Repository
public class QuoteDaoImpl extends GenericDaoImpl<Quote, Integer> implements QuoteDao {

    public QuoteDaoImpl() {
        super(Quote.class);
    }
}