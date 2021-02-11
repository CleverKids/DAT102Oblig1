package no.hvl.data102.adt;

import no.hvl.data102.Film;
import no.hvl.data102.Sjanger;

public interface FILMarkivADT {

	/**
	 * Henter alle filmer i arkivet
	 * @return film tabellen
	 */
	Film[] hentFilmTabell();
	
	//s�ke etter film ved hjelp av filmnr.
	Film sokFilmNr(int soknr);
	
	/**
	 *legger til en ny film i arkivet
	 *@param nyfilm
	 */
	void leggTilFilm(Film nyFilm);
	
	/**
	 * Sletter film om den eksisterer
	 * @param filmnr
	 * @return ble filmen slettet
	 */
	boolean slettFilm(int filmnr);
	
	/**
	 * s�k etter film ved bruk av tittel delstreng
	 * @param delstreng
	 * @return filmer med gitt delstreng
	 */
	Film[] soekTittel(String delstreng);
	
	/**
	 * s�ke etter filmer med produsent delstreng
	 * @param delstreng
	 * @return filmer fra produsenten
	 */
	Film[] soekProdusent(String delstreng);
	
	/**
	 * viser antall sjangere i arkivet
	 * @param Sjanger
	 * @return antall filmer
	 */
	int antall (Sjanger Sjanger);

	/**
	 * viser antall filmer i arkivet
	 * @return antall filmer
	 */
	int antall ();

}//interface

