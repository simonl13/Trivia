import java.io.IOException;
import java.util.Scanner;

public class Screen {

	static String[] newQuestion;
	static String question;
	static String answer;
	static String playerAnswer;
	static int points;
	
	static Scanner input = new Scanner(System.in);
	Logic logic = new Logic();
	
	public static void main(String[] args) throws IOException {
		//loads files.
		Logic.loadItems();
		
		System.out.println("Welcome to a Game of Trivia.");
		System.out.println("Try to answer as many questions as you can.");
		
		while(true) {
			//prints out question.
			newQuestion = Logic.getQuestion();
			
			question = newQuestion[0];
			answer = newQuestion[1];
			
			System.out.println(question);
			playerAnswer = input.next();
			
			if (playerAnswer.equalsIgnoreCase(answer)) {
				System.out.println("That is correct! You have earned one point.");
				points += 1;
				System.out.println("You currently have " + points + " points.");
			}
			
			else {
				System.out.println("Incorrect.");
			}
			
		}

	}

}
