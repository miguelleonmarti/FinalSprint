package es.ulpgc.miguel.sprint3.Counter;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.miguel.sprint3.app.AppMediator;
import es.ulpgc.miguel.sprint3.app.Repository;
import es.ulpgc.miguel.sprint3.app.RepositoryContract;

public class CounterScreen {

  public static void configure(CounterContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    CounterState state = mediator.getCounterState();

    RepositoryContract repositoryContract = Repository.getInstance(context.get());

    CounterContract.Router router = new CounterRouter(mediator);
    CounterContract.Presenter presenter = new CounterPresenter(state);
    CounterContract.Model model = new CounterModel(repositoryContract);
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
