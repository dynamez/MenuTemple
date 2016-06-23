package com.example.dynam.menutemple;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

/**
 * Created by Tsunderella on 14-12-2015.
 */
public class MenuTemple implements Parcelable{

    private int id,cantidad;
    private String name;
    private String description;
    private String description2;
    private Double price;
    private String category;
    private ImageView foto;
    private String foto2;

    public MenuTemple(){}

    public MenuTemple(String name, String description, String description2, Double price, String category, ImageView foto, Integer cantidad) {
        super();
        this.name = name;
        this.description = description;
        this.description2 = description2;
        this.price = price;
        this.category = category;
        this.foto = foto;
        this.cantidad=cantidad;
    }
    public MenuTemple(Parcel in){
        readFromParcel(in);
    }

    //getters & setters
    public int getId(){return id;}
    public String getName(){return name;}
    public String getDescription(){return description; }
    public String getDescription2(){
        return description2;
    }
    public Double getPrice(){
        return price;
    }
    public String getCategory(){
        return category;
    }
    public ImageView getFoto(){
        return foto;
    }
    public String getFoto2(){
        return foto2;
    }

    public void setName(String name){
        this.name=name;
    }
    public void setCategory(String category){
        this.category=category;
    }
    public void setDescription(String description){
        this.description=description;
    }
    public void setDescription2(String description2){
        this.description2=description2;
    }
    public void setPrice(Double price){
        this.price=price;
    }
    public void setFoto(ImageView foto){
        this.foto=foto;
    }
    public void setId(int id){
        this.id=id;
    }
    public void setFoto2(String foto2){
        this.foto2=foto2;
    }

    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {

        // We just need to write each field into the
        // parcel. When we read from parcel, they
        // will come back in the same order
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(description2);
        dest.writeDouble(price);
        dest.writeString(category);
        dest.writeString(foto2);

    }
    /**
     *
     * Called from the constructor to create this
     * object from a parcel.
     *
     * @param in parcel from which to re-create object
     */
    private void readFromParcel(Parcel in) {

        // We just need to read back each
        // field in the order that it was
        // written to the parcel
        id = in.readInt();
        name = in.readString();
        description = in.readString();
        description2 = in.readString();
        price = in.readDouble();
        category = in.readString();
        foto2 = in.readString();

    }
    public static final Parcelable.Creator CREATOR =
            new Parcelable.Creator() {
                public MenuTemple createFromParcel(Parcel in) {
                    return new MenuTemple(in);
                }

                public MenuTemple[] newArray(int size) {
                    return new MenuTemple[size];
                }
            };
    @Override
    public String toString() {
        return "Book [id=" + id + ", name=" + name + ", description=" + description + ", description2" + description2 + ",price" + price + ",category" + category + ",foto" + foto2
                + "]";
    }
}