Time complexity:
* If picking a good pivot: O(n(logn))
* Worst case scenario: O(n^2)


Step 1) Identify pivot
Step 2) Put items less than pivot in front of it and items bigger than it after
Step 3) Recursively sort the list before pivot and the list after pivot
