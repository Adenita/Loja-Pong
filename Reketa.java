import java.awt.event.KeyEvent;
import java.awt.*;

public class Reketa 
{
   int x_position, y_position, y_direction;
   int reketa;
   int Lojtari1;
   int Lojtari2;
   Color color;
   
   public Reketa(int x_position, int y_position, int reketa, Color color)
   {
      this.x_position = x_position;
      this.y_position = y_position;
      this.reketa = reketa;
      this.color = color;
   }

   public void keyPressed(KeyEvent e)
   {
      switch(reketa)
      {
         case 0:
            if(e.getKeyCode() == KeyEvent.VK_W) {
               setYDirection(-8);      
            }  
            
            if (e.getKeyCode() == KeyEvent.VK_S) {
               setYDirection(+8);
            }
            break;
            
         case 1:
            if(e.getKeyCode() == KeyEvent.VK_UP) {
               setYDirection(-8);      
            }
            
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            setYDirection(+8);
            }
            break;
      }
      
   }

   public void keyReleased(KeyEvent e)
   {
      switch(reketa)
      {
         case 0:
            if (e.getKeyCode() == KeyEvent.VK_W) {  
               setYDirection(0);  
            }  
            if (e.getKeyCode() == KeyEvent.VK_S) {  
               setYDirection(0);  
            } 
            break;
   
         case 1:
            if (e.getKeyCode() == KeyEvent.VK_UP) {  
               setYDirection(0);  
            }  
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {  
               setYDirection(0);  
            }  
            break;
      }
   }

   public void setYDirection(int ydir) {  
      y_direction = ydir;
   }
   
   public void move()  
   { 
      if(y_position <= 8) {
         y_position = 8;
      } else if (y_position >= 422) {
         y_position = 422;
      }
      
      y_position += y_direction;    
   }

   public void draw(Graphics g)
   {
      g.setColor(color);
      g.fillRect(x_position, y_position, 20, 70);  
   }

   public int getX(){
      return x_position;
   }

   public int getY(){
      return y_position;              
   }

}
