/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.jeudedame;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

/**
 * Classe de tests pour la classe TourDeJeu
 * @author jujus
 */
public class TourDeJeuTest {
    
    /**
     * Test du constructeur par défaut
     */
    @Test
    @DisplayName("Test du constructeur par défaut")
    public void testConstructeurParDefaut() {
        TourDeJeu tour = new TourDeJeu();
        
        assertNull(tour.getJoueurActif(), "Le joueur actif devrait être null par défaut");
        assertNull(tour.getPositionDepart(), "La position de départ devrait être null par défaut");
        assertNull(tour.getPositionArrivee(), "La position d'arrivée devrait être null par défaut");
        assertEquals(0, tour.getNumeroTour(), "Le numéro de tour devrait être 0 par défaut");
    }

    /**
     * Test du constructeur avec paramètres
     */
    @Test
    @DisplayName("Test du constructeur avec paramètres")
    public void testConstructeurAvecParametres() {
        Joueur joueur = new Joueur("Alice", true);
        TourDeJeu tour = new TourDeJeu(joueur, 5);
        
        assertEquals(joueur, tour.getJoueurActif(), "Le joueur actif devrait être celui passé en paramètre");
        assertEquals(5, tour.getNumeroTour(), "Le numéro de tour devrait être 5");
        assertNull(tour.getPositionDepart(), "La position de départ devrait être null");
        assertNull(tour.getPositionArrivee(), "La position d'arrivée devrait être null");
    }

    /**
     * Test du getter getJoueurActif
     */
    @Test
    @DisplayName("Test du getter getJoueurActif")
    public void testGetJoueurActif() {
        Joueur joueur = new Joueur("Bob", false);
        TourDeJeu tour = new TourDeJeu(joueur, 1);
        
        assertEquals(joueur, tour.getJoueurActif());
    }

    /**
     * Test du getter getPositionDepart
     */
    @Test
    @DisplayName("Test du getter getPositionDepart")
    public void testGetPositionDepart() {
        TourDeJeu tour = new TourDeJeu();
        Point2D position = new Point2D(2, 3);
        tour.setPositionDepart(position);
        
        assertEquals(position, tour.getPositionDepart());
    }

    /**
     * Test du getter getPositionArrivee
     */
    @Test
    @DisplayName("Test du getter getPositionArrivee")
    public void testGetPositionArrivee() {
        TourDeJeu tour = new TourDeJeu();
        Point2D position = new Point2D(4, 5);
        tour.setPositionArrivee(position);
        
        assertEquals(position, tour.getPositionArrivee());
    }

    /**
     * Test du getter getNumeroTour
     */
    @Test
    @DisplayName("Test du getter getNumeroTour")
    public void testGetNumeroTour() {
        TourDeJeu tour = new TourDeJeu();
        assertEquals(0, tour.getNumeroTour());
        
        Joueur joueur = new Joueur("Charlie", true);
        TourDeJeu tour2 = new TourDeJeu(joueur, 10);
        assertEquals(10, tour2.getNumeroTour());
    }

    /**
     * Test du setter setJoueurActif
     */
    @Test
    @DisplayName("Test du setter setJoueurActif")
    public void testSetJoueurActif() {
        TourDeJeu tour = new TourDeJeu();
        assertNull(tour.getJoueurActif());
        
        Joueur joueur = new Joueur("David", true);
        tour.setJoueurActif(joueur);
        assertEquals(joueur, tour.getJoueurActif());
    }

    /**
     * Test du setter setPositionDepart
     */
    @Test
    @DisplayName("Test du setter setPositionDepart")
    public void testSetPositionDepart() {
        TourDeJeu tour = new TourDeJeu();
        assertNull(tour.getPositionDepart());
        
        Point2D position = new Point2D(1, 2);
        tour.setPositionDepart(position);
        assertEquals(position, tour.getPositionDepart());
    }

    /**
     * Test du setter setPositionArrivee
     */
    @Test
    @DisplayName("Test du setter setPositionArrivee")
    public void testSetPositionArrivee() {
        TourDeJeu tour = new TourDeJeu();
        assertNull(tour.getPositionArrivee());
        
        Point2D position = new Point2D(3, 4);
        tour.setPositionArrivee(position);
        assertEquals(position, tour.getPositionArrivee());
    }

