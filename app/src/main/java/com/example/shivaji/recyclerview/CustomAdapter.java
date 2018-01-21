package com.example.shivaji.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by shivaji on 21/1/18.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.NumViewHolder> {
    Context context;
    List<Data> numList;

    public CustomAdapter(Context context, List<Data> numList) {
        this.context = context;
        this.numList = numList;
    }

    @Override
    public NumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        NumViewHolder viewHolder = new NumViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NumViewHolder holder, int position) {
        Data data = numList.get(position);
        holder.nameTextView.setText(data.getName());
        holder.bodyTextView.setText(data.getBody());
    }

    @Override
    public int getItemCount() {
        return numList.size();
    }

    class NumViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView bodyTextView;

        public NumViewHolder(View itemView) {
            super(itemView);
            nameTextView = (TextView)itemView.findViewById(R.id.name_text_view);
            bodyTextView = (TextView)itemView.findViewById(R.id.body_text_view);
        }
    }
}
