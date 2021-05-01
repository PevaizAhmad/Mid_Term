/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerSocket;

import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author Pervaiz Ahmad
 */
public class Client {
    public static void main(String[] args) {
        try{
            Socket s = new Socket("localhost",123);
            DataOutputStream  dout = new DataOutputStream(s.getOutputStream());
            dout.writeUTF("Helo ahmad");
            dout.flush();
            dout.close();
            dout.close();
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    
}
