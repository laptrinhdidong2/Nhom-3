package com.example.ngocdiem.notedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class NoteScreen extends AppCompatActivity {

    private RecyclerView rvNote;
    private ArrayList<NoteManagement> listNote;
    private AdapterNote adapterNote;
    Button btnSend;
    EditText edtInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ThemeManage.onActivityCreateSetTheme(this);

        setContentView(R.layout.activity_note_screen);

        setControl();

        importData();
        setEvent();
    }


    public void setControl() {
        rvNote = (RecyclerView) findViewById(R.id.rvListNote);
        listNote = new ArrayList<>();
        adapterNote = new AdapterNote(this, listNote);

        edtInput = (EditText) findViewById(R.id.edtInput);
        btnSend = (Button) findViewById(R.id.btnSend);

        LinearLayoutManager layout = new LinearLayoutManager(NoteScreen.this, LinearLayoutManager.VERTICAL, false);

        rvNote.setLayoutManager(layout);

        rvNote.setAdapter(adapterNote);

    }


    public void setEvent() {

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = edtInput.getText().toString();

                listNote.add(new NoteManagement(text));
                adapterNote.notifyDataSetChanged();
            }
        });

       btnSend.setOnLongClickListener(new View.OnLongClickListener() {
           @Override
           public boolean onLongClick(View v) {
               if (ThemeManage.sTheme == 0) {
                   ThemeManage.changeToTheme(NoteScreen.this, 1);
               } else {
                   ThemeManage.changeToTheme(NoteScreen.this, 0);
               }
               return true;
           }
       });


    }


    public void importData() {
        listNote.add(new NoteManagement("Đây là ghi chú 1"));
        listNote.add(new NoteManagement("Đây là phần ghi chú 2"));

        adapterNote.notifyDataSetChanged();

    }
}
