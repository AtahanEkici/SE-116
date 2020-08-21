package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;
import Code.*;

/**
 *
 * @author Atahan Ekici
 */
public final class UI extends JFrame implements ActionListener , MouseListener 
{    
    private static UI single_instance = null;
    
        public static UI getInstance() // Singleton Pattern so that only one frame will open //
    {
        if(single_instance == null)
        {
            single_instance = new UI();
        }
            return single_instance;    
    }
    
    private UI()
    {
        try
        {
            Construct_Main_Frame();
            Construct_Parking_slots();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog( null, ""+e+"", "ERROR!", JOptionPane. ERROR_MESSAGE);
        }   
    } 
    
    public int counter = 1;  

    public static final Color PALE_BLACK = new Color(33, 37, 41);
    
    // ------------------------------------- Swing Components ------------------------------------- //
    JFrame main,park;
    JButton clear_button,refresh_button,park_button,park1_button,park2_button,park3_button,park4_button,park5_button,park6_button,park7_button,park8_button,park9_button;
    JTextArea jta;
    JMenuBar mb;
    JMenu fileMenu,aboutMenu;
    JMenuItem jm_read,jm_new,jm_about,jm_github; // Main Frame Menu Components //
    JMenuItem pop_properties , pop_stop_timer; // Pop-Up Menu Components //
    JScrollPane jsp;
    JOptionPane jop;
    JPopupMenu jpm;
    Component invoker;
    // ------------------------------------- Swing Components ------------------------------------- //
    
    Timer timer1,timer2,timer3,timer4,timer5,timer6,timer7,timer8,timer9;
    
    A_ParkingArea a1 = new A_ParkingArea();
    A_ParkingArea a2 = new A_ParkingArea();
    A_ParkingArea a3 = new A_ParkingArea();
    
    B_ParkingArea b1 = new B_ParkingArea();
    B_ParkingArea b2 = new B_ParkingArea();
    B_ParkingArea b3 = new B_ParkingArea();
    
    C_ParkingArea c1 = new C_ParkingArea();
    C_ParkingArea c2 = new C_ParkingArea();
    C_ParkingArea c3 = new C_ParkingArea();
    
    
    public void Construct_Main_Frame()       
    {
        main = new JFrame("SE116 Project - Main Frame");
        main.setIconImage(new ImageIcon("Icons/icon.png").getImage());
        main.setLayout(new BorderLayout());
        main.setResizable(false);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel tutucu = new JPanel();
        tutucu.setLayout(new FlowLayout());
        tutucu.setBackground(PALE_BLACK);
        
        JPanel textArea = new JPanel();
        textArea.setLayout(new FlowLayout(FlowLayout.CENTER));
        textArea.setBackground(Color.BLACK);
        
        mb = new JMenuBar();
        main.setJMenuBar(mb);      
        mb.setBorder(BorderFactory.createLineBorder(PALE_BLACK));
        
        // Clear_Button Tanımı Başlangıç //
        clear_button = new JButton("Clear");
        clear_button.addActionListener(this);
        clear_button.setBackground(Color.WHITE);
        clear_button.setFocusable(false);
        // Clear_Button Tanımı Bitişi //
        
        // Park_Button Tanımı Başlangıç //
        park_button = new JButton("Parks");
        park_button.addActionListener(this);
        park_button.setBackground(Color.WHITE);
        park_button.setFocusable(false);
        // Park_Button Tanımı Bitişi //

        // Refresh_Button Tanımı Başlangıç //
        refresh_button = new JButton("Refresh");
        refresh_button.addActionListener(this);
        refresh_button.setBackground(Color.WHITE);
        refresh_button.setFocusable(false);
        // Refresh_Button Tanımı Bitişi //

        fileMenu = new JMenu("File");
        fileMenu.setFocusable(true);
        fileMenu.setForeground(Color.BLACK);
        fileMenu.addMouseListener(this);
        
        jm_read = fileMenu.add("Open");
        jm_read.addActionListener(this);
        jm_read.setBackground(Color.WHITE);
        
        jm_new = fileMenu.add("Save");
        jm_new.addActionListener(this);
        jm_new.setBackground(Color.WHITE);
        
        aboutMenu = new JMenu("About");
        aboutMenu.setFocusable(true);
        aboutMenu.setForeground(Color.BLACK);
        aboutMenu.addMouseListener(this);
        
        jm_about = aboutMenu.add("About This Project");
        jm_about.addActionListener(this);
        jm_about.setBackground(Color.WHITE);
        
        jm_github = aboutMenu.add("GitHub Page");
        jm_github.addActionListener(this);
        jm_github.setBackground(Color.WHITE);
        
        mb.add(fileMenu);
        mb.add(aboutMenu);
        
        tutucu.add(clear_button,BorderLayout.CENTER);
        tutucu.add(park_button,BorderLayout.CENTER);
        tutucu.add(refresh_button,BorderLayout.CENTER);
        tutucu.setBorder(null);
        
        jsp = new JScrollPane();
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jsp.setBorder(null);
        
        jsp.getVerticalScrollBar().setBackground(PALE_BLACK);
        jsp.getHorizontalScrollBar().setBackground(PALE_BLACK);
        
        jta = new JTextArea(35,55);
        jta.setForeground(Color.WHITE);
        jta.setBackground(Color.BLACK);
        jta.setEditable(false);
        
        jsp.getViewport().add(jta);
        add(jsp);
                     
        textArea.add(jsp);
        textArea.setBorder(null);
  
        main.add(textArea,BorderLayout.PAGE_END); // Text'leri tutan panelin JFrame'e iliştirilmesi //
        main.add(tutucu,BorderLayout.NORTH); // Butonları tutan panelin Ana Frame'e eklenmesi //
        
        main.pack(); // Function that packs the frame and cuts the unnecessary lines //
        main.setLocationRelativeTo(null); // initially start the frame at the center of the screen //
        main.setVisible(true);        
    }
    
