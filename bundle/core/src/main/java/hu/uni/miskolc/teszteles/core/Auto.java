package hu.uni.miskolc.teszteles.core;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Auto implements HanggalRendelkezo{
	public static Map<String, Integer> hengerUrtartalomErtekek;
	
	static {
		hengerUrtartalomErtekek = new HashMap<>();
		hengerUrtartalomErtekek.put("1.0", 998);
		hengerUrtartalomErtekek.put("1.2", 1199);
		hengerUrtartalomErtekek.put("1.4", 1390);
		hengerUrtartalomErtekek.put("1.6", 1560);
		
	}
	
	private String gyarto;
	private String modell;
	private Integer hengerUrtartalom;
	private String rendszam;
	private Uzemanyag uzemanyag;
	private LocalDate gyartasiIdo;
	private String szinHex;
	private boolean korozott;
	private String forgalmiSzama;
	private Valto valto;
	private Kivitel kivitel;
	private int ajtokSzama;
	
	
	
	public Auto(String gyarto, String modell, String hengerUrtartalom, String rendszam,
			Uzemanyag uzemanyag, LocalDate gyartasiIdo, String szinHex, boolean korozott, String forgalmiSzama,
			Valto valto, Kivitel kivitel, int ajtokSzama) {
		super();
		this.gyarto = gyarto;
		this.modell = modell;
		this.setHengerUrtartalom(hengerUrtartalom);
		this.rendszam = rendszam;
		this.uzemanyag = uzemanyag;
		this.gyartasiIdo = gyartasiIdo;
		this.szinHex = szinHex;
		this.korozott = korozott;
		this.forgalmiSzama = forgalmiSzama;
		this.valto = valto;
		this.kivitel = kivitel;
		this.ajtokSzama = ajtokSzama;
	}

	@Override
	public void dudal() {
		System.out.println("T�t��");
	}

	public String getGyarto() {
		return gyarto;
	}

	protected void setGyarto(String gyarto) {
		this.gyarto = gyarto;
	}

	public String getModell() {
		return modell;
	}

	public void setModell(String modell) {
		this.modell = modell;
	}

	public Integer getHengerUrtartalom() {
		return hengerUrtartalom;
	}

	public void setHengerUrtartalom(String hengerUrtartalom) {
		this.hengerUrtartalom = hengerUrtartalomErtekek.get(hengerUrtartalom);
	}

	public String getRendszam() {
		return rendszam;
	}

	public void setRendszam(String rendszam) {
		this.rendszam = rendszam;
	}

	public Uzemanyag getUzemanyag() {
		return uzemanyag;
	}

	public void setUzemanyag(Uzemanyag uzemanyag) {
		this.uzemanyag = uzemanyag;
	}

	public LocalDate getGyartasiIdo() {
		return gyartasiIdo;
	}

	protected void setGyartasiIdo(LocalDate gyartasiIdo) {
		this.gyartasiIdo = gyartasiIdo;
	}

	public String getSzinHex() {
		return szinHex;
	}

	public void setSzinHex(String szinHex) {
		this.szinHex = szinHex;
	}

	public boolean isKorozott() {
		return korozott;
	}

	public void setKorozott(boolean korozott) {
		this.korozott = korozott;
	}

	public String getForgalmiSzama() {
		return forgalmiSzama;
	}

	public void setForgalmiSzama(String forgalmiSzama) {
		this.forgalmiSzama = forgalmiSzama;
	}

	public Valto getValto() {
		return valto;
	}

	public void setValto(Valto valto) {
		this.valto = valto;
	}

	public Kivitel getKivitel() {
		return kivitel;
	}

	protected void setKivitel(Kivitel kivitel) {
		this.kivitel = kivitel;
	}

	public int getAjtokSzama() {
		return ajtokSzama;
	}

	public void setAjtokSzama(int ajtokSzama) {
		this.ajtokSzama = ajtokSzama;
	}
	
	
}
