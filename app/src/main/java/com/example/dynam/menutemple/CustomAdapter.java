package com.example.dynam.menutemple;

/**
 * Created by Tsunderella on 17-06-2015.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.ArrayList;

/********* Adapter class extends with BaseAdapter and implements with OnClickListener ************/
public class CustomAdapter extends BaseAdapter {

    /***********
     * Declare Used Variables
     *********/
    private Activity activity;
    private ArrayList data;
    private static LayoutInflater inflater = null;
    public Resources res;
    MenuTemple tempValues = null;
    int i = 0,bandera;

    //public MyApp app;

    /*************
     * CustomAdapter Constructor
     *****************/
    public CustomAdapter(Activity a, ArrayList d, Resources resLocal, Integer flag) {

        /********** Take passed values **********/
        activity = a;
        data = d;
        res = resLocal;
        bandera=flag;
        //app=(MyApp)activity.getApplication();

        /***********  Layout inflator to call external xml layout () ***********/
        inflater = (LayoutInflater) activity.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    /********
     * What is the size of Passed Arraylist Size
     ************/
    public int getCount() {

        if (data.size() <= 0)
            return 1;
        return data.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    /*********
     * Create a holder Class to contain inflated xml file elements
     *********/
    public static class ViewHolder {

        public TextView item_text1, item_text3, item_text4;
        public TextView item_text2;
        public TextView textWide;
        public TextView id,texto_detalle;
        public ImageView image;
        public String draw;
        Button bt2;
        ImageView bt1;
        ImageView botoncarrito;

    }

    /******
     * Depends upon data size called for each row , Create each ListView row
     *****/
    public View getView(int position, View convertView, ViewGroup parent) {

        View vi = convertView;
        final ViewHolder holder;

        if (convertView == null) {

            /****** Inflate tabitem.xml file for each row ( Defined below ) *******/
            if(bandera ==1) {
                vi = inflater.inflate(R.layout.itemlist, null);

                /****** View Holder Object to contain tabitem.xml file elements ******/

                holder = new ViewHolder();
                holder.id = (TextView) vi.findViewById(R.id.id);
                holder.item_text1 = (TextView) vi.findViewById(R.id.name);
                holder.item_text2 = (TextView) vi.findViewById(R.id.description);
                // holder.item_text3 = (TextView) vi.findViewById(R.id.description2);
                holder.item_text4 = (TextView) vi.findViewById(R.id.precio);
                holder.image = (ImageView) vi.findViewById(R.id.foto);
                holder.texto_detalle=(TextView)vi.findViewById(R.id.description);
                //holder.image.setImageResource();
                holder.bt1 = (ImageView) vi.findViewById(R.id.boton1);
                holder.bt1.setTag((position));
                holder.image.setTag((position));
                holder.botoncarrito = (ImageView)vi.findViewById(R.id.boton_carrito);
            }else{
                /****** Inflate tabitem.xml file for each row ( Defined below ) *******/
                vi = inflater.inflate(R.layout.carrito_row, null);

                /****** View Holder Object to contain tabitem.xml file elements ******/

                holder = new ViewHolder();
                holder.id = (TextView)vi.findViewById(R.id.id_carrito);
                holder.item_text1 = (TextView) vi.findViewById(R.id.name_carrito);
                holder.item_text2 = (TextView) vi.findViewById(R.id.description_carrito);
                // holder.item_text3 = (TextView) vi.findViewById(R.id.description2);
                holder.item_text4 = (TextView) vi.findViewById(R.id.precio_carrito);
                holder.image = (ImageButton) vi.findViewById(R.id.foto_carrito);
                //holder.image.setImageResource();
                holder.texto_detalle=(TextView) vi.findViewById(R.id.description_carrito);
                holder.bt1 = (ImageView) vi.findViewById(R.id.boton_carrito);
                holder.bt1.setTag((position));
                holder.botoncarrito = (ImageView) vi.findViewById(R.id.boton_carrito);
                holder.botoncarrito.setTag((position));
                holder.image.setTag((position));
            }

            //holder.image=(ImageView)vi.findViewById(R.id.item_imagen);

            /************  Set holder with LayoutInflater ************/
            vi.setTag(holder);
        } else {
            holder = (ViewHolder) vi.getTag();
        }
                // Item it=item.get(position);
        if(bandera==1){
                holder.texto_detalle.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v){
                        Integer pos;
                        pos = (Integer)v.getTag();
                        //showPopup(v, pos, holder);
                        Intent intent;
                        intent = new Intent(activity, PopupActivity.class);
                        String name = (String)holder.item_text1.getText();
                        String id = (String)holder.id.getText();
                        String description = (String)holder.item_text2.getText();
                        String precio = (String)holder.item_text4.getText();
                        String foto = (String)holder.draw;
                        intent.putExtra("name",name);
                        intent.putExtra("id",id);
                        intent.putExtra("description",description);
                        intent.putExtra("precio",precio);
                        intent.putExtra("foto",foto);

                        activity.startActivity(intent);
                    }

                                                        });
                holder.image.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer pos;
                        pos = (Integer)v.getTag();
                        //showPopup(v, pos, holder);
                        Intent intent;
                        intent = new Intent(activity, PopupActivity.class);
                        String name = (String)holder.item_text1.getText();
                        String id = (String)holder.id.getText();
                        String description = (String)holder.item_text2.getText();
                        String precio = (String)holder.item_text4.getText();
                        String foto = (String)holder.draw;
                        intent.putExtra("name",name);
                        intent.putExtra("id", id);
                        intent.putExtra("description",description);
                        intent.putExtra("precio",precio);
                        intent.putExtra("foto",foto);

                        activity.startActivity(intent);
            }
                });
                holder.bt1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer pos;
                        pos = (Integer) v.getTag();
                        //carro(v, pos, holder);
                        Intent intent;
                        intent = new Intent(activity, CarritoActivity.class);
                        String id = (String) holder.id.getText();
                        intent.putExtra("id", id);
                        activity.startActivity(intent);
                    }
                });}