    /**
     * Test du setter setNumeroTour
     */
    @Test
    @DisplayName("Test du setter setNumeroTour")
    public void testSetNumeroTour() {
        TourDeJeu tour = new TourDeJeu();
        assertEquals(0, tour.getNumeroTour());
        
        tour.setNumeroTour(15);
        assertEquals(15, tour.getNumeroTour());
        
        tour.setNumeroTour(1);
        assertEquals(1, tour.getNumeroTour());
    }

    /**
     * Test de la méthode estValide avec un tour non valide (positions null)
     */
    @Test
    @DisplayName("Test estValide - Tour non valide (positions null)")
    public void testEstValideNonValide() {
        Joueur joueur = new Joueur("Eve", false);
        TourDeJeu tour = new TourDeJeu(joueur, 1);
        
        assertFalse(tour.estValide(), "Un tour sans positions ne devrait pas être valide");
    }

    /**
     * Test de la méthode estValide avec un tour valide
     */
    @Test
    @DisplayName("Test estValide - Tour valide")
    public void testEstValideValide() {
        Joueur joueur = new Joueur("Frank", true);
        TourDeJeu tour = new TourDeJeu(joueur, 1);
        
        Point2D positionDepart = new Point2D(2, 3);
        Point2D positionArrivee = new Point2D(3, 4);
        
        tour.setPositionDepart(positionDepart);
        tour.setPositionArrivee(positionArrivee);
        
        assertTrue(tour.estValide(), "Un tour avec toutes les informations devrait être valide");
    }

    /**
     * Test de la méthode estValide avec seulement une position de départ
     */
    @Test
    @DisplayName("Test estValide - Seulement position de départ")
    public void testEstValideSeulementDepart() {
        Joueur joueur = new Joueur("Grace", false);
        TourDeJeu tour = new TourDeJeu(joueur, 1);
        
        Point2D positionDepart = new Point2D(2, 3);
        tour.setPositionDepart(positionDepart);
        
        assertFalse(tour.estValide(), "Un tour sans position d'arrivée ne devrait pas être valide");
    }

    /**
     * Test de la méthode estValide avec seulement une position d'arrivée
     */
    @Test
    @DisplayName("Test estValide - Seulement position d'arrivée")
    public void testEstValideSeulementArrivee() {
        Joueur joueur = new Joueur("Henry", true);
        TourDeJeu tour = new TourDeJeu(joueur, 1);
        
        Point2D positionArrivee = new Point2D(3, 4);
        tour.setPositionArrivee(positionArrivee);
        
        assertFalse(tour.estValide(), "Un tour sans position de départ ne devrait pas être valide");
    }

    /**
     * Test de la méthode estValide sans joueur actif
     */
    @Test
    @DisplayName("Test estValide - Sans joueur actif")
    public void testEstValideSansJoueur() {
        TourDeJeu tour = new TourDeJeu();
        
        Point2D positionDepart = new Point2D(2, 3);
        Point2D positionArrivee = new Point2D(3, 4);
        tour.setPositionDepart(positionDepart);
        tour.setPositionArrivee(positionArrivee);
        
        assertFalse(tour.estValide(), "Un tour sans joueur actif ne devrait pas être valide");
    }

    /**
     * Test de la méthode reinitialiser
     */
    @Test
    @DisplayName("Test de la méthode reinitialiser")
    public void testReinitialiser() {
        Joueur joueur = new Joueur("Iris", true);
        TourDeJeu tour = new TourDeJeu(joueur, 5);
        
        Point2D positionDepart = new Point2D(1, 2);
        Point2D positionArrivee = new Point2D(3, 4);
        tour.setPositionDepart(positionDepart);
        tour.setPositionArrivee(positionArrivee);
        
        // Vérifier que le tour est valide avant réinitialisation
        assertTrue(tour.estValide());
        
        // Réinitialiser
        tour.reinitialiser();
        
        // Vérifier que les positions sont remises à null
        assertNull(tour.getPositionDepart(), "La position de départ devrait être null après réinitialisation");
        assertNull(tour.getPositionArrivee(), "La position d'arrivée devrait être null après réinitialisation");
        assertFalse(tour.estValide(), "Le tour ne devrait plus être valide après réinitialisation");
    }

