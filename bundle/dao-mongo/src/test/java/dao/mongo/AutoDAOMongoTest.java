package dao.mongo;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Collection;

import org.junit.Test;

import hu.uni.miskolc.teszteles2021.Auto;
import hu.uni.miskolc.teszteles2021.dao.AutoDao;
import hu.uni.miskolc.teszteles2021.enums.Kivitel;
import hu.uni.miskolc.teszteles2021.enums.Uzemanyag;
import hu.uni.miskolc.teszteles2021.enums.Valto;
import hu.uni.miskolc.teszteles2021.exception.AutoNemTalalhato;
import hu.uni.miskolc.teszteles2021.exception.RendszamMarFoglalt;
import hu.uni.miskolc.teszteles2021.exceptions.AjtokSzamaNemMegfelelo;
import hu.uni.miskolc.teszteles2021.exceptions.GyartasiIdoNemMegfelelo;
import hu.uni.miskolc.teszteles2021.exceptions.RendszamNemMegfelelo;

public class AutoDAOMongoTest {

	@Test
	public void testDatabase() throws RendszamNemMegfelelo, GyartasiIdoNemMegfelelo, AjtokSzamaNemMegfelelo, RendszamMarFoglalt, AutoNemTalalhato {
		AutoDao dao = new AutoDAOMongo("mongodb+srv://test:test@szoftverteszteles2021.bqwgi.mongodb.net/test?retryWrites=true&w=majority",
				"test", "autok");
		
		Auto auto1 = new Auto("Opel","Astra","1.2","ABC-123",Uzemanyag.BENZIN, LocalDate.of(2017, 5, 12),
				"#DEDEDE", false, "123456EE",Valto.MANUALIS_5_FOKOZAT, Kivitel.KOMBI, 5);
		
		//dao.createAuto(auto1);
		
		/*Collection<Auto> list = dao.readAllAutos();
		for (Auto auto : list) {
			System.out.println(auto);
		}*/
		
		System.out.println(dao.readAutoById("ABC-123"));
	}

}
