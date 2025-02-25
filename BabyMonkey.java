
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;
import javax.swing.JPanel; 

public class BabyMonkey extends JPanel {

    private JPanel panel;
    private int x;
    private int y;
    private int X_move;

    Ellipse2D.Double head;
    Ellipse2D.Double inner_head;
    Ellipse2D.Double eye1;
    Ellipse2D.Double eye2;
    Ellipse2D.Double ear1;
    Ellipse2D.Double ear2;
    Ellipse2D.Double mouth;
    Ellipse2D.Double body;
    Ellipse2D.Double left_arm;
    Ellipse2D.Double right_arm;
    Ellipse2D.Double left_leg;
    Ellipse2D.Double right_leg;

    private int dx;
    private int dy;
    private Dimension dimension;

    boolean isJumping;

    Random random;

    public BabyMonkey (JPanel p, int xPos, int yPos) {
        this.panel = p;
        this.dimension = panel.getSize();
        x = xPos;
        y = yPos;

        isJumping=false;

        dx = 0;
        dy = 0;
    }


    public void draw(){
        Graphics g = panel.getGraphics();
        Graphics2D g2 = (Graphics2D) g;
    

        head = new Ellipse2D.Double(x, y, 30, 45);
        inner_head = new Ellipse2D.Double(x+5, y+5, 20, 35);
        eye1 = new Ellipse2D.Double(x+8, y+15, 5, 5);
        eye2 = new Ellipse2D.Double(x+17, y+15, 5, 5);
        ear1 = new Ellipse2D.Double(x-5, y+5, 10, 10); //left ear
        ear2 = new Ellipse2D.Double(x+25, y+5, 10, 10); //right ear
        mouth = new Ellipse2D.Double(x+10, y+25, 10, 5);
        body = new Ellipse2D.Double(x+5, y+40, 20, 30);
        left_leg = new Ellipse2D.Double(x+5, y+65, 5, 20);
        right_leg = new Ellipse2D.Double(x+20, y+65, 5, 20);

        g2.setColor(new Color (208, 127, 47));
        g2.fill(ear1);
        g2.fill(ear2);
        g2.setColor(Color.BLACK);
        g2.draw(ear1);
        g2.draw(ear2);
        g2.setColor(new Color (208, 127, 47));
        g2.fill(body);
        g2.setColor(Color.BLACK);
        g2.draw(body);
        g2.setColor(new Color (208, 127, 47));
        g2.fill(head);
        g2.setColor(Color.BLACK);
        g2.draw(head);

        g2.setColor(new Color (208, 127, 47));
        g2.fill(left_leg);
        g2.fill(right_leg);
        g2.setColor(Color.BLACK);
        g2.draw(left_leg);
        g2.draw(right_leg);

        g2.setColor(new Color (229, 186, 142));
        g2.fill(inner_head);
        
        g2.setColor(Color.BLACK);
        g2.fill(eye1);
        g2.fill(eye2);
        
        g2.setColor(Color.RED);
        g2.fill(mouth);

        g2.setColor(new Color (208, 127, 47));

        // Draw arms with rotation
        double pivotX = x -2;  // Shoulder X coordinate
        double pivotY = y + 45; // Shoulder Y coordinate

        // Left arm rotation
        AffineTransform oldTransform = g2.getTransform();
        g2.rotate(Math.toRadians(30), pivotX+5, pivotY); 
        left_arm = new Ellipse2D.Double(pivotX +3, pivotY, 5, 20); 
        g2.fill(left_arm); 
        g2.setColor(Color.BLACK);
        g2.draw(left_arm);
        g2.setTransform(oldTransform); 

        g2.setColor(new Color (208, 127, 47));
        // Right arm rotation
        g2.rotate(Math.toRadians(-30), pivotX + 20, pivotY);
        right_arm = new Ellipse2D.Double(pivotX + 25, pivotY, 5, 20);
        g2.fill(right_arm); 
        g2.setColor(Color.BLACK);
        g2.draw(right_arm);
        g2.setTransform(oldTransform); 

        g.dispose();

    }

    public void erase(){
        Graphics g = panel.getGraphics();
        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D bed = new Rectangle2D.Double(470, 380, 50, 30);
        g2.setColor(new Color(86, 212, 232));
        g2.fill(bed);
        Rectangle2D wall = new Rectangle2D.Double(470, 280, 50, 100);
        g2.setColor(new Color(230, 162, 26));
        g2.fill(wall);
        Line2D bedLine = new Line2D.Double(470,380,520,380);
        g2.setColor(Color.BLACK);
        g2.draw(bedLine);
  
    }

