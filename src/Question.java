public class Question {

	//declarations
	String question;
	String answer;
	
	public String getQuestion() {
		//gets the question using the number.
		return question;
	}
	
	public String getAnswer() {
		//returns answer corresponding to the number given
		return answer;
	}
	
	public void loadQuestion(String newQuestion, String newAnswer) {
		if ((newQuestion != null) && (newAnswer != null)) {
			question = newQuestion;
			answer = newAnswer;
		}
	}
}
