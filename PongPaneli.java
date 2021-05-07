import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PongPaneli extends JPanel implements Runnable
{
    public static final int gjersia = 850;
    public static final int gjatesia = 500;

    Topi topi;
    Reketa reketa1;
    Reketa reketa2;
    Piket piket;
    Thread gameThread;
    Graphics graphics;
    Image image;

    public PongPaneli ()
    {
        getReketa();
        getTopi();
        piket = new Piket(gjersia, gjatesia);

        this.setPreferredSize(new Dimension(gjersia, gjatesia));
        this.setFocusable(true);
        this.addKeyListener(new KP()); 
     
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void getReketa()
    {
        reketa1 = new Reketa(20, gjatesia/2 - 35, 0, Color.RED);
        reketa2 = new Reketa(gjersia - 40, gjatesia/2 - 35, 1, Color.BLACK);
    }

    public void getTopi() {
        topi = new Topi(450, 250, Color.WHITE);
    }

    public void paint(Graphics g) 
    {
		image = createImage(getWidth(), getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image, 0, 0, this); 
	}

    public void draw(Graphics g) 
    {
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.white);
        g2.setStroke(new BasicStroke(10));

        g2.draw(new Line2D.Double(0, 0, gjersia, 0));
        g2.draw(new Line2D.Double(0, 0, 0, gjatesia));
        g2.draw(new Line2D.Double(0, gjatesia, gjersia, gjatesia));
        g2.draw(new Line2D.Double(gjersia, 0, gjersia, gjatesia));
        g2.draw(new Line2D.Double(gjersia/2, 0, gjersia/2, gjatesia));

		reketa1.draw(g);
        reketa2.draw(g);
        topi.draw(g);
        piket.draw(g);

        Toolkit.getDefaultToolkit().sync(); // ndihmon me animacion
 	}

    public void move()
    {
        reketa1.move();
        reketa2.move();
        topi.move();
    }

    public void checkCollision() 
    {
        //Ktehen mrapa topin nese topi godet reketen1
        if (topi.getY() >= reketa1.y_position && topi.getY() <= reketa1.y_position + 70) {
            if (topi.getX() >= 38 && topi.getX() <= 42){
                topi.setDrejtimiX(-topi.levizX);
            }
        }
        //Ktehen mrapa topin nese topi godet reketen2
        if (topi.getY() >= reketa2.y_position && topi.getY() <= reketa2.y_position + 70) {
            if (topi.getX() >= 792 && topi.getX() <= 798) {
                topi.setDrejtimiX(-topi.levizX);
            }
        } 

        // Shton pike lojetarit nese lojetari tjeter nuk godet topin
        if (topi.pozitaX < 2) {
            piket.lojtari2++;
            getTopi();
            
        } else if (topi.pozitaX > 848) {
            piket.lojtari1++;
            getTopi();
        }
    }
    
  
    @Override
    public void run() 
    {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;

        while(!piket.checkWinner()) 
        {
            long now = System.nanoTime();
            delta += (now -lastTime)/ns;
            lastTime = now;
            if(delta >=1)
            {
                move();
                checkCollision();
                repaint();
                delta--;
                
            }

        }  

        if (piket.checkWinner()) {
            PongFrame.playAgainButton.setVisible(true);
        }

    }

    public class KP extends KeyAdapter
    {
        public void keyPressed(KeyEvent e)
        {
            reketa1.keyPressed(e);
            reketa2.keyPressed(e);
        }

        public void keyReleased(KeyEvent e) 
        {
            reketa1.keyReleased(e);
            reketa2.keyReleased(e);
        }
    }

}