    public void drawJumpingUp(int dy){
        this.dy = dy;
        this.y= y - dy;

        Graphics g = panel.getGraphics();
        Graphics2D g2 = (Graphics2D) g;
    

        head = new Ellipse2D.Double(x, y, 30, 45);
        inner_head = new Ellipse2D.Double(x+5, y+5, 20, 35);
        eye1 = new Ellipse2D.Double(x+8, y+15, 5, 5);
        eye2 = new Ellipse2D.Double(x+17, y+15, 5, 5);
        ear1 = new Ellipse2D.Double(x-5, y+5, 10, 10); //left ear
        ear2 = new Ellipse2D.Double(x+25, y+5, 10, 10); //right ear
        mouth = new Ellipse2D.Double(x+10, y+25, 10, 5);
        body = new Ellipse2D.Double(x+5, y+40, 20, 30);
        left_leg = new Ellipse2D.Double(x+5, y+65, 5, 20);
        right_leg = new Ellipse2D.Double(x+20, y+65, 5, 20);

        g2.setColor(new Color (208, 127, 47));
        g2.fill(ear1);
        g2.fill(ear2);
        g2.setColor(Color.BLACK);
        g2.draw(ear1);
        g2.draw(ear2);
        g2.setColor(new Color (208, 127, 47));
        g2.fill(body);
        g2.setColor(Color.BLACK);
        g2.draw(body);
        g2.setColor(new Color (208, 127, 47));
        g2.fill(head);
        g2.setColor(Color.BLACK);
        g2.draw(head);

        g2.setColor(new Color (208, 127, 47));
        g2.fill(left_leg);
        g2.fill(right_leg);
        g2.setColor(Color.BLACK);
        g2.draw(left_leg);
        g2.draw(right_leg);

        g2.setColor(new Color (229, 186, 142));
        g2.fill(inner_head);
        
        g2.setColor(Color.BLACK);
        g2.fill(eye1);
        g2.fill(eye2);
        
        g2.setColor(Color.RED);
        g2.fill(mouth);

        g2.setColor(new Color (208, 127, 47));

        // Draw arms with rotation
        double pivotX = x -2;  // Shoulder X coordinate
        double pivotY = y + 45; // Shoulder Y coordinate

        // Left arm rotation
        AffineTransform oldTransform = g2.getTransform(); 
        g2.rotate(Math.toRadians(30), pivotX+5, pivotY);
        left_arm = new Ellipse2D.Double(pivotX +3, pivotY, 5, 20); 
        g2.fill(left_arm); 
        g2.setColor(Color.BLACK);
        g2.draw(left_arm);
        g2.setTransform(oldTransform); 

        g2.setColor(new Color (208, 127, 47));
        // Right arm rotation
        g2.rotate(Math.toRadians(-30), pivotX + 20, pivotY); 
        right_arm = new Ellipse2D.Double(pivotX + 25, pivotY, 5, 20);
        g2.fill(right_arm); 
        g2.setColor(Color.BLACK);
        g2.draw(right_arm);
        g2.setTransform(oldTransform);

        g.dispose();

    }

    public void drawJumpingDown(int dy){
        this.dy = dy;
        this.y= y + dy;

        Graphics g = panel.getGraphics();
        Graphics2D g2 = (Graphics2D) g;
    

        head = new Ellipse2D.Double(x, y, 30, 45);
        inner_head = new Ellipse2D.Double(x+5, y+5, 20, 35);
        eye1 = new Ellipse2D.Double(x+8, y+15, 5, 5);
        eye2 = new Ellipse2D.Double(x+17, y+15, 5, 5);
        ear1 = new Ellipse2D.Double(x-5, y+5, 10, 10); //left ear
        ear2 = new Ellipse2D.Double(x+25, y+5, 10, 10); //right ear
        mouth = new Ellipse2D.Double(x+10, y+25, 10, 5);
        body = new Ellipse2D.Double(x+5, y+40, 20, 30);
        left_leg = new Ellipse2D.Double(x+5, y+65, 5, 20);
        right_leg = new Ellipse2D.Double(x+20, y+65, 5, 20);

        g2.setColor(new Color (208, 127, 47));
        g2.fill(ear1);
        g2.fill(ear2);
        g2.setColor(Color.BLACK);
        g2.draw(ear1);
        g2.draw(ear2);
        g2.setColor(new Color (208, 127, 47));
        g2.fill(body);
        g2.setColor(Color.BLACK);
        g2.draw(body);
        g2.setColor(new Color (208, 127, 47));
        g2.fill(head);
        g2.setColor(Color.BLACK);
        g2.draw(head);

        g2.setColor(new Color (208, 127, 47));
        g2.fill(left_leg);
        g2.fill(right_leg);
        g2.setColor(Color.BLACK);
        g2.draw(left_leg);
        g2.draw(right_leg);

        g2.setColor(new Color (229, 186, 142));
        g2.fill(inner_head);
        
        g2.setColor(Color.BLACK);
        g2.fill(eye1);
        g2.fill(eye2);
        
        g2.setColor(Color.RED);
        g2.fill(mouth);

        g2.setColor(new Color (208, 127, 47));

        // Draw arms with rotation
        double pivotX = x -2;  // Shoulder X coordinate
        double pivotY = y + 45; // Shoulder Y coordinate

        // Left arm rotation
        AffineTransform oldTransform = g2.getTransform(); 
        g2.rotate(Math.toRadians(30), pivotX+5, pivotY); 
        left_arm = new Ellipse2D.Double(pivotX +3, pivotY, 5, 20); 
        g2.fill(left_arm); 
        g2.setColor(Color.BLACK);
        g2.draw(left_arm);
        g2.setTransform(oldTransform); 

        g2.setColor(new Color (208, 127, 47));
        // Right arm rotation
        g2.rotate(Math.toRadians(-30), pivotX + 20, pivotY); 
        right_arm = new Ellipse2D.Double(pivotX + 25, pivotY, 5, 20);
        g2.fill(right_arm); 
        g2.setColor(Color.BLACK);
        g2.draw(right_arm);
        g2.setTransform(oldTransform); 

        g.dispose();
    }

    public int getY(){
        return this.y;
    }

    
}
