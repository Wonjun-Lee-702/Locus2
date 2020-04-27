package com.example.locus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FirstPageActivity extends AppCompatActivity {
    //share school location
    public int school_position;
    public static Context context;

    private static final int[] buttonIDs = {
            R.id.techButton,
            R.id.emoryButton
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final FirstPageActivity tmp = this;
        setContentView(R.layout.activity_first_page);
//        ArrayList<ImageButton> schools = new ArrayList<>();

        for (int id: buttonIDs) {
//            ImageButton button = (ImageButton) findViewById(id);
            Button button = findViewById(id);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //function call on click
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    switch (v.getId()) {
                        case R.id.techButton:
                            school_position = 0;
                            break;
                        case R.id.emoryButton:
                            school_position = 1;
                            break;
                    }
                    context = tmp;
                    startActivity(intent);
                }
            });
//            schools.add(button);
        }

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, schools);
//        school_list.setAdapter(adapter);
//        school_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//
//                //send data to next activity
//                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                //intent.putExtra("school_position", position);
//                school_position = position;
//                context = tmp;
//                startActivity(intent);
//            }
//        });
//        school_list.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //function call on click
//                Intent intent = new Intent(FirstPageActivity.this, MainActivity.class);
//                startActivity(intent);
//            }
//        });
    }
}
