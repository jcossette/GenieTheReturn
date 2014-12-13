package genieprojet.tests.annuaire;

import static org.junit.Assert.*;
import genieprojet.annuaire.Personne;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PersonneTest {
	
	Personne personne;
	
	@Before
	public void setUp() {
		personne = new Personne();
	}

	@Test
	public void testSetTrancheAgeValidEnfant() {		
		personne.setTrancheAge(10);
		assertEquals("Un age de 10 ans est considere comme un enfant", personne.getAge(), "ENFANT");
	}
	
	@Test
	public void testSetTrancheValidAdulte() {
		personne.setTrancheAge(25);
		assertEquals("Un age de 18 ans est considere comme un adulte", personne.getAge(), "ADULTE");
	}
	
	@Test
	public void testSetTrancheAgeValidViellard() {
		personne.setTrancheAge(100);
		assertEquals("Un age de 100 ans est considere comme un viellard", personne.getAge(), "VIELLARD");
	}
	
	@Test
	public void testSetTrancheAgeInvalidZero() {
		try {
			personne.setTrancheAge(0);
			fail("Une personne ne peut pas avoir un age de 0");
		} catch (IllegalArgumentException e) {}
	}
	
	@Test
	public void testSetTrancheAgeInvalidNegatif() {
		try {
			personne.setTrancheAge(-1);
			fail("Une personne ne peut pas avoir un age negatif");
		} catch (IllegalArgumentException e) {}
	}

	@Test
	public void testSetTrancheAgeInvalidMax() {
		try {
			personne.setTrancheAge(200);
			fail("Une personne ne peut pas avoir plus de 150 ans");
		} catch (IllegalArgumentException e) {}
	}
}
