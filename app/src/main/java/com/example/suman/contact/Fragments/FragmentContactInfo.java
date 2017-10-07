package com.example.suman.contact.Fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.suman.contact.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentContactInfo extends Fragment {

    View view;
    TextView textViewContactView;


    String value;


    public FragmentContactInfo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view =  inflater.inflate(R.layout.fragment_contact_info, container, false);

        //TODO get data from bundel
        Bundle bundle = getArguments();
        value = bundle.getString("intentContactinfo");

        //Toast.makeText(getContext(),value,Toast.LENGTH_LONG).show();

        castViews();
        displayContactInfo();

        return view;
    }

    private void castViews() {
        textViewContactView = (TextView)view.findViewById(R.id.textView_name_ContactView);
    }

    private void displayContactInfo() {
        textViewContactView.setText(value);
        textViewContactView.setTextColor(Color.BLACK);
        textViewContactView.setTextSize(20.0f);
    }

}
