package es.ulpgc.miguel.sprint3.List;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.miguel.sprint3.app.Counter;

interface ListContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(ListViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();

    void selectCounterListData(Counter item);

    void plus();

    void refreshUI();
  }

  interface Model {
    List<Counter> fetchData();

    void add();
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(ListState state);

    void passCounterToNextScreen(Counter item);

    ListState getDataFromPreviousScreen();
  }
}
