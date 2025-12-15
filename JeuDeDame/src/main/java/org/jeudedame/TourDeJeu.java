/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.jeudedame;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe représentant un tour de jeu dans une partie de dames
 * Gère l'interaction avec le joueur pour effectuer son coup
 * @author jujus
 */
public class TourDeJeu {
    
    // Attributs
    private Joueur joueurActif;
    private Point2D positionDepart;
    private Point2D positionArrivee;
    private int numeroTour;
    
    /**
     * Constructeur par défaut
     */
    public TourDeJeu() {
        this.joueurActif = null;
        this.positionDepart = null;
        this.positionArrivee = null;
        this.numeroTour = 0;
    }
    
    /**
     * Constructeur avec paramètres
     * @param joueurActif Le joueur qui effectue le tour
     * @param numeroTour Le numéro du tour
     */
    public TourDeJeu(Joueur joueurActif, int numeroTour) {
        this.joueurActif = joueurActif;
        this.positionDepart = null;
        this.positionArrivee = null;
        this.numeroTour = numeroTour;
    }
    
    // Getters
    /**
     * Obtient le joueur actif
     * @return Le joueur qui joue ce tour
     */
    public Joueur getJoueurActif() {
        return joueurActif;
    }
    
    /**
     * Obtient la position de départ
     * @return La position de départ de la pièce
     */
    public Point2D getPositionDepart() {
        return positionDepart;
    }
    
    /**
     * Obtient la position d'arrivée
     * @return La position d'arrivée de la pièce
     */
    public Point2D getPositionArrivee() {
        return positionArrivee;
    }
    
    /**
     * Obtient le numéro du tour
     * @return Le numéro du tour
     */
    public int getNumeroTour() {
        return numeroTour;
    }
    
    // Setters
    /**
     * Définit le joueur actif
     * @param joueurActif Le joueur qui joue
     */
    public void setJoueurActif(Joueur joueurActif) {
        this.joueurActif = joueurActif;
    }
    
    /**
     * Définit la position de départ
     * @param positionDepart La position de départ
     */
    public void setPositionDepart(Point2D positionDepart) {
        this.positionDepart = positionDepart;
    }
    
    /**
     * Définit la position d'arrivée
     * @param positionArrivee La position d'arrivée
     */
    public void setPositionArrivee(Point2D positionArrivee) {
        this.positionArrivee = positionArrivee;
    }
    
    /**
     * Définit le numéro du tour
     * @param numeroTour Le numéro du tour
     */
    public void setNumeroTour(int numeroTour) {
        this.numeroTour = numeroTour;
    }
    
    // Méthodes métier
    
    /**
     * Affiche la grille du jeu de dames
     * @param pions La liste des pions sur le plateau
     */
    private void afficherGrille(ArrayList<Pion> pions) {
        System.out.println("\n╔════════════════════════════════════════╗"); //NOSONAR
        System.out.println("║         GRILLE DE JEU DE DAMES        ║"); //NOSONAR
        System.out.println("╠════════════════════════════════════════╣"); //NOSONAR
        System.out.println("║    A  B  C  D  E  F  G  H  I  J       ║"); //NOSONAR
        System.out.println("╟────────────────────────────────────────╢"); //NOSONAR
        
        for (int i = 0; i < 10; i++) {
            afficherLigne(pions, i);
        }
        
        System.out.println("╚════════════════════════════════════════╝");//NOSONAR
    }
    
    /**
     * Affiche une ligne du plateau de jeu
     * @param pions La liste des pions
     * @param ligne Le numéro de ligne à afficher (0-9)
     */
    private void afficherLigne(ArrayList<Pion> pions, int ligne) {
        System.out.print("║ " + (ligne + 1));//NOSONAR
        if (ligne < 9) System.out.print(" ");//NOSONAR
        
        for (int colonne = 0; colonne < 10; colonne++) {
            System.out.print(" ");//NOSONAR
            afficherCellule(pions, ligne, colonne);
        }
        System.out.println("   ║");//NOSONAR
    }
    
    /**
     * Affiche une cellule du plateau (pion ou case vide)
     * @param pions La liste des pions
     * @param ligne La ligne de la cellule
     * @param colonne La colonne de la cellule
     */
    private void afficherCellule(ArrayList<Pion> pions, int ligne, int colonne) {
        Pion pionAPosition = trouverPionAPosition(pions, ligne, colonne);
        
        if (pionAPosition == null) {
            afficherCaseVide(ligne, colonne);
        } else {
            afficherPion(pionAPosition);
        }
    }
    
