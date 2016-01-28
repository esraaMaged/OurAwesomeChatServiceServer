/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.interf;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Deu
 */
public interface ClientInterface extends Remote{
    
    public void recieve(String s)throws RemoteException;
    
}
