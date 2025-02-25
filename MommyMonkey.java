
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;
import javax.swing.JPanel; 

public class MommyMonkey extends Thread {

    private JPanel panel;
    private int x;
    private int y;
  

    Ellipse2D.Double head;
    Ellipse2D.Double inner_head;
    Ellipse2D.Double eye1;
    Ellipse2D.Double eye2;
    Arc2D.Double eyelash1;
    Arc2D.Double eyelash2;
    Ellipse2D.Double ear1;
    Ellipse2D.Double ear2;
    Ellipse2D.Double mouth;
    Line2D.Double mouth_line;
    Polygon body;
    Ellipse2D.Double left_arm;
    Ellipse2D.Double right_arm;
    Ellipse2D.Double left_leg;
    Ellipse2D.Double right_leg;

    private int dx;
    private int dy;
    private Dimension dimension;

    private volatile boolean isRunning;
    private boolean caught;
    private boolean inRoom;
    private boolean gamePaused;

    Random random;

    public MommyMonkey (JPanel p, int xPos, int yPos) {
        this.panel = p;
        this.dimension = panel.getSize();
        x = xPos;
        y = yPos;

        random = new Random();
        isRunning = true;
        caught = false;
        inRoom = false;
        gamePaused = false;

        dx = 0;
        dy = 0;
    }


    public void draw(){
        Graphics g = panel.getGraphics();
        Graphics2D g2 = (Graphics2D) g;
    

        head = new Ellipse2D.Double(x, y, 50, 50);
        inner_head = new Ellipse2D.Double(x+5, y+5, 40, 40);
        eye1 = new Ellipse2D.Double(x+9, y+15, 10, 10);
        eyelash1 = new Arc2D.Double(x+5, y+12, 10, 10, 0, -180, Arc2D.OPEN);
        eye2 = new Ellipse2D.Double(x+30, y+15, 10, 10);
        eyelash2 = new Arc2D.Double(x+34, y+12, 10, 10, 0, -180, Arc2D.OPEN);
        ear1 = new Ellipse2D.Double(x-15, y+5, 20, 20); //left ear
        ear2 = new Ellipse2D.Double(x+45, y+5, 20, 20); //right ear
        mouth = new Ellipse2D.Double(x+17, y+28, 15, 8);
        mouth_line = new Line2D.Double(x+17, y+32, x+32, y+32);
        
        //dress
        int[] xPoints = {x + 5, x + 45, x + 55, x-5}; // Top-left, Top-right, Bottom-right, Bottom-left
        int[] yPoints = {y + 45, y + 45, y + 90, y + 90}; // Same height for top, lower for bottom
               body = new Polygon(xPoints, yPoints, 4);
        left_leg = new Ellipse2D.Double(x+5, y+80, 10, 30);
        right_leg = new Ellipse2D.Double(x+35, y+80, 10, 30);

        g2.setColor(new Color (208, 127, 47));
        g2.fill(ear1);
        g2.fill(ear2);
        g2.setColor(Color.BLACK);
        g2.draw(ear1);
        g2.draw(ear2);
        g2.setColor(new Color (208, 127, 47));
        g2.fill(head);
        g2.setColor(Color.BLACK);
        g2.draw(head);
      

        g2.setColor(new Color (208, 127, 47));
        g2.fill(left_leg);
        g2.setColor(Color.BLACK);
        g2.draw(left_leg);
        g2.setColor(new Color (208, 127, 47));
        g2.fill(right_leg);
        g2.setColor(Color.BLACK);
        g2.draw(right_leg);

        g2.setColor(Color.PINK);
        g2.fill(body);
        g2.setColor(Color.BLACK);
        g2.draw(body);

        g2.setColor(new Color (229, 186, 142));
        g2.fill(inner_head);
        
        g2.setColor(Color.BLACK);
        g2.fill(eye1);
        g2.draw(eyelash1);
        g2.fill(eye2);
        g2.draw(eyelash2);
        g2.setColor(new Color (208, 127, 47));
        g2.setColor(Color.RED);
        g2.fill(mouth);
        g2.setColor(Color.BLACK);
        g2.draw(mouth);
        g2.draw(mouth_line);

        g2.setColor(new Color (208, 127, 47));

        // Draw arms with rotation
        double pivotX = x + 5;  // Shoulder X coordinate
        double pivotY = y + 45; // Shoulder Y coordinate

        // Left arm rotation
        AffineTransform oldTransform = g2.getTransform(); // Save original transform
        g2.rotate(Math.toRadians(30), pivotX, pivotY); // Rotate around shoulder
        left_arm = new Ellipse2D.Double(pivotX - 10, pivotY, 10, 30); 
        g2.fill(left_arm); 
        g2.setColor(Color.BLACK);
        g2.draw(left_arm);
        g2.setTransform(oldTransform); // Restore original transform

        g2.setColor(new Color (208, 127, 47));
        // Right arm rotation
        g2.rotate(Math.toRadians(-30), pivotX + 20, pivotY); // Rotate around right shoulder
        right_arm = new Ellipse2D.Double(pivotX + 35, pivotY+10, 10, 30);
        g2.fill(right_arm); 
        g2.setColor(Color.BLACK);
        g2.draw(right_arm);
        g2.setTransform(oldTransform); // Restore original transform

        g.dispose();

    }

