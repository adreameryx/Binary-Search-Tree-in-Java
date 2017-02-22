import java.util.Random;

class lab9{
// Student: Oscar Ricaud, Professor: Julio Urenda, TA: Saif
	// Lab9 Info:
		// In the main method of lab9.java it creates the values for n
		// for example it does a for loop of, 100,200,300,400
		// While it does this it calls 2 methods the, HeapSortMagic
		// and the BinarySearchTreeMagic 
		// Both of these methods take in the same value which is n. (100,200,300,400)
		// 
	public static void main(String[] args) {
		// FIX TIMER 
		long startTimer = System.nanoTime();
		int computeTime= 0;

		int [] values = new int[4];

		for(int i = 0 ; i < 4; i ++){
			computeTime = 100 + computeTime;
			values[i] = computeTime;
			int timeValue = values[i];
			System.out.println("timeValue: " + timeValue);

			for(int j = 0; j < timeValue; j++){

				BinarySearchTreeMagic(timeValue);	
				HeapSortMagic(timeValue);
			}
			long endTimer = System.nanoTime();
			//	FIX ME
			//	System.out.println("TotalTime: " + (endTimer-startTimer));
		}
		
		
	}

	private static void HeapSortMagic(int timeValue) {
		long startTime = System.currentTimeMillis();
		Random rand = new Random();
		int [] array  = new int [timeValue];
		System.out.println("******************************");
		System.out.println("Size of array. " + array.length);
		System.out.println("******************************");
		for(int i = 0; i < array.length; i ++){

			array[i]  = rand.nextInt(timeValue) + 0;
			// System.out.println("array[i]" + array[i]);
			HeapSort.sort(array);
		}
		System.out.println("Sorted using HeapSortMagic: " );
		System.out.println("");
		
		// Sorts this 
		for (int j = 0; j< timeValue; j++){
			System.out.print(array[j]+" ");            
			System.out.print("");            
			// FIX TIMER
			//long endTime   = System.currentTimeMillis();
			//long total = endTime - startTime;
			//System.out.println("total time:" + (total));
		}   


	}

	private static void BinarySearchTreeMagic(int timeValue) {
		long startTime = System.currentTimeMillis();
		BinarySearchTree bst = new BinarySearchTree( );
		Random rand = new Random();
		int [] array  = new int [timeValue];
		System.out.println("Size of array. " + array.length);
		for(int i = 0; i < array.length; i ++){

			array[i]  = rand.nextInt(timeValue) + 0;
			bst.insert(array[i]);

		}
		//	System.out.println(Arrays.toString(array));
		System.out.println("");
		System.out.println("Sorted using the magic Binary Search Tree: ");
		System.out.println("");
		bst.inorderTraversal( );
		long endTime   = System.currentTimeMillis();
		long total = endTime - startTime;
		System.out.println("Total time:" + total);
	}


}