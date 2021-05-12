package com.example.note1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class CreateActicity extends AppCompatActivity {

    TextInputEditText note;
    Button saveButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_acticity);

        note = findViewById(R.id.Note);
        saveButton = findViewById(R.id.DeleteButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper db = new DatabaseHelper(CreateActicity.this);
                String name = "Note";
                db.addNote(name,note.getText().toString());
            }
        });
    }
}