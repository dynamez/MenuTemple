package com.example.dynam.menutemple;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;


public class BaseActivity extends AppCompatActivity {


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
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
                showPopup2(this.findViewById(android.R.id.content).getRootView());

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
        anchorView.getLocationOnScreen(location);

        // Using location, the PopupWindow will be displayed right under anchorView
        //popupWindow.showAtLocation(anchorView, Gravity.TOP,
             //location[0], location[1] + anchorView.getHeight());


    }
}
