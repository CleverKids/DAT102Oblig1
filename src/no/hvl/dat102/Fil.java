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

	private static final String SKILLE = null;

	public static FILMarkivADT lesFraFil(String filnanvn) {

		FILMarkivADT filmarkiv;

		final String SKILLE = "#"; // kan v�re parameter n�r vi lager metode

		FileReader FilmarkivFil = null;
		BufferedReader innfil = null;
		String FILM_FIL = filnanvn + ".txt";

		try {
			// // 1 - FileReader
			FilmarkivFil = new FileReader(FILM_FIL);
		}

		catch (FileNotFoundException unntak) {
			System.out.println("Finner ikke filen " + FILM_FIL);
			System.exit(1);
			// Vi kan lage script som kj�rer programmet fra kommandolinjen
			// og fanger opp returkoden ved System.exit
			//
		}

		try {
			// 2 - BufferedReader
			innfil = new BufferedReader(FilmarkivFil);
			
			int linjer = 0;
			while (innfil.readLine() != null) {
				linjer++;
			}
			
			// 3 - Leser den f�rste posten som er antall info-poster
			String linje = innfil.readLine();


			
			


			// 4 - Les postene, en hel post om gangen
			String filmLinje = innfil.readLine();

			//while (innfil.readLine() != null) {
				for (int i = 0; i < linjer; i++) {
				String[] felt = filmLinje.split(SKILLE);
				// http://docs.oracle.com/javase/8/docs/api/java/lang/String.html#split(java.lang.String,
				// int)

				int filmnr = Integer.parseInt(felt[0]);
				String produsent = felt[1];
				String tittel = felt[2];
				int lanseringsaar = Integer.parseInt(felt[3]);
				String sjanger = felt[4];
				String filmselskap = felt[5];

				Film f = new Film(filmnr, produsent, tittel, lanseringsaar, sjanger, filmselskap);
				
				filmarkiv.leggTilFilm(f);

				filmLinje = innfil.readLine();
			}

			// 4 - Lukk filen
			innfil.close();

		} catch (IOException e) {
			System.out.println("Feil ved lesing av fil: " + e);
			System.exit(2);
		}
		return filmarkiv;

	}

	final String ANSATT_FIL = "ansatte.txt"; // parameter n�r vi lager metode

	Ansatt anne = new Ansatt("Anne", "Dahl", 220, Ansatt.KVINNE);
	Ansatt knut = new Ansatt("Knut", "Olsen", 180, Ansatt.MANN);
	int antall = 2;

	try
	{
		// 1 - FileWriter
		FileWriter ansFil = new FileWriter(ANSATT_FIL, false);

		// 2 - PrintWriter
		PrintWriter utfil = new PrintWriter(ansFil);

		// 3 - Skriver f�rst ut antall ansatt-info-er p� den f�rste linjen
		utfil.println(antall);

		// Hvis vi tar imot en tabell av ansatte, ville vi her lage en l�kke der
		// vi for hver ansatt henter ut feltvariable og skriver de ut p� samme linje

		// 3 - Skriv postene, felt for felt
		utfil.print(anne.getFornavn());
		utfil.print(SKILLE);
		utfil.print(anne.getEtternavn());
		utfil.print(SKILLE);
		utfil.print(anne.getTimeloenn());
		utfil.print(SKILLE);
		utfil.print(anne.isKjoenn());
		utfil.println();

		utfil.print(knut.getFornavn());
		utfil.print(SKILLE);
		utfil.print(knut.getEtternavn());
		utfil.print(SKILLE);
		utfil.print(knut.getTimeloenn());
		utfil.print(SKILLE);
		utfil.print(knut.isKjoenn());
		utfil.println();

		// 4 - Lukk filen
		utfil.close();

	}catch(
	IOException e)
	{
		System.out.println("Feil ved skriving til fil : " + e);
		System.exit(3);
	}
}

}