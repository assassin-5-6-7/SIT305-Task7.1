package com.example.note1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class UpadteActivity extends AppCompatActivity {

    TextInputEditText note;
    Button update_Button, delete_Button;

    String note0;
    String id0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upadte);

        note = findViewById(R.id.Note2);
        update_Button = findViewById(R.id.updateButton);
        delete_Button = findViewById(R.id.DeleteButton);

        getIntentData();
        Intent intent = new Intent(this,ViewNoteActivity.class);


        update_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper db = new DatabaseHelper(UpadteActivity.this);
                db.updateData(id0,note.getText().toString());
                startActivity(intent);



            }
        });

        delete_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper db = new DatabaseHelper(UpadteActivity.this);
                db.deleteData(id0);
                startActivity(intent);

            }
        });

    }
    void getIntentData(){
        if(getIntent().hasExtra("content")){
            id0 = getIntent().getStringExtra("id");
            note0 = getIntent().getStringExtra("content");

            note.setText(note0);
        }
    }


}