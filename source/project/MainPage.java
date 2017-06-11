package project;

import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MainPage extends JFrame implements ActionListener, ItemListener {
	Maze panel;
	JLabel lb;
	JLabel lb2;
	protected static JLabel rank_first;
	protected static JLabel rank_second;
	protected static JLabel first_digit;
	protected static JLabel second_digit;
	protected static ImageIcon[] numIcon;
	JButton btnrenew, btnlast, btnnext, btnchoose, btnfirst, btnover, btnmuc;
	// JComboBox jc = new JComboBox();
	MenuItem renew = new MenuItem("    Renew");
	// MenuItem back = new MenuItem(" Back");
	MenuItem last = new MenuItem("    Last");
	MenuItem next = new MenuItem("    Next");
	MenuItem choose = new MenuItem("    Choose");
	Music bgm = new Music();
	/**
	 * 
	 * @param level
	 * @param music
	 */
	MainPage(int level, int music) {

		super("Puzzle Game!");

		bgm.setFilePath(music);
		bgm.playMusic();

		numIcon = new ImageIcon[10];
		for (int j = 0; j < 10; j++) {
			String filename = "resrc/gif/" + (j + 20) + ".gif";
			numIcon[j] = new ImageIcon(filename);
		}

		setSize(785, 720);
		setVisible(true);
		setResizable(false);
		setLocation(300, 20);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container cont = getContentPane();
		cont.setLayout(null);
		Color c1 = new Color(109, 68, 57);
		cont.setBackground(c1);
		Menu choice = new Menu("    Selection");
		choice.add(renew);
		choice.add(last);
		choice.add(next);
		choice.add(choose);
		// choice.add(back);
		choice.addSeparator();
		renew.addActionListener(this);
		last.addActionListener(this);
		next.addActionListener(this);
		choose.addActionListener(this);

		// back.addActionListener(this);
		Menu setmuc = new Menu("    Set the music");

		MenuBar bar = new MenuBar();
		bar.add(choice);
		bar.add(setmuc);
		setMenuBar(bar);

		ImageIcon round = new ImageIcon("resrc/gif/30.gif");
		lb = new JLabel(round);
		ImageIcon rank = new ImageIcon("resrc/gif/31.gif");
		lb2 = new JLabel(rank);
		add(lb);
		add(lb2);
		lb.setBounds(700, 571, 80, 30);
		lb2.setBounds(700, 451, 80, 30);

		btnrenew = new JButton("");
		btnrenew.setBorderPainted(false);
		ImageIcon icon1 = new ImageIcon("resrc/gif/10.gif");
		btnrenew.setIcon(icon1);

		// btnback = new JButton("Back");
		btnlast = new JButton("");
		btnlast.setBorderPainted(false);
		ImageIcon icon2 = new ImageIcon("resrc/gif/12.gif");
		btnlast.setIcon(icon2);

		btnnext = new JButton("");
		btnnext.setBorderPainted(false);
		ImageIcon icon3 = new ImageIcon("resrc/gif/13.gif");
		btnnext.setIcon(icon3);

		add(btnrenew);
		add(btnlast);
		add(btnnext);

		btnrenew.setBounds(700, 100, 80, 30);
		btnrenew.addActionListener(this);
		btnlast.setBounds(700, 200, 80, 30);
		btnlast.addActionListener(this);
		btnnext.setBounds(700, 300, 80, 30);
		btnnext.addActionListener(this);

		panel = new Maze();
		add(panel);

		rank_first = new JLabel(numIcon[new Ranking(Start.myname).getRank() / 10]);
		rank_second = new JLabel(numIcon[new Ranking(Start.myname).getRank() % 10]);
		add(rank_first);
		add(rank_second);
		rank_first.setBounds(700, 480, 40, 66);
		rank_second.setBounds(740, 480, 40, 66);

		first_digit = new JLabel(numIcon[0]);

		second_digit = new JLabel(numIcon[1]);

		add(first_digit);
		add(second_digit);
		first_digit.setBounds(700, 600, 40, 66);
		second_digit.setBounds(740, 600, 40, 66);

		if (level == 0) {
			panel.buildMap(1);// control the level

		} else {
			panel.buildMap(level);

			first_digit.setIcon(numIcon[panel.level / 10]);
			second_digit.setIcon(numIcon[panel.level % 10]);
		}

		panel.requestFocus();
		validate();

		// renew the game
		btnrenew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// new tempmain();

				panel.buildMap(panel.level);
				panel.requestFocus();
				panel.remove();

			}
		});
		// go to next round
		btnnext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// new tempmain();
				if (panel.level < 35) {
					panel.level++;
					panel.buildMap(panel.level);
					panel.requestFocus();
					panel.remove();
					first_digit.setIcon(numIcon[panel.level / 10]);
					second_digit.setIcon(numIcon[panel.level % 10]);
				}

			}
		});
		// go to last round
		btnlast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// new tempmain();
				if (panel.level > 1) {
					panel.level--;
					panel.buildMap(panel.level);
					panel.requestFocus();
					panel.remove();
					first_digit.setIcon(numIcon[panel.level / 10]);
					second_digit.setIcon(numIcon[panel.level % 10]);
				}
			}
		});

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
