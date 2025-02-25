import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

public class Room extends JPanel {  
    
    private int panelWidth;
    private int panelHeight;


    Rectangle2D.Double door;
    Ellipse2D.Double doorHandle;
    Line2D.Double floor;
    Polygon bed;
    Rectangle2D.Double bed1;
    Graphics g;

    public Room(JPanel p) {
       
        g = p.getGraphics();
        panelWidth = p.getWidth();
        panelHeight = p.getHeight();
 
    }


    public void draw() {
    
        Graphics2D g2 = (Graphics2D) g;

        // background color
        g2.setColor(new Color(178, 191, 138)); // Green
        g2.fillRect(0, 0, panelWidth, panelHeight); 
        g2.setColor(new Color(230, 162, 26)); //Orange
        g2.fillRect(0, 0, panelWidth, panelHeight-200); 


        int doorWidth = panelWidth / 5;  
        int doorHeight = panelHeight / 4;
        int doorX = (panelWidth - doorWidth) / 2-230;
        int doorY = panelHeight - doorHeight - 200; 

        door = new Rectangle2D.Double(doorX, doorY, doorWidth, doorHeight);
        g2.setColor(new Color(150, 100, 50)); // Brown
        g2.fill(door);

          // **Draw door outline**
          g2.setColor(Color.BLACK);
          g2.draw(door);

        // Draw door handle
        int handleSize = doorWidth / 10;
        doorHandle = new Ellipse2D.Double(doorX + handleSize * 2, doorY + doorHeight / 2, handleSize, handleSize);
        g2.setColor(Color.BLACK);
        g2.fill(doorHandle);

        // Draw floor
        floor = new Line2D.Double(0, panelHeight - 200, panelWidth, panelHeight - 200);
        g2.setColor(Color.BLACK);
        g2.draw(floor);
        
        // Draw bed
        bed = new Polygon();
        bed.addPoint(380, 380);
        bed.addPoint(300, 450);
        bed.addPoint(600, 450);
        bed.addPoint(600, 380);
        g2.setColor(new Color(86, 212, 232)); // Blue
        g2.fill(bed);
        g2.setColor(Color.BLACK);
        g2.draw(bed);

        bed1 = new Rectangle2D.Double(300, 450, 300, 50);
        g2.setColor(new Color(86, 212, 232)); // Blue
        g2.fill(bed1);
        g2.setColor(Color.BLACK);
        g2.draw(bed1);

        g.dispose();

    }


    }





