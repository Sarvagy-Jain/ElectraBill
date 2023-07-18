package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class ViewInformation extends JFrame implements ActionListener{

    JButton cancel;
    ViewInformation(String meter) {
        setBounds(350, 150, 700, 400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        JLabel heading = new JLabel("VIEW CUSTOMER INFORMATION");
        heading.setBounds(175, 0, 500, 40);
        heading.setForeground(Color.decode("#00468b"));
        heading.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(heading);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(70, 80, 100, 20);
        add(lblname);
        
        JLabel name = new JLabel("");
        name.setBounds(200, 80, 100, 20);
        add(name);
        
        JLabel lblmeternumber = new JLabel("Meter Number");
        lblmeternumber.setBounds(70, 110, 100, 20);
        add(lblmeternumber);
        
        JLabel meternumber = new JLabel("");
        meternumber.setBounds(200, 110, 100, 20);
        add(meternumber);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(70, 140, 100, 20);
        add(lbladdress);
        
        JLabel address = new JLabel("");
        address.setBounds(200, 140, 100, 20);
        add(address);
        
        JLabel lblcity = new JLabel("City");
        lblcity.setBounds(70, 170, 100, 20);
        add(lblcity);
        
        JLabel city = new JLabel("");
        city.setBounds(200, 170, 100, 20);
        add(city);
        
        JLabel lblstate = new JLabel("State");
        lblstate.setBounds(70, 200, 100, 20);
        add(lblstate);
        
        JLabel state = new JLabel("");
        state.setBounds(200, 200, 100, 20);
        add(state);
        
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(70, 230, 100, 20);
        add(lblemail);
        
        JLabel email = new JLabel("");
        email.setBounds(200, 230, 150, 20);
        add(email);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(70, 260, 100, 20);
        add(lblphone);
        
        JLabel phone = new JLabel("");
        phone.setBounds(200, 260, 100, 20);
        add(phone);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where meter_no = '"+meter+"'");
            while(rs.next()) {
                name.setText(rs.getString("name"));
                address.setText(rs.getString("address"));
                city.setText(rs.getString("city"));
                state.setText(rs.getString("state"));
                email.setText(rs.getString("email"));
                phone.setText(rs.getString("phone"));
                meternumber.setText(rs.getString("meter_no"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        cancel = new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.decode("#00468b"));
        cancel.setBounds(300, 325, 100, 25);
        add(cancel);
        cancel.addActionListener(this);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/user_information.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 35, 400, 300);
        add(image);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }
    
    public static void main(String[] args) {
        new ViewInformation("");
    }
}