    public void Construct_Parking_slots()
    {
        park = new JFrame("SE116 Project - Main Frame");
        park.getContentPane().setBackground(PALE_BLACK);
        park.setIconImage(new ImageIcon("Icons/park.png").getImage());
        park.setLayout(new BorderLayout());
        park.setSize(500, 500);
        park.setResizable(true);
        park.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
        jpm = new JPopupMenu();
        
        pop_properties = new JMenuItem("Properties");
        pop_properties.addActionListener(this);
        
        pop_stop_timer = new JMenuItem("Stop Timer");
        pop_stop_timer.addActionListener(this);
        
        jpm.add(pop_stop_timer);
        jpm.add(pop_properties);
        
        jpm.addMouseListener(this);
        
        
        JPanel button_holder = new JPanel();
        button_holder.setLayout(new GridLayout(3,3));
        button_holder.setBackground(PALE_BLACK);
        
        // Button Tanımı Başlangıç //
        park1_button = new JButton("Park_1(A)");
        park1_button.addActionListener(this);
        park1_button.setFocusable(false);
        park1_button.setBackground(PALE_BLACK);
        park1_button.setForeground(Color.WHITE);
        park1_button.addMouseListener(this);
        // Button Tanımı Bitişi //
        
        // Button Tanımı Başlangıç //
        park2_button = new JButton("Park_2(A)");
        park2_button.addActionListener(this);
        park2_button.setFocusable(false);
        park2_button.setBackground(PALE_BLACK);
        park2_button.setForeground(Color.WHITE);
        park2_button.addMouseListener(this);
        // Button Tanımı Bitişi //
        
        // Button Tanımı Başlangıç //
        park3_button = new JButton("Park_3(A)");
        park3_button.addActionListener(this);
        park3_button.setFocusable(false);
        park3_button.setBackground(PALE_BLACK);
        park3_button.setForeground(Color.WHITE);
        park3_button.addMouseListener(this);
        // Button Tanımı Bitişi //
        
        // Button Tanımı Başlangıç //
        park4_button = new JButton("Park_4(B)");
        park4_button.addActionListener(this);
        park4_button.setFocusable(false);
        park4_button.setBackground(PALE_BLACK);
        park4_button.setForeground(Color.WHITE);
        park4_button.addMouseListener(this);
        // Button Tanımı Bitişi //
        
        // Button Tanımı Başlangıç //
        park5_button = new JButton("Park_5(B)");
        park5_button.addActionListener(this);
        park5_button.setFocusable(false);
        park5_button.setBackground(PALE_BLACK);
        park5_button.setForeground(Color.WHITE);
        park5_button.addMouseListener(this);
        // Button Tanımı Bitişi //
        
        // Button Tanımı Başlangıç //
        park6_button = new JButton("Park_6(B)");
        park6_button.addActionListener(this);
        park6_button.setFocusable(false);
        park6_button.setBackground(PALE_BLACK);
        park6_button.setForeground(Color.WHITE);
        park6_button.addMouseListener(this);
        // Button Tanımı Bitişi //
        
        // Button Tanımı Başlangıç //
        park7_button = new JButton("Park_7(C)");
        park7_button.addActionListener(this);
        park7_button.setFocusable(false);
        park7_button.setBackground(PALE_BLACK);
        park7_button.setForeground(Color.WHITE);
        park7_button.addMouseListener(this);
        // Button Tanımı Bitişi //
        
        // Button Tanımı Başlangıç //
        park8_button = new JButton("Park_8(C)");
        park8_button.addActionListener(this);
        park8_button.setFocusable(false);
        park8_button.setBackground(PALE_BLACK);
        park8_button.setForeground(Color.WHITE);
        park8_button.addMouseListener(this);
        // Button Tanımı Bitişi //
        
        
        // Button Tanımı Başlangıç //
        park9_button = new JButton("Park_9(C)");
        park9_button.addActionListener(this);
        park9_button.setFocusable(false);
        park9_button.setBackground(PALE_BLACK);
        park9_button.setForeground(Color.WHITE);
        park9_button.addMouseListener(this);
        // Button Tanımı Bitişi //
        
        button_holder.add(park1_button);// First Row //
        button_holder.add(park2_button);
        button_holder.add(park3_button);
        
        button_holder.add(park4_button);// Second Row //
        button_holder.add(park5_button);
        button_holder.add(park6_button);
        
        button_holder.add(park7_button);// Third Row //
        button_holder.add(park8_button);
        button_holder.add(park9_button);
        
        park.add(button_holder);
    }
    
