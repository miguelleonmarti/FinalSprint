package es.ulpgc.miguel.sprint3.List;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.miguel.sprint3.app.AppMediator;
import es.ulpgc.miguel.sprint3.app.Repository;
import es.ulpgc.miguel.sprint3.app.RepositoryContract;

public class ListScreen {

  public static void configure(ListContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    ListState state = mediator.getListState();
    RepositoryContract repositoryContract = Repository.getInstance(context.get());

    ListContract.Router router = new ListRouter(mediator);
    ListContract.Presenter presenter = new ListPresenter(state);
    ListContract.Model model = new ListModel(repositoryContract);
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
