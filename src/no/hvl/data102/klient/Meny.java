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
			filnavn = JOptionPane.showInputDialog("Skriv navn p� fil: ");
			Fil.skrivTilFil(filmer, filnavn);

		} else if (velgFil == 2) {
			filnavn = JOptionPane.showInputDialog("Skriv navn p� fil: ");
			filmer = Fil.lesFraFil(filnavn);
		} else {
			JOptionPane.showConfirmDialog(null, "Finnes ikke");
		}

		int brukervalg;

		brukervalg = Integer.parseInt(JOptionPane.showInputDialog(
				"Tast 1 for opprettelse av ny film, " + "2 for � vise info om en film " + "3 for � s�ke etter en film "
						+ "4 for � finne filmene til en produsent " + "5 for � vise sjanger"));
		if (brukervalg == 1) {
			Film x = tekstgr.lesFilm();
			filmer.leggTilFilm(x);
			Fil.skrivTilFil(filmer, filnavn);
		
		} else if (brukervalg == 2) {
			Film x = filmer.sokFilmNr(Integer.parseInt(JOptionPane.showInputDialog("Filmnr?")));
			tekstgr.visFilm(x);
			
		} else if (brukervalg == 3) {
			String sokeord = JOptionPane.showInputDialog("S�k tittel: ");
			tekstgr.skrivUtFilmDelstrengITittel(filmer, sokeord);
			
		} else if (brukervalg == 4) {
			String sokeord =JOptionPane.showInputDialog("S�k produsent: ");
			tekstgr.skrivUtFilmProdusent(filmer, sokeord);
			
		} else if (brukervalg == 5) {
			String sokeord = JOptionPane.showInputDialog("S�k sjanger: " );
			tekstgr.skrivUtStatistikk(filmer, sokeord);
			
		} else {
			JOptionPane.showInputDialog(null, "Feil!");
		}
	}
}
