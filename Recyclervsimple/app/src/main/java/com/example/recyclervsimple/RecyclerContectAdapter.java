package com.example.recyclervsimple;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerContectAdapter extends RecyclerView.Adapter<RecyclerContectAdapter.ViewHolder>{

    Context context;
    ArrayList<ContectModel> arrContects;

    public RecyclerContectAdapter(Context context,ArrayList<ContectModel> arrContects){
        this.context = context;
        this.arrContects = arrContects;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.contect_row,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.txt_name.setText(arrContects.get(position).name);
        holder.txt_number.setText(arrContects.get(position).number);
        holder.img_contect.setImageResource(arrContects.get(position).img);

    }

    @Override
    public int getItemCount() {
        return arrContects.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_name,txt_number;
        ImageView img_contect;

        public ViewHolder( View itemView) {
            super(itemView);
            txt_name = itemView.findViewById(R.id.txt_name);
            txt_number = itemView.findViewById(R.id.txt_number);
            img_contect = itemView.findViewById(R.id.img_contect);
        }
    }
}