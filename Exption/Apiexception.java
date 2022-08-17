package com.example.schoolmanagment1.Exption;

import lombok.AllArgsConstructor;


public class Apiexception extends RuntimeException{
    public Apiexception(String message) {
        super(message);
    }
}