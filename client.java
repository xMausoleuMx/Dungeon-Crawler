import java.awt.event.WindowEvent;

import javax.swing.*;
public class client {
	public static int levelcount = 1, difficulty = 0;;
	public static String name;
	private static Object lock = new Object();
	private static JFrame frame = new JFrame();
	
	public static void main(String args[]){
		initializeGame();
		startGame(name);
	}
	
	static void initializeGame(){
		GameInitializer frame = new GameInitializer();
		frame.setSize(320, 150);
	    frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	    frame.setVisible(true);
	    while(!frame.selectionDone()){
	    	try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println("interupted");
				e.printStackTrace();
			}
	    	name = frame.getName();
	    	difficulty = frame.getDifficulty();
	    }
	    frame.dispose();
	}
	
	public static void startGame(String name){
		Player playerCharacter = new Player(name,difficulty);
		World gameWorld = new World(difficulty);
		gameWorld.genWorld();
		GUI gameWindow = new GUI(gameWorld, playerCharacter);
		gameWindow.setVisible(true);
	}
	
	public static void gameOver()
    {
        String holder;
        holder = JOptionPane.showInputDialog(null, "Out of life, you made it to level: " + levelcount + "\nPlay agian?\n(YES/NO)");
        if(holder.equalsIgnoreCase("NO")){
            System.exit(0);
        }
        else{
        	startGame(name);
        }
    }
}
