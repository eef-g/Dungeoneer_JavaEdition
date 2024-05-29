package com.ethgray.dungeongame;

public class MapGenerator {
  private int[][] grid;

  public MapGenerator(int width, int height) {
    generateMap(width, height);
    System.out.println("Map has been generated.");
    System.out.printf("Expected: 1 | Actual: %d\n", grid[width - 1][height - 1]);
  }

  // Private functions
  private void generateMap(int width, int height) {
    grid = new int[width][height];
    for (int x = 0; x < width; x++) {
      int[] row = grid[x];
      for (int y = 0; y < height; y++) {
        // For now, just make everything a 1
        // TODO: Make a more robust level generator
        row[y] = 1;
      }
    }
  }
}
