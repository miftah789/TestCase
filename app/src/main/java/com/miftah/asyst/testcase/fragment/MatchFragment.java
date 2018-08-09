package com.miftah.asyst.testcase.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.miftah.asyst.testcase.R;
import com.miftah.asyst.testcase.utility.Constant;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MatchFragment.OnButtonNextClickedListener} interface
 * to handle interaction events.
 * Use the {@link MatchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MatchFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";

    Button btnPlusOneTeamA, btnPlusTwoTeamA, btnPlusThreeTeamA;
    Button btnPlusOneTeamB, btnPlusTwoTeamB, btnPlusThreeTeamB;
    Button btnNext;
    TextView tvQuarter, tvTeamA, tvTeamB, tvScoreA, tvScoreB;
    // TODO: Rename and change types of parameters
    private String teamAName;
    private String teamBName;
    private int quarter;
    private int scoreTeamA;
    private int scoreTeamB;
    private OnButtonNextClickedListener mListener;

    public MatchFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static MatchFragment newInstance(String teamA, String teamB, int quarter, int scoreTeamA, int scoreTeamB) {
        MatchFragment fragment = new MatchFragment();
        Bundle args = new Bundle();
        args.putString(Constant.KEY_TEAM_A_NAME, teamA);
        args.putString(Constant.KEY_TEAM_B_NAME, teamB);
        args.putInt(Constant.KEY_QUARTER, quarter);
        args.putInt(Constant.KEY_SCORE_TEAM_A, scoreTeamA);
        args.putInt(Constant.KEY_SCORE_TEAM_B, scoreTeamB);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            teamAName = getArguments().getString(Constant.KEY_TEAM_A_NAME);
            teamBName = getArguments().getString(Constant.KEY_TEAM_B_NAME);
            quarter = getArguments().getInt(Constant.KEY_QUARTER);
            scoreTeamA = getArguments().getInt(Constant.KEY_SCORE_TEAM_A);
            scoreTeamB = getArguments().getInt(Constant.KEY_SCORE_TEAM_B);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_match, container, false);

        btnNext = view.findViewById(R.id.btn_next);
        btnNext.setOnClickListener(this);

        btnPlusOneTeamA = view.findViewById(R.id.btn_teama_plus_one);
        btnPlusTwoTeamA = view.findViewById(R.id.btn_teama_plus_two);
        btnPlusThreeTeamA = view.findViewById(R.id.btn_teama_plus_three);

        btnPlusOneTeamA.setOnClickListener(this);
        btnPlusTwoTeamA.setOnClickListener(this);
        btnPlusThreeTeamA.setOnClickListener(this);

        btnPlusOneTeamB = view.findViewById(R.id.btn_teamb_plus_one);
        btnPlusTwoTeamB = view.findViewById(R.id.btn_teamb_plus_two);
        btnPlusThreeTeamB = view.findViewById(R.id.btn_teamb_plus_three);

        btnPlusOneTeamB.setOnClickListener(this);
        btnPlusTwoTeamB.setOnClickListener(this);
        btnPlusThreeTeamB.setOnClickListener(this);

        tvQuarter = view.findViewById(R.id.tv_quarter);
        tvTeamA = view.findViewById(R.id.tv_teama);
        tvTeamB = view.findViewById(R.id.tv_teamb);
        tvScoreA = view.findViewById(R.id.tv_teama_score);
        tvScoreB = view.findViewById(R.id.tv_teamb_score);

        switch (quarter) {
            case 1:
                tvQuarter.setText("1st");
                break;
            case 2:
                tvQuarter.setText("2nd");
                break;
            case 3:
                tvQuarter.setText("3th");
                break;
            case 4:
                tvQuarter.setText("4th");
                break;
        }

        tvTeamA.setText(teamAName);
        tvTeamB.setText(teamBName);

        tvScoreA.setText(scoreTeamA + "");
        tvScoreB.setText(scoreTeamB + "");

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.OnButtonNextClickedListener(0,0);
//        }
//    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnButtonNextClickedListener) {
            mListener = (OnButtonNextClickedListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnButtonNextClickedListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_teama_plus_one:
                scoreTeamA += 1;
                break;
            case R.id.btn_teama_plus_two:
                scoreTeamA += 2;
                break;
            case R.id.btn_teama_plus_three:
                scoreTeamA += 3;
                break;
            case R.id.btn_teamb_plus_one:
                scoreTeamB += 1;
                break;
            case R.id.btn_teamb_plus_two:
                scoreTeamB += 2;
                break;
            case R.id.btn_teamb_plus_three:
                scoreTeamB += 3;
                break;
            case R.id.btn_next:
                mListener.OnButtonNextClickedListener(scoreTeamA, scoreTeamB);
                getActivity().getSupportFragmentManager().popBackStack();

                break;
        }
        tvScoreA.setText(scoreTeamA + "");
        tvScoreB.setText(scoreTeamB + "");
    }

    public interface OnButtonNextClickedListener {
        // TODO: Update argument type and name
        void OnButtonNextClickedListener(int scoreTeamA, int scoreTeamB);
    }
}
