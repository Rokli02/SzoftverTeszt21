package hu.uni.miskolc.teszteles2021.dao;

import java.util.Collection;

import hu.uni.miskolc.teszteles2021.Auto;
import hu.uni.miskolc.teszteles2021.exception.AutoNemTalalhato;
import hu.uni.miskolc.teszteles2021.exception.RendszamMarFoglalt;

public interface AutoDao {	//DAO -> Data Acces Object
	public Collection<Auto> readAllAutos();
	public Auto readAutoById(String rendzsam) throws AutoNemTalalhato;
	public void createAuto(Auto auto) throws RendszamMarFoglalt;
	public void updateAuto(Auto auto);
	public void deleteAuto(Auto auto);
	public void deleteAutoById(String rendszam);
}
