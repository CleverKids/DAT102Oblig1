package no.hvl.dat102;

import javax.swing.JOptionPane;

import no.hvl.dat102.adt.FILMarkivADT;

public class Tekstgrensesnitt {
	
	public void skrivUtFilmDelstrengITittel(FILMarkivADT filmarkiv, String delstreng) {
		Film[] filmer = filmarkiv.sokTittel(delstreng);
		
		for (Film f: filmer) {
			JOptionPane.showMessageDialog(null, f.toString());
		}
	}

	public void skrivUtFilmProdusent(FILMarkivADT filmarkiv, String delstreng) {
		Film[] filmer = filmarkiv.sokProdusent(delstreng);
		if(filmarkiv.antall() == 0) {
			JOptionPane.showMessageDialog(null, "Filmarkiv er tomt!");
		}
		for (Film f: filmer) {
			JOptionPane.showMessageDialog(null, f.toString());
		}
	}
	
	public void skrivUtStatistikk(FILMarkivADT filmarkiv) {
		String s = "Totalt antall filmer: " + filmarkiv.antall() + "\n";
		for (Sjanger sjang: Sjanger.values()) {
			s += "Antall filmer innen " + sjang + ": " + filmarkiv.antall(
					sjang) + "\n";
		}
		 JOptionPane.showMessageDialog(null,s);
	}

	public Film lesFilm() {
		Film f = new Film(Integer.parseInt(userInput("Filmnr: ")), userInput("Produsent: "), userInput("Tittel: "),
					Integer.parseInt(userInput("Lanseringsaar: ")), userInput("Sjanger: "), userInput("Filmselskap: "));
		
		return f;
	}

	public void visFilm(Film f) {
		if(f == null) {
			JOptionPane.showMessageDialog(null, "Film ikke funnet");
		}else {
			JOptionPane.showMessageDialog(null, f.toString());
		}
	}
	
	public String userInput(String msg) {
		return JOptionPane.showInputDialog(msg);
	}
}
