package guessmynumbergame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class guessmynumbergame {

	private JFrame frame;
	private JTextField playerguessing;
	JLabel gamerandom = new JLabel("");
	int random;
	int chance=5;
	JLabel gamecommants = new JLabel("");

	private final JLabel balchance = new JLabel(String.valueOf(chance));
	private final JLabel lblNewLabel = new JLabel("Guess My Number Game");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guessmynumbergame window = new guessmynumbergame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws InterruptedException 
	 */
	public guessmynumbergame() throws InterruptedException {
		
	JOptionPane.showMessageDialog(null, "A Game is - I am computer when I guess one number 1 to 100 , So you will find my number within 5 Guess");

		initialize();
		gamerandom();
		
	
	
     
		
	}
	
	void gamerandom() throws InterruptedException {
		
		Random ran=new Random();
		
		random=ran.nextInt(101);
		
		gamerandom.setForeground(new Color(0, 255, 0));
		

	}
	
	
	void stop() {

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.CYAN);
		frame.getContentPane().setBackground(Color.GRAY);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 255, 0), 5));
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 92, 593, 399);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		playerguessing = new JTextField();
		playerguessing.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				playerguessing.setBorder(BorderFactory.createLineBorder(Color.green,4));	
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				playerguessing.setBorder(BorderFactory.createEmptyBorder());
			}
			
			
		});
		playerguessing.setForeground(new Color(255, 255, 255));
		playerguessing.setHorizontalAlignment(SwingConstants.CENTER);
		playerguessing.setBackground(new Color(0, 0, 0));
		playerguessing.addKeyListener(new KeyAdapter() {
						
			public void keyReleased(KeyEvent e) {
				
				gamecommants.setText("");
				String check=playerguessing.getText();
				
				Pattern p=Pattern.compile("[0-9]");
				Matcher m=p.matcher(check);
				
			if(m.find()) {
				
				
				int intcheck=Integer.valueOf(check);

				if(intcheck<=100) {
					
					
					if(e.getKeyCode()==KeyEvent.VK_ENTER) {
						
						int playerguess=Integer.valueOf(playerguessing.getText());

						if(playerguess!=random) {
							
					/*gamerandom.setText("Your Last Guessing - "+playerguessing.getText());
					gamerandom.setForeground(Color.WHITE);*/
							
						}
						
						chance--;
						
						balchance.setText(String.valueOf(chance));
						
						
						
						if(playerguess==random) {						
							gamecommants.setText("Your Win !!!");
					    	gamerandom.setText("My Guess Number is - "+String.valueOf(random));
							playerguessing.setText("");
							playerguessing.requestFocus();
//							JOptionPane.showConfirmDialog(null, "Play again");

						}	
						else if(chance==0) {
							
							gamecommants.setText("Your Lose !!! ");	
							playerguessing.setText("");
							gamerandom.setText("My Guess Number is - "+String.valueOf(random));

//							JOptionPane.showConfirmDialog(null, "Play again");

						}
						else if(playerguess>=random-3&&playerguess<=random+3) {						
							gamecommants.setText("So Closer !!!");	
						playerguessing.setText("");
							playerguessing.requestFocus();
						}
						else if(playerguess>random) {
							
							gamecommants.setText("Think Smaller !!!");
							playerguessing.setText("");
							playerguessing.requestFocus();	
						}
							
						else if(playerguess<random)
						{
							gamecommants.setText("Think Bigger !!!");
							playerguessing.setText("");
							playerguessing.requestFocus();	
						}
							
						
						
					}
					

					
	
				}
				else {
					
					JOptionPane.showMessageDialog(null, "Less then 101");
					playerguessing.setText("");
					playerguessing.requestFocus();  
				}
				
				
			}
			else {
				
				JOptionPane.showMessageDialog(null, "Enter only number");
				playerguessing.setText("");
				playerguessing.requestFocus();
			}
				
				
			

			}
			
		});
		playerguessing.setFont(new Font("Times New Roman", Font.BOLD, 50));
		playerguessing.setBounds(135, 204, 330, 68);
		panel.add(playerguessing);
		playerguessing.setColumns(10);
		
		gamerandom.setFont(new Font("Times New Roman", Font.BOLD, 50));
		gamerandom.setBounds(20, 283, 563, 82);
		panel.add(gamerandom);
		balchance.setForeground(new Color(255, 0, 0));
		balchance.setFont(new Font("Times New Roman", Font.BOLD, 28));
		balchance.setBounds(297, 152, 92, 41);
		
		panel.add(balchance);
		
		JLabel lblBalanceChance = new JLabel("Balance Chance");
		lblBalanceChance.setForeground(new Color(255, 255, 0));
		lblBalanceChance.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblBalanceChance.setBounds(229, 106, 185, 59);
		panel.add(lblBalanceChance);
		
		gamecommants.setForeground(new Color(255, 255, 255));
		gamecommants.setFont(new Font("Times New Roman", Font.BOLD, 48));
		gamecommants.setBounds(152, 26, 431, 82);
		panel.add(gamecommants);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 23));
		btnNewButton.setBorder(new LineBorder(Color.WHITE, 3));
		btnNewButton.setBounds(475, 220, 108, 41);
		panel.add(btnNewButton);
		
		JButton btnStart = new JButton("Restart");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chance=5;
				balchance.setText("5");
				gamecommants.setText("");	
				playerguessing.setText("");
				gamerandom.setText("");
				try {
					gamerandom();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnStart.setForeground(Color.BLACK);
		btnStart.setFont(new Font("Times New Roman", Font.BOLD, 23));
		btnStart.setBorder(new LineBorder(Color.YELLOW, 3));
		btnStart.setBackground(Color.YELLOW);
		btnStart.setBounds(10, 220, 113, 41);
		panel.add(btnStart);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 593, 81);
		frame.getContentPane().add(panel_1);
		panel_1.setBorder(new LineBorder(Color.GREEN, 3));
		panel_1.setBackground(Color.BLACK);
		panel_1.setLayout(null);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(35, 11, 537, 62);
		panel_1.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(0, 255, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 48));
		frame.setBounds(100, 100, 610, 530);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
