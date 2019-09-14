/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author George
 */
import java.util.*;
import java.io.*;
public class pattern {
    
    public static void readFile(String fileN){
        
        try{
            String[][] data=new String[100][2];
            int count=0;
            Scanner myFile =new Scanner(new File(fileN));
            while(myFile.hasNext()){
                String[] temp=myFile.nextLine().split(" ");
                data[count][0]=temp[0];
                data[count][1]=temp[1];
                count++;
            }
            join(data,count);
        
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void join(String[][] data,int count){
        for(int i=0;i<count;i++){
            int fLen=data[i][0].length();
            
            int sLen=data[i][1].length();
            //System.out.println(sLen);
            String newS= new String();
            if(fLen>sLen){
                for(int j=0;j<sLen;j++){
                    
                    newS=newS+data[i][0].charAt(j)+data[i][1].charAt(j)+"";
                }
                newS=newS+data[i][0].substring(sLen);
                //System.out.println(newS);                
            }
            else if(sLen>fLen){
                for(int j=0;j<fLen;j++){
                    
                    newS=newS+data[i][1].charAt(j)+data[i][0].charAt(j)+"";
                }
                newS=newS+data[i][1].substring(fLen);
                //System.out.println(newS);
        
            }
            String out=String.format("%6s : %s",i,newS);
        System.out.println(out);
        }
        
    }
    
    public static void main(String[] args) {
        System.out.println("Please enter the file name");
        Scanner in=new Scanner(System.in);
        String fileN=in.nextLine();
        readFile(fileN);
        
    }
}
