package com.example.tipsglobal.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.tipsglobal.R;
import com.example.tipsglobal.activities.CreateNoteActivity;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_ADD_NOTE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* initial the XML UI **/
        ImageView imageAddNoteMain = findViewById(R.id.imageAddNoteMain);

        /* make the image clickable **/
        imageAddNoteMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* for goto next  screen**/
                startActivityForResult(
                        new Intent(getApplicationContext(), CreateNoteActivity.class),
                        REQUEST_CODE_ADD_NOTE
                );
            }//end of onClick method

        });//end of setOnClickListener

    }//end of the onCreate method

}//end of the main class