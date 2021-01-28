package no.hvl.dat102;

import no.hvl.dat102.adt.FILMarkivADT;

public class Tekstgrensesnitt {
	
	public void skrivUtFilmDelstrengITittel(FILMarkivADT filmarkiv, String delstreng) {
		Film[] filmer = filmarkiv.sokTittel(delstreng);
		
		for (Film f: filmer) {
			System.out.println(f.toString());
			System.out.println();
		}
	}

	public void skrivUtFilmProdusent(FILMarkivADT filmarkiv, String delstreng) {
		Film[] filmer = filmarkiv.sokProdusent(delstreng);
		
		for (Film f: filmer) {
			System.out.println(f.toString());
			System.out.println();
		}
	}
	
	public void skrivUtStatistikk(FILMarkivADT filmarkiv) {
		System.out.println("Antall filmer i akrivet: " + filmarkiv.antall());
		Sjanger[] sjangerTab = Sjanger.values();
		for (int i = 0; i < Sjanger.values().length; i++) {
			System.out.println("Antall filmer i sjangeren " + sjangerTab[i] + ": " + filmarkiv.antall(sjangerTab[i]));
		}
	}
	
	//bare for testing, må ha static over for å funke.
	/*
	public static void main(String[] args) {
		FILMarkivADT filmarkiv = new Filmarkiv();
		Film f1 = new Film(1, "bert", "hairy pooter", 1990, "drama", "shittyMovies");
		Film f2 = new Film(2, "bob", "hairy pooter2", 1992, "action", "shittyMovies2");
		Film f3 = new Film(3, "bob", "hairy pooter3", 1996, "history", "shittyMovies3");
		
		filmarkiv.leggTilFilm(f1);
		filmarkiv.leggTilFilm(f2);
		filmarkiv.leggTilFilm(f3);
		
		skrivUtFilmDelstrengITittel(filmarkiv, "hairy pooter");
		skrivUtFilmProdusent(filmarkiv, "bob");
		skrivUtStatistikk(filmarkiv);
	}
	*/
}
