package com.example.suleman_pc.bookssharingapp;



import java.util.List;


public class  BookEvent {
    private Book message;

    public BookEvent(Book message) {
        this.message = message;
    }

    public String getMessageName() {
        return message.getName();
    }
}

