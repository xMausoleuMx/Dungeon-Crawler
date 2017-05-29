import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
public class GUI extends JFrame {

	private JPanel contentPane;
	private Player playerCharacter;
	private World map;
	private boolean inCombat = false;
	private JLabel lblImage, playerHealthLabel, playerAttackLabel, playerArmorLabel, playerScoreLabel, playerLvlLabel, playerNameLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Player holder = new Player("test");
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
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setForeground(Color.BLACK);
		layeredPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		layeredPane.setBackground(Color.PINK);
		layeredPane.setBounds(10, 301, 150, 140);
		contentPane.add(layeredPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setIcon(new ImageIcon("D:\\Coding\\Dungeon Crawler\\assets\\Character\\black.png"));
		lblNewLabel.setBounds(0, 0, 150, 140);
		layeredPane.add(lblNewLabel);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBorder(new LineBorder(Color.BLACK, 2));
		layeredPane_1.setBounds(159, 361, 314, 40);
		contentPane.add(layeredPane_1);
		
		JLabel lblInv = new JLabel("");
		lblInv.setIcon(new ImageIcon("D:\\Coding\\Dungeon Crawler\\assets\\Character\\Inv.png"));
		lblInv.setBounds(0, 0, 314, 38);
		layeredPane_1.add(lblInv);
		
		JLayeredPane layeredPane_2 = new JLayeredPane();
		layeredPane_2.setBorder(new LineBorder(Color.BLACK, 2));
		layeredPane_2.setBackground(Color.PINK);
		layeredPane_2.setBounds(473, 301, 150, 140);
		contentPane.add(layeredPane_2);
		
		JLabel lblPlayersprite = new JLabel("");
		layeredPane_2.setLayer(lblPlayersprite, 1);
		lblPlayersprite.setIcon(new ImageIcon("D:\\Coding\\Dungeon Crawler\\assets\\Character\\Nakedsprite.png"));
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
		lblScore.setBounds(55, 115, 46, 14);
		layeredPane_2.add(lblScore);
		
		JLabel lblLvl = new JLabel("LvL:");
		lblLvl.setForeground(Color.WHITE);
		lblLvl.setBounds(94, 11, 20, 14);
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
		playerScoreLabel.setBounds(94, 115, 46, 14);
		layeredPane_2.add(playerScoreLabel);
		
		playerNameLabel = new JLabel("");
		playerNameLabel.setForeground(Color.WHITE);
		playerNameLabel.setBounds(10, 11, 79, 14);
		layeredPane_2.add(playerNameLabel);
		
		playerLvlLabel = new JLabel("0");
		playerLvlLabel.setForeground(Color.WHITE);
		playerLvlLabel.setBounds(120, 11, 20, 14);
		layeredPane_2.add(playerLvlLabel);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon("D:\\Coding\\Dungeon Crawler\\assets\\Character\\black.png"));
		lblBackground.setBounds(0, 0, 150, 140);
		layeredPane_2.add(lblBackground);
		
		JLayeredPane layeredPane_3 = new JLayeredPane();
		layeredPane_3.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		layeredPane_3.setBounds(159, 401, 314, 40);
		contentPane.add(layeredPane_3);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Coding\\Dungeon Crawler\\assets\\Character\\Inv.png"));
		lblNewLabel_1.setBounds(0, 0, 314, 40);
		layeredPane_3.add(lblNewLabel_1);
		
		JLayeredPane layeredPane_4 = new JLayeredPane();
		layeredPane_4.setBorder(new LineBorder(Color.RED, 2));
		layeredPane_4.setBounds(10, 11, 613, 353);
		contentPane.add(layeredPane_4);
		
		JButton btnAttack = new JButton("Attack");
		btnAttack.setBounds(392, 291, 71, 23);
		layeredPane_4.add(btnAttack);
		
		JButton btnRun = new JButton("Run");
		btnRun.setBounds(392, 319, 71, 23);
		layeredPane_4.add(btnRun);
		
