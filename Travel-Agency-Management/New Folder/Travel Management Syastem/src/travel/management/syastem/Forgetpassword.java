package travel.management.syastem;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Forgetpassword extends JFrame implements ActionListener{
    
    JTextField tfusername,tfname,tfquestion,tfanswer,tfpassword;
    JButton search,retrieve,back;
    Forgetpassword()
    {
        setBounds(350,200,850,380);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT); 
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580, 70, 200, 200);
        add(image);
        
        JPanel p1 = new JPanel();
        p1.setBounds(30,30,500,280);
        p1.setLayout(null);
        p1.setBackground(new Color(133,193,233));
        add(p1);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("Tahoma",Font.BOLD,14));
        lblusername.setBounds(40,20,100,25);
        p1.add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(220, 20, 150, 25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);
        
        search = new JButton("Search");
        search.setBounds(400, 20, 80, 25);
        search.setBackground(Color.WHITE);
        search.setForeground(new Color(133,193,233));
        search.setBorder(BorderFactory.createEmptyBorder());
        search.addActionListener(this);
        p1.add(search);
        
        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("Tahoma",Font.BOLD,14));
        lblname.setBounds(40,60,100,25);
        p1.add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(220, 60, 150, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);
        
        JLabel lblquestion = new JLabel("Sequrity Question");
        lblquestion.setFont(new Font("Tahoma",Font.BOLD,14));
        lblquestion.setBounds(40,100,150,25);
        p1.add(lblquestion);
        
        tfquestion = new JTextField();
        tfquestion.setBounds(220, 100, 150, 25);
        tfquestion.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfquestion);
        
        
        
        JLabel lblanswer = new JLabel("Answer");
        lblanswer.setFont(new Font("Tahoma",Font.BOLD,14));
        lblanswer.setBounds(40,140,150,25);
        p1.add(lblanswer);
        
        tfanswer = new JTextField();
        tfanswer.setBounds(220, 140, 150, 25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);
        
        
        retrieve = new JButton("Retrieve");
        retrieve.setBounds(400, 140, 80, 25);
        retrieve.setBackground(Color.WHITE);
        retrieve.setForeground(new Color(133,193,233));
        retrieve.setBorder(BorderFactory.createEmptyBorder());
        retrieve.addActionListener(this);
        p1.add(retrieve);
        
        
        JLabel lblpassword = new JLabel("Your Password");
        lblpassword.setFont(new Font("Tahoma",Font.BOLD,14));
        lblpassword.setBounds(40,180,150,25);
        p1.add(lblpassword);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(220, 180, 150, 25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);
        
        
        back = new JButton("Back");
        back.setBounds(240, 220, 80, 25);
        back.setBackground(Color.WHITE);
        back.setForeground(new Color(133,193,233));
        back.setBorder(BorderFactory.createEmptyBorder());
        back.addActionListener(this);
        p1.add(back);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ac)
    {
        if(ac.getSource()==search)
        {
               try
            {
                String query = "Select * from account where username ='"+tfusername.getText()+"' ";
                Conn c = new Conn();
                ResultSet rs =  c.s.executeQuery(query);
                
                while(rs.next())
                {
                    tfname.setText(rs.getString("name"));
                    tfquestion.setText(rs.getString("security"));
                }
                
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(ac.getSource()==retrieve)
        {
            try
            {
                String query = "Select * from account where answer ='"+tfanswer.getText()+"'And username='"+tfusername.getText()+"' ";
                Conn c = new Conn();
                ResultSet rs =  c.s.executeQuery(query);
                
                while(rs.next())
                {
                    tfpassword.setText(rs.getString("password"));
                    
                }
                
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            
        }
        else if(ac.getSource()==back)
        {
            setVisible(false);
            new Login();
        }
    }
    
    public static void main(String[] arg)
    {
        new Forgetpassword();
    }
    
}
