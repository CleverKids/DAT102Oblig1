package no.hvl.dat102;

import no.hvl.dat102.adt.FILMarkivADT;

public class Filmarkiv implements FILMarkivADT {
	private Film[] filmer;
	private int antall = 0;
	private final static int STANDARDLENGDE = 10;

	public Filmarkiv() {
		filmer = new Film[STANDARDLENGDE];
	}

	public Filmarkiv(int antall) {
		filmer = new Film[antall];
	}

	public Film sokFilmNr(int sokNr) {
		boolean b = false;
		int i = 0;
		Film f = null;

		while (i < antall && !b && filmer[i] != null) {
			if (filmer[i].getFilmnr() == sokNr) {
				f = filmer[i];
				b = true;

			}
			i++;
		}
		return f;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		if (sokFilmNr(nyFilm.getFilmnr()) == null) {

			if (antall == filmer.length) {
				Film[] tempFilmer = filmer;
				filmer = new Film[(int) (antall * 1.1)];

				for (int i = 0; i < antall; i++) {
					filmer[i] = tempFilmer[i];
				}
			}

			filmer[antall] = nyFilm;
			antall++;
		} else {
			// JOptionPane(showMessageDialog(null, "Film finnes allerede"));
			System.out.print("Film allerede lagt til");
		}
      
	}
	
	public void utvidArkiv() {
		Film[] utvidetArkiv = new Film[(int)Math.ceil(1.1 * filmer.length)];
		
		for (int i = 0; i < antall; i++) {
			utvidetArkiv[i] = filmer[i];
		}
		
		filmer = utvidetArkiv;
	}

	@Override
	public boolean slettFilm(int filmnr) {
		boolean slettet = false;
		
		for (int i = 0; i < antall && !slettet; i++) {
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
	public Film[] sokTittel(String delstreng) {
		int antallFilmer = 0;
		Film[] hjelpeTab = new Film[filmer.length];
		
		for (int i = 0; i < antall; i++) {
			if (filmer[i].getTittel().toUpperCase().contains(delstreng.toUpperCase())) {
				hjelpeTab[antallFilmer] = filmer[i];
				antallFilmer++;
			}
		}
		
		return trimmeTab(hjelpeTab, antallFilmer);
	}

	@Override
	public Film[] sokProdusent(String delstreng) {
		int antallFilmer = 0;
		Film[] hjelpeTab = new Film[filmer.length];
		
		for (int i = 0; i < antall; i++) {
			if (filmer[i].getProdusent().toUpperCase().contains(delstreng.toUpperCase())) {
				hjelpeTab[antallFilmer] = filmer[i];
				antallFilmer++;
			}
		}
		
		return trimmeTab(hjelpeTab, antallFilmer);
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public Film[] hentFilmTabell() {
		return trimmeTab(filmer, antall);
	}

	@Override
	public int antall(Sjanger sjanger) {
		int antallFilmer = 0;
		
		for(int i = 0; i < antall; i++) {
			if (filmer[i].getSjanger().equals(sjanger)) {
				antallFilmer++;
			}
		}
		
		return antallFilmer;
	}
	
	public Film[] trimmeTab(Film[] filmTab, int antallFilmer) {
		Film[] nyTab = new Film[antallFilmer];
		
		for(int i = 0; i < antallFilmer; i++) {
			nyTab[i] = filmTab[i];
		}
		
		return nyTab;
	}
}
