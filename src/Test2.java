import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.Iterator;


public class Test2 extends JFrame implements Runnable{
    private int width = 1500,height = 600;
    private int scrW = Toolkit.getDefaultToolkit().getScreenSize().width/2;
    private int scrH = Toolkit.getDefaultToolkit().getScreenSize().height/2;
//    String imagePath = System.getProperty("user.dir") + "/Image/";

    private ImageStore store = new ImageStore();
    private Scenes scenes = new Scenes();

    private Thread t = new Thread(this);
    private boolean check = false;

    private Mario mario = null;

    public Test2(){
        this.setBounds(scrW-(width/2),scrH-(height/2),width,height);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
//        this.setBackground(new Color(0, 0, 0));

        this.mario = new Mario(5,480);

        this.repaint();

        t.start();
//        this.setVisible(true);

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()){
                    case KeyEvent.VK_LEFT:
                        mario.leftMove();
                        check = false;
                        break;
                    case KeyEvent.VK_RIGHT:
                        mario.rightMove();
//                        System.out.println("right");
                        check = false;
                        break;
                    case KeyEvent.VK_UP:
                        mario.jump();
                        check = false;
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
                        check = true;
                        break;
                    case KeyEvent.VK_RIGHT:
                        mario.rightStop();
                        check = true;
                        break;
                    default:
                        break;
                }
            }
        });

    }

    public void paint(Graphics g){
        BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_4BYTE_ABGR);
        Graphics g2 = image.getGraphics();
        //畫背景
        g.drawImage(store.backGround,0,0,this);
        //畫出障礙物
        for(int i = 0;i < scenes.getBricks().size(); i++){
            Brick br = scenes.getBricks().get(i);
            g.drawImage(br.getShowImage(),br.getX(),br.getY(),this);
        }
        //畫Mario
        g.drawImage(mario.getNowImage(),this.mario.getX(),this.mario.getY(),this);

//        g.drawImage(image,0,0,this);
    }

    public void run(){
        while(true){
            this.repaint();
            try{
                Thread.sleep(60);
//                System.out.println(imagePath);
            }catch(Exception q){
                System.out.println(q);
            }
        }

    }

}