    public void drawComing(int dx, int dy){
        this.dx = dx;
        this.dy = dy;
        
        this.x = x+dx;
        this.y= y+dy;
        
        Graphics g = panel.getGraphics();
        Graphics2D g2 = (Graphics2D) g;
    

        head = new Ellipse2D.Double(x, y, 50, 50);
        inner_head = new Ellipse2D.Double(x+5, y+5, 40, 40);
        eye1 = new Ellipse2D.Double(x+9, y+15, 10, 10);
        eyelash1 = new Arc2D.Double(x+5, y+12, 10, 10, 0, -180, Arc2D.OPEN);
        eye2 = new Ellipse2D.Double(x+30, y+15, 10, 10);
        eyelash2 = new Arc2D.Double(x+34, y+12, 10, 10, 0, -180, Arc2D.OPEN);
        ear1 = new Ellipse2D.Double(x-15, y+5, 20, 20); //left ear
        ear2 = new Ellipse2D.Double(x+45, y+5, 20, 20); //right ear
        mouth = new Ellipse2D.Double(x+17, y+28, 15, 8);
        mouth_line = new Line2D.Double(x+17, y+32, x+32, y+32);
        
        //dress
        int[] xPoints = {x + 5, x + 45, x + 55, x-5}; // Top-left, Top-right, Bottom-right, Bottom-left
        int[] yPoints = {y + 45, y + 45, y + 90, y + 90}; // Same height for top, lower for bottom
               body = new Polygon(xPoints, yPoints, 4);
        left_leg = new Ellipse2D.Double(x+5, y+80, 10, 30);
        right_leg = new Ellipse2D.Double(x+35, y+80, 10, 30);

        g2.setColor(new Color (208, 127, 47));
        g2.fill(ear1);
        g2.fill(ear2);
        g2.setColor(Color.BLACK);
        g2.draw(ear1);
        g2.draw(ear2);
        g2.setColor(new Color (208, 127, 47));
        g2.fill(head);
        g2.setColor(Color.BLACK);
        g2.draw(head);
      

        g2.setColor(new Color (208, 127, 47));
        g2.fill(left_leg);
        g2.setColor(Color.BLACK);
        g2.draw(left_leg);
        g2.setColor(new Color (208, 127, 47));
        g2.fill(right_leg);
        g2.setColor(Color.BLACK);
        g2.draw(right_leg);

        g2.setColor(Color.PINK);
        g2.fill(body);
        g2.setColor(Color.BLACK);
        g2.draw(body);

        g2.setColor(new Color (229, 186, 142));
        g2.fill(inner_head);
        
        g2.setColor(Color.BLACK);
        g2.fill(eye1);
        g2.draw(eyelash1);
        g2.fill(eye2);
        g2.draw(eyelash2);
        g2.setColor(new Color (208, 127, 47));
        g2.setColor(Color.RED);
        g2.fill(mouth);
        g2.setColor(Color.BLACK);
        g2.draw(mouth);
        g2.draw(mouth_line);

        g2.setColor(new Color (208, 127, 47));

        // Draw arms with rotation
        double pivotX = x + 5;  // Shoulder X coordinate
        double pivotY = y + 45; // Shoulder Y coordinate

        // Left arm rotation
        AffineTransform oldTransform = g2.getTransform(); 
        g2.rotate(Math.toRadians(30), pivotX, pivotY); 
        left_arm = new Ellipse2D.Double(pivotX - 10, pivotY, 10, 30); 
        g2.fill(left_arm); 
        g2.setColor(Color.BLACK);
        g2.draw(left_arm);
        g2.setTransform(oldTransform);

        g2.setColor(new Color (208, 127, 47));
        // Right arm rotation
        g2.rotate(Math.toRadians(-30), pivotX + 20, pivotY);
        right_arm = new Ellipse2D.Double(pivotX + 35, pivotY+10, 10, 30);
        g2.fill(right_arm); 
        g2.setColor(Color.BLACK);
        g2.draw(right_arm);
        g2.setTransform(oldTransform); 

        g.dispose();
    }