    public void refresh()
    {
        main.setVisible(false);
        main.dispose();
            
        main.repaint();
        main.revalidate();
        main.setVisible(true);
    }

   // Action Event Handling //
    
    @Override
    public void actionPerformed(ActionEvent Event) // Action Listener instructions //
    {
        if(Event.getSource() == park_button) // The switch case only allows primitive types(in Java 8) so i can not use it here ==> back to if-else //
        {
            jta.append(""+counter+")Opened Park Menu \n\n");
            counter++;
            park.setLocationRelativeTo(null);
            park.setVisible(true);
        }
        
        else if(Event.getSource() == park1_button)
        { 
            park1_button.setEnabled(false);
            a1.set_Occupation(true);
            
            timer1 = new Timer(1000, new ActionListener() 
            {
                int i = 7201;
                
                @Override
                public void actionPerformed(ActionEvent e) 
                {  
                    if(i == 0)
                    {
                        park1_button.setEnabled(true);
                        park1_button.setText("Park_1(A)");
                        a1.set_Occupation(false);
                        timer1.stop();
                    }
                    
                    else
                    {
                        i--;    
                        park1_button.setText("Park_1(A) : " +Utilities.calculateTime(i));
                    }
                }
            });
            timer1.start();
        }
        
        else if(Event.getSource() == park2_button)
        {
            park2_button.setEnabled(false);
            a2.set_Occupation(true);
            
            timer2 = new Timer(1000, new ActionListener() 
            {
                int i = 7201;
                
                @Override
                public void actionPerformed(ActionEvent e) 
                {  
                    if(i == 0)
                    {
                        park2_button.setEnabled(true);
                        park2_button.setText("Park_2(A)");
                        a2.set_Occupation(false);
                        timer2.stop();
                    }
                    
                    else
                    {
                        i--;    
                        park2_button.setText("Park_2(A) : " +Utilities.calculateTime(i));
                    }
                }
            });
            timer2.start();
        }
        
        else if(Event.getSource() == park3_button)
        {
            park3_button.setEnabled(false);
            a3.set_Occupation(true);

            timer3 = new Timer(1000, new ActionListener() 
            {
                int i = 7201;
                
                @Override
                public void actionPerformed(ActionEvent e) 
                {  
                    if(i == 0)
                    {
                        park3_button.setEnabled(true);
                        park3_button.setText("Park_3(A)");
                        a3.set_Occupation(false);
                        timer3.stop();
                    }
                    
                    else
                    {
                        i--;    
                        park3_button.setText("Park_3(A) : " +Utilities.calculateTime(i));
                    }
                }
            });  
            timer3.start();
        }
        
        else if(Event.getSource() == park4_button)
        {
            park4_button.setEnabled(false);
            b1.set_Occupation(true);
 
            timer4 = new Timer(1000, new ActionListener() 
            {
                int i = 7201;
                
                @Override
                public void actionPerformed(ActionEvent e) 
                {  
                    if(i == 0)
                    {
                        park4_button.setEnabled(true);
                        park4_button.setText("Park_4(B)");
                        b1.set_Occupation(false);
                        timer4.stop();
                    }
                    
                    else
                    {
                        i--;    
                        park4_button.setText("Park_4(B) : " +Utilities.calculateTime(i));
                    }
                }
            }); 
            timer4.start();
        }
        
        else if(Event.getSource() == park5_button)
        {
            park5_button.setEnabled(false);
            b2.set_Occupation(true);
            
            timer5 = new Timer(1000, new ActionListener() 
            {
                int i = 7201;
                
                @Override
                public void actionPerformed(ActionEvent e) 
                {  
                    if(i == 0)
                    {
                        park5_button.setEnabled(true);
                        park5_button.setText("Park_5(B)");
                        b2.set_Occupation(false);
                        timer5.stop();
                    }
                    
                    else
                    {
                        i--;    
                        park5_button.setText("Park_5(B) : " +Utilities.calculateTime(i));
                    }
                }
            }); 
            timer5.start();
        }
        
        else if(Event.getSource() == park6_button)
        {
            park6_button.setEnabled(false);
            b3.set_Occupation(true);
            
            timer6 = new Timer(1000, new ActionListener() 
            {
                int i = 7201;
                
                @Override
                public void actionPerformed(ActionEvent e) 
                {  
                    if(i == 0)
                    {
                        park6_button.setEnabled(true);
                        park6_button.setText("Park_6(B)");
                        b3.set_Occupation(false);
                        timer6.stop();
                    }
                    
                    else
                    {
                        i--;    
                        park6_button.setText("Park_6(B) : " +Utilities.calculateTime(i));
                    }
                }
            }); 
            timer6.start();
        }
        
        else if(Event.getSource() == park7_button)
        {
            park7_button.setEnabled(false);
            c1.set_Occupation(true);
            
            timer7 = new Timer(1000, new ActionListener() 
            {
                int i = 7201;
                
                @Override
                public void actionPerformed(ActionEvent e) 
                {  
                    if(i == 0)
                    {
                        park7_button.setEnabled(true);
                        park7_button.setText("Park_7(C)");
                        c1.set_Occupation(false);
                        timer7.stop();
                    }
                    
                    else
                    {
                        i--;    
                        park7_button.setText("Park_7(C) : " +Utilities.calculateTime(i));
                    }
                }
            }); 
            timer7.start();
        }
        
        else if(Event.getSource() == park8_button)
        {
            park8_button.setEnabled(false);
            c2.set_Occupation(true);
            
            timer8 = new Timer(1000, new ActionListener() 
            {
                int i = 7201;
                
                @Override
                public void actionPerformed(ActionEvent e) 
                {  
                    if(i == 0)
                    {
                        park8_button.setEnabled(true);
                        park8_button.setText("Park_8(C)");
                        c2.set_Occupation(false);
                        timer8.stop();
                    }
                    
                    else
                    {
                        i--;    
                        park8_button.setText("Park_8(C) : " +Utilities.calculateTime(i));
                    }
                }
            }); 
            timer8.start();
        }
        
        else if(Event.getSource() == park9_button)
        {
            park9_button.setEnabled(false);
            c3.set_Occupation(true);
            
            timer9 = new Timer(1000, new ActionListener() 
            {
                int i = 7201;
                
                @Override
                public void actionPerformed(ActionEvent e) 
                {  
                    if(i == 0)
                    {
                        park9_button.setEnabled(true);
                        park9_button.setText("Park_9(C)");
                        c3.set_Occupation(false);
                        timer9.stop();
                    }
                    
                    else
                    {
                        i--;    
                        park9_button.setText("Park_9(C) : " +Utilities.calculateTime(i));
                    }
                }
            }); 
            timer9.start(); 
        }
        
        else if(Event.getSource() == pop_properties)
        {
            invoker = jpm.getInvoker();
            
            if(invoker == park1_button)
            {
                JOptionPane.showMessageDialog(null,"Park Slot: "+a1.get_parkingSlot()+"\n"+a1.toString()+"","Properties",INFORMATION_MESSAGE);
            }
            
            else if(invoker == park2_button)
            {
                JOptionPane.showMessageDialog(null,"Park Slot: "+a2.get_parkingSlot()+"\n"+a2.toString()+"","Properties",INFORMATION_MESSAGE);
            }
            
            else if(invoker == park3_button)
            {
                JOptionPane.showMessageDialog(null,"Park Slot: "+a3.get_parkingSlot()+"\n"+a3.toString()+"","Properties",INFORMATION_MESSAGE);
            }
            
            else if(invoker == park4_button)
            {
                JOptionPane.showMessageDialog(null,"Park Slot: "+b1.get_parkingSlot()+"\n"+b1.toString()+"","Properties",INFORMATION_MESSAGE);
            }
            
            else if(invoker == park5_button)
            {
                JOptionPane.showMessageDialog(null,"Park Slot: "+b2.get_parkingSlot()+"\n"+b2.toString()+"","Properties",INFORMATION_MESSAGE);
            }
            
            else if(invoker == park6_button)
            {
                JOptionPane.showMessageDialog(null,"Park Slot: "+b3.get_parkingSlot()+"\n"+b3.toString()+"","Properties",INFORMATION_MESSAGE);
            }
            
            else if(invoker == park7_button)
            {
                JOptionPane.showMessageDialog(null,"Park Slot: "+c1.get_parkingSlot()+"\n"+c1.toString()+"","Properties",INFORMATION_MESSAGE);
            }
            
            else if(invoker == park8_button)
            {
                JOptionPane.showMessageDialog(null,"Park Slot: "+c2.get_parkingSlot()+"\n"+c2.toString()+"","Properties",INFORMATION_MESSAGE);
            }
            
            else if(invoker == park9_button)
            {
                JOptionPane.showMessageDialog(null,"Park Slot: "+c3.get_parkingSlot()+"\n"+c3.toString()+"","Properties",INFORMATION_MESSAGE);
            }
        }
        
        else if(Event.getSource() == pop_stop_timer)
        {
            invoker = jpm.getInvoker();
            
            if(invoker == park1_button)
            {
                if(timer1 == null || timer1.isRunning() == false)
                {
                    JOptionPane.showMessageDialog( null, "Timer is not running!", "ERROR!", JOptionPane. ERROR_MESSAGE);
                }
                else
                {
                    timer1.stop();
                    park1_button.setEnabled(true);
                    park1_button.setText("Park_1(A)");
                    a1.set_Occupation(false);
                }
            }
            
            else if(invoker == park2_button)
            {
                if(timer2 == null || timer2.isRunning() == false)
                {
                    JOptionPane.showMessageDialog( null, "Timer is not running!", "ERROR!", JOptionPane. ERROR_MESSAGE);
                }
                else
                {
                    timer2.stop();
                    park2_button.setEnabled(true);
                    park2_button.setText("Park_2(A)");
                    a2.set_Occupation(false);
                }
            }
            
            else if(invoker == park3_button)
            {
                 if(timer3 == null || timer3.isRunning() == false)
                {
                    JOptionPane.showMessageDialog( null, "Timer is not running!", "ERROR!", JOptionPane. ERROR_MESSAGE);
                }
                else
                {
                    timer3.stop();
                    park3_button.setEnabled(true);
                    park3_button.setText("Park_3(A)");
                    a3.set_Occupation(false);
                }
            }
            
            else if(invoker == park4_button)
            {
                if(timer4 == null || timer4.isRunning() == false)
                {
                    JOptionPane.showMessageDialog( null, "Timer is not running!", "ERROR!", JOptionPane. ERROR_MESSAGE);
                }
                else
                {
                    timer4.stop();
                    park4_button.setEnabled(true);
                    park4_button.setText("Park_4(B)");
                    b1.set_Occupation(false);
                }
            }
            
            else if(invoker == park5_button)
            {
                if(timer5 == null || timer5.isRunning() == false)
                {
                    JOptionPane.showMessageDialog( null, "Timer is not running!", "ERROR!", JOptionPane. ERROR_MESSAGE);
                }
                else
                {
                    timer5.stop();
                    park5_button.setEnabled(true);
                    park5_button.setText("Park_5(B)");
                    b2.set_Occupation(false);
                }
            }
            
            else if(invoker == park6_button)
            {
              if(timer6 == null || timer6.isRunning() == false)
                {
                    JOptionPane.showMessageDialog( null, "Timer is not running!", "ERROR!", JOptionPane. ERROR_MESSAGE);
                }
                else
                {
                    timer6.stop();
                    park6_button.setEnabled(true);
                    park6_button.setText("Park_6(B)");
                    b3.set_Occupation(false);
                }
            }
            
            else if(invoker == park7_button)
            {
                if(timer7 == null || timer7.isRunning() == false)
                {
                    JOptionPane.showMessageDialog( null, "Timer is not running!", "ERROR!", JOptionPane. ERROR_MESSAGE);
                }
                else
                {
                    timer7.stop();
                    park7_button.setEnabled(true);
                    park7_button.setText("Park_7(C)");
                    c1.set_Occupation(false);
                }
            }
            
            else if(invoker == park8_button)
            {
               if(timer8 == null || timer8.isRunning() == false)
                {
                    JOptionPane.showMessageDialog( null, "Timer is not running!", "ERROR!", JOptionPane. ERROR_MESSAGE);
                }
                else
                {
                    timer8.stop();
                    park8_button.setEnabled(true);
                    park8_button.setText("Park_8(C)");
                    c2.set_Occupation(false);
                }
            }
            
            else if(invoker == park9_button)
            {
                if(timer9 == null || timer9.isRunning() == false)
                {
                    JOptionPane.showMessageDialog( null, "Timer is not running!", "ERROR!", JOptionPane. ERROR_MESSAGE);
                }
                else
                {
                    timer9.stop();
                    park9_button.setEnabled(true);
                    park9_button.setText("Park_9(C)");
                    c3.set_Occupation(false);
                }
            }
        }
        
        else if(Event.getSource() == refresh_button)
        {
           refresh();
        }
        
        else if(Event.getSource() == clear_button)
        {
            try
            {
                jta.setText(""); // Clears all text from JTextArea //
                validate();
                repaint();
                counter = 1;
            }catch(Exception e)
            {
                jta.append(""+counter+") Error: "+e.getClass().getCanonicalName()+" \n\n ");
                counter++;
                JOptionPane.showMessageDialog( null, ""+e+"", "ERROR!", JOptionPane. ERROR_MESSAGE);
            }
        }

        else if(Event.getSource() == jm_github) 
    {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) // if the github button is pressed on the main frame //
            {
                try 
                {
                    Desktop.getDesktop().browse(new URI("https://github.com/AtahanEkici/SE-116/tree/Project"));
                    jta.append(""+counter+") Opened github page on  default browser \n\n");
                    counter++;
                } catch (Exception e) 
                {
                     jta.append(""+counter+") Error: "+e.getClass().getCanonicalName()+" \n\n ");
                     counter++;
                JOptionPane.showMessageDialog( null, ""+e.getMessage()+"", ""+e.getClass().getCanonicalName()+"", JOptionPane. ERROR_MESSAGE);
                }
            }
    }
    
