
/**
 * Find a given element in sorted array.
 * 
 * arr= [1, 2, 3, 4, 5, 6]
 * 
 * follow up: If the sorted array is shifted left by unknown number, modify
 * existing binary search to find a element in modified array
 * 
 * arr = [4, 5, 6, 1, 2, 3]
 * 
 * @see http://www.careercup.com/question?id=5747740665446400
 *
 */
class RotatedBinarySearch {
	public static void main(String[] args) throws java.lang.Exception {
		int arr[] = { 4, 5, 6, 7, 1, 2, 3 };
		System.out.println(indexOf(arr, 5, 0, arr.length - 1));
		System.out.println(indexOf(arr, 2, 0, arr.length - 1));
		System.out.println(indexOf(arr, -1, 0, arr.length - 1));
	}

	public static int indexOf(int arr[], int val, int low, int high) {
		if (low > high) {
			return -1;
		}
		int mid = (low + high) / 2;
		if (arr[mid] == val) {
			return mid;
		}
		if (arr[low] < arr[mid] && val < arr[mid] && val > arr[low]) {
			return indexOf(arr, val, low, mid);
		}
		return indexOf(arr, val, mid + 1, high);

	}
}