package com.example.suleman_pc.bookssharingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DeleteActivity extends AppCompatActivity {

    private static final String TAG ="MTAG";
    Retrofit retrofit;
    EditText inputId;
    Editable id;
    Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        inputId = findViewById(R.id.getID);
        btnDelete = findViewById(R.id.btnDelete);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = inputId.getText();
                retrofit = new Retrofit.Builder()
                        .baseUrl("http://172.20.126.102:8000")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                Api api = retrofit.create(Api.class);
                Call<Book> bookCall = api.deleteBook(id);
                bookCall.enqueue(new Callback<Book>() {
                    @Override
                    public void onResponse(Call<Book> call, Response<Book> response) {
                        Log.d(TAG, "onResponse: Successful");
                      
                    }

                    @Override
                    public void onFailure(Call<Book> call, Throwable t) {
                        Log.d(TAG, "onFailure: Not Successful");

                    }
                });
            }
        });





    }
}
