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
	
	brukervalg = Integer.parseInt(JOptionPane.showInputDialog("Skriv inn: 1 for � legge til ein film,"
			+ " 2 for � vise informasjon om ein film,"
			+ " 3 for � s�ke etter tittel,"
			+ " 4 for � finne filmene til ein produsent,"
			+ " 5 for � vise sjanger informasjon."));
	switch(brukervalg) {
	case 1: Tekstgrensesnitt.lesFilm();
	case 2: Tekstgrensesnitt.visFilm();
	case 3: Tekstgrensesnitt.visFilm();
	case 4: Tekstgrensesnitt.visFilm();
	case 5: Tekstgrensesnitt.visFilm();
	
	}
	
	
	
	}
	}