    /**
     * Affiche une case vide (noire ou blanche)
     * @param ligne La ligne de la case
     * @param colonne La colonne de la case
     */
    private void afficherCaseVide(int ligne, int colonne) {
        if ((ligne + colonne) % 2 == 0) {
            System.out.print("□ "); //NOSONAR // Case blanche (non jouable)
        } else {
            System.out.print("■ "); //NOSONAR // Case noire (jouable)
        }
    }
    
    /**
     * Affiche un pion selon sa couleur
     * @param pion Le pion à afficher
     */
    private void afficherPion(Pion pion) {
        if (pion.getCouleur() == 0) {
            System.out.print("○ "); //NOSONAR // Pion blanc
        } else {
            System.out.print("● "); //NOSONAR // Pion noir
        }
    }
    
    /**
     * Trouve un pion à une position donnée dans la liste
     * @param pions La liste des pions
     * @param x La coordonnée x (ligne)
     * @param y La coordonnée y (colonne)
     * @return Le pion à cette position ou null si aucun
     */
    private Pion trouverPionAPosition(ArrayList<Pion> pions, int x, int y) {
        for (Pion pion : pions) {
            Point2D pos = pion.getPosition();
            if (pos.getX() == x && pos.getY() == y) {
                return pion;
            }
        }
        return null;
    }
    
    /**
     * Affiche le menu d'options pour le joueur
     */
    private void afficherMenuOptions() {
        System.out.println("\n┌─────────────── OPTIONS ───────────────┐");//NOSONAR
        System.out.println("│ 1. Déplacer une pièce                 │");//NOSONAR
        System.out.println("│ 2. Abandonner la partie               │");//NOSONAR
        System.out.println("│ 3. Sauvegarder et quitter             │");//NOSONAR
        System.out.println("└───────────────────────────────────────┘");//NOSONAR
    }
    
    /**
     * Lit et valide une position entrée par le joueur
     * Format attendu: lettre + chiffre (ex: A3, B5)
     * @param scanner Le scanner pour lire l'entrée
     * @param message Le message à afficher
     * @return La position saisie ou null si invalide/annulation
     * @throws Erreur si le format est invalide
     */
    private Point2D lirePosition(Scanner scanner, String message) throws Erreur {
        System.out.print(message);//NOSONAR
        String input = scanner.nextLine().trim().toUpperCase();
        
        // Permettre l'annulation
        if (input.equals("A") || input.equals("ANNULER")) {
            return null;
        }
        
        if (input.length() < 2 || input.length() > 3) {
            throw new Erreur("❌ Format invalide. Utilisez le format lettre+chiffre (ex: A3)");
        }
        
        char colonne = input.charAt(0);
        String ligneStr = input.substring(1);
        
        // Validation de la colonne (A-J)
        if (colonne < 'A' || colonne > 'J') {
            throw new Erreur("❌ Colonne invalide. Utilisez A à J.");
        }
        
        // Validation de la ligne (1-10)
        try {
            int ligne = Integer.parseInt(ligneStr);
            if (ligne < 1 || ligne > 10) {
                throw new Erreur("❌ Ligne invalide. Utilisez 1 à 10.");
            }
            
            // Conversion en indices de tableau (0-9)
            int x = ligne - 1;
            int y = colonne - 'A';
            
            return new Point2D(x, y);
        } catch (NumberFormatException e) {
            throw new Erreur("❌ Numéro de ligne invalide.");
        }
    }
    
    /**
     * Vérifie si le tour est valide (a les informations minimales requises)
     * @return true si le tour est valide, false sinon
     */
    public boolean estValide() {
        return joueurActif != null && 
               positionDepart != null && 
               positionArrivee != null;
    }
    
    /**
     * Réinitialise le tour
     */
    public void reinitialiser() {
        this.positionDepart = null;
        this.positionArrivee = null;
    }
    
