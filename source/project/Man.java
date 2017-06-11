package project;

import java.util.ArrayList;
import java.util.List;

public class Man {
	private int manX;
	private int manY;
	int[][] maptmp;
	
	public int getManX() {
		return manX;
	}

	public void setManX(int manX) {
		this.manX = manX;
	}

	public int getManY() {
		return manY;
	}

	public void setManY(int manY) {
		this.manY = manY;
	}

	public void setMapTmp(int[][] maptmp) {
		this.maptmp = maptmp;
	}
	/**
	 * 
	 * @param map
	 * @param groundmap
	 * @return
	 */
	public List<int[][]> up(int[][] map, int[][] groundmap) {
		List<int[][]> ret_map = new ArrayList<int[][]>();
		Maze.direction1 = 1;
		
		int ttflag = 0;
		
		if (map[manY][manX] == 5 || map[manY][manX] == 6||map[manY][manX] == 19 || map[manY][manX] == 20|| map[manY][manX] == 7|| map[manY][manX] == 8|| map[manY][manX] == 17|| map[manY][manX] == 18) {
			if (Maze.together == 1) {
				if (Maze.direction2 == 0) {
					maptmp[manY][manX] = 6;
					map[manY][manX] = 6;
				} else if (Maze.direction2 == 1) {
					maptmp[manY][manX] = 19;
					map[manY][manX] = 19;
				} else if (Maze.direction2 == 2) {
					maptmp[manY][manX] = 18;
					map[manY][manX] = 18;
				} else if (Maze.direction2 == 3) {
					maptmp[manY][manX] = 17;
					map[manY][manX] = 17;
				}
				// Together = 0;
				ttflag = 1;
			} else {
				maptmp[manY][manX] = 2;
			}
		}
		if (groundmap[manY][manX] != 4)
			map[manY][manX] = maptmp[manY][manX];
		else {
			if (ttflag != 1)
				map[manY][manX] = 4;

		}

		// if(groundmap[manY][manX] == 4) map[manY][manX] = 4;
		if (maptmp[manY - 1][manX] == 2 || maptmp[manY - 1][manX] == 3 || map[manY - 1][manX] == 4
				|| map[manY - 1][manX] == 6|| map[manY - 1][manX] == 19|| map[manY - 1][manX] == 17|| map[manY - 1][manX] == 18) {
			manY--;
			Maze.together = 0;
			// if player2
			if (map[manY][manX] == 6||map[manY][manX] == 19||map[manY][manX] == 17||map[manY][manX] == 18) {
				Maze.together = 1;
			}

			// If box
			if (maptmp[manY][manX] == 3 && (map[manY - 1][manX] == 2 || map[manY - 1][manX] == 4)) {
				map[manY - 1][manX] = 3;
				maptmp[manY - 1][manX] = 3;
				maptmp[manY][manX] = 2;
			} else {
				if (maptmp[manY][manX] == 3) {
					manY++;
					if (ttflag == 1) {
						Maze.together = 1;
					}
				}
			}

		}
		// if(groundmap[manY][manX] == 4) maptmp[manY][manX] = 4;
		map[manY][manX] = 20;
		ret_map.add(map);
		ret_map.add(groundmap);
		
		return ret_map;
	}
	/**
	 * 
	 * @param map
	 * @param groundmap
	 * @return
	 */
	public List<int[][]> down(int[][] map, int[][] groundmap) {
		List<int[][]> ret_map = new ArrayList<int[][]>();
		Maze.direction1 = 0;
		int ttflag = 0;
		if (map[manY][manX] == 5 || map[manY][manX] == 6||map[manY][manX] == 19 || map[manY][manX] == 20|| map[manY][manX] == 17|| map[manY][manX] == 18|| map[manY][manX] == 7|| map[manY][manX] == 8) {
			if (Maze.together == 1) {
				if (Maze.direction2 == 0) {
					maptmp[manY][manX] = 6;
					map[manY][manX] = 6;
				} else if (Maze.direction2 == 1) {
					maptmp[manY][manX] = 19;
					map[manY][manX] = 19;
				} else if (Maze.direction2 == 2) {
					maptmp[manY][manX] = 18;
					map[manY][manX] = 18;
				} else if (Maze.direction2 == 3) {
					maptmp[manY][manX] = 17;
					map[manY][manX] = 17;
				}
				// Together = 0;
				ttflag = 1;
			} else {
				maptmp[manY][manX] = 2;
			}
		}
		if (groundmap[manY][manX] != 4)
			map[manY][manX] = maptmp[manY][manX];
		else {
			if (ttflag != 1)
				map[manY][manX] = 4;
		}
		// map[manY][manX] = maptmp[manY][manX];

		if (map[manY + 1][manX] == 2 || maptmp[manY + 1][manX] == 3 || map[manY + 1][manX] == 4
				|| map[manY + 1][manX] == 6|| map[manY + 1][manX] == 19|| map[manY + 1][manX] == 17|| map[manY + 1][manX] == 18) {
			manY++;
			Maze.together = 0;
			// if player2
			if (map[manY][manX] == 6||map[manY][manX] == 19||map[manY][manX] == 17||map[manY][manX] == 18) {
				Maze.together = 1;
			}

			if (maptmp[manY][manX] == 3 && (map[manY + 1][manX] == 2 || map[manY + 1][manX] == 4)) {
				map[manY + 1][manX] = 3;
				maptmp[manY + 1][manX] = 3;
				maptmp[manY][manX] = 2;
			} else {
				if (maptmp[manY][manX] == 3) {
					manY--;
					if (ttflag == 1) {
						Maze.together = 1;
					}
				}
			}
		}
		map[manY][manX] = 5;
		ret_map.add(map);
		ret_map.add(groundmap);
		return ret_map;
	}
	/**
	 * 
	 * @param map
	 * @param groundmap
	 * @return
	 */
	public List<int[][]> left(int[][] map, int[][] groundmap) {
		List<int[][]> ret_map = new ArrayList<int[][]>();
		Maze.direction1 = 2;
		int ttflag = 0;
		if (map[manY][manX] == 6 || map[manY][manX] == 5 || map[manY][manX] == 17 || map[manY][manX] == 18
				|| map[manY][manX] == 7 || map[manY][manX] == 8 || map[manY][manX] == 19 || map[manY][manX] == 20) {
			if (Maze.together == 1) {
				if (Maze.direction2 == 0) {
					maptmp[manY][manX] = 6;
					map[manY][manX] = 6;
				} else if (Maze.direction2 == 1) {
					maptmp[manY][manX] = 19;
					map[manY][manX] = 19;
				} else if (Maze.direction2 == 2) {
					maptmp[manY][manX] = 18;
					map[manY][manX] = 18;
				} else if (Maze.direction2 == 3) {
					maptmp[manY][manX] = 17;
					map[manY][manX] = 17;
				}
				// Together = 0;
				ttflag = 1;
			} else {
				maptmp[manY][manX] = 2;
			}
		}
		if (groundmap[manY][manX] != 4)
			map[manY][manX] = maptmp[manY][manX];
		else {
			if (ttflag != 1)
				map[manY][manX] = 4;
		}

		if (maptmp[manY][manX - 1] == 2 || maptmp[manY][manX - 1] == 3 || map[manY][manX - 1] == 4
				|| map[manY][manX-1] == 6 || map[manY][manX-1] == 17 || map[manY][manX-1] == 18|| map[manY][manX-1] == 19|| map[manY][manX-1] == 20) {
			manX--;
			Maze.together = 0;
			// if player2
			if (map[manY][manX] == 6 || map[manY][manX] == 17 || map[manY][manX] == 18|| map[manY][manX] == 19) {
				Maze.together = 1;
			}
			if (maptmp[manY][manX] == 3 && (map[manY][manX - 1] == 2 || map[manY][manX - 1] == 4)) {

				map[manY][manX - 1] = 3;
				maptmp[manY][manX - 1] = 3;
				maptmp[manY][manX] = 2;

			} else {
				if (maptmp[manY][manX] == 3) {
					manX++;
					if (ttflag == 1) {
						Maze.together = 1;
					}
				}
			}

		}
		// if(groundmap[manY][manX] == 4) maptmp[manY][manX] = 4;
		map[manY][manX] = 7;
		ret_map.add(map);
		ret_map.add(groundmap);
		
		return ret_map;
	}
	/**
	 * 
	 * @param map
	 * @param groundmap
	 * @return
	 */
	public List<int[][]> right(int[][] map, int[][] groundmap) {
		List<int[][]> ret_map = new ArrayList<int[][]>();
		
		Maze.direction1 = 3;
		int ttflag = 0;
		if (map[manY][manX] == 6 || map[manY][manX] == 5 || map[manY][manX] == 17 || map[manY][manX] == 18
				|| map[manY][manX] == 7 || map[manY][manX] == 8|| map[manY][manX] == 19|| map[manY][manX] == 20) {
			if (Maze.together == 1) {
				if (Maze.direction2 == 0) {
					maptmp[manY][manX] = 6;
					map[manY][manX] = 6;
				} else if (Maze.direction2 == 1) {
					maptmp[manY][manX] = 19;
					map[manY][manX] = 19;
				} else if (Maze.direction2 == 2) {
					maptmp[manY][manX] = 18;
					map[manY][manX] = 18;
				} else if (Maze.direction2 == 3) {
					maptmp[manY][manX] = 17;
					map[manY][manX] = 17;
				}
				// Together = 0;
				ttflag = 1;
			} else {
				maptmp[manY][manX] = 2;
			}
		}
		if (groundmap[manY][manX] != 4)
			map[manY][manX] = maptmp[manY][manX];
		else {
			if (ttflag != 1)
				map[manY][manX] = 4;
		}

		if (maptmp[manY][manX + 1] == 2 || maptmp[manY][manX + 1] == 3 || map[manY][manX + 1] == 4
				|| map[manY][manX+1] == 6 || map[manY][manX+1] == 17 || map[manY][manX+1] == 18|| map[manY][manX+1] == 19|| map[manY][manX+1] == 20) {
			manX++;
			Maze.together = 0;
			// if player2
			if (map[manY][manX] == 6 || map[manY][manX] == 17 || map[manY][manX] == 18|| map[manY][manX] == 19) {
				Maze.together = 1;
			}
			if (maptmp[manY][manX] == 3 && (map[manY][manX + 1] == 2 || map[manY][manX + 1] == 4)) {
				map[manY][manX + 1] = 3;
				maptmp[manY][manX + 1] = 3;
				maptmp[manY][manX] = 2;

			} else {
				if (maptmp[manY][manX] == 3) {
					manX--;
					if (ttflag == 1) {
						Maze.together = 1;
					}
				}
			}

		}
		// if(groundmap[manY][manX] == 4) maptmp[manY][manX] = 4;
		map[manY][manX] = 8;
		ret_map.add(map);
		ret_map.add(groundmap);
		
		return ret_map;
	}

	public Man() {
		// TODO Auto-generated constructor stub
	}

}
