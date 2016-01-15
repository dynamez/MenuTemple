package com.example.dynam.menutemple;

import android.widget.ImageView;

/**
 * Created by dynam on 11-11-2015.
 */
public class ModeloProducto {

    private  String nombre="";
    private  String detalle="";
    private  String precio="";
    private ImageView imagen;

    /*********** Set Methods ******************/

    public void setNombre(String Name)
    {
        this.nombre = Name;
    }

    public void setDetalle(String Detail)
    {
        this.detalle = Detail;
    }

    public void setPrecio(String Price)
    {
        this.precio = Price;
    }
    public void setImagen(ImageView Image){ this.imagen = Image;}

    /*********** Get Methods ****************/

    public String getNombre()
    {
        return this.nombre;
    }

    public String getDetalle()
    {
        return this.detalle;
    }

    public String getPrecio()
    {
        return this.precio;
    }

    public ImageView getImagen() { return this.imagen;}
}