package com.ethgray.dungeongame;

// This is the interface class that each of the monsters in the game will use when they are created
interface IMonster {
  public void attack();

  public void turn();

  public void dispose();
}
