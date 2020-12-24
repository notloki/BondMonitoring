package com.notloki.bondMonitoring;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.NewViewHolder> {



    List <HistoryObj> histories;
    RVAdapter(List<HistoryObj> histories) {
        this.histories = histories;
    }

    @Override
    public int getItemCount() {
        return histories.size();
    }

    @Override
    public NewViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater
                .from(viewGroup
                        .getContext())
                .inflate(R.layout
                        .recycler_view_item,
                        viewGroup,
                        false);
            NewViewHolder nvh = new NewViewHolder(v);
            return nvh;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onBindViewHolder(@NonNull NewViewHolder holder, int i) {
        holder.historyDate.setText(histories.get(i).getDate());
        holder.text.setText(histories.get(i).getText());
        holder.transKey.setText(histories.get(i).getTransaction_key());

    }

    public static class NewViewHolder extends RecyclerView.ViewHolder {
     CardView cv;
     TextView historyDate;
     TextView text;
     TextView transKey;

     NewViewHolder(View itemView) {
         super(itemView);
         cv = (CardView) itemView.findViewById(R.id.cv);
         historyDate = (TextView) itemView.findViewById(R.id.historyDate);
         text = (TextView) itemView.findViewById(R.id.text);
         transKey = (TextView) itemView.findViewById(R.id.transKey);
     }
 }

}


