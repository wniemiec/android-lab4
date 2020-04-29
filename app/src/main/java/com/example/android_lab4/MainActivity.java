package com.example.android_lab4;

import androidx.appcompat.app.AppCompatActivity;
import java.util.*;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {


    private ArrayList<String> target;
    private SimpleCursorAdapter adapter;
    MySQLite db = new MySQLite(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //komentarz
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public void nowyWpis(MenuItem mi)
    {
        Intent intencja = new Intent(this,
                DodajWpis.class);
        startActivityForResult(intencja, 1);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(requestCode==1 && resultCode==RESULT_OK)
        {
           Bundle extras = data.getExtras();

            Animal nowy = (Animal)extras.getSerializable("nowy");

            this.db.dodaj(nowy);

            adapter.changeCursor(db.lista());
            adapter.notifyDataSetChanged();
        }
    }

}
