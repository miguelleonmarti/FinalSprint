package es.ulpgc.miguel.sprint3.app;

import android.app.Application;

import es.ulpgc.miguel.sprint3.Counter.CounterState;
import es.ulpgc.miguel.sprint3.List.ListState;

public class AppMediator extends Application {

  private ListState listState;
  private CounterState counterState;

  private Counter counter;

  public AppMediator() {
    listState = new ListState();
    counterState = new CounterState();
  }

  public ListState getListState() {
    return listState;
  }

  public void setListState(ListState listState) {
    this.listState = listState;
  }

  public CounterState getCounterState() {
    return counterState;
  }

  public void setCounterState(CounterState counterState) {
    this.counterState = counterState;
  }

  public Counter getCounter() {
    return counter;
  }

  public void setCounter(Counter counter) {
    this.counter = counter;
  }
}
