package com.ethgray.dungeongame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Gdx;

public class Buttons {
  // Enum for state control
  private enum B_STATE {
    NONE(0), B(1), A(2), BOTH(3);

    private int value;

    private B_STATE(int value) {
      this.value = value;
    }

    public int getValue() {
      return this.value;
    }
  };

  // Internal variables
  private Texture[] b_imgs;
  private B_STATE state = B_STATE.NONE;

  // Constructor
  public Buttons() {
    System.out.println("Buttons Initialized");
    initTextures();
  }

  // Public functions
  public Texture getCurrTexture() {
    return b_imgs[state.getValue()];
  }

  public void handleInput(boolean[] pkg) {
    // Change the active image
    int idx = 0;
    for (boolean input : pkg) {
      if (input) {
        state = B_STATE.values()[idx];
        break;
      }
      idx++;
    }
  }

  public void dispose() {
    for (Texture img : b_imgs) {
      img.dispose();
    }
  }

  // Private functions
  private void initTextures() {
    b_imgs = new Texture[4];
    b_imgs[0] = loadTexture("buttons/b_none.png");
    b_imgs[1] = loadTexture("buttons/b_b.png");
    b_imgs[2] = loadTexture("buttons/b_a.png");
    b_imgs[3] = loadTexture("buttons/b_both.png");
  }

  private Texture loadTexture(String file) {
    return new Texture(Gdx.files.internal(file));
  }
}
