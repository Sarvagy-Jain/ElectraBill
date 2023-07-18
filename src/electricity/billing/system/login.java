package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class login extends JFrame implements ActionListener{
    JButton login, cancel, signup;
    JTextField username, password;
    Choice logginin;
    
    login() {   
        super("Login Page");// IT MUST BE THE FIRST STATEMENT IN CONSTRUCTOR 
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        
        // JLabel is used towrite on frame

        JLabel userName_label = new JLabel("Username");
        userName_label.setBounds(300,0,300,30)  ;
        add(userName_label);
        
        username = new JTextField();
        username.setBounds(300,30, 150, 20);
        add(username);   
        
        
        JLabel password_label = new JLabel("Password");
        password_label.setBounds(300,60,300,30)  ;
        add(password_label);
        
        password = new JTextField();
        password.setBounds(300, 90, 150, 20);
        add(password);
        
        JLabel userRole_label = new JLabel("Login As ");
        userRole_label.setBounds(300,120,300,30)  ;
        add(userRole_label);
        
        logginin = new Choice();
        logginin.add("Admin");
        logginin.add("Customer");
        logginin.setBounds(300, 150, 150,20);
        add(logginin);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i2 = i1.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        login = new JButton("Login", new ImageIcon(i2));
        login.setBounds(275, 210, 100, 20);
        login.addActionListener(this);
        add(login);
        
        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
        Image i4 = i3.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        cancel = new JButton("Cancel", new ImageIcon(i4));
        cancel.setBounds(400, 210, 100, 20);
        cancel.addActionListener(this);
        add(cancel);
                        
        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
        Image i6 = i5.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        signup = new JButton("Signup", new ImageIcon(i6));
        signup.setBounds(325, 240, 100, 20);
        signup.addActionListener(this);
        add(signup);
        
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icon/man.png"));
        Image i8 = i7.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel image = new JLabel(i9);
        image.setBounds(0, 0, 230, 250);
        add(image);
        
        setSize(550,320);
        setLocation(450,200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            String susername = username.getText();
            String spassword = password.getText();
            String user = logginin.getSelectedItem();
            
            try {
                Conn c = new Conn();
                String query = "select * from login where username = '"+susername+"' and password = '"+spassword+"' and user = '"+user+"'";
                
                ResultSet rs = c.s.executeQuery(query);
                
                if (rs.next()) {
                    String meter = rs.getString("meter_no");
                    setVisible(false);
                    new project(user, meter);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Login");
                    username.setText("");
                    password.setText("");// to make text field empty
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        } else if (ae.getSource() == signup) {
            setVisible(false);
            
            new signup();
        }
    }
    
    public static void main(String[] args) {
        new login();
    }
}
 
