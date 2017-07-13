import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
public class GUI extends JFrame {

	private JPanel contentPane;
	private Player playerCharacter;
	private Monster enemy;
	private int lastXPos, lastYPos;
	private Random num = new Random();
	private mapPanel minimappanel;
	private World map;
	private boolean inCombat = false;
	private JLabel lblImage, playerHealthLabel, playerAttackLabel, playerArmorLabel, playerScoreLabel, playerLvlLabel, playerNameLabel, playerManaLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {//to be used for testing only
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Player holder = new Player("test", 2);
					World wHolder = new World(5);
					wHolder.genWorld();
					GUI frame = new GUI(wHolder,holder);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI(World tempmap, Player pc) {
		playerCharacter = pc;
		map = tempmap;
		setPlayerStart();
		setResizable(false);
		setTitle("Dungeon Crawler");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		minimappanel = new mapPanel();
		minimappanel.setBackground(Color.BLACK);
		minimappanel.setBounds(10, 301, 150, 140);
		contentPane.add(minimappanel);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBorder(new LineBorder(Color.BLACK, 2));
		layeredPane_1.setBounds(159, 361, 314, 40);
		contentPane.add(layeredPane_1);
		
		JLabel lblInv = new JLabel("");
		lblInv.setIcon(new ImageIcon(GUI.class.getResource("/assets/Character/Inv.png")));
		lblInv.setBounds(0, 0, 314, 38);
		layeredPane_1.add(lblInv);
		
		JLayeredPane layeredPane_2 = new JLayeredPane();
		layeredPane_2.setBorder(new LineBorder(Color.BLACK, 2));
		layeredPane_2.setBackground(Color.PINK);
		layeredPane_2.setBounds(473, 301, 150, 140);
		contentPane.add(layeredPane_2);
		
		JLabel lblPlayersprite = new JLabel("");
		layeredPane_2.setLayer(lblPlayersprite, 1);
		lblPlayersprite.setIcon(new ImageIcon(GUI.class.getResource("/assets/Character/Nakedsprite.png")));
		lblPlayersprite.setBounds(10, 59, 35, 70);
		layeredPane_2.add(lblPlayersprite);
		
		JLabel lblHealth = new JLabel("Health: ");
		layeredPane_2.setLayer(lblHealth, 1);
		lblHealth.setForeground(Color.WHITE);
		lblHealth.setBounds(55, 40, 46, 14);
		layeredPane_2.add(lblHealth);
		
		JLabel lblAttack = new JLabel("Attack: ");
		layeredPane_2.setLayer(lblAttack, 1);
		lblAttack.setForeground(Color.WHITE);
		lblAttack.setBounds(55, 65, 46, 14);
		layeredPane_2.add(lblAttack);
		
		JLabel lblArmor = new JLabel("Armor: ");
		layeredPane_2.setLayer(lblArmor, 1);
		lblArmor.setForeground(Color.WHITE);
		lblArmor.setBounds(55, 90, 46, 14);
		layeredPane_2.add(lblArmor);
		
		JLabel lblScore = new JLabel("Score: ");
		layeredPane_2.setLayer(lblScore, 1);
		lblScore.setForeground(Color.WHITE);
		lblScore.setBounds(10, 25, 46, 14);
		layeredPane_2.add(lblScore);
		
		playerLvlLabel = new JLabel("0");
		playerLvlLabel.setForeground(Color.WHITE);
		playerLvlLabel.setBounds(120, 11, 30, 14);
		layeredPane_2.add(playerLvlLabel);
		
		JLabel lblLvl = new JLabel("LvL:");
		lblLvl.setForeground(Color.WHITE);
		lblLvl.setBounds(94, 11, 35, 14);
		layeredPane_2.add(lblLvl);
		
		playerHealthLabel = new JLabel("100");
		playerHealthLabel.setForeground(Color.WHITE);
		playerHealthLabel.setBounds(94, 40, 46, 14);
		layeredPane_2.add(playerHealthLabel);
		
		playerAttackLabel = new JLabel("10");
		playerAttackLabel.setForeground(Color.WHITE);
		playerAttackLabel.setBounds(94, 65, 46, 14);
		layeredPane_2.add(playerAttackLabel);
		
		playerArmorLabel = new JLabel("1");
		playerArmorLabel.setForeground(Color.WHITE);
		playerArmorLabel.setBounds(94, 90, 46, 14);
		layeredPane_2.add(playerArmorLabel);
		
		playerScoreLabel = new JLabel("0");
		playerScoreLabel.setForeground(Color.WHITE);
		playerScoreLabel.setBounds(10, 40, 46, 14);
		layeredPane_2.add(playerScoreLabel);
		
		JLabel lblMana = new JLabel("Mana: ");
		lblMana.setForeground(Color.WHITE);
		lblMana.setBounds(55, 115, 46, 14);
		layeredPane_2.add(lblMana);
		
		playerNameLabel = new JLabel("");
		playerNameLabel.setForeground(Color.WHITE);
		playerNameLabel.setBounds(10, 11, 79, 14);
		layeredPane_2.add(playerNameLabel);
		
	    playerManaLabel = new JLabel("0");
		playerManaLabel.setForeground(Color.WHITE);
		playerManaLabel.setBounds(94, 115, 46, 14);
		layeredPane_2.add(playerManaLabel);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(GUI.class.getResource("/assets/Character/black.png")));
		lblBackground.setBounds(0, 0, 150, 140);
		layeredPane_2.add(lblBackground);
		
		JLayeredPane layeredPane_3 = new JLayeredPane();
		layeredPane_3.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		layeredPane_3.setBounds(159, 401, 314, 40);
		contentPane.add(layeredPane_3);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(GUI.class.getResource("/assets/Character/Inv.png")));
		lblNewLabel_1.setBounds(0, 0, 314, 40);
		layeredPane_3.add(lblNewLabel_1);
		
