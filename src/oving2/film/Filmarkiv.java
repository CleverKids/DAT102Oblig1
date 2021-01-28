package oving2.film;

public class Filmarkiv implements FILMarkivADT{
	private Film[] filmer;
	private int antall = 0;
	
	@Override
	public Film[] hentFilmTabell() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		if (antall == filmer.length) {
			
		}
		
		filmer[antall] = nyFilm;
		antall++;
	}

	@Override
	public boolean slettFilm(int filmnr) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int antall(Sjanger Sjanger) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int antall() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
