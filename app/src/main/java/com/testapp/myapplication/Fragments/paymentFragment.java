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

import java.text.DecimalFormat;

public class paymentFragment extends Fragment implements View.OnClickListener {
    private CustomEditText odHR, etHR, prHR;
    private Button submit, clear;
    private TextView paymentResultTV;

    public paymentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_payment, container, false);
        initialization(view);
        onClick();
        return view;
    }

    private void initialization(View view) {
        odHR = view.findViewById(R.id.ordinaryHourET);
        etHR = view.findViewById(R.id.extraHourET);
        prHR = view.findViewById(R.id.payRateHourET);
        submit = view.findViewById(R.id.paymentCalcBTN);
        clear = view.findViewById(R.id.payClearBTN);
        paymentResultTV = view.findViewById(R.id.totalPaymentResultTV);
    }

    private void onClick() {
        submit.setOnClickListener(this);
        clear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.paymentCalcBTN) {
            if (odHR.getText().toString().trim().isEmpty() || etHR.getText().toString().trim().isEmpty() || prHR.getText().toString().trim().isEmpty()) {
                Toast.makeText(getContext(), "Please fill up all fields", Toast.LENGTH_SHORT).show();
            } else {
                double ordinaryPay = Float.parseFloat(odHR.getText().toString()) * Float.parseFloat(prHR.getText().toString());
                double extraPay = Float.parseFloat(prHR.getText().toString()) * Float.parseFloat(etHR.getText().toString()) * 1.5;
                double totalPay = ordinaryPay + extraPay;
                DecimalFormat df = new DecimalFormat("0.00");
                df.setMaximumFractionDigits(2);
                paymentResultTV.setText(df.format(totalPay));
            }
        } else if (v.getId() == R.id.payClearBTN) {
            paymentResultTV.setText("");
            odHR.setText("");
            etHR.setText("");
            prHR.setText("");
        }
    }
}
