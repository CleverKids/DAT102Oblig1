package no.hvl.dat102;

public class Film {

	private int filmnr;
	private String produsent;
	private String tittel;
	private int lanseringsaar;
	private Sjanger sjanger;
	private String filmselskap;

	public Film() {
		
	}

	public Film(int filmnr, String produsent, String tittel, int lanseringsaar, String sjanger, String filmselskap) {
		this.filmnr = filmnr;
		this.produsent = produsent;
		this.tittel = tittel;
		this.lanseringsaar = lanseringsaar;
		this.sjanger = Sjanger.finnSjanger(sjanger);
		this.filmselskap = filmselskap;
	}

	public int getFilmnr() {
        return filmnr;
    }
    
    public void setFilmnr(int filmnr) {
        this.filmnr = filmnr;
    }
    
    public String getProdusent() {
        return produsent;
    }
    
    public void setProdusent(String produsent) {
        this.produsent = produsent;
    }
    
    public String getTittel() {
        return tittel;
    }
    
    public void setTittel(String tittel) {
        this.tittel = tittel;
    }
    
    public int getLanseringsaar() {
    	return lanseringsaar;
    }
    
    public void setLanseringsaar(int lanseringsaar) {
    	this.lanseringsaar = lanseringsaar;
    }
    
    public Sjanger getSjanger() {
    	return sjanger;
    }
    
    public void setSjanger(String sjanger) {
    	this.sjanger = Sjanger.finnSjanger(sjanger);
    }
    
    public String getFilmselskap() {
        return filmselskap;
    }
    
    public void setFilmselskap(String filmselskap) {
        this.filmselskap = filmselskap;
    }
    
    public String toString() {
    	return sjanger + " filmen " + tittel + " ble laget av filmselskapet " + filmselskap + " i �ret " +
    	lanseringsaar + ",\n og ble produsert av " + produsent;
    }

}
