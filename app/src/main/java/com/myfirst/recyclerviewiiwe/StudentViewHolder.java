package com.myfirst.recyclerviewiiwe;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentViewHolder extends RecyclerView.ViewHolder {

    private ImageView mTvStudentImage;
    private TextView mTvName;
    private TextView mTvAge;
    private TextView mTvDOB;
    private TextView mTvAddress;
    private RelativeLayout mRelativeLayout;
    private ItemClickListener itemClickListener;

    public StudentViewHolder(@NonNull View itemView,ItemClickListener itemClickListener) {
        super(itemView);
        this.itemClickListener = itemClickListener;
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mTvStudentImage = itemView.findViewById(R.id.ivStudentImage);
        mTvName = itemView.findViewById(R.id.tvName);
        mTvAge = itemView.findViewById(R.id.tvAge);
        mTvDOB = itemView.findViewById(R.id.tvDOB);
        mTvAddress = itemView.findViewById(R.id.tvAddress);
        mRelativeLayout = itemView.findViewById(R.id.relativeLayout);
    }

    public void setData(StudentModel studentModel){
        mTvStudentImage.setImageResource(studentModel.getImageId());
        mTvName.setText(studentModel.getName());
        mTvAge.setText(studentModel.getAge() + "");
        mTvDOB.setText(studentModel.getDOB());
        mTvAddress.setText(studentModel.getAddress());
        mRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClicked(studentModel,getAdapterPosition());
            }
        });
    }

}