    /**
     * Joue un tour de jeu complet avec interaction utilisateur
     * Cette méthode affiche la grille, propose des choix au joueur,
     * valide les entrées et enregistre le coup
     * 
     * @param pions La liste des pions sur le plateau
     * @param scanner Le scanner pour lire les entrées utilisateur
     * @return true si le tour s'est bien déroulé, false si abandon/erreur
     * @throws Erreur si une erreur se produit pendant le tour
     */
    public boolean jouerTour(ArrayList<Pion> pions, Scanner scanner) throws Erreur {
        if (joueurActif == null) {
            throw new Erreur("❌ Erreur: Aucun joueur actif défini.");
        }
        
        // Affichage de l'en-tête du tour
        System.out.println("\n" + "═".repeat(50));//NOSONAR
        System.out.println("🎮 TOUR #" + numeroTour);//NOSONAR
        System.out.println("═".repeat(50));//NOSONAR
        System.out.println("👤 Joueur: " + joueurActif.getNom());//NOSONAR
        
        // Affichage de la grille
        afficherGrille(pions);
        
        // Menu d'options
        afficherMenuOptions();
        
        boolean tourTermine = false;
        while (!tourTermine) {
            System.out.print("\n➤ Choisissez une option (1-3): ");//NOSONAR
            String choix = scanner.nextLine().trim();
            
            switch (choix) {
                case "1":
                    // Déplacer une pièce
                    tourTermine = effectuerDeplacement(pions, scanner);
                    break;
                    
                case "2":
                    // Abandonner
                    System.out.print("\n⚠️  Êtes-vous sûr de vouloir abandonner? (O/N): ");//NOSONAR
                    String confirmation = scanner.nextLine().trim().toUpperCase();
                    if (confirmation.equals("O") || confirmation.equals("OUI")) {
                        System.out.println("🏳️  " + joueurActif.getNom() + " abandonne la partie.");//NOSONAR
                        return false;
                    }
                    break;
                    
                case "3":
                    // Sauvegarder et quitter
                    System.out.println("💾 Sauvegarde de la partie...");//NOSONAR
                    System.out.println("   (Fonctionnalité à implémenter avec Sauvegarde.java)");//NOSONAR
                    return false;
                    
                default:
                    throw new Erreur("❌ Option invalide. Choisissez entre 1 et 3.");
            }
        }
        
        return true;
    }
    
    /**
     * Effectue le déplacement d'une pièce
     * @param pions La liste des pions sur le plateau
     * @param scanner Le scanner pour lire les entrées
     * @return true si le déplacement est effectué, false sinon
     * @throws Erreur si une erreur se produit pendant le déplacement
     */
    private boolean effectuerDeplacement(ArrayList<Pion> pions, Scanner scanner) throws Erreur {
        System.out.println("\n🎯 Déplacement d'une pièce");//NOSONAR
        System.out.println("─".repeat(40));//NOSONAR
        
        // Lecture et validation de la position de départ
        Pion pionADeplacer = lireEtValiderPionDepart(pions, scanner);
        if (pionADeplacer == null) {
            return false;
        }
        Point2D depart = pionADeplacer.getPosition();
        
        // Lecture et validation de la position d'arrivée
        Point2D arrivee = lireEtValiderPositionArrivee(pions, scanner);
        if (arrivee == null) {
            return false;
        }
        
        // Enregistrement et exécution du déplacement
        this.positionDepart = depart;
        this.positionArrivee = arrivee;
        
        executerMouvement(pionADeplacer, depart, arrivee);
        return true;
    }
    
    /**
     * Lit et valide la sélection d'un pion de départ
     * @param pions La liste des pions
     * @param scanner Le scanner pour lire l'entrée
     * @return Le pion sélectionné ou null si annulation
     * @throws Erreur si le pion n'appartient pas au joueur
     */
    private Pion lireEtValiderPionDepart(ArrayList<Pion> pions, Scanner scanner) throws Erreur {
        Point2D depart = null;
        Pion pionADeplacer = null;
        
        while (depart == null) {
            depart = lirePosition(scanner, "📍 Position de départ (ex: A3) ou 'A' pour annuler: ");//NOSONAR
            if (depart == null) {
                System.out.println("⚠️  Annulation du déplacement.");//NOSONAR
                return null;
            }
            
            pionADeplacer = trouverPionAPosition(pions, depart.getX(), depart.getY());
            if (pionADeplacer == null) {
                throw new Erreur("❌ Aucune pièce à cette position.");
            } else if (!pionAppartientAuJoueur(pionADeplacer)) {
                throw new Erreur("❌ Cette pièce ne vous appartient pas.");
            }
        }
        
        return pionADeplacer;
    }
    
