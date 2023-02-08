import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Calculator {

	private JFrame frame;
	private JTextField firstNumber;
	private JTextField secondNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.PINK);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		firstNumber = new JTextField();
		firstNumber.setBounds(127, 29, 133, 23);
		frame.getContentPane().add(firstNumber);
		firstNumber.setColumns(10);
		
		secondNumber = new JTextField();
		secondNumber.setBackground(Color.WHITE);
		secondNumber.setBounds(127, 63, 133, 23);
		frame.getContentPane().add(secondNumber);
		secondNumber.setColumns(10);
		
		JLabel lblInstruction2 = new JLabel("Second Number");
		lblInstruction2.setBounds(21, 63, 133, 23);
		frame.getContentPane().add(lblInstruction2);
		
		JLabel lblResult = new JLabel("RESULT");
		lblResult.setBackground(Color.WHITE);
		lblResult.setOpaque(true);
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setBounds(284, 44, 85, 23);
		frame.getContentPane().add(lblResult);
		
		JButton btnDivision = new JButton("\u00F7");
		btnDivision.setBackground(Color.WHITE);
		btnDivision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double var1 = Double.parseDouble(firstNumber.getText());
				double var2 = Double.parseDouble(secondNumber.getText());
				double result = var1 / var2;
				
				lblResult.setText(String.valueOf(result));
			}
		});
		btnDivision.setBounds(90, 133, 108, 53);
		frame.getContentPane().add(btnDivision);
		
		
		
		JButton btnMultiplication = new JButton("\u00D7");
		btnMultiplication.setBackground(Color.WHITE);
		btnMultiplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double var1 = Double.parseDouble(firstNumber.getText());
				double var2 = Double.parseDouble(secondNumber.getText());
				double result = var1 * var2;
				
				lblResult.setText(String.valueOf(result));
			}
		});
		btnMultiplication.setBounds(90, 188, 108, 53);
		frame.getContentPane().add(btnMultiplication);
		
		
		
		JButton btnSubtraction = new JButton("\u2212");
		btnSubtraction.setBackground(Color.WHITE);
		btnSubtraction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double var1 = Double.parseDouble(firstNumber.getText());
				double var2 = Double.parseDouble(secondNumber.getText());
				double result = var1 - var2;
				
				lblResult.setText(String.valueOf(result));
			}
		});
		btnSubtraction.setBounds(208, 133, 106, 53);
		frame.getContentPane().add(btnSubtraction);
		
		JButton btnAddtion = new JButton("+");
		btnAddtion.setBackground(Color.WHITE);
		btnAddtion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double var1 = Double.parseDouble(firstNumber.getText());
				double var2 = Double.parseDouble(secondNumber.getText());
				double result = var1 + var2;
				
				lblResult.setText(String.valueOf(result));
			}
		});
		btnAddtion.setBounds(208, 188, 106, 53);
		frame.getContentPane().add(btnAddtion);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBackground(Color.WHITE);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNumber.setText(null);
				secondNumber.setText(null);
				lblResult.setText("RESULT");
			}
		});
		btnClear.setBounds(321, 133, 75, 108);
		frame.getContentPane().add(btnClear);
		
		JLabel lblInstruction1 = new JLabel("First Number");
		lblInstruction1.setBounds(21, 29, 96, 23);
		frame.getContentPane().add(lblInstruction1);
		
		
	}
}
