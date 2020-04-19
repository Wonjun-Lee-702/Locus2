package com.example.locus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FirstPageActivity extends AppCompatActivity {
    //share school location
    public int school_position;
    public static Context context;

    private ListView school_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final FirstPageActivity tmp = this;
        setContentView(R.layout.activity_first_page);
        ArrayList<String> schools = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            schools.add("School " + i);
        }
        school_list = findViewById(R.id.school_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, schools);
        school_list.setAdapter(adapter);
        school_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(FirstPageActivity.this, position + " is clicked", Toast.LENGTH_SHORT).show();

                //send data to next activity
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                //intent.putExtra("school_position", position);
                school_position = position;
                context = tmp;
                startActivity(intent);
            }
        });
        /*
        school_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //function call on click
                Intent intent = new Intent(FirstPageActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        */
    }
}
