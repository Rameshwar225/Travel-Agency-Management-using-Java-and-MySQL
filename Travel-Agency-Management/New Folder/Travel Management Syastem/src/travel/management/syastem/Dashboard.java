package travel.management.syastem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener  {
    String username;
    JButton addPersonDetails,viewPersonDetails,updatePersonDetails,deletePersonDetails,checkPackeges,bookPackeges,viewPackeges,viewHotels,destinations,bookHotels,viewbookedHotels,exits,abouts,payments;

    Dashboard(String username)
    {
          this.username = username;
//        setBounds(0,0,1600,1000); 
//        we can use both setBounds or below method
        setExtendedState(JFrame.MAXIMIZED_BOTH);//used for get max. screen size from u r device
        setLayout(null);
        
//        1st panel
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0,181,226));
        p1.setBounds(0,0,1600,65);
        add(p1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5, 0, 70, 70);
        p1.add(icon);
        
        
        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(85, 10, 300, 40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma", Font.BOLD,30));
        p1.add(heading);
        
        
//          2nd panel
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0,181,226));
        p2.setBounds(0,65,300,900);
        add(p2);
        
        addPersonDetails = new JButton("add Personal Details");
        addPersonDetails.setBounds(0,0,300,50);
        addPersonDetails.setBackground(new Color(0,181,226));
        addPersonDetails.setForeground(Color.BLACK);
        addPersonDetails.setFont(new Font("Tahoma", Font.PLAIN,20));
        addPersonDetails.setMargin(new Insets(0,0,0,60));
        addPersonDetails.addActionListener(this);
        p2.add(addPersonDetails);
        
        
        updatePersonDetails = new JButton("Update Personal Details");
        updatePersonDetails.setBounds(0,50,300,50);
        updatePersonDetails.setBackground(new Color(0,181,226));
        updatePersonDetails.setForeground(Color.BLACK);
        updatePersonDetails.setFont(new Font("Tahoma", Font.PLAIN,20));
        updatePersonDetails.setMargin(new Insets(0,0,0,30));
        updatePersonDetails.addActionListener(this);
        p2.add(updatePersonDetails);
        
        
        viewPersonDetails = new JButton("View Details");
        viewPersonDetails.setBounds(0,100,300,50);
        viewPersonDetails.setBackground(new Color(0,181,226));
        viewPersonDetails.setForeground(Color.BLACK);
        viewPersonDetails.setFont(new Font("Tahoma", Font.PLAIN,20));
        viewPersonDetails.setMargin(new Insets(0,0,0,130));
        viewPersonDetails.addActionListener(this);
        p2.add(viewPersonDetails);
        
        
        deletePersonDetails = new JButton("Delete Personal Details");
        deletePersonDetails.setBounds(0,150,300,50);
        deletePersonDetails.setBackground(new Color(0,181,226));
        deletePersonDetails.setForeground(Color.BLACK);
        deletePersonDetails.setFont(new Font("Tahoma", Font.PLAIN,20));
        deletePersonDetails.setMargin(new Insets(0,0,0,40));
        deletePersonDetails.addActionListener(this);
        p2.add(deletePersonDetails);
        
        
        
        checkPackeges = new JButton("Check Packeges");
        checkPackeges.setBounds(0,200,300,50);
        checkPackeges.setBackground(new Color(0,181,226));
        checkPackeges.setForeground(Color.BLACK);
        checkPackeges.setFont(new Font("Tahoma", Font.PLAIN,20));
        checkPackeges.setMargin(new Insets(0,0,0,110));
        checkPackeges.addActionListener(this);
        p2.add(checkPackeges);
        
        
        bookPackeges = new JButton("book Packege");
        bookPackeges.setBounds(0,250,300,50);
        bookPackeges.setBackground(new Color(0,181,226));
        bookPackeges.setForeground(Color.BLACK);
        bookPackeges.setFont(new Font("Tahoma", Font.PLAIN,20));
        bookPackeges.setMargin(new Insets(0,0,0,120));
        bookPackeges.addActionListener(this);
        p2.add(bookPackeges);
        
        
        viewPackeges = new JButton("Check booked Packeges");
        viewPackeges.setBounds(0,300,300,50);
        viewPackeges.setBackground(new Color(0,181,226));
        viewPackeges.setForeground(Color.BLACK);
        viewPackeges.setFont(new Font("Tahoma", Font.PLAIN,20));
        viewPackeges.addActionListener(this);
        viewPackeges.setMargin(new Insets(0,0,0,50));
        p2.add(viewPackeges);
        
        
        viewHotels = new JButton("view Hotels");
        viewHotels.setBounds(0,350,300,50);
        viewHotels.setBackground(new Color(0,181,226));
        viewHotels.setForeground(Color.BLACK);
        viewHotels.setFont(new Font("Tahoma", Font.PLAIN,20));
        viewHotels.addActionListener(this);
        viewHotels.setMargin(new Insets(0,0,0,140));
        p2.add(viewHotels);
        
        
        bookHotels = new JButton("book Hotels");
        bookHotels.setBounds(0,400,300,50);
        bookHotels.setBackground(new Color(0,181,226));
        bookHotels.setForeground(Color.BLACK);
        bookHotels.setFont(new Font("Tahoma", Font.PLAIN,20));
        bookHotels.setMargin(new Insets(0,0,0,140));
        bookHotels.addActionListener(this);
        p2.add(bookHotels);
        
        
        viewbookedHotels = new JButton("view booked Hotel");
        viewbookedHotels.setBounds(0,450,300,50);
        viewbookedHotels.setBackground(new Color(0,181,226));
        viewbookedHotels.setForeground(Color.BLACK);
        viewbookedHotels.setFont(new Font("Tahoma", Font.PLAIN,20));
        viewbookedHotels.setMargin(new Insets(0,0,0,80));
        viewbookedHotels.addActionListener(this);
        p2.add(viewbookedHotels);
        
        
        destinations = new JButton("Destination");
        destinations.setBounds(0,500,300,50);
        destinations.setBackground(new Color(0,181,226));
        destinations.setForeground(Color.BLACK);
        destinations.setFont(new Font("Tahoma", Font.PLAIN,20));
        destinations.setMargin(new Insets(0,0,0,140));
        destinations.addActionListener(this);
        p2.add(destinations);
        
        
        payments = new JButton("Payment");
        payments.setBounds(0,550,300,50);
        payments.setBackground(new Color(0,181,226));
        payments.setForeground(Color.BLACK);
        payments.setFont(new Font("Tahoma", Font.PLAIN,20));
        payments.setMargin(new Insets(0,0,0,170));
        payments.addActionListener(this);
        p2.add(payments);
        
        
        abouts = new JButton("Abouts");
        abouts.setBounds(0,600,300,50);
        abouts.setBackground(new Color(0,181,226));
        abouts.setForeground(Color.BLACK);
        abouts.setFont(new Font("Tahoma", Font.PLAIN,20));
        abouts.setMargin(new Insets(0,0,0,180));
        abouts.addActionListener(this);
        p2.add(abouts);
        
        
        exits = new JButton("EXIT");
        exits.setBounds(0,650,300,50);
        exits.setBackground(new Color(0,181,226));
        exits.setForeground(Color.BLACK);
        exits.setFont(new Font("Tahoma", Font.PLAIN,20));
        exits.setMargin(new Insets(0,0,0,180));
        exits.addActionListener(this);
        p2.add(exits);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/dashbackground.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0,0,1600,1000);
        add(image);
        
        JLabel text = new JLabel("LET'S! FLY WITH US");
        text.setBounds(600,0,1200,70);
        text.setForeground(Color.white);
        text.setFont(new Font("raleway", Font.PLAIN,50));
        p1.add(text);
        
        
        setVisible(true);
        

    }
    
     public void actionPerformed(ActionEvent ae)
     {
         if(ae.getSource()==addPersonDetails)
         {
             new AddCustomer(username);
         }
         else if(ae.getSource()==viewPersonDetails)
         {
             new ViewCustomer(username);
         }
         else if(ae.getSource()==updatePersonDetails)
         {
             new UpdateCustomer(username);
         }
         else if(ae.getSource()==deletePersonDetails)
         {
             new DeleteDetails(username);
         }
         else if(ae.getSource()==checkPackeges)
         {
             new CheckPackage();
         }
         else if(ae.getSource()==bookPackeges)
         {
             new BookPackage(username);
         }
         else if(ae.getSource()==viewPackeges)
         {
             new ViewPackage(username);
         }
         else if(ae.getSource()==viewHotels)
         {
             new CheckHotels();
         }
         else if(ae.getSource()==destinations)
         {
             new Destinations();
         }
         else if(ae.getSource()==bookHotels)
         {
             new BookHotel(username);
         }
         else if(ae.getSource()==viewbookedHotels)
         {
             new ViewBookedHotel(username);
         }
         else if(ae.getSource()==exits)
         {
             setVisible(false);
         }
         else if(ae.getSource()==abouts)
         {
             JOptionPane.showMessageDialog(null, "Our travel industry management system allows the client of the system, to get to all the details, for example, climate, area, occasions, etc.\n" +
"The main purpose is to help tourism companies to manage customers and hotels etc. The system can likewise be utilized for both\n" +
"professional and business travel.\n" +
"\n" +
" \n" +
"\n" +
" \n" +
"");
         }
         else if(ae.getSource()==payments)
             
         {
             JOptionPane.showMessageDialog(null,"Done payment");
         }
     }
    public static void main(String[] arg)
    {
        new Dashboard("");
    }
    
    
}
