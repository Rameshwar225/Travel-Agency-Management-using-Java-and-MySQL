
package travel.management.syastem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
public class BookPackage extends JFrame implements ActionListener{
    
    Choice cpackage;
    JTextField tfpersons;
    String username;
    JLabel labelusername,labelid , labelnumber,labelphone,labelprice;
    JButton checkprice, bookpackage, back;
    BookPackage(String username)
    {
        this.username = username;
        
        setBounds(350,200,1100,500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("BOOK PACKAGE");
        text.setBounds(100, 10, 200, 30);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        text.setForeground(Color.BLACK);
        add(text);
 
        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblusername.setBounds(40,70,100,20);
        add(lblusername);
        
        
        labelusername = new JLabel();
        labelusername.setFont(new Font("Tahoma",Font.PLAIN,16));
        labelusername.setBounds(250,70,200,20);
        add(labelusername);
        
        
        JLabel lblpackage = new JLabel("Select Package");
        lblpackage.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblpackage.setBounds(40,110,150,20);
        add(lblpackage);
        
        
        cpackage = new Choice();
        cpackage.add("Gold Package");
        cpackage.add("Selver Package");
        cpackage.add("Bronze Package");
        cpackage.setBounds(250, 110, 200, 20);
        add(cpackage);
        
        
        
        JLabel lblperson = new JLabel("Total persons");
        lblperson.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblperson.setBounds(40,150,150,25);
        add(lblperson);
        
        tfpersons = new JTextField("1");
        tfpersons.setBounds(250, 150, 200, 25);
        add(tfpersons);
        
        
        
        JLabel lblid = new JLabel("ID");
        lblid.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblid.setBounds(40,190,150,25);
        add(lblid);
        
        
        labelid = new JLabel();
        labelid.setBounds(250,190,200,25);
        add(labelid);
        
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblnumber.setBounds(40,230,150,25);
        add(lblnumber);
        
        labelnumber = new JLabel();
        labelnumber.setBounds(250,230,150,25);
        add(labelnumber);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblphone.setBounds(40,270,150,25);
        add(lblphone);
        
        
        labelphone = new JLabel();
        labelphone.setBounds(250,270,200,25);
        add(labelphone);
        
        
        JLabel lbltotal = new JLabel("Total Price");
        lbltotal.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbltotal.setBounds(40,310,150,25);
        add(lbltotal);
        
        labelprice = new JLabel();
        labelprice.setBounds(250,310,150,25);
        add(labelprice);
        
        
        try{
            Conn c = new Conn();
            String Query = "Select * from customer where username = '"+username+"'";
            ResultSet rs = c.s.executeQuery(Query);
            while(rs.next())
            {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                
                labelphone.setText(rs.getString("phone"));
               
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
        checkprice = new JButton("Check Price");
        checkprice.setBounds(60,380,120,25);
        checkprice.addActionListener(this);
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.setBorder(BorderFactory.createEmptyBorder());
        add(checkprice);
        
        
        bookpackage = new JButton("book package");
        bookpackage.setBounds(200,380,120,25);
        bookpackage.addActionListener(this);
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBorder(BorderFactory.createEmptyBorder());
        add(bookpackage);
        
        back = new JButton("Back");
        back.setBounds(340,380,120,25);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBorder(BorderFactory.createEmptyBorder());
        add(back);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550 ,50 ,500, 300);
        add(image);
        
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==checkprice)
        {
            String pack = cpackage.getSelectedItem();
            int cost=0;
            if(pack.equals("Gold Package"))
            {
                cost+= 12000;
            }
            else if(pack.equals("Selver Package"))
            {
                cost+=9000;
            }
            else
            {
                cost+=6000;
            }
            
            int persons = Integer.parseInt(tfpersons.getText());
            cost *= persons;
            
            labelprice.setText("RS: "+cost);
            
        }
        else if(ae.getSource()==bookpackage)
        {
            try
            {
             Conn c = new Conn();
             c.s.executeUpdate("insert into bookpackage values ('"+labelusername.getText() +"','"+cpackage.getSelectedItem() +"','"+ tfpersons.getText()+"','"+ labelid.getText()+"','" +labelnumber.getText() +"','"+labelphone.getText() +"','" + labelprice.getText()+"')");
             
             JOptionPane.showMessageDialog(null, "Package booked successfully");
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
        new BookPackage("Rambo");
        
    }
}
