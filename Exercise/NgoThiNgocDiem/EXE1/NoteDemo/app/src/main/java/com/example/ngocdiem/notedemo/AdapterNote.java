package com.example.ngocdiem.notedemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterNote extends RecyclerView.Adapter<AdapterNote.NoteViewHolder>{


    private ArrayList<NoteManagement> listNote;
    private Context context;
    private LayoutInflater inflater;

    public AdapterNote(Context context, ArrayList<NoteManagement> list) {
        this.context = context;
        this.listNote = list;

        inflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View item = inflater.inflate(R.layout.list_note_item, viewGroup, false);

        return new NoteViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder noteViewHolder, int i) {

        NoteManagement noteCurrent = listNote.get(i);

        noteViewHolder.tvNote.setText(noteCurrent.getNote());


    }

    @Override
    public int getItemCount() {
        return listNote.size();
    }

    // View holder
    class NoteViewHolder extends RecyclerView.ViewHolder {

        private TextView tvNote;

        public  NoteViewHolder(View item) {
            super(item);
            tvNote =(TextView) item.findViewById(R.id.tvNote);
        }


    }
}
