package com.example.musicapp.mvvm.views;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.musicapp.R;
import com.example.musicapp.mvvm.viewModels.RulesViewModel;

/**
 * Отвечает за просмотр экранной формы "Правила"
 */

public class RulesView extends AppCompatActivity {

    Button startButt;
    Button timeButt10;
    Button timeButt15;
    Button timeButt20;
    RulesViewModel rulesVM;
    SeekBar playerNum;
    TextView playerNumText;
    SeekBar gameDuration;
    TextView gameDurationText;
    int roundTime = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rules);

        startButt =  findViewById(R.id.startButt);

        timeButt10 = findViewById(R.id.timeButt10);
        timeButt15 = findViewById(R.id.timeButt15);
        timeButt20 = findViewById(R.id.timeButt20);

        playerNum = findViewById(R.id.playerNum);
        playerNumText = findViewById(R.id.playerNumText);

        gameDuration = findViewById(R.id.gameDuration);
        gameDurationText = findViewById(R.id.gameDurationText);

        rulesVM = new ViewModelProvider(this).get(RulesViewModel.class);



        playerNum.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String str = (progress + 2) + " Players";
                playerNumText.setText(str);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        gameDuration.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String str = (progress + 4) + " Songs";
                gameDurationText.setText(str);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        timeButt10.setOnClickListener(view -> {
            roundTime = 10;
            timeButt10.setBackgroundResource(R.drawable.actrule);
            timeButt15.setBackgroundResource(R.drawable.actrulenon);
            timeButt20.setBackgroundResource(R.drawable.actrulenon);
        });
        timeButt15.setOnClickListener(view -> {
            roundTime = 15;
            timeButt10.setBackgroundResource(R.drawable.actrulenon);
            timeButt15.setBackgroundResource(R.drawable.actrule);
            timeButt20.setBackgroundResource(R.drawable.actrulenon);
        });
        timeButt20.setOnClickListener(view -> {
            roundTime = 20;
            timeButt10.setBackgroundResource(R.drawable.actrulenon);
            timeButt15.setBackgroundResource(R.drawable.actrulenon);
            timeButt20.setBackgroundResource(R.drawable.actrule);
        });

        startButt.setOnClickListener(view -> {
            rulesVM.newSession(gameDuration.getProgress(),roundTime-1,playerNum.getProgress());
            startActivity(new Intent(this, RoundView.class));
            finish();
        });


    }
    @Override
    protected void onStop() {
        super.onStop();

    }

}

