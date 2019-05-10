package es.ulpgc.miguel.sprint3.List;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.miguel.sprint3.R;
import es.ulpgc.miguel.sprint3.app.Counter;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

  private List<Counter> counterList;
  private final View.OnClickListener clickListener;

  public ListAdapter(View.OnClickListener clickListener) {
    this.counterList = new ArrayList<>();
    this.clickListener = clickListener;
  }

  public void addItem(Counter item) {
    counterList.add(item);
    notifyDataSetChanged();
  }

  public void addItems(List<Counter> items) {
    counterList.addAll(items);
    notifyDataSetChanged();
  }

  public void setItems(List<Counter> items) {
    this.counterList = items;
    notifyDataSetChanged();
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.list_content, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(final ViewHolder holder, int position) {
    holder.itemView.setTag(counterList.get(position));
    holder.itemView.setOnClickListener(clickListener);

    holder.counterText.setText(String.valueOf(counterList.get(position).getCounter()));
  }

  @Override
  public int getItemCount() {
    return counterList.size();
  }

  class ViewHolder extends RecyclerView.ViewHolder {

    final TextView counterText;

    ViewHolder(View view) {
      super(view);
      counterText = view.findViewById(R.id.counterText);
    }
  }
}
