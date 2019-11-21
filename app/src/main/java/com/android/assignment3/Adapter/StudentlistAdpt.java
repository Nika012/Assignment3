package com.android.assignment3.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.assignment3.R;
import com.android.assignment3.model.DataSet;

import java.util.List;

public class StudentlistAdpt extends RecyclerView.Adapter<StudentlistAdpt.Studentview> {
    Context context;
    List <DataSet> dataSetList;

    public StudentlistAdpt(Context context, List<DataSet> dataSetList) {
        this.context = context;
        this.dataSetList = dataSetList;
    }

    @NonNull
    @Override
    public StudentlistAdpt.Studentview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activitycardview,parent,false);
        return new Studentview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentlistAdpt.Studentview holder, final int position) {
        DataSet dataSet= dataSetList.get(position);
        if(dataSet.getStdgender().equalsIgnoreCase("male")){
            holder.itemView.setId(R.id.rgmale);
        }else{
            holder.itemView.setId(R.id.rgfemale);
        }
        holder.txname.setText(dataSet.getStdname());
        holder.txaddress.setText(dataSet.getStdaddress());
        holder.txage.setText(dataSet.getStdage());
        holder.txgender.setText(dataSet.getStdgender());
        holder.btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dataSetList.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataSetList.size();
    }

    public class Studentview extends RecyclerView.ViewHolder {
        ImageView imgcard;
        TextView txname,txaddress,txage,txgender;
        Button btndel;
        public Studentview(@NonNull View itemView) {
            super(itemView);
            imgcard= itemView.findViewById(R.id.cv);
            txname= itemView.findViewById(R.id.tvname);
            txaddress= itemView.findViewById(R.id.tvaddresss);
            txage= itemView.findViewById(R.id.tvage);
            btndel= itemView.findViewById(R.id.btndele);
            txgender=itemView.findViewById(R.id.tvgender);
        }
    }
}
