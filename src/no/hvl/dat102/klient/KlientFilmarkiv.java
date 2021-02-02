package no.hvl.dat102.klient;

import no.hvl.dat102.Filmarkiv;
import no.hvl.dat102.adt.FILMarkivADT;

public class KlientFilmarkiv {

	public static void main(String[] args) {

		FILMarkivADT filmer = new Filmarkiv();

		Meny meny = new Meny(filmer);
		meny.start();
	}

}
