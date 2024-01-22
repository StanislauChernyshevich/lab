package photo.bean;

import java.io.Serializable;
import java.util.*;

/*
* customer photo order
* */
public class CustomerOrder implements Serializable {
  private String name;
  private String dateOf;
  private String number;
  private String format;
  private String cost;
  private boolean done = false;

  public CustomerOrder() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDateOf() {
    return dateOf;
  }

  public void setDateOf(String dateOf) {
    this.dateOf = dateOf;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getFormat() {
    return format;
  }

  public void setFormat(String format) {
    this.format = format;
  }

  public String getCost() {
    return cost;
  }

  public void setCost(String cost) {
    this.cost = cost;
  }

  public boolean isDone() {
    return done;
  }

  public void setDone(boolean done) {
    this.done = done;
  }
}
