package pd.multithread.arraysum;

/*Scrivere un programma Java che usi i thread per:
 *Calcolare la somma di un array di 1000000 elementi
 *utilizzando un numero di thread variabile da 1 a 8 e
 *stampando i tempi ottenuti in ciascuno dei casi
 */

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Domenico
 */
public class ArrayMultiThread extends Thread {
	// settare numero thread e dimensione array
	public static final int SIZE = 1000000;// Array Size
	// Array Size
	public static final int MAX_THR = 128;// Numero di thread

	public static AtomicInteger globCount;
	private int start;// Variabile privata del Thread
	private int dim; // Variabile Privata del Thread
	private int count;

	public static int[] data;

	public static void main(String[] args) {

		data = new int[SIZE];
		long begin, end;
		int start, j;
		ArrayMultiThread[] threads;

		for (int numThread = 1; numThread <= MAX_THR; numThread++) {
			globCount = new AtomicInteger();
			begin = System.currentTimeMillis();
			start = 0;
			threads = new ArrayMultiThread[numThread];
			for (j = 0; j < numThread; j++) {
				threads[j] = new ArrayMultiThread(start, (SIZE / numThread));
				threads[j].start();
				start += SIZE / numThread;
			}

			for (j = 0; j < numThread; j++) {
				try {
					threads[j].join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			end = System.currentTimeMillis();

			System.out.println();
			System.out.println("Con " + numThread + " thread(s)\n sono stati contati " + (globCount.get())
					+ " elementi\tin " + (end - begin) + "ms");
		}

	}

	public ArrayMultiThread(int start, int size) {
		this.start = start;
		this.dim = size;
	}

	public void run() {
		count = 0;
		for (int i = 0; i < this.dim; i++) {
			data[start + i] = 2;
			this.count += ArrayMultiThread.data[i];
		}

		// System.out.println("parto da:"+this.start+" arrivo a:"+this.dim+"\n
		// totale: "+this.count);
		globCount.addAndGet(this.count);
		// System.out.println("ho aggiunto " +globCount.addAndGet(this.count));

	}
}