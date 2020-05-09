package com.testapp.myapplication.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.libizo.CustomEditText;
import com.testapp.myapplication.R;

public class triangleFragment extends Fragment implements View.OnClickListener {
    private CustomEditText firstET, secondET, thirdET;
    private Button submit, clear;
    private TextView triangleResultTV;

    public triangleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_triangle, container, false);
        initialization(view);
        onClick();
        return view;
    }

    private void initialization(View view) {
        firstET = view.findViewById(R.id.firstInputET);
        secondET = view.findViewById(R.id.secondInputET);
        thirdET = view.findViewById(R.id.thirdInputET);
        submit = view.findViewById(R.id.triangleCalcBTN);
        clear = view.findViewById(R.id.triangleClearBTN);
        triangleResultTV = view.findViewById(R.id.triangleTypeResultTV);
    }

    private void onClick() {
        submit.setOnClickListener(this);
        clear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.triangleCalcBTN) {
            if (firstET.getText().toString().trim().isEmpty() || secondET.getText().toString().trim().isEmpty() || thirdET.getText().toString().trim().isEmpty()) {
                Toast.makeText(getContext(), "Please fill up all fields", Toast.LENGTH_SHORT).show();
            } else {
                int valid = 0;
                double a = Double.parseDouble(firstET.getText().toString().trim());
                double b = Double.parseDouble(secondET.getText().toString().trim());
                double c = Double.parseDouble(thirdET.getText().toString().trim());

                if ((a + b) > c) {
                    if ((b + c) > a) {
                        if ((a + c) > b) {
                            valid = 1;
                        }
                    }
                }
                if (valid == 1) {
                    if ((a == b) && (b == c)) {
                        triangleResultTV.setText("Triangle is Equilateral");
                    } else if ((a == b) || (a == c) || (b == c)) {
                        triangleResultTV.setText("Triangle is Isosceles");
                    } else {
                        triangleResultTV.setText("Triangle is Scalene");
                    }
                } else {
                    triangleResultTV.setText("Triangle is Invalid");
                }
            }
        } else if (v.getId() == R.id.triangleClearBTN) {
            triangleResultTV.setText("");
            firstET.setText("");
            secondET.setText("");
            thirdET.setText("");
        }
    }
}
