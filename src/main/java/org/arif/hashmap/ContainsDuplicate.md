# Intuition
Initially, consider the requirements of the problem: checking for duplicates within a certain index distance (k).
Contemplate the use of additional data structures that allow for fast access to previously seen numbers and their indices.

# Approach
Utilize a HashMap to store number indices.
Iterate through the array, for each element:
- Check if the element is already in the map.
- If it is, check if the current index and the stored index are within the distance k.
- If they are, return true (found the nearby duplicate).
- Update the map with the current index of the element.

# Complexity
- Time complexity:
  O(n), where n is the length of the array, since the loop goes through each element once.
- Space complexity:
  O(min(n, k)), since the map will store at most min(n, k) elements. For k >= n, all elements could be stored; for k < n, only k elements will be stored at any time.

# Code
````
public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }
````