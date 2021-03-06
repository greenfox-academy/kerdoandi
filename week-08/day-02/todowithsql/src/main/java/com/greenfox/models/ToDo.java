package com.greenfox.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Getter
@Setter
public class ToDo {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  long id;
  String title;
  @Column(nullable = false)
  boolean isUrgent;
  @Column(nullable = false)
  boolean isDone;

  public ToDo() {
  }

  public ToDo(String title) {
    this.title = title;
  }


  @Override
  public String toString() {
    return id + " " + title + " " + isUrgent + " " + isDone;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public boolean isUrgent() {
    return isUrgent;
  }

  public void setUrgent(boolean urgent) {
    isUrgent = urgent;
  }

  public boolean isDone() {
    return isDone;
  }

  public void setDone(boolean done) {
    isDone = done;
  }
}
