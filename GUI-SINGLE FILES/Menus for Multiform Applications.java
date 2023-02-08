import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
public class Main extends JFrame {
 private String holder;
 private Path path;
 private final JMenuItem mntmCut, mntmCopy;
 private final JMenuItem mntmPopCut, mntmPopCopy;
 private final JPanel contentPane;
 private final JFileChooser fileChooser;
 private final JTextPane textPane;
 /**
 * Launch the application.
 */
 public static void main(String[] args) {
 EventQueue.invokeLater(() -> {
 try {
 Main frame = new Main();
 frame.setVisible(true);
 } catch (Exception e) {
 e.printStackTrace();
 }
 });
 }
 /**
 * Create the frame.
 */
 public Main() {
 setFont(new Font("Serif", Font.PLAIN, 12));
 setTitle("TEXT EDITOR");
 setBounds(100, 100, 680, 410);
 setLocationRelativeTo(null);
 addWindowListener(new WindowAdapter() {
 public void windowClosing(WindowEvent e) {
 JFrame frame = (JFrame) e.getSource(); // Return the object that initially occurred.
 if (path != null && textPane.getText().equals(holder) || textPane.getText().isBlank()) {
 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 } else {
 int confirmation = JOptionPane.showConfirmDialog(contentPane,
 "DO YOU WANT TO SAVE CHANGE", "TEXT EDITOR",
 JOptionPane.YES_NO_CANCEL_OPTION);
 if (confirmation == 0) {
 save();
 frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
 } else if (confirmation == 1) {
 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 } else {
 frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
 }
 }
 }
 });
 // File Chooser.
 fileChooser = new JFileChooser();
 fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Text Files", "txt"));
 fileChooser.setAcceptAllFileFilterUsed(true);
 // Menu Bar.
 JMenuBar menuBar = new JMenuBar();
 setJMenuBar(menuBar);
 // File Menu.
 JMenu mnFile = new JMenu("File");
 mnFile.setFont(new Font("Serif", Font.PLAIN, 12));
 mnFile.setMnemonic(KeyEvent.VK_F);
 menuBar.add(mnFile);
 // New Menu Item.
 JMenuItem mntmNew = new JMenuItem("New");
 mntmNew.setFont(new Font("Serif", Font.PLAIN, 12));
 mntmNew.addActionListener(e -> newFile());
 mntmNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
 mnFile.add(mntmNew);
 // Open Menu Item.
 JMenuItem mntmOpen = new JMenuItem("Open");
 mntmOpen.setFont(new Font("Serif", Font.PLAIN, 12));
 mntmOpen.addActionListener(e -> open());
 mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
 mnFile.add(mntmOpen);
 // Save Menu Item.
 JMenuItem mntmSave = new JMenuItem("Save");
 mntmSave.setFont(new Font("Serif", Font.PLAIN, 12));
 mntmSave.addActionListener(e -> save());
 mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
 mnFile.add(mntmSave);
 JSeparator separator = new JSeparator();
 mnFile.add(separator);
 // Print Menu Item.
 JMenuItem mntmPrint = new JMenuItem("Print");
 mntmPrint.setFont(new Font("Serif", Font.PLAIN, 12));
 mntmPrint.addActionListener(e -> print());
 mntmPrint.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK));
 mnFile.add(mntmPrint);
 // Edit Menu.
 JMenu mnEdit = new JMenu("Edit");
 mnEdit.setFont(new Font("Serif", Font.PLAIN, 12));
 mnEdit.setMnemonic(KeyEvent.VK_E);
 menuBar.add(mnEdit);
 // Cut Menu Item.
 mntmCut = new JMenuItem("Cut");
 mntmCut.setFont(new Font("Serif", Font.PLAIN, 12));
 mntmCut.addActionListener(e -> copyAndPaste(0));
 mntmCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK));
 mntmCut.setEnabled(false);
 mnEdit.add(mntmCut);
 // Copy Menu Item.
 mntmCopy = new JMenuItem("Copy");
 mntmCopy.setFont(new Font("Serif", Font.PLAIN, 12));
 mntmCopy.addActionListener(e -> copyAndPaste(1));
 mntmCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));
 mntmCopy.setEnabled(false);
 mnEdit.add(mntmCopy);
 // Paste Menu Item.
 JMenuItem mntmPaste = new JMenuItem("Paste");
 mntmPaste.setFont(new Font("Serif", Font.PLAIN, 12));
 mntmPaste.addActionListener(e -> copyAndPaste(2));
 mntmPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK));
 mnEdit.add(mntmPaste);
 contentPane = new JPanel();
 contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
 contentPane.setLayout(new BorderLayout(0, 0));
 setContentPane(contentPane);
 JScrollPane scrollPane = new JScrollPane();
 contentPane.add(scrollPane, BorderLayout.CENTER);
 // Text Pane.
 textPane = new JTextPane();
 textPane.setFont(new Font("Serif", Font.PLAIN, 14));
 textPane.addMouseListener(new MouseAdapter() {
 @Override
 public void mouseClicked(MouseEvent e) {
 editMenu();
 }
 public void mouseExited(MouseEvent e1) {
 editMenu();
 }
 });
 scrollPane.setViewportView(textPane);
 // Close Menu.
 JMenu mnClose = new JMenu("Close");
 mnClose.setFont(new Font("Serif", Font.PLAIN, 12));
 mnClose.setMnemonic(KeyEvent.VK_C);
 menuBar.add(mnClose);
 // Exit Menu Item.
 JMenuItem mntmExit = new JMenuItem("Exit");
 mntmExit.setFont(new Font("Serif", Font.PLAIN, 12));
 mntmExit.addActionListener(e -> exit());
 mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, KeyEvent.ALT_DOWN_MASK));
 mnClose.add(mntmExit);
 // Pop-up Menu.
 JPopupMenu popupMenu = new JPopupMenu();
 popupMenu.setFont(new Font("Serif", Font.PLAIN, 12));
 addPopup(textPane, popupMenu);
 // Cut Pop-up Item.
 mntmPopCut = new JMenuItem("Cut");
 mntmPopCut.addActionListener(e -> copyAndPaste(0));
 mntmPopCut.setEnabled(false);
 popupMenu.add(mntmPopCut);
 // Copy Pop-up Item.
 mntmPopCopy = new JMenuItem("Copy");
 mntmPopCopy.addActionListener(e -> copyAndPaste(1));
 mntmPopCopy.setEnabled(false);
 popupMenu.add(mntmPopCopy);
 // Paste Pop-up Item.
 JMenuItem mntmPopPaste = new JMenuItem("Paste");
 mntmPopPaste.addActionListener(e -> copyAndPaste(2));
 popupMenu.add(mntmPopPaste);
 }
 private void addPopup(Component component, final JPopupMenu popup) {
 component.addMouseListener(new MouseAdapter() {
 public void mousePressed(MouseEvent e) {
 if (e.isPopupTrigger()) {
 showMenu(e);
 }
 }
 public void mouseReleased(MouseEvent e) {
 if (e.isPopupTrigger()) {
 showMenu(e);
 }
 }
 private void showMenu(MouseEvent e) {
 popup.show(e.getComponent(), e.getX(), e.getY());
 }
 });
 }
 // Methods.
 private void bufferFile(File file) { // a method with parameter to buffer the file.
 try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
 bw.write(textPane.getText());
 bw.flush();
 } catch (IOException e) {
 // TODO Auto-generated catch block
 e.printStackTrace();
 }
 path = Paths.get(file.toString());
 }
 private void openSelectedFile() { // a method for opening selected file.
 int value = fileChooser.showOpenDialog(contentPane);
 if (value == 0) {
 StringBuilder sb = new StringBuilder();
 File selectedFile = fileChooser.getSelectedFile();
 path = Paths.get(selectedFile.getPath());
 String line;
 try(BufferedReader br = new BufferedReader(new FileReader(selectedFile.getPath()))) {
 while ((line = br.readLine()) != null) {
 sb.append(line).append("\n"); // Getting the text of the selected file.
 }
 } catch (IOException e) {
 // TODO Auto-generated catch block
 e.printStackTrace();
 }
 holder = sb.toString();
 textPane.setText(holder);
 }
 }
 private void newFile() { // a method for creating new file.
 if (path != null && textPane.getText().equals(holder) || textPane.getText().isBlank()) {
 textPane.setText(null);
 path = null;
 } else {
 int confirmation = JOptionPane.showConfirmDialog(contentPane, "DO YOU WANT TO SAVE CHANGE",
 "TEXT EDITOR", JOptionPane.YES_NO_CANCEL_OPTION);
 if (confirmation == 0) {
 save();
 } else if (confirmation == 1) {
 textPane.setText(null);
 path = null;
 }
 }
 }
 private void open() { // Open existing file.
 if (textPane.getText().isBlank() && path == null) {
 openSelectedFile();
 } else {
 int confirmation = JOptionPane.showConfirmDialog(contentPane,
 "DO YOU WANT TO SAVE CHANGE?",
 "CONFIRM", JOptionPane.YES_NO_CANCEL_OPTION);
 if (confirmation == 0) {
 save();
 } else if (confirmation == 1) {
 openSelectedFile();
 }
 }
 }
 private void save() { // a method for saving the file.
 if (path != null) {
 // The class of BufferedWriter with the instance of writer makes the performance fast.
 // new FileWriter with the parameter containing the path to the save file.
 try (BufferedWriter bw = new BufferedWriter(new FileWriter(path.toString()))) {
 bw.write(textPane.getText());
 bw.flush();
 } catch (IOException e) {
 // TODO Auto-generated catch block
 e.printStackTrace();
 }
 } else {
 boolean save;
 do {
 int value = fileChooser.showSaveDialog(contentPane);
 save = false;
 if (value == 0) {
 File file = new File(fileChooser.getSelectedFile().toString() + ".txt");
 if (!file.exists()) {
 bufferFile(file);
 } else {
 int response = JOptionPane.showConfirmDialog(null,
 "DO YOU WANT TO REPLACE THE EXISTING FILE?", "CONFIRM",
 JOptionPane.YES_NO_OPTION,
 JOptionPane.QUESTION_MESSAGE);
 save = true;
 if (response == 0) {
 bufferFile(file);
 save = false;
 }
 }
 }
 } while (save); // Loop while the response is no.
 }
 holder = textPane.getText();
 }
 private void print() {
 try {
 textPane.print();
 } catch (PrinterException e) {
 e.printStackTrace();
 }
 }
 private void editMenu() { // A method When you click an edit menu, it will enable items if you select text.
 if (textPane.getSelectedText() != null) {
 mntmCut.setEnabled(true);
 mntmPopCut.setEnabled(true);
 mntmCopy.setEnabled(true);
 mntmPopCopy.setEnabled(true);
 } else {
 mntmCut.setEnabled(false);
 mntmPopCut.setEnabled(false);
 mntmCopy.setEnabled(false);
 mntmPopCopy.setEnabled(false);
 }
 }
 private void copyAndPaste(int value) { // a method with parameter to get the value of the selected action.
 StringSelection stringSelection = new StringSelection(textPane.getSelectedText());
 Clipboard clipBoard = Toolkit.getDefaultToolkit().getSystemClipboard();
 if (value == 0) {
 textPane.cut();
 } else if (value == 1) {
 clipBoard.setContents(stringSelection, null);
 } else {
 Transferable transferable = clipBoard.getContents(null);
 if (transferable != null && transferable.isDataFlavorSupported(DataFlavor.stringFlavor)) {
 try {
 textPane.setText(textPane.getText() +
 transferable.getTransferData(DataFlavor.stringFlavor));
 } catch (UnsupportedFlavorException | IOException e) {
 e.printStackTrace();
 }
 }
 }
 }
 private void exit() {
 if (path != null && textPane.getText().equals(holder) || textPane.getText().isBlank()) {
 System.exit(0);
 } else {
 int confirmation = JOptionPane.showConfirmDialog(contentPane, "DO YOU WANT TO SAVE CHANGE?",
 "TEXT EDITOR", JOptionPane.YES_NO_CANCEL_OPTION);
 if (confirmation == 0) {
 save();
 this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
 } else if (confirmation == 1) {
 System.exit(0);
 }
 }
 }
}
