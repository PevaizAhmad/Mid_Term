/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerSocket;

import java.io.DataInputStream;
import java.net.Socket;
import java.net.ServerSocket;

/**
 *
 * @author Pervaiz Ahmad
 */
public class Server {
    public static void main(String[] args) {
        try{
        
            while(true)
            {
                ServerSocket ss= new ServerSocket(123);
                System.out.println("Going to establish connection \n\n");
                Socket s= ss.accept();
                System.out.println("Established");
                
                DataInputStream dis = new DataInputStream(s.getInputStream());
                String str = (String) dis.readUTF();
                System.out.println("message : "+str);
                
                if(str.equalsIgnoreCase("end"))
                {
                    ss.close();
                }
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    
}
