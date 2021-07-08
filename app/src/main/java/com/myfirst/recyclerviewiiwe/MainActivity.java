package com.myfirst.recyclerviewiiwe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemClickListener {

    private RecyclerView mRecyclerView;
    private ArrayList<StudentModel> studentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        buildList();
        setRecyclerView();
    }

    private void setRecyclerView() {
        StudentAdapter studentAdapter = new StudentAdapter(studentList,this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(studentAdapter);
    }

    private void buildList() {
        for(int i=0;i<100;i++){
            StudentModel studentModel = new StudentModel("Yash Bansal",22,
                    "Saharanpur","13/05/1999",R.drawable.dante);
            studentList.add(studentModel);
        }
    }

    private void initViews() {
        mRecyclerView = findViewById(R.id.recyclerView);
    }

    @Override
    public void onItemClicked(StudentModel model, int position) {
        new AlertDialog.Builder(this)
                .setTitle("Student Details")
                .setMessage(model.getName() + "\n" +
                        model.getAge() + "\n" +
                        model.getAddress() + "\n" +
                        model.getDOB() + "\n" +
                        position)
                .show();
    }
}