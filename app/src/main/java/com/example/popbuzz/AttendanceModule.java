package com.example.popbuzz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class AttendanceModule extends AppCompatActivity {

    FloatingActionButton fab;
    RecyclerView recyclerView;
    ClassAdapter classAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<ClassItem> classItems = new ArrayList<>();

    EditText name_edt,id_edt,class_edt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_module);

        fab = findViewById(R.id.fab_add);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        classAdapter = new ClassAdapter(this,classItems);
        recyclerView.setAdapter(classAdapter);

    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(R.layout.class_dialog, null);
        builder.setView(view);
        AlertDialog dialog = builder.create();
        dialog.show();

        name_edt = view.findViewById(R.id.student_name);
        id_edt = view.findViewById(R.id.student_id);
        class_edt = view.findViewById(R.id.student_class);

        Button cancel = view.findViewById(R.id.cancel_btn);
        Button add = view.findViewById(R.id.add_btn);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addClass();
                dialog.dismiss();
            }
        });


    }

    private void addClass() {
        String stdName = name_edt.getText().toString();
        String stdId = id_edt.getText().toString();
        String stdClass = class_edt.getText().toString();
        classItems.add(new ClassItem(stdName,stdId,stdClass));
        classAdapter.notifyDataSetChanged();

    }

}