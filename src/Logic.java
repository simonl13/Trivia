import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Logic {
	
	public static ArrayList<Question> questions = new ArrayList<Question>();
	public static ArrayList<Integer> answeredQuestions = new ArrayList<Integer>();
	
	static int questionNumber;
	static int questionQuantity;
	static int tryNumber;
	
	String newQuestion;
	String newAnswer;
	
	static String question;
	static String answer;
	
	static String[] lineString;
	
	static boolean answered = true;
	static boolean noQuestions = false;
	
	static Random randomNumber = new Random();
	
	public static String[] getQuestion() {
		//checks if all questions have been answered
		if (tryNumber >= questionQuantity) {
			System.out.println("You have answered all questions. Game over");
			System.exit(0);
		}
		
		tryNumber += 1;
		
		//ensures that question has not been already answered
		while(true) {
			questionNumber = randomNumber.nextInt(questionQuantity) + 1;
			if (!(answeredQuestions.contains(questionNumber))) {
				break;
			}
		}
		
		//adds questions to already answered list
		answeredQuestions.add(questionNumber);
		
		question = questions.get(questionNumber - 1).getQuestion();
		answer = questions.get(questionNumber - 1).getAnswer();
		return new String[] {question, answer};
	}
	
	public int getQuestionAmount() {
		return questionQuantity;
	}
	
	public int getAnsweredQuestions() {
		return tryNumber;
	}
	
	public static void loadItems() throws IOException {
		//loads Questions Part
		try (BufferedReader reader = new BufferedReader(new FileReader("questions.txt"))) {
			//debug
			String line;
			while ((line = reader.readLine()) != null) {
				lineString = line.split(",");
				
				Question tempQuestion = new Question();
				tempQuestion.loadQuestion(lineString[0], lineString[1]);

				questions.add(tempQuestion);
				questionQuantity += 1;
			}
		}
		catch (FileNotFoundException event) {
			File newFile = new File("questions.txt");
			newFile.createNewFile();
			noQuestions = true;
		}
		//if files are newly generated, stops the program and tells the runner.
		if (noQuestions == true) {
			System.out.println("My my, it looks like you haven't set the questions up yet.");
			System.out.println("Look at the files that have been generated to see how to do so.");
			System.exit(0);
		}
	}
}
