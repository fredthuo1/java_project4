package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QS {

    public int countRegular = 0;
    public int swapsRegular = 0;
    public int countRandom = 0;
    public int swapsRandom = 0;
    public int countMedian = 0;
    public int swapsMedian = 0;

    public static void main(String[] args)
    {
        QS ob = new QS();
        System.out.println("Original Array:" + "\n");
        ob.display( random() );

        System.out.println( "Original Version-Random Array: " + "\n" );
        long startTime = System.nanoTime();
        ob.sort(random().toArray());
        long endTime = System.nanoTime();
        System.out.println("Time: " + ( endTime - startTime) + "\n");
        System.out.println( "Number of counts: "+ ob.countRegular + "\n");
        System.out.println( "Number of swaps: " + ob.swapsRegular + "\n");
        ob.countRegular = 0;
        ob.swapsRegular = 0;
        ob.display( random() );

        System.out.println( "Original Version-Ascending order array:  " + "\n");
        long startTime1 = System.nanoTime();
        ob.sort(ascending().toArray());
        long endTime1 = System.nanoTime();
        System.out.println( "Time: " + ( endTime1 - startTime1 ) + "\n");
        System.out.println( "Number of swaps: " + ob.countRegular + "\n");
        System.out.println( "Number of counts: " + ob.swapsRegular + "\n");
        ob.countRegular = 0;
        ob.swapsRegular = 0;
        ob.display( ascending() );

        System.out.println("Original Version-Descending order array: " + "\n");
        long startTime2 = System.nanoTime();
        ob.sort(descending().toArray());
        long endTime2 = System.nanoTime();
        System.out.println( "Time: " + ( endTime2 - startTime2 ) + "\n");
        System.out.println( "Number of swaps: " + ob.countRegular + "\n");
        System.out.println( "Number of counts: " + ob.swapsRegular + "\n");
        ob.countRegular = 0;
        ob.swapsRegular = 0;
        ob.display( descending() );

        System.out.println( "Randomizaton Version-Random Array: " + "\n");
        long startTime3 = System.nanoTime();
        ob.sortRandom(random().toArray());
        long endTime3 = System.nanoTime();
        System.out.println("Time: " + ( endTime3 - startTime3) + "\n");
        System.out.println( "Number of swaps: " + ob.swapsRandom + "\n");
        System.out.println( "Number of counts: " + ob.countRandom + "\n");
        ob.swapsRandom = 0;
        ob.countRandom = 0;
        ob.display( random() );

        System.out.println( "Randomization Version-Ascending order array:  " + "\n" );
        long startTime4 = System.nanoTime();
        ob.sortRandom(ascending().toArray());
        long endTime4 = System.nanoTime();
        System.out.println( "Time: " + ( endTime4 - startTime4 ) + "\n");
        System.out.println( "Number of swaps: " + ob.swapsRandom + "\n");
        System.out.println( "Number of counts: " + ob.countRandom + "\n");
        ob.swapsRandom = 0;
        ob.countRandom = 0;
        ob.display( random() );

        System.out.println("Randomiazation Version-Descending order array: ");
        long startTime5 = System.nanoTime();
        ob.sortRandom(descending().toArray());
        long endTime5 = System.nanoTime();
        System.out.println( "Time: " + ( endTime5 - startTime5 ) + "\n");
        System.out.println( "Number of swaps: " + ob.swapsRandom + "\n");
        System.out.println( "Number of counts: " + ob.countRandom + "\n");
        ob.swapsRandom = 0;
        ob.countRandom = 0;
        ob.display( random() );

        System.out.println( "Median of 3 Version-Random Array: " + "\n");
        long startTime6 = System.nanoTime();
        ob.medianOfThree(random().toArray());
        long endTime6 = System.nanoTime();
        System.out.println("Time: " + ( endTime6 - startTime6 ) + "\n");
        System.out.println( "Number of swaps: " + ob.countMedian + "\n");
        System.out.println( "Number of counts: " + ob.swapsMedian + "\n");
        ob.swapsMedian = 0;
        ob.countMedian = 0;
        ob.display( random() );

        System.out.println( "Median of three Version-Ascending order array:  " + "\n" );
        long startTime7 = System.nanoTime();
        ob.medianOfThree(ascending().toArray());
        long endTime7 = System.nanoTime();
        System.out.println( "Time: " + ( endTime7 - startTime7 ) + "\n");
        System.out.println( "Number of swaps: " + ob.countMedian + "\n");
        System.out.println( "Number of counts: " + ob.swapsMedian + "\n");
        ob.swapsMedian = 0;
        ob.countMedian = 0;
        ob.display( ascending() );

        System.out.println("Median of three Version-Descending order array: " + "\n");
        long startTime8 = System.nanoTime();
        ob.medianOfThree(descending().toArray());
        long endTime8 = System.nanoTime();
        System.out.println( "Time: " + ( endTime8 - startTime8 ) + "\n");
        System.out.println( "Number of swaps: " + ob.countMedian + "\n");
        System.out.println( "Number of counts: " + ob.swapsMedian + "\n");
        ob.swapsMedian = 0;
        ob.countMedian = 0;
        ob.display( descending() );

    }



        private Object[] temp_array;
        private int len;

        public void sort(Object[] nums) {

            if (nums == null || nums.length == 0) {
                return;
            }
            this.temp_array = nums;
            len = nums.length;
            quickSort(0, len - 1);
        }

    public void sortRandom(Object[] nums) {

        if (nums == null || nums.length == 0) {
            return;
        }
        this.temp_array = nums;
        len = nums.length;
        randomization(0, len - 1);
    }

    public void medianOfThree(Object[] nums) {

        if (nums == null || nums.length == 0) {
            return;
        }
        this.temp_array = nums;
        len = nums.length;
        int[] arr = new int[len];
        for ( int i = 0; i < len; i++ ) {
            arr[i] = (int) nums[i];
        }
        medianOf3 (arr, 0, len - 1);

    }

        // Last Pivot
        private void quickSort(int low_index, int high_index) {

            int i = low_index;
            int j = high_index;
            int pivot = (int) temp_array[high_index];
            while (i <= j) {
                while ((int) temp_array[i] < pivot) {
                    i++;
                    countRegular ++;
                }
                while ((int) temp_array[j] > pivot) {
                    j--;
                    countRegular ++;
                }
                if (i <= j) {
                    exchangeNumbers(i, j);
                    swapsRegular++;
                    i++;
                    j--;
                }
            }
            if (low_index < j)
                quickSort(low_index, j);
            if (i < high_index)
                quickSort(i, high_index);
        }



        // Random Pivot
        private void randomization( int low_index, int high_index ) {
            int i = low_index;
            int j = high_index;
            int pivot = (int) temp_array[ (int) (1 + (Math.random() * 1000 -1 ))];
            while (i <= j) {
                while ((int) temp_array[i] < pivot) {
                    countRandom++;
                    i++;
                }
                while ((int) temp_array[j] > pivot) {
                    countRandom++;
                    j--;
                }
                if (i <= j) {
                    exchangeNumbers(i, j);
                    swapsRandom++;
                    i++;
                    j--;
                }
            }
            if (low_index < j)
                quickSort(low_index, j);
            if (i < high_index)
                quickSort(i, high_index);
        }

    // Random Pivot

    private void swap(int[] intArray, int dex1, int dex2) {
        int temp = intArray[dex1];
        intArray[dex1] = intArray[dex2];
        intArray[dex2] = temp;
        swapsMedian++;
    }


    private int medianOf3(int[] intArray, int left, int right) {
        int center = (left + right) / 2;

        if (intArray[left] > intArray[center]) {
            swap(intArray, left, center);
            countMedian++;
        }
        if (intArray[left] > intArray[right]) {
            swap(intArray, left, right);
            countMedian++;
    }
        if (intArray[center] > intArray[right]) {
            swap(intArray, center, right);
            countMedian++;
        }
        swap(intArray, center, right - 1);
        return intArray[right - 1];
    }



    private  void exchangeNumbers(int i, int j) {
            int temp = (int) temp_array[i];
            temp_array[i] = temp_array[j];
            temp_array[j] = temp;
        }



    private static ArrayList random() {
        ArrayList array = new ArrayList();
        for ( int i = 0; i < 1000; i++ ) {
            int num = (int) (1 + (Math.random() * 1000 -1 ));
            array.add(num);
        }

        return array;

    }

    private static ArrayList ascending() {
        ArrayList arrayList = new ArrayList();
        for ( int i = 1; i <= 1000; i ++ ) {
            arrayList.add( i );
        }

        return arrayList;
    }

    private static ArrayList descending() {
        ArrayList arrayList = new ArrayList();
        for ( int i = 999; i >= 1; i-- ) {
            arrayList.add( i );
        }

        return arrayList;

    }

    private void display( ArrayList arrayList ) {
        for ( int i = 0; i < arrayList.size() - 1; i++ ) {
            System.out.print( arrayList.get( i ) + " " );
            if ( i % 20 == 0 ) {
                System.out.println( "\n");
            }
        }
    }

}
