import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

public class ImageStore {
    private static String imagePath = System.getProperty("user.dir") + "/Image/";
    public static ArrayList<BufferedImage> marioImage;
//    private static String imagePath = "D:\Users\GitHub\exam-105021011\Image/";
    public static ArrayList<BufferedImage> enemyImage;
    public static BufferedImage bigImage;
    public static ArrayList<BufferedImage> obImage;
    public static BufferedImage backGround;

    static {
        marioImage = new ArrayList<BufferedImage>();
        enemyImage = new ArrayList<BufferedImage>();
        obImage = new ArrayList<BufferedImage>();

        try{
            for(int i = 1; i <= 8; i++){
                marioImage.add(ImageIO.read(new FileInputStream(imagePath + i + ".png")));
            }
            bigImage = ImageIO.read(new FileInputStream(imagePath +"big.png"));

            for(int i = 1; i <= 2; i++){
                enemyImage.add(ImageIO.read(new FileInputStream(imagePath +"mashroom"+ i + ".png")));
            }
            for(int i = 1; i <= 4; i++){
                obImage.add(ImageIO.read(new FileInputStream(imagePath+"brick"+ i +".png")));
            }

            backGround = ImageIO.read(new FileInputStream(imagePath +"BG.png"));


        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
