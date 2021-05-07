import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import java.awt.Window.Type;

public class Main { 
   
   private JFrame window;
   private JFrame instructions;
   private JTextField textField1, textField2;
   static String player1;
   static String player2;
  
   public static void main(String[] args) {
     new Main();
     //new PongFrame();
   }
    
   public Main(){
      initialize2();
   }
    
   public void initialize2(){
      window = new JFrame();
      window.setTitle("Pong");
      window.setBounds(342, 152, 865, 540);
      window.getContentPane().setLayout(null);
      window.setResizable(false);
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window.getContentPane().setBackground(new Color(77,94,251,150));
      
      Icon icon = new ImageIcon("play-button.jpg"); 
   
      
      JButton btnNewButton = new JButton(icon);
      btnNewButton.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
               String[] names = new String[2];
               player1 = textField1.getText();
               player2 = textField2.getText();
               names[0] = player1;
               names[1] = player2;
            
               if (!player1.equals("") && !player2.equals("")) {
                  new PongFrame();
                 // window.setVisible(false);
                  window.dispose();
               }
               
            }
         });

      btnNewButton.setBounds(290, 200, 250, 250);
      window.getContentPane().add(btnNewButton);
      btnNewButton.setBorderPainted(false);
      
      JLabel lblNewLabel_4 = new JLabel("PONG");
      lblNewLabel_4.setFont(new Font("Bauhaus 93", Font.PLAIN, 150));
      lblNewLabel_4.setBounds(300, 20, 600, 210);
      window.getContentPane().add(lblNewLabel_4);
      
      JLabel jLabelObject = new JLabel();
      jLabelObject.setIcon(new ImageIcon("paddles.jpg"));
      jLabelObject.setBounds(5, 10, 300, 235);
      window.getContentPane().add(jLabelObject);
      
        	
      JLabel lblNewLabel_5 = new JLabel("Player 1");
      lblNewLabel_5.setFont(new Font("Lucida Calligraphy", Font.BOLD, 25));
      lblNewLabel_5.setBounds(50, 250, 150, 50);
      window.getContentPane().add(lblNewLabel_5);
      
      textField1 = new JTextField();
      textField1.setBounds(20, 300, 185, 40);
      window.getContentPane().add(textField1);
      textField1.setColumns(10);
      textField1.setBackground(Color.white);
      textField1.setFont(new Font("Bauhaus 93", Font.PLAIN, 25));
      textField1.setHorizontalAlignment(JTextField.CENTER);
      
      JLabel lblNewLabel_6 = new JLabel("Player 2");
      lblNewLabel_6.setFont(new Font("Lucida Calligraphy", Font.BOLD, 25));
      lblNewLabel_6.setBounds(645, 250, 150, 50);
      window.getContentPane().add(lblNewLabel_6);
      
      textField2 = new JTextField();
      textField2.setBounds(610, 300, 185, 40);
      window.getContentPane().add(textField2);
      textField2.setColumns(10);
      textField2.setBackground(Color.white);
      textField2.setFont(new Font("Bauhaus 93", Font.PLAIN, 25));
      textField2.setHorizontalAlignment(JTextField.CENTER);
      
      JMenuBar menuBar = new JMenuBar();
      window.setJMenuBar(menuBar);
   	
      JMenu mnNewMenu = new JMenu("Help");
      menuBar.add(mnNewMenu);		
      
      window.setVisible(true);
   	
      JMenuItem mntmNewMenuItem = new JMenuItem("Instructions");
      mntmNewMenuItem.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               instruction();
               try {
                  instructions.setVisible(true);
               } catch (Exception e1) {
                  e1.printStackTrace();
               }
            }
         });
      mnNewMenu.add(mntmNewMenuItem);		
   }
   
   public void instruction() {
      instructions = new JFrame();
      instructions.setType(Type.UTILITY);
      instructions.setTitle("Instructions");
      instructions.setAlwaysOnTop(true);
      instructions.setBounds(100, 100, 392, 330);
      instructions.getContentPane().setLayout(null);
   	
      JLabel lblNewLabel_7 = new JLabel("Instructions");
      lblNewLabel_7.setFont(new Font("Bodoni MT", Font.BOLD, 33));
      lblNewLabel_7.setBounds(105, 11, 191, 53);
      instructions.getContentPane().add(lblNewLabel_7);
   	
      JTextPane txtpnAV = new JTextPane();
      txtpnAV.setEditable(false);
      txtpnAV.setText(""+
         "1. Shenoni emrat e juaj ne hapsirat Player1, Player2\r\n\r\n2."+
         " Player1 leviz me ane te butonave W dhe S ndersa Player2 me ↑ dhe ↓\r\n\r\n3. Qellimi i lojes eshte te goditni topin derisa tjetri te mos mund ta kthej \r\n\r\n4."+
         " Loja do te zhvillohet deri sa njeri te arrij 11 pike me c'rast do te shpallet fitues\r\n\r\n5. Loje te mbare!!!");
      txtpnAV.setBounds(20, 60, 340, 200);
      instructions.getContentPane().add(txtpnAV);
   }
}
