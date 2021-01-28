package oving2.film;

public enum Sjanger {
	Action, Drama, Komedie, Fantasi, Scifi;

	public static Sjanger finnSjanger(String navn) {
		Sjanger sjang = null;
		for (Sjanger sj : Sjanger.values()) {
			if (sj.toString().equals(navn.toUpperCase())) {
				sjang = sj;
				break;
			}
		}
		return sjang;
	}

}
