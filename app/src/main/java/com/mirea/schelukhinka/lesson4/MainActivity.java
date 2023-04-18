package com.mirea.schelukhinka.lesson4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.mirea.schelukhinka.lesson4.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private	ActivityMainBinding	binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding	= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}