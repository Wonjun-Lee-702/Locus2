package com.example.locus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
//import android.

public class MainActivity extends AppCompatActivity {
    public int school_position;
    public String location_name;
    public static Context context;

    private ListView location_list;
    private ArrayList<String> locations = new ArrayList<>();
    /*
    //firebase
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message");
    */




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MainActivity tmp = this;

        //get school info
        school_position = ((FirstPageActivity)FirstPageActivity.context).school_position;

        //add locations to location_list
        switch (school_position) {
            case 0:
                //GaTech
                locations.add("PandaExpress");
                locations.add("Subway");
                locations.add("Twisted Taco");
                locations.add("Chick-fil-a");
                break;
            case 1:
                //Emory
                locations.add("Romeo's Pizza");
                locations.add("Maru");
                break;
        }
        location_list = findViewById(R.id.location_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, locations);
        location_list.setAdapter(adapter);
        location_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), DisplayMessageActivity.class);
                location_name = locations.get(position);
                context = tmp;
                startActivity(intent);
            }
        });
    }
}
