package hu.uni.miskolc.teszteles2021;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import hu.uni.miskolc.teszteles2021.enums.Kivitel;
import hu.uni.miskolc.teszteles2021.enums.Uzemanyag;
import hu.uni.miskolc.teszteles2021.enums.Valto;
import hu.uni.miskolc.teszteles2021.exceptions.AjtokSzamaNemMegfelelo;
import hu.uni.miskolc.teszteles2021.exceptions.GyartasiIdoNemMegfelelo;
import hu.uni.miskolc.teszteles2021.exceptions.RendszamNemMegfelelo;

public class Auto implements HanggalRendelkezo {
    public static Map<String, Integer> hengerurtartalomErtekek;

    static {
        hengerurtartalomErtekek = new HashMap<>();
        hengerurtartalomErtekek.put("1.0", 998);
        hengerurtartalomErtekek.put("1.2", 1199);
        hengerurtartalomErtekek.put("1.4", 1390);
        hengerurtartalomErtekek.put("1.6", 1560);
    }

    //Adattagok
    protected String gyarto;
    protected String modell;
    protected Integer hengerurtartalom;
    protected String rendszam;
    protected Uzemanyag uzemanyag;
    protected LocalDate gyartasiIdo;
    protected String szinHex;
    protected boolean korozott;
    protected String forgalmiSzama;
    protected Valto valto;
    protected Kivitel kivitel;
    protected int ajtokSzama;

