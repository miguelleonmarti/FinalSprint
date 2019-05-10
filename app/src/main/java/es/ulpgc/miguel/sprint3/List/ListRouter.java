package es.ulpgc.miguel.sprint3.List;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.miguel.sprint3.Counter.CounterActivity;
import es.ulpgc.miguel.sprint3.app.AppMediator;
import es.ulpgc.miguel.sprint3.app.Counter;

public class ListRouter implements ListContract.Router {

  public static String TAG = ListRouter.class.getSimpleName();

  private AppMediator mediator;

  public ListRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToNextScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, CounterActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToNextScreen(ListState state) {
    mediator.setListState(state);
  }

  @Override
  public ListState getDataFromPreviousScreen() {
    ListState state = mediator.getListState();
    return state;
  }

  @Override
  public void passCounterToNextScreen(Counter item) {
    mediator.setCounter(item);
  }
}
