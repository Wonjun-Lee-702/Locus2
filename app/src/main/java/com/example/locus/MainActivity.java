package com.example.locus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public int school_position;
    public String location_name;
    public static Context context;

    private ListView location_list;
    private ArrayList<RestaurantListItem> locations = new ArrayList<>();

    private RestaurantAdapter rAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MainActivity tmp = this;

        //get school info
        school_position = ((FirstPageActivity)FirstPageActivity.context).school_position;

        location_list = (ListView) findViewById(R.id.location_list);

        //add locations to location_list
        switch (school_position) {
            case 0:
                //GaTech
                locations.add(new RestaurantListItem(R.drawable.panda_express, "PandaExpress"));
                locations.add(new RestaurantListItem(R.drawable.subway, "Subway"));
                locations.add(new RestaurantListItem(R.drawable.twisted_taco, "Twisted Taco"));
                locations.add(new RestaurantListItem(R.drawable.chick_fil_a, "Chick-fil-a"));
                break;
            case 1:
                //Emory
                locations.add(new RestaurantListItem(R.drawable.romeos_pizza, "Romeo's Pizza"));
                locations.add(new RestaurantListItem(R.drawable.panera, "Panera"));
                break;
        }

        rAdapter = new RestaurantAdapter(this, locations);
        location_list.setAdapter(rAdapter);

        location_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), DisplayMessageActivity.class);

                location_name = locations.get(position).getrName();
                context = tmp;
                startActivity(intent);
            }
        });
    }
}