    @Override
    public void dudal() {
        System.out.println("Tütü");
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

    protected void setModell(String modell) {
        this.modell = modell;
    }

    public Integer getHengerurtartalom() {
        return hengerurtartalom;
    }

    public void setHengerurtartalom(String hengerurtartalom){
		this.hengerurtartalom = hengerurtartalomErtekek.get(hengerurtartalom);
    }
    
    public void setHengerurtartalom(Integer hengerurtartalom) {
    	this.hengerurtartalom = hengerurtartalom;
    }

    public String getRendszam() {
        return rendszam;
    }

    public void setRendszam(String rendszam) throws RendszamNemMegfelelo {
    	//TODO: regex
    	String regex = "^([^a-z0-9Q]{3}-(?!000)[0-9]{3})$";
    	if(!rendszam.matches(regex)) {
    		throw new RendszamNemMegfelelo(rendszam);
    	}
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

    protected void setGyartasiIdo(LocalDate gyartasiIdo) throws GyartasiIdoNemMegfelelo {
    	if(gyartasiIdo.isAfter(LocalDate.now()) || 
    	   gyartasiIdo.isBefore(LocalDate.of(1885, 1, 1))) {
    		throw new GyartasiIdoNemMegfelelo(gyartasiIdo);
    	}
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

    protected void setAjtokSzama(int ajtokSzama) throws AjtokSzamaNemMegfelelo {
    	if(ajtokSzama < 0 || ajtokSzama > 5) {
    		throw new AjtokSzamaNemMegfelelo(ajtokSzama);
    	}
        this.ajtokSzama = ajtokSzama;
    }
    
    public Auto(String gyarto, String modell, String hengerurtartalom, String rendszam, Uzemanyag uzemanyag,
            LocalDate gyartasiIdo, String szinHex, boolean korozott, String forgalmiSzama, Valto valto, Kivitel kivitel,
            int ajtokSzama) throws RendszamNemMegfelelo, GyartasiIdoNemMegfelelo, AjtokSzamaNemMegfelelo {
    super();
    setGyarto(gyarto);
    setModell(modell);
    setHengerurtartalom(hengerurtartalom);
    setRendszam(rendszam);
    setUzemanyag(uzemanyag);
    setGyartasiIdo(gyartasiIdo);
    setSzinHex(szinHex);
    setKorozott(korozott);
    setForgalmiSzama(forgalmiSzama);
    setValto(valto);
    setKivitel(kivitel);
    setAjtokSzama(ajtokSzama);
}

    public Auto(String gyarto, String modell, Integer hengerurtartalom, String rendszam, Uzemanyag uzemanyag,
                LocalDate gyartasiIdo, String szinHex, boolean korozott, String forgalmiSzama, Valto valto, Kivitel kivitel,
                int ajtokSzama) throws RendszamNemMegfelelo, GyartasiIdoNemMegfelelo, AjtokSzamaNemMegfelelo {
        super();
        setGyarto(gyarto);
        setModell(modell);
        setHengerurtartalom(hengerurtartalom);
        setRendszam(rendszam);
        setUzemanyag(uzemanyag);
        setGyartasiIdo(gyartasiIdo);
        setSzinHex(szinHex);
        setKorozott(korozott);
        setForgalmiSzama(forgalmiSzama);
        setValto(valto);
        setKivitel(kivitel);
        setAjtokSzama(ajtokSzama);
    }
    
    public Auto() {
    	
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ajtokSzama;
		result = prime * result + ((forgalmiSzama == null) ? 0 : forgalmiSzama.hashCode());
		result = prime * result + ((gyartasiIdo == null) ? 0 : gyartasiIdo.hashCode());
		result = prime * result + ((gyarto == null) ? 0 : gyarto.hashCode());
		result = prime * result + ((hengerurtartalom == null) ? 0 : hengerurtartalom.hashCode());
		result = prime * result + ((kivitel == null) ? 0 : kivitel.hashCode());
		result = prime * result + (korozott ? 1231 : 1237);
		result = prime * result + ((modell == null) ? 0 : modell.hashCode());
		result = prime * result + ((rendszam == null) ? 0 : rendszam.hashCode());
		result = prime * result + ((szinHex == null) ? 0 : szinHex.hashCode());
		result = prime * result + ((uzemanyag == null) ? 0 : uzemanyag.hashCode());
		result = prime * result + ((valto == null) ? 0 : valto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Auto other = (Auto) obj;
		if (ajtokSzama != other.ajtokSzama)
			return false;
		if (forgalmiSzama == null) {
			if (other.forgalmiSzama != null)
				return false;
		} else if (!forgalmiSzama.equals(other.forgalmiSzama))
			return false;
		if (gyartasiIdo == null) {
			if (other.gyartasiIdo != null)
				return false;
		} else if (!gyartasiIdo.equals(other.gyartasiIdo))
			return false;
		if (gyarto == null) {
			if (other.gyarto != null)
				return false;
		} else if (!gyarto.equals(other.gyarto))
			return false;
		if (hengerurtartalom == null) {
			if (other.hengerurtartalom != null)
				return false;
		} else if (!hengerurtartalom.equals(other.hengerurtartalom))
			return false;
		if (kivitel != other.kivitel)
			return false;
		if (korozott != other.korozott)
			return false;
		if (modell == null) {
			if (other.modell != null)
				return false;
		} else if (!modell.equals(other.modell))
			return false;
		if (rendszam == null) {
			if (other.rendszam != null)
				return false;
		} else if (!rendszam.equals(other.rendszam))
			return false;
		if (szinHex == null) {
			if (other.szinHex != null)
				return false;
		} else if (!szinHex.equals(other.szinHex))
			return false;
		if (uzemanyag != other.uzemanyag)
			return false;
		if (valto != other.valto)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Auto [gyarto=" + gyarto + ", modell=" + modell + ", hengerurtartalom=" + hengerurtartalom
				+ ", rendszam=" + rendszam + ", uzemanyag=" + uzemanyag + ", gyartasiIdo=" + gyartasiIdo + ", szinHex="
				+ szinHex + ", korozott=" + korozott + ", forgalmiSzama=" + forgalmiSzama + ", valto=" + valto
				+ ", kivitel=" + kivitel + ", ajtokSzama=" + ajtokSzama + "]";
	}

    
}
