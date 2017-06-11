package project;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


/**
 * The Class Ranking.
 */
public class Ranking {
	
	/** The user name. */
	private String usrname;
	
	/** The path of ranking.txt. */
	final String rankPath = "ranking.txt";
	
	/** The path of temp.txt. */
	final String tempPath = "temp.txt";
	
	/**
	 * Let the user has right to change the ranking system.
	 *
	 * @param usrname the name of user
	 */
	public Ranking (String usrname) {
		this.usrname = usrname;
	}
	
	
	/**
	 * Adds the player.
	 */
	public void addPlayer() {
						
		File rank = new File(rankPath);
		if (!rank.exists()) {
			try {
				rank.createNewFile();
			} catch (IOException e) {
				
			}
		}

		File temp = new File(tempPath);
		if (temp.exists()) {
			temp.delete();
		}
		try {
			temp.createNewFile();
		} catch (IOException e) {
				
		}
		
		BufferedWriter bw = null;
		FileWriter fw = null;
		
		boolean exist = false;
		Scanner sc = null;
		
		try
		{
			sc = new Scanner(new FileReader(rankPath));
			fw = new FileWriter(tempPath, true);
			bw = new BufferedWriter(fw);
			
			while (sc.hasNext()) {
				
				String toAnalyse = sc.nextLine();
				String[] words = toAnalyse.split("\\ ");
				
				if (usrname.equals(words[0])) {
					exist = true;
					System.out.println("already exist!");
				}
				bw.write(toAnalyse + "\n");
				
				
			}
			
			if (exist == false) {
				bw.write(usrname + " " + 0 + "\n");
			}
			
		}
		catch (FileNotFoundException e) {}
		catch (IOException e) {}
		finally
		{
			if (sc != null) sc.close();
			try {
				if (bw != null) bw.close();
				if (fw != null) fw.close();
			} 
			catch (IOException ex) {}
				//File ranking = new File(rankPath);
				//ranking.delete();
				
			Process process = null;
			String sortCommand[] = {
					"/bin/sh", 
					"-c", 
					"sort -k 2 -g -r temp.txt > ranking.txt"
			};
			
			try {
				process = Runtime.getRuntime().exec(sortCommand);
				process.waitFor();
			} catch (Exception e) {}
			
			temp.delete();
			
		}
		
	}
	
	/**
	 * Upgrade the rank.
	 *
	 * @param level the round number
	 */
	public void upgradeR(int level) {
		
		File rank = new File(rankPath);
		if (!rank.exists()) {
			try {
				rank.createNewFile();
			} catch (IOException e) {
				
			}
		}

		File temp = new File(tempPath);
		if (temp.exists()) {
			temp.delete();
		}
		try {
			temp.createNewFile();
		} catch (IOException e) {
				
		}
		
		BufferedWriter bw = null;
		FileWriter fw = null;
		
		boolean exist = false;
		Scanner sc = null;
		
		try
		{
			sc = new Scanner(new FileReader(rankPath));
			fw = new FileWriter(tempPath, true);
			bw = new BufferedWriter(fw);
			
			while (sc.hasNext()) {
				
				String toAnalyse = sc.nextLine();
				String[] words = toAnalyse.split("\\ ");
				
				if (usrname.equals(words[0])) {
					exist = true;
					if (level > Integer.parseInt(words[1])) {
						toAnalyse = this.usrname + " " + level;
					}
					
				}
				bw.write(toAnalyse + "\n");
				
				
			}
			
			if (exist == false) {
				System.out.println("Cannot upgrade: user not exist");
			}
			
		}
		catch (FileNotFoundException e) {}
		catch (IOException e) {}
		finally
		{
			if (sc != null) sc.close();
			try {
				if (bw != null) bw.close();
				if (fw != null) fw.close();
			} 
			catch (IOException ex) {}
				//File ranking = new File(rankPath);
				//ranking.delete();
				
			Process process = null;
			String sortCommand[] = {
					"/bin/sh", 
					"-c", 
					"sort -k 2 -g -r temp.txt > ranking.txt"
			};
			
			try {
				process = Runtime.getRuntime().exec(sortCommand);
				process.waitFor();
			} catch (Exception e) {}
			
			temp.delete();
			
		
		}
	}
	
	
	/**
	 * Get one's rank.
	 *
	 * @return the rank number
	 */
	public int getRank() {
		
		boolean exist = false;
		Scanner sc = null;
		
		try
		{
			sc = new Scanner(new FileReader(rankPath));
			
			int counter = 0;
			while (sc.hasNext()) {
				
				counter++;
				
				String toAnalyse = sc.nextLine();
				String[] words = toAnalyse.split("\\ ");
				//System.out.println(words[0]);
				//System.out.println(usrname);
				
				if (this.usrname.equals(words[0])) {
					if (counter < 100) {
						return counter;
					}
					return 0;
				}
			}
			
			if (exist == false) {
				System.out.println("Cannot getRank: user not exist");
			}
		}
		catch (FileNotFoundException e) {}
		finally
		{
			if (sc != null) sc.close();
		}

		return 0;
	}
		
}

