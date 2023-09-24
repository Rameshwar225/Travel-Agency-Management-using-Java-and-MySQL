package travel.management.syastem;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateCustomer extends JFrame implements ActionListener {
    
    JLabel Labelusername, Labelname;
    JComboBox comboid, combogender;
    JTextField tfnumber, tfaddress,tfcountry,tfemail,tfphone,tfid,tfgender;
    JRadioButton rmale,rfemale,rother;
    JButton add,back;
    String username;
    UpdateCustomer(String username)
    {
        this.username = username;
        setBounds(500,200,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("UPDATE CUSTOMER DETAILS");
        text.setBounds(50,0,300,25);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        add(text);
        
        
        JLabel lblusername = new JLabel("username");
        lblusername.setBounds(30, 50, 150, 25);
        add(lblusername);
        
        
        Labelusername = new JLabel();
        Labelusername.setBounds(220, 50, 150, 25);
        add(Labelusername);
        
        
        JLabel lblid = new JLabel("Id");
        lblid.setBounds(30, 90, 150, 25);
        add(lblid);
//        
//        //combo box is used for creating menu or dropdown box in window 
//        //in combo box we need to create a object of string class and it take the all the string 
//        //argument which u want to in u r menu or drop down box
//        comboid = new JComboBox(new String[]{"Adhar Card", "Pan Card","Passport", "Driving lience"});
//        comboid.setBounds(220, 90,150 , 25);
//        comboid.setBackground(Color.white);
//        add(comboid);
        
        tfid = new JTextField();
        tfid.setBounds(220, 90,150 , 25);
        add(tfid);
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30, 130, 150, 25);
        add(lblnumber);
        
        tfnumber = new JTextField();
        tfnumber.setBounds(220, 130,150 , 25);
        add(tfnumber);
        
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30, 170, 150, 25);
        add(lblname);
        
        
        Labelname = new JLabel();
        Labelname.setBounds(220, 170, 150, 25);
        add(Labelname);
        
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(30, 210, 150, 25);
        add(lblgender);
        
//        combogender = new JComboBox(new String[]{"Male", "Female","Other"});
//        combogender.setBounds(220, 210,150 , 25);
//        combogender.setBackground(Color.white);
//        add(combogender);
        
//        rmale = new JRadioButton("Male");
//        rmale.setBounds(220, 210, 70, 25);
//        rmale.setBackground(Color.white);
//        add(rmale);
//        
//        rfemale = new JRadioButton("Female");
//        rfemale.setBounds(300, 210, 70, 25);
//        rfemale.setBackground(Color.white);
//        add(rfemale);
//        
//        ButtonGroup bg = new ButtonGroup();
//        bg.add(rmale);
//        bg.add(rfemale);
        

        tfgender = new JTextField();
        tfgender.setBounds(220, 210,150 , 25);
        add(tfgender);
        
        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(30, 250, 150, 25);
        add(lblcountry);
        
        tfcountry = new JTextField();
        tfcountry.setBounds(220, 250,150 , 25);
        add(tfcountry);
        
        
         JLabel lbladress = new JLabel("Address");
        lbladress.setBounds(30, 290, 150, 25);
        add(lbladress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(220, 290,150 , 25);
        add(tfaddress);
        
        
        JLabel lblemail = new JLabel("Email i'd");
        lblemail.setBounds(30, 370, 150, 25);
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(220, 370,150 , 25);
        add(tfemail);
        
        
         JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(30, 330, 150, 25);
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(220, 330,150 , 25);
        add(tfphone);
        
        add = new JButton("Update");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBorder(BorderFactory.createEmptyBorder());
        add.setBounds(70,420,100,25);
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBorder(BorderFactory.createEmptyBorder());
        back.setBounds(220,420,100,25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/update.jpg"));
        Image i2= i1.getImage().getScaledInstance(500, 350, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 100, 500, 350);
        add(image);
        
        //now lets fetch the username and Name from database
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"'");
            while(rs.next())
            {
                Labelusername.setText(rs.getString("username"));
                Labelname.setText(rs.getString("name"));
                tfid.setText(rs.getString("id"));
                tfnumber.setText(rs.getString("number"));
                tfgender.setText(rs.getString("gender"));
                tfcountry.setText(rs.getString("country"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==add)
        { 
            String username = Labelusername.getText();
            String id = tfid.getText();
                                                           
            String number = tfnumber.getText();
            String name = Labelname.getText();
            String gender = tfgender.getText();
            
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            
            try
            {
                     Conn c = new Conn();
                     String query = "update customer set  username='"+username+"',id= '"+id+"',number='"+number+"',name='"+name+"',gender='"+gender+"',country='"+country+"',address='"+address+"',phone='"+phone+"',email='"+email+"'";
                     c.s.executeUpdate(query);
                     
                     JOptionPane.showMessageDialog(null, "Customer details updated succsessfully");
                     setVisible(false);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            setVisible(false);
        }
    }

    
       public static void main(String[] arg)
       {
           new UpdateCustomer("Ram12");
          
       }
    
}
