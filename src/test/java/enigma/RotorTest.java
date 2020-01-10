package enigma;

import static org.junit.Assert.*;

import org.junit.Test;

public class RotorTest {
	
	Rotor rotor1 = Rotor.rotorFactory(
			"E K M F L G D Q V Z N T O W Y H X U S P A I B R C J", "Q");

	/*@Test
	public void test() {
		fail("Not yet implemented");
	}*/
	
	@Test
	public void test_Advance() {
	int actual = rotor1.getPosition();
	rotor1.advance();
	int expected = actual + 1; //Resultat attendu
	actual = rotor1.getPosition();
	assertEquals(expected, actual);
	}
	
	
	@Test
	public void test_to_Letter() {
	char actual = rotor1.toLetter(0);
	char expected = 'A';
	assertEquals(expected, actual);
	}
	
	@Test
	public void test_to_Index() {
	int actual = rotor1.toIndex('A');
	int expected = 0;
	assertEquals(expected, actual);
	}
	
}
