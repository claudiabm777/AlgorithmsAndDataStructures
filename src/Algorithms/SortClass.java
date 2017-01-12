package Algorithms;
import java.util.*;

import TestFolder.*;

public class SortClass{
	/**
	 * Insertion sort: is an efficient algorithm to sort a small number of elements.
	 * This implementation is going to modify your array.
	 * Worst case complexity: O(n^2).
	 * This implementation does not consider the null case, if you want to handle this case,
	 * you must take it into account in your Comparator-class.
	 * @param a - array to be sorted
	 * @param comparator - a comparator for the objects of your array a[]
	 */
	public static <T> void insertionSort(T [] a,Comparator<? super T> comparator ){
		if(a.length>=2){
			for(int j=1;j<a.length;j++){
				T key =a[j];
				int i=j-1;
				while(i>=0 && comparator.compare(a[i],key)>0){
					a[i+1]=a[i];
					i=i-1;
				}
				a[i+1]=key;
			}
		}
	}

	public static void main(String [] args){
		Integer[] a={9,86,3,5,2,6,8,7,8,9,1,4,2,0,7,-1,23,56,-7};
		Worker [] w=new Worker[9];
		Random r=new Random();
		for(int i=0;i<w.length;i++){
			w[i]=new Worker(r.nextInt(20));
		}
		MyComparator ci=new MyComparator();
		WorkerAgeComparator cw=new WorkerAgeComparator();
		insertionSort(a,ci);
		insertionSort(w,cw);
		System.out.println(Arrays.deepToString(a));
		System.out.println(Arrays.deepToString(w));
		Integer []aa={9,86,null,5,2,6,8,7,8,9,1,4,2,0,7,-1,23,56,-7};
		Arrays.sort(aa);
	}
}
