package com.example.dynam.menutemple;


import android.content.Intent;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MenuActivity extends BaseActivity {

    public ArrayList<MenuTemple> customlist = new ArrayList<MenuTemple>();

    CustomAdapter adapter;
    private ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        MyApp appclass=(MyApp) getApplication();

        setListData();

        Resources res=getResources();
        list = (ListView)findViewById(R.id.listView);
        adapter= new CustomAdapter(this,customlist,res,1);
        //adapter.
        list.setAdapter(adapter);
        //Button boton1 = (Button)findViewById(R.id.boton1);
       // ImageView imagen1 = (ImageView)findViewById(R.id.foto);
       // boton1.setOnClickListener(onClickListener);
       //imagen1.setOnClickListener(onClickListener);
        /*list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                String test = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), "Ha pulsado el item " + position + test, Toast.LENGTH_SHORT).show();
            }

        });*/
    }
   /* */

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
    public void setListData()
    {

        MenuReaderDbHelper dbHelper = new MenuReaderDbHelper(this);
        //MyApp appclass=(MyApp) getApplication();
        //appclass.setArray(dbHelper.getAllBooks("appetizer_frio"));
        customlist=dbHelper.getAllBooks("appetizer_frio");
        /*for (int i = 0; i < 11; i++) {

            final MenuTemple sched = new MenuTemple();

            *//******* Firstly take data in model object ******//*
            sched.setName("Producto " + i);
            sched.setDescription("image" + i);
            sched.setPrice("$5.000");
            sched.setFoto(new ImageView(this));
            sched.setFoto2("temple");

            *//******** Take Model Object in ArrayList **********//*
            customlist.add( sched );
        }*/

    }

}
