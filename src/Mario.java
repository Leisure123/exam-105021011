import javax.swing.*;
import java.io.IOException;

public class Mario implements Runnable{
    private ImageStore store = new ImageStore();

    private int x , y;
    private int movex, movey;
    private int upTime;
    private JLabel mario = new JLabel();
    private ImageIcon nowImage;
    private String status;
    private Thread t = null;

    public Mario(int x, int y){
        this.x = x;
        this.y = y;
        this.nowImage = store.marioImage.get(0);
        this.status = "stand-right";
        mario.setIcon(nowImage);
        t = new Thread(this);
        t.start();
    }

    public void rightMove(){
        movex = 5;
        if(status.equals("jump")){
            status = "jump-right";
        }else{
            status = "right";
        }
    }

    public void leftMove(){
        movex = -5;
        if(status.equals("jump")){
            status = "jump-left";
        }else{
            status = "left";
        }
    }

    public void rightStop(){
        movex = 0;
        if(status.equals("jump")){
            status = "jump-right";
        }else{
            status = "right";
        }
    }

    public void leftStop(){
        movex = 0;
        if(status.equals("jump")){
            status = "jump-left";
        }else{
            status = "left";
        }
    }

    public void jump(){
        if(!status.equals("jump")){
            if(status.equals("right")){
                status = "jump-right";
            }else{
                status = "jump-left";
            }
            movey = -3;
            upTime = 40;
        }
    }

    public void drop(){
        if(status.equals("right")){
            status = "jump-right";
        }else{
            status = "jump-left";
        }
        movey = 5;
    }

    @Override
    public void run() {
        while(true){
            boolean canL = true, canR = true, onLand = false;

            if(onLand && upTime ==0){
                if(status.equals("right")){
                    if(movex != 0){
                        status = "right";
                    }
                }else{
                    if(movex != 0){
                        status = "left";
                    }
                }
            }else{
                if(upTime != 0){
                    upTime--;
                }else{
                    this.drop();
                }
                y += movey;
            }

            if((canL && (movex < 0)) || (canR && (movex > 0))){
                if(x < 0){
                    x = 0;
                }
                x += movex;
            }
            if (status.equals("left")){
                System.out.println(status);
                nowImage = store.marioImage.get(1);
                mario.setIcon(nowImage);
            }
            if(status.equals("right")){
                nowImage = store.marioImage.get(0);
                mario.setIcon(nowImage);
            }

        }
    }
    public JLabel getMario() {
        return mario;
    }
    public int getMovex(){
        return movex;
    }

    public int getMovey(){
        return movey;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }
}
