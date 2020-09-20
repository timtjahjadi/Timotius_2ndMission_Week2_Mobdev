package com.example.a2ndmission_week2_mobdev;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.security.PrivateKey;
import java.util.ArrayList;

public class itemAdapter extends RecyclerView.Adapter<itemAdapter.ViewHolder> {
    ArrayList<User> data;
    Context context;
    private OnItemListener _onItemListener;

    public itemAdapter(Context context, ArrayList<User> data, OnItemListener onItemListener) {
        this.data = data;
        this.context = context;
        this._onItemListener = onItemListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name, age, location;
        ImageView image;
        OnItemListener onItemListener;

        public ViewHolder(@NonNull View itemView, OnItemListener onItemListener) {
            super(itemView);

            name = itemView.findViewById(R.id.text_name);
            age = itemView.findViewById(R.id.text_age);
            location = itemView.findViewById(R.id.text_location);
            this.onItemListener = onItemListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onItemListener.onItemClicked(getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_item, parent, false);
        return new ViewHolder(view, _onItemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // bind textview with data received

        User currentItem = data.get(position);
        holder.name.setText(currentItem.get_Name());
        holder.age.setText(String.valueOf(currentItem.get_age()));
        holder.location.setText(currentItem.get_Address());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public interface OnItemListener {
        void onItemClicked(int position);
    }
}
