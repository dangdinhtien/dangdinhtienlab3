package com.example.dangdinhtien_ps10163_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView lvContact;
    GetContact getContact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvContact = findViewById(R.id.lvContact);

        getContact = new GetContact(this,lvContact);
        getContact.execute();
    }
}