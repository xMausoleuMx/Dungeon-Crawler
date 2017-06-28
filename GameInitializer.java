import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameInitializer extends JFrame {

	private JPanel contentPane;
	private JTextField playerName;
	private JComboBox difficultySelect;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameInitializer frame = new GameInitializer();
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
	public GameInitializer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 260, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblEnterYourCharacter = new JLabel("Enter your Character Name:");
		
		playerName = new JTextField();
		playerName.setColumns(10);
		
		difficultySelect = new JComboBox();
		difficultySelect.setModel(new DefaultComboBoxModel(new String[] {"Easy", "Normal", "Hard", "Insane"}));
		
		JLabel lblChooseTheDifficulty = new JLabel("Choose the difficulty:");
		
		JButton contButton = new JButton("Continue");
		contButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				if(getName() ==null)
					JOptionPane.showConfirmDialog(null, "You need to enter a name!" ,"Error",JOptionPane.OK_OPTION);
				else
					System.out.println(getDifficulty());
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEnterYourCharacter)
						.addComponent(lblChooseTheDifficulty))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(contButton, Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
						.addComponent(difficultySelect, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(playerName))
					.addContainerGap(192, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterYourCharacter)
						.addComponent(playerName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(difficultySelect, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblChooseTheDifficulty))
					.addGap(18)
					.addComponent(contButton)
					.addContainerGap(149, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public String getName(){
		return playerName.getText();
	}
	
	public int getDifficulty(){
		return difficultySelect.getSelectedIndex();
	}
}
