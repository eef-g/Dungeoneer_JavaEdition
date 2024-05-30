package com.ethgray.dungeongame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

// This is a helper class that will contain functions that are used accross multiple classes
public class Helper {
  public Texture loadImage(String image) {
    return new Texture(Gdx.files.internal(image));
  }
}