    /**
     * Test de la méthode toString
     */
    @Test
    @DisplayName("Test de la méthode toString")
    public void testToString() {
        Joueur joueur = new Joueur("Jack", false);
        TourDeJeu tour = new TourDeJeu(joueur, 3);
        
        Point2D positionDepart = new Point2D(2, 3);
        Point2D positionArrivee = new Point2D(4, 5);
        tour.setPositionDepart(positionDepart);
        tour.setPositionArrivee(positionArrivee);
        
        String result = tour.toString();
        
        assertNotNull(result, "toString ne devrait pas retourner null");
        assertTrue(result.contains("3"), "toString devrait contenir le numéro de tour");
    }

    /**
     * Test de la méthode toString avec un tour incomplet
     */
    @Test
    @DisplayName("Test toString - Tour incomplet")
    public void testToStringTourIncomplet() {
        Joueur joueur = new Joueur("Kate", true);
        TourDeJeu tour = new TourDeJeu(joueur, 1);
        
        String result = tour.toString();
        
        assertNotNull(result, "toString ne devrait pas retourner null même pour un tour incomplet");
    }

    /**
     * Test de modification du joueur actif en cours de partie
     */
    @Test
    @DisplayName("Test modification du joueur actif")
    public void testModificationJoueurActif() {
        Joueur joueur1 = new Joueur("Leo", true);
        Joueur joueur2 = new Joueur("Mike", false);
        
        TourDeJeu tour = new TourDeJeu(joueur1, 1);
        assertEquals(joueur1, tour.getJoueurActif());
        
        tour.setJoueurActif(joueur2);
        assertEquals(joueur2, tour.getJoueurActif());
        assertNotEquals(joueur1, tour.getJoueurActif());
    }

    /**
     * Test avec positions identiques
     */
    @Test
    @DisplayName("Test avec positions identiques (départ = arrivée)")
    public void testPositionsIdentiques() {
        Joueur joueur = new Joueur("Nina", true);
        TourDeJeu tour = new TourDeJeu(joueur, 1);
        
        Point2D position = new Point2D(3, 3);
        tour.setPositionDepart(position);
        tour.setPositionArrivee(position);
        
        // Le tour est techniquement valide même si les positions sont identiques
        assertTrue(tour.estValide());
    }

    /**
     * Test de numéro de tour négatif
     */
    @Test
    @DisplayName("Test avec numéro de tour négatif")
    public void testNumeroTourNegatif() {
        Joueur joueur = new Joueur("Oscar", false);
        TourDeJeu tour = new TourDeJeu(joueur, -1);
        
        assertEquals(-1, tour.getNumeroTour(), "Le numéro de tour devrait pouvoir être négatif");
    }

    /**
     * Test de cohérence après plusieurs réinitialisations
     */
    @Test
    @DisplayName("Test cohérence après réinitialisations multiples")
    public void testReinitialisationsMultiples() {
        Joueur joueur = new Joueur("Paul", true);
        TourDeJeu tour = new TourDeJeu(joueur, 1);
        
        Point2D pos1 = new Point2D(1, 1);
        Point2D pos2 = new Point2D(2, 2);
        
        // Premier cycle
        tour.setPositionDepart(pos1);
        tour.setPositionArrivee(pos2);
        assertTrue(tour.estValide());
        tour.reinitialiser();
        assertFalse(tour.estValide());
        
        // Deuxième cycle
        tour.setPositionDepart(pos2);
        tour.setPositionArrivee(pos1);
        assertTrue(tour.estValide());
        tour.reinitialiser();
        assertFalse(tour.estValide());
        
        // Le joueur actif devrait toujours être présent
        assertEquals(joueur, tour.getJoueurActif());
    }
}
