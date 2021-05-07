import java.awt.*;

public class Piket 
{
    int gjersia;
    int gjatesia;
    Topi topi;
    int lojtari1 = 0;
    int lojtari2 = 0;
    int piketFituese = 11;
    String emri1 = Main.player1;
    String emri2 = Main.player2;
    boolean winner = false;

    public Piket(int gjersia, int gjatesia) {
        this.gjersia = gjersia;
        this.gjatesia = gjatesia;
    }

    public void draw(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        g.setColor(new Color(215,178,44));
        g.setFont(new Font("Times New Roman", Font.BOLD, 60));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //Paraqet piket e lojetareve ne panelin e lojes
        g2.drawString(String.valueOf(lojtari1/10) + String.valueOf(lojtari1%10), gjersia/2 - 80, 50);
        g2.drawString(String.valueOf(lojtari2/10) + String.valueOf(lojtari2%10), gjersia/2 + 20, 50);

        g2.setColor(Color.white);
        g2.setFont(new Font("Georgia", Font.PLAIN, 30));
        g2.drawString(emri1, 10, 490);
        g2.drawString(emri2, 780 - emri2.length() * 6, 490);
        
        g.setColor(new Color(247,216,0));
        g.setFont(new Font("Lucida Calligraphy", Font.BOLD, 60));

        //Paraqet emrin e fitues ne panel nese arrihet kushti
        if (getLojtari1() == piketFituese) {
            g.drawString("Winner: " + emri1, 190 - emri1.length() * 5, 250);
        }else if (getLojtari2() == piketFituese) {
            g.drawString("Winner: " + emri2, 190 - emri2.length() * 5, 250);
        }    
    }
    
    public int getLojtari1() {
        return lojtari1;
    }

    public int getLojtari2() {
        return lojtari2;
    }

    // kontrollon nese ka fitues
    public boolean checkWinner() {
        boolean winner = false;
        if (lojtari1 == piketFituese || lojtari2 == piketFituese) {
            winner = true;
        }
        return winner;
    }

}