    /**
     * Vérifie si un pion appartient au joueur actif
     * @param pion Le pion à vérifier
     * @return true si le pion appartient au joueur actif
     */
    private boolean pionAppartientAuJoueur(Pion pion) {
        int couleurJoueur = joueurActif.getCouleur() ? 1 : 0;
        return pion.getCouleur() == couleurJoueur;
    }
    
    /**
     * Lit et valide une position d'arrivée
     * @param pions La liste des pions
     * @param scanner Le scanner pour lire l'entrée
     * @return La position d'arrivée ou null si annulation
     * @throws Erreur si la position est invalide
     */
    private Point2D lireEtValiderPositionArrivee(ArrayList<Pion> pions, Scanner scanner) throws Erreur {
        Point2D arrivee = null;
        
        while (arrivee == null) {
            arrivee = lirePosition(scanner, "📍 Position d'arrivée (ex: B4) ou 'A' pour annuler: ");//NOSONAR
            if (arrivee == null) {
                System.out.println("⚠️  Annulation du déplacement.");//NOSONAR
                return null;
            }
            
            if (!estCaseVide(pions, arrivee)) {
                throw new Erreur("❌ La case d'arrivée est occupée.");
            }
            
            if (!estCaseNoire(arrivee)) {
                throw new Erreur("❌ Les pions ne peuvent se déplacer que sur les cases noires.");
            }
        }
        
        return arrivee;
    }
    
    /**
     * Vérifie si une case est vide
     * @param pions La liste des pions
     * @param position La position à vérifier
     * @return true si la case est vide
     */
    private boolean estCaseVide(ArrayList<Pion> pions, Point2D position) {
        return trouverPionAPosition(pions, position.getX(), position.getY()) == null;
    }
    
    /**
     * Vérifie si une position correspond à une case noire (jouable)
     * @param position La position à vérifier
     * @return true si c'est une case noire
     */
    private boolean estCaseNoire(Point2D position) {
        return (position.getX() + position.getY()) % 2 != 0;
    }
    
    /**
     * Exécute le mouvement du pion (déplacement ou capture)
     * @param pion Le pion à déplacer
     * @param depart La position de départ
     * @param arrivee La position d'arrivée
     * @throws Erreur si le mouvement est invalide
     */
    private void executerMouvement(Pion pion, Point2D depart, Point2D arrivee) throws Erreur {
        try {
            double distance = depart.distance(arrivee);
            
            if (estDeplacementSimple(distance)) {
                pion.deplacer(arrivee);
                System.out.println("\n✅ Déplacement effectué: " + formatPosition(depart) + " → " + formatPosition(arrivee));//NOSONAR
            } else if (estCapture(distance)) {
                pion.capturer(arrivee);
                System.out.println("\n✅ Capture effectuée: " + formatPosition(depart) + " ✕ " + formatPosition(arrivee));//NOSONAR
            } else {
                throw new Erreur("❌ Déplacement invalide: distance incorrecte.");
            }
        } catch (Exception e) {
            throw new Erreur("❌ Erreur lors du déplacement: " + e.getMessage());
        }
    }
    
    /**
     * Vérifie si la distance correspond à un déplacement simple
     * @param distance La distance entre départ et arrivée
     * @return true si c'est un déplacement simple
     */
    private boolean estDeplacementSimple(double distance) {
        return Math.abs(distance - Math.sqrt(2)) < 0.1;
    }
    
    /**
     * Vérifie si la distance correspond à une capture
     * @param distance La distance entre départ et arrivée
     * @return true si c'est une capture
     */
    private boolean estCapture(double distance) {
        return Math.abs(distance - 2 * Math.sqrt(2)) < 0.1;
    }
    
    /**
     * Formate une position pour l'affichage (ex: [2,3] → "C3")
     * @param pos La position à formater
     * @return La chaîne formatée
     */
    private String formatPosition(Point2D pos) {
        char colonne = (char) ('A' + pos.getY());
        int ligne = pos.getX() + 1;
        return "" + colonne + ligne;
    }
    
    /**
     * Retourne une représentation textuelle du tour
     * @return Une chaîne décrivant le tour
     */
    @Override
    public String toString() {
        String coup = "pas encore joué";
        if (positionDepart != null && positionArrivee != null) {
            coup = formatPosition(positionDepart) + " → " + formatPosition(positionArrivee);
        }
        return "Tour #" + numeroTour + 
               " - Joueur: " + (joueurActif != null ? joueurActif.getNom() : "inconnu") +
               " | Coup: " + coup;
    }
}
