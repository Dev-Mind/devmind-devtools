package com.devmind.devtools.model;

import static com.devmind.devtools.util.StringUtils.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class Speaker implements Identifiable {

    private String id;
    private String login;
    private String email;
    private String firstname;
    private String lastname;
    private String company;
    private String shortDescription;
    private String longDescription;
    private String token;
    @JsonIgnore
    private Set<Session> sessions = new HashSet<>();

    public Set<Session> getSessions() {
        return sessions;
    }

    public Speaker clearSessions() {
        this.sessions.clear();
        return this;
    }

    public Speaker addSession(Session session) {
        this.sessions.add(session);
        return this;
    }

    public Speaker removeSharedLink(Session session) {
        this.sessions.remove(session);
        return this;
    }

    public String getId() {
        return id;
    }

    public Speaker setId(String id) {
        this.id = id;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public Speaker setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Speaker setEmail(String email) {
        this.email = lowercase(email);
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public Speaker setFirstname(String firstname) {
        this.firstname = capitalize(lowercase(firstname));
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public Speaker setLastname(String lastname) {
        this.lastname = uppercase(lastname);
        return this;
    }

    public String getCompany() {
        return company;
    }

    public Speaker setCompany(String company) {
        this.company = company;
        return this;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public Speaker setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
        return this;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public Speaker setLongDescription(String longDescription) {
        this.longDescription = longDescription;
        return this;
    }

    public String getToken() {
        return token;
    }

    public Speaker setToken(String token) {
        this.token = token;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Speaker speaker = (Speaker) o;
        return Objects.equals(id, speaker.id) &&
                Objects.equals(login, speaker.login) &&
                Objects.equals(email, speaker.email) &&
                Objects.equals(firstname, speaker.firstname) &&
                Objects.equals(lastname, speaker.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, email, firstname, lastname);
    }
}