import java.awt.event.WindowEvent;

import javax.swing.*;
public class client {
	public static int levelcount = 1;
	public static String name;
	private static Object lock = new Object();
	private static JFrame frame = new JFrame();
	
	public static void main(String args[]){
		name = JOptionPane.showInputDialog("Welcome to Dungeon Crawler!\nEnter your character name:");
		initializeGame();
		startGame(name);
	}
	
	static void initializeGame(){
		GameInitializer frame = new GameInitializer();
		frame.setSize(300, 300);
	    frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	    frame.setVisible(true);

	    Thread t = new Thread() {
	        public void run() {
	            synchronized(lock) {
	                while (frame.isVisible())
	                    try {
	                        lock.wait();
	                    } catch (InterruptedException e) {
	                        e.printStackTrace();
	                    }
	                System.out.println("Working now");
	            }
	        }
	    };
	    t.start();

	    frame.addWindowListener(new WindowAdapter() {

	        public void windowClosing(WindowEvent arg0) {
	            synchronized (lock) {
	                frame.setVisible(false);
	                lock.notify();
	            }
	        }

	    });
	    t.join();

	}
	
	public static void startGame(String name){
		Player playerCharacter = new Player(name);
		World gameWorld = new World(5);
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
