package no.hvl.data102;

public class Film {
	private int filmnr;
	private String produsent;
	private String tittel;
	private int Âr;
	private Sjanger sjanger;
	private String filmselskap;
	
	public Film() {
		
	}
	
	public Film(int filmnr, String produsent, String tittel, int Âr, String sjanger, String filmselskap) {
		this.filmnr = filmnr;
		this.produsent = produsent;
		this.tittel = tittel;
		this.Âr = Âr;
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
	
	public int get≈r() {
		return Âr;
	}
	
	public void set≈r(int Âr) {
		this.Âr = Âr;
	}
	
	public String getFilmselskap() {
		return filmselskap;
	}
	
	public void setFilmselskap(String filmselskap) {
		this.filmselskap = filmselskap;
	}
	
	public Sjanger getSjanger() {
        return sjanger;
    }
    
    public void setSjanger(String sjanger) {
        this.sjanger = Sjanger.finnSjanger(sjanger);
    }

}