        else if(Event.getSource() == jm_new) 
    {
       try
     {  
               String text = null;
               
               while(text == null || text.trim().equals(""))
               {
                   text = JOptionPane.showInputDialog(null,"Please enter something","Specify Input",INFORMATION_MESSAGE);
                           
                   if(text == null)
                   {
                       JOptionPane.showMessageDialog( null, "Lütfen bir değer girin", "Just Type Something", JOptionPane.ERROR_MESSAGE);
                   }  
               }
               BufferedWriter writer;
               JFileChooser fileChooser;
               fileChooser = new JFileChooser(System.getProperty("user.home") +"/Desktop");
               fileChooser.setFileFilter(new FileNameExtensionFilter("txt file","txt"));
               fileChooser.setSelectedFile(new File(""+new Date().getTime()+".txt"));
               int result = fileChooser.showSaveDialog(null);
               
               if(result == JFileChooser.APPROVE_OPTION)
               {
                writer = new BufferedWriter(new FileWriter(fileChooser.getSelectedFile()));
                writer.append(text);
                writer.close();
                JOptionPane.showMessageDialog(null, "File has been saved","File Saved",JOptionPane.INFORMATION_MESSAGE);
               }
    } catch (Exception e) 
    {
        if(e instanceof IOException)
        {
            JOptionPane.showMessageDialog( null, "Dosya oluştururken hata oluştu", ""+e.getClass().getCanonicalName()+"", JOptionPane. ERROR_MESSAGE);
        }
        else
        {
            jta.append(""+counter+") Error: "+e.getClass().getCanonicalName()+" \n\n ");
                counter++;
                JOptionPane.showMessageDialog( null, ""+e.getMessage()+"", ""+e.getClass().getCanonicalName()+"", JOptionPane. ERROR_MESSAGE);
        }         
    }
  }
    
