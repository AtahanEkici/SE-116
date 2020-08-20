package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.FlowLayout;
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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

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
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog( null, ""+e+"", "ERROR!", JOptionPane. ERROR_MESSAGE);
        }
        
    }  

    public static final Color PALE_BLACK = new Color(33, 37, 41);
    
    JFrame main;
    JButton clear_button,refresh_button;
    JTextArea jta;
    JMenuBar mb;
    JMenu fileMenu,aboutMenu;
    JMenuItem jm_read,jm_new,jm_about,jm_github;
    JScrollPane jsp;
    JOptionPane jop;
    
    public int counter = 1;  
    
    public void Construct_Main_Frame()       
    {
        main = new JFrame("SE116 Project - Main Frame");
        main.setForeground(PALE_BLACK);
        main.setBackground(PALE_BLACK);
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
    
   // Action Event Handling //
    
    @Override
    public void actionPerformed(ActionEvent Event) // Action Listener instructions //
    {
        if(Event.getSource() == jm_github) // The switch case only allows primitive types so i can not use it here back to if-else //
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
        
        else if(Event.getSource() == refresh_button)
        {
            main.setVisible(false);
            main.dispose();
            
            main.repaint();
            main.revalidate();
            main.setVisible(true);
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
        
        else if(Event.getSource() == jm_about)
        {
            try
            {   
                JOptionPane.showMessageDialog(null,"<html><font color=#0066ff> <u> <br> Java Swing Application </br> </u> </font> \n"
                        + "<html><font color=#0066ff><u> <br> Java</br></u>: </font>  1.8.0_111 </html> \n"
                        + "<html><font color=#0066ff> <u> <br> IDE</br></u>: </font>  Apache Netbeans IDE 12.0 </html>\n"
                        + "<html><font color=#0066ff><u> <br> Icon</br></u>: </font>  www.flaticon.com </html>","About This Project",JOptionPane.INFORMATION_MESSAGE);     
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
        // Not Needed //
    }

    @Override
    public void mousePressed(MouseEvent me) 
    {
        // Not Needed //
    }

    @Override
    public void mouseReleased(MouseEvent me) 
    {
        // Not Needed //
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
}