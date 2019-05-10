package es.ulpgc.miguel.sprint3.Counter;

import es.ulpgc.miguel.sprint3.app.RepositoryContract;

public class CounterModel implements CounterContract.Model {

  public static String TAG = CounterModel.class.getSimpleName();

  private RepositoryContract repository;


  public CounterModel(RepositoryContract repository) {
    this.repository = repository;
  }

  @Override
  public int fetchData() {
    // Log.e(TAG, "fetchData()");
    return repository.clicks();
  }

  @Override
  public int getClicks() {
    return repository.clicks();
  }

  @Override
  public void suma(int id) {
    repository.plus(id);
  }
}
