package com.example.musicapp.mvvm.views;

import android.content.Intent;
import android.os.Bundle;

import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.musicapp.R;
import com.example.musicapp.mvvm.repository.SongRepository;
/**
 * Отвечает за просмотр экранной формы "Темы"
 */

public class ThemesView extends AppCompatActivity {
    LinearLayout theme1;
    LinearLayout theme2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.themes);
        theme1 = findViewById(R.id.theme1);
        theme2 = findViewById(R.id.theme2);
        theme1.setOnClickListener(view -> {
            SongRepository.Themes1();
            startActivity(new Intent(this, RulesView.class));
        });
        theme2.setOnClickListener(view -> {
            SongRepository.Themes2();
            startActivity(new Intent(this, RulesView.class));
        });
    }
    @Override
    protected void onStop() {
        super.onStop();
        finish();

    }
}
