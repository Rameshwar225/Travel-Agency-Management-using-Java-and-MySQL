package travel.management.syastem;

import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*; //Color class is belong in awt Package so we import it
public class Signup extends JFrame implements ActionListener{
    
    JButton create, back; //here we difine the object globally 
                          //we can define locally aslo but here we use create and 
                          //back object out of the class  
    
    JTextField tfname,tfusername,tfpassword,tfanswer;
    Choice security; 
    Signup()
    {
        setBounds(350,200,900,360);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131,193,233));
        p1.setBounds(0, 0, 500, 400);   
        add(p1);
        p1.setLayout(null);
        
        
        JLabel jlusername = new JLabel("Username");
        jlusername.setBounds(50, 20, 125, 25);
        jlusername.setBorder(BorderFactory.createEmptyBorder());
        jlusername.setFont(new Font("Tahoma", Font.BOLD,14));
        p1.add(jlusername);
       
        
        tfusername = new JTextField();
        tfusername.setBounds(190, 20, 180, 25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);
        
        
        JLabel jlname = new JLabel("Name");
        jlname.setBounds(50, 60, 125, 25);
        jlname.setBorder(BorderFactory.createEmptyBorder());
        jlname.setFont(new Font("Tahoma", Font.BOLD,14));
        p1.add(jlname);
       
        
        tfname = new JTextField();
        tfname.setBounds(190, 60, 180, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);
        
        
        JLabel jlpassword = new JLabel("Password");
        jlpassword.setBounds(50, 100, 125, 25);
        jlpassword.setBorder(BorderFactory.createEmptyBorder());
        jlpassword.setFont(new Font("Tahoma", Font.BOLD,14));
        p1.add(jlpassword);
       
        
        tfpassword = new JTextField();
        tfpassword.setBounds(190, 100, 180, 25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);
        
        
        JLabel jlsecurity = new JLabel("Security Question");
        jlsecurity.setBounds(50, 140, 125, 25);
        jlsecurity.setBorder(BorderFactory.createEmptyBorder());
        jlsecurity.setFont(new Font("Tahoma", Font.BOLD,14));
        p1.add(jlsecurity);
        
        
        security = new Choice();
        security.add("Your Best friend name?");
        security.add("Your Mother name?");
        security.add("Your favorite dish");
        security.add("Your birth place");
        security.add("Your favorite crecketor");
        security.setBounds(190,140,180,30);
        p1.add(security);
        
        
        JLabel jlanswer = new JLabel("Answer");
        jlanswer.setBounds(50, 180, 125, 25);
        jlanswer.setBorder(BorderFactory.createEmptyBorder());
        jlanswer.setFont(new Font("Tahoma", Font.BOLD,14));
        p1.add(jlanswer);
       
        
        tfanswer = new JTextField();
        tfanswer.setBounds(190, 180, 180, 25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);
        
        create = new JButton("Create");
        create.setBackground(Color.white);
        create.setForeground(new Color(133,193,233));
        create.setFont(new Font("Tahoma",Font.BOLD,14));
        create.setBounds(80,250,100,30);
        create.setBorder(BorderFactory.createEmptyBorder());
        create.addActionListener(this);
        p1.add(create);
        
        back = new JButton("Back");
        back.setBackground(Color.WHITE);
        back.setForeground(new Color(133,193,233));
        back.setFont(new Font("Tahoma",Font.BOLD,14));
        back.setBounds(250,250,100,30);
        back.setBorder(BorderFactory.createEmptyBorder());
        back.addActionListener(this);
        p1.add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT); 
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580, 50, 250, 250);
        add(image);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ac)
    {
        if(ac.getSource()== create)
        {
            String username = tfusername.getText();
            String name = tfname.getText();
            String password = tfpassword.getText();
            String question = security.getSelectedItem(); 
            String answer = tfanswer.getText();
            
            String query = "insert into account values('"+username+"','"+name+"','"+password+"','"+question+"','"+answer+"')";
            
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null,"Account Create Successfuly");
                setVisible(false);
                new Login();
            }
            catch(Exception e)
                    {
                        e.printStackTrace();
                    }
            
        }else if(ac.getSource()== back)
        {
            setVisible(false);
            new Login();
            
        }
        
    }
    
    public static void main(String[] args)
    {
        new Signup();
    }
}
