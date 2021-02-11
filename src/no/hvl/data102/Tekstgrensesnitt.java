package no.hvl.data102;

import javax.swing.JOptionPane;
import no.hvl.data102.adt.FILMarkivADT;

public class Tekstgrensesnitt {

	// Lese opplysningene om en FILM fra tastatur
	public Film lesFilm() {
		int filmnr;
		String produsent;
		String tittel;
		int år;
		String Sjanger;
		String filmselskap;

		filmnr = Integer.parseInt(JOptionPane.showInputDialog("Skriv inn filmnr"));
		produsent = JOptionPane.showInputDialog("Skriv inn produsent");
		tittel = JOptionPane.showInputDialog("Skriv inn tittel");
		år = Integer.parseInt(JOptionPane.showInputDialog("Skriv inn år"));
		Sjanger = JOptionPane.showInputDialog("Skriv inn sjanger");
		filmselskap = JOptionPane.showInputDialog("Skriv inn filmselskap");

		Film x = new Film(filmnr, produsent, tittel, år, Sjanger, filmselskap);

		return x;
	}

	// vise en film med alle opplysninger på skjerm(husk tekst for sjanger)
	public void visFilm(Film film) {
		if (film == null) {
			JOptionPane.showMessageDialog(null, "Film finst ikkje!");
		} else {
			JOptionPane.showMessageDialog(null,
					"Filmnr: " + film.getFilmnr() + "\n" + "Produsent: " + film.getProdusent() + "\n" + "Tittel: "
							+ film.getTittel() + "\n" + "År: " + film.getÅr() + "\n" + "Sjanger: " + film.getSjanger()
							+ "\n" + "Filmselskap: " + film.getFilmselskap());
		}
	}

	// Skriv ut alle filmer med en spesiell delstreng i tittelen
	public void skrivUtFilmDelstrengITittel(FILMarkivADT filmer, String delstreng) {
		Film[] sokResultater = filmer.soekTittel(delstreng);

		for (int i = 0; i < sokResultater.length; i++) {
			JOptionPane.showMessageDialog(null,
					"Filmnr: " + sokResultater[i].getFilmnr() + "Produsent: " + sokResultater[i].getProdusent()
							+ "Tittel: " + sokResultater[i].getTittel() + "År: " + sokResultater[i].getÅr()
							+ "Sjanger: " + sokResultater[i].getSjanger() + "Filmselskap: "
							+ sokResultater[i].getFilmselskap() + "\n");
		}
	}

	// Skriver ut alle filmer av en produsent /-er
	public void skrivUtFilmProdusent(FILMarkivADT filmer, String delstreng) {
		Film[] sokResultater = filmer.soekProdusent(delstreng);

		for (int i = 0; i < sokResultater.length; i++) {
			JOptionPane.showMessageDialog(null,
					"Filmnr: " + sokResultater[i].getFilmnr() + "Produsent: " + sokResultater[i].getProdusent()
							+ "Tittel: " + sokResultater[i].getTittel() + "År: " + sokResultater[i].getÅr()
							+ "Sjanger: " + sokResultater[i].getSjanger() + "Filmselskap: "
							+ sokResultater[i].getFilmselskap() + "\n");
		}
	}
	
	//skriv ut en enkel statistikk som inneholder antall filmer totalt
	//og hvor mange det er i hver sjanger
	// endrer paremeter fra kunn filmer til filmer og string
	public void skrivUtStatistikk(FILMarkivADT filmer, String sjanger) { 
		int filmtot = filmer.antall();
		int antSjanger = filmer.antall(Sjanger.finnSjanger(sjanger));
		
		JOptionPane.showMessageDialog(null, "Totalt antall filmer: " + filmtot + "\nAntall filmer innen: " + sjanger + ": " + antSjanger);
	}
}
