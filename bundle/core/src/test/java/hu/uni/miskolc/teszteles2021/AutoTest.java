package hu.uni.miskolc.teszteles2021;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import hu.uni.miskolc.teszteles2021.exceptions.AjtokSzamaNemMegfelelo;
import hu.uni.miskolc.teszteles2021.exceptions.GyartasiIdoNemMegfelelo;
import hu.uni.miskolc.teszteles2021.exceptions.RendszamNemMegfelelo;

public class AutoTest {
	Auto testauto;
	
	@Before
	public void initAuto() {
		testauto = new Auto();
	}
    
    @Test
    public void testAjtokSzamaMegfelelo() throws AjtokSzamaNemMegfelelo {
    	Auto auto = new Auto();
    	auto.setAjtokSzama(3);
    }
    
    @Test(expected = AjtokSzamaNemMegfelelo.class)
    public void testAjtokSzamaTulAlacsony() throws AjtokSzamaNemMegfelelo {
    	Auto auto = new Auto();
    	auto.setAjtokSzama(-1);
    }
    
    @Test(expected = AjtokSzamaNemMegfelelo.class)
    public void testAjtokSzamaTulMagas() throws AjtokSzamaNemMegfelelo {
    	Auto auto = new Auto();
    	auto.setAjtokSzama(6);
    }
    
     @Test
     public void testJoRendszam() throws RendszamNemMegfelelo {
    	 String rendszam = "ABC-123";
    	 testauto.setRendszam(rendszam);
    	 
     }
     
     @Test(expected = RendszamNemMegfelelo.class)
     public void testKotojelNelkuliRendszam() throws RendszamNemMegfelelo {
    	 String rendszam = "ABC123";
    	 testauto.setRendszam(rendszam);
     }
     
     @Test(expected = RendszamNemMegfelelo.class)
     public void testTulhosszubetusRendszam() throws RendszamNemMegfelelo {
    	 String rendszam = "ABCD-123";
    	 testauto.setRendszam(rendszam);
     }
     
     @Test(expected = RendszamNemMegfelelo.class)
     public void testTulhosszuSzamosRendszam() throws RendszamNemMegfelelo {
    	 String rendszam = "ABC-1234";
    	 testauto.setRendszam(rendszam);
     }
     
     @Test(expected = RendszamNemMegfelelo.class)
     public void testCsakSzamokRendszam() throws RendszamNemMegfelelo {
    	 String rendszam = "123-123";
    	 testauto.setRendszam(rendszam);
     }
     
     @Test(expected = RendszamNemMegfelelo.class)
     public void testCsakBetukRendszam() throws RendszamNemMegfelelo {
    	 String rendszam = "JEZ-ZUS";
    	 testauto.setRendszam(rendszam);
     }
     
     @Test(expected = RendszamNemMegfelelo.class)
     public void testkisBetusRendszam() throws RendszamNemMegfelelo {
    	 String rendszam = "abc-123";
    	 testauto.setRendszam(rendszam);
     }
     
     @Test(expected = RendszamNemMegfelelo.class)
     public void testQTartalmazoRendszam() throws RendszamNemMegfelelo {
    	 String rendszam = "AQC-123";
    	 testauto.setRendszam(rendszam);
     }
     
     @Test
     public void testJoGyartasiIdo() throws GyartasiIdoNemMegfelelo {
    	 String gyartasiIdo = "2021-04-17";
    	 testauto.setGyartasiIdo(LocalDate.parse(gyartasiIdo));
     }
     
     @Test(expected = GyartasiIdoNemMegfelelo.class)
     public void testKoraiGyartasiIdo() throws GyartasiIdoNemMegfelelo {
    	 String gyartasiIdo = "0220-04-17";
    	 testauto.setGyartasiIdo(LocalDate.parse(gyartasiIdo));
     }
     
     @Test(expected = GyartasiIdoNemMegfelelo.class)
     public void testKesoiGyartasiIdo() throws GyartasiIdoNemMegfelelo {
    	 String gyartasiIdo = "2021-11-17";
    	 testauto.setGyartasiIdo(LocalDate.parse(gyartasiIdo));
     }
     
     @Test
     public void testSzinkodSetter() {
    	 String szinkod = "#FFFFFF";
    	 testauto.setSzinHex(szinkod);
    	 
     }
}