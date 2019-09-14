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

public class Secrets {

    public static void readFile(String fileN, String[] pos) {
        try {
            //ArrayList<String> sentences=new ArrayList();
            String paragraph = "";
            Scanner myFile = new Scanner(new File(fileN));
            while (myFile.hasNext()) {
                paragraph += myFile.nextLine();

            }
            String[] sentences = paragraph.split("!|,|\\.|\\?");
            for (int i = 0; i < sentences.length; i++) {
                sentences[i] = sentences[i].trim();

            }
            String newS = "";
            for (int i = 0; i < pos.length; i++) {
                String[] temp = sentences[i].split(" ");

                System.out.println(temp[i] + "    " + temp.length + "        " + Integer.parseInt(pos[i]));
                if (Integer.parseInt(pos[i]) > temp.length) {
                    newS = newS + ".";
                } else if (i == 0) {
                    newS = temp[Integer.parseInt(pos[i]) - 1];
                    //System.out.println(newS);
                } else {
                    newS = newS + " " + temp[Integer.parseInt(pos[i]) - 1];
                    System.out.println(newS);
                }
            }
            System.out.println(newS);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String fileN = in.nextLine();

        String position = in.nextLine();
        String[] pos = position.split(" ");
        readFile(fileN, pos);

    }
}
