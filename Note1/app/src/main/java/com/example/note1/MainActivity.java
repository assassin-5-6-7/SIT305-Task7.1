package com.example.note1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Creat_Click(View view) {
        Intent intent = new Intent(this,CreateActicity.class);
        startActivity(intent);
    }

    public void Show_Click(View view) {
        Intent intent = new Intent(this,ViewNoteActivity.class);
        startActivity(intent);
    }
}