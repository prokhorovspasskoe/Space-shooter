package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Label {
    private BitmapFont bitmapFont;

    public Label() {
        bitmapFont = new BitmapFont();
    }

    public void draw(SpriteBatch spriteBatch){
        bitmapFont.draw(spriteBatch, "Hello World!", Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
    }
}
