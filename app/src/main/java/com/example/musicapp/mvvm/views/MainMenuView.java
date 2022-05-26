package com.example.musicapp.mvvm.views;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.musicapp.R;
/**
 * Отвечает за просмотр экранной формы "Главное Меню"
 */

public class MainMenuView extends AppCompatActivity {
    Button playButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        playButton = findViewById(R.id.playButton);
        playButton.setOnClickListener(view -> {
            startActivity(new Intent(this, ThemesView.class));
        });
    }
}
