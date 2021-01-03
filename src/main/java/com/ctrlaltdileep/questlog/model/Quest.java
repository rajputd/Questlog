package com.ctrlaltdileep.questlog.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Quest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    //make fields not nullable
    private String name;
    private String description;
    private boolean complete;

    //TODO: subtasks


    //TODO: last mod timestamp
    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date lastModifiedDate;

    protected  Quest() {}

    public Quest(String name, String description) {
        this.name = name;
        this.description = description;
        this.complete = false;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    protected void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    protected void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    public String toString() {
        return "Quest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", complete=" + complete +
                ", createdDate=" + createdDate +
                ", lastModifiedDate=" + lastModifiedDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quest quest = (Quest) o;
        return id == quest.id &&
                complete == quest.complete &&
                Objects.equals(name, quest.name) &&
                Objects.equals(description, quest.description) &&
                Objects.equals(createdDate, quest.createdDate) &&
                Objects.equals(lastModifiedDate, quest.lastModifiedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, complete, createdDate, lastModifiedDate);
    }
}
