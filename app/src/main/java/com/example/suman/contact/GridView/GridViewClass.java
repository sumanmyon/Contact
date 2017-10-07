package com.example.suman.contact.GridView;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

import com.example.suman.contact.Fragments.FragmentContactInfo;
import com.example.suman.contact.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by suman on 9/19/2017.
 */

public class GridViewClass {
    Fragment m;
    String s;
    int value = 20;

    public GridViewClass(Fragment mainActivity, String mycontacts) {
        this.m =  mainActivity; // (FragmentFav)
        this.s = mycontacts;
    }

//    public GridViewClass(FragmentMycontacts fragmentMycontacts) {
//        this.m = (FragmentMycontacts) fragmentMycontacts;
//    }

    public void addToGrid(GridView v) {
        //TODO get data from here
        if(s == "mycontacts"){
            value = 10;
        }

        //TODO list data from here
        ArrayList<HashMap<String,String>> contactList = new ArrayList<>();
        HashMap<String,String> contacts = new HashMap<String, String>();
        for(int i=0;i<value;i++) {
            contacts.put("rankID", "hi added");
            contactList.add(contacts);
        }


        ListAdapter adapter = new SimpleAdapter(m.getContext(),
                contactList,
                R.layout.layout,
                new String[]{"rankID"},
                new int[]{R.id.textViewGrid}
        );
        v.setAdapter(adapter);

        v.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //TODO Fragment to Activity data transfer
                //Toast.makeText(m.getContext(),"hello "+position, Toast.LENGTH_LONG).show();
                //Intent intentContactinfo = new Intent(m.getContext(), FragmentContactInfo.class);
                //intentContactinfo.putExtra("intentContactinfo","hello"+position);
                //m.startActivity(intentContactinfo);

                //TODO to pass data we have to put in bundel
                Bundle bundle = new Bundle();
                bundle.putString("intentContactinfo","Contact Info "+position);

                FragmentManager fm = m.getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();

                FragmentContactInfo contactInfo = new FragmentContactInfo();
                contactInfo.setArguments(bundle); //TODO passing data

                ft.replace(R.id.fragment, contactInfo);
                ft. addToBackStack("fma");
                ft.commit();

            }
        });
    }


}
