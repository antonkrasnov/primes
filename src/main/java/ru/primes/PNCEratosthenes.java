package ru.primes;

import java.util.BitSet;

/**
 * @author Anton Krasnov
 */
public class PNCEratosthenes implements PrimeNumbersCounter {

	@Override
	public int primeNumbersQuantity(int num) {
		final boolean PRINT = false;
		int count = 0;
		int i;
		BitSet b = new BitSet(num); // используем BitSet вместо boolean[] в
		// целях экономии памяти
		for (i = 2; i <= num; i++)
			b.set(i); // переводит все биты по индексам i в 1 (true)
		i = 2;
		while (i * i <= num) {
			if (b.get(i)) {
				if (PRINT)
					System.out.println(i);
				count++;
				int k = 2 * i;
				while (k <= num) {
					b.clear(k);
					k += i;
				}
			}
			i++;
		}
		while (i <= num) {
			if (b.get(i)) {
				if (PRINT)
					System.out.println(i);
				count++;
			}
			i++;
		}
		return count;
	}

}