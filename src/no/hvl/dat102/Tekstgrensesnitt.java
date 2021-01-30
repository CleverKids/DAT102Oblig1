package no.hvl.dat102;

import no.hvl.dat102.adt.FILMarkivADT;
import javax.swing.JOptionPane;
public class Tekstgrensesnitt {

	// lese opplysningene om en FILM fra tastatur
	// er gjort static på grunn av feil i switch på start metoden i meny classen, mulig det må endrest tilbake
	 public static Film lesFilm() {
		
	int filmnr;
	String produsent;
	String tittel;
	int lanseringsaar;
	String sjanger;
	String filmselskap;
	
	filmnr = Integer.parseInt(JOptionPane.showInputDialog("Skriv inn filmnr"));
	produsent =JOptionPane.showInputDialog("Skriv inn produsent");
	tittel = JOptionPane.showInputDialog("Skriv inn tittel");
	lanseringsaar = Integer.parseInt(JOptionPane.showInputDialog("Skriv inn lanseringsaar"));
	sjanger = JOptionPane.showInputDialog("Skriv inn sjanger");
	filmselskap = JOptionPane.showInputDialog("Skriv inn filmselskap");
	
	Film f = new Film(filmnr, produsent, tittel, lanseringsaar, sjanger, filmselskap);
	
	return f;
	 }
	// vise en film med alle opplysninger på skjerm (husk tekst for sjanger)
	// endret input til metoden fra Film film til int nummer
	//gjorde visfilm om til static for å fikse feil i meny classen for switch 2
	 public static void visFilm(int nummer){
		 
		 
	 
	 
	 }
	// Skrive ut alle Filmer med en spesiell delstreng i tittelen
	 public void skrivUtFilmDelstrengITittel(FILMarkivADT filma, String delstreng){
		 
	 }
	// Skriver ut alle Filmer av en produsent / en gruppe
	 public void skrivUtFilmProdusent(FILMarkivADT filma, String delstreng) {
		 
	 
	 }
	// Skrive ut en enkel statistikk som inneholder antall Filmer totalt
	// og hvor mange det er i hver sjanger
	// endrer paremeter fra kunn filma til filma og String
	 public void skrivUtStatistikk(FILMarkivADT filma, String sjang){
		 
	 }
	//… Ev. andre metoder
	}//class