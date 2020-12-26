package com.example.lesson6_fragments_27;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.app.UiAutomation;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DetailsActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private Adapter pagerAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        init();
    }

    private void init() {
        viewPager = findViewById(R.id.viewPager);
        pagerAdapter = new Adapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
    }

    public  void  showMain(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}