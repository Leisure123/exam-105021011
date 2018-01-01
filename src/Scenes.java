import java.util.ArrayList;

public class Scenes {
    private ArrayList<Brick> bricks = new ArrayList<Brick>();
    private ArrayList<Brick> brickRemove = new ArrayList<Brick>();

    public Scenes(){
        for(int i = 0; i < 30; i++){
            if(i != 15 &&i != 16){
                bricks.add(new Brick(i*50,550,0));
            }

        }

        bricks.add(new Brick(200,400,1));
        bricks.add(new Brick(250,400,1));

        bricks.add(new Brick(300,400,2));
    }

    public ArrayList<Brick> getBricks() {
        return bricks;
    }
    public ArrayList<Brick> getBrickRe(){
        return brickRemove;
    }
}
