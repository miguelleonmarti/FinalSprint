package es.ulpgc.miguel.sprint3.Counter;

import android.content.Intent;
import android.content.Context;

import es.ulpgc.miguel.sprint3.app.AppMediator;
import es.ulpgc.miguel.sprint3.app.Counter;

public class CounterRouter implements CounterContract.Router {

  public static String TAG = CounterRouter.class.getSimpleName();

  private AppMediator mediator;

  public CounterRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToNextScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, CounterActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToNextScreen(CounterState state) {
    mediator.setCounterState(state);
  }

  @Override
  public CounterState getDataFromPreviousScreen() {
    CounterState state = mediator.getCounterState();
    return state;
  }

  @Override
  public Counter getCounterFromPreviousScreen() {
    return mediator.getCounter();
  }
}
