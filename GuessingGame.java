import javax.swing.*;

public class GuessingGame {
	public static void main(String[] args) {

		int correctCount = 0;
		int attemptCount = 0;

		while(true){
			byte randomNumber = (byte)(Math.random() * 100 + 1);
			int userNumber = 0;

			//System.out.println("correct number = " + randomNumber);

			while(randomNumber != userNumber) {
				attemptCount++;
				String response = JOptionPane.showInputDialog(null,
						"Enter a guess between 1-100", 3);
				userNumber = Integer.parseInt(response);
				JOptionPane.showMessageDialog(null,
						"" + checkGuess(userNumber, randomNumber, correctCount, attemptCount));
			}
			correctCount++;
		}
	}

	public static String checkGuess(int userNumber, byte randomNumber, int correctCount, int attemptCount) {

		if(userNumber <= 0 || userNumber > 100) {
			return "Invalid guess";
		}
		else if(userNumber > randomNumber) {
			return "Your guess is too high.\nAttempts: " + attemptCount;
		}
		else if(userNumber < randomNumber) {
			return "Your guess is too low.\nAttempts:" + attemptCount;
		}
		else if(userNumber == randomNumber){
			correctCount++;
			return "your guess is correct!\nCorrect guesses:" + correctCount + "\nAttempts: " + attemptCount;
		}
		else
			return "Incorrect guess, try again.\nAttempts:" + attemptCount;
	}

}