import java.util.Arrays;
import java.util.Random;

public class insertion
{
	public static void main(String [] args)
	{
		int array_size = 65536;
		int array [] = new int[array_size];
                long start_time, end_time, elapsed_time;

		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());

		//part(b) choosing one integer array and showing that the sort method works

		//initialize elements of array with random integers
		for (int i = 0; i < array.length; i++)
			array[i] = rand.nextInt(100);

                //print_array(array);
                start_time = System.nanoTime();
                insertion_sort(array);
                end_time = System.nanoTime();
                elapsed_time = end_time-start_time;
                //print_array(array);

                System.out.printf("Elapsed time in nanoseconds: %d\n", elapsed_time);

	}

	//part(a) implementing insertion sort algorithm as a method below
	public static void insertion_sort(int [] A)
	{
		int key;
		int i;

		for (int j = 1; j < A.length; j++)
		{
			key = A[j];

			//insert A[j] into the sorted sequence A[1..j-1]
			i = j-1;

			while ((i >= 0) && (A[i] > key))				
			{
				A[i+1] = A[i];
				i = i-1;
			}

			A[i+1] = key;
		}		
	}

	//prints the elements of the array A on the screen
	public static void print_array(int [] A)
	{
		System.out.printf("[");
		for (int i = 0; i < A.length-1; i++)
		{
			System.out.printf("%d, ", A[i]);
		}
		
		System.out.printf("%d]\n", A[A.length-1]);

	}

}

