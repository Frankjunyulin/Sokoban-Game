package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.JPanel;

public class Maze extends JPanel implements KeyListener {
	int max = 50;
	int[][] map, maptmp, groundmap;
	int manX, manY, manX2, manY2, boxnum;
	Image[] myImage;
	Map Levelmap;
	Map Levelmaptmp;
	Map Levelgroundmap;
	static int together;
	static int direction1;
	static int direction2;
	int len = 35;
	public int level = 1;
	Stack mystack = new Stack();
	Man man = new Man();
	Man2 man2 = new Man2();
	
	public Maze() {
		together = 0;
		direction1 = 0;
		direction2 = 0;
		setBounds(0, 0, 700, 700);
		setBackground(Color.white);
		addKeyListener(this);
		myImage = new Image[30];
		for (int i = 0; i < 30; i++) {
			myImage[i] = Toolkit.getDefaultToolkit().getImage("resrc/png/" + i + ".png");
		}
		setVisible(true);
	}
	//store the map and the man
	/**
	 * 
	 * @param i
	 */
	void buildMap(int i) {
		level = i;
		Levelmap = new Map(i);
		Levelmaptmp = new Map(i);
		Levelgroundmap = new Map(i);
		map = Levelmap.getmap();
		manX = Levelmap.getmanX();
		manY = Levelmap.getmanY();
		man.setManX(manX);
		man.setManY(manY);
		manX2 = Levelmap.getmanX2();
		manY2 = Levelmap.getmanY2();
		man2.setManX(manX2);
		man2.setManY(manY2);
		maptmp = Levelmaptmp.getmap();
		man.setMapTmp(maptmp);
		man2.setMapTmp(maptmp);
		groundmap = Levelgroundmap.getmap();

		repaint();
	}
	//paint graph
	public void paint(Graphics g) {
		for (int i = 0; i < 20; i++)
			for (int j = 0; j < 20; j++) {
				g.drawImage(myImage[map[j][i]], i * len, j * len, this);
				// g.fillOval(manX,manY, 10, 10);//gp_point
			}
		// g.fillOval(manX,manY, 10, 10);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void manNew(Graphics g) {
	//	System.out.println("12312	");
	}

	@Override
	// Key events
	public void keyPressed(KeyEvent e) {
		List<int[][]> value1 = new ArrayList<int[][]>();
		List<int[][]> value2 = new ArrayList<int[][]>();

		int stopflag = 0;
		// if press down, go down
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {

			value1 = man.down(map, groundmap);
			map = value1.get(0);
			groundmap = value1.get(1);
			if (checksuccess(map, groundmap) == true) {
				map[3][3] = 9;
				//System.out.println("Yes");
				together = 0;
			}
			// if press up, go up
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {

			value1 = man.up(map, groundmap);
			map = value1.get(0);
			groundmap = value1.get(1);
			if (checksuccess(map, groundmap) == true) {
				map[3][3] = 9;
				//System.out.println("Yes");
				together = 0;
			}
			// if press left, go left
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {

			value1 = man.left(map, groundmap);
			map = value1.get(0);
			groundmap = value1.get(1);
			if (checksuccess(map, groundmap) == true) {
				map[3][3] = 9;
				//System.out.println("Yes");
				together = 0;
			}
			// if press right, go right
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

			value1 = man.right(map, groundmap);
			map = value1.get(0);
			groundmap = value1.get(1);
			if (checksuccess(map, groundmap) == true) {
				map[3][3] = 9;
				//System.out.println("Yes");
				together = 0;
			}
			// if press s, go down
		} else if (e.getKeyCode() == KeyEvent.VK_S) {

			value2 = man2.down(map, groundmap);
			map = value2.get(0);
			groundmap = value2.get(1);
			if (checksuccess(map, groundmap) == true) {
				map[3][3] = 9;
				//System.out.println("Yes");
				together = 0;
			}
			// if press w, go up
		} else if (e.getKeyCode() == KeyEvent.VK_W) {

			value2 = man2.up(map, groundmap);
			map = value2.get(0);
			groundmap = value2.get(1);
			if (checksuccess(map, groundmap) == true) {
				map[3][3] = 9;
				//System.out.println("Yes");
				together = 0;
			}
			// if press A, go left
		} else if (e.getKeyCode() == KeyEvent.VK_A) {

			value2 = man2.left(map, groundmap);
			map = value2.get(0);
			groundmap = value2.get(1);
			if (checksuccess(map, groundmap) == true) {
				map[3][3] = 9;
				//System.out.println("Yes");
				together = 0;
			}
			//// if press D, go right
		} else if (e.getKeyCode() == KeyEvent.VK_D) {

			value2 = man2.right(map, groundmap);
			map = value2.get(0);
			groundmap = value2.get(1);
			if (checksuccess(map, groundmap) == true) {
				map[3][3] = 9;
				//System.out.println("Yes");
				together = 0;
			}
		}
		//check whether the man finish the game
		if (checksuccess(map, groundmap) == true) {
			level++;
			if (!Start.myname.equals("")) {
				Ranking temp = new Ranking(Start.myname);
				// System.out.println(Start.myname);
				temp.upgradeR(level - 1);
			}

			MainPage.rank_first.setIcon(MainPage.numIcon[new Ranking(Start.myname).getRank() / 10]);
			MainPage.rank_second.setIcon(MainPage.numIcon[new Ranking(Start.myname).getRank() % 10]);
			MainPage.first_digit.setIcon(MainPage.numIcon[level / 10]);
			MainPage.second_digit.setIcon(MainPage.numIcon[level % 10]);
			buildMap(level);
		}

		this.repaint();

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void remove() {
		mystack.removeAllElements();
	}

	public boolean checksuccess(int[][] map, int[][] groundmap) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (groundmap[i][j] == 4) {
					if (map[i][j] != 3)
						return false;
				}
			}
		}

		return true;
	}

	public void setLevel(int l) {
		this.level = l;
	}
}
