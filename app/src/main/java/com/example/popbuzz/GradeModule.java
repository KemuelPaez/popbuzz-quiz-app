package com.example.popbuzz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GradeModule extends AppCompatActivity {

    TextView tv_engage, tv_elab, tv_explore, tv_eval, tv_explain, tv_res;
    EditText edt_engage, edt_elab, edt_explore, edt_eval, edt_explain;
    Button btn_compute, btn_reset;
    float final_grade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade_module);

        tv_engage = findViewById(R.id.tv_engage);
        tv_elab = findViewById(R.id.tv_elaborate);
        tv_explore = findViewById(R.id.tv_explore);
        tv_eval = findViewById(R.id.tv_evaluate);
        tv_explain = findViewById(R.id.tv_explain);
        tv_res = findViewById(R.id.tv_result);

        edt_engage = (EditText) findViewById(R.id.et_engage);
        edt_elab = (EditText) findViewById(R.id.et_elaborate);
        edt_explore = (EditText) findViewById(R.id.et_explore);
        edt_eval = (EditText) findViewById(R.id.et_evaluate);
        edt_explain = (EditText) findViewById(R.id.et_explain);

        btn_compute = findViewById(R.id.btn_compute);
        btn_reset = findViewById(R.id.btn_reset);

        btn_compute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                float engage = ((Float.parseFloat(edt_engage.getText().toString())) / 100) * 10;
                float elaborate = ((Float.parseFloat(edt_elab.getText().toString())) /100) * 10;
                float explore = ((Float.parseFloat(edt_explore.getText().toString())) / 100) * 20;
                float evaluate = ((Float.parseFloat(edt_eval.getText().toString())) / 100) * 40;
                float explain = ((Float.parseFloat(edt_explain.getText().toString())) / 100) * 20;

                final_grade = engage + elaborate + explore + evaluate + explain;

                String final_score = String.valueOf(final_grade);

                tv_res.setText("Final Grades = "+final_score);

            }
        });

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt_engage.setText("");
                edt_elab.setText("");
                edt_explore.setText("");
                edt_eval.setText("");
                edt_explain.setText("");
                tv_res.setText("FINAL GRADES");
            }
        });

    }
}