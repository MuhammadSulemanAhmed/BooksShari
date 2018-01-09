package com.example.suleman_pc.bookssharingapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


 public class Book {

@SerializedName("Name")
@Expose
private String name;
@SerializedName("Writer")
@Expose
private String author;
@SerializedName("Price")
@Expose
private Integer price;
@SerializedName("rating")
@Expose
private Integer rating;

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}



public String getAuthor() {
return author;
}


public void setAuthor(String author) {
this.author = author;
}

public Integer getPrice() {
return price;
}

public void setPrice(Integer price) {
this.price = price;
}

public Integer getRating() {
return rating;
}

public void setRating(Integer rating) {
this.rating = rating;
}

}

