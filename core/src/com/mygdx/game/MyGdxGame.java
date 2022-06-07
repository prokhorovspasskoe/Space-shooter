package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
	private SpriteBatch batch;
	TextureRegion region;
	private int x, y;
	private GameAnimation gameAnimation;
	private Label label;
	private TiledMap map;
	private OrthogonalTiledMapRenderer mapRender;
	private OrthographicCamera camera;
	
	@Override
	public void create () {
		map = new TmxMapLoader().load("maps/map1.tmx");
		mapRender = new OrthogonalTiledMapRenderer(map);
		camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		RectangleMapObject mo = (RectangleMapObject) map.getLayers().get("Слой объектов 1").getObjects().get("Camera");
		camera.position.x = mo.getRectangle().x;
		camera.position.y = mo.getRectangle().y;
		camera.update();
		batch = new SpriteBatch();
		gameAnimation = new GameAnimation("runRight.png", 8, 1, 16, true, Animation.PlayMode.LOOP);
		label = new Label();
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		gameAnimation.setTime(Gdx.graphics.getDeltaTime());
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) x--;
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) x++;
		mapRender.setView(camera);
		camera.update();
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
