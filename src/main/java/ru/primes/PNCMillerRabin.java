package ru.primes;

import java.math.BigInteger;

/**
 * @author Anton Krasnov
 */
public class PNCMillerRabin implements PrimeNumbersCounter {

	@Override
	public int primeNumbersQuantity(int num) {
		int count = 0;
		for (int i = 2; i <= num; i++) {
			BigInteger bigInteger = BigInteger.valueOf(i);
			if (bigInteger.isProbablePrime((int) Math.log(i)))
				count++;
		}
		return count;
	}

}