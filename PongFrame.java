
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PongFrame extends JFrame
{
    PongPaneli pongPanel;
    static JButton playAgainButton;

    public PongFrame()
    {
        pongPanel = new PongPaneli();

        this.setTitle("Loja Pong");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(new Color(42,63,109));
        this.getContentPane().add(pongPanel);

        playAgainButton = new JButton("PlayAgain");
        playAgainButton.setBounds(290, 200, 100, 80);
        playAgainButton.setBorderPainted(false);
        this.getContentPane().add(playAgainButton, BorderLayout.PAGE_END);
        playAgainButton.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PongFrame.this.dispose();
                new PongFrame();
            }
         });

        playAgainButton.setVisible(false);

            this.pack(); 
            this.setVisible(true);
            this.setLocationRelativeTo(null);
            this.setResizable(false);

    }
}

