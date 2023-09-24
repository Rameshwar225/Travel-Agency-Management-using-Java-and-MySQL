
package travel.management.syastem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
public class BookHotel extends JFrame implements ActionListener{
    
    Choice chotel,cac,cfood;
    JTextField tfpersons,tfdays;
    String username;
    JLabel labelusername,labelid , labelnumber,labelphone,labelprice;
    JButton checkprice, bookhotel, back;
    BookHotel(String username)
    {
        this.username = username;
        
        setBounds(350,200,1100,600);
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
        
        
        JLabel lblpackage = new JLabel("Select Hotel");
        lblpackage.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblpackage.setBounds(40,110,150,20);
        add(lblpackage);
        
        
        chotel = new Choice();
        chotel.setBounds(250, 110, 200, 20);
        add(chotel);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel");
            while(rs.next())
            {
                chotel.add(rs.getString("name"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
        
        JLabel lblperson = new JLabel("Total persons");
        lblperson.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblperson.setBounds(40,150,150,25);
        add(lblperson);
        
        tfpersons = new JTextField();
        tfpersons.setBounds(250, 150, 200, 25);
        add(tfpersons);
        
        JLabel lbldays = new JLabel("No. of days");
        lbldays.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbldays.setBounds(40,190,150,25);
        add(lbldays);
        
        tfdays = new JTextField();
        tfdays.setBounds(250, 190, 200, 25);
        add(tfdays);
        
        JLabel lblac = new JLabel("AC/NON-AC");
        lblac.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblac.setBounds(40,230,150,25);
        add(lblac);
        
        cac = new Choice();
        cac.add("AC");
        cac.add("Non-AC");
        cac.setBounds(250, 230, 200, 20);
        add(cac);
        
        JLabel lblfood = new JLabel("Food Included?");
        lblfood.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblfood.setBounds(40,270,150,25);
        add(lblfood);
        
        cfood = new Choice();
        cfood.add("Yes");
        cfood.add("No");
        cfood.setBounds(250, 270, 200, 20);
        add(cfood);
        
        
        
        JLabel lblid = new JLabel("ID");
        lblid.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblid.setBounds(40,310,150,25);
        add(lblid);
        
        
        labelid = new JLabel();
        labelid.setBounds(250,310,200,25);
        add(labelid);
        
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblnumber.setBounds(40,340,150,25);
        add(lblnumber);
        
        labelnumber = new JLabel();
        labelnumber.setBounds(250,340,150,25);
        add(labelnumber);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblphone.setBounds(40,380,150,25);
        add(lblphone);
        
        
        labelphone = new JLabel();
        labelphone.setBounds(250,380,200,25);
        add(labelphone);
        
        
        JLabel lbltotal = new JLabel("Total Price");
        lbltotal.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbltotal.setBounds(40,420,150,25);
        add(lbltotal);
        
        labelprice = new JLabel();
        labelprice.setBounds(250,420,150,25);
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
        checkprice.setBounds(60,470,120,25);
        checkprice.addActionListener(this);
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.setBorder(BorderFactory.createEmptyBorder());
        add(checkprice);
        
        
        bookhotel = new JButton("book Hotel");
        bookhotel.setBounds(200,470,120,25);
        bookhotel.addActionListener(this);
        bookhotel.setBackground(Color.BLACK);
        bookhotel.setForeground(Color.WHITE);
        bookhotel.setBorder(BorderFactory.createEmptyBorder());
        add(bookhotel);
        
        back = new JButton("Back");
        back.setBounds(340,470,120,25);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBorder(BorderFactory.createEmptyBorder());
        add(back);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550 ,50 ,600, 400);
        add(image);
        
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==checkprice)
        {
            try
            {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from hotel where name = '"+chotel.getSelectedItem()+"'");
                
                while(rs.next())
                {
                    int cost = Integer.parseInt(rs.getString("costperperson"));
                    int ac = Integer.parseInt(rs.getString("acroom"));
                    int food = Integer.parseInt(rs.getString("foodincluded"));
                    
                    int persons = Integer.parseInt(tfpersons.getText());
                    int days = Integer.parseInt(tfdays.getText());
                    
                    String acselected = cac.getSelectedItem();
                    String foodselected = cfood.getSelectedItem();
                    
                    if(persons*days> 0)
                    {
                        int total=0;
                        if(acselected.equals("AC"))
                        {
                            total = total + ac;
                        }
                        else
                        {
                            total = total + 0;
                        }
                        
                        if(foodselected.equals("Yes"))
                        {
                            total = total + food;
                        }
                        else
                        {
                            total = total + 0;
                        }
                        total = total+cost;
                        total = total*days*persons;
                        labelprice.setText("RS: "+total);
                        
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "please Enter valid number");
                    }
                }
            
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==bookhotel)
        {
            try
            {
             Conn c = new Conn();
             c.s.executeUpdate("insert into bookhotel values ('"+labelusername.getText() +"','"+chotel.getSelectedItem() +"','"+ tfpersons.getText()+"','"+tfdays.getText()+"','"+cac.getSelectedItem()+"','"+cfood.getSelectedItem()+"','"+ labelid.getText()+"','" +labelnumber.getText() +"','"+labelphone.getText() +"','" + labelprice.getText()+"')");
             
             JOptionPane.showMessageDialog(null, "hotel booked successfully");
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
        new BookHotel("Rambo");
        
    }
}
