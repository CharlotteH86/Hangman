package hangman;

import java.util.ArrayList;
import java.util.Scanner;

public class Hangman {
	static Scanner reader = new Scanner(System.in);
	// static String menu= reader.nextLine();
	static String guessWords[] = { "snake", "hand", "wolf", "desk", "phone" };
	static String randomWord = guessWords[(int) (Math.random() * guessWords.length)];
	static String gameStatus = "-gamestatus \n-guesschar \n-guessword";
	static int allowedTries = 10, wrongCount = 0;
	static char[] showWord;
	static ArrayList<Character> usedLetters = new ArrayList<Character>(30);
	static StringBuffer guess;
	

	public static void main(String[] args) {

		System.out.println(randomWord);
		System.out.println("Welcome to the Hangmane game! Write menu below to see your options: ");

		menuMethod();

	}

	 static void menuMethod() {
		while (true) {
			String menu = reader.nextLine();
			if (menu.equals("menu")) {
				System.out.println(gameStatus);
			}
			if (menu.equals("gamestatus")) {
				// gameStatus();
			} else if (menu.equals("guesschar")) {
				guessLetter();
			} else if (menu.equals("guessword")) {
				guessWord();
			} else {
				System.out.println("Type menu again to see your options");
			}

		}

	}

	 static boolean guessLetter() {
	        System.out.print("Bokstav: ");
	        char ch = readLetter();

	        if (usedLetters.contains(ch)) {
	            System.out.println("Du har redan anvÃ¤nt bokstav '" + ch + "'.");
	            System.out.print("Du har anvÃ¤nt dessa bokstÃ¤ver: ");
	            System.out.println(usedLetters);
	            return true;
	        } else {
	            usedLetters.add(ch);
	        }

	        var indices = letterIndicies(ch);
	        indices.forEach(idx -> guess.setCharAt(idx, ch));

	        if (indices.isEmpty()) {
	            fail();
	        } else {
	            indices.forEach(idx -> guess.setCharAt(idx, ch));

	            if (guess.toString().equalsIgnoreCase(randomWord)) {
	                win();
	                return true;
	            }
	        }

	        return false;
	    }
	  
	  static char readLetter(){
		  String input = reader.next().toLowerCase();
				  if(input.length()==1&&Character.isLetter(input.charAt(0))) {
					  return input.charAt(0);
				  }else {
					  System.out.println("Add letter: ");
					  return readLetter();
				  }
		   }	
	  
	    static ArrayList<Integer> letterIndicies(char letter) {
	        var indices = new ArrayList<Integer>();
	        for (int i = 0; i < randomWord.length(); i++) {
	            if (randomWord.charAt(i) == letter)
	                indices.add(i);
	        }
	        return indices;
	    }
	
	 
	/*static boolean guessChar() {
		System.out.println("Guess a letter: ");
		String letter = readLetter();
		char l = letter.charAt(0);
		if (usedLetters.contains(l)) {
			System.out.println("Already used letter" + letter + ".");
			System.out.println("You have used these letters: ");
			System.out.println(usedLetters);
			return true;
		} else {
			usedLetters.add(l);
		}
		if (randomWord.contains(letter)) {
			for (int i = 0; i < showWord.length; i++) {
				if (randomWord.charAt(i) == 1) {
					showWord[i] = 1;

				}

			}
			System.out.println(new String(showWord));
			if (new String(showWord).equals(randomWord)) {
				win();
				return false;
			}
		} else {
			fail();
			return true;
		}
		return true;

	}*/

	 static void fail() {
		wrongCount++;
		hangHimImage();
		System.out.println("Sorry wrong!");
		System.out.println("You have used " + wrongCount + " tries.");

	}

	 static void win() {
		System.out.println("Congratulations you won!!!");

	}

	 /*static String readLetter() {
		String command = "";
		while (command == "") {
			command = reader.next().toLowerCase();
			if (command.length() != 1) {
				System.out.println("Choose only one letter!");
				command = "";

			} else {
				char letter = command.charAt(0);
				if (!Character.isLetter(letter)) {
					System.out.println("Only letters!");
					command = "";
				}
			}

		}
		return command;
	}*/

	static boolean guessWord() {
		System.out.println("Guess the full word:");
		String wordGuess = reader.nextLine();
		if (wordGuess.equals(randomWord)) {
		
			win();
			return false;
		} else {
			fail();
			return true;
		}
		

	}

	private static void hangHimImage() {
		// TODO Auto-generated method stub

	}

}
