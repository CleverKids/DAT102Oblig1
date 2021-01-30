package no.hvl.dat102.klient;

import javax.swing.JOptionPane;

import no.hvl.dat102.Tekstgrensesnitt;
import no.hvl.dat102.adt.FILMarkivADT;
public class Meny{
	
	 private Tekstgrensesnitt tekstgr;
	 private FILMarkivADT filmer;
	 public Meny(FILMarkivADT filmer){
	 tekstgr = new Tekstgrensesnitt();
	 this.filmer = filmer;
	 }
	
	 public void start() {
		 
	int brukervalg;
	
	brukervalg = Integer.parseInt(JOptionPane.showInputDialog("Skriv inn: 1 for å legge til ein film,"
			+ " 2 for å vise informasjon om ein film,"
			+ " 3 for å søke etter tittel,"
			+ " 4 for å finne filmene til ein produsent,"
			+ " 5 for å vise sjanger informasjon."));
	
	
	if (brukervalg == 1) {
		Tekstgrensesnitt.lesFilm();
	} else if (brukervalg == 2) {
		
		Tekstgrensesnitt.visFilm(Integer.parseInt(JOptionPane.showInputDialog("Skriv inn filmnummer")));
	} else if (brukervalg == 3) {
		String sokeord = JOptionPane.showInputDialog("Skriv inn sokeord på ein tittel");
		tekstgr.skrivUtFilmDelstrengITittel(filmer,sokeord);
		
	} else if (brukervalg == 4) {
		String sokeord = JOptionPane.showInputDialog("Skriv inn sokeord på ein produsent");
		tekstgr.skrivUtFilmProdusent(filmer,sokeord);
		
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

