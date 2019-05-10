package es.ulpgc.miguel.sprint3.app;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class Repository implements RepositoryContract {

  public static Repository INSTANCE;
  private Context context;

  private List<Counter> counterList = new ArrayList<>();

  private int i = 0;
  private int clicks = 0;

  public static RepositoryContract getInstance(Context context) {
    if (INSTANCE == null) {
      INSTANCE = new Repository(context);
    }
    return INSTANCE;
  }

  private Repository(Context context) {
    this.context = context;
  }

  public List<Counter> getCounterList() {
    return counterList;
  }

  public void setCounterList(List<Counter> counterList) {
    this.counterList = counterList;
  }

  @Override
  public void add() {
    counterList.add(new Counter(i, 0));
    i++;
  }

  @Override
  public void plus(int id) {
    getCounterList().get(id).setCounter(counterList.get(id).getCounter() + 1);
    clicks++;
  }

  @Override
  public List<Counter> list() {
    return getCounterList();
  }

  @Override
  public int clicks() {
    return getClicks();
  }

  public int getClicks() {
    return clicks;
  }

  public void setClicks(int clicks) {
    this.clicks = clicks;
  }
}
