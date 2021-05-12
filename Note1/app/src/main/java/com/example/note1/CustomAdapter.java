package com.example.note1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private Context context;
    private ArrayList note_id;
    private ArrayList note_name;
    private ArrayList note_content;

    CustomAdapter(Context context, ArrayList note_name,ArrayList note_content,ArrayList note_id){
        this.context = context;
        this.note_name = note_name;
        this.note_content = note_content;
        this.note_id = note_id;


    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.Note_name.setText(String.valueOf(note_name.get(position)));
        holder.myrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,UpadteActivity.class);
                intent.putExtra("id",String.valueOf(note_id.get(position)));
                intent.putExtra("content",String.valueOf(note_content.get(position)));

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return note_name.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView Note_name;
        LinearLayout myrow;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Note_name = itemView.findViewById(R.id.note_id);
            myrow = itemView.findViewById(R.id.myrow);
        }
    }

}
