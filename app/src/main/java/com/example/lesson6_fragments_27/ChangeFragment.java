package com.example.lesson6_fragments_27;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

public class ChangeFragment extends Fragment implements IFragments{

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private Button btnChild;
    private Button btnNext1;

    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private ArrayList<Destination> list;
    private ViewPager pager;
    private Fragment child;
    public String text;

    public static ChangeFragment newInstance(TextFragment childFrag, String param2) {
        ChangeFragment fragment = new ChangeFragment();
        fragment.child = childFrag;
        Bundle args = new Bundle();
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
        View view = inflater.inflate(R.layout.fragment_change, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        setupRecyclerView();
        btnChild = view.findViewById(R.id.btnChild);
        btnNext1 = view.findViewById(R.id.btnNext1);
        pager = getActivity().findViewById(R.id.viewPager);


        if (getArguments() !=null) {
            text = getArguments().getString("key");
            list.add(new Destination(text,""));
        Log.e("one", "onCreateView: " + text );
        }

        btnChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              showChildFragment(ChildFragment.newInstance(ChangeFragment.this,
                      "sdfghjk"), ChildFragment.TAG);
            }
        });

        btnNext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pager.setCurrentItem(2);
            }
        });
        return view;
    }

    public void showChildFragment(Fragment fragment, String tag){
        FragmentManager manager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(R.id.change_fragment,fragment, tag);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void setupRecyclerView() {
        list = new ArrayList<>();
        list.add(new Destination("Title", "SubTitle"));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new RecyclerAdapter(list, getContext());
        adapter.setOnClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void displayDetail(String title, String subTitle) {
        MainActivity activity = (MainActivity) getActivity();
        activity.displayDetails(title,subTitle);

    }
}