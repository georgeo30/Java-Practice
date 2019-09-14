/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author George
 */
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
public class Griddle {
    
    public static void gridF(int x,int y,String fileN,String codee){
        
        String[][] grid=new String[x][y];
        ArrayList<String> words=new ArrayList();
        
        try{
            Scanner myFile=new Scanner(new File(fileN));
            String line;
            while(myFile.hasNext()){
                String[] word=myFile.nextLine().split(" ");
                for(int i=0;i<word.length;i++){
                    words.add(word[i]);
                }
                
            }
            int size=words.size();
            int wordC=0;
            label1:
            for(int i=0;i<x;i++){
                label2:
                for (int j=0;j<y;j++){
                    if(wordC>=size){
                        break label1;
                    }
                    else{
                        grid[i][j]=words.get(wordC);
                        wordC++;
                    }
                    
                }
            }
            for(int i =0;i<x;i++){
                for (int j=0;j<y;j++){
                    System.out.println(grid[i][j]);
                }
            }
            String[] coords=codee.split(" ");
            System.out.println(coords.length);
            for (int i=0;i<coords.length;i=i+2){
                int xc=Integer.parseInt(coords[i+1]);
                int yc=Integer.parseInt(coords[i]);
                System.out.print(grid[xc][yc]+ " ");
                
            }
            
            
        }
        catch(Exception e){
            System.out.println("Error");
        }
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the filename:");
        String fileN=in.nextLine();
        System.out.println("Enter the grid width and height:");
        int x=in.nextInt();
        int y=in.nextInt();
        //System.out.println("Enter the coded message:");
        String code=in.nextLine();
        System.out.println("Enter the coded message:");
        String codee=in.nextLine();
        System.out.println(code);
        System.out.println(codee);
        gridF(y,x,fileN,codee);
        
                
    }
}
