package com.example.dynam.menutemple;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.ArrayList;

public class CarritoActivity extends AppCompatActivity {

    ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        WindowManager.LayoutParams lp = this.getWindow().getAttributes();
        lp.gravity = Gravity.TOP | Gravity.LEFT;
        lp.dimAmount = 0;
        lp.flags = WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS;
                //| WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;

        LayoutInflater inflater = getLayoutInflater();
        LinearLayout ll = (LinearLayout) inflater.inflate(
                R.layout.carrito_layout, null);
        setContentView(ll, lp);
        //setContentView(R.layout.carrito_layout);

        Intent i = getIntent();
        if(i.hasExtra("id")){
            Bundle b = getIntent().getExtras();
            String idValue = b.getString("id");
            System.out.println(idValue);
            TextView total_compra = (TextView)findViewById(R.id.total_compra);
            MyApp app = (MyApp)getApplication();

            app.list1 = (ListView)findViewById(R.id.listacarro);
            MenuReaderDbHelper dbHelper = new MenuReaderDbHelper(this);
            ArrayList<MenuTemple> temple = new ArrayList<>();
            temple=dbHelper.getMenubyID(Integer.parseInt(idValue));
            app.globalarray.add(temple.get(0));
            int o;
            double total=0;
            for(o=0;o<app.globalarray.size();o++){
                total= total + app.globalarray.get(o).getPrice();
            }
        NumberFormat defaultFormat = NumberFormat.getCurrencyInstance();
        defaultFormat.setMaximumFractionDigits(0);
            total_compra.setText(String.valueOf(defaultFormat.format(total)));

            app.adapter = new CustomAdapter(this, app.getArray(), getResources(), 2);

            app.list1.setAdapter(app.adapter);
        }else {
            try{
                i.getStringExtra("id");
                System.out.println("paso corbata");
                TextView total_compra = (TextView)findViewById(R.id.total_compra);
                MyApp app = (MyApp)getApplication();

                app.list1 = (ListView)findViewById(R.id.listacarro);
                int o;
                double total=0;
                for(o=0;o<app.globalarray.size();o++){
                    total= total + app.globalarray.get(o).getPrice();
                }
                NumberFormat defaultFormat = NumberFormat.getCurrencyInstance();
                defaultFormat.setMaximumFractionDigits(0);
                total_compra.setText(String.valueOf(defaultFormat.format(total)));

                app.adapter = new CustomAdapter(this, app.getArray(), getResources(), 2);

                app.list1.setAdapter(app.adapter);
            }catch (NullPointerException e){
                System.out.println("No paso na");
            }
        }


    }
}
