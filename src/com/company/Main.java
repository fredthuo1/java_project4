package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

    originalVersion( random(), 0, random().size() - 1 );
        //System.out.println(Arrays.toString( random().toArray() ));//System.out.println( ascending() );
        //System.out.println( descending() );
    }

    public static ArrayList random() {
        ArrayList array = new ArrayList();
        for ( int i = 0; i < 1000; i++ ) {
            int num = (int) (1 + (Math.random() * 1000 -1 ));
            array.add(num);
        }

        return array;

    }

    public static ArrayList ascending() {
        ArrayList arrayList = new ArrayList();
        for ( int i = 1; i <= 1000; i ++ ) {
            arrayList.add( i );
        }

        return arrayList;
    }

    public static ArrayList descending() {
        ArrayList arrayList = new ArrayList();
        for ( int i = 999; i >= 1; i-- ) {
            arrayList.add( i );
        }

        return arrayList;

    }

    public static ArrayList originalVersion(ArrayList arrayList, int start, int end ) {
        int partition = partition(arrayList, start, end);

        if(partition-1>start) {
            originalVersion(arrayList, start, partition - 1);
        }
        if(partition+1<end) {
            originalVersion(arrayList, partition + 1, end);
        } else {
            return arrayList;
        }

        return null;
    }

    private static int partition(ArrayList arrayList, int start, int end) {
        int pivot = (int) arrayList.get( arrayList.size()-1 );

        for(int i = start; i < end; i++ ){
            if( (int) arrayList.get(i) < pivot ) {
                int temp= (int)  arrayList.get( start );
                arrayList.set( start, arrayList.get( i ) );
                arrayList.set( i, temp );
                start++;
            }
        }

        int temp = (int) arrayList.get( start );
        arrayList.set( start, pivot );
        arrayList.set( end, temp );


        return start;
    }


    public static void randomization() {

    }

    public static void median() {

    }
}
