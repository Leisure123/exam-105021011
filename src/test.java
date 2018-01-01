import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class test extends JFrame implements Runnable{
    private int width = 900,height = 600;
    private int scrW = Toolkit.getDefaultToolkit().getScreenSize().width/2;
    private int scrH = Toolkit.getDefaultToolkit().getScreenSize().height/2;
    private int x = 10, y = 480;
    private int movex, movey,upTime = 0;
    private String status;
    private Mario mario = null;
    private Thread t;

    private ImageStore store = new ImageStore();

    private JLabel lbmario = new JLabel();
    public test() {
        this.setBounds(scrW - (width / 2), scrH - (height / 2), width, height);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        mario = new Mario(x, y);

        lbmario.setBounds(x, y, 50, 75);
        this.add(lbmario);
        t = new Thread(this);
        t.start();

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        leftMove();
                        System.out.println(x+"\t"+y);
                        lbmario.setLocation(x,y);
                        break;
                    case KeyEvent.VK_RIGHT:
                        rightMove();
                        System.out.println(x+"\t"+y);
                        lbmario.setLocation(x,y);
                        break;
                    case KeyEvent.VK_UP:
                        jump();
                        System.out.println(x+"\t"+y);
                        lbmario.setLocation(x,y);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        leftStop();
                        System.out.println(x+"\t"+y);
                        lbmario.setLocation(x,y);
                        break;
                    case KeyEvent.VK_RIGHT:
                        rightStop();
                        System.out.println(x+"\t"+y);
                        lbmario.setLocation(x,y);
                        break;
                    default:
                        break;
                }
            }
        });
    }
        public void rightMove(){
            movex = 1;
            x += 5;
//            if(status.equals("jump")){
//                status = "jump-right";
//            }else{
//                status = "right";
//            }
        }

        public void leftMove(){
            movex = -1;
            x -= 5;
//          if(status.equals("jump")){
//                status = "jump-left";
//            }else{
//                status = "left";
//            }
        }

        public void rightStop(){
            movex = 0;
//            if(status.equals("jump")){
//                status = "jump-right";
//            }else{
//                status = "right";
//            }
        }

        public void leftStop(){
            movex = 0;
//            if(status.equals("jump")){
//                status = "jump-left";
//            }else{
//                status = "left";
//            }
        }

        public void jump(){
            if(!status.equals("jump")){
                if(status.equals("right")){
                    status = "jump-right";
                }else{
                    status = "jump-left";
                }
                movey = -5;
                upTime = 36;
            }
        }

        public void drop(){
//            if(status.equals("right")){
//                status = "jump-right";
//            }else{
//                status = "jump-left";
//            }
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
//                    drop();
                }
                y += movey;
            }

            if((canL && (movex < 0)) || (canR && (movex > 0))){
                if(x < 0 || x > 900){
                    x = 0;
                }
                x += movex;
            }
            try{
                Thread.sleep(50);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
//            if (status.equals("left")){
//                System.out.println(status);
//                nowImage = store.marioImage.get(1);
//                mario.setIcon(nowImage);
//            }
//            if(status.equals("right")){
//                nowImage = store.marioImage.get(0);
//                mario.setIcon(nowImage);
//            }

        }
    }
}
