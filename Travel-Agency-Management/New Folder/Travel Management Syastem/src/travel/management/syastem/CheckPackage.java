
package travel.management.syastem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
public class CheckPackage extends JFrame {
    
    CheckPackage()
    {
       
        setBounds(450,200,900,600);
        
//        array is created for making data in tap dynamic
        String[] package1 = {"GOLD PACKAGE","6 Days and 7 Nights","Airport Assistance !!!","Half Day City Tour !!!","Daily Buffet free !!!","Welcome Drinks on Arrival !!!","All Forts and hill station Coverd in maharastra !!!","Marathi || Hindi || English speaking Guides !!!","BOOK NOW","Summer Spacial","RS 12000/-","package1.jpg"};
        String[] package2 = {"SILVER PACKAGE","4 Days and 5 Nights","TOll free entry !!!","Half Day City Tour !!!","Daily Dinner free!!!","Welcome Drinks on Arrival !!!","All Forts Coverd in maharastra !!!","Marathi || Hindi || English speaking Guides !!!","BOOK NOW","Summer Spacial","RS 9000/-","package2.jpg"};
        String[] package3 = {"BRONZE PACKAGE","2 Days and 3 Nights"," Entrance Free tickets !!!","Free indoore Games !!!","Daily Breakfast free !!!","Welcome Drinks on Arrival !!!","All hill station Coverd in maharastra !!!","Marathi || Hindi || English speaking Guides !!!","BOOK NOW","Summer Spacial","RS 6000/-","package3.jpg"};
        

        
//        tabbed pane class is used for create a tab on the fram
        JTabbedPane tab = new JTabbedPane();
        JPanel p1 =createPackage(package1);
        
        tab.add("Package 1", p1);
        
        JPanel p2 =createPackage(package2);
        tab.add("Package 2", p2);
        
        JPanel p3 =createPackage(package3);
        tab.add("Package 3", p3);
        add(tab);


       
        
        
        setVisible(true);
            
    }
    
    public JPanel createPackage(String[] pack)
    {
         
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.white);
        
        JLabel l1 = new JLabel(pack[0]);
        l1.setBounds(50, 5,300 , 30);
        l1.setForeground(Color.yellow);
        l1.setFont(new Font("Tahoma",Font.BOLD,30));
        p1.add(l1);
        
        JLabel l2 = new JLabel(pack[1] );
        l2.setBounds(30, 60,300 , 30);
        l2.setForeground(Color.black);
        l2.setFont(new Font("Tahoma",Font.PLAIN,20));
        p1.add(l2);
        
        JLabel l3 = new JLabel(pack[2]);
        l3.setBounds(30, 110,300 , 30);
        l3.setForeground(Color.black);
        l3.setFont(new Font("Tahoma",Font.PLAIN,20));
        p1.add(l3);
        
        
        JLabel l4 = new JLabel(pack[3] );
        l4.setBounds(30, 160,300 , 30);
        l4.setForeground(Color.black);
        l4.setFont(new Font("Tahoma",Font.PLAIN,20));
        p1.add(l4);
        
        JLabel l5 = new JLabel(pack[4] );
        l5.setBounds(30, 210,300 , 30);
        l5.setForeground(Color.black);
        l5.setFont(new Font("Tahoma",Font.PLAIN,20));
        p1.add(l5);
        
        JLabel l6 = new JLabel(pack[5] );
        l6.setBounds(30, 260,300 , 30);
        l6.setForeground(Color.black);
        l6.setFont(new Font("Tahoma",Font.PLAIN,20));
        p1.add(l6);
        
        JLabel l7 = new JLabel(pack[6]);
        l7.setBounds(30, 320,450 , 30);
        l7.setForeground(Color.black);
        l7.setFont(new Font("Tahoma",Font.PLAIN,20));
        p1.add(l7);
        
        
        JLabel l8 = new JLabel(pack[7] );
        l8.setBounds(30, 370,450 , 30);
        l8.setForeground(Color.black);
        l8.setFont(new Font("Tahoma",Font.PLAIN,20));
        p1.add(l8);
        
        JLabel l9 = new JLabel(pack[8] );
        l9.setBounds(60, 430,450 , 30);
        l9.setForeground(Color.black);
        l9.setFont(new Font("Tahoma",Font.BOLD,25));
        p1.add(l9);
        
        JLabel l10 = new JLabel(pack[9] );
        l10.setBounds(80, 480,450 , 30);
        l10.setForeground(Color.black);
        l10.setFont(new Font("Tahoma",Font.BOLD,25));
        p1.add(l10);
        
        
        JLabel l11 = new JLabel(pack[10] );
        l11.setBounds(550, 400,450 , 30);
        l11.setForeground(Color.black);
        l11.setFont(new Font("Tahoma",Font.BOLD,25));
        p1.add(l11);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/"+pack[11]));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l12 = new JLabel(i3);
        l12.setBounds(350, 20, 500, 300);
        p1.add(l12);
        
        return p1;
        
    }
    
    
    
    
    public static void main(String[] arg)
    {
        new CheckPackage();
    }
    
}
