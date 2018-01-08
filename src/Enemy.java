import java.awt.image.BufferedImage;

public class Enemy{
    private ImageStore store = new ImageStore();
//    Scenes scenes = new Scenes();

    private int x, y;
    private int startX, startY;

    private int type;

    private BufferedImage showImage = null;

    private int imageAction = 0;

    private boolean canL = true;

    //一般菇菇怪
    public Enemy(int x, int y, boolean can, int type){
        this.x = x;
        this.y = y;
        this.startX = x;
        this.startY = y;
        this.canL = can;
        this.type = type;
        if (type == 1){
            this.showImage = store.enemyImage.get(0);
        }
    }

    public Enemy(){

    }
    public void setImage(){
        this.showImage = store.enemyImage.get(imageAction);
    }

    public boolean getCan(){
        return canL;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public BufferedImage getShowImage() {
        return showImage;
    }

    public int getType(){
        return type;
    }

}
