package CLI;
/**
 *
 * @author Atahan Ekici
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public final class CLI extends KeyAdapter
{
     private static CLI single_instance = null;
     protected static final Color PALE_BLACK = new Color(33, 37, 41);
    
        public static CLI getInstance() // Singleton Pattern so that only one frame will open //
    {
        if(single_instance == null)
        {
            single_instance = new CLI();
        }
            return single_instance;    
    }
        CLI()
        {
         try
         {
             Construct_CLI();
         }
         catch (Exception ex) 
         {
             JOptionPane.showMessageDialog(null,""+ex+"","ERROR!",JOptionPane.ERROR_MESSAGE);
         }
        }
    
    private void Construct_CLI() 
    {     
    JFrame MainFrame = new JFrame("Command Line Interface");
    MainFrame.addKeyListener(this);
    MainFrame.setLayout(new BorderLayout());
    MainFrame.setResizable(false);
    MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JPanel textArea = new JPanel();
    textArea.setLayout(new FlowLayout(FlowLayout.LEADING));
    textArea.setBackground(PALE_BLACK);
    textArea.addKeyListener(this);
    
    JPanel InputArea = new JPanel();
    InputArea.setLayout(new FlowLayout(FlowLayout.CENTER));
    InputArea.setLayout(new BorderLayout());
    InputArea.addKeyListener(this);

    JTextArea jta = new JTextArea(15,40);
    jta.setBackground(PALE_BLACK);
    jta.setForeground(Color.WHITE);
    jta.setEditable(false);
    jta.addKeyListener(this);
    
    JTextArea jta2 = new JTextArea();
    jta2.addKeyListener(this);
    
    JButton Submit = new JButton("OK");
    Submit.setBackground(Color.WHITE);
    Submit.setFocusable(false);
    Submit.addActionListener((ActionEvent ae) -> 
    {
        jta.append(jta2.getText()+"\n");
    });
    
    InputArea.add(jta2);
    InputArea.add(Submit,BorderLayout.LINE_END);
    
    JScrollPane jsp = new JScrollPane();
    jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    jsp.setBorder(null);
    
    jsp.getViewport().add(jta);
    textArea.add(jsp);
    
    MainFrame.add(textArea,BorderLayout.PAGE_START);
    MainFrame.add(InputArea,BorderLayout.SOUTH);  
    MainFrame.pack();
    MainFrame.setLocationRelativeTo(null);
    MainFrame.setVisible(true);
    } 

    @Override
    public void keyPressed(KeyEvent e) 
    {
        if (e.getKeyCode()== KeyEvent.VK_Q)
        {
            System.out.println("Key Q pressed!");
        }       
    }
}