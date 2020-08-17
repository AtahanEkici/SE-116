
package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URI;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

/**
 *
 * @author Atahan Ekici
 */

public final class UI extends JFrame implements ActionListener
{    
    private static UI single_instance = null;
    
    UI()
    {
        Construct_Main_Frame();
    }  
    
    JFrame main = new JFrame("SE116 Project - Main Frame");
    JButton github_button,button,clear_button,about_button;
    JTextArea jta;
    JMenuBar mb;
    JScrollPane jsp;
    JOptionPane jop;
    
    public int counter = 1;
    
    
    public void Construct_Main_Frame()       
    {
       
        main.setLayout(new BorderLayout());
        main.setResizable(false);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel tutucu = new JPanel();
        tutucu.setLayout(new FlowLayout(FlowLayout.LEADING));
        
        JPanel textArea = new JPanel();
        textArea.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        
        mb = new JMenuBar();
        main.setJMenuBar(mb);

        // Github Button Tanımı Başlangıç //
        github_button = new JButton("GitHub");
        github_button.setOpaque(true);
        github_button.setFocusable(false);
        github_button.addActionListener(this);
        // Github Button Tanımı Bitiş //
        
         // Button Tanımı Başlangıç //
         button = new JButton("Buton");
         button.addActionListener(this);
        // Button Tanımı Bitiş //
        
        // Clear_Button Tanımı Başlangıç //
         clear_button = new JButton("Clear");
         clear_button.addActionListener(this);
         // Clear_Button Tanımı Bitişi //
         
         // About_Button Tanımı Başlangıç //
         about_button = new JButton("About");
         about_button.addActionListener(this);
         // About_Button Tanımı Bitişi //
        
        mb.add(github_button);
        mb.add(button);
        mb.add(clear_button);
        mb.add(about_button);
        
        jsp = new JScrollPane();
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
       
        jta = new JTextArea(45,70);
        jta.setBorder(new LineBorder(Color.BLACK));
        jta.setEditable(false);
        
        jsp.getViewport().setBackground(Color.WHITE);
        jsp.getViewport().add(jta);
        add(jsp);
                     
        textArea.add(jsp);
  
        main.add(textArea,BorderLayout.PAGE_END); // Text'leri tutan panelin JFrame'e iliştirilmesi //
        main.add(tutucu,BorderLayout.AFTER_LINE_ENDS);
        main.pack(); // Function that packs the frame and cuts the unnecessary lines //
        
        main.setLocationRelativeTo(null); // initially start the frame at the center of the screen //
        main.setVisible(true);  
        
    }
    
    public static UI getInstance() // Singleton Pattern //
    {
        if(single_instance == null)
        {
            single_instance = new UI();
        }
            return single_instance;    
    }

    @Override
    public void actionPerformed(ActionEvent Event) // Action Listener instructions //
    {
        if(Event.getSource() == github_button) // The switch case only allows primitive types so i can not use it here back to if-else //
    {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) // if the github button is pressed on the main frame //
            {
                try 
                {
                    Desktop.getDesktop().browse(new URI("https://github.com/AtahanEkici/SE-116"));
                    jta.append(""+counter+") Opened github page on  default browser \n\n");
                    counter++;
                } catch (Exception e) 
                {
                     jta.append(""+counter+") Error: "+e.getClass().getCanonicalName()+" \n\n ");
                     counter++;
                JOptionPane.showMessageDialog( null, ""+e+"", ""+e.getClass().getCanonicalName()+"", JOptionPane. ERROR_MESSAGE);
                }
            }
    }
        else if(Event.getSource() == button)
        {
            try
            {
               JFileChooser fileChooser;
               fileChooser = new JFileChooser(System.getProperty("user.home") +"/Desktop");
               int result = fileChooser.showOpenDialog(getParent());
               
               if (result == JFileChooser.APPROVE_OPTION) 
               {
                  jta.append(""+counter+") File selection successfull \n\n");
                  counter++;
               }
               else
               {
                    jta.append(""+counter+") File selection fail \n\n");
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
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                }
                
String content = stringBuilder.toString();
jta.append(""+counter+") \n "+content+" \n\n");
counter++;

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
                counter = 1;
            }catch(Exception e)
            {
                jta.append(""+counter+") Error: "+e.getClass().getCanonicalName()+" \n\n ");
                counter++;
                JOptionPane.showMessageDialog( null, ""+e+"", "ERROR!", JOptionPane. ERROR_MESSAGE);
            }
        }
        
        else if(Event.getSource() == about_button)
        {
            try
            {   
                JOptionPane.showMessageDialog(null,"<html><font color=#0066ff> <u> <br> Java Swing Application </br> </u> </font> \n"
                        + "<html><font color=#0066ff><u> <br> Java </br>: </u> </font> 1.8.0_111 \n"
                        + "<html><font color=#0066ff> <u> <br> IDE </br>:  </u> </font> Netbeans IDE 12.0","About This Project",JOptionPane.INFORMATION_MESSAGE);     
            }catch(Exception e)
            {
                jta.append(""+counter+") Error: "+e.getClass().getCanonicalName()+" \n\n ");
                counter++;
                JOptionPane.showMessageDialog( null, ""+e+"", "ERROR!", JOptionPane. ERROR_MESSAGE);
            }
            // Exception Handling //

        }
}
}