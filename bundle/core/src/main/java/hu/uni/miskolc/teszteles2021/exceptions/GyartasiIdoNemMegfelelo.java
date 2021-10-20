package hu.uni.miskolc.teszteles2021.exceptions;

import java.time.LocalDate;

public class GyartasiIdoNemMegfelelo extends Exception {

	public GyartasiIdoNemMegfelelo(LocalDate message) {
		super(message.toString());
	}

}
