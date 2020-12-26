package com.example.lesson6_fragments_27;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity{

    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private Fragment fragment;
    private View fragmentView;
    private boolean mViewFragment = false;
    public static String KEY ="key";
    public static String KEY2 ="key2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentView = findViewById(R.id.fragment_first_main);
        if (fragmentView!=null){
            mViewFragment = true;
        }
        if(mViewFragment) {
            fragmentManager = getSupportFragmentManager();
            transaction = fragmentManager.beginTransaction();
            transaction.add(R.id.fragment_first_main, new ChangeFragment());
            transaction.commit();
        }else{
            fragmentManager = getSupportFragmentManager();
            transaction = fragmentManager.beginTransaction();
            transaction.add(R.id.fragment_first, new ChangeFragment());
            transaction.commit();
        }

    }

    public void displayDetails(String title, String subTitle){
        if(mViewFragment) {
            fragmentManager = getSupportFragmentManager();
            transaction = fragmentManager.beginTransaction();
            transaction.add(R.id.fragment_first, TextFragment.newInstance(title, subTitle));
            transaction.commit();
        }
        else {
            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra(KEY, subTitle);
            intent.putExtra(KEY2, subTitle);
            startActivity(intent);
        }
    }
}