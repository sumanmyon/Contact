package com.example.suman.contact.Fragments;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.suman.contact.GridView.GridViewClass;
import com.example.suman.contact.R;

public class FragmentFav extends Fragment {


    public FragmentFav() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fav, container, false);
        GridView v = (GridView) view.findViewById(R.id.gridView);
        GridViewClass g = new GridViewClass(FragmentFav.this, "fav");
        g.addToGrid(v);
        return view;
    }

}
