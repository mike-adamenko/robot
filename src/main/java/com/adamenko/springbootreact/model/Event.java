package com.adamenko.springbootreact.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.time.Instant;
import java.util.Set;

@Entity
public class Event {

    @Id
    @GeneratedValue
    private Long id;
    private Instant date;
    private String title;
    private String description;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<User> attendees;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<User> getAttendees() {
        return attendees;
    }

    public void setAttendees(Set<User> attendees) {
        this.attendees = attendees;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Event() {}

    public Event(Instant date, String title, String description) {
        this.date = date;
        this.title = title;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", date=" + date +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", attendees=" + getAttendees() +
                '}';
    }

    public static class Builder {
        private Instant date;
        private String title;
        private String description;

        public Event build() {
            return new Event(date, title, description);
        }

        public Builder date(Instant date) {
            this.date = date;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }
    }
}