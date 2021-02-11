package no.hvl.data102.klient;

import javax.swing.JOptionPane;
import no.hvl.data102.*;
import no.hvl.data102.adt.FILMarkivADT;
public class Meny {

	private Tekstgrensesnitt tekstgr;
	private FILMarkivADT filmer;

	public Meny(FILMarkivADT filmer) {
		tekstgr = new Tekstgrensesnitt();
		this.filmer = filmer;
	}

	public void start() {
		String filnavn = null;
		int velgFil;
		velgFil = Integer.parseInt(JOptionPane.showInputDialog("Skriv 1 for ny fil. Skriv 2 for en fil som fins"));

		if (velgFil == 1) {
			filnavn = JOptionPane.showInputDialog("Skriv navn på fil: ");
			Fil.skrivTilFil(filmer, filnavn);

		} else if (velgFil == 2) {
			filnavn = JOptionPane.showInputDialog("Skriv navn på fil: ");
			filmer = Fil.lesFraFil(filnavn);
		} else {
			JOptionPane.showConfirmDialog(null, "Finnes ikke");
		}

		int brukervalg;

		brukervalg = Integer.parseInt(JOptionPane.showInputDialog(
				"Tast 1 for opprettelse av ny film, " + "2 for å vise info om en film " + "3 for å søke etter en film "
						+ "4 for å finne filmene til en produsent " + "5 for å vise sjanger"));
		if (brukervalg == 1) {
			Film x = tekstgr.lesFilm();
			filmer.leggTilFilm(x);
			Fil.skrivTilFil(filmer, filnavn);
		
		} else if (brukervalg == 2) {
			Film x = filmer.sokFilmNr(Integer.parseInt(JOptionPane.showInputDialog("Filmnr?")));
			tekstgr.visFilm(x);
			
		} else if (brukervalg == 3) {
			String sokeord = JOptionPane.showInputDialog("Søk tittel: ");
			tekstgr.skrivUtFilmDelstrengITittel(filmer, sokeord);
			
		} else if (brukervalg == 4) {
			String sokeord =JOptionPane.showInputDialog("Søk produsent: ");
			tekstgr.skrivUtFilmProdusent(filmer, sokeord);
			
		} else if (brukervalg == 5) {
			String sokeord = JOptionPane.showInputDialog("Søk sjanger: " );
			tekstgr.skrivUtStatistikk(filmer, sokeord);
			
		} else {
			JOptionPane.showInputDialog(null, "Feil!");
		}
	}
}
