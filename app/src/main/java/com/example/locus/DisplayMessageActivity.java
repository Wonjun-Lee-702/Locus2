package com.example.locus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class DisplayMessageActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Location> arrayList;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private TextView waitTime;
    public String location_name;
    public int school_position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        school_position = ((FirstPageActivity)FirstPageActivity.context).school_position;
        location_name = ((MainActivity)MainActivity.context).location_name;

        recyclerView = findViewById(R.id.recyclerView);
        waitTime = findViewById(R.id.waitTime);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        arrayList = new ArrayList<>();

        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("location");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //when there is an update
                //download data
                arrayList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    //only add specific location's data

                    Location location = snapshot.getValue(Location.class);
                    System.out.println(location.getName());
                    if (location.getName().equals(location_name)) {
                        System.out.println(school_position);
                        System.out.println(location_name);
                        arrayList.add(location);
                        //set waiting time
                        int distance = location.getSensor1();
                        if (distance < 100) {
                            waitTime.setText("Line is full");
                        }
                        else if (distance < 200) {
                            waitTime.setText("less than 15 minutes");
                        }
                        else if (distance < 300) {
                            waitTime.setText("less than 12 minutes");
                        }
                        else if (distance < 400) {
                            waitTime.setText("less than 9 minutes");
                        }
                        else if (distance < 500) {
                            waitTime.setText("less than 6 minutes");
                        }
                        else if (distance < 600){
                            waitTime.setText("less than 3 minutes");
                        }
                        else {
                            waitTime.setText("line is empty");
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    waitTime.setText("Service not available");
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("MainActivity", String.valueOf(databaseError.toException()));
            }
        });
        adapter = new CustomAdapter(arrayList, this);
        recyclerView.setAdapter(adapter);
    }
}
