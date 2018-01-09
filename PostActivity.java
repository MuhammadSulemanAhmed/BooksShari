package com.example.suleman_pc.bookssharingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostActivity extends AppCompatActivity {

    private static final String TAG = "MTAG";
    EditText name;
    EditText writer;
    EditText price;
    EditText discount;
    EditText stock;
    EditText rating;
    Button btnPost;
    Retrofit retrofit;
    String bookName;
    String writerName;
    Editable bookDiscount;
    Editable bookStock;
    Editable bookPrice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        name = findViewById(R.id.book_name);
        writer = findViewById(R.id.book_writer);
        discount = findViewById(R.id.book_discount);
        stock = findViewById(R.id.book_stock);
        price = findViewById(R.id.book_price);

        btnPost = findViewById(R.id.btnPost);

        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookName =name.getText().toString().trim();
                writerName = writer.getText().toString().trim();
                bookPrice = price.getText();
                bookDiscount = discount.getText();
                bookStock = stock.getText();


                retrofit = new Retrofit.Builder()
                        .baseUrl("http://172.20.126.102:8000")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                Api api = retrofit.create(Api.class);
                Call<Book> bookCall = api.saveBook(bookName,writerName,bookPrice,bookDiscount,bookStock);
                bookCall.enqueue(new Callback<Book>() {
                    @Override
                    public void onResponse(Call<Book> call, Response<Book> response) {
                        Log.d(TAG, "onResponse: Successfully Posted");

                    }

                    @Override
                    public void onFailure(Call<Book> call, Throwable t) {
                        Log.d(TAG, "onFailure: Not Successfully Posted");

                    }
                });







            }




        });





    }
}
