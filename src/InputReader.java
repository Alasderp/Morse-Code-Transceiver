import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class InputReader extends Thread{
	
	public String message = "";
	
	private Scanner br;
	
	public InputReader(){
		br = new Scanner(System.in);
	}
	
	public void run(){
		while(true){
			/*
		    JFrame frame = new JFrame();
		    message = JOptionPane.showInputDialog(frame, "Enter your message");
		    if (message == null) {
		      message = "SOS";
		      System.out.println("No message entered, sending for help!!");
		    }
			frame.dispose();
			*/
			if(br.hasNext()){
				message = br.nextLine();
			}
		}
	}

}
