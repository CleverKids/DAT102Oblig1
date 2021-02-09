package no.hvl.dat102;

public class LinearNode<T> {
	private LinearNode<T> neste;
	private T element;
	
	public LinearNode() {
		neste = null;
		element = null;
	}
	
	public LinearNode(T elem) {
		neste = null;
		element = elem;
	}
}
