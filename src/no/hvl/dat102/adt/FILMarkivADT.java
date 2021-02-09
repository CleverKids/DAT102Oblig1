package no.hvl.dat102.adt;

import no.hvl.dat102.Film;
import no.hvl.dat102.Sjanger;

public interface FILMarkivADT {

	/**
	 * Henter alle filmene i arkivet
	 * 
	 * @return film tabellen
	 */
	Film[] hentFilmTabell();

	/**
	 * Legger til en ny film i arkivet
	 * 
	 * @param nyFilm
	 */
	void leggTilFilm(Film nyFilm);

	/**
	 * Sletter film med gitt filmnr fra arkivet om det eksisterer
	 * 
	 * @param filmnr
	 * @return ble filmen slettet
	 */
	boolean slettFilm(int filmnr);

	/**
	 * Søker opp og henter filmer med en gitt delstreng
	 * 
	 * @param delstreng
	 * @return filmer med gitt delstreng
	 */
	Film[] sokTittel(String delstreng);

	/**
	 * Søker opp og henter filmer som er produsert av gitt produsent i delstreng
	 * 
	 * @param delstreng
	 * @return filmer laget av produsent
	 */
	Film[] sokProdusent(String delstreng);

	/**
	 * Antall filmer av gitt sjanger i arkivet
	 * 
	 * @param sjanger
	 * @return antall filmer
	 */
	int antall(Sjanger sjanger);

	/**
	 * Antall filmer i arkivet
	 * 
	 * @return antall filmer
	 */
	int antall();
}
