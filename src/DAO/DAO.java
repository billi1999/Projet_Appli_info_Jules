/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Jules
 */
public abstract class DAO<T> {

    protected Connection dbConnect;

    /**
     * méthode premettant d'établir la connexion avec la base de donnée de
     * l'application principale
     *
     * @param newdbConnect connexion à la base de données
     */
    public void setConnection(Connection newdbConnect) {
        dbConnect = newdbConnect;
    }
/**
 * Permet de récupérer un objet grâce à son id
 * @param id
 * @return
 * @throws SQLException 
 */
    public abstract T read(int id) throws SQLException;
/**
 * Permet de créer un objet
 * @param obj
 * @return
 * @throws SQLException 
 */
    public abstract T create(T obj) throws SQLException;
/**
 * Permet de mettre à jour un objet
 * @param obj
 * @return
 * @throws SQLException 
 */
    public abstract T update(T obj) throws SQLException;
/**
 * Permet de supprimer un objet d'une entrée
 * @param obj
 * @throws SQLException 
 */
    public abstract void delete(T obj) throws SQLException;

}
