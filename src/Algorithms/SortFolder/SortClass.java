package Algorithms.SortFolder;
import java.util.*;

import TestFolder.*;

public class SortClass{
	/**
	 * Insertion sort: is an algorithm to sort. It is  efficient for a small number of elements.
	 * This implementation is going to modify your array, it's going to be sorted.
	 * Worst case running time complexity: O(n^2).
	 * Average case running time complexity: O(n^2).
	 * Worst case extra-spatial complexity: O(1).
	 * This implementation does not consider the null case, if you want to handle this case,
	 * you must take it into account in your Comparator-class.
	 * @param a - array to be sorted.
	 * @param comparator - a comparator for the objects of your array a[].
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
	/**
	 * Merge method for the merge sort.
	 * It is an auxiliary method of mergeSort(...).
	 * @param a - the array to be sorted.
	 * @param p - the index of the first element to be sorted in the array.
	 * @param q - the index of the middle element to be sorted in the array.
	 * @param r - the index of the last element to be sorted in the array.
	 * @param comparator - a comparator for the objects of your array a[].
	 */
	private static <T> void merge(T[]a,int p,int q,int r,Comparator<? super T>comparator){
		int n1=q-p+1;
		int n2=r-q;
		List<T>left=new ArrayList<T>(n1+1);
		List<T>right=new ArrayList<T>(n2+1);
		for(int i=0;i<n1;i++){
			left.add(i,a[p+i]);
		}
		for(int i=0;i<n2;i++){
			right.add(i,a[q+i+1]);
		}
		left.add(n1,null);
		right.add(n2,null);
		int i=0;
		int j=0;
		for(int k=p;k<=r;k++){
			if(right.get(j)==null||(left.get(i)!=null&&comparator.compare(left.get(i),right.get(j))<=0)){
				a[k]=left.get(i);
				i++;
			}else{
				a[k]=right.get(j);
				j++;
			}
		}
	}
	/**
	 * Merge sort: is an efficient algorithm to sort. 
	 * This algorithm follows the divide and conquer approach.
	 * This implementation is going to modify your array, it's going to be sorted.
	 * Worst case running time complexity: O(n log_2(n)).
	 * Average case running time complexity: O(n log_2(n)).
	 * Worst case extra-spatial complexity: O(n).
	 * @param a - array to be sorted.
	 * @param p - the index of the first element of the array to be sorted (inclusive). It is usually 0.
	 * @param r - the index of the last element of the array to be sorted (inclusive). It is usually (a.length-1).
	 * @param comparator - a comparator for the objects of your array a[].
	 */
	public static <T> void mergeSort(T[]a,int p,int r, Comparator<? super T>comparator){
		if(p<r){
			int q=p+(r-p)/2;
			mergeSort(a,p,q, comparator);
			mergeSort(a,q+1,r,comparator);
			merge(a,p,q,r,comparator);
		}
	}
	
	/**
	 * Bubble sort: an algorithm to sort the elements in the array.
	 * This implementation is going to modify your array, it's going to be sorted.
	 * @param a - the array to be sorted
	 * @param comparator - a comparator for the objects of your array a[].
	 */
	public static <T>void bubbleSort(T[]a,Comparator<? super T>comparator){
		for(int i=0;i<a.length-1;i++){
			for(int j=a.length-1;j>i;j--){
				if(comparator.compare(a[j],a[j-1])<0){
					T temp=a[j];
					a[j]=a[j-1];
					a[j-1]=temp;
				}
			}
		}
	}
	
	
	public static void main(String [] args){
		Integer[] a={9,8,6,6,5,44,3,4,4,4,4,3,2,2,3,4,0,77,7,5,6,6,7,-1,2-34,-244};
		Worker [] w=new Worker[20];
		Random r=new Random();
		for(int i=0;i<w.length;i++){
			w[i]=new Worker(r.nextInt(20));
		}
		MyComparator ci=new MyComparator();
		WorkerAgeComparator cw=new WorkerAgeComparator();
		bubbleSort(a,ci);
		bubbleSort(w,cw);
		System.out.println(Arrays.deepToString(a));
		System.out.println(Arrays.deepToString(w));
	}
}
