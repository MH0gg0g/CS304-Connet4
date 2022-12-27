package Textures;

public class Bullet {
    int targetY, targetX;
    boolean isMove;
    int currentY, currentX;
    int player;
    int test = 0;
    
    public Bullet(int x, int y, int column, int player){
        this.player = player;
        this.currentY = 70;
        this.currentX = x;
        this.targetX = x;
        this.targetY = y;
        this.isMove = true;
    }
    
    void moveDown() {
        if (currentY > this.targetY) {
            currentY--;
//            System.out.println(currentY);
        }
        isMove = false;
    
    }
    

}
