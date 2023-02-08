import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
@SuppressWarnings("serial")
public class Main extends JFrame {
private JPanel contentPane;
private JLabel lblItemPrice;
private JTextField txtQuantity;
private String[] itemCategory = {"CANNED GOODS", "DETERGENTS", "DRINKS"};
private String[] cannedGoods = {"CORNED BEEF", "SARDINES", "TUNA"};
private double[] cannedGoodsP = {30.0, 15.0, 25.0};
private String[] detergents = {"BLEACH", "DETERGENT SOAP", "POWDERED DETERGENT"};
private double[] detergentsP = {12.0, 10.0, 8.0};
private String[] drinks = {"COFFEE", "JUICE", "SOFTDRINK"};
private double[] drinksP = {12.0, 20.0, 25.0};
private DefaultComboBoxModel<Object> modelItems = new
DefaultComboBoxModel<Object>(cannedGoods);
private JComboBox<Object> cboItemCategories, cboItems;
private JTextArea txtAOrderSummary;
private double totalPrice = 0;
/**
* Launch the application.
*/
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
/**
* Create the frame.
*/
public Main() {
setResizable(false);
setTitle("SALES APPLICATION");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 348, 537);
setLocationRelativeTo(null);
contentPane = new JPanel();
contentPane.setBackground(Color.PINK);
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
setContentPane(contentPane);
contentPane.setLayout(null);
JLabel lblNewLabel = new JLabel("SELECT ITEM CATEGORY:");
lblNewLabel.setBounds(10, 11, 152, 14);
lblNewLabel.setFont(new Font("Serif", Font.BOLD, 10));
contentPane.add(lblNewLabel);
JLabel lblNewLabel_1 = new JLabel("SELECT ITEM:");
lblNewLabel_1.setBounds(10, 66, 152, 14);
lblNewLabel_1.setFont(new Font("Serif", Font.BOLD, 10));
contentPane.add(lblNewLabel_1);
JLabel lblNewLabel_2 = new JLabel("ITEM PRICE:");
lblNewLabel_2.setBounds(60, 128, 152, 14);
lblNewLabel_2.setFont(new Font("Serif", Font.BOLD, 10));
contentPane.add(lblNewLabel_2);
// ComboBox For Categories.
cboItemCategories = new JComboBox<Object>(itemCategory);
cboItemCategories.setBounds(10, 33, 123, 22);
cboItemCategories.setFont(new Font("Serif", Font.PLAIN, 11));
cboItemCategories.addActionListener(new ActionListener() { // Action perform when 
click.
public void actionPerformed(ActionEvent e) {
// Input.
String selectedCategory = cboItemCategories.getSelectedItem().toString();
// Process & Output.
if (selectedCategory.equals("DETERGENTS")) { // If Detergents category is 
selected.
modelItems = new DefaultComboBoxModel<Object>(detergents);
lblItemPrice.setText(String.valueOf(detergentsP[0]));
} else if (selectedCategory.equals("DRINKS")) { // If Drinks category is 
selected.
modelItems = new DefaultComboBoxModel<Object>(drinks);
lblItemPrice.setText(String.valueOf(drinksP[0]));
} else { // If CannedGoods category is selected.
modelItems = new DefaultComboBoxModel<Object>(cannedGoods);
lblItemPrice.setText(String.valueOf(cannedGoodsP[0]));
}
cboItems.setModel(modelItems);
}
});
contentPane.add(cboItemCategories);
// ComboBox For Items.
cboItems = new JComboBox<Object>(modelItems);
cboItems.setBounds(10, 91, 123, 22);
cboItems.setFont(new Font("Serif", Font.PLAIN, 11));
cboItems.addActionListener(new ActionListener() { // Action perform when click.
public void actionPerformed(ActionEvent e) {
// Input.
String selectedCategory = cboItemCategories.getSelectedItem().toString();
// Process & Output.
if (selectedCategory.equals("DETERGENTS")) { // If Detergents category is 
selected.
lblItemPrice.setText(String.valueOf(detergentsP[cboItems.getSelectedIndex()]));
} else if (selectedCategory.equals("DRINKS")) { // If Drinks category is 
selected.
lblItemPrice.setText(String.valueOf(drinksP[cboItems.getSelectedIndex()]));
} else { // If CannedGoods category is selected.
lblItemPrice.setText(String.valueOf(cannedGoodsP[cboItems.getSelectedIndex()]));
}
}
});
contentPane.add(cboItems);
// Label For Price.
lblItemPrice = new JLabel("30.0");
lblItemPrice.setBounds(276, 121, 46, 14);
lblItemPrice.setFont(new Font("Serif", Font.PLAIN, 11));
lblItemPrice.setHorizontalAlignment(SwingConstants.RIGHT);
contentPane.add(lblItemPrice);
// Button For AddToCart.
JButton btnAddToCart = new JButton("ADD TO CART");
btnAddToCart.setBounds(164, 185, 139, 23);
btnAddToCart.setFont(new Font("Serif", Font.PLAIN, 11));
btnAddToCart.addActionListener(new ActionListener() { // Action perform when click.
public void actionPerformed(ActionEvent e) {
try {
 // Block of code to try
if (txtQuantity.getText().isBlank()) { // If Quantity is blank.
JOptionPane.showMessageDialog(null, "PUT A QUANTITY", 
"WARNING",JOptionPane.WARNING_MESSAGE);
} else if (txtQuantity.getText().contains("-")) { // If contains 
negative sign.
JOptionPane.showMessageDialog(null, "ONLY WHOLE NUMBER/S ARE 
ALLOWED!", "WARNING",JOptionPane.WARNING_MESSAGE);
} else { // If no error.
// Input.
String item = cboItems.getSelectedItem().toString();
String price = lblItemPrice.getText();
String quantity = 
String.valueOf(Integer.parseInt(txtQuantity.getText()));
// Process.
double subTotal = Double.parseDouble(price) * 
Double.parseDouble(quantity);
totalPrice += subTotal;
// Output.
txtAOrderSummary.append(item.concat(" - ") + price.concat(" 
@ ") + 
quantity.concat(" - ") + 
String.valueOf(subTotal).concat(" pesos\n"));
reset();
}
} catch (Exception er) {
 // Block of code to handle errors
JOptionPane.showMessageDialog(null, "ONLY WHOLE NUMBER/S ARE 
ALLOWED!", "WARNING",JOptionPane.WARNING_MESSAGE);
}
}
});
btnAddToCart.setFocusable(false);
contentPane.add(btnAddToCart);
JLabel lblNewLabel_3 = new JLabel("ENTER QUANTITY:");
lblNewLabel_3.setBounds(60, 161, 152, 14);
lblNewLabel_3.setFont(new Font("Serif", Font.BOLD, 10));
contentPane.add(lblNewLabel_3);
// TextField For Quantity.
txtQuantity = new JTextField();
txtQuantity.setBounds(263, 146, 59, 22);
txtQuantity.setFont(new Font("Serif", Font.PLAIN, 11));
txtQuantity.setHorizontalAlignment(SwingConstants.CENTER);
contentPane.add(txtQuantity);
txtQuantity.setColumns(10);
// Button For CheckOut.
JButton btnCheckOut = new JButton("CHECK OUT");
btnCheckOut.setBounds(164, 219, 139, 23);
btnCheckOut.setFont(new Font("Serif", Font.PLAIN, 11));
btnCheckOut.addActionListener(new ActionListener() { // Action perform when click.
public void actionPerformed(ActionEvent e) {
// Process & Output.
if (txtAOrderSummary.getText().isBlank()) { // If OrderSummary is blank.
JOptionPane.showMessageDialog(null, "THERE'S NO ITEM TO CHECK 
OUT...");
} else { // If no error.
for (int i = 0; i <= 58; i++) {
txtAOrderSummary.append("*");
}
txtAOrderSummary.append("\nTotal Price: " + 
String.valueOf(totalPrice).concat(" pesos\n\n\n"));
reset();
}
}
});
btnCheckOut.setFocusable(false);
contentPane.add(btnCheckOut);
JLabel lblNewLabel_4 = new JLabel("ORDER SUMMARY:");
lblNewLabel_4.setBounds(21, 240, 133, 14);
lblNewLabel_4.setFont(new Font("Serif", Font.BOLD, 11));
contentPane.add(lblNewLabel_4);
JScrollPane scrollPane = new JScrollPane();
scrollPane.setBounds(10, 265, 314, 193);
contentPane.add(scrollPane);
// TextArea For OrderSummary.
txtAOrderSummary = new JTextArea();
txtAOrderSummary.setEditable(false);
txtAOrderSummary.setFont(new Font("Serif", Font.PLAIN, 14));
txtAOrderSummary.setLineWrap(true);
scrollPane.setViewportView(txtAOrderSummary);
// Button For Clear.
JButton btnClear = new JButton("CLEAR");
btnClear.setBounds(120, 469, 99, 23);
btnClear.setFont(new Font("Serif", Font.PLAIN, 14));
btnClear.addActionListener(new ActionListener() { // Action perform when click.
public void actionPerformed(ActionEvent e) {
// Back to default interface.
reset();
txtAOrderSummary.setText(null);
totalPrice = 0;
}
});
btnClear.setFocusable(false);
contentPane.add(btnClear);
}
// Method to reset to the default selection.
void reset() {
cboItemCategories.setSelectedIndex(0);
cboItems.setSelectedIndex(0);
lblItemPrice.setText("30.0");
txtQuantity.setText(null);
}
}
