package com.example.sfa;


import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDialogFragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
import java.util.ResourceBundle;


/**
 * A simple {@link Fragment} subclass.
 */
public class HistoricalFragment extends Fragment {

    EditText dateOfBirthET;
    EditText endDateET;
    String selectedDate;
    String selectedEndDate;
    public static final int REQUEST_CODE_1 = 11;
    public static final int REQUEST_CODE_2 = 22;

    private OnFragmentInteractionListener mListener;

    public HistoricalFragment() {}

    public static HistoricalFragment newInstance() {
        HistoricalFragment fragment = new HistoricalFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //    @NonNull
    // @Override
//    public Dialog onCreateDialog(Bundle savedInstanceState){

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode ==REQUEST_CODE_1 && resultCode == Activity.RESULT_OK) {
            selectedDate = data.getStringExtra("selectedDate");
            dateOfBirthET.setText(selectedDate);
        }
        if(requestCode ==REQUEST_CODE_2 && resultCode == Activity.RESULT_OK) {
            selectedEndDate = data.getStringExtra("selectedEndDate");
            endDateET.setText(selectedEndDate);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_historical, container,  false);
        dateOfBirthET = view.findViewById(R.id.tv);
        endDateET = view.findViewById(R.id.tv2);

        final FragmentManager fm = ((AppCompatActivity)getActivity()).getSupportFragmentManager();

        dateOfBirthET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatDialogFragment newFragment = new DatePickerFragment();
                newFragment.setTargetFragment(HistoricalFragment.this, REQUEST_CODE_1);
                newFragment.show(fm, "datePicker1");

            }
        });

        endDateET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatDialogFragment newFragment = new DatePickerFragment2();
                newFragment.setTargetFragment(HistoricalFragment.this, REQUEST_CODE_2);
                newFragment.show(fm, "datePicker2");
            }
        });
        return view;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } //else {
        //throw new RuntimeException(context.toString() + "must implement OnFragmentListener");
        // }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener =null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }


}