    public void drawLeaving(int dx, int dy){
        this.dx = dx;
        this.dy = dy;

        this.x = x- dx;
        this.y = y - dy;


        Graphics g = panel.getGraphics();
        Graphics2D g2 = (Graphics2D) g;
    

        head = new Ellipse2D.Double(x, y, 50, 50);
        inner_head = new Ellipse2D.Double(x+5, y+5, 40, 40);
        eye1 = new Ellipse2D.Double(x+9, y+15, 10, 10);
        eyelash1 = new Arc2D.Double(x+5, y+12, 10, 10, 0, -180, Arc2D.OPEN);
        eye2 = new Ellipse2D.Double(x+30, y+15, 10, 10);
        eyelash2 = new Arc2D.Double(x+34, y+12, 10, 10, 0, -180, Arc2D.OPEN);
        ear1 = new Ellipse2D.Double(x-15, y+5, 20, 20); //left ear
        ear2 = new Ellipse2D.Double(x+45, y+5, 20, 20); //right ear
        mouth = new Ellipse2D.Double(x+17, y+28, 15, 8);
        mouth_line = new Line2D.Double(x+17, y+32, x+32, y+32);
        
        //dress
        int[] xPoints = {x + 5, x + 45, x + 55, x-5}; // Top-left, Top-right, Bottom-right, Bottom-left
        int[] yPoints = {y + 45, y + 45, y + 90, y + 90}; // Same height for top, lower for bottom
               body = new Polygon(xPoints, yPoints, 4);
        left_leg = new Ellipse2D.Double(x+5, y+80, 10, 30);
        right_leg = new Ellipse2D.Double(x+35, y+80, 10, 30);

        g2.setColor(new Color (208, 127, 47));
        g2.fill(ear1);
        g2.fill(ear2);
        g2.setColor(Color.BLACK);
        g2.draw(ear1);
        g2.draw(ear2);
        g2.setColor(new Color (208, 127, 47));
        g2.fill(head);
        g2.setColor(Color.BLACK);
        g2.draw(head);
      

        g2.setColor(new Color (208, 127, 47));
        g2.fill(left_leg);
        g2.setColor(Color.BLACK);
        g2.draw(left_leg);
        g2.setColor(new Color (208, 127, 47));
        g2.fill(right_leg);
        g2.setColor(Color.BLACK);
        g2.draw(right_leg);

        g2.setColor(Color.PINK);
        g2.fill(body);
        g2.setColor(Color.BLACK);
        g2.draw(body);


        g2.setColor(new Color (208, 127, 47));

        // Draw arms with rotation
        double pivotX = x + 5;  // Shoulder X coordinate
        double pivotY = y + 45; // Shoulder Y coordinate

        // Left arm rotation
        AffineTransform oldTransform = g2.getTransform();
        g2.rotate(Math.toRadians(30), pivotX, pivotY); 
        left_arm = new Ellipse2D.Double(pivotX - 10, pivotY, 10, 30); 
        g2.fill(left_arm); 
        g2.setColor(Color.BLACK);
        g2.draw(left_arm);
        g2.setTransform(oldTransform); 

        g2.setColor(new Color (208, 127, 47));
        // Right arm rotation
        g2.rotate(Math.toRadians(-30), pivotX + 20, pivotY); 
        right_arm = new Ellipse2D.Double(pivotX + 35, pivotY+10, 10, 30);
        g2.fill(right_arm); 
        g2.setColor(Color.BLACK);
        g2.draw(right_arm);
        g2.setTransform(oldTransform); 

        g.dispose();


    }


