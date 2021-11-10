package dao.mongo;

import hu.uni.miskolc.teszteles2021.Auto;
import hu.uni.miskolc.teszteles2021.exceptions.AjtokSzamaNemMegfelelo;
import hu.uni.miskolc.teszteles2021.exceptions.GyartasiIdoNemMegfelelo;
import hu.uni.miskolc.teszteles2021.exceptions.RendszamNemMegfelelo;

public class AutoPojoConverter {
	
	public static AutoPojo autoToPojoConvert(Auto auto) {
		AutoPojo pojo = new AutoPojo(auto.getGyarto(), auto.getModell(), auto.getHengerurtartalom(),
				auto.getRendszam(), auto.getUzemanyag(), auto.getGyartasiIdo(), auto.getSzinHex(),
				auto.isKorozott(), auto.getForgalmiSzama(), auto.getValto(), auto.getKivitel(), 
				auto.getAjtokSzama());
		return pojo;
	}
	
	public static Auto pojoToAutoConvert(AutoPojo pojo) {
		Auto auto;
		try {
			auto = new Auto(pojo.getGyarto(), pojo.getModell(), pojo.getHengerurtartalom(),
					pojo.getRendszam(), pojo.getUzemanyag(), pojo.getGyartasiIdo(), pojo.getSzinHex(),
					pojo.isKorozott(), pojo.getForgalmiSzama(), pojo.getValto(), pojo.getKivitel(), 
					pojo.getAjtokSzama());
			return auto;
		} catch (RendszamNemMegfelelo | GyartasiIdoNemMegfelelo | AjtokSzamaNemMegfelelo e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
