package com.techgiants.hmsabes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RoomDetailsAdapter extends RecyclerView.Adapter<RoomDetailsAdapter.ViewHolder> {
    Context context;
    ArrayList<RoomnumberStracture> arrrooms;

    RoomDetailsAdapter(Context context, ArrayList<RoomnumberStracture> arrrooms) {
        this.context = context;
        this.arrrooms = arrrooms;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.roomnumbers, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtName.setText(arrrooms.get(position).getname());
    }

    @Override
    public int getItemCount() {
        return arrrooms.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName;
        LinearLayout ll;

        public ViewHolder(View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.allotmentroomdetailttftxt);
            ll = itemView.findViewById(R.id.contactrowlayout);
        }
    }
}
