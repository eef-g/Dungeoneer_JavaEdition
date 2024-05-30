package com.ethgray.dungeongame;

import com.badlogic.gdx.graphics.Texture;

public class Slime extends Helper implements IMonster {
  private Texture[] sprites;
  private int health, damage, xp_value;

  public Slime() {
    health = 20;
    damage = 5;
    xp_value = 5;
    System.out.printf("Slime stats: %d|%d|%d\n", health, damage, xp_value);
    sprites = new Texture[2];
    sprites[0] = loadImage("monsters/Slime_idle.png");
    sprites[1] = loadImage("monsters/Slime_hurt.png");
  }

  // IMonster Methods

  public void attack() {
    System.out.println("Slime attacks you!");
  }

  public void turn() {
    System.out.println("It's the Slime's turn");
  }

  public void dispose() {
    for (Texture sprite : sprites) {
      sprite.dispose();
    }
  }

  // Public functions
  public Texture getTexture() {
    return sprites[0];
  }

  // Private functions
  private void changeState() {
    System.out.println("This is where we change the state from idle to hurt");
  }

}
