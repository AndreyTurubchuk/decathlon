package io.antur.decathlon.quotes.dao;

import io.antur.decathlon.quotes.entity.Quote;

import java.util.List;

public interface QuoteDao extends GenericDao<Quote, Integer> {
    void upVote(int voteId);

}
