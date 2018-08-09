package com.miftah.asyst.testcase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.miftah.asyst.testcase.utility.Constant;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnBack;
    TextView tvWinner, tvScore;
    String nameWinner;
    int scoreWinner = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(this);
        tvWinner = findViewById(R.id.tv_winner_team);
        tvScore = findViewById(R.id.tv_winner_score);

        if (getIntent().getExtras() != null) {
            nameWinner = getIntent().getExtras().getString(Constant.KEY_WINNER_TEAM);
            scoreWinner = getIntent().getExtras().getInt(Constant.KEY_WINNER_SCORE);
        }
        tvWinner.setText(nameWinner);
        tvScore.setText(scoreWinner + "");

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back:
                Intent intent = new Intent(this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;
        }
    }
}
