package no.hvl.dat102;

import no.hvl.dat102.adt.FILMarkivADT;

public class Filmarkiv2 implements FILMarkivADT {
	private int antall;
	private LinearNode<Film> start;
	
	public Filmarkiv2() {
		start = new LinearNode<Film>();
		antall = 0;
	}
	
	public Filmarkiv2(Film nyFilm) {
		start = new LinearNode<Film>(nyFilm);
		antall = 1;
	}
	
	@Override
	public Film[] hentFilmTabell() {
		Film[] filmer = new Film[antall];
		LinearNode<Film> aktuell = start;
		
		for(int i = 0; i < antall; i++) {
			filmer[i] = aktuell.getElement();
			aktuell = aktuell.getNeste();
		}
		
		return filmer;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		if(start.getElement().equals(null)) {
			start.setElement(nyFilm);
		}else {
			LinearNode<Film> nyNode = new LinearNode<Film>(nyFilm);
			nyNode.setNeste(start);
			start = nyNode;
		}
		antall++;
	}

	@Override
	public boolean slettFilm(int filmnr) {
		boolean funnet = false;
		
		if(start.getElement().getFilmnr() == filmnr) {
			start = start.getNeste();
		}else {
			LinearNode<Film> aktuell = start;
			while(!funnet && !aktuell.getNeste().equals(null)) {
				if(aktuell.getNeste().getElement().getFilmnr() == filmnr) {
					LinearNode<Film> hjelpeNode = aktuell.getNeste();
					aktuell.setNeste(hjelpeNode.getNeste());
					funnet = true;
					antall--;
				}else {
					aktuell = aktuell.getNeste();
				}
			}
		}
		
		return funnet;
	}

	@Override
	public Film[] sokTittel(String delstreng) {
		int antallFilmer = 0;
		Film[] filmTab = hentFilmTabell();
		Film[] hjelpeTab = new Film[antall];
		
		for(int i = 0; i < antall; i++) {
			if(filmTab[i].getTittel().toUpperCase().contains(delstreng.toUpperCase())) {
				hjelpeTab[antallFilmer] = filmTab[i];
				antallFilmer++;
			}
		}
		
		return trimmeTab(hjelpeTab, antallFilmer);
	}

	@Override
	public Film[] sokProdusent(String delstreng) {
		int antallFilmer = 0;
		Film[] filmTab = hentFilmTabell();
		Film[] hjelpeTab = new Film[antall];
		
		for(int i = 0; i < antall; i++) {
			if(filmTab[i].getProdusent().toUpperCase().contains(delstreng.toUpperCase())) {
				hjelpeTab[antallFilmer] = filmTab[i];
				antallFilmer++;
			}
		}
		
		return trimmeTab(hjelpeTab, antallFilmer);
	}

	@Override
	public int antall(Sjanger sjanger) {
		int antallFilmer = 0;
		LinearNode<Film> aktuell = start;
		
		if(!aktuell.getElement().equals(null)) {
			if(aktuell.getElement().getSjanger().equals(sjanger)) {
				antallFilmer++;
			}
			while(!aktuell.getNeste().equals(null)) {
				if(aktuell.getNeste().getElement().getSjanger().equals(sjanger)) {
					antallFilmer++;
				}
				aktuell = aktuell.getNeste();
			}
		}
		
		return antallFilmer;
	}

	@Override
	public int antall() {
		return antall;
	}
	
	public Film[] trimmeTab(Film[] filmTab, int antallFilmer) {
		Film[] nyTab = new Film[antallFilmer];
		
		for(int i = 0; i < antallFilmer; i++) {
			nyTab[i] = filmTab[i];
		}
		
		return nyTab;
	}
}
