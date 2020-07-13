package com.tekcamp.environment;

import javax.imageio.ImageIO;

import com.tekcamp.program.Main;
import com.tekcamp.model.*;

import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MapLevel {
	private final int width;
	private final int height;

	private static Tile[][] tiles;
	private static List<Coin> coins;
	
	public MapLevel(String path) {
		
		coins = new ArrayList<>();
		
		BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}

		assert bufferedImage != null;
		this.width = bufferedImage.getWidth();
		this.height = bufferedImage.getHeight();
		int[] pixels = new int[this.width * this.height];
		tiles = new Tile[this.width][this.height];
		bufferedImage.getRGB(0, 0, this.width, this.height, pixels, 0, this.width);
		
		int ghostIndex = 0;
		for (int x = 0; x < this.width; x += 32) {
			for (int y = 0; y < this.height; y += 32) {
				int val = pixels[x + (y * this.width)];
				// checking for blue in our game.png
				if (val == 0xFF0000FF) {
					// Create Tile when find blue pixel
					Tile tile = new Tile(x, y);
					tiles[x][y] = tile;
				}// checking for yellow in our game.png
				else if (val == 0xFF00FF00 ) {
					// Move PacMan when find yellow pixel
					Main.pacMan.x = x;
					Main.pacMan.y = y;
				} // checking for red in our game.png
				else if (val == 0xFFFF0000) {
					// Move Ghost when find red pixel
					Main.ghosts.get(ghostIndex).x = x;
					Main.ghosts.get(ghostIndex).y = y;
					ghostIndex++;
				
				} // checking for orange in our game.png
				else if (val == 0xFFFF8000) {
					// Create Coin when find orange pixel
					coins.add(new Coin(x, y));
				}
			}
		}
	}
	
	public static Tile[][] getTiles() {
		return tiles;
	}

	public static List<Coin> getCoins() {
		return coins;
	}

	public void render(Graphics g) {
		for (int x = 0; x < this.width; x+=32) {
			for (int y = 0; y < this.height; y+=32) {
				if (tiles[x][y] != null) {
					tiles[x][y].render(g);
				}
			}
		}
		
		coins.stream().forEach((coin) -> coin.render(g)); // example of using stream with lambda expression
		
	}
}
