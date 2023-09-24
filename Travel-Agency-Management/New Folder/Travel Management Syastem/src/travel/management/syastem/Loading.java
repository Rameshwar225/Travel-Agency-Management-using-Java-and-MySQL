
package travel.management.syastem;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Loading extends JFrame implements Runnable{
    Thread t;
    JProgressBar bar;
    String username;
    
    public void run()
    {
        try{
            for(int i = 1; i<=101; i++)
            {
                int max = bar.getMaximum(); //its shows the maximum values of bar in our case it is 100
                
                int value = bar.getValue(); //its show the current value of bar
                
                if(value < max)
                {
                    bar.setValue(bar.getValue() +1);
                }
                else 
                {
                    setVisible(false);
//                    new Dashboard(username);
                    new Dashboard(username);
                }
                Thread.sleep(50);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        };
    }
    Loading(String username)
    {
        
        this.username = username;
        t = new Thread(this);
        setBounds(500,200,650,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Travel And Turism application");
        text.setBounds(50, 20, 600, 40);
        text.setForeground(Color.blue);
        text.setFont(new Font("Raleway",Font.BOLD,34));
        add(text);
        
        bar = new JProgressBar();
        bar.setBounds(150,100,300,35);
        bar.setStringPainted(true);
        add(bar);
        
        
        
        JLabel loading = new JLabel("Loading, Please Wait...");
        loading.setBounds(230, 130, 150, 30);
        loading.setForeground(Color.red);
        loading.setFont(new Font("Raleway",Font.BOLD,16));
        add(loading);
        
        
        JLabel lblusername = new JLabel("Welcome "+username);
        lblusername.setBounds(20, 310, 400, 40);
        lblusername.setForeground(Color.red);
        lblusername.setFont(new Font("Raleway",Font.BOLD,16));
        add(lblusername);
        
        t.start();
        setVisible(true);
        
    } 
    
    public static void main(String[] args)
    {
        new Loading("");
    }
    
    
}
