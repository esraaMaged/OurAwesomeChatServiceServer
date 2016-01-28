/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.interf;

import java.rmi.Remote;
import java.rmi.RemoteException;
import model.DataBase.ClientDB;

/**
 *
 * @author Deu
 */
public interface ServerInterface extends Remote{
    
    public void register(ClientInterface cI)throws RemoteException;
    public void unregister(ClientInterface cI)throws RemoteException;
    public void sendToAll(String s) throws RemoteException;
    
    public void insertNewUser(ClientDB cb)throws RemoteException;
    public void select()throws RemoteException;
    public void update()throws RemoteException;
    
    
    
}
