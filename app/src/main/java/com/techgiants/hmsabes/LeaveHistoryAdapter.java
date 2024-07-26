package com.techgiants.hmsabes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LeaveHistoryAdapter extends RecyclerView.Adapter<LeaveHistoryAdapter.ViewHolder> {
    Context context;
    ArrayList<LeaveHistoryStructure> arrleaves;

    LeaveHistoryAdapter(Context context, ArrayList<LeaveHistoryStructure> arrleaves) {
        this.context = context;
        this.arrleaves = arrleaves;
    }

    @NonNull
    @Override
    public LeaveHistoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.leaveslayout, parent, false);
        return new LeaveHistoryAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeaveHistoryAdapter.ViewHolder holder, int position) {
        holder.txtdate.setText(arrleaves.get(position).getdate());
        holder.txttime.setText(arrleaves.get(position).gettime());
    }

    @Override
    public int getItemCount() {
        return arrleaves.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtdate;
        TextView txttime;
        LinearLayout ll;

        public ViewHolder(View itemView) {
            super(itemView);
            txtdate = itemView.findViewById(R.id.leavehistorydate);
            txttime=itemView.findViewById(R.id.leavehistorytime);
            ll = itemView.findViewById(R.id.leavehistoryll);
        }
}

}
