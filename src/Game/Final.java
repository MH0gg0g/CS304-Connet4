/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import jdk.nashorn.internal.objects.NativeRegExp;
 

/**
 *
 * @author impact
 */
import java.util.Scanner;
public class Final {
    static int[][] board = new int[6][7];
   static int player;
    
    //Placing a Move 
    public void placeMove(int column, int player){ 
        
        for(int i=5;i>=0;--i){
            if(board[i][column] == 0) {
                board[i][column] = (int)player;
            }
        }
    }
    //Check win
    static public int ValidatewinUp(){ 
        player = 0;
            for(int i = 0; i <= 5 ;++i){
                for(int j = 0; j <= 6 ;++j){
                    
                    //up 
//                    
                  if(board[i][j]>0)
                    if( (i-3) >= 0 && board[i][j] == board[i-1][j] && board[i-2][j] == board[i-3][j] && board[i][j] == board[i-3][j] ) {
                    player = board[i][j];
                                                            System.out.println("UpUPUP" + i + "   " + j );

                }

                }
            }
                    return player;
    }
    
static public int ValidatewinRight(){ 
        player = 0;
        
            for(int i = 0; i <= 5 ;++i){
                for(int j = 0; j <= 6 ;++j){
                    
              //Right     
              if(board[i][j]>0)

                         if((j+3) <= 6 && board[i][j] == board[i][j+1] && board[i][j+2] == board[i][j+3] && board[i][j] == board[i][j+3] ) {
                        player = board[i][j];
                                                            System.out.println("rrrr " + i + "   " + j );

    //                System.out.println("Player one is win");
                }
                }
            }
                                return player;

}
       static public int ValidatewinLeft(){ 
        player = 0;
            for(int i = 0; i <= 5 ;++i){
                for(int j = 0; j <= 6 ;++j){
                
                // left
              if(board[i][j]>0)

                 if((j-3) >= 0 && board[i][j] == board[i][j-1] && board[i][j-2] == board[i][j-3] && board[i][j] == board[i][j-3] ) {
                    player = board[i][j]; 
                                                            System.out.println("LLLLLLL " + i + "   " + j );

                }
                }
            }
       return player;
 
       }
                

     static public int ValidatewinDiagRight(){ 
        player = 0;
            for(int i = 0; i <= 5 ;++i){
                for(int j = 0; j <= 6 ;++j){
                    
               
                    if(board[i][j]>0)        
                 if( (j+3) <= 6 && (i-3) >= 0 &&  board[i][j] == board[i-1][j+1] && board[i-2][j+2] == board[i-3][j+3] && board[i][j] == board[i-3][j+3] ) {
                    player = board[i][j];
                                        System.out.println("dddddrr " + i + "   " + j );
                 }
            }
            }
                   return player;

            
     }
              static public int ValidatewinDiagleft(){ 
        player = 0;
            for(int i = 0; i <= 5 ;++i){
                for(int j = 0; j <= 6 ;++j){
                    
               
                    if(board[i][j]>0)    
                 if((j-3) >=0 && (i-3) >= 0  && board[i][j] == board[i-1][j-1] && board[i-2][j-2] == board[i-3][j-3] && board[i][j] == board[i-3][j-3]  ) {
                    player = board[i][j];
                                                            System.out.println("dddddLL " + i + "   " + j );

                }

            }
        }
        return player;
    }
//    

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
    
            for(int i = 0; i <= 5 ;++i){
                for(int j = 0; j <= 6 ;++j){
                    board[i][j] = input.nextInt();

                }
            }
//        System.out.println(ValidatewinUp());
//        System.out.println(ValidatewinRight());
        //System.out.println(ValidatewinLeft());
//         System.out.println(ValidatewinDiagRight());
         System.out.println(ValidatewinDiagleft());


    }
    
}
