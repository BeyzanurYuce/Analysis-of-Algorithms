import java.util.Arrays;
import java.util.Random;

public class permute
{
	public static void main(String [] args)
	{
		int array_size = 10;
		int array_size_2 = 10;
		int array_size_3 = 4;
		int [] array = new int[array_size];
		int [] arr_2 = new int[array_size_2];
		int [] arr_3 = new int[array_size_3];
		int [] frequency_array = new int[24];
		int [] frequency_arr_2 = new int[24];
		int permutation_index = 0;

		Random rand = new Random();

		for (int i = 0; i < array_size; i++)
			array[i] = rand.nextInt(100);

		for (int i = 0; i < array_size_2; i++)
			arr_2[i] = rand.nextInt(100);

		System.out.print("//////////////Part 1(b)//////////////\n");
		System.out.println("Original array: ");
		print_array(array);
		for (int i=0;i<5;i++) {
			System.out.println("Permutation "+(i+1)+":");
			randomize_in_place(array);
			print_array(array);
		}

		System.out.print("\n//////////////Part 2(b)/////////////////\n");
		System.out.println("Original array: ");
		print_array(arr_2);
		for (int i=0;i<5;i++) {
			System.out.println("Permutation "+(i+1)+":");
			randomize_in_place(arr_2);
			print_array(arr_2);
		}


		arr_3[0] = 4;
                arr_3[1] = 3;
                arr_3[2] = 2;
                arr_3[3] = 1;

		System.out.print("\n///////////////Part 3(a)/////////////////\n");
		for(int i=0;i<24000;i++) {
			randomize_in_place(arr_3);
			permutation_index = compute_permutation_index(arr_3);
			frequency_array [permutation_index]+=1;
		}
		print_frequency_array(frequency_array);

		System.out.print("\n///////////////Part 3(b)/////////////////\n");
		for(int i=0;i<24000;i++) {
			permute_with_all(arr_3);
			permutation_index = compute_permutation_index(arr_3);
			frequency_arr_2 [permutation_index]+=1;
			//System.out.printf("permutation index = %d, frequency = %d\n", permutation_index, frequency_arr_2[permutation_index]);
		}
		print_frequency_array(frequency_arr_2);

	}

	//Implement randomize in place algorithm below
	public static void randomize_in_place(int[] A)
	{
		Random rd = new Random();
		int swap_var =0;
		int random_index;
		int n = A.length;
		for(int i=0; i<n; i++) {
			random_index = rd.nextInt(n - i) + i;
			swap_var = A[random_index];
			A[random_index] = A[i];
			A[i] = swap_var;
		}

	}

        //Implement permute with all algorithm below
        public static void permute_with_all(int[] A)
        {
			Random rd = new Random();
			int n = A.length;
			for(int i=0; i<n; i++){
				int randomIndex = rd.nextInt(n-i)+i;
				int swapVariable = A[randomIndex];
				A[randomIndex] = A[i];
				A[i] = swapVariable;
			}

        }

	public static int compute_permutation_index(int [] A)
	{
		int permutation_index = 0;
		int next_number = 0;
		int index_next_number = 0;

		for (int starting_index = 0; starting_index < A.length-1; starting_index++)
		{	
			int [] remaining_numbers = new int [A.length-starting_index];
                        int [] remaining_numbers_sorted = new int [A.length-starting_index];

			for (int i = 0; i < remaining_numbers.length; i++)
			{
				remaining_numbers[i] = A[starting_index+i];
				remaining_numbers_sorted[i] = remaining_numbers[i];
			}

			insertion_sort(remaining_numbers_sorted);

			next_number = A[starting_index];

			for (int i = 0; i < remaining_numbers_sorted.length; i++)
			{
				if (remaining_numbers_sorted[i] == next_number)
				{
					index_next_number = i;
					break;
				}
			}

			permutation_index += index_next_number*factorial(remaining_numbers.length-1);	
		}	

		return permutation_index;
		
	}

	public static int factorial(int x)
	{	
		int product = 1;

		for (int i = x; i >= 1; i--)
			product *= i;

		return product;
	}

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

	public static void print_frequency_array(int [] A)
	{
		int i = 0;
		for (; i < A.length; i++)
		{
			System.out.printf("permutation index: %d , frequency: %d\n",(i), A[i]);
		}

	}
}