if(bandera==2) {
    holder.botoncarrito.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {


           int pos = (Integer)v.getTag();
            //carro(v,pos, holder);
            MyApp app =(MyApp)activity.getApplication();
            //int pos = (Integer) holder.botoncarrito.getTag();
            System.out.println(pos + "posicion");
            app.globalarray.remove(pos);

            //app.adapter= (CustomAdapter)list1.getAdapter();
            //app.adapter.notifyDataSetChanged();
            //app.adapter = new CustomAdapter(activity, app.getArray(), res, 2);

            //app.list1.setAdapter(app.adapter);
            app.adapter.notifyDataSetChanged();

        }
    });
}

            if(data.size()<=0)
            {
                holder.item_text1.setText("No Data");

            }
            else
            {
                   // **** Get each Model object from Arraylist *******
                    tempValues=null;
                    tempValues = ( MenuTemple ) data.get( position );

                    //***********  Set Model values in Holder elements **********
                    holder.id.setText(String.valueOf(tempValues.getId()));
                    holder.item_text1.setText( tempValues.getName() );
                    holder.item_text2.setText( tempValues.getDescription() );
                   // holder.item_text3.setText("");// tempValues.getDescription2() );
                    double num = tempValues.getPrice();
                    NumberFormat defaultFormat = NumberFormat.getCurrencyInstance();
                    defaultFormat.setMaximumFractionDigits(0);
                String iden;
                if(tempValues.getFoto2().equals("elemento")){
                    iden="com.example.dynam.menutemple:drawable/" + tempValues.getFoto2();
                }else{
                    iden="com.example.dynam.menutemple:drawable/" + tempValues.getFoto2()+"_item";
                }

                System.out.println(iden);
                holder.item_text4.setText(defaultFormat.format(num));
                int imageResource = activity.getResources().getIdentifier(iden, null, null);
                     holder.image.setImageResource(imageResource);
//                          res.getIdentifier(
//                                  "com.example.dynam.menutemple:drawable/maguro_tataki_item"
//                                  , null, null));
                    holder.draw=tempValues.getFoto2();

                 //   ******* Set Item Click Listner for LayoutInflater for each row ******

                    //vi.setOnClickListener(new OnItemClickListener( position ));
        }
        return vi;
    }
