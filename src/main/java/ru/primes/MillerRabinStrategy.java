package ru.primes;

import java.math.BigInteger;

public class MillerRabinStrategy implements IPrimeNumbersCounter {

	@Override
	public int getPrimesCount(int num) {
		int count = 0;
		for (int i = 2; i <= num; i++) {
			BigInteger bigInteger = BigInteger.valueOf(i);
			if (bigInteger.isProbablePrime((int) Math.log(i)))
				count++;
		}
		return count;
	}

	@Override
	public String getName() {
		return getClass().getSimpleName();
	}

}