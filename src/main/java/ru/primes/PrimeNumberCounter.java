package ru.primes;

public class PrimeNumberCounter {
	private static final int NUMBER_LIMIT = 50_000_000;

	// можем менять границу для применения методов (здесь
	// 2000000 взято с потолка в качестве примера)
	private static final int STRATEGY_THRESHOLD = 2_000_000;

	public static void main(String[] args) {
		/*
		 * Ниже приведена такая реализация, чтобы показать требуемую связь
		 * классов с одним интерфейсом. По-хорошему я бы реализовал два
		 * независимых класса для метода решета и метода Миллера: решето для
		 * чисел с 1 по NUMBER_LIMIT, а Миллера-Рабина - c NUMBER_LIMIT по М (диапазон больших чисел)
		 */
		IPrimeNumbersCounter strategy;
//		if (STRATEGY_THRESHOLD < NUMBER_LIMIT) {
			// для больших чисел предпочтительнее использовать
			// вероятностные методы (в нашем случае метод
			// Рабина-Миллера)
			strategy = new MillerRabinStrategy();
			calculatePrimes(strategy);
//		} else
			// для малых чисел сгодится решето
			strategy = new EratosthenesStrategy();
			calculatePrimes(strategy);
	}

	private static void calculatePrimes(IPrimeNumbersCounter strategy) {
		long startTime;
		long endTime;
		startTime = System.currentTimeMillis();
		System.out.println(strategy.getPrimesCount(NUMBER_LIMIT));
		endTime = System.currentTimeMillis();
		System.out.println("Process time for " + strategy.getName() + ": " + (endTime - startTime));
	}
}
