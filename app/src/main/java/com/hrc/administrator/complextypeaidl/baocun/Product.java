package com.hrc.administrator.complextypeaidl.baocun;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2017/1/16.
 */

public class Product implements Parcelable{
    private int id;
    private String name;
    private float price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    protected Product(Parcel in) {
    }

    public Product(){}

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeFloat(price);
    }

    public void readFromParcel(Parcel in){
        id=in.readInt();
        name=in.readString();
        price=in.readFloat();
    }
}
