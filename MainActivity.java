package com.example.suleman_pc.bookssharingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MTAG";
    RecyclerView recyclerView;
    ArrayList<Book> books;
    BookAdapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    DividerItemDecoration dividerItemDecoration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        Button buttonDelete = findViewById(R.id.button3);
        books = new ArrayList<>();
        recyclerView = findViewById(R.id.bookRecycler);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://172.20.126.102:8000")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);
        final Call<List<Book>> busList = api.getBooks();
        busList.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, retrofit2.Response<List<Book>> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: success " + response.body().get(2).getName());
                    List<Book> list = response.body();
                    for (Book book : list) {
                        books.add(book);
                        Log.d(TAG, "onResponse: " + book.getAuthor() + " \n");
                    }
                    myAdapter = new BookAdapter(books, MainActivity.this);
                    recyclerView.setAdapter(myAdapter);
                } else if (response.code() != 200) {
                    Log.d(TAG, "onResponse: ELSE " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PostActivity.class);
                startActivity(intent);
            }
        });
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DeleteActivity.class);
                startActivity(intent);
            }
        });


    }
}

