
package company.weekendtasks;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andrey
 */
import java.io.*;
import java.util.Random;
import java.util.ArrayList;
public class ValentinsDay {
    public static ArrayList<String> arts = new ArrayList<String>();
    public static void toCongratulate(String name){
        System.out.println("I love you, " + name);
    }
    public static void loadFile(String filename) throws IOException, FileNotFoundException {
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        String art = in.readLine() + "\n";
        while((s = in.readLine()) != null){
            if (!s.isEmpty()) art += s + "\n";
            else {
                arts.add(art);
                art = "";
            }
        }
        in.close();
    }
    public static String pickRandomArt(){
        int n = arts.size();
        Random r = new Random();
        return arts.get(r.nextInt(n));
        
    }
    public static void toSaveCongratulation(String filename, String name, String congratulation) throws IOException, FileNotFoundException {
        FileWriter out = new FileWriter(filename);
        String art = pickRandomArt();
        out.write(art + "\n");
        out.write(congratulation + "\n");
        out.write(name);
        out.close();
    }
}
