package solutions.pack2;

public class Main {
	public static void main(String[] args) {
		testIsPrime012();
	}

	private static void testIsPrime012() {
		int N = 100;
		int count = 0;
		L2_IsPrimeInterface obj = new IsPrime0();
		for (int n = 1; n < N; n++)
			if (obj.isPrime(n)) count++;
		System.out.println("Pi (" + N + ")= " + count);
		bench_isPrime(obj); // <---
		System.out.println();
		System.out.println("==============================");

		count = 0;
		obj = new IsPrime1();
		for (int n = 1; n < N; n++)
			if (obj.isPrime(n)) count++;
		System.out.println("Pi (" + N + ")= " + count);
		bench_isPrime(obj); // <---
		System.out.println();
		System.out.println("==============================");


		count = 0;
		obj = new IsPrime2();
		for (int n = 1; n < N; n++)
			if (obj.isPrime(n)) count++;
		System.out.println("Pi (" + N + ")= " + count);
		bench_isPrime(obj); // <---
		System.out.println();
		System.out.println("==============================");

	}

	public static void bench_isPrime(L2_IsPrimeInterface obj) {
		int your_cpu_factor = 1; /* increase by 10 times */
		int N = 100;
		int count = 0;
		// long start = 0;
		for (N = 100_000; N <= 1_000_000 * your_cpu_factor; N+= 100_000 * your_cpu_factor) {
		count = 0;
		long start = System.currentTimeMillis();
		for (int n = 1; n < N; n++) {
		if (obj.isPrime(n)) count++;
		}
		long time = (System.currentTimeMillis() - start);
		System.out.println(N + "\t" + count + "\t" + time);
		System.out.printf("%s\t %s\t %s",
			String.format("%,d",N), String.format("%,d",count),
				String.format("%,d",time));
		}
	}
}
