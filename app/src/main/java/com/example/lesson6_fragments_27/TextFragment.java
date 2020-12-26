package com.example.lesson6_fragments_27;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TextFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private Button btnSkip;
    private Button btnNext;
    private Button btnSend;
    private EditText editTextSend;
    private ViewPager pager;


    public static TextFragment newInstance(String param1, String param2) {
        TextFragment fragment = new TextFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_text, container, false);
        btnSkip = view.findViewById(R.id.btnSkip);
        btnNext = view.findViewById(R.id.btnNext);
        btnSend = view.findViewById(R.id.btnSendText);
        editTextSend = view.findViewById(R.id.etSend);
        pager = getActivity().findViewById(R.id.viewPager);


        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailsActivity activity = (DetailsActivity) getActivity();
                activity.showMain();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pager.setCurrentItem(1);
            }
        });

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChangeFragment changeFragment= new ChangeFragment();
                Bundle bundle = new Bundle();
                bundle.putString( "key",editTextSend.getText().toString());
                changeFragment.setArguments(bundle);
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame,changeFragment);
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}