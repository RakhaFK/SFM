package com.example.sfa;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListHistWardahFragment extends Fragment {

    private int mScore1;
    public EditText mScoreText1;
    static final String STATE_SCORE_1 = "Team 1 Score";

    @NonNull
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_list_hist_wardah, container, false);
        mScoreText1 = (EditText)view.findViewById(R.id.stockwardah);

        if (savedInstanceState != null) {
            mScore1 = savedInstanceState.getInt(STATE_SCORE_1);
        }

        mScoreText1.setText(String.valueOf(mScore1));
        return view;
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(STATE_SCORE_1, mScore1);
        super.onSaveInstanceState(outState);
    }

}
