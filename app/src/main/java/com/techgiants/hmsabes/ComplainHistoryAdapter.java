package com.techgiants.hmsabes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ComplainHistoryAdapter extends RecyclerView.Adapter<ComplainHistoryAdapter.ViewHolder> {
    Context context;
    ArrayList<ComplainHistoryStracture> arrcomplains;

    public ComplainHistoryAdapter(Context context, ArrayList<ComplainHistoryStracture> arrcomplains) {
        this.context = context;
        this.arrcomplains = arrcomplains;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.complainslayout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ComplainHistoryStracture complain = arrcomplains.get(position);
        holder.txtdate.setText(complain.getdate());
        holder.txtsectin.setText(complain.getsection());
    }

    @Override
    public int getItemCount() {
        return arrcomplains.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtdate;
        TextView txtsectin;

        public ViewHolder(View itemView) {
            super(itemView);
            txtdate = itemView.findViewById(R.id.complainhistorydate);
            txtsectin = itemView.findViewById(R.id.complainhistorysection);
        }
    }
}
