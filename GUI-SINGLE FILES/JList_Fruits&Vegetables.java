import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import java.awt.Color;
@SuppressWarnings("serial")
public class Main extends JFrame {
private JPanel contentPane;
private JTextField txtItem;
private DefaultListModel<String> modelItem1 = new DefaultListModel<String>();
private DefaultListModel<String> modelItem2 = new DefaultListModel<String>();
private JLabel lblVegetablesCount, lblFruitsCount;
private ButtonGroup bgItem;
private JRadioButton rdoFruits, rdoVegetables;
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
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 765, 490);
setLocationRelativeTo(null);
contentPane = new JPanel();
contentPane.setBackground(Color.WHITE);
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
setContentPane(contentPane);
contentPane.setLayout(null);
JScrollPane scrollPane = new JScrollPane();
scrollPane.setBounds(448, 137, 291, 222);
contentPane.add(scrollPane);
JScrollPane scrollPane_1 = new JScrollPane();
scrollPane_1.setBounds(10, 137, 265, 225);
contentPane.add(scrollPane_1);
// List for Item1.
JList<String> listVegetables = new JList<String>(modelItem1);
listVegetables.setFont(new Font("Serif", Font.PLAIN, 14));
scrollPane_1.setViewportView(listVegetables);
// List for Item2.
JList<String> listFruits = new JList<String>(modelItem2);
listFruits.setFont(new Font("Serif", Font.PLAIN, 14));
scrollPane.setViewportView(listFruits);
// Button for Transfer To Right.
JButton btnRight = new JButton(">");
btnRight.addActionListener(new ActionListener() { // Action Perform when click.
public void actionPerformed(ActionEvent e) {
if (listVegetables.getSelectedIndex() >= 0) { // If there is no error.
int[] item1Arr = listVegetables.getSelectedIndices();
for (int i : item1Arr) { // Iterate each item.
modelItem2.addElement(modelItem1.getElementAt(i));
lblFruitsCount.setText("Item List: " + modelItem2.getSize());
}
for (int i = item1Arr.length-1; i >= 0; i--) { // It iterates the 
length of an item.
modelItem1.removeElementAt(item1Arr[i]);
lblVegetablesCount.setText("Item List: " + 
modelItem1.getSize());
}
} else { // If no item is selected.
JOptionPane.showMessageDialog(null, "SELECT A VEGETABLE ITEM TO 
TRANSFER!!", "Warning", JOptionPane.WARNING_MESSAGE);
}
}
});
btnRight.setFocusable(false);
btnRight.setFont(new Font("Serif", Font.BOLD, 14));
btnRight.setBounds(297, 202, 130, 47);
contentPane.add(btnRight);
// Button for Transfer to Left.
JButton btnLeft = new JButton("<");
btnLeft.addActionListener(new ActionListener() { // Action Perform when click.
public void actionPerformed(ActionEvent e) {
if (listFruits.getSelectedIndex() >= 0) { // If there is no error.
int[] item2Arr = listFruits.getSelectedIndices();
for (int i : item2Arr) { // Iterate each item.
modelItem1.addElement(modelItem2.getElementAt(i));
lblVegetablesCount.setText("Item List: " + 
modelItem1.getSize());
}
for (int i = item2Arr.length-1; i >= 0; i--) { // It iterates the 
length of an item.
modelItem2.removeElementAt(item2Arr[i]);
lblFruitsCount.setText("Item List: " + modelItem2.getSize());
}
} else { // If no item is selected.
JOptionPane.showMessageDialog(null, "SELECT A FRUIT ITEM TO 
TRANSFER!", "WARNING", JOptionPane.WARNING_MESSAGE);
}
}
});
btnLeft.setFont(new Font("Serif", Font.BOLD, 14));
btnLeft.setFocusable(false);
btnLeft.setBounds(297, 260, 130, 47);
contentPane.add(btnLeft);
// Button for Add.
JButton btnAdd = new JButton("ADD");
btnAdd.addActionListener(new ActionListener() { // Action Perform when click.
public void actionPerformed(ActionEvent e) {
if (txtItem.getText().isBlank()) { // If TextField is blank.
JOptionPane.showMessageDialog(null, "INPUT A STRING FIRST!", 
"WARNING", JOptionPane.WARNING_MESSAGE);
} else { // If no error.
if (rdoVegetables.isSelected()) { // If Vegetables button is 
selected.
modelItem1.addElement(txtItem.getText());
lblVegetablesCount.setText("Item List: " + 
(modelItem1.getSize()));
} else { // if Fruits button is selected
modelItem2.addElement(txtItem.getText());
lblFruitsCount.setText("Item List: " + 
(modelItem2.getSize()));
}
txtItem.setText(null);
}
}
});
btnAdd.setFocusable(false);
btnAdd.setFont(new Font("Serif", Font.PLAIN, 14));
btnAdd.setBounds(564, 11, 175, 36);
contentPane.add(btnAdd);
// TextField for Item.
txtItem = new JTextField();
txtItem.setFont(new Font("Serif", Font.PLAIN, 16));
txtItem.setBounds(164, 10, 390, 38);
contentPane.add(txtItem);
txtItem.setColumns(10);
// Label for Item1.
lblVegetablesCount = new JLabel("Item Count: 0");
lblVegetablesCount.setHorizontalAlignment(SwingConstants.CENTER);
lblVegetablesCount.setFont(new Font("Serif", Font.PLAIN, 14));
lblVegetablesCount.setBounds(-67, 373, 265, 38);
contentPane.add(lblVegetablesCount);
// Label for Item2.
lblFruitsCount = new JLabel("Item Count: 0");
lblFruitsCount.setHorizontalAlignment(SwingConstants.CENTER);
lblFruitsCount.setFont(new Font("Serif", Font.PLAIN, 14));
lblFruitsCount.setBounds(353, 373, 291, 38);
contentPane.add(lblFruitsCount);
JLabel lblEAS = new JLabel("ENTER A STRING:");
lblEAS.setFont(new Font("Serif", Font.PLAIN, 16));
lblEAS.setBounds(10, 12, 199, 35);
contentPane.add(lblEAS);
// RadioButton for Vegetables.
rdoVegetables = new JRadioButton("VEGETABLES");
rdoVegetables.setBackground(Color.WHITE);
rdoVegetables.setFocusable(false);
rdoVegetables.setSelected(true);
rdoVegetables.setHorizontalAlignment(SwingConstants.CENTER);
rdoVegetables.setFont(new Font("Serif", Font.PLAIN, 16));
rdoVegetables.setBounds(53, 96, 175, 34);
contentPane.add(rdoVegetables);
// RadioButton for Fruits.
rdoFruits = new JRadioButton("FRUITS");
rdoFruits.setBackground(Color.WHITE);
rdoFruits.setFocusable(false);
rdoFruits.setHorizontalAlignment(SwingConstants.CENTER);
rdoFruits.setFont(new Font("Serif", Font.PLAIN, 16));
rdoFruits.setBounds(513, 96, 175, 34);
contentPane.add(rdoFruits);
bgItem = new ButtonGroup();
bgItem.add(rdoVegetables);
bgItem.add(rdoFruits);
}
}
