package no.hvl.dat102;

import no.hvl.dat102.Film;
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
		}else {
		//JOptionPane(showMessageDialog(null, "Film finnes allerede"));
		System.out.print("Film allerede lagt til");
		}
		
		/*
		if (antall == filmer.length) {
			Film[] tempFilmer = filmer;
			filmer = new Film[(int) (antall * 1.1)];

			for (int i = 0; i < antall; i++) {
				filmer[i] = tempFilmer[i];
			}
		}

		filmer[antall] = nyFilm;
		antall++;
		*/
	}
	
	

	@Override
	public boolean slettFilm(int filmnr) {
		boolean b = false;

		for (int i = 0; i < antall && !b; i++) {
			if (filmer[i].getFilmnr() == filmnr) {
				for (int n = i; n < antall; n++) {
					filmer[n] = filmer[n + 1];
				}
				antall--;
			}
		}

		return b;
	}

	@Override
	public Film[] sokTittel(String delstreng) {
		// Må være full tabell

		Film[] resultater;
		int funnet = 0;

		int[] index = new int[antall];

		for (int i = 0; i < antall; i++) {
			if (filmer[i].getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
				index[funnet] = i;
				funnet++;
			}

		}

		resultater = new Film[funnet];

		for (int i = 0; i < funnet; i++) {
			resultater[i] = filmer[index[i]];
		}

		return resultater;
	}

	@Override
	public Film[] sokProdusent(String delstreng) {
		// Må være full tabell

		Film[] resultater;
		int funnet = 0;

		int[] index = new int[antall];

		for (int i = 0; i < antall; i++) {
			if (filmer[i].getProdusent().toLowerCase().contains(delstreng.toLowerCase())) {
				index[funnet] = i;
				funnet++;
			}

		}

		resultater = new Film[funnet];

		for (int i = 0; i < funnet; i++) {
			resultater[i] = filmer[index[i]];
		}

		return resultater;
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public Film[] hentFilmTabell() {
		Film[] filmTab = new Film[antall];

		for (int i = 0; i < antall; i++) {
			filmTab[i] = filmer[i];
		}

		return filmTab;
	}

	@Override
	public int antall(Sjanger sjanger) {

		int n = 0;

		for (int i = 0; i < antall; i++) {
			if (filmer[i].getSjanger().equals(sjanger)) {
				n++;
			}
		}

		return n;
	}

}
