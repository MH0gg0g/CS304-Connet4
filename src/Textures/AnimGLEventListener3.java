package Textures;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package project;
import Game.mainMenu;
import Textures.*;
import com.sun.opengl.util.j2d.TextRenderer;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.*;
import java.io.IOException;
import javax.media.opengl.*;

import java.util.BitSet;
import javax.media.opengl.glu.GLU;

public class AnimGLEventListener3 extends AnimListener {

    // 
    private int timer = 100;
    private int column = 0;
    private int column0 = 0;
    private int column1 = 0;
    private int column2 = 0;
    private int column3 = 0;
    private int column4 = 0;
    private boolean ispaused = false;
    private boolean isWinner = false;

    private int row = 0;
    private int mouseX, mouseY;

    int[][] board = new int[5][5];
    Bullet[][] bulletBoard = new Bullet[5][5];
//    Bullet[][] bulletBoard = {{new Bullet(28, 27, 1, 1)}};
//    int[][] arrrr = {{1, 2, 3},{4, 5, 6},{7, 8, 9},{10, 11, 12} };
//    int[][] board = {{1, 0, 0, 0 ,0}, {0, 0, 0, 0 ,0}, {0, 0, 0, 0 ,0}, {0, 0, 0, 0 ,0}, {1, 0, 0, 0 ,0}};
    int[] rowMatrix = {16, 27, 38, 49, 59};
    int[] columnMatrix = {28, 37, 46, 55, 63};
    int player = 1;
    int winner = 0;
    int currentY = 70;

    int maxWidth = 100;
    int maxHeight = 100;
    float x = maxWidth / 2, y = maxHeight / 2;

    String textureNames[] = {"1.png", "2.png", "pause.jpg", "win.jpg", "easy.jpeg"};
    TextureReader.Texture texture[] = new TextureReader.Texture[textureNames.length];
    int textures[] = new int[textureNames.length];
//    TextureReader txReader = new TextureReader();
//    TextRenderer txtRenderer = new TextRenderer(new Font("Courier New", Font.BOLD, 20));
    TextRenderer txtRenderer = new TextRenderer(new Font("Courier New", 3, 30));


    /*
     5 means gun in array pos
     x and y coordinate for gun 
     */
    public void init(GLAutoDrawable gld) {

        GL gl = gld.getGL();
        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);    //This Will Clear The Background Color To Black

        gl.glEnable(GL.GL_TEXTURE_2D);  // Enable Texture Mapping
        gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
        gl.glGenTextures(textureNames.length, textures, 0);

        for (int i = 0; i < textureNames.length; i++) {
            try {
                texture[i] = TextureReader.readTexture(assetsFolderName + "//" + textureNames[i], true);
                gl.glBindTexture(GL.GL_TEXTURE_2D, textures[i]);

//                mipmapsFromPNG(gl, new GLU(), texture[i]);
                new GLU().gluBuild2DMipmaps(
                        GL.GL_TEXTURE_2D,
                        GL.GL_RGBA, // Internal Texel Format,
                        texture[i].getWidth(), texture[i].getHeight(),
                        GL.GL_RGBA, // External format from image,
                        GL.GL_UNSIGNED_BYTE,
                        texture[i].getPixels() // Imagedata
                );
            } catch (IOException e) {
                System.out.println(e);
                e.printStackTrace();
            }
        }
//        bulletBoard[0][0] = new Bullet(rowMatrix[0], columnMatrix[0], 1, 1);
    }

    public void display(GLAutoDrawable gld) {

        GL gl = gld.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);       //Clear The Screen And The Depth Buffer
        gl.glLoadIdentity();

        DrawBackground(gl, textureNames.length - 1);
        handleKeyPress();
