package es.ulpgc.miguel.sprint3.List;

import java.lang.ref.WeakReference;

import es.ulpgc.miguel.sprint3.app.Counter;

public class ListPresenter implements ListContract.Presenter {

  public static String TAG = ListPresenter.class.getSimpleName();

  private WeakReference<ListContract.View> view;
  private ListViewModel viewModel;
  private ListContract.Model model;
  private ListContract.Router router;

  public ListPresenter(ListState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<ListContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(ListContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(ListContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchData()");

    // set passed state
    viewModel.counterList = model.fetchData();
    ListState state = router.getDataFromPreviousScreen();
    state.counterList = viewModel.counterList;
    router.passDataToNextScreen(state);
    view.get().displayData(viewModel);

  }

  @Override
  public void refreshUI() {
    ListState state = router.getDataFromPreviousScreen();
    if (state.counterList != null) {
      viewModel.counterList = state.counterList;
      view.get().displayData(viewModel);
    } else {
      fetchData();
    }
  }

  @Override
  public void selectCounterListData(Counter item) {
    router.passCounterToNextScreen(item);
    router.navigateToNextScreen();
  }

  @Override
  public void plus() {
    model.add();
    fetchData();
  }
}
