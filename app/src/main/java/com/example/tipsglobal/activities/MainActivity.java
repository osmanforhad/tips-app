package com.example.tipsglobal.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.tipsglobal.R;
import com.example.tipsglobal.database.NotesDatabase;
import com.example.tipsglobal.entities.Note;

import java.util.List;

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

        getNotes();

    }//end of the onCreate method

    /* method for get notes from Database **/
    private void getNotes(){

        @SuppressLint("StaticFieldLeak")
        class GetNotesTask extends AsyncTask<Void, Void, List<Note>>{

            @Override
            protected List<Note> doInBackground(Void... voids) {
                return NotesDatabase.getDatabase(getApplicationContext()).noteDao().getAllNotes();
            }//end of the doInBackground method

            @Override
            protected void onPostExecute(List<Note> notes) {
                super.onPostExecute(notes);
                Log.d("MY_NOTES", notes.toString());
            }//end of the onPostExecute method

        }//end of the GetNotesTask Class

        new GetNotesTask().execute();

    }//end of the getNotes method

}//end of the main class