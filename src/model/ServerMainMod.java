/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Deu
 */
public class ServerMainMod {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new ServerMainMod();
    }
    public ServerMainMod()
    {
        try
        {
            ServerImpelmentMod impelObj= new ServerImpelmentMod();
            Registry reg=LocateRegistry.createRegistry(1099);
            reg.bind("OurAwesomeChatService", impelObj);           
        }
        catch(Exception ex)
        {
            System.out.println("error: can't start Server!"); 
            ex.printStackTrace();
        }
    }
    
}
