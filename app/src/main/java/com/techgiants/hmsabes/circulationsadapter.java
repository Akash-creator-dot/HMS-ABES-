package com.techgiants.hmsabes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class circulationsadapter extends RecyclerView.Adapter<circulationsadapter.NoticeViewAdapter> {
    private Context context;
    private ArrayList<circulationsclass> list;

    circulationsadapter(Context context, ArrayList<circulationsclass> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public NoticeViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.circular_view, parent, false);
        return new NoticeViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoticeViewAdapter holder, int position) {
        circulationsclass currentitem = list.get(position);
        holder.title.setText(currentitem.getTitle());
        holder.date.setText(currentitem.getDate());
        holder.time.setText(currentitem.getTime());
        try {
            if (currentitem.getImg() != null) {
                Glide.with(context).load(currentitem.getImg()).into(holder.noticeimage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class NoticeViewAdapter extends RecyclerView.ViewHolder {
        private TextView title, date, time;
        private ImageView noticeimage;

        public NoticeViewAdapter(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.noticetitle);
            date = itemView.findViewById(R.id.datechange);
            time = itemView.findViewById(R.id.timechange);
            noticeimage = itemView.findViewById(R.id.noticeimage);
        }
    }
}
