package com.pollstreet.polstreet.Model;

import android.graphics.drawable.Drawable;
import android.widget.TextView;

public class ElectionsItem {
    Drawable img;
    String   heading;

    public Drawable getImg() {
        return img;
    }

    public void setImg(Drawable img) {
        this.img = img;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public ElectionsItem(Drawable img, String heading) {
        this.img = img;
        this.heading = heading;
    }
}
