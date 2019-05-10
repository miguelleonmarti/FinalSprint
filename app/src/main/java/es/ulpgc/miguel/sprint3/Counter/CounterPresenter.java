package es.ulpgc.miguel.sprint3.Counter;

import java.lang.ref.WeakReference;

import es.ulpgc.miguel.sprint3.app.Counter;

public class CounterPresenter implements CounterContract.Presenter {

  public static String TAG = CounterPresenter.class.getSimpleName();

  private WeakReference<CounterContract.View> view;
  private CounterViewModel viewModel;
  private CounterContract.Model model;
  private CounterContract.Router router;

  public CounterPresenter(CounterState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<CounterContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(CounterContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(CounterContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchData()");

    // set passed state
    Counter counter = router.getCounterFromPreviousScreen();
    if (counter != null) {
      viewModel.counter = counter.getCounter();
      viewModel.clicks = model.getClicks();
      view.get().displayData(viewModel);
    }
  }

  @Override
  public void suma() {
    int id = router.getCounterFromPreviousScreen().getId();
    model.suma(id);
    fetchData();
  }
}
