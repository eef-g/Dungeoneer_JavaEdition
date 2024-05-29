package com.ethgray.dungeongame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Game extends ApplicationAdapter {
  SpriteBatch batch;
  Texture bg;
  Texture js;
  OrthographicCamera cam;
  MapGenerator generator;

  @Override
  public void create() {
    // Setup the generator
    generator = new MapGenerator(15, 15);

    Gdx.graphics.setResizable(false);
    Gdx.graphics.setWindowedMode(720, 1280);
    cam = new OrthographicCamera(720, 1280);
    cam.position.set(cam.viewportWidth / 2, cam.viewportHeight / 2, 0);
    cam.update();

    batch = new SpriteBatch();
    bg = new Texture("bg.jpg");
    js = new Texture("js_idle.png");
  }

  @Override
  public void render() {
    cam.update();
    batch.setProjectionMatrix(cam.combined);

    ScreenUtils.clear(0, 0, 0, 1);
    batch.begin();
    batch.draw(bg, 0, 0);
    batch.draw(js, 86, 250);
    batch.end();
  }

  @Override
  public void dispose() {
    batch.dispose();
    bg.dispose();
    js.dispose();
  }
}
