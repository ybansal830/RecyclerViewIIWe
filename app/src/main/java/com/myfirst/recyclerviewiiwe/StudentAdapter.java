package com.myfirst.recyclerviewiiwe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentViewHolder> {

    private ArrayList<StudentModel> studentList;
    private ItemClickListener itemClickListener;

    public StudentAdapter(ArrayList<StudentModel> studentList,
                            ItemClickListener itemClickListener){
        this.studentList = studentList;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new StudentViewHolder(view,itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull StudentViewHolder holder, int position) {
        StudentModel studentModel = studentList.get(position);
        holder.setData(studentModel);
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }
}
