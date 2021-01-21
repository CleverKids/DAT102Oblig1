package no.hvl.dat102;

import no.hvl.dat102.Film;
import no.hvl.dat102.adt.FILMarkivADT;

public class Filmarkiv implements FILMarkivADT {
	private Film[] filmer;
	private int antall = 0;
	private final static int STANDARDLENGDE = 10;

	public Filmarkiv() {
		this(STANDARDLENGDE);
	}
	
	public Filmarkiv(int antall) {
		filmer = new Film[antall];
	}
	
	@Override
	public void leggTilFilm(Film nyFilm) {
		if(antall == filmer.length) {
			//Utvid tabellen metode
		}
		
		filmer[antall] = nyFilm;
		antall++;
	}

	@Override
	public boolean slettFilm(int filmnr) {
		// getFilmnr fra Film class?(står ingenting nevnt i oppgaven som jeg har sett)
		return false;
	}

	@Override
	public Film[] sokTittel(String delstreng) {
		// Må være full tabell
		return null;
	}

	@Override
	public Film[] sokProdusent(String delstreng) {
		// Må være full tabell
		return null;
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public Film[] hentFilmTabell() {
		// Må være full tabell
		return null;
	}

	@Override
	public int antall(Sjanger sjanger) {
		// TODO Auto-generated method stub
		return 0;
	}

}
