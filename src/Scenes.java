import java.util.ArrayList;

public class Scenes {
    private ArrayList<Brick> bricks = new ArrayList<Brick>();
    private ArrayList<Brick> brickRemove = new ArrayList<Brick>();

    public Scenes(){
        for(int i = 0; i < 30; i++){
            if(i != 15 && i != 16 && i != 11 && i != 12){
                bricks.add(new Brick(i*50,550,0));
            }

        }
        //前-下方塊1
        bricks.add(new Brick(200,400,1));
        bricks.add(new Brick(250,400,1));
        bricks.add(new Brick(300,400,2));
        //前-上方塊2
        bricks.add(new Brick(450,250,1));
        bricks.add(new Brick(500,250,1));
        bricks.add(new Brick(550,250,1));
        bricks.add(new Brick(600,250,1));
        //階梯
        bricks.add(new Brick(1450,500,1));
        bricks.add(new Brick(1450,450,1));
        bricks.add(new Brick(1450,400,1));
        bricks.add(new Brick(1400,500,1));
        bricks.add(new Brick(1400,450,1));
        bricks.add(new Brick(1350,500,1));

    }

    public ArrayList<Brick> getBricks() {
        return bricks;
    }
    public ArrayList<Brick> getBrickRe(){
        return brickRemove;
    }
}
