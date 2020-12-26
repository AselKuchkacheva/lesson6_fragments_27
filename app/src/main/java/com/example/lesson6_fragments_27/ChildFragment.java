package com.example.lesson6_fragments_27;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChildFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChildFragment extends Fragment {

    private Button btnNext2;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static final String TAG = "tag";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Fragment parent;

    public ChildFragment() {
        // Required empty public constructor
    }

    public static ChildFragment newInstance(ChangeFragment fragmentParent, String param2) {
        ChildFragment fragment = new ChildFragment();
        fragment.parent = fragmentParent;
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_child, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
         btnNext2 = view.findViewById(R.id.btnNext2);
         btnNext2.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View v) {
//                DetailsActivity activity = (DetailsActivity) getActivity();
//                activity.showMain();
                ((DetailsActivity)requireActivity()).showMain();
            }
        });
    }
}