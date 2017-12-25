import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MarioGame extends JFrame implements Runnable{
    private int width = 900,height = 600;
    private int scrW = Toolkit.getDefaultToolkit().getScreenSize().width/2;
    private int scrH = Toolkit.getDefaultToolkit().getScreenSize().height/2;
    private boolean check = false;
    private Thread t = new Thread(this);

    private Mario mario = null;

    public MarioGame(){
        this.setBounds(scrW-(width/2),scrH-(height/2),width,height);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setBackground(new Color(255, 255, 255));
        t.start();

        mario = new Mario(10,465);
        mario.getMario().setBounds(mario.getX(),mario.getY(),50,75);
        this.add(mario.getMario());


        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()){
                    case KeyEvent.VK_LEFT:
                        mario.leftMove();
                        check = true;
                        break;
                    case KeyEvent.VK_RIGHT:
                        mario.rightMove();
                        check = true;
                        break;
                    case KeyEvent.VK_UP:
                        mario.jump();
                        check = true;
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()){
                    case KeyEvent.VK_LEFT:
                        mario.leftStop();
                        check = false;
                        break;
                    case KeyEvent.VK_RIGHT:
                        mario.rightStop();
                        check = false;
                        break;
                    default:
                        break;
                }
            }
        });

    }

    public void run(){
        try{
            while(true){
                if((mario.getMovex() != 0) &&(mario.getMovey() != 0)){
                    mario.getMario().setLocation(mario.getX(),mario.getY());
                }else{

                }
            }
        }catch(Exception q){
            System.out.println(q);
        }
    }

}
