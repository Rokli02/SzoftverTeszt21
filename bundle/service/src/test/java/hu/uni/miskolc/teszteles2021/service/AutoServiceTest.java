package hu.uni.miskolc.teszteles2021.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.times;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.mockito.AdditionalMatchers;
import org.mockito.Mockito;

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

public class AutoServiceTest {
	private AutoService service;
	private Collection<Auto> autok;
	private AutoDao mock;
	
	@Before
	public void setUp() throws AutoNemTalalhato, RendszamMarFoglalt, RendszamNemMegfelelo, GyartasiIdoNemMegfelelo, AjtokSzamaNemMegfelelo {
		mock = Mockito.mock(AutoDao.class);
		Auto auto1 = new Auto("Opel","Astra","1.2","ABC-123",Uzemanyag.BENZIN, LocalDate.of(2017, 5, 12),
							"#DEDEDE", false, "123456EE",Valto.MANUALIS_5_FOKOZAT, Kivitel.KOMBI, 5);
		Auto auto2 = new Auto("Kia","Picanto","1.0","ABC-222",Uzemanyag.BENZIN, LocalDate.of(2012, 8, 30),
							"#FFFFFF", true, "121212EE",Valto.MANUALIS_5_FOKOZAT, Kivitel.HATCHBACK, 4);
		Auto auto3 = new Auto("Renault","Thalia","1.2","ABC-333",Uzemanyag.DIESEL, LocalDate.of(2009, 12, 24),
							"#000000", false, "987654EE",Valto.AUTOMATA, Kivitel.SEDAN, 4);
		autok = new ArrayList<>();
		autok.add(auto1);
		autok.add(auto2);
		autok.add(auto3);
		service = new AutoService(mock);
		
		Mockito.when(mock.readAutoById(org.mockito.Matchers.anyString())).
				thenThrow(new AutoNemTalalhato());
		Mockito.doReturn(auto1).when(mock).readAutoById("ABC-123");
		Mockito.doReturn(auto2).when(mock).readAutoById("ABC-222");
		Mockito.doReturn(auto3).when(mock).readAutoById("ABC-333");
		Mockito.when(mock.readAllAutos()).thenReturn(autok);
		/*Mockito.when(mock.readAutoById(AdditionalMatchers.not(
				Mockito.matches("\\w\\w\\w-\\d\\d\\d")))).thenThrow(RendszamNemMegfelelo.class);*/
		Mockito.doThrow(RendszamNemMegfelelo.class).when(mock).readAutoById(
				AdditionalMatchers.not(Mockito.matches("\\w\\w\\w-\\d\\d\\d")));
		Mockito.doThrow(RendszamMarFoglalt.class).when(mock).createAuto(auto1);
		Mockito.doThrow(RendszamMarFoglalt.class).when(mock).createAuto(auto2);
		Mockito.doThrow(RendszamMarFoglalt.class).when(mock).createAuto(auto3);
	}
	
	@Test
	public void test() {
		assertEquals(3, service.getAllAuto().size());
		for (Auto a : autok) {
			MatcherAssert.assertThat(autok, Matchers.hasItem(a));
		}
	}

	@Test
	public void testVanKorozottAuto() {
		assertNotEquals(0,service.getAllKorozottAuto());
	}
	
	@Test
	public void testAutoMasolat() throws RendszamNemMegfelelo, GyartasiIdoNemMegfelelo, AjtokSzamaNemMegfelelo {
		Auto auto = new Auto("Opel","Astra","1.2","ABC-123",Uzemanyag.BENZIN, LocalDate.of(2017, 5, 12),
				"#DEDEDE", false, "123456EE",Valto.MANUALIS_5_FOKOZAT, Kivitel.KOMBI, 5);
		MatcherAssert.assertThat(autok, Matchers.hasItem(auto));
	}
	
	@Test
	public void testAutoByRendszam() throws AutoNemTalalhato {
		service.getAutoByRendszam("ABC-123");
	}
	
	@Test(expected = RendszamNemMegfelelo.class)
	public void testRosszRendszamLekerdezes() throws AutoNemTalalhato {
		service.getAutoByRendszam("kiscica");
	}
	
	@Test(expected = RendszamMarFoglalt.class)
	public void testDuplum() throws RendszamMarFoglalt, RendszamNemMegfelelo, GyartasiIdoNemMegfelelo, AjtokSzamaNemMegfelelo {
		Auto auto = new Auto("Opel","Astra","1.2","ABC-123",Uzemanyag.BENZIN, LocalDate.of(2017, 5, 12),
				"#DEDEDE", false, "123456EE",Valto.MANUALIS_5_FOKOZAT, Kivitel.KOMBI, 5);
		service.addAuto(auto);
	}
	
	/*
	@AfterClass
	public void verify() throws RendszamMarFoglalt {
		Mockito.verify(mock, Mockito.times(2)).createAuto(org.mockito.Matchers.anyObject());;
	}*/
}
