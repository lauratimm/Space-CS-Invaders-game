package Gui;

import java.io.*;

/**
 * This class is used to create, read or write to 
 * "highscore.txt" file. If the score from the current game is
 * greater than that of the file, it will replace the score
 */
public class Read_Score_Gui{

	/**
	 * This method is used to read the "highscore.txt" file and
	 * return the first line of that file
	 * 
	 * @return score The highscore stored in the text file
	 * 
	 * @exception IOException if the file does not open
	 */
	public static String read(){
		String score = "";
		try{ // Try reading the first line of the file and store that value as String score
			FileReader fileReader = new FileReader("highscore.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			score = bufferedReader.readLine();
			bufferedReader.close();
			if (score == null){ // If the value is null, then make the value 0
				FileWriter fileWriter = new FileWriter("highscore.txt");
				PrintWriter printWriter = new PrintWriter(fileWriter);
				printWriter.println(0);
				printWriter.close();
				score = "0";
			}
		}
    // if there is error finding a file, then create new, set the score to default 0
		catch(IOException e){
			File file = new File("highscore.txt");
			FileWriter fileWriter = null;
			try {
				fileWriter = new FileWriter("highscore.txt");
			}
			catch (IOException e1) {
				System.out.println("Could not write to file");
			}
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.println(0);
			printWriter.close();
    }
    return score;
  }

	/**
	 * This method takes in a score as a parameter
	 * and checks to see if the score is greater than 
	 * the score stored in the file. If it is then
	 * the score in the file is replaced
	 * 
	 * @param newScore The int score from the current game
	 * 
	 * @exception IOException if the file does not write to
	 */
	public static void setScore(int newScore){
		try{
			if (newScore > Integer.parseInt(read()) || read() == null){
				FileWriter fileWriter = new FileWriter("highscore.txt");
				PrintWriter printWriter = new PrintWriter(fileWriter);
				printWriter.println(newScore);
				printWriter.close();
			}
		}
		catch(IOException e){
			System.out.println("ERROR!");
		}
	}
}
