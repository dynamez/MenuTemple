package com.example.dynam.menutemple;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.TextView;


public class BaseActivity extends AppCompatActivity {

    private static LayoutInflater inflater = null;
    public MyApp app;
    public Resources res;
    Menu menu1;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        menu1 = menu;
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            case R.id.action_settings:
                return true;
            case R.id.action_carrito:
                Intent intent;
                intent = new Intent(this, CarritoActivity.class);
                startActivity(intent);
                System.out.println("wekereke");

                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
        //noinspection SimplifiableIfStatement

    }

    public void showPopup2(View anchorView) {

        View popupView = getLayoutInflater().inflate(R.layout.carrito_layout, null);

        PopupWindow popupWindow;
        popupWindow = new PopupWindow(popupView);

        // Example: If you have a TextView inside `popup_layout.xml`
        TextView tv = (TextView) popupView.findViewById(R.id.description);


        // If the PopupWindow should be focusable
        popupWindow.setFocusable(true);

        // If you need the PopupWindow to dismiss when when touched outside
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));

        int location[] = new int[2];

        // Get the View's(the one that was clicked in the Fragment) location
        //anchorView.getLocationOnScreen(location);

        // Using location, the PopupWindow will be displayed right under anchorView
        popupWindow.showAtLocation(anchorView, Gravity.TOP,
                15, 30);


    }
    public void showcarro (View anchorView){
        inflater = (LayoutInflater) this.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View popupView = inflater.inflate(R.layout.carrito_layout, null);
        //app.list1 = (ListView)popupView.findViewById(R.id.listacarrito);

        PopupWindow popupWindow = new PopupWindow(popupView,
                700, AbsListView.LayoutParams.WRAP_CONTENT);
        popupView = inflater.inflate(R.layout.carrito_row, null);
        //popupWindow.setWidth(500);



        //app = (MyApp)activity.getApplication();
        res=getResources();
        app.adapter = new CustomAdapter(this, app.getArray(), res, 2);

        app.list1.setAdapter(app.adapter);



        popupWindow.setFocusable(true);

        // If you need the PopupWindow to dismiss when when touched outside
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));

        int location[] = new int[2];

        // Get the View's(the one that was clicked in the Fragment) location
        anchorView.getLocationOnScreen(location);

        // Using location, the PopupWindow will be displayed right under anchorView
        popupWindow.showAtLocation(anchorView, Gravity.TOP,
                15, 30);
    }
}
