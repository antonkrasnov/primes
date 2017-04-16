package ru.primes;

/**
 * @author Anton Krasnov
 */
public class PrimeNumberCounter {

	public static void main(String[] args) {
		int N = 1000000;
		int M = 2000000; // можем менять границу для применения методов (здесь
		// 2000000 взято с потолка в качестве примера)
		//System.out.println(new MillerRabinStrategy().primeNumbersQuantity(N));
		/*
		 * Ниже приведена такая реализация, чтобы показать требуемую связь
		 * классов с одним интерфейсом. По-хорошему я бы реализовал два
		 * независимых класса для метода решета и метода Миллера: решето для
		 * чисел с 1 по N, а Миллера-Рабина - c N по М (диапазон больших чисел)
		 */
		IPrimeNumbersCounter counter;
		if (M < N) { // для больших чисел предпочтительнее использовать
			// вероятностные методы (в нашем случае метод
			// Рабина-Миллера)
			counter = new MillerRabinStrategy();
			System.out.println(counter.primeNumbersQuantity(N));
		} else // для малых чисел сгодится решето
			counter = new EratosthenesStrategy();
			System.out.println(counter.primeNumbersQuantity(N));
	}
}
