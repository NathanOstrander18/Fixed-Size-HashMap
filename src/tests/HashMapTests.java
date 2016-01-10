/*
 * Nathan Ostrander
 * Tests for FSHashMap Methods
 * 10/30/15
 */
package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Map.FSHashMap;

public class HashMapTests {
	private final int SIZE = 8;
	FSHashMap<String> map = new FSHashMap<String>(SIZE);
	
	@Test
	public void setValuesTest(){
		assertTrue(map.set("a", "Aardvark"));
		assertTrue(map.set("c", "Cat"));
		assertTrue(map.set("l", "Lion"));
		assertTrue(map.set("h", "Horse"));
		assertTrue(map.set("d", "Dog"));
		assertTrue(map.set("r", "Raindeer"));
		assertTrue(map.set("q", "Quail"));
		assertTrue(map.set("m", "Manatee"));
		assertTrue(map.set("p", "Porcupine"));
		assertTrue(map.set("s", "Shark"));
		assertTrue(map.set("y", "Yellowtail"));
		assertTrue(map.set("z", "Zebra"));
	}
	@Test
	public void testGet() {
		assertTrue(map.set("a", "Aardvark"));
		assertTrue(map.set("c", "Cat"));
		assertTrue(map.set("l", "Lion"));
		assertTrue(map.set("h", "Horse"));
		assertTrue(map.set("d", "Dog"));
		assertTrue(map.set("r", "Raindeer"));
		assertTrue(map.set("q", "Quail"));
		assertTrue(map.set("m", "Manatee"));
		assertTrue(map.set("p", "Porcupine"));
		assertTrue(map.get("a").equals("Aardvark"));
		assertTrue(map.get("p").equals("Porcupine"));
		assertTrue(map.get("q").equals("Quail"));
	}
	
	@Test
	public void testDelete() {
		assertTrue(map.set("a", "Aardvark"));
		assertTrue(map.set("c", "Cat"));
		assertTrue(map.set("l", "Lion"));
		assertTrue(map.set("h", "Horse"));
		assertTrue(map.set("d", "Dog"));
		assertTrue(map.set("r", "Raindeer"));
		assertTrue(map.set("q", "Quail"));
		assertTrue(map.set("m", "Manatee"));
		assertTrue(map.set("p", "Porcupine"));
		assertTrue(map.delete("m").equals("Manatee"));
		assertNull(map.get("m"));
	}
	
	@Test
	public void testLoad() {
		assertTrue(map.set("a", "Aardvark"));
		assertTrue(map.set("b", "Cat"));
		assertTrue(map.set("c", "Lion"));
		assertTrue(map.set("d", "Horse"));
		
		assertTrue(map.load() == .5);
	}
	
	@Test
	public void testLoadWithCollision() {
		assertTrue(map.set("a", "Aardvark"));
		assertTrue(map.set("b", "Cat"));
		assertTrue(map.set("c", "Lion"));
		assertTrue(map.set("d", "Horse"));
		assertTrue(map.set("e", "Dog"));
		assertTrue(map.set("f", "Raindeer"));
		assertTrue(map.set("g", "Quail"));
		assertTrue(map.set("i", "Porcupine"));
		assertTrue(map.set("j", "Shark"));
		assertTrue(map.set("k", "Yellowtail"));
		assertTrue(map.set("l", "Zebra"));
		
		assertTrue(map.load() <= 8);
	}
	
	

}
