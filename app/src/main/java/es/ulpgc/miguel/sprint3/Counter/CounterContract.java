package es.ulpgc.miguel.sprint3.Counter;

import java.lang.ref.WeakReference;

import es.ulpgc.miguel.sprint3.app.Counter;

interface CounterContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(CounterViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();

    void suma();
  }

  interface Model {
    int fetchData();

    int getClicks();

    void suma(int id);
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(CounterState state);

    CounterState getDataFromPreviousScreen();

    Counter getCounterFromPreviousScreen();
  }
}
