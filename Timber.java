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
import java.math.*;

public class Timber {

    public static void main(String[] args) {
        int obstacles = 0;
        int[][] obs = new int[100][2];
        double m = 0;
        int x = 0;
        int y = 0;
        Scanner in = new Scanner(System.in);
        obstacles = Integer.parseInt(in.nextLine());
        String[] temp = in.nextLine().split(" ");
        int j = 0;
        for (int i = 0; i < obstacles; i++) {

            obs[i][0] = Integer.parseInt(temp[j]);

            obs[i][1] = Integer.parseInt(temp[j + 1]);
            j = j + 2;

        }

        String[] tempTwo = in.nextLine().split(" ");
        x = Integer.parseInt(tempTwo[0]);
        y = Integer.parseInt(tempTwo[1]);
        m = Double.parseDouble(tempTwo[2]);

        double bottom = Math.sqrt((x * x) + (y * y));

        for (int i = 0; i < obstacles; i++) {

            double top = Math.abs((y * obs[i][0]) + (x * obs[i][1]));

            double ans = top / bottom;

            if (ans < m) {
                String out = String.format("Put down the obstacle. Collision at %s,%s)", obs[i][0], obs[i][1]);
                System.out.println(out);
                
                //System.exit(0);
            }
            System.out.println(ans);
        }
        
        System.out.println("Timber!");
        double ans=0.989456;
        String ou=String.format("Hee there %10.2f",ans);
        System.out.println(ou);
    }
}
