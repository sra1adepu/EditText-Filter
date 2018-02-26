package com.logicshore.edittextfilter;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by Clipcodes on 18/10/2017.
 */

public class MainActivity extends AppCompatActivity {

    EditText editText;
    ListView listView;
    ListViewAdapter adapter;
    String[] Name;
    ArrayList<PeopleName> nameArrayList = new ArrayList<PeopleName>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creating Filter or Search for Listview
        //GOOD

        //Create string array
        Name = new String[]{"Clipcodes Android", "Youtube Clipcodes", "Android Developers", "Michael Monney",
                "Alana Komre", "Simmon Pentol", "Mahathir Gresik", "Android Studio", "Create Filter Listview",
                "Ellie Camaro", "Youtube Android", "Blogger Clipcodes", "Cool ListView", "Mahathir Ujungpangkah"};

        //Listview
        listView = (ListView)findViewById(R.id.list);

        //Set Data
        for (int i = 0; i < Name.length; i++){
            PeopleName PN = new PeopleName(Name[i]);
            nameArrayList.add(PN);
        }
        editText = (EditText)findViewById(R.id.Edt);
        //The custom adapter
        adapter = new ListViewAdapter(this, nameArrayList);

        //Listview
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("Sra1",nameArrayList.get(position).getName().toString());
                editText.setText(nameArrayList.get(position).getName().toString());
                nameArrayList.clear();
               // editText.setFocusable(false);
            }
        });



        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //Search or Filter

              //  editText.setText((CharSequence) adapter);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(s.length()>4){
                    String who = editText.getText().toString().toLowerCase(Locale.getDefault());
                    adapter.myFilter(who);
                }

              //  editText.setText(who);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        //SUBSCRIBE FOR NICE PROJECT, LIKE and COMMENT
    }



}

