/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.jeudedame;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

/**
 * Classe de tests pour la classe Joueur
 * @author jujus
 */
public class JoueurTest {
    
    /**
     * Test du constructeur par défaut
     */
    @Test
    @DisplayName("Test du constructeur par défaut")
    public void testConstructeurParDefaut() {
        Joueur joueur = new Joueur();
        assertEquals("", joueur.getNom(), "Le nom par défaut devrait être une chaîne vide");
        assertTrue(joueur.getCouleur(), "La couleur par défaut devrait être Noir (true)");
    }

    /**
     * Test du constructeur avec paramètres
     */
    @Test
    @DisplayName("Test du constructeur avec paramètres - Joueur Noir")
    public void testConstructeurAvecParametresNoir() {
        Joueur joueur = new Joueur("Alice", true);
        assertEquals("Alice", joueur.getNom());
        assertTrue(joueur.getCouleur());
    }

    /**
     * Test du constructeur avec paramètres pour un joueur Blanc
     */
    @Test
    @DisplayName("Test du constructeur avec paramètres - Joueur Blanc")
    public void testConstructeurAvecParametresBlanc() {
        Joueur joueur = new Joueur("Bob", false);
        assertEquals("Bob", joueur.getNom());
        assertFalse(joueur.getCouleur());
    }

    /**
     * Test du constructeur de copie
     */
    @Test
    @DisplayName("Test du constructeur de copie")
    public void testConstructeurDeCopie() {
        Joueur original = new Joueur("Charlie", true);
        Joueur copie = new Joueur(original);
        
        assertEquals(original.getNom(), copie.getNom());
        assertEquals(original.getCouleur(), copie.getCouleur());
        assertNotSame(original, copie, "La copie devrait être un objet différent");
    }

    /**
     * Test du getter getNom
     */
    @Test
    @DisplayName("Test du getter getNom")
    public void testGetNom() {
        Joueur joueur = new Joueur("David", false);
        assertEquals("David", joueur.getNom());
    }

    /**
     * Test du getter getCouleur pour Noir
     */
    @Test
    @DisplayName("Test du getter getCouleur - Noir")
    public void testGetCouleurNoir() {
        Joueur joueur = new Joueur("Eve", true);
        assertTrue(joueur.getCouleur());
    }

    /**
     * Test du getter getCouleur pour Blanc
     */
    @Test
    @DisplayName("Test du getter getCouleur - Blanc")
    public void testGetCouleurBlanc() {
        Joueur joueur = new Joueur("Frank", false);
        assertFalse(joueur.getCouleur());
    }

    /**
     * Test du setter setCouleur
     */
    @Test
    @DisplayName("Test du setter setCouleur")
    public void testSetCouleur() {
        Joueur joueur = new Joueur("Grace", true);
        assertTrue(joueur.getCouleur());
        
        joueur.setCouleur(false);
        assertFalse(joueur.getCouleur(), "La couleur devrait être changée à Blanc (false)");
        
        joueur.setCouleur(true);
        assertTrue(joueur.getCouleur(), "La couleur devrait être changée à Noir (true)");
    }

    /**
     * Test de la méthode toString pour un joueur Noir
     */
    @Test
    @DisplayName("Test toString - Joueur Noir")
    public void testToStringNoir() {
        Joueur joueur = new Joueur("Henry", true);
        String result = joueur.toString();
        assertTrue(result.contains("Henry"), "Le nom devrait apparaître dans toString");
        assertTrue(result.contains("Noir"), "La couleur 'Noir' devrait apparaître dans toString");
    }

    /**
     * Test de la méthode toString pour un joueur Blanc
     */
    @Test
    @DisplayName("Test toString - Joueur Blanc")
    public void testToStringBlanc() {
        Joueur joueur = new Joueur("Iris", false);
        String result = joueur.toString();
        assertTrue(result.contains("Iris"), "Le nom devrait apparaître dans toString");
        assertTrue(result.contains("Blanc"), "La couleur 'Blanc' devrait apparaître dans toString");
    }

