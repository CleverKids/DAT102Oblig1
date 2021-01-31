package no.hvl.dat102;

import no.hvl.dat102.adt.FILMarkivADT;
import javax.swing.JOptionPane;

public class Tekstgrensesnitt {

	// lese opplysningene om en FILM fra tastatur
	public Film lesFilm() {

		int filmnr;
		String produsent;
		String tittel;
		int lanseringsaar;
		String sjanger;
		String filmselskap;

		filmnr = Integer.parseInt(JOptionPane.showInputDialog("Skriv inn filmnr"));
		produsent = JOptionPane.showInputDialog("Skriv inn produsent");
		tittel = JOptionPane.showInputDialog("Skriv inn tittel");
		lanseringsaar = Integer.parseInt(JOptionPane.showInputDialog("Skriv inn lanseringsaar"));
		sjanger = JOptionPane.showInputDialog("Skriv inn sjanger");
		filmselskap = JOptionPane.showInputDialog("Skriv inn filmselskap");

		Film f = new Film(filmnr, produsent, tittel, lanseringsaar, sjanger, filmselskap);

		return f;
	}

	// vise en film med alle opplysninger på skjerm (husk tekst for sjanger)
	public void visFilm(Film film) {
		if (film == null) {
			JOptionPane.showMessageDialog(null, "Film ikke funnet");
		} else {

			JOptionPane.showMessageDialog(null,
					"Filmnr: " + film.getFilmnr() + "\n" + "Produsent: " + film.getProdusent() + "\n" + "Tittel: "
							+ film.getTittel() + "\n" + "Lanseringsår: " + film.getLanseringsaar() + "\n" + "Sjanger: "
							+ film.getSjanger() + "\n" + "Filmselskap: " + film.getFilmselskap());
		}

	}

	// Skrive ut alle Filmer med en spesiell delstreng i tittelen
	public void skrivUtFilmDelstrengITittel(FILMarkivADT filma, String delstreng) {
		Film[] sokResultater = filma.sokTittel(delstreng);
		
		for(int i = 0; i < sokResultater.length; i++) {
		JOptionPane.showMessageDialog(null,
		"Filmnr: " + sokResultater[i].getFilmnr() + "Produsent: " + sokResultater[i].getProdusent() + "Tittel: "
				+ sokResultater[i].getTittel() +  "Lanseringsår: " + sokResultater[i].getLanseringsaar() + "Sjanger: "
				+ sokResultater[i].getSjanger() + "Filmselskap: " + sokResultater[i].getFilmselskap() + "\n");
		}
	}

	// Skriver ut alle Filmer av en produsent / en gruppe
	public void skrivUtFilmProdusent(FILMarkivADT filma, String delstreng) {
		Film[] sokResultater = filma.sokProdusent(delstreng);
		
		for(int i = 0; i < sokResultater.length; i++) {
		JOptionPane.showMessageDialog(null,
		"Filmnr: " + sokResultater[i].getFilmnr() + "Produsent: " + sokResultater[i].getProdusent() + "Tittel: "
				+ sokResultater[i].getTittel() +  "Lanseringsår: " + sokResultater[i].getLanseringsaar() + "Sjanger: "
				+ sokResultater[i].getSjanger() + "Filmselskap: " + sokResultater[i].getFilmselskap() + "\n");
		}

	}

	// Skrive ut en enkel statistikk som inneholder antall Filmer totalt
	// og hvor mange det er i hver sjanger
	// endrer paremeter fra kunn filma til filma og String
	public void skrivUtStatistikk(FILMarkivADT filma, String sjang) {
		int totaltAntall = filma.antall();
		int antallSjanger = filma.antall(Sjanger.finnSjanger(sjang));
		
		JOptionPane.showMessageDialog(null, "Totalt antall filmer: " + totaltAntall + "\nAntall filmer innen " +  sjang + ": " + antallSjanger);

	}
	// … Ev. andre metoder
}// class













