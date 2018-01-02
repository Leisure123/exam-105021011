import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Mario implements Runnable{
    private ImageStore store = new ImageStore();
    private Scenes scenes = new Scenes();

    private int x , y;
    private int movex = 0, movey = 0;
    private int upTime;
    //jump = true; ground = false;
    private boolean upCheck = false;
    // Right = true; Left = false
    private boolean RLCheck = true;

    private BufferedImage nowImage;
    private String status;
    private Thread t = null;

    public Mario(int x, int y){
        this.x = x;
        this.y = y;
        this.nowImage = store.marioImage.get(1);
        this.status = "right";
        t = new Thread(this);
        t.start();
    }

    public void rightMove(){
        movex = 5;
        RLCheck = true;
        if (!upCheck){
            status = "right";
        }else{
            status = "jump-right";
        }
    }

    public void leftMove(){
        movex = -5;
        RLCheck = false;
        if (!upCheck){
            status = "left";
        }else{
            status = "jump-left";
        }
    }

    public void rightStop(){
        this.movex = 0;
        RLCheck = true;
        if (!upCheck){
            status = "right";
        }else{
            status = "jump-right";
        }
    }

    public void leftStop(){
        this.movex = 0;
        RLCheck = false;
        if (!upCheck){
            status = "left";
        }else{
            status = "jump-left";
        }
    }

    public void jump(){
        // 限制跳一次
        if (!upCheck){
            if(RLCheck){
                status = "jump-right";
            }else{
                status = "jump-left";
            }
            movey = -5;
            upTime = 32;
            upCheck = true;
        }
    }

    public void drop(){
        if(RLCheck){
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
            //miniMario
            for(int i = 0; i < scenes.getBricks().size(); i++){
                Brick br = scenes.getBricks().get(i);
                //不允許往右
                if((this.x + 50 == br.getX()) && (this.y < br.getY() + 50 && this.y > br.getY() - 50)){
                    canR = false;
                }
                //不允許往左
                if((this.x - 50 == br.getX()) && (this.y < br.getY() + 50 && this.y > br.getY() - 50)){
                    canL = false;
                }
                //可以站在障礙物上
                if((this.y + 50 == br.getY()) && (this.x < br.getX() + 50 && this.x > br.getX() - 50)){
                    onLand = true;
                }
                //撞到障礙物
                if((this.y - 50 == br.getY()) && (this.x < br.getX() + 50 && this.x > br.getX() - 50)){
//                    if(br.getType() == 1){
//                        scenes.getBricks().remove(br);
//                        scenes.getBrickRe().add(br);
//                    }
//                    if(br.getType() == 2 && upTime > 0){
//                        br.setType(1);
//                        br.setImage();
//                    }
                    upTime = 0;
                }
            }

            if(onLand && upTime ==0){
                if(RLCheck){
                    status = "right";
                }else{
                    status = "left";
                }
                upCheck = false;
            }else{
                if(upTime != 0){
                    upTime--;
                }else{
                    this.drop();
                }
                y += movey;
            }

            if(this.y > 600){
                dead();
            }

            if((canL && (movex < 0)) || (canR && (movex > 0))){
                if(x < 0){
                    x = 0;
                }
                x += movex;
            }

//            this.nowImage = store.marioImage.get(0);

            switch (status){
                case "right":
                    this.nowImage = store.marioImage.get(0);
                    break;
                case "left":
                    this.nowImage = store.marioImage.get(1);
                    break;
                case "jump-right":
                    this.nowImage = store.marioImage.get(2);
                    break;
                case "jump-left":
                    this.nowImage = store.marioImage.get(3);
                    break;
            }

            try{
                Thread.sleep(40);
            }catch(InterruptedException e){
                e.printStackTrace();
            }

        }
    }

    public int getMovex(){
        return movex;
    }

    public int getMovey(){
        return movey;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public BufferedImage getNowImage(){
        return nowImage;
    }

    public void dead(){
        this.x = 5;
        this.y = 480;
//        JOptionPane.showMessageDialog(null,"Dead  Haha 87");
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }
}
