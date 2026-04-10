package com.example.recyclerview;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;


public class RecyclerContectAdapter extends RecyclerView.Adapter<RecyclerContectAdapter.ViewHolder>{

Context context;
ArrayList<ContectModel> arrContects;
private int lastPosition = -1;

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
public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

    holder.txt_name.setText(arrContects.get(position).name);
    holder.txt_number.setText(arrContects.get(position).number);
    holder.img_contect.setImageResource(arrContects.get(position).img);
    holder.llrow.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Dialog dialog =new Dialog(context);
            dialog.setContentView(R.layout.add_update_lay);

            EditText edtname = dialog.findViewById(R.id.edtname);
            EditText edtnumber = dialog.findViewById(R.id.edtnumber);
            Button btnaction = dialog.findViewById(R.id.btnaction);
            TextView txttitle = dialog.findViewById(R.id.txttitle);

            txttitle.setText("Update Contect");
            btnaction.setText("Update");
            edtname.setText(arrContects.get(position).name);
            edtnumber.setText(arrContects.get(position).number);

            btnaction.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String name = "", number = "";
                    if (!edtname.getText().toString().equals("") | !edtnumber.getText().toString().equals("")) {
                        name = edtname.getText().toString();
                        number = edtnumber.getText().toString();
                    }else {
                        Toast.makeText(context, "Please Enter both contect Name and Number", Toast.LENGTH_LONG).show();
                    }

                    arrContects.set(position,new ContectModel(arrContects.get(position).img,name,number));
                    notifyItemChanged(position);
                    dialog.dismiss();
                }
            });

            dialog.show();
        }
    });

    holder.llrow.setOnLongClickListener(new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View view) {

            AlertDialog.Builder builder = new AlertDialog.Builder(context)
                    .setTitle("Delete Contect")
                    .setMessage("Are you sure! You want to delete this contect.")
                    .setIcon(R.drawable.baseline_delete_24)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            arrContects.remove(position);
                            notifyItemRemoved(position);
                    }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
            builder.show();

            return true;
        }
    });

setAnimation(holder.itemView,position);

}

@Override
public int getItemCount() {
    return arrContects.size();
}

public class ViewHolder extends RecyclerView.ViewHolder {
    TextView txt_name,txt_number;
    ImageView img_contect;
    LinearLayout llrow;

    public ViewHolder( View itemView) {
        super(itemView);
        txt_name = itemView.findViewById(R.id.txt_name);
        txt_number = itemView.findViewById(R.id.txt_number);
        img_contect = itemView.findViewById(R.id.img_contect);
        llrow = itemView.findViewById(R.id.llrow);
    }
}
private void setAnimation(View viewToAnimate,int position){
    if (position>lastPosition) {
        Animation slideIn = AnimationUtils.loadAnimation(context,R.anim.conntect_view_anim);
        viewToAnimate.startAnimation(slideIn);
        lastPosition = position;

    }
}
    public int lastPosition(){
        return lastPosition;
    }
}