//        rand();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (bulletBoard[j][i] != null) {
//                    System.out.println("currentX:  " + bulletBoard[0][0].currentX + "  currentY: " + bulletBoard[0][0].currentY );
                    bulletBoard[j][i].moveDown();
                    DrawSprite(gl, bulletBoard[j][i].currentX, bulletBoard[j][i].currentY, bulletBoard[j][i].player - 1, 1f);
                }
            }
        }

        if (isWiner()) {
            DrawBackground(gl, textureNames.length - 2);
        }
        
        if (ispaused) {
            DrawBackground(gl, textureNames.length - 3);
        }



        if (!isWinner && !ispaused) {
            DrawText("Timer: ", timer--, 20, 650);
            DrawText("Current Player: ", player, 20, 600);
 
            if (timer == 0) {
                timer = 100;
                player = (player % 2) + 1;
            }
            
        }

    }

    public void DrawText(String str, int value, int x, int y) {
        txtRenderer.beginRendering(1280, 720);
        txtRenderer.setColor(Color.BLACK);
        txtRenderer.draw(str + value--, x, y);
        txtRenderer.setColor(Color.WHITE);
        txtRenderer.endRendering();

    }

    public void DrawSprite(GL gl, int x, int y, int index, float scale) {
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[index]);	// Turn Blending On

        gl.glPushMatrix();
        gl.glTranslated(x / (maxWidth / 2.0) - 0.9, y / (maxHeight / 2.0) - 0.9, 0);
        gl.glScaled(0.11 * scale, 0.17 * scale, 1);
        //System.out.println(x +" " + y);
        gl.glBegin(GL.GL_QUADS);
        // Front Face
        gl.glTexCoord2f(0.0f, 0.0f);
        gl.glVertex3f(-1.0f, -1.0f, -1.0f);
        gl.glTexCoord2f(1.0f, 0.0f);
        gl.glVertex3f(1.0f, -1.0f, -1.0f);
        gl.glTexCoord2f(1.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, -1.0f);
        gl.glTexCoord2f(0.0f, 1.0f);
        gl.glVertex3f(-1.0f, 1.0f, -1.0f);
        gl.glEnd();
        gl.glPopMatrix();

        gl.glDisable(GL.GL_BLEND);
    }

    public void DrawBackground(GL gl, int index) {
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[index]);	// Turn Blending On

        gl.glPushMatrix();
        gl.glBegin(GL.GL_QUADS);
        // Front Face
        gl.glTexCoord2f(0.0f, 0.0f);
        gl.glVertex3f(-1.0f, -1.0f, -1.0f);
        gl.glTexCoord2f(1.0f, 0.0f);
        gl.glVertex3f(1.0f, -1.0f, -1.0f);
        gl.glTexCoord2f(1.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, -1.0f);
        gl.glTexCoord2f(0.0f, 1.0f);
        gl.glVertex3f(-1.0f, 1.0f, -1.0f);
        gl.glEnd();
        gl.glPopMatrix();

        gl.glDisable(GL.GL_BLEND);
    }

