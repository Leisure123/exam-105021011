import java.awt.*;
import java.awt.image.BufferedImage;

public class Brick{
    private ImageStore store = new ImageStore();

    private int x, y;
    private int type;
    private int startType;
    private BufferedImage showImage = null;

    public Brick(int x, int y, int type){
        this.x = x;
        this.y = y;
        this.type = type;
        this.startType = type;
        setImage();
    }
    public void setImage(){
        showImage = store.obImage.get(type);
    }

    public BufferedImage getShowImage() {
        return showImage;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getType(){
        return type;
    }

    public void setType(int t){
        this.type = t;
    }
}
