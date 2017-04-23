import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
public class GUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
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
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBorder(new LineBorder(Color.BLACK, 2));
		layeredPane_1.setBounds(159, 361, 314, 40);
		contentPane.add(layeredPane_1);
		
		JLayeredPane layeredPane_2 = new JLayeredPane();
		layeredPane_2.setBorder(new LineBorder(Color.BLACK, 2));
		layeredPane_2.setBackground(Color.PINK);
		layeredPane_2.setBounds(473, 301, 150, 140);
		contentPane.add(layeredPane_2);
		
		JLayeredPane layeredPane_3 = new JLayeredPane();
		layeredPane_3.setBorder(new LineBorder(Color.BLACK, 2));
		layeredPane_3.setBounds(159, 401, 314, 40);
		contentPane.add(layeredPane_3);
		
		JLayeredPane layeredPane_4 = new JLayeredPane();
		layeredPane_4.setBorder(new LineBorder(Color.RED, 2));
		layeredPane_4.setBounds(10, 11, 613, 353);
		contentPane.add(layeredPane_4);
		
		JLabel lblImage = new JLabel("");
		lblImage.setIcon(new ImageIcon(new ImageIcon("D:\\Coding\\Dungeon Crawler\\assets\\Finalroom.jpg").getImage().getScaledInstance(613, 353, Image.SCALE_DEFAULT)));
		lblImage.setBounds(0, 0, 613, 353);
		layeredPane_4.add(lblImage);
		
		
	}
}
