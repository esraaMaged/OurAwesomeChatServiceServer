/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import model.DataBase.ClientDB;
import model.interf.ClientInterface;
import model.interf.ServerInterface;
import oracle.jdbc.OracleDriver;

/**
 *
 * @author Deu
 */
public class ServerImpelmentMod extends UnicastRemoteObject implements ServerInterface {

    Connection con;
    Statement stmt;
    String queryString;

    static Vector<ClientInterface> clientsVector = new Vector<ClientInterface>();

    public ServerImpelmentMod() throws RemoteException {

        //---------------connecting to DataBase--------------------------
        try {
            DriverManager.registerDriver(new OracleDriver());
            con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "es", "pass");
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (SQLException ex) {
            System.out.println("can't connect to DataBase");
        }
        //---------------end of connecting to DataBase--------------------------
    }

    //-----------------------connection methods-----------------
    @Override
    public void sendToAll(String s) throws RemoteException {

        for (ClientInterface ch : clientsVector) {
            ch.recieve(s);
        }
    }

    @Override
    public void register(ClientInterface cI) throws RemoteException {
        clientsVector.add(cI);
    }

    @Override
    public void unregister(ClientInterface cI) throws RemoteException {
        clientsVector.remove(cI);
    }
    //-----------------------end of connection methods-----------------

    //-----------------------dataBase methods-----------------
    @Override
    public void insertNewUser(ClientDB cb) throws RemoteException {
        System.out.println("fname="+cb.getFname());
        System.out.println("lastname="+cb.getLname());
    }

    @Override
    public void select() throws RemoteException {
    }

    @Override
    public void update() throws RemoteException {
    }
    //-----------------------end of dataBase methods-----------------

}
