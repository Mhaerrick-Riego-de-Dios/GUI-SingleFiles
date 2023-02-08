import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.DropMode;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextArea textArea;

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
		setTitle("MILK TEA SHOP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 856, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(8, 8, 8, 8));
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("CUSTOMER NAME:");
		lblName.setBounds(10, 30, 125, 14);
		lblName.setFont(new Font("Agency FB", Font.BOLD, 18));
		contentPane.add(lblName);
		
		txtName = new JTextField();
		txtName.setBounds(127, 26, 255, 23);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblMilkTeaSize = new JLabel("Milk Tea Size:");
		lblMilkTeaSize.setBounds(132, 85, 109, 14);
		lblMilkTeaSize.setFont(new Font("Agency FB", Font.BOLD, 14));
		contentPane.add(lblMilkTeaSize);
		
		JLabel lblAdd = new JLabel("Add-ons:");
		lblAdd.setBounds(254, 85, 102, 14);
		lblAdd.setFont(new Font("Agency FB", Font.BOLD, 14));
		contentPane.add(lblAdd);
		
		JRadioButton rdoCapuccino = new JRadioButton("Capuccino");
		rdoCapuccino.setBounds(10, 132, 109, 23);
		rdoCapuccino.setFont(new Font("Agency FB", Font.PLAIN, 13));
		rdoCapuccino.setBackground(Color.PINK);
		contentPane.add(rdoCapuccino);
		
		JRadioButton rdoBlueberry = new JRadioButton("Blueberry");
		rdoBlueberry.setBounds(10, 106, 109, 23);
		rdoBlueberry.setFont(new Font("Agency FB", Font.PLAIN, 13));
		rdoBlueberry.setBackground(Color.PINK);
		rdoBlueberry.setSelected(true);
		contentPane.add(rdoBlueberry);
		
		JRadioButton rdoChocolate = new JRadioButton("Chocolate");
		rdoChocolate.setBounds(10, 158, 109, 23);
		rdoChocolate.setFont(new Font("Agency FB", Font.PLAIN, 13));
		rdoChocolate.setBackground(Color.PINK);
		contentPane.add(rdoChocolate);
		
		JRadioButton rdoVanilla = new JRadioButton("Vanilla");
		rdoVanilla.setBounds(10, 184, 109, 23);
		rdoVanilla.setFont(new Font("Agency FB", Font.PLAIN, 13));
		rdoVanilla.setBackground(Color.PINK);
		contentPane.add(rdoVanilla);
		
		JRadioButton rdoJavaChips = new JRadioButton("Java Chips");
		rdoJavaChips.setBounds(10, 210, 109, 23);
		rdoJavaChips.setFont(new Font("Agency FB", Font.PLAIN, 13));
		rdoJavaChips.setBackground(Color.PINK);
		contentPane.add(rdoJavaChips);
		
		JRadioButton rdoMedium = new JRadioButton("Medium");
		rdoMedium.setBounds(132, 106, 109, 23);
		rdoMedium.setFont(new Font("Agency FB", Font.PLAIN, 13));
		rdoMedium.setBackground(Color.PINK);
		rdoMedium.setSelected(true);
		contentPane.add(rdoMedium);
		
		JRadioButton rdoLarge = new JRadioButton("Large");
		rdoLarge.setBounds(132, 132, 109, 23);
		rdoLarge.setFont(new Font("Agency FB", Font.PLAIN, 13));
		rdoLarge.setBackground(Color.PINK);
		contentPane.add(rdoLarge);
		
		JRadioButton rdoExtraLarge = new JRadioButton("Extra Large");
		rdoExtraLarge.setBounds(132, 158, 109, 23);
		rdoExtraLarge.setFont(new Font("Agency FB", Font.PLAIN, 13));
		rdoExtraLarge.setBackground(Color.PINK);
		contentPane.add(rdoExtraLarge);
		
		//used to group flavors
		ButtonGroup rdoFlavorSelect = new ButtonGroup();
		rdoFlavorSelect.add(rdoBlueberry);
		rdoFlavorSelect.add(rdoCapuccino);
		rdoFlavorSelect.add(rdoChocolate);
		rdoFlavorSelect.add(rdoVanilla);
		rdoFlavorSelect.add(rdoJavaChips);
		
		//used to group sizes
		ButtonGroup rdoSizeSelect = new ButtonGroup();
		rdoSizeSelect.add(rdoMedium);
		rdoSizeSelect.add(rdoLarge);
		rdoSizeSelect.add(rdoExtraLarge);
		
		JCheckBox chkTapiocaPearls = new JCheckBox("Tapioca Pearls");
		chkTapiocaPearls.setBounds(254, 106, 128, 23);
		chkTapiocaPearls.setFont(new Font("Agency FB", Font.PLAIN, 13));
		chkTapiocaPearls.setBackground(Color.PINK);
		contentPane.add(chkTapiocaPearls);
		
		JCheckBox chkPoppingBoba = new JCheckBox("Popping Boba");
		chkPoppingBoba.setBounds(254, 132, 128, 23);
		chkPoppingBoba.setFont(new Font("Agency FB", Font.PLAIN, 13));
		chkPoppingBoba.setBackground(Color.PINK);
		contentPane.add(chkPoppingBoba);
		
		JCheckBox chkCreamCheese = new JCheckBox("Cream Cheese");
		chkCreamCheese.setBounds(254, 158, 128, 23);
		chkCreamCheese.setFont(new Font("Agency FB", Font.PLAIN, 13));
		chkCreamCheese.setBackground(Color.PINK);
		contentPane.add(chkCreamCheese);
		
		JCheckBox chkJellyToppings = new JCheckBox("Jelly Toppings");
		chkJellyToppings.setBounds(254, 184, 128, 23);
		chkJellyToppings.setFont(new Font("Agency FB", Font.PLAIN, 13));
		chkJellyToppings.setBackground(Color.PINK);
		contentPane.add(chkJellyToppings);
						
		JButton btnConfirm = new JButton("CONFIRM ORDER");
		btnConfirm.setBounds(10, 269, 158, 36);
		btnConfirm.setFont(new Font("Agency FB", Font.PLAIN, 16));
		btnConfirm.setBackground(Color.PINK);
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String name = txtName.getText();
				String flavor;
				String size;
				String addons = "";
				
				//condition in choosing flavor
				if(rdoBlueberry.isSelected()) {
					flavor = "Blueberry";
				}else if(rdoCapuccino.isSelected()) {
					flavor = "Capuccino";					
				}else if(rdoChocolate.isSelected()) {
					flavor = "Chocolate";
				}else if(rdoVanilla.isSelected()) {
					flavor = "Vanilla";
				}else {
					flavor = "Java Chips";
				}
				
				//condition in choosing size			
				if(rdoMedium.isSelected()) {
					size = "Medium";
				}else if(rdoLarge.isSelected()) {
					size = "Large";
				}else {
					size = "Extra Large";
				}
				
				//condition in choosing add-ons
				if(chkTapiocaPearls.isSelected()) {
					addons += chkTapiocaPearls.getText() + "\n" + "\t";
				}if(chkPoppingBoba.isSelected()) {
					addons += chkTapiocaPearls.getText() + "\n"+ "\t";
				}if(chkCreamCheese.isSelected()) {
					addons += chkCreamCheese.getText() + "\n" + "\t";
				}if(chkJellyToppings.isSelected()) {
					addons += chkJellyToppings.getText() + "\n" + "\t";	
				}
				
				//output
				textArea.append("ORDER SUMMARY" + "\n" + "\n" +
								"CUSTOMER NAME:  " + name + "\n" + "\n" +
								"Milk Tea Flavor:  " + flavor + "\n"  + "\n" +
								"Milk Tea Size:  " + size + "\n" + "\n" +
								"Add-ons:" + "\n" + "\t" + addons );
							
			}
		});
		contentPane.add(btnConfirm);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setBounds(209, 269, 158, 36);
		btnClear.setFont(new Font("Agency FB", Font.PLAIN, 16));
		btnClear.setBackground(Color.PINK);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textArea.setText(null); //used to clear the Text Area
				rdoBlueberry.setSelected(true); //used to set the default radio button in size
				rdoMedium.setSelected(true); //used to set the default radio button in size
				//used to clear all the checked checkbox
				chkTapiocaPearls.setSelected(false);
				chkPoppingBoba.setSelected(false);
				chkCreamCheese.setSelected(false);
				chkJellyToppings.setSelected(false);
				
			}
		});
		contentPane.add(btnClear);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(392, 30, 438, 275);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Agency FB", Font.PLAIN, 15));
		textArea.setTabSize(10);
		textArea.setBackground(Color.WHITE);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		
		JLabel lblMilkTeaFlavor = new JLabel("Milk Tea Flavor:");
		lblMilkTeaFlavor.setBounds(10, 85, 112, 14);
		lblMilkTeaFlavor.setFont(new Font("Agency FB", Font.BOLD, 14));
		contentPane.add(lblMilkTeaFlavor);
		
		
	}
}
 
