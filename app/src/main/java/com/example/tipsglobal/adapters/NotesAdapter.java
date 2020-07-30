package com.example.tipsglobal.adapters;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tipsglobal.R;
import com.example.tipsglobal.entities.Note;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NoteViewHolder> {

    private List<Note> notes;

    /* start constructor method **/
    public NotesAdapter(List<Note> notes) {
        this.notes = notes;
    }//end of the constructor method

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NoteViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_container_note,
                        parent,
                        false
                )
        );
    }//end of the onCreateViewHolder

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        holder.setNote(notes.get(position));
    }//end of the onBindViewHolder

    @Override
    public int getItemCount() {
        return notes.size();
    }//end of the getItemCount


    @Override
    public int getItemViewType(int position) {
        return position;
    }//end of the getItemViewType method

    /* creating view holder **/
    static class NoteViewHolder extends RecyclerView.ViewHolder{

        /* variable declaration **/
        TextView textTitle, textSubtitle, textDateTime;
        LinearLayout layoutNote;

        /* start constructor method **/
        NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            /* initial xml UI **/
            textTitle = itemView.findViewById(R.id.textTitle);
            textSubtitle = itemView.findViewById(R.id.textSubtitle);
            textDateTime = itemView.findViewById(R.id.textDateTime);
            layoutNote = itemView.findViewById(R.id.layoutNote);
        }//end of the constructor method

        /* method for set note data **/
        void setNote(Note note) {

            textTitle.setText(note.getTitle());

            if(note.getSubtitle().trim().isEmpty()){
                textSubtitle.setVisibility(View.GONE);
            }else {
                textSubtitle.setText(note.getSubtitle());
            }
            textDateTime.setText(note.getDateTime());

            GradientDrawable gradientDrawable = (GradientDrawable) layoutNote.getBackground();
            if(note.getColor() != null) {
                gradientDrawable.setColor(Color.parseColor(note.getColor()));
            }else {
                gradientDrawable.setColor(Color.parseColor("#333333"));
            }

        }//end of the setNote method

    }//end of the view holder class

}//end of the main class
