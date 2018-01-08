import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

public class ImageStore {
    private static String imagePath = System.getProperty("user.dir") + "/Image/";
    //    private static String imagePath = "D:\Users\GitHub\exam-105021011\Image/";
    public static ArrayList<BufferedImage> marioImage;
    public static ArrayList<BufferedImage> enemyImage;
    public static BufferedImage toxicImage;
    public static ArrayList<BufferedImage> obImage;
    public static BufferedImage backGround;
    public static ArrayList<BufferedImage> headlife;
    public static BufferedImage endingflag;
    public static BufferedImage portal;

    static {
        marioImage = new ArrayList<BufferedImage>();
        enemyImage = new ArrayList<BufferedImage>();
        obImage = new ArrayList<BufferedImage>();
        headlife = new ArrayList<BufferedImage>();

        try{
            for(int i = 1; i <= 8; i++){
                marioImage.add(ImageIO.read(new FileInputStream(imagePath + i + ".png")));
            }
            toxicImage = ImageIO.read(new FileInputStream(imagePath +"toxic.png"));

            for(int i = 1; i <= 3; i++){
                enemyImage.add(ImageIO.read(new FileInputStream(imagePath +"mashroom"+ i + ".png")));
            }
            for(int i = 1; i <= 5; i++){
                obImage.add(ImageIO.read(new FileInputStream(imagePath+"brick"+ i +".png")));
            }

            for(int i = 1; i<=3; i++){
                headlife.add(ImageIO.read(new FileInputStream(imagePath+"headlife"+ i +".png")));
            }

            backGround = ImageIO.read(new FileInputStream(imagePath +"BG.png"));

            endingflag = ImageIO.read(new FileInputStream(imagePath+"flag.png"));

            portal = ImageIO.read(new FileInputStream(imagePath+"portal.png"));

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
