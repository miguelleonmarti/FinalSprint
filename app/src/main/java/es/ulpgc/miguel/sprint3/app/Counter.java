package es.ulpgc.miguel.sprint3.app;

public class Counter {
  private int id, counter;

  public Counter(int id, int counter) {
    this.id = id;
    this.counter = counter;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getCounter() {
    return counter;
  }

  public void setCounter(int counter) {
    this.counter = counter;
  }
}
