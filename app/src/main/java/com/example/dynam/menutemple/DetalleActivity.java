package com.example.dynam.menutemple;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by dynam on 11-11-2015.
 */
public class DetalleActivity extends BaseActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle parameters = getIntent().getExtras();
        super.onCreate(savedInstanceState);
        setContentView(parameters.getInt("imagen"));
    }

}
