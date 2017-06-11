package project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Map {

	private int level, mx, my, mx2, my2;
	private int[][] mymap = new int[20][20];
	FileReader reader;
	BufferedReader bReader;
	String bb = "";
	int[] x;
	int c = 0;
	/**
	 * 
	 * @param k
	 */
	Map(int k) {
		level = k;
		String s;
		try {
			//File f = new File("resources/map/" + level + ".map");
			File f = new File("resrc/map/" + level + ".map");
			reader = new FileReader(f);
			bReader = new BufferedReader(reader);
		} catch (IOException e) {
			System.out.println(e);
		}
		try {
			while ((s = bReader.readLine()) != null) {
				bb = bb + s;

			}
		} catch (IOException g) {
			System.out.println(g);
		}
		byte[] d = bb.getBytes();
		int len = bb.length();
		int[] x = new int[len];
		for (int i = 0; i < bb.length(); i++) {
			x[i] = d[i] - 48;
		}
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				mymap[i][j] = x[c];
				if (mymap[i][j] == 5) {
					mx = j;
					my = i;
				}
				if (mymap[i][j] == 6) {
					mx2 = j;
					my2 = i;
				}
				c++;
			}
		}
	}

	int[][] getmap() {
		return mymap;
	}

	int getmanX() {
		return mx;
	}

	int getmanY() {
		return my;
	}

	int getmanX2() {
		return mx2;
	}

	int getmanY2() {
		return my2;
	}

	int[][] setmap() {
		return mymap;
	}

	int setmanX() {
		return mx;
	}

	int setmanY() {
		return my;
	}

	int setmanX2() {
		return mx2;
	}

	int setmanY2() {
		return my2;
	}
}