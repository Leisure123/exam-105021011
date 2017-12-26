import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MarioGame extends JFrame implements Runnable{
    private int width = 900,height = 600;
    private int scrW = Toolkit.getDefaultToolkit().getScreenSize().width/2;
    private int scrH = Toolkit.getDefaultToolkit().getScreenSize().height/2;

    private ImageStore store = new ImageStore();

    private boolean check = false;
    private Thread t = new Thread(this);
    private JLabel lbMario;

    private Mario mario = null;

    public MarioGame(){
        this.setBounds(scrW-(width/2),scrH-(height/2),width,height);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
//        this.setBackground(new Color(0, 0, 0));

        mario = new Mario(10,465);
        mario.getMario().setBounds(mario.getX(),mario.getY(),50,75);
        lbMario = new JLabel((Icon) mario.getMario());
        this.add(mario.getMario());
        t.start();


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
//                        System.out.println("right");
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
                    mario.getMario().setLocation(mario.getX(),mario.getX());
                    System.out.println(mario.getX());
                    System.out.println(mario.getY());
                    System.out.println("y");
                }else{
                    System.out.print("");
                }
            }
        }catch(Exception q){
            System.out.println(q);
        }
    }

}
