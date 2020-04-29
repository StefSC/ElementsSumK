# ElementsSumK

This problem was recently asked by Google. 
Given a list of numbers and a number k, return whether any two numbers from
the list add up to k. For example, given [10, 15, 3, 7] and k of 17, return
true since 10 + 7 is 17.

<b>Bonus: Can you do this in one pass?</b>

Solution: create a map where we add elements as we parse the list. The map
will have the integer value as key and boolean true as value. When we check
the next element, we check if the map contains k - current value with value
true. If yes, then the list contains the 2 elements that sum up to k. Those
elements are the current value, and the k - current value that was added in
the map before.

step 1: map.put(current_value & true) step 2: if map.get(k - current_value)
is true then solution is current_value and map.get(k - current_value).
current_value + k - current_value = k step 3: else do step 1.
