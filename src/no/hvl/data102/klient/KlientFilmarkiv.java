package no.hvl.data102.klient;

import no.hvl.data102.Filmarkiv;
import no.hvl.data102.adt.FILMarkivADT;

public class KlientFilmarkiv {

	public static void main(String[] args) {
		
		FILMarkivADT filmer = new Filmarkiv();
		
		Meny meny = new Meny(filmer);
		meny.start();
	}
}