    public void erase(){
        Graphics g = panel.getGraphics();
        Graphics2D g2 = (Graphics2D) g;
        int panelWidth = 600;
        int panelHeight= 600;

        int doorWidth = panelWidth / 5;  
        int doorHeight = panelHeight / 4;
        int doorX = (panelWidth - doorWidth) / 2-230;
        int doorY = panelHeight - doorHeight - 200; 

        Rectangle2D   door = new Rectangle2D.Double(doorX, doorY, doorWidth, doorHeight);
        g2.setColor(Color.BLACK);
        g2.fill(door);

        Rectangle2D floor = new Rectangle2D.Double(10, 400, 250, 250);
        g2.setColor(new Color(178, 191, 138));
        g2.fill(floor);

        Line2D floorLine = new Line2D.Double(0,400,300,400);
        g2.setColor(Color.BLACK);
        g2.draw(floorLine);

        Polygon doorOpen = new Polygon();

        doorOpen.addPoint(130,250); //top left
        doorOpen.addPoint(130, 400); //bottom left
        
        doorOpen.addPoint(190, 430); //bottom right
        doorOpen.addPoint(190, 280); //top right


        g2.setColor(new Color(150, 100, 50)); //Brown
        g2.fill(doorOpen);
        g2.setColor(Color.BLACK);
        g2.draw(doorOpen);

        int handleSize = doorWidth / 10;
        Ellipse2D doorHandle = new Ellipse2D.Double(130 + 40 , 280 + 150 / 2, handleSize/2+ 5, handleSize);
        g2.fill(doorHandle);

        g2.dispose();

    }

    @Override
    public void run(){

        while(isRunning){
        try {

            if(!caught){
                synchronized(this){
             Thread.sleep(getRandomTime());

             if(!gamePaused){
             mommyComing();
             Thread.sleep(400);
             inRoom = true;
             Thread.sleep(2000);
             }
            
             if(!caught)
             mommyLeaving();

            }
             
            }
            
        } catch (Exception e) {
            System.out.println("Exception: "+ e);
            return;
        }

    }
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void mommyComing(){
        int dx;
        int dy;

        dx = 5;
        dy= 10;

        if(this!=null){
            try{
                while(this.y<400 && this.x<105){
                    this.erase();
                    this.drawComing(dx, dy);
                    Thread.sleep(100);
                }
                inRoom=true;
            }
            catch(Exception e){
                System.out.println("Exception: " + e);
            }
        }

    }

    public void mommyLeaving(){
        int dx;
        int dy;

        dx = 5;
        dy= 10;

        if(this!=null){
            try{
                while(this.y>290 && this.x>50){
                    this.erase();
                    this.drawLeaving(dx, dy);
                    Thread.sleep(100);
                }
                eraseWhenLeaving();
                inRoom=false;
            }
            catch(InterruptedException e){
                System.out.println("Exception: " + e);
            }
        }
    }

    public void eraseWhenLeaving(){
        Graphics g = panel.getGraphics();
        Graphics2D g2 = (Graphics2D) g;
        int panelWidth = 600;
        int panelHeight= 600;

        int doorWidth = panelWidth / 5;  
        int doorHeight = panelHeight / 4;
        int doorX = (panelWidth - doorWidth) / 2-230; 
        int doorY = panelHeight - doorHeight - 200; 

        Rectangle2D   door = new Rectangle2D.Double(doorX, doorY, doorWidth, doorHeight);
        g2.setColor(new Color(150, 100, 50)); // Brown
        g2.fill(door);

        int handleSize = doorWidth / 10;
        Ellipse2D doorHandle = new Ellipse2D.Double(doorX + handleSize * 2, doorY + doorHeight / 2, handleSize, handleSize);
        g2.setColor(Color.BLACK);
        g2.fill(doorHandle);

        Rectangle2D floor = new Rectangle2D.Double(10, 400, 250, 250);
        g2.setColor(new Color(178, 191, 138));
        g2.fill(floor);

        Line2D floorLine = new Line2D.Double(0,400,300,400);
        g2.setColor(Color.BLACK);
        g2.draw(floorLine);

        Rectangle2D   wall = new Rectangle2D.Double(doorX+121, doorY-1, doorWidth, doorHeight);
        g2.setColor(new Color(230, 162, 26)); // Brown
        g2.fill(wall);

        g.dispose();

    }

    private int getRandomTime() {
        int min = 5000; // 5 seconds
        int max = 9000; // 9 seconds
        return random.nextInt(max - min + 1) + min; 
    }

    public void setCaught(boolean b){
        this.caught = b;
        isRunning=false;
    }

    public boolean getRoomStatus(){
        return this.inRoom;
    }

    public void setIsRunning(boolean b){
        this.isRunning = b;
    }
    public void setGamePaused(boolean b){
        this.gamePaused = b;
    }

}
    

