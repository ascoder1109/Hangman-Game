import java.util.Scanner;

public class App {

	private static String[] words = {
    "apple",
    "apricot",
    "arugula",
    "asparagus",
    "avocado",
    "banana",
    "beetroot",
    "blackberry",
    "blueberry",
    "broccoli",
    "carrot",
    "cauliflower",
    "cherry",
    "chestnut",
    "cucumber",
    "capsicum",
    "dates",
    "eggplant",
    "endive",
    "fig",
    "grape",
    "grapefruit",
    "guava",
    "huckleberry",
    "kiwi",
    "lemon",
    "lime",
    "mango",
    "melon",
    "mushroom",
    "nectarine",
    "olive",
    "onion",
    "orange",
    "papaya",
    "peach",
    "pear",
    "pepper",
    "pineapple",
    "plum",
    "potato",
    "cluster beans",
    "drumstick",
    "green chilies",
    "ladyfinger",
    "okra",
    "peas",
    "spinach",
    "turmeric",
    "watermelon",
    "yam",
};
	private static String word = words[(int) (Math.random() * words.length)];
	private static String asterisk = new String(new char[word.length()]).replace("\0", "*");
	private static int count = 0;

	public static void main(String[] args) {
		System.out.println("Welcome to my Hangman Game (Fruits and Vegetables Edition)!");
		Scanner sc = new Scanner(System.in);

		while (count < 7 && asterisk.contains("*")) {
			System.out.println("Guess any letter in the word");
			System.out.println(asterisk);
			String guess = sc.next();
			hang(guess);
		}
		sc.close();
	}

	public static void hang(String guess) {
		String newasterisk = "";
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == guess.charAt(0)) {
				newasterisk += guess.charAt(0);
			} else if (asterisk.charAt(i) != '*') {
				newasterisk += word.charAt(i);
			} else {
				newasterisk += "*";
			}
		}

		if (asterisk.equals(newasterisk)) {
			count++;
			hangmanImage();
		} else {
			asterisk = newasterisk;
		}
		if (asterisk.equals(word)) {
			System.out.println("Correct! You win! The word was " + word);
		}
	}

	public static void hangmanImage() {
		if (count == 1) {
			System.out.println("Wrong guess, try again");
			System.out.println("5 Attempts Remaining!");
			
		}
		if (count == 2) {
			System.out.println("Wrong guess, try again");
			System.out.println("4 Attempts Remaining!");
			
		}
		if (count == 3) {
			System.out.println("Wrong guess, try again");
			System.out.println("3 Attempts Remaining!");
			
		}
		if (count == 4) {
			System.out.println("Wrong guess, try again");
			System.out.println("2 Attempts Remaining!");
			
		}
		if (count == 5) {
			System.out.println("Wrong guess, try again");
			System.out.println("1 Attempts Remaining!");
			
		}
		if (count == 6) {
			System.out.println("Wrong guess, try again");
			System.out.println("0 Attempts Remaining!");
		
		}
		if (count == 7) {
			
			System.out.println("GAME OVER! The word was " + word);
		}
	}
}