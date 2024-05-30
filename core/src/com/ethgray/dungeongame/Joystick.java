package com.ethgray.dungeongame;

import com.badlogic.gdx.graphics.Texture;

public class Joystick extends Helper {
  private Texture[] js_sprites;

  private enum JS_DIR {
    IDLE(0), UP(1), DOWN(2), LEFT(3), RIGHT(4);

    private int value;

    private JS_DIR(int value) {
      this.value = value;
    }

    public int getValue() {
      return this.value;
    }
  };

  JS_DIR cDir = JS_DIR.IDLE;

  public Joystick() {
    // Initialize Joystick
    System.out.println("Joystick initialized");

    // Load the textures
    loadTextures();
  }

  public Texture getCurrTexture() {
    return js_sprites[cDir.getValue()];
  }

  public void handleInput(boolean[] pkg) {
    // Change the active image
    int idx = 0;
    for (boolean dir : pkg) {
      if (dir) {
        cDir = JS_DIR.values()[idx];
        break;
      }
      idx++;
    }
  }

  public void dispose() {
    for (Texture texture : js_sprites) {
      texture.dispose();
    }
  }

  // Private functions
  private void loadTextures() {
    js_sprites = new Texture[5];
    js_sprites[0] = loadImage("joystick/js_idle.png");
    js_sprites[1] = loadImage("joystick/js_up.png");
    js_sprites[2] = loadImage("joystick/js_down.png");
    js_sprites[3] = loadImage("joystick/js_left.png");
    js_sprites[4] = loadImage("joystick/js_right.png");
  }

}
