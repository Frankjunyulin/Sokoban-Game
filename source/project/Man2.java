package project;

import java.util.ArrayList;
import java.util.List;

public class Man2 {
	private int manX2;
	private int manY2;
	int[][] maptmp;
	
	public Man2() {
		
	}
	
	public int getManX2() {
		return manX2;
	}

	public void setManX(int manX2) {
		this.manX2 = manX2;
	}

	public int getManY2() {
		return manY2;
	}

	public void setManY(int manY2) {
		this.manY2 = manY2;
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
	public List<int[][]> down(int[][] map, int[][] groundmap) {
		List<int[][]> ret_map = new ArrayList<int[][]>();
		
		Maze.direction2 = 0;
		int ttflag = 0;
		if (map[manY2][manX2] == 6 || map[manY2][manX2] == 5||map[manY2][manX2] == 19 || map[manY2][manX2] == 20|| map[manY2][manX2] == 7|| map[manY2][manX2] == 8|| map[manY2][manX2] == 17|| map[manY2][manX2] == 18) {
			if (Maze.together == 1) {
				if (Maze.direction1 == 0) {
					maptmp[manY2][manX2] = 5;
					map[manY2][manX2] = 5;
				} else if (Maze.direction1 == 1) {
					maptmp[manY2][manX2] = 20;
					map[manY2][manX2] = 20;
				} else if (Maze.direction1 == 2) {
					maptmp[manY2][manX2] = 7;
					map[manY2][manX2] = 7;
				} else if (Maze.direction1 == 3) {
					maptmp[manY2][manX2] = 8;
					map[manY2][manX2] = 8;
				}

				// Together = 0;
				ttflag = 1;
			} else {
				maptmp[manY2][manX2] = 2;
			}
		}
		if (groundmap[manY2][manX2] != 4)
			map[manY2][manX2] = maptmp[manY2][manX2];
		else

		{
			if (ttflag != 1)
				map[manY2][manX2] = 4;
		}
		// map[manY][manX] = maptmp[manY][manX];

		if (map[manY2 + 1][manX2] == 2 || maptmp[manY2 + 1][manX2] == 3 || map[manY2 + 1][manX2] == 4
				|| map[manY2 + 1][manX2] == 5|| map[manY2 + 1][manX2] == 20|| map[manY2 + 1][manX2] == 7|| map[manY2 + 1][manX2] == 8) {
			manY2++;
			Maze.together = 0;
			// if player2
			if (map[manY2][manX2] == 5||map[manY2][manX2] == 20||map[manY2][manX2] == 7||map[manY2][manX2] == 8) {
				Maze.together = 1;
			}

			if (maptmp[manY2][manX2] == 3 && (map[manY2 + 1][manX2] == 2 || map[manY2 + 1][manX2] == 4)) {
				map[manY2 + 1][manX2] = 3;
				maptmp[manY2 + 1][manX2] = 3;
				maptmp[manY2][manX2] = 2;
			} else {
				if (maptmp[manY2][manX2] == 3) {
					manY2--;
					if (ttflag == 1) {
						Maze.together = 1;
					}
				}
			}
		}
		map[manY2][manX2] = 6;
		
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
	public List<int[][]> up(int[][] map, int[][] groundmap) {
		List<int[][]> ret_map = new ArrayList<int[][]>();
		Maze.direction2 = 1;
		int ttflag = 0;
		if (map[manY2][manX2] == 6 || map[manY2][manX2] == 5|| map[manY2][manX2] == 19|| map[manY2][manX2] == 20|| map[manY2][manX2] == 7|| map[manY2][manX2] == 8|| map[manY2][manX2] == 17|| map[manY2][manX2] == 18) {
			if (Maze.together == 1) {
				if (Maze.direction1 == 0) {
					maptmp[manY2][manX2] = 5;
					map[manY2][manX2] = 5;
				} else if (Maze.direction1 == 1) {
					maptmp[manY2][manX2] = 20;
					map[manY2][manX2] = 20;
				} else if (Maze.direction1 == 2) {
					maptmp[manY2][manX2] = 7;
					map[manY2][manX2] = 7;
				} else if (Maze.direction1 == 3) {
					maptmp[manY2][manX2] = 8;
					map[manY2][manX2] = 8;
				}
				// Together = 0;
				ttflag = 1;
			} else {
				maptmp[manY2][manX2] = 2;
			}
		}
		if (groundmap[manY2][manX2] != 4)
			map[manY2][manX2] = maptmp[manY2][manX2];
		else {
			if (ttflag != 1)
				map[manY2][manX2] = 4;
		}
		// if(groundmap[manY][manX] == 4) map[manY][manX] = 4;
		if (maptmp[manY2 - 1][manX2] == 2 || maptmp[manY2 - 1][manX2] == 3 || map[manY2 - 1][manX2] == 4
				|| map[manY2 - 1][manX2] == 5|| map[manY2 - 1][manX2] == 20|| map[manY2 - 1][manX2] == 7|| map[manY2 - 1][manX2] == 8) {
			manY2--;
			Maze.together = 0;
			// if player2
			if (map[manY2][manX2] == 5||map[manY2][manX2] == 20||map[manY2][manX2] == 7||map[manY2][manX2] == 8) {
				Maze.together = 1;
			}
			// If box
			if (maptmp[manY2][manX2] == 3 && (map[manY2 - 1][manX2] == 2 || map[manY2 - 1][manX2] == 4)) {
				map[manY2 - 1][manX2] = 3;
				maptmp[manY2 - 1][manX2] = 3;
				maptmp[manY2][manX2] = 2;
			} else {
				if (maptmp[manY2][manX2] == 3) {
					manY2++;
					if (ttflag == 1) {
						Maze.together = 1;
					}
				}
			}
		}

		map[manY2][manX2] = 19;
		
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
		Maze.direction2 = 2;
		int ttflag = 0;
		if (map[manY2][manX2] == 6 || map[manY2][manX2] == 5 || map[manY2][manX2] == 17 || map[manY2][manX2] == 18
				|| map[manY2][manX2] == 7 || map[manY2][manX2] == 8|| map[manY2][manX2] == 20|| map[manY2][manX2] == 19) {
			if (Maze.together == 1) {
				if (Maze.direction1 == 0) {
					maptmp[manY2][manX2] = 5;
					map[manY2][manX2] = 5;
				} else if (Maze.direction1 == 1) {
					maptmp[manY2][manX2] = 20;
					map[manY2][manX2] = 20;
				} else if (Maze.direction1 == 2) {
					maptmp[manY2][manX2] = 7;
					map[manY2][manX2] = 7;
				} else if (Maze.direction1 == 3) {
					maptmp[manY2][manX2] = 8;
					map[manY2][manX2] = 8;
				}
				// Together = 0;
				ttflag = 1;
			} else {
				maptmp[manY2][manX2] = 2;
			}
		}
		if (groundmap[manY2][manX2] != 4)
			map[manY2][manX2] = maptmp[manY2][manX2];
		else {
			if (ttflag != 1)
				map[manY2][manX2] = 4;
		}

		if (maptmp[manY2][manX2 - 1] == 2 || maptmp[manY2][manX2 - 1] == 3 || map[manY2][manX2 - 1] == 4
				|| map[manY2][manX2-1] == 5 || map[manY2][manX2-1] == 7 || map[manY2][manX2-1] == 8|| map[manY2][manX2-1] == 20) {
		//	System.out.println("ttt");
			manX2--;
			Maze.together = 0;
			// if player2
			if (map[manY2][manX2] == 5 || map[manY2][manX2] == 7 || map[manY2][manX2] == 8|| map[manY2][manX2] == 20) {
				Maze.together = 1;
			}
			if (maptmp[manY2][manX2] == 3 && (map[manY2][manX2 - 1] == 2 || map[manY2][manX2 - 1] == 4)) {

				map[manY2][manX2 - 1] = 3;
				maptmp[manY2][manX2 - 1] = 3;
				maptmp[manY2][manX2] = 2;

			} else {
				if (maptmp[manY2][manX2] == 3) {
					manX2++;
					if (ttflag == 1) {
						Maze.together = 1;
					}
				}
			}

		}
		map[manY2][manX2] = 18;
		
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
		Maze.direction2 = 3;
		int ttflag = 0;
		if (map[manY2][manX2] == 6 || map[manY2][manX2] == 5 || map[manY2][manX2] == 17 || map[manY2][manX2] == 18
				|| map[manY2][manX2] == 7 || map[manY2][manX2] == 8|| map[manY2][manX2] == 19|| map[manY2][manX2] == 20) {
			if (Maze.together == 1) {
				if (Maze.direction1 == 0) {
					maptmp[manY2][manX2] = 5;
					map[manY2][manX2] = 5;
				} else if (Maze.direction1 == 1) {
					maptmp[manY2][manX2] = 20;
					map[manY2][manX2] = 20;
				} else if (Maze.direction1 == 2) {
					maptmp[manY2][manX2] = 7;
					map[manY2][manX2] = 7;
				} else if (Maze.direction1 == 3) {
					maptmp[manY2][manX2] = 8;
					map[manY2][manX2] = 8;
				}
				ttflag = 1;
				// Together = 0;
			} else {
				maptmp[manY2][manX2] = 2;
			}
		}
		if (groundmap[manY2][manX2] != 4)
			map[manY2][manX2] = maptmp[manY2][manX2];
		else {
			if (ttflag != 1)
				map[manY2][manX2] = 4;
		}

		if (maptmp[manY2][manX2 + 1] == 2 || maptmp[manY2][manX2 + 1] == 3 || map[manY2][manX2 + 1] == 4
				|| map[manY2][manX2+1] == 5 || map[manY2][manX2+1] == 7 || map[manY2][manX2+1] == 8|| map[manY2][manX2+1] == 20) {
			manX2++;
			Maze.together = 0;
			// if player2
			if (map[manY2][manX2] == 5 || map[manY2][manX2] == 7 || map[manY2][manX2] == 8|| map[manY2][manX2] == 20) {
				Maze.together = 1;
			}
			if (maptmp[manY2][manX2] == 3 && (map[manY2][manX2 + 1] == 2 || map[manY2][manX2 + 1] == 4)) {
				map[manY2][manX2 + 1] = 3;
				maptmp[manY2][manX2 + 1] = 3;
				maptmp[manY2][manX2] = 2;

			} else {
				if (maptmp[manY2][manX2] == 3) {
					manX2--;
					if (ttflag == 1) {
						Maze.together = 1;
					}
				}
			}

		}

		map[manY2][manX2] = 17;
		
		ret_map.add(map);
		ret_map.add(groundmap);
		
		return ret_map;
	}
}
