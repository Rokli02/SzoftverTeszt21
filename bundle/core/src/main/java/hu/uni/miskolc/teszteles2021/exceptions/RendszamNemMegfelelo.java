package hu.uni.miskolc.teszteles2021.exceptions;

public class RendszamNemMegfelelo extends Exception {

	public RendszamNemMegfelelo() {
		super("Nem megfelelő a rendszám!");
	}
	
	public RendszamNemMegfelelo(String message) {
		super(message);
	}
}
