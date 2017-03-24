package com.example.benzdev.section1;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by BenZDeV on 3/22/2017.
 */

public class testPa implements Parcelable {

    int a, b, c;

    protected testPa(Parcel in) {
        a = in.readInt();
        b = in.readInt();
        c = in.readInt();
    }

    public static final Creator<testPa> CREATOR = new Creator<testPa>() {
        @Override
        public testPa createFromParcel(Parcel in) {
            return new testPa(in);
        }

        @Override
        public testPa[] newArray(int size) {
            return new testPa[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(a);
        parcel.writeInt(b);
        parcel.writeInt(c);
    }
}
