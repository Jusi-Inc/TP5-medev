/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.jeudedame;

import java.io.*;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author Catherine
 */
public class Sauvegarde {
	private String filename;
	
	/**
	 * Constructeur d'une sauvegarde
	 * @param filename Le nom du fichier
	 */
	public Sauvegarde(String filename) {
		this.filename = filename;
	}
	
	/**
	 * Constructeur d'une sauvegarde
	 */
	public Sauvegarde() {
		this.filename = "";
	}
	
	/**
	 * Charge une partie depuis un fichier texte
	 * @return Une partie
	 */
	public Partie loadGame() {
		BufferedReader file = null;
		Partie partie = null;
		try {
			String line;
			file = new BufferedReader(new FileReader(filename));
			
			// Initialisation des variables
			String nom_white = "";
			String nom_black = "";
			boolean tour_de_jeu = false;
			
			/*
			*/
			
			// Enregistrement des joueurs
			line = file.readLine();
			if (line != null) {
				nom_white = line;
			} else {
				throw IllegalFormatException();
			}
			
			line = file.readLine();
			if (line != null) {
				nom_black = line;
			} else {
				throw IllegalFormatException();
			}
			
			// Tour de jeu
			line = file.readLine();
			if (line != null) {
				switch (line) {
					case "white":
						tour_de_jeu = false;
						break;
					case "black":
						tour_de_jeu = true;
						break;
					default:
						throw IllegalFormatException();
				}
			} else {
				throw IllegalFormatException();
			}
			
			// List des coordonnées des pièces
			List<Pion> list = new List<>();
			line = file.readLine();
			while (line != null) {
				Pion p = fileReadLine(line);
				if (p != null) {
					list.add(new Pion(p));
				}
				
				line = file.readLine();
			}
			partie = new Partie(new Joueur(nom_white, false), new Joueur(nom_black, true), list, tour_de_jeu);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Erreur lors de la lecture de la sauvegarde");
		} finally {
			file.close();
		}
		
		return partie;
	}
	
	/**
	 * Enregistre une partie dans un fichier texte
	 * @param partie La partie à sauvegarder
	 */
	public void saveGame(Partie partie) {
		BufferedWriter file = null;
		
		String jw = partie.getJoueurBlanc().getNom();
		String jb = partie.getJoueurNoir().getNom();
		List <Pion>list = partie.getPlateau();
		boolean tour = partie.isTourJoueur();
		
		
		try {
			file = new BufferedWriter(new FileWriter(filename));
			
			// Caractéristiques du jeu
			file.write(jw + "\n");
			file.write(jb + "\n");
			file.write(tour ? "black\n":"white\n");
			
			// List des pions
			for (Pion p : list) {
				file.write(p.getX() + " ");
				file.write(p.getY() + " ");
				file.write(p.getCouleur());
				
				if (p.getClass().getSimpleName().equals("Dame")) {
					file.write(" dame");
				}
				
				file.newLine();
			}
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (file != null) {
					file.flush();
					file.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	
	private Pion fileReadLine(String line) throws Exception {
		StringTokenizer tokenizer = new StringTokenizer(line, " ");
		Pion pion = null;
		
		int tokenCount = tokenizer.countTokens();
		if (tokenCount >= 3 && tokenCount <= 4) {
			int x = Integer.parseInt(tokenizer.nextToken());
			int y = Integer.parseInt(tokenizer.nextToken());
			int couleur = Integer.parseInt(tokenizer.nextToken());
			
			if (tokenCount == 3) { // Pion
				pion = new Pion(couleur, x, y);
			} else { // Dame
				pion = new Dame(couleur, x, y);
			}			
		} else {
			throw IllegalFormatException();
		}
		return pion;
	}

	/**
	 *
	 * @return
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 *
	 * @param filename
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}

	private Exception IllegalFormatException() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}
	
	
}
