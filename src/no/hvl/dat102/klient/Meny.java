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

	public Meny(FILMarkivADT filmer) {
		tekstgr = new Tekstgrensesnitt();
		this.filmer = filmer;
	}

	public void start() {

		String filnavn = null;

		int velgFil;

		velgFil = Integer.parseInt(JOptionPane.showInputDialog(
				"Skriv inn 1 for å opprette en ny fil, eller 2 for å velge en fil som finnes fra før av"));

		if (velgFil == 1) {
			filnavn = JOptionPane.showInputDialog("Skriv filnavn: ");
			/*
			if (Fil.lesFraFil(filnavn) != null) {
				int bekreft = Integer.parseInt(JOptionPane.showInputDialog(
						"Fil finnes fra før av, skriv inn 1 for å erstatte eller 2 for å åpne eksisterende fil:"));

				if (bekreft == 1) {
					Fil.skrivTilFil(filmer, filnavn);
				} else if (bekreft == 2) {
					filmer = Fil.lesFraFil(filnavn);
				} else {
					JOptionPane.showMessageDialog(null, "Feil input");
				}

			} else {
			*/
				Fil.skrivTilFil(filmer, filnavn);

			//}

		} else if (velgFil == 2) {
			filnavn = JOptionPane.showInputDialog("Skriv filnavn: ");
			filmer = Fil.lesFraFil(filnavn);
		} else {
			JOptionPane.showMessageDialog(null, "Feil input");
		}

		int brukervalg;

		brukervalg = Integer.parseInt(JOptionPane.showInputDialog("Skriv inn: 1 for å legge til ein film,"
				+ " 2 for å vise informasjon om ein film," + " 3 for å søke etter tittel,"
				+ " 4 for å finne filmene til ein produsent," + " 5 for å vise sjanger informasjon."));

		if (brukervalg == 1) {
			Film f = tekstgr.lesFilm();
			filmer.leggTilFilm(f);

			Fil.skrivTilFil(filmer, filnavn);

		} else if (brukervalg == 2) {

			Film f = filmer.sokFilmNr(Integer.parseInt(JOptionPane.showInputDialog("Skriv inn filmnummer")));
			tekstgr.visFilm(f);

		} else if (brukervalg == 3) {
			String sokeord = JOptionPane.showInputDialog("Skriv inn sokeord på ein tittel");
			tekstgr.skrivUtFilmDelstrengITittel(filmer, sokeord);

		} else if (brukervalg == 4) {
			String sokeord = JOptionPane.showInputDialog("Skriv inn sokeord på ein produsent");
			tekstgr.skrivUtFilmProdusent(filmer, sokeord);

		} else if (brukervalg == 5) {
			String sokeord = JOptionPane.showInputDialog("Skriv inn sokeord på ein sjanger");
			tekstgr.skrivUtStatistikk(filmer, sokeord);
		} else {
			JOptionPane.showMessageDialog(null, "Feil input");
		}

//	switch(brukervalg) {
//	case 1: Tekstgrensesnitt.lesFilm();
//	break;
//	case 2:  int n =Integer.parseInt(JOptionPane.showInputDialog("Skriv inn filmnummer"));
//		
//		Tekstgrensesnitt.visFilm(n);
//	break;
//	case 3: Tekstgrensesnitt.visFilm();
//	break;
//	case 4: Tekstgrensesnitt.visFilm();
//	break;
//	case 5: Tekstgrensesnitt.visFilm();
//	break;
//	default: JOptionPane.showMessageDialog(null, "Feil input");
//	}

	}
}
