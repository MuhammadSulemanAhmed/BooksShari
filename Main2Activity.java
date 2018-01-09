package com.example.suleman_pc.bookssharingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class Main2Activity extends AppCompatActivity {

//    TextView author = (TextView) findViewById(R.id.bus_route);
//    TextView bookName = (TextView) findViewById(R.id.route_no);


    TextView etName;
    TextView etWriter;
    TextView etPrice;
    TextView etRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        etName = (TextView) findViewById(R.id.name);
        etWriter = (TextView) findViewById(R.id.writer);
        etPrice = (TextView) findViewById(R.id.price);
       // etRating = (TextView) findViewById(R.id.rating);

        Gson gson = new Gson();
        String target = getIntent().getStringExtra("Details");
        Book book = gson.fromJson(target, Book.class);


        String Name =  book.getName().toString();
        String Author =   book.getAuthor().toString();
        String Price = book.getPrice().toString();
       // String Rating = "Rating = " + book.getRating().toString();

        etName.setText(Name);
        etWriter.setText(Author);
        etPrice.setText(Price);
        //etRating.setText(Rating);




    }
}
