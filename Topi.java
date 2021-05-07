import java.awt.*;
import java.util.Random;

public class Topi 
{
    int pozitaX;
    int pozitaY;
    int levizX;
    int levizY;
    Random random;
    Color color;

    public Topi(int pozitaX, int pozitaY, Color color)
    {
        this.pozitaX = pozitaX;
        this.pozitaY = pozitaY;
        levizX = 2;
        levizY = 1;
        this.color = color;
        random = new Random();

        // percakton kahjen e levizjes se topi ne fillim te lojes
        int randomx = random.nextInt(2);
        if(randomx == 0) 
            randomx--;
        setDrejtimiX(randomx * 4);

        int randomy = random.nextInt(2);
        if(randomy == 0) 
            randomy--;
        setDrejtimiX(randomy * 4);

    }

    public void draw(Graphics g)
    {
        g.setColor(color);
        g.fillOval(pozitaX, pozitaY, 20, 20);
    }

    public void move()
    {
        // Nese topi godet muret horizantle kthehet ne anen e kundert 
        if(pozitaY <= 1) {
            setDrejtimiY(-levizY);
        } else if(pozitaY >= 475) {
            setDrejtimiY(-levizY);
        }
        pozitaX += levizX;
        pozitaY += levizY;
    }

    // vendos kahjen dhe shpejtesine e levizjes e topit ne boshtin x  me nje vlere te rastesishme
    public void setDrejtimiX(int randomXDrejtimi)
    {
        levizX = randomXDrejtimi;
    }

    // vendos kahjen dhe shpejtesine e levizjes e topit ne boshtin y me nje vlere te rastesishme
    public void setDrejtimiY(int randomYDrejtimi)
    {
        levizY = randomYDrejtimi;
    }

    public int getX()
    {
        return pozitaX;
    }

    public int getY()
    {
        return pozitaY;
    }
}
