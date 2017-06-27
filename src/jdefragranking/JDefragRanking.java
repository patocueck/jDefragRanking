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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pato
 */
public class JDefragRanking {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        
//        // A Runtime object has methods for dealing with the OS
//        Runtime r = Runtime.getRuntime();
//        Process p;     // Process tracks one external native process
//        BufferedReader is;  // reader for output of process
//        String line;
//
//        // Our argv[0] contains the program to run; remaining elements
//        // of argv contain args for the target program. This is just
//        // what is needed for the String[] form of exec.
//        p = r.exec(args);
//
//        System.out.println("In Main after exec");
//
//        // getInputStream gives an Input stream connected to
//        // the process p's standard output. Just use it to make
//        // a BufferedReader to readLine() what the program writes out.
//        is = new BufferedReader(new InputStreamReader(p.getInputStream()));
//
//        while ((line = is.readLine()) != null)
//          System.out.println(line);
//
//        System.out.println("In Main after EOF");
//        System.out.flush();
//        try {
//          p.waitFor();  // wait for process to complete
//        } catch (InterruptedException e) {
//          System.err.println(e);  // "Can'tHappen"
//          return;
//        }
//        System.err.println("Process done, exit status was " + p.exitValue());
//        return;


//==============================================================================


        ProcessBuilder   ps=new ProcessBuilder("cmd.exe", "/c d:\\ioquake3\\ioq3ded.x86.exe");

        //From the DOC:  Initially, this property is false, meaning that the 
        //standard output and error output of a subprocess are sent to two 
        //separate streams
        ps.redirectErrorStream(true);

        Process pr = ps.start();  

        BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(line);
        }
        pr.waitFor();
        System.out.println("ok!");

        in.close();
        System.exit(0);

//==========================================================================

//        Runtime rt = Runtime.getRuntime();
//        //String[] commands = {"cmd.exe","-get t"};
//        String[] commands = {"cmd.exe"," dir "};
//        Process proc = null;
//        try {
//            proc = rt.exec(commands);
//        } catch (IOException ex) {
//            Logger.getLogger(JDefragRanking.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        BufferedReader stdInput = new BufferedReader(new 
//             InputStreamReader(proc.getInputStream()));
//
//        BufferedReader stdError = new BufferedReader(new 
//             InputStreamReader(proc.getErrorStream()));
//
//        // read the output from the command
//        System.out.println("Here is the standard output of the command:\n");
//        String s = null;
//        while ((s = stdInput.readLine()) != null) {
//            System.out.println(s);
//        }
//
//        // read any errors from the attempted command
//        System.out.println("Here is the standard error of the command (if any):\n");
//        while ((s = stdError.readLine()) != null) {
//            System.out.println(s);
//        }
    }
    
}
