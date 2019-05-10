package es.ulpgc.miguel.sprint3.List;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import es.ulpgc.miguel.sprint3.R;
import es.ulpgc.miguel.sprint3.app.Counter;

public class ListActivity
    extends AppCompatActivity implements ListContract.View {

  public static String TAG = ListActivity.class.getSimpleName();

  private ListContract.Presenter presenter;

  private Button plusButton;
  private ListAdapter listAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_list);
    this.setTitle(R.string.master_label);

    plusButton = findViewById(R.id.plusButton);

    plusButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.plus();
      }
    });

    listAdapter = new ListAdapter(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Counter placeItem = (Counter) view.getTag();
        presenter.selectCounterListData(placeItem);
      }
    });

    RecyclerView recyclerView = findViewById(R.id.list);
    recyclerView.setAdapter(listAdapter);
    recyclerView.setLayoutManager(new GridLayoutManager(this, 1));

    // do the setup
    ListScreen.configure(this);
  }

  @Override
  protected void onResume() {
    super.onResume();

    // do some work
    presenter.fetchData();
  }

  @Override
  public void injectPresenter(ListContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(ListViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data
    listAdapter.setItems(viewModel.counterList);
  }


}
