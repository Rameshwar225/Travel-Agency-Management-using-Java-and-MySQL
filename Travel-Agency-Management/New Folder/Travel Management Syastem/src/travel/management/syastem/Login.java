package travel.management.syastem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
    
    JButton login,signup,password;
    JTextField tfusername,tfpassword ;
    
    Login()
    {
        setSize(900 , 400);
        setLocation(350, 200);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        //this code for left part of frame
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131 , 193, 233));
        p1.setBounds(0, 0, 400, 400);
        p1.setLayout(null);
        add(p1);
        
        //this is for right part of frame
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400,30,450,300);
        add(p2);
        
        //this is for adding img in left part 
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT); 
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100, 120, 200, 200);
        p1.add(image);
        
        //this for username label
        JLabel lbusername = new JLabel("Username");
        lbusername.setBounds(60, 20, 100, 25);
        lbusername.setFont(new Font("SAN SERIF", Font.PLAIN,20));
        p2.add(lbusername);
        
        //this for user text field
        tfusername = new JTextField();
        tfusername.setBounds(60, 60, 300, 30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfusername);
        
        
        
         //this for password label
        JLabel lbpassword = new JLabel("Password");
        lbpassword.setBounds(60, 110, 100, 25);
        lbpassword.setFont(new Font("SAN SERIF", Font.PLAIN,20));
        p2.add(lbpassword);
        
        //this for password text field
        tfpassword = new JTextField();
        tfpassword.setBounds(60, 150, 300, 30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfpassword);
       
        
        login = new JButton("Log in");
        login.setBackground(new Color(131,193,231));
        login.setForeground(Color.white);
        login.setBorder(BorderFactory.createEmptyBorder());
        login.setBounds(60, 200, 130, 30);
        login.addActionListener(this);
        p2.add(login);
        
        signup = new JButton("Sign Up");
        signup.setBackground(new Color(131,193,231));
        signup.setForeground(Color.white);
        signup.setBorder(BorderFactory.createEmptyBorder());
        signup.setBounds(230, 200, 130, 30);
        signup.addActionListener(this);
        p2.add(signup);
        
        password = new JButton("Forget Password");
        password.setBackground(new Color(131,193,231));
        password.setForeground(Color.white);
        password.setBorder(BorderFactory.createEmptyBorder());
        password.setBounds(130, 250, 130, 30);
        password.addActionListener(this);
        p2.add(password);
        
        JLabel text = new JLabel("Trouble in sign in");
        text.setBounds(300,250,150,20);
        text.setForeground(Color.red);
        p2.add(text);
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ac)
    {
        if(ac.getSource()==login)
        {
            try{
                String username = tfusername.getText();
                String pass = tfpassword.getText();
                String query = "Select * from account where username = '"+username+"'And password='"+pass+"'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                
                if(rs.next())
                {
                    setVisible(false);
                    new Loading(username);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Incorrect Password or Username");
                }
            
            }   
            
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(ac.getSource()==password)
        {
            setVisible(false);
            new Forgetpassword();
        }
        else if(ac.getSource()==signup)
        {
            setVisible(false);
            new Signup();
        }
    }
//    
    public static void main(String [] args)
    {
         new Login();
    }
    
}