		JLayeredPane layeredPane_4 = new JLayeredPane();
		layeredPane_4.setBorder(new LineBorder(Color.RED, 2));
		layeredPane_4.setBounds(10, 11, 613, 353);
		contentPane.add(layeredPane_4);
		
		JButton btnAttack = new JButton("Attack");
		btnAttack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(inCombat)
					playerAttack();
			}
		});
		btnAttack.setMargin(new Insets(2, 2, 2, 2));
		btnAttack.setBounds(360, 291, 53, 23);
		layeredPane_4.add(btnAttack);
		
		JButton btnRun = new JButton("Run");
		btnRun.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(inCombat){
					enemyTurn();
					playerCharacter.setXPos(lastXPos);
					playerCharacter.setYPos(lastYPos);
					updateDisplay();
					inCombat = false;
				}
			}
		});
		btnRun.setMargin(new Insets(2, 2, 2, 2));
		btnRun.setBounds(418, 319, 45, 23);
		layeredPane_4.add(btnRun);
		
		JButton btnDown = new JButton("Down");
		btnDown.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(!inCombat && movePlayer(1)){
					updateDisplay();
					checkRoom();
				}
			}
		});
		
		JButton btnPotion = new JButton("Potion");
		btnPotion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				Object[] options = {"Health",
                "Mana"};
				int n = JOptionPane.showOptionDialog(null,
				"Which type of potion would you like to drink?",
				"Which Potion",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,     
				options,  
				options[0]);
				System.out.println(n);
				if(inCombat){
					if(playerCharacter.drinkPotion(n+4)){
						enemyTurn();
					}
					else
						JOptionPane.showConfirmDialog(null, "You don't have any of that potion!" ,"Out of Potion",JOptionPane.OK_OPTION);
				}
				else{
					if(!playerCharacter.drinkPotion(n+4))
						JOptionPane.showConfirmDialog(null, "You don't have any of that potion!" ,"Out of Potion",JOptionPane.OK_OPTION);
				}
				updateDisplay();
			}
		});
		btnPotion.setMargin(new Insets(2, 2, 2, 2));
		btnPotion.setBounds(360, 319, 53, 23);
		layeredPane_4.add(btnPotion);
		
		JButton btnMagic = new JButton("Magic");
		btnMagic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(inCombat)
					magicAttack();
			}
		});
		btnMagic.setMargin(new Insets(2, 2, 2, 2));
		btnMagic.setBounds(418, 291, 45, 23);
		layeredPane_4.add(btnMagic);
		btnDown.setMargin(new Insets(2, 2, 2, 2));
		btnDown.setBounds(181, 330, 37, 23);
		layeredPane_4.add(btnDown);
		
		JButton btnUp = new JButton("Up");
		btnUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				if(!inCombat && movePlayer(3)){
					updateDisplay();
					checkRoom();
				}
			}
		});
		btnUp.setMargin(new Insets(2, 2, 2, 2));
		btnUp.setBounds(186, 291, 32, 23);
		layeredPane_4.add(btnUp);
		
		JButton btnRight = new JButton("Right");
		btnRight.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				if(!inCombat && movePlayer(2)){
					updateDisplay();
					checkRoom();
				}
			}
		});
		btnRight.setMargin(new Insets(2, 2, 2, 2));
		btnRight.setBounds(215, 307, 45, 23);
		layeredPane_4.add(btnRight);
		
		JButton btnLeft = new JButton("Left");
		btnLeft.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(!inCombat && movePlayer(4)){
					updateDisplay();
					checkRoom();
				}
			}
		});
		btnLeft.setMargin(new Insets(2, 2, 2, 2));
		btnLeft.setBounds(149, 307, 39, 23);
		layeredPane_4.add(btnLeft);
		
		lblImage = new JLabel("");
		lblImage.setIcon(new ImageIcon(GUI.class.getResource("/assets/Rooms/Finalroom.jpg")));
		lblImage.setBounds(0, 0, 613, 353);
		layeredPane_4.add(lblImage);
		
		updateDisplay();
	}
	
	void updateDisplay(){
		//sets room picture
		if(map.worldMap[playerCharacter.getXPos()][playerCharacter.getYPos()].resident == null)
			lblImage.setIcon(new ImageIcon(new ImageIcon(GUI.class.getResource("/assets/Rooms/Finalroom.jpg")).getImage().getScaledInstance(613, 353, Image.SCALE_DEFAULT)));
		else{
			if(map.worldMap[playerCharacter.getXPos()][playerCharacter.getYPos()].resident instanceof Goblin){
				lblImage.setIcon(new ImageIcon(new ImageIcon(GUI.class.getResource("/assets/Monsters/Goblin.jpg")).getImage().getScaledInstance(613, 353, Image.SCALE_DEFAULT)));
			}
			if(map.worldMap[playerCharacter.getXPos()][playerCharacter.getYPos()].resident instanceof CaveTroll){
				lblImage.setIcon(new ImageIcon(new ImageIcon(GUI.class.getResource("/assets/Monsters/CaveTroll.jpg")).getImage().getScaledInstance(613, 353, Image.SCALE_DEFAULT)));
			}
			if(map.worldMap[playerCharacter.getXPos()][playerCharacter.getYPos()].resident instanceof HobGoblin){
				lblImage.setIcon(new ImageIcon(new ImageIcon(GUI.class.getResource("/assets/Monsters/Hobgoblin.jpg")).getImage().getScaledInstance(613, 353, Image.SCALE_DEFAULT)));
			}
			if(map.worldMap[playerCharacter.getXPos()][playerCharacter.getYPos()].resident instanceof MountainTroll){
				lblImage.setIcon(new ImageIcon(new ImageIcon(GUI.class.getResource("/assets/Monsters/MountainTroll.jpg")).getImage().getScaledInstance(613, 353, Image.SCALE_DEFAULT)));
			}
		}
		//sets player status
		playerNameLabel.setText(playerCharacter.getName());
		playerAttackLabel.setText(String.valueOf(playerCharacter.getStrength()));
		playerHealthLabel.setText(String.valueOf(playerCharacter.getHP()));
		playerScoreLabel.setText(String.valueOf(playerCharacter.getScore()));
		playerLvlLabel.setText(String.valueOf(playerCharacter.getLvl()));
		playerArmorLabel.setText(String.valueOf(playerCharacter.getArmor()));
		playerManaLabel.setText(String.valueOf(playerCharacter.getMana()));
		//sets minimap
		minimappanel.repaint();
	}
	
	void setPlayerStart(){
		for(int i = 0; i < map.worldMap.length;i++){
			for(int k = 0; k <map.worldMap[0].length;k++){
				if(map.worldMap[i][k]!= null && map.worldMap[i][k].isStart){
					playerCharacter.setXPos(i);
					playerCharacter.setYPos(k);
					return;
				}
			}	
		}
	}
	
	boolean movePlayer(int direction){
		lastXPos = playerCharacter.getXPos();
		lastYPos = playerCharacter.getYPos();
		switch(direction){
		case 1://down of minimap
			if(map.worldMap[playerCharacter.getXPos()][playerCharacter.getYPos()+1]!= null && map.worldMap[playerCharacter.getXPos()][playerCharacter.getYPos()+1].connectedToStart){
				map.worldMap[playerCharacter.getXPos()][playerCharacter.getYPos()+1].beenVisited = true;
				playerCharacter.setYPos(playerCharacter.getYPos()+1);
				return true;
			}	
			break;
		case 2://right on minimap
			if(map.worldMap[playerCharacter.getXPos()+1][playerCharacter.getYPos()]!= null  &&map.worldMap[playerCharacter.getXPos()+1][playerCharacter.getYPos()].connectedToStart ){
				map.worldMap[playerCharacter.getXPos()+1][playerCharacter.getYPos()].beenVisited = true;
				playerCharacter.setXPos(playerCharacter.getXPos()+1);
				return true;
			}	
			break;
		case 3://up on minimap
			if(map.worldMap[playerCharacter.getXPos()][playerCharacter.getYPos()-1]!= null && map.worldMap[playerCharacter.getXPos()][playerCharacter.getYPos()-1].connectedToStart){
				map.worldMap[playerCharacter.getXPos()][playerCharacter.getYPos()-1].beenVisited = true;
				playerCharacter.setYPos(playerCharacter.getYPos()-1);
				return true;
			}
			break;
		case 4://left on minimap
			if(map.worldMap[playerCharacter.getXPos()-1][playerCharacter.getYPos()]!= null && map.worldMap[playerCharacter.getXPos()-1][playerCharacter.getYPos()].connectedToStart){
				map.worldMap[playerCharacter.getXPos()-1][playerCharacter.getYPos()].beenVisited = true;
				playerCharacter.setXPos(playerCharacter.getXPos()-1);
				return true;
			}	
			break;
		}
		return false;
	}
	
	void checkRoom(){
		if(map.worldMap[playerCharacter.getXPos()][playerCharacter.getYPos()].resident!=null)
			combatPhase();
		else if(map.worldMap[playerCharacter.getXPos()][playerCharacter.getYPos()].loot != null)
			pickupLoot();
		else if(map.worldMap[playerCharacter.getXPos()][playerCharacter.getYPos()].hasStairs)
			nextFloor();
	}
	
	void combatPhase(){
		inCombat = true;		
		enemy = map.worldMap[playerCharacter.getXPos()][playerCharacter.getYPos()].resident;
		if(playerCharacter.getSpeed()+num.nextInt(10) < enemy.getSpeed()+num.nextInt(10))
			enemyTurn();
		
	}
	
	void playerAttack(){
		int damageValue = playerCharacter.getStrength() + num.nextInt(((Sword)playerCharacter.getFromInventory(0)).damageValue) - enemy.getArmor();
		if(damageValue>0)
			enemy.editHP(-1*damageValue);
		if(enemy.getHP() < 1){
			combatOver();
		}
		else{
			if(damageValue>0)
				JOptionPane.showConfirmDialog(null, "You gave " + damageValue + " damage!" ,"You attacked!",JOptionPane.OK_OPTION);
			else
				JOptionPane.showConfirmDialog(null, "You did no damage!" ,"You attacked!",JOptionPane.OK_OPTION);
			enemyTurn();
		}
	}
	
	void magicAttack(){
		if(playerCharacter.getMana() < 5){
			JOptionPane.showConfirmDialog(null, "You don't have enough mana to cast a spell!" ,"Spell Failed!",JOptionPane.OK_OPTION);
			return;
		}
		int damageValue = num.nextInt(15);
		enemy.editHP(-1*damageValue);
		playerCharacter.editMana(-5);
		if(enemy.getHP() < 1){
			combatOver();
		}
		else{
			JOptionPane.showConfirmDialog(null, "You gave " + damageValue + " of magic damage!" ,"You cast a spell!",JOptionPane.OK_OPTION);
			enemyTurn();
		}
	}
	
	void enemyTurn(){
		int damageValue = enemy.getAttack() + num.nextInt(enemy.getAttackVariance()) - playerCharacter.getArmor();
		if(damageValue>0)
			playerCharacter.editHP(-1*damageValue);
		if(playerCharacter.getHP() < 1)
			gameOver();
		else{
			if(damageValue>0)
				JOptionPane.showConfirmDialog(null, "You took " + damageValue + " damage!" ,"You took damage!",JOptionPane.OK_OPTION);
			else
				JOptionPane.showConfirmDialog(null, "You dodged all the damage!" ,"You took damage!",JOptionPane.OK_OPTION);
		}
		updateDisplay();
	}
	
	void combatOver(){
		playerCharacter.addXp(enemy.expWorth);
		playerCharacter.editScore(enemy.expWorth);
		map.worldMap[playerCharacter.getXPos()][playerCharacter.getYPos()].resident = null;
		if(map.worldMap[playerCharacter.getXPos()][playerCharacter.getYPos()].loot != null)//checks for item drops
			pickupLoot();
		inCombat = false;
		enemy = null;
		updateDisplay();
		checkRoom();
	}
	
	void pickupLoot(){
		Item drop = map.worldMap[playerCharacter.getXPos()][playerCharacter.getYPos()].loot;
		JOptionPane.showConfirmDialog(null, "You picked up a " + drop.getItemName() +"!" ,"You got an item!",JOptionPane.OK_OPTION);
		if(drop.getItemType() == 0){//checks to see if the item is a weapon
			if(playerCharacter.getFromInventory(0).getItemID() < drop.getItemID())
				playerCharacter.addToInventory(0, drop);
			else
				JOptionPane.showConfirmDialog(null, "You have a better Sword than that!\nDropping..","You got an item!",JOptionPane.OK_OPTION);
		}
		if(drop.getItemType() == 1){//checks to see if item is a potion.
			if(!playerCharacter.addToInventory(drop))
				playerCharacter.drinkPotion(drop);//drinks potion if there are no inventory slots left
		}
		if(drop.getItemType() == 2){//checks to see if item is a armor
			if(playerCharacter.getFromInventory(1).getItemID() < drop.getItemID())
				playerCharacter.addToInventory(1, drop);
			else
				JOptionPane.showConfirmDialog(null, "You have better Armor than that!\nDropping..","You got an item!",JOptionPane.OK_OPTION);
		}
		map.worldMap[playerCharacter.getXPos()][playerCharacter.getYPos()].loot = null;
	}
	
	void nextFloor(){
		map = new World(5);	
		map.genWorld();
		setPlayerStart();
		playerCharacter.editScore(10);
		updateDisplay();
	}
	
	void gameOver(){
		int response = JOptionPane.showConfirmDialog(null, "Game over!\nTotal Score: " + playerCharacter.getScore() + "\nWould you like to play again?","Game Over!",JOptionPane.YES_NO_OPTION);
		if(response == JOptionPane.YES_OPTION){
			playerCharacter = new Player(playerCharacter.getName(), map.getDifficulty());
			map = new World(map.getDifficulty());
			map.genWorld();
			setPlayerStart();
			updateDisplay();
			inCombat = false;
		}
		else
			System.exit(0);
	}
	
	public class mapPanel extends JPanel{
		public mapPanel(){	
		}
		protected void paintComponent(Graphics g){
			super.paintComponent(g);
			int ycoord= 1, xcoord = 1;
			for(int i = 1; i < map.worldMap.length;i++){
				xcoord = 1;
				for(int k = 1; k < map.worldMap[0].length;k++){
					g.drawRect(ycoord, xcoord, 12, 12);
					g.setColor(Color.black);
					if(map.worldMap[i][k]!= null && map.worldMap[i][k].connectedToStart)
						g.setColor(Color.gray);
					if(map.worldMap[i][k]!= null && map.worldMap[i][k].hasStairs)
						g.setColor(Color.white);
					if(i == playerCharacter.getXPos() && k == playerCharacter.getYPos())
						g.setColor(Color.green);
					g.fillRect(ycoord, xcoord, 12, 12);
					g.setColor(Color.black);
					xcoord += 14;
				}
				ycoord += 14;
			}
		}
	}
}
