import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
public class Main extends JFrame {
/**
* 
*/
private JPanel contentPane;
private JTextField txtFN;
private JTextField txtMN;
private JTextField txtLN;
private JRadioButton rdoResident;
private JRadioButton rdoNonResident;
private JRadioButton rdoRegular;
private JRadioButton rdoIrregular;
private JCheckBox chkCCS103;
private JCheckBox chkCCS104;
private JCheckBox chkCCS105;
private JCheckBox chkCCS106;
private JCheckBox chkCOM101;
private JCheckBox chkGAD101;
private JCheckBox chkNSTP2;
private JCheckBox chkPED102;
private int numberOfSubjects;
private ButtonGroup bgClassification;
private ButtonGroup bgStatus;
private int miscFee;
private int tuitionFee;
private int total;
private JLabel lblWelcome;
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
addWindowListener(new WindowAdapter() {
@Override
public void windowClosing(WindowEvent e) {
int confirmed = JOptionPane.showConfirmDialog(null, "ARE YOU SURE YOU WANT 
TO EXIT?", "Exit", JOptionPane.YES_NO_OPTION);
if(confirmed == JOptionPane.YES_OPTION) {
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}else {
setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
}
}
});
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 735, 640);
contentPane = new JPanel();
contentPane.setBackground(Color.WHITE);
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
setContentPane(contentPane);
contentPane.setLayout(null);
txtFN = new JTextField();
txtFN.setBounds(104, 14, 160, 20);
contentPane.add(txtFN);
txtFN.setColumns(10);
txtMN = new JTextField();
txtMN.setColumns(10);
txtMN.setBounds(104, 60, 160, 20);
contentPane.add(txtMN);
txtLN = new JTextField();
txtLN.setColumns(10);
txtLN.setBounds(104, 38, 160, 20);
contentPane.add(txtLN);
JScrollPane scrollPane = new JScrollPane();
scrollPane.setBounds(10, 350, 705, 220);
contentPane.add(scrollPane);
JTextArea txASummary = new JTextArea();
txASummary.setEditable(false);
scrollPane.setViewportView(txASummary);
JLabel lblFirstName = new JLabel("FIRST NAME: ");
lblFirstName.setFont(new Font("Bell MT", lblFirstName.getFont().getStyle() | Font.BOLD, 
11));
lblFirstName.setBounds(10, 16, 93, 17);
contentPane.add(lblFirstName);
JLabel lblLastName = new JLabel("LAST NAME: ");
lblLastName.setFont(new Font("Bell MT", lblLastName.getFont().getStyle() | Font.BOLD, 
lblLastName.getFont().getSize()));
lblLastName.setBounds(10, 63, 70, 14);
contentPane.add(lblLastName);
JLabel lblMiddleName = new JLabel("MIDDLE NAME: ");
lblMiddleName.setFont(new Font("Bell MT", lblMiddleName.getFont().getStyle() | 
Font.BOLD, lblMiddleName.getFont().getSize()));
lblMiddleName.setBounds(10, 41, 87, 14);
contentPane.add(lblMiddleName);
JLabel lblClassification = new JLabel("CLASSIFICATION");
lblClassification.setFont(new Font("Bell MT", Font.BOLD, 14));
lblClassification.setBounds(313, 17, 144, 14);
contentPane.add(lblClassification);
rdoResident = new JRadioButton("RESIDENT");
rdoResident.setFont(new Font("Bell MT", Font.BOLD, 11));
rdoResident.setBackground(Color.PINK);
rdoResident.setBounds(281, 37, 87, 23);
contentPane.add(rdoResident);
rdoNonResident = new JRadioButton("NON-RESIDENT");
rdoNonResident.setFont(new Font("Bell MT", Font.BOLD, 11));
rdoNonResident.setBackground(Color.PINK);
rdoNonResident.setBounds(375, 37, 104, 23);
contentPane.add(rdoNonResident);
JLabel lblStatus = new JLabel("STATUS");
lblStatus.setFont(new Font("Bell MT", Font.BOLD, 14));
lblStatus.setBounds(549, 17, 87, 14);
contentPane.add(lblStatus);
rdoRegular = new JRadioButton("REGULAR");
rdoRegular.setFont(new Font("Bell MT", Font.BOLD, 11));
rdoRegular.setBackground(Color.PINK);
rdoRegular.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
regularStudent();
}
});
rdoRegular.setBounds(495, 37, 87, 23);
contentPane.add(rdoRegular);
rdoIrregular = new JRadioButton("IRREGULAR");
rdoIrregular.setFont(new Font("Bell MT", Font.BOLD, 11));
rdoIrregular.setBackground(Color.PINK);
rdoIrregular.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
irregularStudent();
}
});
rdoIrregular.setBounds(584, 37, 96, 23);
contentPane.add(rdoIrregular);
JLabel lblSubjects = new JLabel("SUBJECTS");
lblSubjects.setFont(new Font("Bell MT", Font.BOLD, 14));
lblSubjects.setBounds(37, 200, 178, 14);
contentPane.add(lblSubjects);
chkCCS103 = new JCheckBox("CCS103 Computer Programming 2 (3 units, Lab)");
chkCCS103.setFont(new Font("Bell MT", Font.PLAIN, 11));
chkCCS103.setBackground(Color.PINK);
chkCCS103.setBounds(171, 134, 381, 23);
contentPane.add(chkCCS103);
chkCCS104 = new JCheckBox("CCS104 Discrete Structures 1 (3 units, Lab)");
chkCCS104.setFont(new Font("Bell MT", Font.PLAIN, 11));
chkCCS104.setBackground(Color.PINK);
chkCCS104.setBounds(171, 160, 381, 23);
contentPane.add(chkCCS104);
chkCCS105 = new JCheckBox("CCS105 Human Computer Interaction 1 (3 units, Lab)");
chkCCS105.setFont(new Font("Bell MT", Font.PLAIN, 11));
chkCCS105.setBackground(Color.PINK);
chkCCS105.setBounds(171, 186, 381, 23);
contentPane.add(chkCCS105);
chkCCS106 = new JCheckBox("CCS106 Social and Professional Issues (3 units, Lec)");
chkCCS106.setFont(new Font("Bell MT", Font.PLAIN, 11));
chkCCS106.setBackground(Color.PINK);
chkCCS106.setBounds(171, 212, 381, 23);
contentPane.add(chkCCS106);
chkCOM101 = new JCheckBox("COM101 Purposive Communication (3 units, Lec)");
chkCOM101.setFont(new Font("Bell MT", Font.PLAIN, 11));
chkCOM101.setBackground(Color.PINK);
chkCOM101.setBounds(171, 238, 381, 23);
contentPane.add(chkCOM101);
chkGAD101 = new JCheckBox("GAD101 Gender and Development (3 units, Lec)");
chkGAD101.setFont(new Font("Bell MT", Font.PLAIN, 11));
chkGAD101.setBackground(Color.PINK);
chkGAD101.setBounds(171, 264, 381, 23);
contentPane.add(chkGAD101);
chkNSTP2 = new JCheckBox("NSTP2 National Service Training Program 2 (3 units, Lec)");
chkNSTP2.setFont(new Font("Bell MT", Font.PLAIN, 11));
chkNSTP2.setBackground(Color.PINK);
chkNSTP2.setBounds(171, 290, 381, 23);
contentPane.add(chkNSTP2);
chkPED102 = new JCheckBox("PED102 Physical Education 2 (3 units, Lec)");
chkPED102.setFont(new Font("Bell MT", Font.PLAIN, 11));
chkPED102.setBackground(Color.PINK);
chkPED102.setBounds(171, 316, 381, 23);
contentPane.add(chkPED102);
bgClassification = new ButtonGroup();
bgClassification.add(rdoResident);
bgClassification.add(rdoNonResident);
bgStatus = new ButtonGroup();
bgStatus.add(rdoRegular);
bgStatus.add(rdoIrregular);
JButton btnEnrol = new JButton("ENROL");
btnEnrol.setFont(new Font("Bell MT", Font.BOLD, 15));
btnEnrol.setForeground(new Color(0, 0, 0));
btnEnrol.setBackground(Color.PINK);
btnEnrol.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
String name = txtLN.getText().trim() + ", " + txtFN.getText().trim() + " "
+ txtMN.getText().trim();
String classification = "";
if(rdoResident.isSelected()) {
classification = rdoResident.getText();
}else if(rdoNonResident.isSelected()) {
classification = rdoNonResident.getText();
}
String status = "";
if(rdoRegular.isSelected()) {
status = rdoRegular.getText();
}else if(rdoIrregular.isSelected()) {
status = rdoIrregular.getText();
}
String subjects = "";
numberOfSubjects = 0;
int unit = 0;
int lab = 0;
if(chkCCS103.isSelected()) {
numberOfSubjects += 1;
subjects = "\n" + "CCS103\t\tComputer Programming 2\t\t\t3";
unit +=3; 
if(rdoResident.isSelected()) {
lab += 500;
}else {
lab += 1000;
}
}
if(chkCCS104.isSelected()) {
numberOfSubjects += 1;
subjects += "\n" + "CCS104\t\tDiscrete Structures 1\t\t\t3";
unit +=3; 
if(rdoResident.isSelected()) {
lab += 500;
}else {
lab += 1000;
}
}
if(chkCCS105.isSelected()) {
numberOfSubjects += 1;
subjects += "\n" + "CCS105\t\tHuman Computer Interaction 1\t\t3";
unit +=3; 
if(rdoResident.isSelected()) {
lab += 500;
}else {
lab += 1000;
}
}
if(chkCCS106.isSelected()) {
numberOfSubjects += 1;
subjects += "\n" + "CCS106\t\tSocial and Professional Issues\t\t3";
unit +=3; 
}
if(chkCOM101.isSelected()) {
numberOfSubjects += 1;
subjects += "\n" + "COM101\t\tPurposive Communication\t\t\t3";
unit +=3; 
}
if(chkGAD101.isSelected()) {
numberOfSubjects += 1;
subjects += "\n" + "GAD101\t\tGender and Development\t\t\t3";
unit +=3; 
}
if(chkNSTP2.isSelected()) {
numberOfSubjects += 1;
subjects += "\n" + "NSTP2\t\tNational Training Service Program 
2\t3";
unit +=3; 
}
if(chkPED102.isSelected()) {
numberOfSubjects += 1;
subjects += "\n" + "PED102\t\tPhysical Education 2\t\t\t3";
unit +=3; 
}
if(txtFN.getText().isBlank() || txtLN.getText().isBlank() || 
txtMN.getText().isBlank()) {
JOptionPane.showMessageDialog(null, "There was an empty field/s", 
"Message", JOptionPane.INFORMATION_MESSAGE);
return;
}
if(numberOfSubjects <= 1) {
JOptionPane.showMessageDialog(null, "You have to select at least 2 
subjects", "Message", JOptionPane.INFORMATION_MESSAGE);
return;
}
total = 0;
if(rdoResident.isSelected()) {
total += residentAmount();
}else {
total += nonresident();
}
miscFee = 0;
if(rdoResident.isSelected()) {
miscFee = 1000;
}else {
miscFee = 3000;
}
tuitionFee = 0;
if(rdoResident.isSelected()) {
tuitionFee = 100;
}else {
tuitionFee = 300;
}
txASummary.setFont(new Font("Monospaced", Font.PLAIN, 13));
txASummary.append("Name: " + name + "\nStatus: " + status + 
"\nClassification: " + classification + "\n\nCOURSE CODE\tDESCRIPTION\t\t\t\tUNIT\n\n" + subjects + 
"\n\nMiscellaneous Fee: " + miscFee + "\nTuition Fee: " + 
((tuitionFee * unit)+lab) + "\n\nTotal Amount: " + total + "\n\n");
reset();
}
});
btnEnrol.setBounds(343, 81, 149, 35);
contentPane.add(btnEnrol);
JButton btnClear = new JButton("CLEAR");
btnClear.setFont(new Font("Bell MT", Font.BOLD, 15));
btnClear.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
txASummary.setText(null);
}
});
btnClear.setForeground(new Color(0, 0, 0));
btnClear.setBackground(Color.PINK);
btnClear.setBounds(504, 81, 144, 35);
contentPane.add(btnClear);
lblWelcome = new JLabel("HELLO STUDENT!");
lblWelcome.setFont(new Font("Stencil", Font.PLAIN, 15));
lblWelcome.setBounds(189, 81, 144, 36);
contentPane.add(lblWelcome);
setLocationRelativeTo(null);
}
public void reset() {
bgClassification.clearSelection();
bgStatus.clearSelection();
chkCCS103.setSelected(false);
chkCCS104.setSelected(false);
chkCCS105.setSelected(false);
chkCCS106.setSelected(false);
chkCOM101.setSelected(false);
chkGAD101.setSelected(false);
chkNSTP2.setSelected(false);
chkPED102.setSelected(false);
txtFN.setText(null);
txtLN.setText(null);
txtMN.setText(null);
}
public void regularStudent() {
chkCCS103.setSelected(true);
chkCCS104.setSelected(true);
chkCCS105.setSelected(true);
chkCCS106.setSelected(true);
chkCOM101.setSelected(true);
chkGAD101.setSelected(true);
chkNSTP2.setSelected(true);
chkPED102.setSelected(true);
chkCCS103.setEnabled(false);
chkCCS104.setEnabled(false);
chkCCS105.setEnabled(false);
chkCCS106.setEnabled(false);
chkCOM101.setEnabled(false);
chkGAD101.setEnabled(false);
chkNSTP2.setEnabled(false);
chkPED102.setEnabled(false);
}
public void irregularStudent() {
chkCCS103.setEnabled(true);
chkCCS104.setEnabled(true);
chkCCS105.setEnabled(true);
chkCCS106.setEnabled(true);
chkCOM101.setEnabled(true);
chkGAD101.setEnabled(true);
chkNSTP2.setEnabled(true);
chkPED102.setEnabled(true);
chkCCS103.setSelected(false);
chkCCS104.setSelected(false);
chkCCS105.setSelected(false);
chkCCS106.setSelected(false);
chkCOM101.setSelected(false);
chkGAD101.setSelected(false);
chkNSTP2.setSelected(false);
chkPED102.setSelected(false);
}
private int residentAmount() {
int resident = 0;
int labsubject = 500;
int tuitionfee = 3 * 100;
int miscellaneous = 1000;
if(chkCCS103.isSelected()) {
resident += tuitionfee + labsubject;
}
if(chkCCS104.isSelected()) {
resident += tuitionfee + labsubject;
}
if(chkCCS105.isSelected()) {
resident += tuitionfee + labsubject;
}
if(chkCCS106.isSelected()) {
resident += tuitionfee;
}
if(chkCOM101.isSelected()) {
resident += tuitionfee;
}
if(chkGAD101.isSelected()) {
resident += tuitionfee;
}
if(chkNSTP2.isSelected()) {
resident += tuitionfee;
}
if(chkPED102.isSelected()) {
resident += tuitionfee;
}
return resident + miscellaneous;
}
private int nonresident() {
int nonresident = 0;
int labsubject = 1000;
int tuitionfee = 3 * 300;
int miscellaneous = 3000;
if(chkCCS103.isSelected()) {
nonresident += tuitionFee + labsubject;
}
if(chkCCS104.isSelected()) {
nonresident += tuitionFee + labsubject;
}
if(chkCCS105.isSelected()) {
nonresident += tuitionFee + labsubject;
}
if(chkCCS106.isSelected()) {
nonresident += tuitionFee;
}
if(chkCOM101.isSelected()) {
nonresident += tuitionfee;
}
if(chkGAD101.isSelected()) {
nonresident += tuitionfee;
}
if(chkNSTP2.isSelected()) {
nonresident += tuitionfee;
}
if(chkPED102.isSelected()) {
nonresident += tuitionfee;
}
return nonresident + miscellaneous;