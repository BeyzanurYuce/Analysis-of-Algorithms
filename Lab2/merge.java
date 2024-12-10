import java.util.Arrays;
import java.util.Random;

public class merge
{
	public static void main(String [] args)
	{
		int array_size = 1048576;
		int [] array = new int[array_size];
		long start_time, end_time, elapsed_time, elapsed_time_insertion, elapsed_time_merge;

		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());

		for (int i = 0; i < array_size; i++)
			array[i] = rand.nextInt(100);
		
		//part 2(b)
		//System.out.println("Original array:");
		//print_array(array);

		//System.out.println("Array after merge sort: ");
		/*start_time = System.nanoTime();
		merge_sort(array,0,array_size-1);
		end_time = System.nanoTime();
		elapsed_time_merge = end_time-start_time;*/
		//print_array(array);
		
		/*start_time =System.nanoTime();
		merge(array, 0,(array_size/2)-1 , array_size-1);
		end_time = System.nanoTime();
		elapsed_time_merge = end_time-start_time;
		long total_elapsed_time = elapsed_time+elapsed_time_merge; 
		*/
		
		
		//part 3(a)	
		//System.out.println("Array after merge sort: ");
				start_time = System.nanoTime();
				merge_sort(array,0,array_size-1);
				end_time = System.nanoTime();
				elapsed_time_merge = end_time-start_time;
				//print_array(array);
				 
				 
				
				start_time =System.nanoTime();
				//insertion_sort(array);
				end_time = System.nanoTime();
				elapsed_time_insertion = end_time-start_time;
				
				
				System.out.println("Time for merge sort: "+elapsed_time_merge);
				//System.out.println("Time for merge "+elapsed_time_merge);
				//System.out.println("Total time for merge sort "+total_elapsed_time);
				System.out.println("Time for insertion sort: "+elapsed_time_insertion);
				

		//part 3(b)
		for(int i = 1; i <= 100; i++){
			if(8*Math.pow(i, 2)< 64*i*Math.log(i)/Math.log(2))
				System.out.println(i);
		}

	}

	//indices p and r can start from 0
	public static void merge_sort(int [] A, int p, int r)
	{
		if (p < r) {
			// Find the middle point
			int m = p + (r - p) / 2;

			// Sort first and second halves
			merge_sort(A, p, m);
			merge_sort(A, m + 1, r);

			// Merge the sorted halves
			merge(A, p, m, r);
		}
	}

	//Part 2(a)
	public static void merge(int [] A, int p, int q, int r)
	{
		int left_size = q-p +1;
		int right_size = r-q;
		int[] left = new int[left_size];
		int[] right = new int[right_size];

		for(int i =0; i<left_size; i++)
			left[i] = A[p+i];
		for(int j=0; j<right_size; j++)
			right[j] = A[q+j+1];

		int i=0, j=0;
		int key = p;
		while(i<left_size && j<right_size){
			if(left[i]<= right[j]){
				A[key] = left[i];
				i++;
			}
			else{
				A[key] = right[j];
				j++;
			}
			key++;
		}
		while (i < left_size) {
			A[key] = left[i];
			i++;
			key++;
		}

		while (i < right_size) {
			A[key] = right[j];
			j++;
			key++;
		}
	}	

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

