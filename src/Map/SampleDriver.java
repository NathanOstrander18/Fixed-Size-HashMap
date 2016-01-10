/*
 * Nathan Ostrander
 * Sample driver for FSHashMap
 * 10/30/15
 */
package Map;

public class SampleDriver {

	public static void main(String[] args) {
		FSHashMap<String> map = new FSHashMap<String>(16);
		System.out.println("Nathan Ostrander");
		System.out.println("Fixed hash map of size 16\n");
		System.out.println("key = 'a', value = 'red': " + map.set("a", "red"));
		System.out.println("key = 'b', value = 'blue': " + map.set("b", "blue"));
		System.out.println("key = 'c', value = 'green': " + map.set("c", "green"));
		System.out.println("key = 'q', value = 'yellow': " + map.set("q", "yellow"));
		System.out.println("key = 'aaa', value = 'black': " + map.set("aaa", "black"));
		
		System.out.println("Value at key 'a': " + map.get("a"));
		System.out.println("Value at key 'b': " + map.get("b"));
		System.out.println("Value at key 'c': " + map.get("c"));
		System.out.println("Value at key 'q': " + map.get("q"));
		System.out.println("Value at key 'aaa': " + map.get("aaa"));
		System.out.println("Load factor: " + map.load());
		
		System.out.println("Delete Value at key 'a': " + map.delete("a"));
		System.out.println("Value at key 'a': " + map.get("a"));
		System.out.println("Load factor: " + map.load());
		
		System.out.println("Delete value at key 'q': " + map.delete("q"));
		System.out.println("Value at key 'q': " + map.get("q"));
		
		System.out.println("Delete value at key 'b': " + map.delete("b"));
		System.out.println("Value at key 'b': " + map.get("b"));
		System.out.println("Load factor: " + map.load());
	}

}
