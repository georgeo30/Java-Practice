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
public class passwordSerial {
    public static void writeFile(String password){
        try{
            FileWriter myFile=new FileWriter("passwords.txt",true);
            myFile.write(password+" ");
            myFile.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        char[] specialChars={'_','@','%','!'};
        
        for(char i='a'; i<='z';i++){
            for(int j=0;j<10;j++){
                for(char k=0;k<specialChars.length;k++){
                    writeFile(i+""+j+""+specialChars[k]+" ");
                }
            }
        }
        
    }
    
}
