 package UI;
import java.awt.BorderLayout;import java.awt.Color;import java.awt.Component;import java.awt.Desktop;import java.awt.FlowLayout;import java.awt.GridLayout;import java.awt.event.ActionEvent;import java.awt.event.ActionListener;import java.awt.event.MouseEvent;import java.awt.event.MouseListener;import java.io.BufferedReader;import java.io.BufferedWriter;import java.io.File;import java.io.FileReader;import java.io.FileWriter;import java.io.IOException;import java.net.URI;import java.util.Date;import javax.swing.BorderFactory;import javax.swing.ImageIcon;import javax.swing.JButton;import javax.swing.JFileChooser;import javax.swing.JFrame;import javax.swing.JMenu;import javax.swing.JMenuBar;import javax.swing.JMenuItem;import javax.swing.JOptionPane;import static javax.swing.JOptionPane.INFORMATION_MESSAGE;import javax.swing.JPanel;import javax.swing.JPopupMenu;import javax.swing.JScrollPane;import javax.swing.JTextArea;import javax.swing.Timer;import javax.swing.filechooser.FileNameExtensionFilter;import Code.*;import static Code.Utilities.SHA_256;import static Code.Utilities.getCurrentTime;import Interface.Interface_Container;import java.awt.Font;import java.awt.event.KeyEvent;import java.awt.event.KeyListener;import java.awt.event.WindowAdapter;import java.awt.event.WindowEvent;import java.math.BigDecimal;import java.math.MathContext;import javax.swing.JLabel;import javax.swing.JTextField;
/**
 *
 * @author Atahan Ekici
 */
public final class UI extends JFrame implements ActionListener,MouseListener,Interface_Container,KeyListener
{    
    private static UI single_instance = null;
    
