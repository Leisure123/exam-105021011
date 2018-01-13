import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class Test4 extends JFrame implements Runnable{
    private int width = 1500,height = 600;
    private int scrW = Toolkit.getDefaultToolkit().getScreenSize().width/2;
    private int scrH = Toolkit.getDefaultToolkit().getScreenSize().height/2;
    //    String imagePath = System.getProperty("user.dir") + "/Image/";
    private BufferedImage image;
    private Graphics g2;
    private int time = 0;
    private Timer timer;

    private ImageStore store = new ImageStore();
    private Scenes scenes = new Scenes();

    private Thread t = new Thread(this);
    private boolean check = false;

    private Mario3 mario = null;

    public Test4(Test3 t3){
        this.setBounds(scrW-(width/2),scrH-(height/2),width,height);
        this.setResizable(false);
        this.setTitle("Mario_危機重重");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);

        this.mario = new Mario3(5,100);

        this.repaint();

        t.start();

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                timer.start();
            }
        });

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()){
                    case KeyEvent.VK_LEFT:
                        mario.leftMove();
                        break;
                    case KeyEvent.VK_RIGHT:
                        mario.rightMove();
                        break;
                    case KeyEvent.VK_UP:
                        mario.jump();
                        break;
                    case KeyEvent.VK_SPACE:
                        mario.jump();
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
                        break;
                    case KeyEvent.VK_RIGHT:
                        mario.rightStop();
                        break;
                    default:
                        break;
                }
            }
        });
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                time++;
            }
        });

    }


    public void paint(Graphics g){
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_3BYTE_BGR);
        Graphics g2 = image.getGraphics();
        g2.drawRect(0,0,width,height);
        //畫背景
        g2.drawImage(store.backGround,0,0,this);
        //旗子
        g2.drawImage(store.endingflag,1450,350,this);
        g2.setFont(new Font(null,Font.BOLD,25));
        //paint Timer
        g2.drawString("Time",1370,60);
        g2.drawString(time+"s",1370,90);
        //paint headlife
        g2.drawString("Life : ",20,65);
        g2.drawImage(mario.getLifeImage(),80,45,this);
        //畫出障礙物
        for(int i = 0;i < scenes.getBricks3().size(); i++){
            Brick br = scenes.getBricks3().get(i);
            g2.drawImage(br.getShowImage(),br.getX(),br.getY(),this);
        }
        //畫Mario
        g2.drawImage(mario.getNowImage(),this.mario.getX(),this.mario.getY(),this);

        g.drawImage(image,0,0,this);

    }

    public void run(){
        while(true){
            this.repaint();
            if (((mario.getX() + 50 == 1460) && (mario.getY() < 380 && mario.getY() > 280)) || ((mario.getY() + 50 == 330) && (mario.getX() < 1500 && mario.getX() > 1410))){
//                System.exit(1);
//                Test3 t3 = new Test3(Test2.this);
//                t3.setVisible(true);
//                Test2.this.dispose();
            }
            try{
                Thread.sleep(10);
//                System.out.println(imagePath);
            }catch(Exception q){
                System.out.println(q);
            }
        }

    }

}