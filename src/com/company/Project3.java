package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Project3 {
    private int[] Heap;
    private int size;
    private int maxsize;

    public Project3(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[ this.maxsize + 1 ];
        Heap[0] = Integer.MAX_VALUE;
    }

    private int parent ( int pos ) {
        return pos/2;
    }

    private int leftChild( int pos ) {
        return ( 2*pos );
    }

    private int rightChild( int pos ) {
        return ( 2*pos ) + 1;
    }

    private boolean isLeaf(int pos)
    {
        if (pos >= (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }


    private void swap ( int fpos, int spos ) {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    private void maxHeapify(int pos)
    {
        if (isLeaf(pos))
            return;

        if (Heap[pos] < Heap[leftChild(pos)] ||
                Heap[pos] < Heap[rightChild(pos)]) {

            if (Heap[leftChild(pos)] > Heap[rightChild(pos)]) {
                swap(pos, leftChild(pos));
                maxHeapify(leftChild(pos));
            }
            else {
                swap(pos, rightChild(pos));
                maxHeapify(rightChild(pos));
            }
        }
    }

    public void insert( int element )
    {
        if (Heap[maxsize] != 0) {
            int[] newHip = new int[maxsize * 2];
            Heap = newHip;
        }
        Heap[++size] = element;

        int current = size;
        while (Heap[current] > Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }


    private static ArrayList generateArray() {

        ArrayList arrayList = new ArrayList();

        for ( int i = 0; i < 100; i++ ) {
            arrayList.add(  (int) (2000 * Math.random()) );
        }

        display( arrayList );
        return arrayList;
    }

    private static void display( ArrayList arrayList ) {
        for ( int i = 0; i < arrayList.size(); i++ ) {
            System.out.print( arrayList.get( i )  + ", ");
            if ( i % 20 == 0 ) {
                System.out.println( "\n" );
            }
        }
    }

    public void sort( ) {
        int n = Heap.length;

        for ( int i = n / 2 - 1; i >= 0; i-- ) {
            maxHeapify( i );
        }

        for ( int i = n - 1; i > 0; i++ ) {

            int temp = Heap[0];
            Heap[0] = Heap[i];
            Heap[i] = temp;

            maxHeapify( i );
        }
    }

    public static void main(String[] args) {
        ArrayList initial = new ArrayList();
        System.out.println("Initial Array: \n");
        initial = generateArray();
        Object[] array = initial.toArray();

        Project3 project3 = new Project3( (Integer) initial.get(0));
        for ( int i = 0; i < initial.size(); i++ ) {
            int in = (int) array[i];
            project3.insert( in );
        }

        System.out.println( "\n\nInitial array into a heap:" );
        ArrayList arrayList = new ArrayList();
        for ( int i = 0; i < project3.Heap.length; i++ ) {
            arrayList.add( project3.Heap[i] );
        }
        display(arrayList);


        for ( int i = 0; i < 20; i++ ) {
            Object[] array1 = generateArray().toArray();
            int[] ints = new int[ array1.length ];
            for ( int k = 0; k < array1.length; k++ ) {
                ints[k] = (int) array1[k];
            }
            for ( int m = 0;  m < ints.length; m ++ ) {
                if ( m >= project3.Heap.length ) {
                    int[] ints1 = new int[ project3.Heap.length * 2 ];
                    for ( int x = 0; x > project3.Heap.length; x++ ) {
                        ints1[x] = project3.Heap[x];
                    }
                    project3.Heap = ints1;
                    project3.insert(ints[m] );
                } else {
                    project3.insert(ints[m]);
                }
            }

            ArrayList arrayList1 = new ArrayList();
            for ( int l = 0; l < project3.Heap.length; l++ ) {
                arrayList1.add( project3.Heap[i] );
            }

            display( arrayList1 );

        }


    }
}
