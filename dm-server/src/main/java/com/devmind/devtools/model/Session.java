package com.devmind.devtools.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Session implements Identifiable {

    private String id;
    private String title;
    private String summary;
    private LocalDateTime addedAt = LocalDateTime.now();
    private Integer maxAttendees;
    private Level level;
    private String description;
    private Set<Speaker> speakers = new HashSet<>();
    private LocalDateTime start;
    private LocalDateTime end;

    public String getId() {
        return id;
    }

    public Session setId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Session setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getSummary() {
        return summary;
    }

    public Session setSummary(String summary) {
        this.summary = summary;
        return this;
    }

    public LocalDateTime getAddedAt() {
        return addedAt;
    }

    public Session setAddedAt(LocalDateTime addedAt) {
        this.addedAt = addedAt;
        return this;
    }

    public Integer getMaxAttendees() {
        return maxAttendees;
    }

    public Session setMaxAttendees(Integer maxAttendees) {
        this.maxAttendees = maxAttendees;
        return this;
    }

    public Level getLevel() {
        return level;
    }

    public Session setLevel(Level level) {
        this.level = level;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Session setDescription(String description) {
        this.description = description;
        return this;
    }

    public Set<Speaker> getSpeakers() {
        return speakers;
    }

    public boolean containsSpeaker(Long idSpeaker) {
        return this.speakers
                .stream()
                .filter(s -> s.getId().equals(idSpeaker))
                .findFirst()
                .isPresent();
    }

    public Session addSpeaker(Speaker speaker) {
        if (speaker != null) {
            this.speakers.add(speaker);
        }
        return this;
    }

    public Session removeSpeaker(Speaker speaker) {
        this.speakers.remove(speaker);
        return this;
    }

    public Session clearSpeakers() {
        this.speakers.clear();
        return this;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public Session setStart(LocalDateTime start) {
        this.start = start;
        return this;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public Session setEnd(LocalDateTime end) {
        this.end = end;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Session session = (Session) o;
        return Objects.equals(id, session.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
