package no.hvl.data102;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import no.hvl.data102.adt.FILMarkivADT;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Fil {
	
	private static final String SKILLE = null; 
	 
	public static FILMarkivADT lesFraFil(String filnavn){
		
		FILMarkivADT filmarkiv = new Filmarkiv();
		
		final String SKILLE = "#";
		
		FileReader FilmarkivFil = null;
		BufferedReader innfil= null;
		String FILM_FIL = filnavn + ".txt";
		
		try { 
			FilmarkivFil = new FileReader(FILM_FIL);
		}
		
		catch (FileNotFoundException unntak) {
			System.out.println("Finner ikke filen " + FILM_FIL);
			System.exit(1);
		}
		
		try { 
			innfil = new BufferedReader(FilmarkivFil);
			String filmLinje = innfil.readLine();
			
			while (filmLinje != null) {
				String[] felt = filmLinje.split(SKILLE);
				
				int filmnr = Integer.parseInt(felt[0]);
				String produsent = felt[1];
				String tittel = felt[2];
				int år = Integer.parseInt(felt[3]);
				String Sjanger = felt[4];
				String filmselskap = felt[5];
				
				Film x = new Film(filmnr, produsent, tittel, år, Sjanger, filmselskap);
				
				filmarkiv.leggTilFilm(x);
				
				filmLinje = innfil.readLine();
			}
			
			innfil.close();
		} catch (IOException e) {
			System.out.println("Feil ved lesingen av filen: " + e);
			System.exit(2);
		}
		return filmarkiv;
	}
	
	// Lagre et Filmarkiv til tekstfil
	public static void skrivTilFil(FILMarkivADT filmarkiv, String filnavn){
		final String ARKIV_UTSKRIFT_FIL = filnavn + ".txt";
		try {
			FileWriter utskriftfil = new FileWriter(ARKIV_UTSKRIFT_FIL, false);
			PrintWriter utfil = new PrintWriter(utskriftfil);
			
			Film[] filmTab = filmarkiv.hentFilmTabell();
			for (int i=0; i<filmarkiv.antall(); i++) {
				utfil.print(filmTab[i].getFilmnr());
				utfil.print(SKILLE);
				utfil.print(filmTab[i].getProdusent());
				utfil.print(SKILLE);
				utfil.print(filmTab[i].getTittel());
				utfil.print(SKILLE);
				utfil.print(filmTab[i].getÅr());
				utfil.print(SKILLE);
				utfil.print(filmTab[i].getSjanger());
				utfil.print(SKILLE);
				utfil.print(filmTab[i].getFilmselskap());
				utfil.println();
			}
			utfil.close();
			
		} catch (IOException e) {
			System.out.print("Feil ved skriving til filen: " + e);
			System.exit(3);
			
		}
	}
}
