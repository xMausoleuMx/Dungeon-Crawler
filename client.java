import java.util.*;
import java.text.*;
import java.io.*;
import javax.swing.*;
public class client {
	public static int levelcount = 1;
	
	public static void main(String args[]){
		Scanner reader = new Scanner(System.in);
		Random num = new Random();
		String name = JOptionPane.showInputDialog("WELCOME TO DUNGEON DESTROYER!\nPLEASE ENTER YOUR CHARACTERS NAME");
		
	}
	
	public static void gameOver()
    {
        String holder;
        holder = JOptionPane.showInputDialog(null, "Out of life, you made it to level: " + levelcount + "\nPlay agian?\n(YES/NO)");
        if(holder.equalsIgnoreCase("NO"))
        {
            System.exit(0);
        }
    }
}
