package es.ulpgc.miguel.sprint3.List;

import java.util.List;

import es.ulpgc.miguel.sprint3.app.Counter;
import es.ulpgc.miguel.sprint3.app.RepositoryContract;

public class ListModel implements ListContract.Model {

  public static String TAG = ListModel.class.getSimpleName();

  private RepositoryContract repository;

  public ListModel(RepositoryContract repository) {
    this.repository = repository;
  }

  @Override
  public List<Counter> fetchData() {
    // Log.e(TAG, "fetchData()");
    return repository.list();
  }

  @Override
  public void add() {
    repository.add();
  }
}
