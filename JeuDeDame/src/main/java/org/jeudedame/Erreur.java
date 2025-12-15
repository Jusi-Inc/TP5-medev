/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.jeudedame;

import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author nathan
 */
public class Erreur extends Exception{
    private final String texte;
    private static final Logger logger = Logger.getLogger(Erreur.class.getName());
    
    public Erreur(String texte){
        this.texte="Une erreur est survenue"+texte;
        logger.log(Level.SEVERE, this.texte);
    }
}
