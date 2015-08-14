import java.util.Arrays;

public class BinkyWinky {
	public static void main2(String args[]) {
		System.out.println(getNumPrimeNumbers(65536));
		System.out.println(getNumPrimeNumbers2(65536));

		return;
	}
	
    public static void main(String args[])
    {
        System.out.println(getNumPrimeNumber(20));
        return;
    }
    
    static int getNumPrimeNumber(int n) {
        int result = 1;
        boolean isPrime;
        for (int i = 3; i < n; i+= 2) {
            isPrime = true;
            for (int j = 3; j < i; j += 2) {
                if(i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                result++; 
            }
        }
        return result;
    }      

	static int getNumPrimeNumbers(int n) {
		int result = 1; // smallest prime number is 2.
		for (int i = 3; i < n; i += 2) {
			boolean isPrime = true;
			double limit = Math.sqrt(i);
			for (int j = 3; j <= limit; j+=2) { // I have used sqrt
														// method of Math
														// package which find
														// square root of a
														// number. To check if
														// an integer(say n) is
														// prime you can check
														// if it is divisible by
														// any integer from 3 to
														// (n-1) or check from 3
														// to sqrt(n), first one
														// is less efficient and
														// will take more time.
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				result++;
			}
		}
		return result;
	}
	static int getNumPrimeNumbers2(int n) {
		boolean[] numbers = new boolean[n];
		Arrays.fill(numbers, true);
		numbers[0] = false;
		numbers[1] = false;
		// we know 0 and 1 are not prime.
	    for (int i=2;i<n;i++) {
	        //if the number is prime, 
	        //then go through all its multiples and make their values false.
	        if(numbers[i]) {
	            for (int j=2;i*j<n;j++) {
	                numbers[i*j] = false;
	            }
	        }
	    }
	    int result = 0;
	    for(boolean isPrime : numbers) {
	    	if(isPrime) {
	    		result++;
	    	}
	    }
	    return result;
	}
	 
	public static void org(String args[]) {
		int i, j, k, m;
		m = 0;
		for (i = 3; i < 65535; i += 2) {
			k = 1;
			for (j = 3; j <= i * i; j += 2) {
				if (i % j == 0) {
					k = 0;
					break;
				}
			}
			if (k == 1) {
				m++;
			}
		}
		System.out.println(m);
		return;
	}
}
