package java.com.translate;

import java.io.File;


import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * 
 * @author bpoomalai
 * 
 * The file parses input.txt and convert the text to English. If translation not found, it will print the same word
 *
 */

public class Application {

	private static final String FILE_NAME = "src/res/input.txt";

	static Locale esLocale = new Locale("en", "GB");

	static ResourceBundle resourceBundle = ResourceBundle.getBundle("res.bundle", esLocale);

	public static void main(String args[]) throws FileNotFoundException {
		File file = new File(FILE_NAME);
		Scanner sc = new Scanner(file);

		while (sc.hasNext()) {
			Application.translate(sc.nextLine());

		}
		sc.close();
	}

	private static void translate(String input) {
		String[] words = input.split(" ");

		for (String word : words) {
			String translatedText = "";
			try {
				translatedText = resourceBundle.getString(word.toLowerCase());
			} catch (MissingResourceException e) {
				translatedText = word;
			}
			System.out.print(translatedText + " ");
		}
		System.out.println();
	}

}
