import java.util.ArrayList;

public class Scenes {
    private ArrayList<Brick> bricks = new ArrayList<Brick>();
    private ArrayList<Brick> bricks2 = new ArrayList<Brick>();

    private int bg;

    public Scenes(){
                //bricks
                for(int i = 0; i < 30; i++){
                    if(i != 15 && i != 16 && i != 11 && i != 12){
                        bricks.add(new Brick(i*50,550,0));
                    }

                }
                for(int i = 0; i < 30; i++){
                    bricks.add(new Brick(i*50,-20,0));
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
                //hight wall
                bricks.add(new Brick(750,100,1));
                bricks.add(new Brick(750,50,1));
                bricks.add(new Brick(750,0,1));
                for(int i = 0;i < 8;i++ ){
                    bricks.add(new Brick(850,500 - (i *50),1));
                }
                //後-方塊
                bricks.add(new Brick(1300,200,1));
                bricks.add(new Brick(1250,200,1));
                bricks.add(new Brick(1200,200,2));
                bricks.add(new Brick(1150,200,2));
                bricks.add(new Brick(1100,200,1));



                //bricks2
                 for(int i = 0; i < 5; i++){
                        bricks2.add(new Brick(i*50,150,0));
                    }
                    for(int i = 0; i < 30; i++) {
                        bricks2.add(new Brick(i * 50, -20, 0));
                    }
                    for(int i = 0; i < 9; i++){
                        bricks2.add(new Brick(400,0+(i*50),1));
                    }
                    for(int i = 0; i < 25; i++){
                        bricks2.add(new Brick(500+(i*50),550,0));
                    }
                    for(int i = 0; i < 9; i++){
                        bricks2.add(new Brick(600,500-(i*50),1));
                    }
                    for(int i = 0; i < 2; i++){
                        bricks2.add(new Brick(650+(i*50),400,1));
                    }
                    bricks2.add(new Brick(550,450,3));
                    bricks2.add(new Brick(550,300,3));
                    bricks2.add(new Brick(550,150,3));
                    bricks2.add(new Brick(450,380,3));
                    bricks2.add(new Brick(450,220,3));
                    bricks2.add(new Brick(450,80,3));
    }

    public ArrayList<Brick> getBricks() {
        return bricks;
    }
    public ArrayList<Brick> getBricks2(){
        return bricks2;
    }


}
