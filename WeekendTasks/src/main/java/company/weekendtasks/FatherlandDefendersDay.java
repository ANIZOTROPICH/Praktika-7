/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package company.weekendtasks;

/**
 *
 * @author Andrey
 */
import company.weekendtasks.ValentinsDay;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
class Gamer {
    private final String name;
    private boolean alive;
    public Gamer(String gamerName){
        name = gamerName;
        alive = true;
    }
    public String getName(){
        return name;
    }
    public void toDie(){
        alive = false;
    }
    public boolean isAlive(){
        return alive;
    }
}
public class FatherlandDefendersDay {
    public static void russianRoulette(ArrayList<Gamer> gamers) throws FileNotFoundException, IOException{
    	ValentinsDay.loadFile("C:\\WeekendTasks\\src\\main\\java\\company\\weekendtasks\\ascii_arts _dead.txt");
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        int bullet = r.nextInt(6);
        int push = r.nextInt(6);
        int n = gamers.size();
        while (n > 1){
            for (Gamer g: gamers){
                if (g.isAlive()){
                    System.out.println("Hey, " + g.getName() + "! Roll and push(1) or just push(any number, except 1)?");
                    if (sc.nextInt() == 1) push = r.nextInt();
                    else push = (push + 1) % 6;
                    if (push == bullet) {
                        g.toDie();
                        
                        String name = g.getName();
                        String congratulation = g.getName() + ", you,re dead! Good night";
                        String filename = "C:\\Users\\demya\\Desktop\\" + "To" + g.getName() + ".txt";
                        ValentinsDay.toSaveCongratulation(filename, name, congratulation);
                        System.out.println(g.getName() + ", you,re dead! Good night");
                        n -= 1;
                        bullet = r.nextInt(6);
                    }
                }
            }
        }
        
        for (Gamer g: gamers) if (g.isAlive()) { System.out.println(g.getName() + " - WINNER!!!");
        String name = g.getName();
        String filename = "C:\\Users\\demya\\Desktop\\" + "To" + g.getName() + ".txt";
        String win = g.getName() + ", You are the WINNER";
        ValentinsDay.toSaveCongratulation(filename, name, win);}
    }
}
