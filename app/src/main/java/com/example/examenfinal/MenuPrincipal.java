package com.example.examenfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.mindorks.placeholderview.annotations.Click;

public class MenuPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
    }

    public void cARGARrEVISTAS(View v)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}