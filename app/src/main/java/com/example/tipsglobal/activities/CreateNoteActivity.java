package com.example.tipsglobal.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.tipsglobal.R;

public class CreateNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note);

        /* initial the XML UI **/
        ImageView imageBack = findViewById(R.id.imageBack);

        /* make the image clickable **/
        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //for goto back screen
                onBackPressed();
            }//end of the onClick method

        });//end of the setOnClickListener

    }//end of the onCreate method

}//end of the main class