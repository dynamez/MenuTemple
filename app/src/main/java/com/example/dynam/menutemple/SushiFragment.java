package com.example.dynam.menutemple;

import android.app.Fragment;


import android.app.ListFragment;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.view.Gravity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

/**
 * Created by dynam on 28-10-2015.
 */
public class SushiFragment extends Fragment {

    View inflatedview=null;
    View inflatedview2=null;
    View inflatedpop=null;
    LayoutInflater infl;
    Button boton1;
    TextView texto;
    public SushiFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        infl=inflater;
        this.inflatedview=inflater.inflate(R.layout.fragment_main, container, false);
        //this.inflatedview2=inflater.inflate(R.layout.productrow, container, false);
        //boton1 = (Button) inflatedview2.findViewById(R.id.boton1);
       //boton1.setOnClickListener(onClickListener);
        return inflatedview;
    }
    /*private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(final View v) {
            Intent intent;
            switch (v.getId()) {
                case R.id.boton1:
                    //intent = new Intent(MenuActivity.this, DetalleActivity.class).putExtra("imagen", R.layout.popup_layout);
                    //startActivity(intent);
                    showPopup(v);

                    break;

                case R.id.imageView3:
                    //intent = new Intent(MenuActivity.this, DetalleActivity.class).putExtra("imagen", R.layout.popup_layout);
                    //startActivity(intent);
                    showPopup(v);

                    break;
            }
        }
    };*/


}