//    public void rand(){
//        int xrand= (int)(Math.random()*5);
//        int yrand= (int)(Math.random()*5);
//        System.out.println(xrand+" "+yrand);
//    }
//    public void moveBall (int y) {
//        currentY =  (currentY > y)? currentY-- : y;
//    }
    //Placing a Move
    public int placeBall(int column, int player) {
        for (int i = 4; i >= 0; i--) {
            if (board[i][column] == 0) {
                board[i][column] = player;
                return i;
            }
        }
        return 0;
    }

    public void printBulletMatrix() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (bulletBoard[i][j] != null) {
                    System.out.println("found" + i + "  " + j);
//                    System.out.print(i + "   " + bulletBoard[i][j].targetX + "    " + j + "  " +  bulletBoard[i][j].targetY  +  "  ");

                }
            }
            System.out.println("");
        }
    }
    
    public boolean isWiner() {
       if(ValidatewinRight() || ValidatewinLeft() || ValidatewinDiagleft() || ValidatewinDiagRight()) {
          isWinner = true;
       }
    
    return isWinner;
    }

    public void printMatrix() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(board[i][j] + "  ");

            }
            System.out.println("");
        }
    }

    public boolean ValidatewinUp() {
        winner = 0;
        for (int i = 0; i <= 4; ++i) {
            for (int j = 0; j <= 4; ++j) {

                //up 
//                    
                if (board[i][j] > 0) //                    if( (i-3) >= 0 && board[i][j] == board[i-1][j] && board[i-2][j] == board[i-3][j] && board[i][j] == board[i-3][j] ) {
                {
                    if (board[i][j] == board[i + 1][j] && board[i + 2][j] == board[i + 3][j] && board[i][j] == board[i + 3][j]) {
                        winner = board[i][j];
                        System.out.println("UpUPUP" + i + "   " + j );
                        return true;

                    }
                }

            }
        }
        return  false;
    }

    public boolean ValidatewinRight() {
        winner = 0;
        for (int i = 0; i <= 4; ++i) {
            for (int j = 0; j <= 4; ++j) {

                //Right     
                if (board[i][j] > 0) {
                    if ((j + 3) <= 4 && board[i][j] == board[i][j + 1] && board[i][j + 2] == board[i][j + 3] && board[i][j] == board[i][j + 3]) {
                        winner = board[i][j];
                        System.out.println("rrrr " + i + "   " + j);
                        return true;
                        //                System.out.println("Player one is win");
                    }
                }
            }
        }
    return false;
    }

    public boolean ValidatewinLeft() {
        winner = 0;
        for (int i = 0; i <= 4; ++i) {
            for (int j = 0; j <= 4; ++j) {

                // left
                if (board[i][j] > 0) {
                    if ((j - 3) >= 0 && board[i][j] == board[i][j - 1] && board[i][j - 2] == board[i][j - 3] && board[i][j] == board[i][j - 3]) {
                        winner = board[i][j];
                        System.out.println("LLLLLLL " + i + "   " + j);
                        return true;

                    }
                }
            }
        }
        return false;
    }

    public boolean ValidatewinDiagRight() {
        winner = 0;
        for (int i = 0; i <= 4; ++i) {
            for (int j = 0; j <= 4; ++j) {

                if (board[i][j] > 0) {
                    if ((j + 3) <= 4 && (i - 3) >= 0 && board[i][j] == board[i - 1][j + 1] && board[i - 2][j + 2] == board[i - 3][j + 3] && board[i][j] == board[i - 3][j + 3]) {
                        winner = board[i][j];
                        System.out.println("dddddrr " + i + "   " + j);
                        return true;
                    }
                }
            }
        }
        return false;

    }

    public boolean ValidatewinDiagleft() {
        winner = 0;
        for (int i = 0; i <= 4; ++i) {
            for (int j = 0; j <= 4; ++j) {

                if (board[i][j] > 0) {
                    if ((j - 3) >= 0 && (i - 3) >= 0 && board[i][j] == board[i - 1][j - 1] && board[i - 2][j - 2] == board[i - 3][j - 3] && board[i][j] == board[i - 3][j - 3]) {
                        winner = board[i][j];
                        System.out.println("dddddLL " + i + "   " + j);
                        return true;
                    }
                }

            }
        }
        return false;
    }

    public void mouseClicked(MouseEvent e) {
        double x = e.getX();
        double y = e.getY();
        Component c = e.getComponent();
        double width = c.getWidth();
        double height = c.getHeight();

        mouseX = (int) ((x / width) * 100);
        mouseY = ((int) ((y / height) * 100));
        mouseY = 100 - mouseY;

        System.out.println("\nThe mouse is clicked at ( X=  " + mouseX + ", Y= " + mouseY + " )");
        if (column0 < 5 && mouseX >= 30 && mouseX <= 36) {
//            column = 0;
//            row = placeBall(column, player);
            board[4 - column0][0] = player;
            bulletBoard[0][column0] = new Bullet(columnMatrix[0], rowMatrix[column0], column, player);
            column0++;

        } else if (column1 < 5 && mouseX >= 39 && mouseX <= 45) {
//            column = 1;
//            row = placeBall(column, player);
            board[4 - column1][1] = player;

            bulletBoard[1][column1] = new Bullet(columnMatrix[1], rowMatrix[column1], column, player);
            column1++;
        } else if (column2 < 5 && mouseX >= 47 && mouseX <= 53) {
//            column = 2;
//            row = placeBall(column, player);
            board[4 - column2][2] = player;

            bulletBoard[2][column2] = new Bullet(columnMatrix[2], rowMatrix[column2], column, player);
            column2++;

        } else if (column3 < 5 && mouseX >= 56 && mouseX <= 62) {
//             column = 3;
//            row = placeBall(column, player);
            board[4 - column3][3] = player;

            bulletBoard[3][column3] = new Bullet(columnMatrix[3], rowMatrix[column3], column, player);
            column3++;

//        printMatrix();
        } else if (column4 < 5 && mouseX >= 65 && mouseX <= 72) {
//            column = 4;
//            row = placeBall(column, player);
            board[4 - column4][4] = player;

            bulletBoard[4][column4] = new Bullet(columnMatrix[4], rowMatrix[column4], column, player);
            column4++;
        }
        else if (mouseX >= 80 && mouseX <= 89) {
            
        }
        else if (mouseX >= 90 && mouseX <= 95) {

        }
        timer = 1;

    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }

    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

//    public static void main(String[] args) {
//        new Anim(new AnimGLEventListener3());
//    }

    public void handleKeyPress() {

        if (isKeyPressed(KeyEvent.VK_P)) {
            ispaused = true;
            System.out.println("pppppppp");
        } else if (isKeyPressed(KeyEvent.VK_R)) {
            ispaused = false;
            System.out.println("rrrrrrrrrr");
        }
    }
    public BitSet keyBits = new BitSet(256);

    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyPressed(final KeyEvent event) {
        int keyCode = event.getKeyCode();
        keyBits.set(keyCode);
    }

    @Override
    public void keyReleased(final KeyEvent event) {
        int keyCode = event.getKeyCode();
        keyBits.clear(keyCode);
    }

    public boolean isKeyPressed(final int keyCode) {
        return keyBits.get(keyCode);
    }

}
