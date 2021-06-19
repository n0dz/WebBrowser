package com.nodz.browser.Activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.nodz.browser.R;
import com.nodz.browser.databinding.ActivityHomeScreenBinding;

public class HomeScreen extends AppCompatActivity {

    ActivityHomeScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        binding.searchBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, MainActivity.class);
                intent.putExtra("query",binding.searchBox.getText().toString());
                intent.putExtra("type",1);
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(HomeScreen.this).toBundle());
            }
        });
    }
}
// Add Transitions
//ActivityOptions.makeSceneTransitionAnimation(HomeScreen.this).toBundle();