    /**
     * Test de la méthode equals - Deux joueurs identiques
     */
    @Test
    @DisplayName("Test equals - Joueurs identiques")
    public void testEqualsJoueursIdentiques() {
        Joueur joueur1 = new Joueur("Jack", true);
        Joueur joueur2 = new Joueur("Jack", true);
        
        assertTrue(joueur1.equals(joueur2), "Deux joueurs avec le même nom et la même couleur devraient être égaux");
    }

    /**
     * Test de la méthode equals - Joueurs différents (nom différent)
     */
    @Test
    @DisplayName("Test equals - Noms différents")
    public void testEqualsNomsDifferents() {
        Joueur joueur1 = new Joueur("Kate", true);
        Joueur joueur2 = new Joueur("Leo", true);
        
        assertFalse(joueur1.equals(joueur2), "Deux joueurs avec des noms différents ne devraient pas être égaux");
    }

    /**
     * Test de la méthode equals - Joueurs différents (couleur différente)
     */
    @Test
    @DisplayName("Test equals - Couleurs différentes")
    public void testEqualsCouleursDifferentes() {
        Joueur joueur1 = new Joueur("Mike", true);
        Joueur joueur2 = new Joueur("Mike", false);
        
        assertFalse(joueur1.equals(joueur2), "Deux joueurs avec le même nom mais des couleurs différentes ne devraient pas être égaux");
    }

    /**
     * Test de la méthode equals avec null
     */
    @Test
    @DisplayName("Test equals avec null")
    public void testEqualsAvecNull() {
        Joueur joueur = new Joueur("Nina", true);
        assertFalse(joueur.equals(null), "Un joueur ne devrait pas être égal à null");
    }

    /**
     * Test de la méthode equals avec le même objet
     */
    @Test
    @DisplayName("Test equals avec le même objet")
    public void testEqualsMemeObjet() {
        Joueur joueur = new Joueur("Oscar", true);
        assertTrue(joueur.equals(joueur), "Un joueur devrait être égal à lui-même");
    }

    /**
     * Test de la méthode equals avec un objet d'un autre type
     */
    @Test
    @DisplayName("Test equals avec un objet d'un autre type")
    public void testEqualsAutreType() {
        Joueur joueur = new Joueur("Paul", true);
        String autreObjet = "Pas un joueur";
        assertFalse(joueur.equals(autreObjet), "Un joueur ne devrait pas être égal à un objet d'un autre type");
    }

    /**
     * Test de la méthode hashCode - Joueurs identiques ont le même hashCode
     */
    @Test
    @DisplayName("Test hashCode - Joueurs identiques")
    public void testHashCodeJoueursIdentiques() {
        Joueur joueur1 = new Joueur("Quinn", true);
        Joueur joueur2 = new Joueur("Quinn", true);
        
        assertEquals(joueur1.hashCode(), joueur2.hashCode(), 
                "Deux joueurs égaux devraient avoir le même hashCode");
    }

    /**
     * Test de la méthode hashCode - Joueurs différents
     */
    @Test
    @DisplayName("Test hashCode - Joueurs différents")
    public void testHashCodeJoueursDifferents() {
        Joueur joueur1 = new Joueur("Rose", true);
        Joueur joueur2 = new Joueur("Sam", false);
        
        // Note: Ce test peut échouer dans de rares cas de collision
        assertNotEquals(joueur1.hashCode(), joueur2.hashCode(), 
                "Deux joueurs différents devraient généralement avoir des hashCodes différents");
    }

    /**
     * Test de cohérence entre equals et hashCode
     */
    @Test
    @DisplayName("Test cohérence equals et hashCode")
    public void testCoherenceEqualsHashCode() {
        Joueur joueur1 = new Joueur("Tom", true);
        Joueur joueur2 = new Joueur("Tom", true);
        
        if (joueur1.equals(joueur2)) {
            assertEquals(joueur1.hashCode(), joueur2.hashCode(), 
                    "Si deux objets sont égaux selon equals, leurs hashCodes doivent être égaux");
        }
    }
}
