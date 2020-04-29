package stef.dailycodingproblem;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ElementsSumK {

	/**
	 * This problem was recently asked by Google.
	 * 
	 * Given a list of numbers and a number k, return whether any two numbers from
	 * the list add up to k. For example, given [10, 15, 3, 7] and k of 17, return
	 * true since 10 + 7 is 17. Bonus: Can you do this in one pass?
	 * 
	 * Solution: create a map where we add elements as we parse the list. The map
	 * will have the integer value as key and boolean true as value. When we check
	 * the next element, we check if the map contains k - current value with value
	 * true. If yes, then the list contains the 2 elements that sum up to k. Those
	 * elements are the current value, and the k - current value that was added in
	 * the map before.
	 * 
	 * step 1: map.put(current_value & true) step 2: if map.get(k - current_value)
	 * is true then solution is current_value and map.get(k - current_value).
	 * current_value + k - current_value = k step 3: else do step 1.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> elements = Arrays.asList(10, 15, 32, 43, 25, 13, 567, 23, 54, 764, 32, 65, 23, 643, 3415, 32, 43,
				25, 13, 567, 23, 54, 764, 32, 65, 23, 643, 3415, 32, 43, 25, 13, 567, 23, 54, 764, 32, 65, 23, 643, 34,
				7);
		int k = 17;

		Instant start = Instant.now();
		listHasElementsThatSumToK(elements, k);
		Instant end = Instant.now();
		Duration elapsed = Duration.between(start, end);
		System.out.println("The process took: " + elapsed.getNano() + " nanoseconds");
		System.out.println("The process took: " + elapsed.getSeconds() + " seconds");

		Instant startInef = Instant.now();
		inefficient(elements, k);
		Instant endInef = Instant.now();
		Duration elapsedInef = Duration.between(startInef, endInef);
		System.out.println("The inefficient process took: " + elapsedInef.getNano() + " nanoseconds");
		System.out.println("The inefficient process took: " + elapsedInef.getSeconds() + " seconds");
	}

	/**
	 * @param elements - The list of elements to check
	 * @param k        - The wanted sum of the 2 elements
	 * @return - The boolean result. True means the {@link} elements has 2 elements
	 *         thats sum up to {@link} k.
	 */
	public static Boolean listHasElementsThatSumToK(List<Integer> elements, int k) {
		HashMap<Integer, Boolean> sumElements = new HashMap<Integer, Boolean>();
		Boolean result = Boolean.FALSE;

		Iterator<Integer> iterator = elements.iterator();
		while (iterator.hasNext()) {
			Integer currentValue = iterator.next();
			if (sumElements.getOrDefault(k - currentValue, Boolean.FALSE)) {
				result = Boolean.TRUE;
				System.out.println("True! Found 2 elements that sum up to " + k);
				System.out.println("Those elements are: " + currentValue + " and " + (k - currentValue));
				break;
			} else {
				sumElements.put(currentValue, Boolean.TRUE);
			}
		}

		return result;

	}

	public static Boolean inefficient(List<Integer> elements, int k) {
		Boolean result = Boolean.FALSE;

		for (int i = 0; i < elements.size() - 1; i++) {
			for (int j = i + 1; j < elements.size(); j++) {
				if (elements.get(i) + elements.get(j) == k) {
					result = Boolean.TRUE;
					System.out.println("True! Found 2 elements that sum up to " + k);
					System.out.println("Those elements are: " + elements.get(i) + " and " + elements.get(j));
					break;
				}
			}
		}

		return result;
	}

}
