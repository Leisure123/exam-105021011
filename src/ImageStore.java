import javax.swing.*;
import java.util.ArrayList;

public class ImageStore {
    public static ArrayList<ImageIcon> marioImage;

    static {
        marioImage = new ArrayList<ImageIcon>();
        try{
            for(int i = 1; i <= 8; i++){
                marioImage.add(new ImageIcon("Image/"+ i +".png"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
