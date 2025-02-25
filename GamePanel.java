import javax.swing.JPanel;


public class GamePanel extends JPanel {
    
    MommyMonkey mommy;
    BabyMonkey baby;
    Room room;
    SleepBar sleepBar;
    boolean paused;
  

    public GamePanel () {
        mommy = null;
        baby = null;
        room = null;
        sleepBar = null;
        paused = false;
    }

    public void createGameEntities() {
        baby = new BabyMonkey (this, 480, 320);
        room = new Room(this);
        sleepBar = new SleepBar(this, 420, 50);
        mommy = new MommyMonkey(this, 50, 290); 
    }

    public void drawGameEntities() {
        if(room!=null) {
            room.draw();
        }

        if(baby != null) {
            baby.draw();
        }

        if(sleepBar != null) {
            sleepBar.draw();
        }  
    }

    public void pauseGameEntities(){
        mommy.setIsRunning(false);
        mommy.setGamePaused(true);
    }

    public void resumeGameEntities(){
        mommy = new MommyMonkey(this, 50, 290); 
        mommy.start();
        setPause(false);
        mommy.setIsRunning(true);

    }

    public void jump(){
        int change;
        change=10;


        if(baby!=null && paused == false){
        try{
        while(baby.getY()>280){
            baby.erase();
            baby.drawJumpingUp(change);
            Thread.sleep(100);
        }
        this.sleepBar.add_points();
    }
    catch(InterruptedException e){
        System.out.println("Exception: " + e);
    }
    if(baby.getY()>=280){
        try{
        while(baby.getY()<320){
            baby.erase();
            baby.drawJumpingDown(change);
            Thread.sleep(100);
        }
    }
        catch(Exception e){
            System.out.println("Exception: " + e);
        }
    }
    }
    }

    public void runMommy() {
        if (mommy == null && paused ==false) {
            mommy = new MommyMonkey (this, 50, 290); //top 290 bottom 400
            mommy.start();
        } else if (!mommy.isAlive() && paused == false) {
            mommy = new MommyMonkey (this, 50, 290); //top 290 bottom 400
            mommy.start();
        }
    }

    public void caught(boolean b){
        this.mommy.setCaught(b);
    }

    public void setPause(boolean state){
        this.paused = state;
    }

    public boolean getPause(){
        return this.paused;
    }

    public boolean getInRoomStatus(){
        return mommy.getRoomStatus();
    }

    public int getSleepBarNumber(){
        return sleepBar.getLevel();
    }

    public void printWin(){
        sleepBar.printWin();
    }

    public void printLoss(){
        sleepBar.printLoss();
    }


  
}
