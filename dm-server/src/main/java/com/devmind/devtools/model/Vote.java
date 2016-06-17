package com.devmind.devtools.model;

import java.util.Objects;

public class Vote implements Identifiable{

    private String id;

    private Session session;

    private Speaker member;

    /**
     * true if the vote is positive
     */
    public Boolean value;

    public String getId() {
        return id;
    }

    public Vote setId(String id) {
        this.id = id;
        return this;
    }

    public Session getSession() {
        return session;
    }

    public Vote setSession(Session session) {
        this.session = session;
        return this;
    }

    public Speaker getMember() {
        return member;
    }

    public Vote setMember(Speaker member) {
        this.member = member;
        return this;
    }

    public Boolean getValue() {
        return value;
    }

    public Vote setValue(Boolean value) {
        this.value = value;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vote vote = (Vote) o;
        return Objects.equals(session, vote.session) &&
                Objects.equals(member, vote.member) &&
                Objects.equals(value, vote.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(session, member, value);
    }
}
