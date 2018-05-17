import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Client {

	private static BufferedReader in;
	private static PrintWriter out;
	private static int PORT = 8181;
	private static String address = "127.0.0.1";
	private static Socket socket;

	public static void main(String[] args) throws Exception{
		
		InputReader reader = new InputReader();
		reader.start();

		try {
			socket = new Socket(address, PORT);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
		} catch (Exception e) {

		}

		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			try {
				if (in.ready()) {
					String msg = in.readLine();
					playMessage(msg);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if(!reader.message.equals("") && reader.message != null) {
				String message = reader.message;
				sendMessage(message);
				reader.message = "";
			}
			

		}

	}

	public static void playMessage(String msg) {

		char[] charList = msg.toCharArray();
		for (int x = 0; x < charList.length; x++) {
			
			String character = charList[x] + "";
			
			// Check for spaces between words and allow for a pause
			if (character.equals(" ")) {
				System.out.print(" ");
				playSound(750, 0.0, 0);

			}
			else if (charList[x] == '.') {
				System.out.print(".");
				playSound(100, 1.0, 600);
			} else {
				System.out.print("-");
				playSound(250, 1.0, 600);
			}

		}
		
		System.out.println("");

	}
	
	public static void sendMessage(String text) {		
		
	    text = text.trim();
		
		if (text == "") {
	      text = "SOS";
	      System.out.println("No message entered, sending for help!!");
	    }
	    
		text = text.toLowerCase();
		
		char[] charList = text.toCharArray();
		
		LetterToMorseTable dictionary = new LetterToMorseTable();
		
		String morseString = "";
		
		for(int x = 0;x < charList.length;x++) {
			
			if(dictionary.letterTranslator.containsKey(charList[x])) {
				morseString += dictionary.letterTranslator.get(charList[x]);
				morseString += " ";
			}
			else if(charList[x] == ' ') {
				morseString += "  ";
			}
			
		}
		
		out.println(morseString);

	}

	public static void playSound(int duration, double volume, int frequency) {
		try {
			Sound.tone(frequency, duration, volume);
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
