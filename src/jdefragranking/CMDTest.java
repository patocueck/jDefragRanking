/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmdtest;

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
            
/*            ShellExec exec = new ShellExec(true, false);
            exec.execute("D:\\ioquake3\\defrag-mp.bat", null, true);
            System.out.println(exec.getOutput());
*/


            ProcessBuilder pb = new ProcessBuilder("D:\\ioquake3\\defrag-mp.bat");
            Process p = pb.start();
            
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedWriter output = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
            BufferedReader error = new BufferedReader(new InputStreamReader(p.getErrorStream()));
                        
            Listener listen = new Listener();
            String line2 = "";
            int count = 0;
            
            while ((line = error.readLine() ) != null && (line.length() > 0 || count == 21) || count == 57) {
                count++;
                System.out.println(line); 
            }
            output.write("say ===========TOP========");
            output.newLine();
            output.flush();
            
            while ((line2 = error.readLine() ) != null && line2.length() > 0) {
                System.out.println(line2); 
            }

            p.destroy();

        }
        catch (IOException e){
            System.out.println("IOException e: " + e.getLocalizedMessage());
        }catch (Exception e){
            System.out.println("Exception e: " + e.getLocalizedMessage());
        }
        
        
    }
    
}
