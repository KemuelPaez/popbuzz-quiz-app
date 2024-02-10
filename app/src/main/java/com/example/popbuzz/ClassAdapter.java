package com.example.popbuzz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ClassAdapter extends RecyclerView.Adapter<ClassAdapter.ClassViewHolder> {
    ArrayList<ClassItem> classItems;
    Context context;

    public ClassAdapter(Context context, ArrayList<ClassItem> classItems) {
        this.classItems = classItems;
        this.context = context;
    }

    public static class ClassViewHolder extends RecyclerView.ViewHolder{

        TextView studName, studID, studClass;

        public ClassViewHolder(@NonNull View itemView) {
            super(itemView);

            studName = itemView.findViewById(R.id.name_tv);
            studID = itemView.findViewById(R.id.id_tv);
            studClass = itemView.findViewById(R.id.class_tv);

        }
    }

    @NonNull
    @Override
    public ClassViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.class_item, parent,false);
        return new ClassViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ClassViewHolder holder, int position) {
        holder.studName.setText(classItems.get(position).getStudName());
        holder.studID.setText(classItems.get(position).getStudId());
        holder.studClass.setText(classItems.get(position).getStudClass());

    }

    @Override
    public int getItemCount() {
        return classItems.size();
    }
}
