import java.util.ArrayList;

public class Scenes {
    private ArrayList<Brick> bricks = new ArrayList<Brick>();
    private ArrayList<Brick> bricks2 = new ArrayList<Brick>();
    private ArrayList<Brick> bricks3 = new ArrayList<Brick>();
    private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    private ArrayList<Enemy> enemiesRe = new ArrayList<Enemy>();

    private int bg;

    public Scenes(){
        //bricks
        for(int i = 0; i < 30; i++){
            if(i != 15 && i != 16 && i != 11 && i != 12){
                bricks.add(new Brick(i*50,550,0));
            }

        }
        for(int i = 0; i < 30; i++){
            bricks.add(new Brick(i*50,-30,0));
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
        for(int i = 0; i < 3; i++){
            bricks2.add(new Brick(i*50,150,0));
        }
        for(int i = 0; i < 30; i++) {
            bricks2.add(new Brick(i * 50, -30, 0));
        }
        for(int i = 0; i < 9; i++){
            bricks2.add(new Brick(250,0+(i*50),1));
        }
        for(int i = 0; i < 25; i++){
            if (i != 12 && i != 13){
                bricks2.add(new Brick(500+(i*50),550,0));
            }
        }
        bricks2.add(new Brick(1100,550,5));
        bricks2.add(new Brick(1150,550,5));

        for(int i = 0; i < 9; i++){
            bricks2.add(new Brick(450,500-(i*50),1));
        }
        //迷宮
        for(int i = 0; i < 9; i++){
            bricks2.add(new Brick(600,50*i,4));
        }
        bricks2.add(new Brick(550,450,4));

        for(int i = 0; i < 9; i++){
            bricks2.add(new Brick(800,500-(i*50),4));
        }
        bricks2.add(new Brick(650,400,4));
        bricks2.add(new Brick(700,400,4));
        bricks2.add(new Brick(650,250,4));
        bricks2.add(new Brick(750,150,4));
        for(int i = 0; i < 8; i++){
            bricks2.add(new Brick(850+(i*50),100,4));
        }
        for(int i = 0; i < 6; i++){
            bricks2.add(new Brick(1350,i*50,4));
        }
        for(int i = 0; i < 8; i++){
            bricks2.add(new Brick(1300-(i*50),250,4));
        }
        for(int i = 0; i < 8; i++){
            bricks2.add(new Brick(1300-(i*50),400,4));
        }
        for(int i = 0; i < 3; i++){
            bricks2.add(new Brick(1350,400+(i*50),4));
        }
        bricks2.add(new Brick(1100,225,4));
        bricks2.add(new Brick(1000,375,4));

//      for (int i = 0; i < 2; i++){
//          bricks2.add(new Brick(650+(i*50),400,1));
//      }
        bricks2.add(new Brick(400,450,3));
        bricks2.add(new Brick(400,300,3));
        bricks2.add(new Brick(400,150,3));
        bricks2.add(new Brick(300,380,3));
        bricks2.add(new Brick(300,220,3));
        bricks2.add(new Brick(300,80,3));


        //brick3
        for(int i = 0; i < 6; i++) {
            if (i != 4 && i != 5) {
                bricks3.add(new Brick(i * 50, 150, 0));
            }
        }
        //空
        bricks3.add(new Brick(250,150,5));
        bricks3.add(new Brick(200,150,5));
        for(int i = 0;i<6;i++){
            if(i!=2 && i!=3){
            bricks3.add(new Brick(150+(i*50),450,1));
             }
        }
        //空
        bricks3.add(new Brick(250,450,6));
        bricks3.add(new Brick(300,450,6));

        for(int i = 0;i<7;i++){
            bricks3.add(new Brick(450+(i*50),300,1));
        }

        bricks3.add(new Brick(750,250,3));
        bricks3.add(new Brick(800,200,3));
        bricks3.add(new Brick(900,100,3));
        //空
        bricks3.add(new Brick(850,150,7));
        //空
        for(int i = 0;i<6;i++){
            bricks3.add(new Brick(850+(i*50),400,7));
        }
        for(int i = 0;i<3;i++){
            if(i!=1 && i!=2) {
                bricks3.add(new Brick(1100 + (i * 50), 100, 1));
            }
        }
        //空
        bricks3.add(new Brick(1150,100,6));
        bricks3.add(new Brick(1200,100,6));

        for(int i = 0;i<6;i++){
            if(i!=3 && i!=5 && i!=4) {
                bricks3.add(new Brick(1200 + (i * 50), 550, 0));
            }
        }
        //空
        bricks3.add(new Brick(1350,550,5));
        bricks3.add(new Brick(1400,550,5));
        bricks3.add(new Brick(1450,550,5));

        //後新增
        bricks3.add(new Brick(1100,200,4));
        bricks3.add(new Brick(950,200,4));
        bricks3.add(new Brick(1150,300,4));

        bricks3.add(new Brick(1300,100,4));
        bricks3.add(new Brick(1300,250,4));
        bricks3.add(new Brick(1300,400,4));
        bricks3.add(new Brick(1350,350,4));
        bricks3.add(new Brick(1300,525,4));
    }

    public ArrayList<Brick> getBricks() {
        return bricks;
    }
    public ArrayList<Brick> getBricks2(){
        return bricks2;
    }
    public ArrayList<Brick> getBricks3(){ return bricks3; }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }
}
