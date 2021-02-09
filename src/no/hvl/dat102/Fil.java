package no.hvl.dat102;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

import no.hvl.dat102.adt.FILMarkivADT;

import java.io.FileWriter;
import java.io.PrintWriter;

public class Fil {

	private static final String SKILLE = "#";

	public static FILMarkivADT lesFraFil(String filnanvn) {

		FILMarkivADT filmarkiv = new Filmarkiv();

		FileReader FilmarkivFil = null;
		BufferedReader innfil = null;
		String filmfil = filnanvn + ".txt";

		try {
			FilmarkivFil = new FileReader(filmfil);
		}

		catch (FileNotFoundException unntak) {
			System.out.println("Finner ikke filen " + filmfil);
			System.exit(1);
		}

		try {
			innfil = new BufferedReader(FilmarkivFil);

			String filmLinje = innfil.readLine();

			while (filmLinje != null) {
				String[] felt = filmLinje.split(SKILLE);
				Film f = new Film(Integer.parseInt(felt[0]), felt[1], felt[2], Integer.parseInt(felt[3]), felt[4], felt[5]);
				filmarkiv.leggTilFilm(f);
				filmLinje = innfil.readLine();
			}

			innfil.close();

		} catch (IOException e) {
			System.out.println("Feil ved lesing av fil: " + e);
			System.exit(2);

		}
		return filmarkiv;
	}

	public static void skrivTilFil(FILMarkivADT filmarkiv, String filnavn) {

		final String ARKIV_UTSKRIFT_FIL = filnavn + ".txt"; 

		try {
			FileWriter utskriftFil = new FileWriter(ARKIV_UTSKRIFT_FIL, false);
			PrintWriter utfil = new PrintWriter(utskriftFil);

			Film[] filmTab = filmarkiv.hentFilmTabell();
			for (int i = 0; i < filmarkiv.antall(); i++) {
				utfil.print(filmTab[i].getFilmnr() + SKILLE);
				utfil.print(filmTab[i].getProdusent() + SKILLE);
				utfil.print(filmTab[i].getTittel() + SKILLE);
				utfil.print(filmTab[i].getLanseringsaar() + SKILLE);
				utfil.print(filmTab[i].getSjanger() + SKILLE);
				utfil.print(filmTab[i].getFilmselskap());
				utfil.println();
			}
			
			utfil.close();

		} catch (IOException e) {
			System.out.println("Feil ved skriving til fil : " + e);
			System.exit(3);
		}
	}
}
