import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

public class Notebook extends JFrame {
    private JLabel LastNameLabel = new JLabel("Name");
    private JTextField LastNameField = new JTextField();
    private JLabel TelephoneLabel = new JLabel("Telephone");
    private JTextField TelephoneField = new JTextField();
    private JButton PrintBtn = new JButton("Print");
    private JButton AddBtn = new JButton("Add");
    private JLabel Note = new JLabel("Records");
    private JTextField NoteCount = new JTextField();
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    //TreeSet<String> treeSet = new TreeSet<>();
    Map<String,String> bookList = new HashMap<>();

    public Notebook()
    {
        setTitle("Записна книга");
        setSize(500,350); setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); setLocationRelativeTo(null); setResizable(false);
        panel1.setLayout(new GridLayout(0,1,10,10));
        panel1.setBorder(BorderFactory.createEmptyBorder(20,20,30,30));
        panel1.add(LastNameLabel); panel1.add(LastNameField);
        panel1.add(TelephoneLabel); panel1.add(TelephoneField);
        AddBtn.addActionListener(new AddBtnEventListener()); PrintBtn.addActionListener(new PrintBtnEventListener());
        panel1.add(AddBtn); panel1.add(PrintBtn);
        add(panel1, BorderLayout.NORTH);

        panel2.setLayout(new FlowLayout());
        panel2.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));
        Note.setHorizontalAlignment(JLabel.CENTER); NoteCount.setHorizontalAlignment(JTextField.CENTER);
        NoteCount.setPreferredSize(new Dimension(50,20)); NoteCount.setEnabled(false);
        NoteCount.setText("0");
        panel2.add(Note); panel2.add(NoteCount);
        add(panel2, BorderLayout.SOUTH);

        setVisible(true);
    }
    class AddBtnEventListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(LastNameField.getText().equals("") && TelephoneField.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"Two empty fields!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if(LastNameField.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"Enter your name!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if(TelephoneField.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"Enter your telephone!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else {
                String lastname = LastNameField.getText();
                String telephone = TelephoneField.getText();
                //treeSet.add(lastname);
                //treeSet.add(telephone);
                bookList.put(telephone,lastname);
                JOptionPane.showMessageDialog(null,"Added to book!", "Info", JOptionPane.INFORMATION_MESSAGE);
                LastNameField.setText(null); TelephoneField.setText(null); NoteCount.setText(Integer.toString(bookList.size()));
            }
        }
    }
    class PrintBtnEventListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(bookList.size() == 0)
            {
                JOptionPane.showMessageDialog(null,"The book is empty!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else {
                String msg = "List:\n";
                for(Map.Entry mp: bookList.entrySet())
                {
                    msg += mp.getValue() + " " + mp.getKey() + "\n";
                }
                JOptionPane.showMessageDialog(null, msg, "List", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
