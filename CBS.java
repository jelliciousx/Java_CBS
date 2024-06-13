import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
public class CBS implements ActionListener {
    JButton b1, b2, b3;
    JLabel l1;
    JFrame f;

    CBS() {
        f = new JFrame("Customer Billing System");
        f.getContentPane().setFont(new Font("Arial Narrow", Font.PLAIN, 11));
        f.getContentPane().setBackground(new Color(65, 65, 65));
        l1 = new JLabel("Customer Billing System");
        l1.setForeground(new Color(255, 255, 255));
        l1.setFont(new Font("Bradley Hand ITC", Font.BOLD, 25));
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        l1.setBounds(135, 23, 435, 73);

        // Button
        b1 = new JButton("Click to Add Customer");
        b1.setFont(new Font("Arial Narrow", Font.BOLD, 15));
        b1.setBounds(230, 140, 208, 32);
        b1.addActionListener(this);
        b2 = new JButton("Exit");
        b2.setFont(new Font("Arial Narrow", Font.BOLD, 15));
        b2.setBounds(576, 284, 100, 40);
        b2.addActionListener(this);
        b3 = new JButton("Logout");
        b3.setFont(new Font("Arial Narrow", Font.BOLD, 15));
        b3.setBounds(10, 284, 100, 40);
        b3.addActionListener(this);

        // Adding frame pane and size
        f.getContentPane().add(b3);
        f.getContentPane().add(b1);
        f.getContentPane().add(b2);
        f.getContentPane().add(l1);
        f.setResizable(false);
        f.setSize(700, 400);
        f.setLocation(220, 100);
        f.getContentPane().setLayout(null);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            new Add();
            f.dispose();
        } else if (e.getSource() == b2) {
            f.dispose();
        } else if (e.getSource() == b3) {
            f.dispose();
            new Password();
        }
    }

    public static void main(String[] args) {
        new CBS();
    }
}

class Add implements ActionListener {
    DefaultTableModel model;
    JTable table;
    JTextArea ta;
    JTextField nameField, phoneField, emailField;
    JButton addButton, updateButton, deleteButton;
    JButton Backbutton;
    JFrame f;
    JScrollPane pane;

    Add() {
        f = new JFrame("CBS SYSTEM");
        f.getContentPane().setBackground(new Color(65, 65, 65));
        model = new DefaultTableModel();

        // Name and Labels
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setForeground(new Color(255, 255, 255));
        nameLabel.setFont(new Font("Arial Narrow", Font.BOLD, 15));
        nameLabel.setBounds(10, 40, 73, 20);
        nameField = new JTextField();
        nameField.setBounds(146, 40, 200, 30);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setForeground(new Color(255, 255, 255));
        phoneLabel.setFont(new Font("Arial Narrow", Font.BOLD, 15));
        phoneLabel.setBounds(10, 89, 83, 20);
        phoneField = new JTextField();
        phoneField.setBounds(146, 90, 200, 27);

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setForeground(new Color(255, 255, 255));
        addressLabel.setFont(new Font("Arial Narrow", Font.BOLD, 15));
        addressLabel.setBounds(10, 137, 111, 20);
        ta = new JTextArea();
        ta.setBounds(148, 137, 198, 74);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setForeground(new Color(255, 255, 255));
        emailLabel.setFont(new Font("Arial Narrow", Font.BOLD, 15));
        emailLabel.setBounds(10, 233, 150, 20);
        emailField = new JTextField();
        emailField.setBounds(148, 235, 200, 27);

        // Buttons
        addButton = new JButton("Add");
        addButton.setFont(new Font("Arial Narrow", Font.BOLD, 15));
        addButton.setBounds(37, 339, 122, 34);
        addButton.addActionListener(this);

        updateButton = new JButton("Update");
        updateButton.setFont(new Font("Arial Narrow", Font.BOLD, 15));
        updateButton.setBounds(37, 455, 122, 34);
        updateButton.addActionListener(this);

        deleteButton = new JButton("Delete");
        deleteButton.setFont(new Font("Arial Narrow", Font.BOLD, 15));
        deleteButton.setBounds(38, 397, 122, 34);
        deleteButton.addActionListener(this);

        Backbutton = new JButton(" <-Back");
        Backbutton.setFont(new Font("Arial Narrow", Font.BOLD, 15));
        Backbutton.setBounds(730, 568, 122, 34);
        Backbutton.addActionListener(this);

        // Adding Table
        String columnname[] = {"Name", "Phone", "Address", "Email"};
        table = new JTable(model);
        model.setColumnIdentifiers(columnname);
        pane = new JScrollPane(table);
        pane.setLocation(400, 40);
        pane.setSize(452, 468);

        // Adding on frame
        f.getContentPane().add(emailLabel);
        f.getContentPane().add(addressLabel);
        f.getContentPane().add(phoneLabel);
        f.getContentPane().add(nameLabel);
        f.getContentPane().add(Backbutton);
        f.getContentPane().add(addButton);
        f.getContentPane().add(ta);
        f.getContentPane().add(deleteButton);
        f.getContentPane().add(emailField);
        f.getContentPane().add(updateButton);
        f.getContentPane().add(phoneField);
        f.getContentPane().add(nameField);
        f.getContentPane().add(pane);

        f.getContentPane().setLayout(null);
        f.setSize(900, 650);
        f.setLocation(220, 50);
        f.setResizable(false);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Mouse Event
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int rowindex = table.getSelectedRow();
                String name = (String) (model.getValueAt(rowindex, 0));
                String phone = (String) model.getValueAt(rowindex, 1);
                String address = (String) model.getValueAt(rowindex, 2);
                String email = (String) model.getValueAt(rowindex, 3);

                nameField.setText(name);
                phoneField.setText(phone);
                ta.setText(address);
                emailField.setText(email);
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String name, email, phone, address;
            name = nameField.getText();
            phone = phoneField.getText();
            address = ta.getText();
            email = emailField.getText();

            if (name.isEmpty() || phone.isEmpty() || email.isEmpty() || address.isEmpty()) {
                JOptionPane.showMessageDialog(f, "Please Provide the Customer Info!!");
            } else {
                model.addRow(new String[]{name, phone, address, email});

                nameField.setText("");
                phoneField.setText("");
                ta.setText("");
                emailField.setText("");
                JOptionPane.showMessageDialog(null, "Added Successfully....");
            }
        } else if (e.getSource() == updateButton) {
            if (table.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "Please Select the data!!");
            } else {
                String name = nameField.getText();
                String phone = phoneField.getText();
                String address = ta.getText();
                String email = emailField.getText();
                int row = table.getSelectedRow();
                model.setValueAt(name, row, 0);
                model.setValueAt(phone, row, 1);
                model.setValueAt(address, row, 2);
                model.setValueAt(email, row, 3);

                nameField.setText("");
                phoneField.setText("");
                emailField.setText("");
                ta.setText("");

                JOptionPane.showMessageDialog(null, "Updated Successfully....");
            }
        } else if (e.getSource() == deleteButton) {
            if (table.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "Please Select the data!!");
            } else {
                model.removeRow(table.getSelectedRow());

                nameField.setText("");
                phoneField.setText("");
                emailField.setText("");
                ta.setText("");
                JOptionPane.showMessageDialog(null, "Data Deleted.....");
            }
        } else if (e.getSource() == Backbutton) {
            f.dispose();
            new CBS();
        }
    }
}

