package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
	private SpriteBatch batch;
	TextureRegion region;
	private int x, y;
	private GameAnimation gameAnimation;
	private Label label;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		gameAnimation = new GameAnimation("runRight.png", 8, 1, 60, true, Animation.PlayMode.LOOP);
		label = new Label();
	}

	@Override
	public void render () {
		gameAnimation.setTime(Gdx.graphics.getDeltaTime());
		ScreenUtils.clear(1, 0, 0, 1);
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) x--;
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) x++;
		batch.begin();
		batch.draw(gameAnimation.draw(), x, 0);
		label.draw(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	    gameAnimation.dispose();
	}
}
