package es.ulpgc.miguel.sprint3.Counter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import es.ulpgc.miguel.sprint3.R;

public class CounterActivity
    extends AppCompatActivity implements CounterContract.View {

  public static String TAG = CounterActivity.class.getSimpleName();

  private CounterContract.Presenter presenter;

  private Button plusButton;
  private TextView counterText, clicksText;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_counter);

    plusButton = findViewById(R.id.plusButton);
    counterText = findViewById(R.id.counterText);
    clicksText = findViewById(R.id.clicksText);

    plusButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.suma();
      }
    });

    // do the setup
    CounterScreen.configure(this);
  }

  @Override
  protected void onResume() {
    super.onResume();

    // do some work
    presenter.fetchData();
  }

  @Override
  public void injectPresenter(CounterContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(CounterViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data
    ((TextView) findViewById(R.id.counterText)).setText(String.valueOf(viewModel.counter));
    ((TextView) findViewById(R.id.clicksText)).setText(String.valueOf(viewModel.clicks));
  }
}
