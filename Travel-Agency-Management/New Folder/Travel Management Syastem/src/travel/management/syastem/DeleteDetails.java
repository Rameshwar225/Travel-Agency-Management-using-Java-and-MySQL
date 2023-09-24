
package travel.management.syastem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;


public class DeleteDetails extends JFrame implements ActionListener{
    JButton back,delete;
    String username;
    DeleteDetails(String username)
    {
        this.username = username;
        setBounds(450,180,870,625);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);
        
        
        JLabel labelusername = new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);
        
        
        JLabel lblid = new JLabel("ID");
        lblid.setBounds(30,90,150,25);
        add(lblid);
        
        
        JLabel labelid = new JLabel();
        labelid.setBounds(220,90,150,25);
        add(labelid);
        
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30,130,150,25);
        add(lblnumber);
        
        
        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(220,130,150,25);
        add(labelnumber);
        
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30,170,150,25);
        add(lblname);
        
        
        JLabel labelname = new JLabel();
        labelname.setBounds(220,170,150,25);
        add(labelname);
        
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(30,210,150,25);
        add(lblgender);
        
        
        JLabel labelgender = new JLabel();
        labelgender.setBounds(220,210,150,25);
        add(labelgender);
        
        JLabel lblcountry = new JLabel("country");
        lblcountry.setBounds(500,50,150,25);
        add(lblcountry);
        
        
        JLabel labelcountry = new JLabel();
        labelcountry.setBounds(690,50,150,25);
        add(labelcountry);
        
        
        JLabel lbladdress = new JLabel("Adress");
        lbladdress.setBounds(500,90,150,25);
        add(lbladdress);
        
        
        JLabel labeladdress = new JLabel();
        labeladdress.setBounds(690,90,150,25);
        add(labeladdress);
        
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(500,130,150,25);
        add(lblphone);
        
        
        JLabel labelphone = new JLabel();
        labelphone.setBounds(690,130,150,25);
        add(labelphone);
        
        
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(500,170,150,25);
        add(lblemail);
        
        
        JLabel labelemail = new JLabel();
        labelemail.setBounds(690,170,150,25);
        add(labelemail);
        
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.setBorder(BorderFactory.createEmptyBorder());
        back.setBounds(450, 350, 100, 25);
        back.addActionListener(this);
        add(back);
        
        delete = new JButton("Detele");
        delete.setBackground(Color.black);
        delete.setForeground(Color.WHITE);
        delete.setBorder(BorderFactory.createEmptyBorder());
        delete.setBounds(200, 350, 100, 25);
        delete.addActionListener(this);
        add(delete);
        
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(20 ,400 ,600, 200);
        add(image);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ac)
    {
        if(ac.getSource()==back)
        {
            setVisible(false);
        }
        else if(ac.getSource()==delete)
        {
            try{
                Conn c = new Conn();
                String query = "delete  from customer where username = '"+username+"'";
                c.s.executeUpdate(query);
                     
                JOptionPane.showMessageDialog(null, "Customer details added succsessfully");
                setVisible(false);                
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] arg)
    {
        new DeleteDetails("");
    }
    
}
