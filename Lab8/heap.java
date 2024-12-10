import java.util.Arrays;
import java.util.Random;

public class heap
{
	public static void main(String [] args)
	{
		int array_size = 10;
		int [] array = new int[array_size];
		long start_time, end_time, elapsed_time, elapsed_time_heap, elapsed_time_merge;

		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());

		for (int i = 0; i < array_size; i++)
			array[i] = rand.nextInt(100);
		// part 1 (b)
		System.out.println("The sorted array:");
		print_array(array);
		start_time = System.nanoTime();
		heap_sort(array);
		//Used for part 1(d)
		//merge_sort(array, 0, array_size-1);
		end_time = System.nanoTime();
		elapsed_time =  end_time-start_time;
		System.out.println("Time to sort array of size "+ array_size+ " with heap sort: "+ elapsed_time);
	
		//part 1(c)

		array_size = 67108864;
		int [] array_2 = new int[array_size]; //will be used for insertion sort
                int [] array_3 = new int[array_size]; //will be used for merge sort
		
		for (int i = 0; i < array_size; i++)
		{
                        array_2[i] = rand.nextInt(100);
			array_3[i] = array_2[i]; //make a copy of array_2 
		}

		start_time = System.nanoTime();
		heap_sort(array_2);
		end_time = System.nanoTime();
		elapsed_time_heap= end_time - start_time;
		System.out.printf("Elapsed time in nanoseconds for heap sort when "+ array_size+" integers are sorted: %d\n", elapsed_time_heap);

		start_time = System.nanoTime();
		merge_sort(array_3, 0, array_size-1);
		end_time = System.nanoTime();
		elapsed_time_merge = end_time - start_time;
                System.out.printf("Elapsed time in nanoseconds for merge sort when "+ array_size+" integers are sorted: %d\n", elapsed_time_merge);
		
	}

	// Part 1(a)
	//Implement heap sort algorithm below
	public static void heap_sort(int A[])
	{

		//max heap
		for (int i = A.length / 2 - 1; i >= 0; i--) {
			heapify(A, A.length, i);
		}

		//sort
		for (int i = A.length - 1; i >= 0; i--) {
			int tmp = A[0];
			A[0] = A[i];
			A[i] = tmp;
			heapify(A, i, 0);
		}

	}

	static void heapify(int A[], int n, int i) {
		int max = i;
		int left_child = 2 * i ;
		int right_child = 2 * i + 1;

		if (left_child < n && A[left_child] > A[max])
			max = left_child;

		if (right_child < n && A[right_child] > A[max])
			max = right_child;

		if (max != i) {
			int swap = A[i];
			A[i] = A[max];
			A[max] = swap;
			heapify(A, n, max);
		}
	}

	//indices p and r can start from 0
	public static void merge_sort(int [] A, int p, int r)
	{
		int q;

		if (p < r)
		{
			q = (int)Math.floor((p+r)/2);
			merge_sort(A, p, q);
			merge_sort(A, q+1, r);
			merge(A, p, q, r);
		}
	}

	//Part 2(a)
	public static void merge(int [] A, int p, int q, int r)
	{
		int n1, n2;
		int i, j;

		n1 = q-p+1;
		n2 = r-q;

		int [] L = new int[n1];
		int [] R = new int[n2];

		for (i = 0; i < n1; i++)
			L[i] = A[p+i];

                for (i = 0; i < n2; i++)
                        R[i] = A[q+i+1];		

		i = 0;
		j = 0;
		
		for (int k=p; k <= r; k++)
		{
			if (i >= n1) //the left array finished, copy from right array
			{
				A[k] = R[j];
				j++;
				continue;
			}
			
			if (j >= n2) //the right array finished, copy from left array
			{
				A[k] = L[i];
				i++;
				continue;
			}
	
			if (L[i] <= R[j])
			{
				A[k] = L[i];
				i++;
			}
			else
			{
				A[k] = R[j];
				j++;
			}
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

