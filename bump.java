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
public class bump {
    public static void readFile(String fileN){
        String[][] bots=new String[100][100];
        int botsT=0;
        String[][] bumps=new String[100][100];
        int bumpsT=0;
        try{
            Scanner myFile=new Scanner(new FileReader(fileN));
            String line;
            int end=0;
            
            while (myFile.hasNext()){
                line=myFile.nextLine();
                
                if(line.equals("----")){
                    end++;
                    continue;
                }
                if(end==0){
                    
                    String[] temp=line.split(" ");
                    bots[botsT][0]=temp[0];                   
                    bots[botsT][1]=temp[1];                   
                    botsT++;
                }
                else if(end==1){
                    
                    String[] temp=line.split(" ");
                    bumps[bumpsT][0]=temp[0];
                    bumps[bumpsT][1]=temp[1];
                    bumpsT++;
                }
            }
            
            
        }
        
        catch(Exception e){
            System.out.println("Eroor reading file");
        }
        
        
       calc(bots,bumps,botsT,bumpsT);
                
    }
    
    public static void calc(String[][] bots,String[][] bumps,int botsT,int bumpsT){
        for(int i=0;i<bumpsT;i++){
            String fBot=bumps[i][0];
            String sBot=bumps[i][1];
            int fBotVal=0;
            int fBotT=0;
            int sBotVal=0;
            int sBotT=0;
            for(int j=0;j<botsT;j++){
                if(bots[j][0].equals(fBot)){
                    fBotVal=Integer.parseInt(bots[j][1]);
                    fBotT=j;
                    
                }
                if(bots[j][0].equals(sBot)){
                    sBotVal=Integer.parseInt(bots[j][1]);
                    sBotT=j;
                }
            }
            
            if(fBotVal==sBotVal){
                continue;
            }
            else if(fBotVal>sBotVal&&fBotVal<5){
                sBotVal=sBotVal+fBotVal;
                fBotVal=0;
                bots[fBotT][1]=fBotVal+"";
                bots[sBotT][1]=sBotVal+"";
            }
            else if(sBotVal>fBotVal&&sBotVal<5){
                fBotVal=fBotVal+sBotVal;
                sBotVal=0;
                bots[fBotT][1]=fBotVal+"";
                bots[sBotT][1]=sBotVal+"";
            }
            else if(fBotVal>sBotVal){
                
                fBotVal=fBotVal-5;
                sBotVal=sBotVal+5;
                bots[fBotT][1]=fBotVal+"";
                bots[sBotT][1]=sBotVal+"";
            }
            else if(sBotVal>fBotVal){
                sBotVal=sBotVal-5;
                fBotVal=fBotVal+5;
                bots[fBotT][1]=fBotVal+"";
                bots[sBotT][1]=sBotVal+"";
            }
        }
        
        for (int i=0;i<botsT;i++){
            String ans=String.format("%-10s : %2s",bots[i][0],bots[i][1]);
            System.out.println(ans);
        }
    }
    
    public static void main(String[] args){
        Scanner in =new Scanner(System.in);
        System.out.println("Enter the filename");
        String fileN=in.nextLine();
        readFile(fileN);
        System.out.println("DONE");
        
    }
    
}
