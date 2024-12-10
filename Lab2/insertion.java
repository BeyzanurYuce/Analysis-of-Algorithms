import java.util.Arrays;
import java.util.Random;

public class insertion
{
	public static void main(String [] args)
	{
		int array_size = 100000;
		long start_time, end_time, elapsed_time;

		int array [] = new int[array_size];

		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());

		//initialize elements of array with random integers
		for (int i = 0; i < array.length; i++)
			array[i] = rand.nextInt(100);
		
		//part 1(c)
		//System.out.println("After first insertion sort:");
		insertion_sort(array);
		//print_array(array);
		
		//System.out.println("After second insertion sort:");
		start_time= System.nanoTime();
		insertion_sort(array);
		end_time = System.nanoTime();
		elapsed_time = end_time - start_time;
		//print_array(array);
		System.out.println("Time for best-case of insertion sort: "+ elapsed_time); 
		
		//part 1(d) 
		//System.out.println("After reverse insertion sort:");
		insertion_sort_reverse(array);
		//print_array(array);
		
		//System.out.println("After insertion sort:");
		start_time= System.nanoTime();
		insertion_sort(array);
		end_time = System.nanoTime();
		elapsed_time = end_time - start_time;
		//print_array(array);
		System.out.println("Time for worst-case of insertion sort "+ elapsed_time); 
		//part 1(e)
	}

        //part 1(a) implementing insertion sort algorithm as a method below
        public static void insertion_sort(int [] A)
        {
        	for(int i = 1; i<A.length; i++) {
				int key = A[i];
				int j = i - 1;
				while (j >= 0 && A[j] > key) {
					A[j + 1] = A[j];
					j = j - 1;
				}
				A[j + 1] = key;
			}

        }

        //part 1(b) implementing insertion sort algorithm that sorts in descending order as a method below
        public static void insertion_sort_reverse(int [] A)
        {
        	for(int i = 1; i<A.length; i++) {
				int key = A[i];
				int j = i - 1;
				while (j >= 0 && A[j] < key) {
					A[j + 1] = A[j];
					j = j - 1;
				}
				A[j + 1] = key;
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

