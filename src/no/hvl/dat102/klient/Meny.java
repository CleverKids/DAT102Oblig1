package no.hvl.dat102.klient;

import javax.swing.JOptionPane;

import no.hvl.dat102.Film;
import no.hvl.dat102.Filmarkiv;
import no.hvl.dat102.Tekstgrensesnitt;
import no.hvl.dat102.adt.FILMarkivADT;
import no.hvl.dat102.Fil;

public class Meny {

	private Tekstgrensesnitt tekstgr;
	private FILMarkivADT filmer;

	private String filnavn = null;

	public Meny(FILMarkivADT filmer) {
		tekstgr = new Tekstgrensesnitt();
		this.filmer = filmer;
	}

	public void start() {

		int velgFil = Integer.parseInt(
				tekstgr.userInput("Skriv inn 1 for å opprette en ny fil, eller 2 for å velge en fil som finnes fra før av"));

		newOrOldArchive(velgFil);

		int brukervalg = Integer.parseInt(tekstgr.userInput("1 - Legg til film \n2 - Vis informasjon om film "
				+ "\n3 - Søk etter tittel \n4 - Filmer av produsent \n5 - Sjanger informasjon"));

		userChoice(brukervalg);
	}

	public void newOrOldArchive(int velgFil) {

		switch (velgFil) {
		case 1:
			Fil.skrivTilFil(filmer, filnavn = tekstgr.userInput("Skriv filnavn: "));
			break;
		case 2:
			filmer = Fil.lesFraFil(filnavn = tekstgr.userInput("Skriv filnavn: "));
			break;
		default:
			JOptionPane.showMessageDialog(null, "Feil input");
		}
	}
	
	public void userChoice(int brukervalg) {
		
		switch (brukervalg) {
		case 1:
			filmer.leggTilFilm(tekstgr.lesFilm());
			Fil.skrivTilFil(filmer, filnavn);
			break;
		case 2:
			tekstgr.visFilm(((Filmarkiv) filmer).sokFilmNr(Integer.parseInt(tekstgr.userInput("Skriv inn filmnummer: "))));
			break;
		case 3:
			tekstgr.skrivUtFilmDelstrengITittel(filmer, tekstgr.userInput("Skriv inn sokeord for tittel: "));
			break;
		case 4:
			tekstgr.skrivUtFilmProdusent(filmer, tekstgr.userInput("Skriv inn sokerord for produsent: "));
			break;
		case 5: 
			tekstgr.skrivUtStatistikk(filmer);
			break;
		default:
			JOptionPane.showMessageDialog(null, "Feil input");
		}
	}
}
