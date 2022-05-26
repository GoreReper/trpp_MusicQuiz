package com.example.musicapp.mvvm.views;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.musicapp.R;
import com.example.musicapp.mvvm.viewModels.RoundViewModel;

/**
 * Отвечает за просмотр экранной формы "Результат"
 */

public class ResultsView extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
    }
}
