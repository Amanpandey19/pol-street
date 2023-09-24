package com.pollstreet.polstreet.Model;

import android.graphics.drawable.Drawable;

public class Bets {
    Drawable betImg;
    String   betText;

    public Bets(Drawable betImg, String betText) {
        this.betImg = betImg;
        this.betText = betText;
    }

    public Drawable getBetImg() {
        return betImg;
    }

    public void setBetImg(Drawable betImg) {
        this.betImg = betImg;
    }

    public String getBetText() {
        return betText;
    }

    public void setBetText(String betText) {
        this.betText = betText;
    }
}
