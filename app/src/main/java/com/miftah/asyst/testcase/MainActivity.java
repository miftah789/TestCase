package com.miftah.asyst.testcase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.miftah.asyst.testcase.utility.Constant;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etTeamA, etTeamB;
    Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTeamA = findViewById(R.id.et_team_a);
        etTeamB = findViewById(R.id.et_team_b);
        btnStart = findViewById(R.id.btn_start);

        btnStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start:
                if (validate()) {
                    Intent intent = new Intent(this, MatchActivity.class);
                    intent.putExtra(Constant.KEY_TEAM_A_NAME, etTeamA.getText().toString());
                    intent.putExtra(Constant.KEY_TEAM_B_NAME, etTeamB.getText().toString());
                    startActivity(intent);
                }
                break;
        }
    }

    public boolean validate() {
        if (TextUtils.isEmpty(etTeamA.getText().toString()) || TextUtils.isEmpty(etTeamB.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Nama Team Harus Diisi", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (etTeamA.getText().toString().equalsIgnoreCase(etTeamB.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Nama Team Tidak Boleh Sama", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
