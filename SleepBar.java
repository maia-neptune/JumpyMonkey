import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;


public class SleepBar {
    private int x;
    private int y;

    JPanel p;

    private int width;
    private int height;
    
    private int sleepLevel;

    public SleepBar(JPanel panel, int x, int y){
        this.p = panel;
        this.x = x;
        this.y = y;
        sleepLevel = 0;

        this.width = 150;
        this.height = 30;
    }


    public void draw(){
        Graphics g =p.getGraphics();
        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D.Double sleepBar = new Rectangle2D.Double(x, y, width, height);
        g2.setColor(new Color(152, 103, 3));
        g2.fill(sleepBar);
        g2.setColor(Color.BLACK);
        g2.draw(sleepBar);

        g2.dispose();
    }
    public void add_points(){

        if(this.sleepLevel<150){
        this.sleepLevel = sleepLevel + 6;
        Rectangle2D barLevel = new Rectangle2D.Double(this.x, this.y, sleepLevel,30);
        
        Graphics g = p.getGraphics();
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(new Color(50,31,125));
        g2.fill(barLevel);

        g.dispose();
        }
    }

    public int getLevel(){
        return this.sleepLevel;
    }

    public void printWin(){
        Graphics g = p.getGraphics();
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.GREEN);
        g2.setFont(new Font("Arial", Font.BOLD, 50));
        g2.drawString("WIN!", p.getWidth() / 2 - 50, p.getHeight() / 2);
        g2.setColor(Color.BLACK);
        g2.setFont(new Font("Arial", Font.BOLD, 20));
        g2.drawString("Score: " + sleepLevel, p.getWidth() / 2 - 45, p.getHeight() / 2 + 20);
    }   
    
    public void printLoss(){
        Graphics g = p.getGraphics();
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.RED);
        g2.setFont(new Font("Arial", Font.BOLD, 50));
        g2.drawString("LOSE!", p.getWidth() / 2 - 48, p.getHeight() / 2);
        g2.setColor(Color.BLACK);
        g2.setFont(new Font("Arial", Font.BOLD, 20));
        g2.drawString("Score: " + sleepLevel, p.getWidth() / 2 - 46, p.getHeight() / 2+ 20);
        
    }

}
