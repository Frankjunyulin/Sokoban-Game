package project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Start extends JFrame {

	int player = 1;		// default by 1
	int l = 0;
	int m = 0;
	static String myname;
	
	public Start() {

		this.setTitle("Welcome to Puzzle Game!");
		this.setSize(600, 440);
		this.setLocation(500, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Player mode choosing panel
		JPanel panelMode = new JPanel();
		panelMode.setLayout(new BoxLayout(panelMode, BoxLayout.Y_AXIS));
		JRadioButton storyMode = new JRadioButton("1P Mode");
		JRadioButton challengeMode = new JRadioButton("2P Mode");
		ButtonGroup modeGroup = new ButtonGroup();
		//check box for 1 player
		storyMode.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				player = 1;
			}
		});
		//check box for 2 players
		challengeMode.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				l =31;
			}
		});
		
		modeGroup.add(storyMode);
		modeGroup.add(challengeMode);
		panelMode.add(storyMode);
		panelMode.add(challengeMode);
		panelMode.setBorder(BorderFactory.createTitledBorder("Mode"));

		// Username panel
		JPanel panelText = new JPanel();
		panelText.setLayout(new GridLayout(2, 1));
		JTextField jtf = new JTextField();
		panelText.add(jtf);
		panelText.setBorder(BorderFactory.createTitledBorder("Username"));
		

		// Player mode and User panel group
		JPanel panelModeNUser = new JPanel();
		panelModeNUser.setLayout(new GridLayout(1, 2));
		panelModeNUser.add(panelMode);
		panelModeNUser.add(panelText);
		
		
		// Difficulty
		JPanel panelDifficulty = new JPanel();
		panelDifficulty.setLayout(new GridLayout(3, 2));
		JRadioButton levelEasy = new JRadioButton("Beginner");
		JRadioButton levelMedi = new JRadioButton("Advanced");
		JRadioButton levelHard = new JRadioButton("Expert");
		
		levelEasy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				l = 1;
			}
		});
		
		levelMedi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				l = 11;
			}
		});
		
		levelHard.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				l = 21;
			}
		});
		
		ButtonGroup Difficulty = new ButtonGroup();
		
		Difficulty.add(levelEasy);
		Difficulty.add(levelMedi);
		Difficulty.add(levelHard);

		panelDifficulty.add(levelEasy);
		panelDifficulty.add(levelMedi);
		panelDifficulty.add(levelHard);

		panelDifficulty.setBorder(BorderFactory.createTitledBorder("Difficulty"));	
		
		
		// Music panel
		JPanel panelMusic = new JPanel();
		panelMusic.setLayout(new BoxLayout(panelMusic, BoxLayout.Y_AXIS));
		JRadioButton Music1 = new JRadioButton("Music1");
		JRadioButton Music2 = new JRadioButton("Music2");
		JRadioButton Music3 = new JRadioButton("Music3");
		
		
		/**
		 * 
		 */
		Music1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				m = 1;
			}
		});
		
		Music2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				m = 2;
			}
		});
		
		Music3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				m = 3;
			}
		});
		
		ButtonGroup musicGroup = new ButtonGroup();
		musicGroup.add(Music1);
		musicGroup.add(Music2);
		musicGroup.add(Music3);
		panelMusic.add(Music1);
		panelMusic.add(Music2);
		panelMusic.add(Music3);
		panelMusic.setBorder(BorderFactory.createTitledBorder("Music"));
		
		
		// choose buttons
		JPanel panelButtons = new JPanel();
		panelButtons.setLayout(new GridLayout(3, 2));
		JButton play = new JButton("Play");
		play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (! jtf.getText().trim().equals("")) {
					System.out.println("passing here");
					new Ranking(jtf.getText()).addPlayer();
					myname = jtf.getText().trim();

				} else {
					myname = "";
				}
				new MainPage(l, m);
			}
		});

		//JButton ranking = new JButton("Ranking");
		//ranking.addActionListener(new ActionListener() {
			//public void actionPerformed(ActionEvent e) {
				//new RankingPage();
			//}
		//});
		JLabel lblNull = new JLabel("");
		
		panelButtons.add(play);
		//panelButtons.add(ranking);
		panelButtons.add(lblNull);

		// panel south
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new BorderLayout());
		southPanel.add(panelButtons, BorderLayout.EAST);

		// panel north
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(3, 1));
		northPanel.add(panelModeNUser);
		northPanel.add(panelDifficulty);
		northPanel.add(panelMusic);

		this.setLayout(new BorderLayout());
		this.add(northPanel, BorderLayout.NORTH);
		this.add(southPanel, BorderLayout.SOUTH);
		this.setVisible(true);
	}


}