//    public void showPopup(View anchorView, int position, ViewHolder holder) {
//
//        View popupView = inflater.inflate(R.layout.newpopup, null);
//
//        PopupWindow popupWindow = new PopupWindow(popupView,
//                800, 600);
//
//        // Example: If you have a TextView inside `popup_layout.xml`
//        TextView description = (TextView) popupView.findViewById(R.id.description);
//        TextView name = (TextView) popupView.findViewById(R.id.name);
//        TextView precio = (TextView) popupView.findViewById(R.id.precio);
//        ImageView foto = (ImageView)popupView.findViewById(R.id.foto);
//        name.setText(holder.item_text1.getText());
//        description.setText(holder.item_text2.getText());
//        precio.setText(holder.item_text4.getText());
//        foto.setImageResource(res.getIdentifier(
//                "com.example.dynam.menutemple:drawable/logol"//+holder.draw
//                ,null,null));
//
//
//        //tv.setText("hola");
//
//        // Initialize more widgets from `popup_layout.xml`
//
//
//        // If the PopupWindow should be focusable
//        popupWindow.setFocusable(true);
//
//        // If you need the PopupWindow to dismiss when when touched outside
//        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));
//
//        int location[] = new int[2];
//
//        // Get the View's(the one that was clicked in the Fragment) location
//        anchorView.getLocationOnScreen(location);
//
//        // Using location, the PopupWindow will be displayed right under anchorView
////        popupWindow.showAtLocation(anchorView, Gravity.NO_GRAVITY,
////                location[0], location[1] + anchorView.getHeight());
//        popupWindow.showAtLocation(anchorView, Gravity.CENTER,
//                0, 0);
//
//    }
//
//    public void carro (View anchorView, int position, ViewHolder holder){
//
//        View popupView = inflater.inflate(R.layout.carrito_layout, null);
//        app.list1 = (ListView)popupView.findViewById(R.id.listacarro);
//
//        PopupWindow popupWindow = new PopupWindow(popupView,
//                700, AbsListView.LayoutParams.WRAP_CONTENT);
//        popupView = inflater.inflate(R.layout.carrito_row, null);
//        //popupWindow.setWidth(500);
//
//
//
//        //app = (MyApp)activity.getApplication();
//        MenuReaderDbHelper dbHelper = new MenuReaderDbHelper(app.getApplicationContext());
//        ArrayList<MenuTemple> temple = new ArrayList<>();
//        String idValue = holder.id.getText().toString();
//        System.out.println(idValue + "wii");
//        temple=dbHelper.getMenubyID(Integer.parseInt(idValue));
//
//        app.globalarray.add(temple.get(0));
//
//        app.adapter = new CustomAdapter(activity, app.getArray(), res, 2);
//
//        app.list1.setAdapter(app.adapter);
//
//
//
//        popupWindow.setFocusable(true);
//
//        // If you need the PopupWindow to dismiss when when touched outside
//        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));
//
//        int location[] = new int[2];
//
//        // Get the View's(the one that was clicked in the Fragment) location
//        anchorView.getLocationOnScreen(location);
//
//        // Using location, the PopupWindow will be displayed right under anchorView
//        popupWindow.showAtLocation(anchorView, Gravity.TOP,
//                15, 30);
//    }
//
}

    /*@Override
    public void onClick(View v) {
        Log.v("CustomAdapter", "=====Row button clicked=====");
    }

   // ******** Called when Item click in ListView ***********
  private class OnItemClickListener  implements View.OnClickListener {
        private int mPosition;

       OnItemClickListener(int position){
           mPosition = position;
        }

        @Override
      public void onClick(View arg0) {


            MainActivity sct = (MainActivity)activity;

          // ***  Call  onItemClick Method inside CustomListViewAndroidExample Class ( See Below )***

          // sct.onItemClick(mPosition);
        }
    }
}*/