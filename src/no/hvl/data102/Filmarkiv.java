package no.hvl.data102;

import no.hvl.data102.adt.FILMarkivADT;

public class Filmarkiv implements FILMarkivADT {
	private Film[] filmer;
	private int antall = 0;
	private final static int SL = 10;

	public Filmarkiv() {
		this(SL);
	}

	public Filmarkiv(int antall) {
		filmer = new Film[antall];
	}

	public Film sokFilmNr(int soknr) {
		boolean y = false;
		int i = 0;
		Film x = null;
		
		while (i < antall && !y && filmer[i] != null) {
			if(filmer[i].getFilmnr() == soknr) {
				x = filmer[i];
				y = true;
			}
			i++;
		}
		return x;
	}
	
	
	
	
	@Override
	public Film[] hentFilmTabell() {
		return trimtab(filmer, antall);
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		if (antall == filmer.length) {
			Film[] nyfilmer = new Film[filmer.length * 2];
			for (int i = 0; i < filmer.length; i++) {
				nyfilmer[i] = filmer[i];
			}
		}

		filmer[antall] = nyFilm;
		antall++;
	}

	@Override
	public boolean slettFilm(int filmnr) {
		boolean slettet = false;

		for (int i = 0; i < antall; i++) {
			if (filmer[i].getFilmnr() == filmnr) {
				antall--;
				filmer[i] = filmer[antall];
				filmer[antall] = null;
				slettet = true;
			}
		}
		return slettet;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		int antall = 0;
		Film[] mTab = new Film[filmer.length];
		for (int i = 0; i < filmer.length; i++) {
			if (filmer[i].getTittel().toUpperCase().contains(delstreng.toUpperCase())) {
				mTab[antall] = filmer[i];
				antall++;
			}
		}
		trimtab(mTab, antall);
		return mTab;
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		int antall = 0;
		Film[] mTab = new Film[filmer.length];
		for (int i = 0; i < filmer.length; i++) {
			if (filmer[i].getProdusent().toUpperCase().contains(delstreng.toUpperCase())) {
				mTab[antall] = filmer[i];
				antall++;
			}
		}
		trimtab(mTab, antall);
		return mTab;
	}

	@Override
	public int antall(Sjanger Sjanger) {
		int antall = 0;
		Film[] mTab = new Film[filmer.length];
		for (int i = 0; i < filmer.length; i++) {
			if (filmer[i].getSjanger().equals(Sjanger)) {
				mTab[antall] = filmer[i];
				antall++;
			}
		}
		return antall;
	}

	@Override
	public int antall() {
		return antall;
	}

	private Film[] trimtab(Film[] tab, int n) {
		Film[] filmtab2 = new Film[n];
		int i = 0;
		while (i < n) {
			filmtab2[i] = tab[i];
			i++;
		}
		return filmtab2;
	}

}
