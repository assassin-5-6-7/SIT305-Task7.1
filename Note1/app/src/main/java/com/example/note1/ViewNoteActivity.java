package com.example.note1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ViewNoteActivity extends AppCompatActivity {


    RecyclerView recyclerView;

    DatabaseHelper db;
    ArrayList<String> note_id ,note_name, note_content;
    CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_note);

        recyclerView = findViewById(R.id.RecyclerView);

        db = new DatabaseHelper(ViewNoteActivity.this);
        note_name = new ArrayList<>();
        note_content = new ArrayList<>();
        note_id = new ArrayList<>();

        displayNote();
        customAdapter = new CustomAdapter(ViewNoteActivity.this,note_name,note_content,note_id);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ViewNoteActivity.this));
    }

    void displayNote(){
        Cursor cursor = db.Readnote();
        if(cursor.getCount() == 0){
            Toast.makeText(this,"Nodata.",Toast.LENGTH_LONG).show();
        }
        else{
            while (cursor.moveToNext()){
                note_id.add(cursor.getString(0));
                note_name.add("Note " + cursor.getString(0));
                note_content.add(cursor.getString(2));
            }
        }
    }
}