		JButton btnDown = new JButton("Down");
		btnDown.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!inCombat && movePlayer(3)){
					playerCharacter.setYPos(playerCharacter.getYPos()-1);
					updateDisplay();
					if(map.worldMap[playerCharacter.getXPos()][playerCharacter.getYPos()].resident!=null)
						combatPhase();
				}
			}
		});
		btnDown.setMargin(new Insets(2, 2, 2, 2));
		btnDown.setBounds(181, 330, 37, 23);
		layeredPane_4.add(btnDown);
		
		JButton btnUp = new JButton("Up");
		btnUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(!inCombat && movePlayer(1)){
					playerCharacter.setYPos(playerCharacter.getYPos()+1);
					updateDisplay();
					if(map.worldMap[playerCharacter.getXPos()][playerCharacter.getYPos()].resident!=null)
						combatPhase();
				}
			}
		});
		btnUp.setMargin(new Insets(2, 2, 2, 2));
		btnUp.setBounds(186, 291, 32, 23);
		layeredPane_4.add(btnUp);
		
		JButton btnRight = new JButton("Right");
		btnRight.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(!inCombat && movePlayer(2)){
					playerCharacter.setXPos(playerCharacter.getXPos()+1);
					updateDisplay();
					if(map.worldMap[playerCharacter.getXPos()][playerCharacter.getYPos()].resident!=null)
						combatPhase();
				}
			}
		});
		btnRight.setMargin(new Insets(2, 2, 2, 2));
		btnRight.setBounds(215, 307, 45, 23);
		layeredPane_4.add(btnRight);
		
		JButton btnLeft = new JButton("Left");
		btnLeft.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!inCombat && movePlayer(4)){
					playerCharacter.setXPos(playerCharacter.getXPos()-1);
					updateDisplay();
					if(map.worldMap[playerCharacter.getXPos()][playerCharacter.getYPos()].resident!=null)
						combatPhase();
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
	
	public void updateDisplay(){
		//sets room picture
		if(map.worldMap[playerCharacter.getXPos()][playerCharacter.getYPos()].resident == null)
			lblImage.setIcon(new ImageIcon(new ImageIcon("D:\\Coding\\Dungeon Crawler\\assets\\Rooms\\Finalroom.jpg").getImage().getScaledInstance(613, 353, Image.SCALE_DEFAULT)));
		else{
			if(map.worldMap[playerCharacter.getXPos()][playerCharacter.getYPos()].resident instanceof Goblin){
				lblImage.setIcon(new ImageIcon(GUI.class.getResource("/assets/Monsters/Goblin.jpg")));
				System.out.println("itsagoblin");
			}
			if(map.worldMap[playerCharacter.getXPos()][playerCharacter.getYPos()].resident instanceof CaveTroll){
				lblImage.setIcon(new ImageIcon(GUI.class.getResource("/assets/Monsters/CaveTroll.jpg")));
				System.out.println("itsagoblin");
			}
			if(map.worldMap[playerCharacter.getXPos()][playerCharacter.getYPos()].resident instanceof HobGoblin){
				lblImage.setIcon(new ImageIcon(GUI.class.getResource("/assets/Monsters/Hobgoblin.jpg")));
				System.out.println("itsagoblin");
			}
			if(map.worldMap[playerCharacter.getXPos()][playerCharacter.getYPos()].resident instanceof MountainTroll){
				lblImage.setIcon(new ImageIcon(GUI.class.getResource("/assets/Monsters/MountainTroll.jpg")));
				System.out.println("itsagoblin");
			}
		}
		//sets player status
		playerNameLabel.setText(playerCharacter.getName());
		playerAttackLabel.setText(String.valueOf(playerCharacter.getStrength()));
		playerHealthLabel.setText(String.valueOf(playerCharacter.getHP()));
		playerArmorLabel.setText(String.valueOf(playerCharacter.getStrength()));
		playerLvlLabel.setText(String.valueOf(playerCharacter.getLvl()));
		//sets minimap
		
	}
	
	public boolean movePlayer(int direction){
		switch(direction){
		case 1:
			if(map.worldMap[playerCharacter.getXPos()][playerCharacter.getYPos()+1]!= null && playerCharacter.getYPos()+1 < 10){
				playerCharacter.setYPos(playerCharacter.getYPos()+1);
				System.out.println("movednorth");
				return true;
			}	
			break;
		case 2:
			if(map.worldMap[playerCharacter.getXPos()+1][playerCharacter.getYPos()]!= null && playerCharacter.getXPos()+1 < 10){
				playerCharacter.setXPos(playerCharacter.getXPos()+1);
				System.out.println("movedeast");
				return true;
			}	
			break;
		case 3:
			if(map.worldMap[playerCharacter.getXPos()][playerCharacter.getYPos()-1]!= null && playerCharacter.getYPos()-1 > 1){
				playerCharacter.setYPos(playerCharacter.getYPos()-1);
				System.out.println("movedsouth");
				return true;
			}
			break;
		case 4:
			if(map.worldMap[playerCharacter.getXPos()-1][playerCharacter.getYPos()]!= null && playerCharacter.getXPos()-1 > 1){
				playerCharacter.setXPos(playerCharacter.getXPos()-1);
				System.out.println("movedWest");
				return true;
			}	
			break;
		}
		return false;
	}
	
	public void combatPhase(){
		inCombat = true;
		Monster enemy = map.worldMap[playerCharacter.getXPos()][playerCharacter.getYPos()].resident;
		while(enemy.getHP() > 1 && playerCharacter.getHP() > 1){
			
		}
		if(playerCharacter.getHP() < 1)
			gameOver();
		if(enemy.getHP() < 1){
			playerCharacter.addXp(enemy.expWorth);
			playerCharacter.editScore(enemy.expWorth);
			if(map.worldMap[playerCharacter.getXPos()][playerCharacter.getYPos()].loot != null){
				
			}
		}
		inCombat = false;
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
	
	void nextFloor(){
		
		
		updateDisplay();
	}
	
	void gameOver(){
		
	}
}
