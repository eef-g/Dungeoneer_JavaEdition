package com.ethgray.dungeongame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.Input;

public class Game extends ApplicationAdapter {
  // LibGDX classes
  SpriteBatch batch;
  Texture bg;
  OrthographicCamera cam;

  // Custom Classes
  MapGenerator generator;
  Joystick js;
  Buttons b;
  Slime slime;

  @Override
  public void create() {
    // Setup the generator
    generator = new MapGenerator(15, 15);
    js = new Joystick();
    b = new Buttons();
    slime = new Slime();

    Gdx.graphics.setResizable(false);
    Gdx.graphics.setWindowedMode(720, 1280);
    cam = new OrthographicCamera(720, 1280);
    cam.position.set(cam.viewportWidth / 2, cam.viewportHeight / 2, 0);
    cam.update();

    batch = new SpriteBatch();
    bg = new Texture("bg.jpg");
  }

  @Override
  public void render() {
    handleInput();
    // Update the camera
    cam.update();
    batch.setProjectionMatrix(cam.combined);

    // Clear the screen
    ScreenUtils.clear(0, 0, 0, 1);
    batch.begin();
    batch.draw(bg, 0, 0);

    // Draw the UI
    batch.draw(js.getCurrTexture(), 86, 250);
    batch.draw(b.getCurrTexture(), 350, 250);

    // TODO: Switch from temporary monster on screen to the game logic
    // Draw the game
    batch.draw(slime.getTexture(), 250, 800);

    // End the draw frame
    batch.end();
  }

  @Override
  public void dispose() {
    batch.dispose();
    bg.dispose();
    js.dispose();
    slime.dispose();
  }

  // Private functions
  private void handleInput() {
    // Get direction handling
    boolean up = (Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(Input.Keys.W));
    boolean down = (Gdx.input.isKeyPressed(Input.Keys.DOWN) || Gdx.input.isKeyPressed(Input.Keys.S));
    boolean left = (Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A));
    boolean right = (Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D));
    boolean idle = (!up && !down && !left && !right);

    // Get the button input
    boolean input_b = (Gdx.input.isKeyPressed(Input.Keys.BACKSPACE) || Gdx.input.isKeyPressed(Input.Keys.K));
    boolean input_a = (Gdx.input.isKeyPressed(Input.Keys.ENTER) || Gdx.input.isKeyPressed(Input.Keys.J));
    boolean input_both = (input_b && input_a);
    boolean b_idle = (!input_b && !input_a);

    // Send the boolean array to the Joystick object to update the current direction
    boolean[] js_pkg = { idle, up, down, left, right };
    js.handleInput(js_pkg);

    // Send the boolean array to the Buttons object to update the current button
    // image
    boolean[] b_pkg = { b_idle, input_b, input_a, input_both };
    b.handleInput(b_pkg);
  }
}