        else if(Event.getSource() == jm_read)
        {
            try
            {
               JFileChooser fileChooser;
               fileChooser = new JFileChooser(System.getProperty("user.home") +"/Desktop");
               fileChooser.setFileFilter(new FileNameExtensionFilter("txt file","txt"));
               int result = fileChooser.showOpenDialog(getParent());
               
               if (result == JFileChooser.APPROVE_OPTION) 
               {
                  jta.append(""+counter+") Dosya başarıyla okundu : ");
                  counter++;
               }
               else
               {
                    jta.append(""+counter+") Dosya okunamadı \n\n");
                    counter++;
               }
               
               File selectedFile = fileChooser.getSelectedFile();
               
               StringBuilder stringBuilder;
                try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) 
                {
                    stringBuilder = new StringBuilder();
                    String line;
                    String ls = System.getProperty("line.separator");
                    while ((line = reader.readLine()) != null)
                    {
                        stringBuilder.append(line);
                        stringBuilder.append(ls);
                    }
                    reader.close();
                }
                
String content = stringBuilder.toString().replaceAll(" ", "");
jta.append(""+content+" \n\n");
counter++;
validate();
repaint();
}catch(Exception e)
            {
                if(e instanceof NullPointerException)
                {
                    JOptionPane.showMessageDialog( null, "Dosya Seçilmedi", "HATA!", JOptionPane. ERROR_MESSAGE);
                }
                else
                {
                 jta.append(""+counter+") Error: "+e.getClass().getCanonicalName()+" \n\n ");
                 counter++;
                 JOptionPane.showMessageDialog( null, ""+e+"", "ERROR!", JOptionPane. ERROR_MESSAGE);
                }
            }
        }
        
        else if(Event.getSource() == jm_about)
        {
            try
            {   
                JOptionPane.showMessageDialog(null,"<html><font color=#0066ff> <u> <br> Java Swing Application </br> </u> </font> \n"
                        + "<html><font color=#0066ff><u> <br> Java</br></u>: </font>  1.8.0_111 </html> \n"
                        + "<html><font color=#0066ff> <u> <br> IDE</br></u>: </font>  Apache Netbeans IDE 12.0 </html>\n"
                        + "<html><font color=#0066ff><u> <br> Icons</br></u>: </font>  www.flaticon.com </html>","About This Project",JOptionPane.INFORMATION_MESSAGE);     
            }catch(Exception e)
            {
                jta.append(""+counter+") Error: "+e.getClass().getCanonicalName()+" \n\n ");
                counter++;
                JOptionPane.showMessageDialog( null, ""+e+"", "ERROR!", JOptionPane. ERROR_MESSAGE);
            }
        }     
}

    @Override
    public void mouseClicked(MouseEvent me) 
    {
        ShowPopupMenu(me);
    }

    @Override
    public void mousePressed(MouseEvent me) 
    {
        ShowPopupMenu(me);
    }

    @Override
    public void mouseReleased(MouseEvent me) 
    {
        ShowPopupMenu(me);
    }

    @Override
    public void mouseEntered(MouseEvent me) 
    {
        if(me.getSource() == fileMenu)
        {
            fileMenu.setSelected(true); // begin hover effect //
        }
        else if(me.getSource() == aboutMenu)
        {
            aboutMenu.setSelected(true); // begin hover effect //
        }
    }

    @Override
    public void mouseExited(MouseEvent me)
    {
        if(me.getSource() == fileMenu)
        {
            fileMenu.setSelected(false); // dispose hover effect //
        }
        else if(me.getSource() == aboutMenu)
        {
            aboutMenu.setSelected(false); // dispose hover effect //
        }
    }
    
    private void ShowPopupMenu(MouseEvent me) 
    {
        if (me.isPopupTrigger()) 
        {
            jpm.show(me.getComponent(),me.getX(), me.getY());
        }
}
}