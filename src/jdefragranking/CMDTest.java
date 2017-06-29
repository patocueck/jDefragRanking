/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdefragranking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * @author pzunigap
 */
public class CMDTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String line = "";
        try {
            //ProcessBuilder pb = new ProcessBuilder("cmd.exe");
            //Process p = pb.start();
            
            Process p = Runtime.getRuntime().exec("cmd.exe");
            
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedWriter output = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
            BufferedReader error = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            
            //line = input.readLine();
            //while ((line = input.readLine()) != null) {
                //System.out.println(line);
            //}

            //output.write("D:\\ioquake3\\defrag\\misc\\misc\\defrag-serverdocs\\files\\defrag-mp.bat");
            //output.write("d:\\ioquake3\\ioq3ded.x86.exe");
//            output.write("D:");
//            output.newLine();
//            output.flush();
//            output.write("cd D:\\ioquake3");
//            output.newLine();
//            output.flush();
//            output.write("ioq3ded.x86.exe");
//            output.newLine();
//            output.flush();
            output.write("dir");
            output.newLine();
            output.flush();
            
            Listener listen = new Listener();
//            while ((line = error.readLine()) != null) {
//                System.out.println(line);
//            }
            while ((line = input.readLine()) != null) {
                
                String cmd = listen.readCommand(line);
                cmd="top";
                if (cmd == null) 
                    continue;
                
                if (cmd.equalsIgnoreCase("top")){
                    output.write("say ===========TOP========");
                    output.newLine();
                    output.flush();
                    output.write("say 1) 10:00 Hoopz");
                    output.newLine();
                    output.flush();
                }
                
                System.out.println(line);
            }

            p.destroy();
        }
        catch (IOException e){
        }
        
    }
    
}