    public static UI getInstance()
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
            Construct_Payment_Frame();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,""+e+"","ERROR!",JOptionPane.ERROR_MESSAGE);
        }   
    } 
    
    private int counter = 1;  

    private static final Color PALE_BLACK = new Color(33, 37, 41);
    
    // ------------------------------------- Swing Components ------------------------------------- //
    private JFrame main,park,payment,cash,credit;
    private JButton clear_button,refresh_button,park_button,park1_button,park2_button,park3_button,park4_button,park5_button,park6_button,park7_button,park8_button,park9_button,payByCash_button,payByCreditCard_button;
    private JTextArea jta;
    private JMenuBar mb;
    private JMenu fileMenu,aboutMenu;
    private JMenuItem jm_read,jm_new,jm_about,jm_github; // Main Frame Menu Components //
    private JMenuItem pop_properties , pop_stop_timer; // Pop-Up Menu Components //
    private JScrollPane jsp;
    private JPopupMenu jpm;
    private Component invoker;
    // ------------------------------------- Swing Components ------------------------------------- //
    
    private static Timer timer1,timer2,timer3,timer4,timer5,timer6,timer7,timer8,timer9;
    private static String key1,key2,key3,key4,key5,key6,key7,key8,key9;
    private static int offset1,offset2,offset3,offset4,offset5,offset6,offset7,offset8,offset9;
    
    private int current_operation;
    private double current_fee;
    
    //------------------------------------- Parking Areas  ------------------------------------- //
    private static final Park_Area a1 = new A_ParkingArea();
    private static final Park_Area a2 = new A_ParkingArea();
    private static final Park_Area a3 = new A_ParkingArea();
    
    private static final Park_Area b1 = new B_ParkingArea();
    private static final Park_Area b2 = new B_ParkingArea();
    private static final Park_Area b3 = new B_ParkingArea();
    
    private static final Park_Area c1 = new C_ParkingArea();
    private static final Park_Area c2 = new C_ParkingArea();
    private static final Park_Area c3 = new C_ParkingArea();
    //------------------------------------- Parking Areas ------------------------------------- //
    
    private void Construct_Main_Frame() throws IOException     // Constructs the Main Frame //  
    {
        main = new JFrame("SE116 Project - Main Frame");
        ImageIcon image = new ImageIcon(getClass().getResource("/Icons/icon.png"));
        main.setIconImage(image.getImage());
        main.setLayout(new BorderLayout());
        main.setResizable(false);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.addKeyListener(this);
        
        JPanel tutucu = new JPanel();
        tutucu.setLayout(new FlowLayout());
        tutucu.setBackground(PALE_BLACK);
        tutucu.addKeyListener(this);
        
        JPanel textArea = new JPanel();
        textArea.setLayout(new FlowLayout(FlowLayout.CENTER));
        textArea.setBackground(Color.BLACK);
        textArea.addKeyListener(this);
        
        mb = new JMenuBar();
        main.setJMenuBar(mb);      
        mb.setBorder(BorderFactory.createLineBorder(PALE_BLACK));
        mb.addKeyListener(this);
        
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
        jsp.addKeyListener(this);
        
        jsp.getVerticalScrollBar().setBackground(PALE_BLACK);
        jsp.getHorizontalScrollBar().setBackground(PALE_BLACK);
        
        jta = new JTextArea(35,55);
        jta.setForeground(Color.WHITE);
        jta.setBackground(Color.BLACK);
        jta.setEditable(false);
        jta.addKeyListener(this);
        
        jsp.getViewport().add(jta);
        add(jsp);
                     
        textArea.add(jsp);
        textArea.setBorder(null);
  
        main.add(textArea,BorderLayout.PAGE_END); // Text'leri tutan panelin JFrame'e iliştirilmesi //
        main.add(tutucu,BorderLayout.NORTH); // Butonları tutan panelin Ana Frame'e eklenmesi //
        main.getContentPane().addKeyListener(this);
        main.pack(); // Function that packs the frame and cuts the unnecessary lines //
        main.setLocationRelativeTo(null); // initially start the frame at the center of the screen //
        main.setVisible(true);        
        main.setAutoRequestFocus(true);
        main.getContentPane().requestFocus();
    }
    
    private static double round(double value) // Rounds given presicion integer into 3 significant figures //
    {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.round(new MathContext(3));
        value = bd.doubleValue();
        return value;
    }
    
    private void Construct_Payment_Frame() throws IOException // Constructs Payment Frame //
    {
        payment = new JFrame("Payment Menu");
        ImageIcon image = new ImageIcon(getClass().getResource("/Icons/money.png"));
        payment.setIconImage(image.getImage());
        payment.setLayout(new GridLayout());
        payment.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        payment.setSize(500, 250);
        payment.getContentPane().setBackground(PALE_BLACK);
        
        payment.addWindowListener(new WindowAdapter() 
{
    @Override
    public void windowClosing(WindowEvent e) 
    {
        JOptionPane.showMessageDialog( null, "You have to pay the bill", "ERROR!", JOptionPane.ERROR_MESSAGE);
    }
});
        JPanel tutucu = new JPanel();
        tutucu.setLayout(new GridLayout());
        tutucu.setBackground(PALE_BLACK);
        
        payByCash_button = new JButton("Pay By Cash");
        payByCash_button.setFocusable(false);
        payByCash_button.setBackground(PALE_BLACK);
        payByCash_button.setForeground(Color.WHITE);
        payByCash_button.addActionListener(this);
        
        payByCreditCard_button = new JButton("Pay by Card");
        payByCreditCard_button.setFocusable(false);
        payByCreditCard_button.setBackground(PALE_BLACK);
        payByCreditCard_button.setForeground(Color.WHITE);
        payByCreditCard_button.addActionListener(this);
                
        tutucu.add(payByCash_button);
        tutucu.add(payByCreditCard_button);
        
        payment.add(tutucu);
        payment.setLocationRelativeTo(null);
    }
         
        
    private void Construct_PayByCash(double fee) // Constructs the pay by cash Menu //
        {
        cash = new JFrame("Pay With Cash Menu");
        cash.getContentPane().setBackground(PALE_BLACK);
        cash.setLayout(null);
        cash.setSize(300,300);
        cash.setResizable(false);
        cash.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        fee = round(fee);
        
        current_fee = fee;
        
        JLabel label = new JLabel("Your Fee is: "+fee+"");  
        label.setBounds(60,50,250,100);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Serif", Font.PLAIN, 20));
        
        JButton hundred = new JButton();  
        hundred.setText("100 TL");
        hundred.setBounds(30,200,72,30);
        hundred.addActionListener((new ActionListener()
        {  
    @Override
    public void actionPerformed(ActionEvent e)
    {  
        current_fee = (100 - current_fee);
        JOptionPane.showMessageDialog( null, "Your change is :"+current_fee+"", "Payment Successfull", JOptionPane.INFORMATION_MESSAGE);
        cash.dispose();
    }  
    }));
        
        cash.addWindowListener(new WindowAdapter() 
{
    @Override
    public void windowClosing(WindowEvent e) 
    {
        JOptionPane.showMessageDialog( null, "You have to pay the bill", "ERROR!", JOptionPane.ERROR_MESSAGE);
    }
});
        JButton fifty = new JButton();  
        fifty.setText("50 TL");
        fifty.setBounds(110,200,72,30);
        fifty.addActionListener((new ActionListener()
        {  
    @Override
    public void actionPerformed(ActionEvent e)
    {  
             current_fee = (50 - current_fee);
                JOptionPane.showMessageDialog( null, "Your change is :"+current_fee+"", "Payment Successfull", JOptionPane.INFORMATION_MESSAGE);
                cash.dispose();
    }  
    }));
        JButton twenty = new JButton();  
        twenty.setText("20 TL");
        twenty.setBounds(190,200,72,30);
        twenty.addActionListener((new ActionListener()
        {  
    @Override
    public void actionPerformed(ActionEvent e)
    {  
             current_fee = (20 - current_fee);
             JOptionPane.showMessageDialog( null, "Your change is :"+current_fee+"", "Payment Successfull", JOptionPane.INFORMATION_MESSAGE);
             cash.dispose();
    }  
    }));   
        cash.add(label);
        cash.add(hundred);
        cash.add(fifty);
        cash.add(twenty);
        cash.setLocationRelativeTo(null);
        }
        
    private void Construct_PayByCreditCard(double fee) // Constructs the pay by credit card menu //
        {
        
        credit = new JFrame("Pay With Cash Menu");
        credit.getContentPane().setBackground(PALE_BLACK);
        credit.setLayout(null);
        credit.setSize(300,300);
        credit.setResizable(false);
        credit.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        fee = round(fee);
        
        current_fee = fee;
        
        JLabel label = new JLabel("Your Fee is: "+fee+"");  
        label.setBounds(75,-15,250,100);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Serif", Font.PLAIN, 20));
        
        JLabel label2 = new JLabel("Card Number: ");  
        label2.setBounds(10,40,250,100);
        label2.setForeground(Color.WHITE);
        
        JTextField cardText = new JTextField("",11);  
        cardText.setBounds(90,82,150,20);  
        
        JTextField cvc = new JTextField("",3);  
        cvc.setBounds(90,120,30,20);
        
        JLabel label3 = new JLabel("CVC:");  
        label3.setBounds(60,80,250,100);
        label3.setForeground(Color.WHITE);
        
        JButton hundred = new JButton();  
        hundred.setText("OK");
        hundred.setBounds(120,200,55,40);
        hundred.setFocusable(false);
        hundred.addActionListener((new ActionListener()
        {  
    @Override
    public void actionPerformed(ActionEvent e)
    {  
            String card_number = cardText.getText();
            String CVC = cvc.getText();
            
            if(card_number.length() != 11)
            {
                JOptionPane.showMessageDialog( null, "Wrong Card Number Lenght"
                        + "(It should be 11)", "ERROR!", JOptionPane.ERROR_MESSAGE);
            }
            else if(CVC.length() != 3)
            {
                JOptionPane.showMessageDialog( null, "Wrong CVC Number Lenght"
                        + "(It should be 3)", "ERROR!", JOptionPane.ERROR_MESSAGE);
            }
            else if(card_number.length() == 11 && CVC.length() == 3)
            {
                JOptionPane.showMessageDialog( null, "Thank you for your visit", "Payment Successfull", JOptionPane.INFORMATION_MESSAGE);
                credit.dispose();
            }
            else
            {
                actionPerformed(e);
            }
    }  
    }));
        
        credit.addWindowListener(new WindowAdapter() 
{
    @Override
    public void windowClosing(WindowEvent e) 
    {
        JOptionPane.showMessageDialog( null, "You have to pay the bill", "ERROR!", JOptionPane.ERROR_MESSAGE);
    }
}); 
        credit.add(label);
        credit.add(label2);
        credit.add(label3);
        credit.add(cardText);
        credit.add(cvc);
        credit.add(hundred);
        credit.setLocationRelativeTo(null);
        }
        
    private void Construct_Parking_slots() throws IOException // Constructs Parking Slots Frame //
    {
        park = new JFrame("Park Menu");
        ImageIcon image = new ImageIcon(getClass().getResource("/Icons/park.png"));
        park.setIconImage(image.getImage());
        park.setLayout(new BorderLayout());
        park.setSize(500, 500);
        park.setResizable(true);
        park.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
        jpm = new JPopupMenu();
        
        pop_properties = new JMenuItem("Properties");
        pop_properties.addActionListener(this);
        
        pop_stop_timer = new JMenuItem("Disembark");
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
    
    private void refresh() // Refreshes the Main Frame in case of Failure on drawing bounds of the frame //
    {
        jta.append(""+counter+")Frame Refreshed\n\n");
        counter++;
        
        main.setVisible(false);
        park.setVisible(false);
        
        main.repaint();
        park.repaint();
        
        main.revalidate();
        park.revalidate();
        
        main.setVisible(true);
        park.setVisible(true);
        
        if(park.isActive() == true)
        {
            park.requestFocus();
        }
        else
        {
            main.requestFocus();
        }  
    }
    
    private void Save_To_File(String text) // Saves the ticket information //
    {
               BufferedWriter writer;
               JFileChooser jfc;
               jfc = new JFileChooser(System.getProperty("user.home") +"/Desktop");
               jfc.setFileFilter(new FileNameExtensionFilter("Ticket Files","ticket"));
               jfc.setSelectedFile(new File(""+new Date().getTime()+".ticket"));
               int result = jfc.showSaveDialog(null);
               
               if(result == JFileChooser.APPROVE_OPTION)
               {
                   try 
                   {
                       writer = new BufferedWriter(new FileWriter(jfc.getSelectedFile()));
                       writer.append(text);
                       writer.close();
                       JOptionPane.showMessageDialog(null, "Your ticket has been saved","File Saved",JOptionPane.INFORMATION_MESSAGE);
                   } 
                   catch (Exception e) 
                   {
                     JOptionPane.showMessageDialog(null,""+e+"","ERROR!",JOptionPane.ERROR_MESSAGE);  
                   }
               }
               else
               {
                    JOptionPane.showMessageDialog(null,"Could not save ticket","ERROR!",JOptionPane.ERROR_MESSAGE);
                    Save_To_File(text);
               }
    }
    
    private String Check_Key() // checks for the given ticket //
    {
        String content = null;
        
        try
            {
               JFileChooser fileChooser;
               fileChooser = new JFileChooser(System.getProperty("user.home") +"/Desktop");
               fileChooser.setFileFilter(new FileNameExtensionFilter("Ticket Files","ticket"));
               fileChooser.showOpenDialog(null);
               File selectedFile = fileChooser.getSelectedFile();
               StringBuilder stringBuilder;
               
                try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) 
                {
                    stringBuilder = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null)
                    {
                        stringBuilder.append(line);
                    }
                    content = stringBuilder.toString().trim();
                }              
}catch(Exception e)
            {
                if(e instanceof NullPointerException)
                {
                    JOptionPane.showMessageDialog( null, "No File was selected ", "ERROR!", JOptionPane. ERROR_MESSAGE);
                }
                else
                {
                 JOptionPane.showMessageDialog( null, ""+e+"", "ERROR!", JOptionPane. ERROR_MESSAGE);
                }
            }
        return content;
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
            key1  = SHA_256("park1_button"+getCurrentTime());
            Save_To_File(key1);
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
                        current_fee = a1.calculate_Discount(offset1);
                        current_operation = 1;
                        payment.setVisible(true);
                        park1_button.setEnabled(true);
                        park1_button.setText("Park_1(A)");
                        a1.set_Occupation(false);
                        timer1.stop();
                        offset1 = 0;
                    }
                    
                    else
                    {
                        i--;
                        offset1 = i;
                        park1_button.setText("Park_1(A) : " +Utilities.calculateTime(i));
                    }
                }
            });
            timer1.start();
        }
        
        else if(Event.getSource() == park2_button)
        {
            key2 = SHA_256("park2_button"+getCurrentTime());
            Save_To_File(key2);
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
                        current_fee = a2.calculate_Discount(offset1);
                        current_operation = 2;
                        payment.setVisible(true);
                        park2_button.setEnabled(true);
                        park2_button.setText("Park_2(A)");
                        a2.set_Occupation(false);
                        timer2.stop();
                        offset2 = 0;
                    }
                    
                    else
                    {
                        i--;    
                        offset2 = i;
                        park2_button.setText("Park_2(A) : " +Utilities.calculateTime(i));
                    }
                }
            });
            timer2.start();
        }
        
        else if(Event.getSource() == park3_button)
        {
            key3 = SHA_256("park3_button"+getCurrentTime());
            Save_To_File(key3);
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
                        current_fee = a3.calculate_Discount(offset1);
                        current_operation = 3;
                        payment.setVisible(true);
                        park3_button.setEnabled(true);
                        park3_button.setText("Park_3(A)");
                        a3.set_Occupation(false);
                        timer3.stop();
                        offset3 = 0;
                    }
                    
                    else
                    {
                        i--;
                        offset3 = i;
                        park3_button.setText("Park_3(A) : " +Utilities.calculateTime(i));
                    }
                }
            });  
            timer3.start();
        }
        
        else if(Event.getSource() == park4_button)
        {
            key4 = SHA_256("park4_button"+getCurrentTime());
            Save_To_File(key4);
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
                        current_fee = b1.calculate_Discount(offset1);
                        current_operation = 4;
                        payment.setVisible(true);
                        park4_button.setEnabled(true);
                        park4_button.setText("Park_4(B)");
                        b1.set_Occupation(false);
                        timer4.stop();
                        offset4 = 0;
                    }
                    
                    else
                    {
                        i--;
                        offset4 = i;
                        park4_button.setText("Park_4(B) : " +Utilities.calculateTime(i));
                    }
                }
            }); 
            timer4.start();
        }
        
        else if(Event.getSource() == park5_button)
        {
            key5 = SHA_256("park5_button"+getCurrentTime());
            Save_To_File(key5);
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
                        current_fee = b2.calculate_Discount(offset1);
                        current_operation = 5;
                        payment.setVisible(true);
                        park5_button.setEnabled(true);
                        park5_button.setText("Park_5(B)");
                        b2.set_Occupation(false);
                        timer5.stop();
                        offset5 = 0;
                    }
                    
                    else
                    {
                        i--;
                        offset5 = i;
                        park5_button.setText("Park_5(B) : " +Utilities.calculateTime(i));
                    }
                }
            }); 
            timer5.start();
        }
        
        else if(Event.getSource() == park6_button)
        { 
            key6 = SHA_256("park6_button"+getCurrentTime());
            Save_To_File(key6);
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
                        current_fee = b3.calculate_Discount(offset1);
                        current_operation = 6;
                        payment.setVisible(true);
                        park6_button.setEnabled(true);
                        park6_button.setText("Park_6(B)");
                        b3.set_Occupation(false);
                        timer6.stop();
                        offset6 = 0;
                    }
                    
                    else
                    {
                        i--;
                        offset6 = i;
                        park6_button.setText("Park_6(B) : " +Utilities.calculateTime(i));
                    }
                }
            }); 
            timer6.start();
        }
        
        else if(Event.getSource() == park7_button)
        {
            key7 = SHA_256("park7_button"+getCurrentTime());
            Save_To_File(key7);
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
                        current_fee = c1.calculate_Discount(offset1);
                        current_operation = 7;
                        payment.setVisible(true);
                        park7_button.setEnabled(true);
                        park7_button.setText("Park_7(C)");
                        c1.set_Occupation(false);
                        timer7.stop();
                        offset7 = 0;
                    }
                    
                    else
                    {
                        i--;
                        offset7 = i;
                        park7_button.setText("Park_7(C) : " +Utilities.calculateTime(i));
                    }
                }
            }); 
            timer7.start();
        }
        
        else if(Event.getSource() == park8_button)
        {
            SHA_256("park8_button"+getCurrentTime());
            Save_To_File(key8);
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
                        current_fee = c2.calculate_Discount(offset1);
                        current_operation = 8;
                        payment.setVisible(true);
                        park8_button.setEnabled(true);
                        park8_button.setText("Park_8(C)");
                        c2.set_Occupation(false);
                        timer8.stop();
                        offset8 = 0;
                    }
                    
                    else
                    {
                        i--;
                        offset8 = i;
                        park8_button.setText("Park_8(C) : " +Utilities.calculateTime(i));
                    }
                }
            }); 
            timer8.start();
        }
        
        else if(Event.getSource() == park9_button)
        {
            key9 = SHA_256("park9_button"+getCurrentTime());
            Save_To_File(key9);
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
                        current_fee = c3.calculate_Discount(offset1);
                        current_operation = 9;
                        payment.setVisible(true);
                        park9_button.setEnabled(true);
                        park9_button.setText("Park_9(C)");
                        c3.set_Occupation(false);
                        timer9.stop();
                        offset9 = 0;
                    }
                    
                    else
                    {
                        i--;
                        offset9 = i;
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
                JOptionPane.showMessageDialog(null,"Park Slot: "+a1.get_parkingSlot()+"\n"+a1.toString()+"\nSlot Type: "+a1.parking_slot_type()+"","Properties",INFORMATION_MESSAGE);
            }
            
            else if(invoker == park2_button)
            {
                JOptionPane.showMessageDialog(null,"Park Slot: "+a2.get_parkingSlot()+"\n"+a2.toString()+"\nSlot Type: "+a2.parking_slot_type()+"","Properties",INFORMATION_MESSAGE);
            }
            
            else if(invoker == park3_button)
            {
                JOptionPane.showMessageDialog(null,"Park Slot: "+a3.get_parkingSlot()+"\n"+a3.toString()+"\nSlot Type: "+a3.parking_slot_type()+"","Properties",INFORMATION_MESSAGE);
            }
            
            else if(invoker == park4_button)
            {
                JOptionPane.showMessageDialog(null,"Park Slot: "+b1.get_parkingSlot()+"\n"+b1.toString()+"\nSlot Type: "+b1.parking_slot_type()+"","Properties",INFORMATION_MESSAGE);
            }
            
            else if(invoker == park5_button)
            {
                JOptionPane.showMessageDialog(null,"Park Slot: "+b2.get_parkingSlot()+"\n"+b2.toString()+"\nSlot Type: "+b2.parking_slot_type()+"","Properties",INFORMATION_MESSAGE);
            }
            
            else if(invoker == park6_button)
            {
                JOptionPane.showMessageDialog(null,"Park Slot: "+b3.get_parkingSlot()+"\n"+b3.toString()+"\nSlot Type: "+b3.parking_slot_type()+"","Properties",INFORMATION_MESSAGE);
            }
            
            else if(invoker == park7_button)
            {
                JOptionPane.showMessageDialog(null,"Park Slot: "+c1.get_parkingSlot()+"\n"+c1.toString()+"\nSlot Type: "+c1.parking_slot_type()+"","Properties",INFORMATION_MESSAGE);
            }
            
            else if(invoker == park8_button)
            {
                JOptionPane.showMessageDialog(null,"Park Slot: "+c2.get_parkingSlot()+"\n"+c2.toString()+"\nSlot Type: "+c2.parking_slot_type()+"","Properties",INFORMATION_MESSAGE);
            }
            
            else if(invoker == park9_button)
            {
                JOptionPane.showMessageDialog(null,"Park Slot: "+c3.get_parkingSlot()+"\n"+c3.toString()+"\nSlot Type: "+c3.parking_slot_type()+"","Properties",INFORMATION_MESSAGE);
            }
        }
        
        else if(Event.getSource() == pop_stop_timer)
        {
            invoker = jpm.getInvoker();
            
            if(invoker == park1_button)
            {
                if(timer1 == null || timer1.isRunning() == false)
                {
                    JOptionPane.showMessageDialog(null,"Timer is not running!","ERROR!",JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    String selected = Check_Key().trim();
                    
                    if(selected.equals(key1))
                    {
                    current_fee = a1.calculate_Discount(offset1);
                    current_operation = 1;
                    payment.setVisible(true);
                    JOptionPane.showMessageDialog(null,"Fee for embarking is: "+a1.calculate_Discount(offset1)+"","Success", JOptionPane.PLAIN_MESSAGE); 
                    timer1.stop();
                    park1_button.setEnabled(true);
                    park1_button.setText("Park_1(A)");
                    a1.set_Occupation(false);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Key is not identified","ERROR!", JOptionPane.ERROR_MESSAGE);
                    }
                    
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
                    String selected = Check_Key().trim();
                    
                    if(selected.equals(key2))
                    {
                    current_fee = a2.calculate_Discount(offset2); 
                    current_operation = 2;
                    payment.setVisible(true);
                    JOptionPane.showMessageDialog(null,"Fee for embarking is: "+a2.calculate_Discount(offset2)+"","Success", JOptionPane.PLAIN_MESSAGE);    
                    timer2.stop();
                    a2.set_Occupation(false);
                    park2_button.setText("Park_2(A)");
                    park2_button.setEnabled(true);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Key is not identified","ERROR!", JOptionPane.ERROR_MESSAGE);
                    }
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
                    String selected = Check_Key().trim();
                    
                    if(selected.equals(key3))
                    {   
                    current_fee = a3.calculate_Discount(offset3);
                    current_operation = 3;
                    payment.setVisible(true);
                    JOptionPane.showMessageDialog(null,"Fee for embarking is: "+a3.calculate_Discount(offset3)+"","Success", JOptionPane.PLAIN_MESSAGE);    
                    timer3.stop();
                    park3_button.setEnabled(true);
                    park3_button.setText("Park_3(A)");
                    a3.set_Occupation(false);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Key is not identified","ERROR!", JOptionPane.ERROR_MESSAGE);
                    }
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
                    String selected = Check_Key().trim();
                    
                    if(selected.equals(key4))
                    {
                    current_fee = b1.calculate_Discount(offset4);  
                    current_operation = 4;
                    payment.setVisible(true);
                    JOptionPane.showMessageDialog(null,"Fee for embarking is: "+b1.calculate_Discount(offset4)+"","Success", JOptionPane.PLAIN_MESSAGE);    
                    timer4.stop();
                    park4_button.setEnabled(true);
                    park4_button.setText("Park_4(B)");
                    b1.set_Occupation(false);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Key is not identified","ERROR!", JOptionPane.ERROR_MESSAGE);
                    }
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
                    String selected = Check_Key().trim();
                    
                    if(selected.equals(key5))
                    {
                    current_fee = b2.calculate_Discount(offset5); 
                    current_operation = 5;
                    payment.setVisible(true);
                    JOptionPane.showMessageDialog(null,"Fee for embarking is: "+b2.calculate_Discount(offset5)+"","Success", JOptionPane.PLAIN_MESSAGE);     
                    timer5.stop();
                    park5_button.setEnabled(true);
                    park5_button.setText("Park_5(B)");
                    b2.set_Occupation(false);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Key is not identified","ERROR!", JOptionPane.ERROR_MESSAGE);
                    }
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
                    String selected = Check_Key().trim();
                    
                    if(selected.equals(key6))
                    {
                    current_fee = b3.calculate_Discount(offset6);
                    current_operation = 6;
                    payment.setVisible(true);
                    JOptionPane.showMessageDialog(null,"Fee for embarking is: "+b3.calculate_Discount(offset6)+"","Success", JOptionPane.PLAIN_MESSAGE);     
                    timer6.stop();
                    park6_button.setEnabled(true);
                    park6_button.setText("Park_6(B)");
                    b3.set_Occupation(false);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Key is not identified","ERROR!", JOptionPane.ERROR_MESSAGE);
                    }
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
                    String selected = Check_Key().trim();
                    
                    if(selected.equals(key7))
                    {
                    current_fee = c1.calculate_Discount(offset7);  
                    current_operation = 7;
                    payment.setVisible(true);
                    JOptionPane.showMessageDialog(null,"Fee for embarking is: "+c1.calculate_Discount(offset7)+"","Success", JOptionPane.PLAIN_MESSAGE);    
                    timer7.stop();
                    park7_button.setEnabled(true);
                    park7_button.setText("Park_7(C)");
                    c1.set_Occupation(false);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Key is not identified","ERROR!", JOptionPane.ERROR_MESSAGE);
                    }
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
                    String selected = Check_Key().trim();
                    
                    if(selected.equals(key8))
                    {
                    current_fee = c2.calculate_Discount(offset8);   
                    current_operation = 8;
                    payment.setVisible(true);
                    JOptionPane.showMessageDialog(null,"Fee for embarking is: "+c2.calculate_Discount(offset8)+"","Success", JOptionPane.PLAIN_MESSAGE);    
                    timer8.stop();
                    park8_button.setEnabled(true);
                    park8_button.setText("Park_8(C)");
                    c2.set_Occupation(false);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Key is not identified","ERROR!", JOptionPane.ERROR_MESSAGE);
                    }
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
                    String selected = Check_Key().trim();
                    
                    if(selected.equals(key9))
                    {
                    current_fee = c3.calculate_Discount(offset9); 
                    current_operation = 9;
                    payment.setVisible(true);
                    JOptionPane.showMessageDialog(null,"Fee for embarking is: "+c3.calculate_Discount(offset9)+"","Success", JOptionPane.PLAIN_MESSAGE);    
                    timer9.stop();
                    park9_button.setEnabled(true);
                    park9_button.setText("Park_9(C)");
                    c3.set_Occupation(false);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Key is not identified","ERROR!", JOptionPane.ERROR_MESSAGE);
                    }
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
                JOptionPane.showMessageDialog(null,"<html><font color=#0066ff> <u> <br> Java Swing Application </br> </u> </font> </html>\n"
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
        
        else if(Event.getSource() == payByCreditCard_button)
        {
            payment.dispose();
            payByCreditCard(current_fee);
            
        }
        
        else if(Event.getSource() == payByCash_button)
        {
            payment.dispose();
            payByCash(current_fee);
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

    @Override
    public void payByCash(double Fee) 
    { 
       Construct_PayByCash(Fee);
       cash.setVisible(true);
    }

    @Override
    public void payByCreditCard(double Fee) 
    {
        Construct_PayByCreditCard(Fee);
        credit.setVisible(true);
    }

    @Override
    public void keyPressed(KeyEvent e) 
    {
        if (e.getKeyCode()== KeyEvent.VK_F5)
        {
            refresh();
        }    
    }
    
@Override public void keyTyped(KeyEvent e){} // Not Needed //
@Override public void keyReleased(KeyEvent e){} // Not Needed //
}