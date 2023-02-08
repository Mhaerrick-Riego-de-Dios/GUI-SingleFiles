import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;;
@SuppressWarnings("serial") 
public class Main extends JFrame {
// Column Header.
private String[] columns = {"ID", "LAST NAME", "FIRST NAME", "MIDDLE NAME", "SEX", "COLLEGE", 
"PROGRAM"};
// Data.
private DefaultTableModel modelPersonalInfo = new DefaultTableModel();
// Unique Identifier.
private int id = 1;
// College Array.
private String[] collegeArr = {"CEAS", "CBAA", "CCE", "CON"};
// Program Array.
private String[] ceasArr = {"BSEED", "BSSED", "BSPSY"};
private String[] cbaaArr = {"BSA", "BSBA"};
private String[] cceArr = {"BSCS", "BSCPE", "BSECE", "BSIE", "BSIT"};
private String[] conArr = {"BSN"};
// Program Model.
private DefaultComboBoxModel<Object> modelProgram = new DefaultComboBoxModel<Object>(ceasArr);
// Button Group.
private ButtonGroup bgSex = new ButtonGroup();
// Set validation of what operation is currently used.
private boolean isUpdate = false, isDelete = false;
// Cell Renderer.
private DefaultTableCellRenderer rendar = new DefaultTableCellRenderer();
private JPanel contentPane;
private JTable tblPersonalInfo;
private JTextField txtLastName, txtFirstName, txtMiddleName;
private JLabel lblId;
private JComboBox<Object> cboProgram, cboCollege;
private JButton btnCancel, btnSave, btnUpdate, btnDelete, btnNew;
private JRadioButton rdoMale, rdoFemale;
private JLabel lblRecords;
/**s
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
setTitle("CRUD APPLICATION");
setBounds(100,100,826,542);
setLocationRelativeTo(null);
this.addWindowListener(new WindowAdapter() {
public void windowClosing(WindowEvent e) {
JFrame frame = (JFrame) e.getSource(); // Return the object that initially 
occurred.
int confirmation = JOptionPane.showConfirmDialog(
 frame, "ARE YOU SURE YOU WANT TO EXIT?", "WARNING!", 
JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
if (confirmation == 0) {
 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 } else {
 frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
 
}
}
});
contentPane = new JPanel();
contentPane.setFocusable(false);
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
setContentPane(contentPane);
contentPane.setLayout(null);
JLabel lblID = new JLabel("ID:");
lblID.setFont(new Font("Serif", Font.BOLD, 14));
lblID.setHorizontalAlignment(SwingConstants.RIGHT);
lblID.setBounds(10, 27, 49, 29);
contentPane.add(lblID);
JLabel lblLastName = new JLabel("LAST NAME:");
lblLastName.setFont(new Font("Serif", Font.BOLD, 14));
lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
lblLastName.setBounds(20, 65, 89, 29);
contentPane.add(lblLastName);
JLabel lblSex = new JLabel("SEX :");
lblSex.setFont(new Font("Serif", Font.BOLD, 14));
lblSex.setHorizontalAlignment(SwingConstants.RIGHT);
lblSex.setBounds(30, 105, 49, 29);
contentPane.add(lblSex);
JScrollPane scrollPane = new JScrollPane();
scrollPane.setBounds(20, 170, 774, 185);
contentPane.add(scrollPane);
// PersonalInfo Table.
tblPersonalInfo = new JTable(modelPersonalInfo) {
@Override
public boolean editCellAt(int row, int column, java.util.EventObject e) {
return false;
}
};
tblPersonalInfo.addMouseListener(new MouseAdapter() {
@Override
public void mouseClicked(MouseEvent e) {
selectedRow();
}
@Override
public void mouseReleased(MouseEvent e) {
selectedRow();
}
});
modelPersonalInfo.setColumnIdentifiers(columns);
tblPersonalInfo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
tblPersonalInfo.setEnabled(false);
scrollPane.setViewportView(tblPersonalInfo);
// Update Button.
btnUpdate = new JButton("UPDATE");
btnUpdate.setFont(new Font("Serif", Font.PLAIN, 11));
btnUpdate.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
updateRow();
}
});
btnUpdate.setFocusable(false);
btnUpdate.setBounds(564, 416, 89, 23);
contentPane.add(btnUpdate);
// Delete Button.
btnDelete = new JButton("DELETE");
btnDelete.setFont(new Font("Serif", Font.PLAIN, 11));
btnDelete.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
deleteRow();
}
});
btnDelete.setFocusable(false);
btnDelete.setBounds(564, 450, 89, 23);
contentPane.add(btnDelete);
// New Button.
btnNew = new JButton("NEW");
btnNew.setFont(new Font("Serif", Font.PLAIN, 11));
btnNew.setFocusable(false);
btnNew.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
newRow();
}
});
btnNew.setBounds(564, 382, 89, 23);
contentPane.add(btnNew);
// Save Button.
btnSave = new JButton("SAVE");
btnSave.setFont(new Font("Serif", Font.PLAIN, 11));
btnSave.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
save();
}
});
btnSave.setEnabled(false);
btnSave.setFocusable(false);
btnSave.setBounds(681, 416, 89, 23);
contentPane.add(btnSave);
// Cancel Button.
btnCancel = new JButton("CANCEL");
btnCancel.setFont(new Font("Serif", Font.PLAIN, 11));
btnCancel.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
cancel();
}
});
btnCancel.setEnabled(false);
btnCancel.setFocusable(false);
btnCancel.setBounds(681, 451, 89, 23);
contentPane.add(btnCancel);
// Records Label.
lblRecords = new JLabel("RECORDS: 0");
lblRecords.setFont(new Font("Serif", Font.PLAIN, 14));
lblRecords.setHorizontalAlignment(SwingConstants.LEFT);
lblRecords.setBounds(681, 378, 113, 29);
contentPane.add(lblRecords);
// Last Name TextField.
txtLastName = new JTextField();
txtLastName.setFont(new Font("Serif", Font.PLAIN, 13));
txtLastName.setEnabled(false);
txtLastName.setBackground(new Color(255, 255, 255));
txtLastName.setBounds(115, 71, 145, 20);
contentPane.add(txtLastName);
txtLastName.setColumns(10);
// ID Label.
lblId = new JLabel("");
lblId.setHorizontalAlignment(SwingConstants.LEFT);
lblId.setFont(new Font("Serif", Font.PLAIN, 14));
lblId.setBounds(115, 27, 49, 29);
contentPane.add(lblId);
JLabel lblFirstName = new JLabel("FIRST NAME:");
lblFirstName.setHorizontalAlignment(SwingConstants.LEFT);
lblFirstName.setFont(new Font("Serif", Font.BOLD, 14));
lblFirstName.setBounds(270, 65, 125, 29);
contentPane.add(lblFirstName);
JLabel lblMiddleName = new JLabel("MIDDLE NAME :");
lblMiddleName.setHorizontalAlignment(SwingConstants.RIGHT);
lblMiddleName.setFont(new Font("Serif", Font.BOLD, 14));
lblMiddleName.setBounds(507, 65, 125, 29);
contentPane.add(lblMiddleName);
// First Name TextField.
txtFirstName = new JTextField();
txtFirstName.setFont(new Font("Serif", Font.PLAIN, 13));
txtFirstName.setEnabled(false);
txtFirstName.setBackground(new Color(255, 255, 255));
txtFirstName.setColumns(10);
txtFirstName.setBounds(372, 71, 137, 20);
contentPane.add(txtFirstName);
// Middle Name TextField.
txtMiddleName = new JTextField();
txtMiddleName.setFont(new Font("Serif", Font.PLAIN, 13));
txtMiddleName.setEnabled(false);
txtMiddleName.setBackground(new Color(255, 255, 255));
txtMiddleName.setColumns(10);
txtMiddleName.setBounds(642, 71, 152, 20);
contentPane.add(txtMiddleName);
// Male RadioButton.
rdoMale = new JRadioButton("MALE");
rdoMale.setFont(new Font("Serif", Font.PLAIN, 11));
rdoMale.setSelected(true);
rdoMale.setEnabled(false);
rdoMale.setFocusable(false);
rdoMale.setBounds(115, 105, 109, 23);
contentPane.add(rdoMale);
// Female RadioButton.
rdoFemale = new JRadioButton("FEMALE");
rdoFemale.setFont(new Font("Serif", Font.PLAIN, 11));
rdoFemale.setEnabled(false);
rdoFemale.setFocusable(false);
rdoFemale.setBounds(249, 105, 109, 23);
contentPane.add(rdoFemale);
bgSex.add(rdoMale);
bgSex.add(rdoFemale);
// College ComboBox.
cboCollege = new JComboBox<Object>(collegeArr);
cboCollege.setFont(new Font("Serif", Font.PLAIN, 11));
cboCollege.setEnabled(false);
cboCollege.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
selectedCollege();
}
});
cboCollege.setFocusable(false);
cboCollege.setBounds(112, 140, 125, 22);
contentPane.add(cboCollege);
// Program ComboBox.
cboProgram = new JComboBox<Object>(modelProgram);
cboProgram.setFont(new Font("Serif", Font.PLAIN, 11));
cboProgram.setEnabled(false);
cboProgram.setFocusable(false);
cboProgram.setBounds(372, 140, 125, 22);
contentPane.add(cboProgram);
JLabel lblCollege = new JLabel("COLLEGE :");
lblCollege.setHorizontalAlignment(SwingConstants.LEFT);
lblCollege.setFont(new Font("Serif", Font.BOLD, 14));
lblCollege.setBounds(20, 136, 89, 29);
contentPane.add(lblCollege);
JLabel lblProgram = new JLabel("PROGRAM :");
lblProgram.setHorizontalAlignment(SwingConstants.LEFT);
lblProgram.setFont(new Font("Serif", Font.BOLD, 14));
lblProgram.setBounds(261, 136, 125, 29);
contentPane.add(lblProgram);
}
private void newRow() {
lblId.setText(String.valueOf(id));
changeInterface();
}
private void updateRow() {
isUpdate = true;
deleteAndUpdateRow();
}
private void deleteRow() {
isDelete = true;
deleteAndUpdateRow();
}
private void save() {
if (txtFirstName.getText().isBlank() || txtLastName.getText().isBlank()
|| txtMiddleName.getText().isBlank()) {
JOptionPane.showMessageDialog(contentPane, "PLEASE FILL UP ALL TEXTFIELD.", 
"WARNING!", JOptionPane.WARNING_MESSAGE);
} else {
String selectedSex = null;
if (rdoMale.isSelected()) {
selectedSex = rdoMale.getText();
} else {
selectedSex = rdoFemale.getText();
}
// Make the cell value in the center of the table.
rendar.setHorizontalAlignment(SwingConstants.CENTER);
 for (int i = 0; i < 7; i++) { // Continue to iterate through each column.
 tblPersonalInfo.getColumnModel().getColumn(i).setCellRenderer(rendar);
 }
if (isUpdate) {
int selectedRow = tblPersonalInfo.getSelectedRow(); // Get the index of the 
selected row.
// Update the value of the selected row.
modelPersonalInfo.setValueAt(txtFirstName.getText(), selectedRow, 1);
modelPersonalInfo.setValueAt(txtLastName.getText(), selectedRow, 2);
modelPersonalInfo.setValueAt(txtMiddleName.getText(), selectedRow, 3);
modelPersonalInfo.setValueAt(selectedSex, selectedRow, 4);
modelPersonalInfo.setValueAt(cboCollege.getSelectedItem(), selectedRow, 5);
modelPersonalInfo.setValueAt(cboProgram.getSelectedItem(), selectedRow, 6);
isUpdate = false;
JOptionPane.showMessageDialog(contentPane, "Update Success!");
} else {
Object[] rowData = new Object[7];
// Data will be processed into each column.
rowData[0] = lblId.getText();
rowData[1] = txtFirstName.getText();
rowData[2] = txtLastName.getText();
rowData[3] = txtMiddleName.getText();
rowData[4] = selectedSex;
rowData[5] = cboCollege.getSelectedItem().toString();
rowData[6] = cboProgram.getSelectedItem().toString();
modelPersonalInfo.addRow(rowData);
id++; // Increment id.
lblRecords.setText("RECORDS : " + tblPersonalInfo.getRowCount());
JOptionPane.showMessageDialog(contentPane, "STUDENT INFO HAS BEEN SAVED.");
}
 
 defaultInterface();
 tblPersonalInfo.clearSelection();
}
}
private void cancel() {
if (isUpdate) {
isUpdate = false;
} else if (isDelete) {
isDelete = false;
}
tblPersonalInfo.clearSelection();
lblId.setText(null);
defaultInterface();
}
private void selectedRow() {
int selectedRow = tblPersonalInfo.getSelectedRow();
if (selectedRow >= 0) {
if (isUpdate) {
changeInterface();
btnSave.setEnabled(true);
Object[] personalData = new Object[7];
// Get the data on the selected row.
for (int i = 0; i < 7; i++) {
personalData[i] = modelPersonalInfo.getValueAt(selectedRow, i);;
}
String selectedCollege = personalData[5].toString();
// The data gathered will be set for each component.
lblId.setText(personalData[0].toString());
txtFirstName.setText(personalData[1].toString());
txtLastName.setText(personalData[2].toString());
txtMiddleName.setText(personalData[3].toString());
cboCollege.setSelectedItem(selectedCollege);
cboProgram.setSelectedItem(personalData[6]);
if (personalData[4].toString().equals("MALE")) {
rdoMale.setSelected(true);
} else {
rdoFemale.setSelected(true);
}
cboProgram.setModel(modelProgram);
} else if (isDelete) {
int deleteConfirmation = JOptionPane.showConfirmDialog(
contentPane, "ARE YOU SURE YOU WANT TO DELETE THE SELECTED 
ROW?", "WARNING!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
if (deleteConfirmation == 0) {
modelPersonalInfo.removeRow(tblPersonalInfo.getSelectedRow());
lblRecords.setText("RECORDS : " + tblPersonalInfo.getRowCount());
JOptionPane.showMessageDialog(contentPane, "THE SELECTED ROW HAS BEEN 
DELETED.");
isDelete = false;
defaultInterface();
}
tblPersonalInfo.clearSelection();
}
}
}
private void selectedCollege() {
int selectedCollege = cboCollege.getSelectedIndex();
if (selectedCollege == 1) { // If CBAA is selected.
modelProgram = new DefaultComboBoxModel<Object>(cbaaArr);
} else if (selectedCollege == 2) { // If CCE is selected.
modelProgram = new DefaultComboBoxModel<Object>(cceArr);
} else if (selectedCollege == 3) { // If CON is selected.
modelProgram = new DefaultComboBoxModel<Object>(conArr);
} else { // If CEAS is selected.
modelProgram = new DefaultComboBoxModel<Object>(ceasArr);
}
cboProgram.setModel(modelProgram);
}
private void changeInterface() {
// Disable.
btnNew.setEnabled(false);
btnUpdate.setEnabled(false);
btnDelete.setEnabled(false);
// Enable.
btnSave.setEnabled(true);
btnCancel.setEnabled(true);
rdoMale.setEnabled(true);
rdoFemale.setEnabled(true);
cboCollege.setEnabled(true);
cboProgram.setEnabled(true);
txtFirstName.setEnabled(true);
txtLastName.setEnabled(true);
txtMiddleName.setEnabled(true);
}
private void defaultInterface() {
// Enable.
btnNew.setEnabled(true);
btnUpdate.setEnabled(true);
btnDelete.setEnabled(true);
// Disable.
btnSave.setEnabled(false);
btnCancel.setEnabled(false);
rdoMale.setEnabled(false);
rdoFemale.setEnabled(false);
cboCollege.setEnabled(false);
cboProgram.setEnabled(false);
tblPersonalInfo.setEnabled(false);
txtFirstName.setEnabled(false);
txtLastName.setEnabled(false);
txtMiddleName.setEnabled(false);
// Back to Default Interface.
lblId.setText(null);
txtFirstName.setText(null);
txtLastName.setText(null);
txtMiddleName.setText(null);
rdoMale.setSelected(true);
cboCollege.setSelectedIndex(0);
cboProgram.setSelectedIndex(0);
}
private void deleteAndUpdateRow() {
// Enable.
tblPersonalInfo.setEnabled(true);
btnCancel.setEnabled(true);
// Disable.
btnNew.setEnabled(false);
btnUpdate.setEnabled(false);
btnDelete.setEnabled(false);
}
}
