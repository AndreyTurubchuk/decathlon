/*Сущность "quote"
*/

package io.antur.decathlon.quotes.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "QUOTES")
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "QUOTE_ID")
    private Integer quoteId;

    @Column(name = "TEXT")
    private String text;

    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "VOTE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date voteDate;

    public Quote() {
        this.createdDate = new Date();
        this.voteDate = new Date();
    }

    public Integer getQuoterId() {
        return quoteId;
    }

    public void setQuoterId(Integer quoterId) {
        this.quoteId = quoterId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getVoteDate() {
        return voteDate;
    }

    public void setVoteDate(Date voteDate) {
        this.voteDate = voteDate;
    }
}
