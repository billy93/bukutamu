package com.atibusinessgroup.bukutamu;

import java.util.Arrays;

public class Test {
	
	public static void main(String args[]) {
		boolean test = isEqual("ANJA", "RANJA");
		System.out.println(test);
	}
	
	private static  boolean isEqual(String kata1, String kata2) {
		  char[] one = kata1.toCharArray();
		  char[] two = kata2.toCharArray();
		  one=sortArrays(one);
		  two=sortArrays(two);
		  
		  if(one.length == two.length) {
			  for(int x=0;x<one.length;x++) {
				  if(one[x] != two[x]) {
					  return false;
				  }
			  }
			  return true;
		  }
		  
		  return false;
	}
	
	// Function for Sorting the array using a single loop
    public static char[] sortArrays(char[] arr)
    {
  
        // Finding the length of array 'arr'
        int length = arr.length;
  
        // Sorting using a single loop
        for (int j = 0; j < arr.length - 1; j++) {
  
            // Type Conversion of char to int.
            int d1 = arr[j];
            int d2 = arr[j + 1];
  
            // Comparing the ascii code.
            if (d1 > d2) {
  
                // Swapping of the characters
                char temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                j = -1;
            }
        }
  
        return arr;
    }
}
