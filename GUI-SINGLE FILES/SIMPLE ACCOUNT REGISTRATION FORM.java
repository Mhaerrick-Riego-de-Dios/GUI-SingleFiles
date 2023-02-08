import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFname;
	private JTextField textLname;
	private JTextField textEmail;
	private JButton btnshow;
	private JButton btnshow1;
	private JButton btnregister;
	private boolean isHidden=true;
	private JPasswordField txtpassword;
	private JPasswordField textpass;
	private int Counter = 0;

	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Main() {
		setBackground(Color.PINK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 333);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("FIRST NAME");
		lblNewLabel.setFont(new Font("Agency FB", Font.PLAIN, 14));
		lblNewLabel.setBounds(26, 68, 81, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("LAST NAME");
		lblNewLabel_1.setFont(new Font("Agency FB", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(26, 36, 81, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("EMAIL");
		lblNewLabel_2.setFont(new Font("Agency FB", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(26, 100, 46, 21);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("PASSWORD");
		lblNewLabel_3.setFont(new Font("Agency FB", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(26, 134, 101, 21);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("RE-TYPE PASSWORD");
		lblNewLabel_4.setFont(new Font("Agency FB", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(26, 166, 130, 21);
		contentPane.add(lblNewLabel_4);
		
		textFname = new JTextField();
		textFname.setFont(new Font("Agency FB", Font.PLAIN, 14));
		textFname.setBounds(96, 64, 202, 23);
		contentPane.add(textFname);
		textFname.setColumns(10);
		
		textLname = new JTextField();
		textLname.setFont(new Font("Agency FB", Font.PLAIN, 14));
		textLname.setColumns(10);
		textLname.setBounds(96, 34, 202, 23);
		contentPane.add(textLname);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("Agency FB", Font.PLAIN, 14));
		textEmail.setColumns(10);
		textEmail.setBounds(96, 98, 267, 23);
		contentPane.add(textEmail);
		
		btnshow = new JButton("SHOW");
		btnshow.setFont(new Font("Agency FB", Font.PLAIN, 14));
		btnshow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isHidden) {
					txtpassword.setEchoChar((char)0);
					btnshow.setText("HIDE");
				}else {
					txtpassword.setEchoChar('*');
					btnshow.setText("SHOW");
				}
				
				isHidden= !isHidden;
				
			}
		});
		btnshow.setBounds(381, 132, 81, 23);
		contentPane.add(btnshow);
		
		btnshow1 = new JButton("SHOW");
		btnshow1.setFont(new Font("Agency FB", Font.PLAIN, 14));
		btnshow1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isHidden) {
					textpass.setEchoChar((char)0);
					btnshow1.setText("HIDE");
				}else {
					textpass.setEchoChar('*');
					btnshow1.setText("SHOW");
				}
				
				isHidden= !isHidden;
			}
		});
		btnshow1.setBounds(381, 164, 81, 23);
		contentPane.add(btnshow1);
		
		btnregister = new JButton("REGISTER");
		btnregister.setFont(new Font("Agency FB", Font.PLAIN, 20));
		btnregister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a =(textFname.getText());
				String b =(textLname.getText());
				String c =(textEmail.getText());
				@SuppressWarnings("deprecation")
				String p =(txtpassword.getText());
				@SuppressWarnings("deprecation")
				String r =(textpass.getText());
				for(int i = 0; i<p.length(); i++) {
					if (!Character.isLetterOrDigit(p.charAt(i))) {
						break;
					}else if(Character.isDefined(i)) {
						Counter++;
						if(Counter==2) {
							break;
						}
						
					}
					
				}
				
				while(true) {
					
					if (a.isBlank()) {
						JOptionPane.showInternalMessageDialog(null, "ENTER YOUR FIRST NAME");
						break;
					}
					else if  (b.isBlank()) {
						JOptionPane.showInternalMessageDialog(null, "ENTER YOUR LAST NAME");
						break;
					}
					else if  (c.isBlank()) {
						JOptionPane.showInternalMessageDialog(null, "ENTER YOUR EMAIL");
						break;
					}
					else if  (!c.contains("@gmail.com")) {
						JOptionPane.showMessageDialog(null, "INVALID EMAIL");
						break;
					}
					else if  (p.length() <10) {
						if(Counter != 2) {
						JOptionPane.showMessageDialog(null, "PASSWORD MUST CONTAIN ATLEAST 10 CHARACTERS AND 2 DIGITS");
						break;
						}
					}
					else if (!r.equals(p)) {
						JOptionPane.showMessageDialog(null, "PASSWORD NOT MUST BE THE SAME");
						break;
					}
					else {
						JOptionPane.showMessageDialog(null, "REGISTERED SUCCESFULLY\n\n"+ "NAME:" + a + " " + b +"\n"+  "EMAIL:" + c + "\n" + "PASSWORD:" + p);
						break;
					}	
				}
				}
		});
		btnregister.setBounds(178, 209, 121, 42);
		contentPane.add(btnregister);
		
		txtpassword = new JPasswordField();
		txtpassword.setFont(new Font("Agency FB", Font.PLAIN, 14));
		txtpassword.setEchoChar('*');
		txtpassword.setBounds(96, 132, 267, 23);
		contentPane.add(txtpassword);
		
		textpass = new JPasswordField();
		textpass.setFont(new Font("Agency FB", Font.PLAIN, 14));
		textpass.setEchoChar('*');
		textpass.setBounds(141, 164, 222, 23);
		contentPane.add(textpass);
	}
}
