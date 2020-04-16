package com.example.android_lab4;

import androidx.appcompat.app.AppCompatActivity;
import java.util.*;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


    private ArrayList<String> target;
    private ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //komentarz
    }
}
