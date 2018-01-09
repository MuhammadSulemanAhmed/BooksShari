package com.example.suleman_pc.bookssharingapp;

import android.content.Intent;
import android.text.Editable;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

/**
 * Created by suleman-pc on 12/25/2017.
 */

public interface Api {
    @GET("api/book")
    Call<List<Book>> getBooks();

    @POST("api/book")
    @FormUrlEncoded
    Call<Book> saveBook(@Field("Name") String Name,
                        @Field("Writer") String Writer,
                        @Field("Price") Editable Price,
                        @Field("Discount") Editable Discount,
                        @Field("Stock") Editable Stock);

    @DELETE("api/book/{id}")
    Call<Book> deleteBook(@Path("id") Editable id);


}