class Password extends KeyAdapter implements ActionListener {
    JLabel l, l1, l2;
    JFrame f;
    JPasswordField p;
    JTextField tf1;
    JButton b;

    Password() {
        f = new JFrame("CBS SYSTEM");
        f.getContentPane().setForeground(new Color(255, 255, 255));
        f.getContentPane().setBackground(new Color(65, 65, 65));

        l = new JLabel("Homepage");
        l.setForeground(new Color(255, 255, 255));
        l.setFont(new Font("Bell MT", Font.BOLD, 16));
        l.setBackground(new Color(0, 0, 0));
        l.setBounds(289, 11, 150, 40);

        l1 = new JLabel("Username");
        l1.setForeground(new Color(255, 255, 255));
        l1.setFont(new Font("Arial Narrow", Font.BOLD, 15));
        l1.setBounds(151, 89, 150, 30);
        tf1 = new JTextField();
        tf1.setBounds(256, 89, 150, 30);

        l2 = new JLabel("Password");
        l2.setFont(new Font("Arial Narrow", Font.BOLD, 15));
        l2.setForeground(new Color(255, 255, 255));
        l2.setBounds(151, 141, 150, 30);

        p = new JPasswordField();
        p.setBounds(256, 141, 150, 30);

        b = new JButton("Login");
        b.setFont(new Font("Arial Narrow", Font.BOLD, 14));
        b.setBounds(403, 195, 80, 25);
        b.addActionListener(this);

        // Adding Enter Key
        p.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String name = tf1.getText();
                    String P1 = p.getText();

                    if (name.equals("shayan007") && P1.equals("Mango")) {
                        f.dispose();
                        new CBS();
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Username & Password !!!!");
                    }
                }
            }
        });

        f.getContentPane().add(l2);
        f.getContentPane().add(l1);
        f.getContentPane().add(p);
        f.getContentPane().add(b);
        f.getContentPane().add(tf1);
        f.getContentPane().setLayout(null);
        f.getContentPane().add(l);
        f.setSize(700, 400);
        f.setLocation(220, 100);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                String name = tf1.getText();
                String P1 = p.getText();

                if (name.equals("shayan007") && P1.equals("Mango")) {
                    f.dispose();
                    new CBS();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username & Password !!!!");
                }
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        String name = tf1.getText();
        String P1 = p.getText();

        if (name.equals("shayan007") && P1.equals("Mango")) {
            f.dispose();
            new CBS();
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Username & Password !!!!");
        }
    }

    public void keyReleased(KeyEvent e) {
        String name = tf1.getText();
        String P1 = p.getText();

        if (name.equals("shayan007") && P1.equals("Mango")) {
            f.dispose();
            new CBS();
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Username & Password !!!!");
        }
    }
}
