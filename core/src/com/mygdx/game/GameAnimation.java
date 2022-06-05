package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class GameAnimation {
    private final Animation<TextureRegion> animation;
    private final Texture texture;
    private float time;
    private final boolean loop;

    public GameAnimation(String name, int width, int height, float fps, boolean loop, Animation.PlayMode mode) {
        this.loop = loop;
        texture = new Texture(name);
        TextureRegion region = new TextureRegion(texture);
        int tw = region.getRegionWidth() / width;
        int th = region.getRegionHeight() / height;
        TextureRegion[][] regions = region.split(tw, th);
        TextureRegion[] regionsAligned = new TextureRegion[width * height];

        int cnt = 0;
        for (int i = 0; i < regions.length; i++) {
            for (int j = 0; j < regions[i].length; j++) {
                regionsAligned[cnt++] = regions[i][j];
            }
        }

        animation = new Animation<TextureRegion>(1.0f/fps, regionsAligned);
        animation.setPlayMode(mode);
    }

    public void dispose(){
        texture.dispose();
    }

    public void setTime(float time) {
        this.time = time;
    }

    public TextureRegion draw(){
        return animation.getKeyFrame(time, loop);
    }
}
