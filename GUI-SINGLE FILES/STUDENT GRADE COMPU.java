import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.w3c.dom.Text;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;
public class Main extends JFrame {
 private JPanel contentPane;
 private JTextField textName;
 private JTextField textPG;
 private JTextField textMG;
 private JTextField textFG;
 private JScrollPane scrollPane; 
 private JTextArea txtrName;
 private static JButton btnEnter;
 private static JButton btnNewRecord;
 private JLabel lblHigh;
 private JLabel lblLow;
 private static double highest, lowest, hilo, graderank;
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
 setForeground(new Color(255, 248, 220));
 setTitle("Student Grading System");
 setBackground(new Color(255, 228, 196));
 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 setBounds(100, 100, 800, 430);
 setLocationRelativeTo(null);
 contentPane = new JPanel();
 contentPane.setBackground(Color.PINK);
 contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
 setContentPane(contentPane);
 contentPane.setLayout(null);
 
 JScrollPane scrollPane = new JScrollPane();
 scrollPane.setEnabled(false);
 scrollPane.setBounds(36, 11, 726, 120);
 contentPane.add(scrollPane);
 
 JTextArea txtrName = new JTextArea();
 txtrName.setFont(new Font("Arial Black", Font.PLAIN, 13));
 txtrName.setBackground(Color.WHITE);
 txtrName.setEditable(false);
 txtrName.setEnabled(false);
 txtrName.setText("NAME\t PG\t MG\t FG\t SG 
\t REMARKS\r\n");
 scrollPane.setViewportView(txtrName);
 
 JLabel lblName = new JLabel("Name:");
 lblName.setFont(new Font("Arial Black", Font.PLAIN, 11));
 lblName.setBounds(60, 171, 183, 14);
 contentPane.add(lblName);
 
 textName = new JTextField();
 textName.addKeyListener(new KeyAdapter() {
 @Override
 public void keyTyped(KeyEvent e) {
 char c = e.getKeyChar();
 
 if (Character.isDigit(c)) {
 e.consume();
 JOptionPane.showMessageDialog(null, " Please Enter a Name!");
 }
 }
 });
 textName.setBackground(new Color(255, 255, 255));
 textName.setEnabled(false);
 textName.setBounds(116, 166, 183, 27);
 contentPane.add(textName);
 textName.setColumns(10);
 
 JLabel lblPG = new JLabel("Prelim Grade:");
 lblPG.setFont(new Font("Arial Black", Font.PLAIN, 11));
 lblPG.setBounds(128, 229, 183, 14);
 contentPane.add(lblPG);
 
 textPG = new JTextField();
 textPG.addKeyListener(new KeyAdapter() {
 @Override
 public void keyTyped(KeyEvent e) {
 char c = e.getKeyChar();
 
 if (Character.isLetter(c)) {
 e.consume();
 JOptionPane.showMessageDialog(null, " Please Enter your Prelim Grade!");
 }
 }
 });
 textPG.setBackground(Color.WHITE);
 textPG.setEnabled(false);
 textPG.setColumns(10);
 textPG.setBounds(249, 224, 183, 27);
 contentPane.add(textPG);
 
 JLabel lblMG = new JLabel("Midterm Grade:");
 lblMG.setFont(new Font("Arial Black", Font.PLAIN, 11));
 lblMG.setBounds(128, 278, 183, 14);
 contentPane.add(lblMG);
 
 textMG = new JTextField();
 textMG.addKeyListener(new KeyAdapter() {
 @Override
 public void keyTyped(KeyEvent e) {
 char c = e.getKeyChar();
 
 if (Character.isLetter(c)) {
 e.consume();
 JOptionPane.showMessageDialog(null, " Please Enter your Midterm Grade!");
 }
 }
 });
 textMG.setBackground(new Color(255, 255, 255));
 textMG.setEnabled(false);
 textMG.setColumns(10);
 textMG.setBounds(249, 273, 183, 27);
 contentPane.add(textMG);
 
 JLabel lblFG = new JLabel("Final Grade:");
 lblFG.setFont(new Font("Arial Black", Font.PLAIN, 11));
 lblFG.setBounds(128, 334, 183, 14);
 contentPane.add(lblFG);
 
 textFG = new JTextField();
 textFG.addKeyListener(new KeyAdapter() {
 @Override
 public void keyTyped(KeyEvent e) {
 char c = e.getKeyChar();
 
 if (Character.isLetter(c)) {
 e.consume();
 JOptionPane.showMessageDialog(null, " Please Enter your Final Grade!");
 }
 }
 });
 textFG.setBackground(Color.WHITE);
 textFG.setEnabled(false);
 textFG.setColumns(10);
 textFG.setBounds(249, 329, 183, 26);
 contentPane.add(textFG);
 
 lblHigh = new JLabel();
 lblHigh.setFont(new Font("Arial Black", Font.PLAIN, 11));
 lblHigh.setBounds(330, 142, 432, 20);
 contentPane.add(lblHigh);
 
 lblLow = new JLabel();
 lblLow.setFont(new Font("Arial Black", Font.PLAIN, 11));
 lblLow.setBounds(330, 173, 432, 20);
 contentPane.add(lblLow);
 
 btnNewRecord = new JButton("New Record");
 btnNewRecord.setFont(new Font("Arial Black", Font.PLAIN, 11));
 btnNewRecord.setBackground(Color.WHITE);
 btnNewRecord.addActionListener(new ActionListener() {
 public void actionPerformed(ActionEvent e) {
 textName.setEnabled(true);
 textPG.setEnabled(true);
 textMG.setEnabled(true);
 textFG.setEnabled(true);
 txtrName.setEnabled(true);
 textName.requestFocus();
 btnNewRecord.setEnabled(false);
 btnEnter.setEnabled(true);
 }
 });
 btnNewRecord.setBounds(524, 220, 164, 33);
 contentPane.add(btnNewRecord);
 
 btnEnter = new JButton("Save Record");
 btnEnter.setFont(new Font("Arial Black", Font.PLAIN, 11));
 btnEnter.setBackground(Color.WHITE);
 btnEnter.setEnabled(false);
 btnEnter.addActionListener(new ActionListener() {
 public void actionPerformed(ActionEvent e) {
 String name = textName.getText();
 double pg = Double.parseDouble(textPG.getText());
 double mg = Double.parseDouble(textMG.getText());
 double fg = Double.parseDouble(textFG.getText());
 double remarks = ((pg + mg + fg)/3);
 
 double sg = (pg * .30) + (mg * .30) + (fg * .40);
 
 if (remarks >= 59.99) {
 txtrName.append(name + "\t" + pg + "\t" + mg + "\t" + fg + "\t" + sg + 
"\t" + " Passed\n");
 }
 else {
 txtrName.append(name + "\t" + pg + "\t" + mg + "\t" + fg + "\t" + sg + 
"\t" + " Failed\n");
 }
 
 
 textName.setText(null);
 textPG.setText(null);
 textMG.setText(null);
 textFG.setText(null);
 btnEnter.setEnabled(false);
 textName.requestFocus();
 textName.setEnabled(false);
 textPG.setEnabled(false);
 textMG.setEnabled(false);
 textFG.setEnabled(false);
 btnNewRecord.setEnabled(true);
 
 hilo = remarks;
 graderank = hilo;
 String highgrade = ("Highest Semestral Grade: " + name + " with " + sg + " 
computed grade.");
 String lowgrade = ("Lowest Semestral Grade: " + name + " with " + sg + " 
computed grade."); 
 
 if (graderank >= highest || highest == 0 ) {
 lblHigh.setText(highgrade);
 highest = graderank;
 
 }
 if (graderank <= lowest || lowest == 0) {
 lblLow.setText(lowgrade);
 lowest = graderank;
 }
 
 }
 });
 btnEnter.setBounds(524, 278, 164, 33);
 contentPane.add(btnEnter);
 
 
 JButton btnEnter_1 = new JButton("<Exit>");
 btnEnter_1.setFont(new Font("Arial Black", Font.PLAIN, 11));
 btnEnter_1.setBackground(Color.WHITE);
 btnEnter_1.addActionListener(new ActionListener() {
 public void actionPerformed(ActionEvent e) {
 System.exit(EXIT_ON_CLOSE);
 }
 });
 btnEnter_1.setBounds(524, 334, 164, 33);
 contentPane.add(btnEnter_1);
 
 }
 }
