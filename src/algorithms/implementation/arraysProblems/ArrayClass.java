package algorithms.implementation.arraysProblems;

import algorithms.implementation.arraysProblems.auxiliarClasses.TheMaximumSubAarrayProblemResult;

/**
 * This class contains methods for different problems with arrays, following the pseudo-code
 * of the book "Introduction to algorithms" third edition
 * @author Claudia Daniela Bedoya Motta
 *
 */
public class ArrayClass {

	/**
	 * This method solves the problem of find the maximum crossing sub-array 
	 * Implementation according the book Introduction to Algorithms, third edition, page 68...
	 * Is an auxiliary problem to solve findTheMaximumSubArray(...)
	 * Worst case running time complexity: O(n).
	 * Average case running time complexity: O(n).
	 * Worst case extra-spatial complexity: O(1).
	 * @param a - complete array
	 * @param low - lower index of the sub-array to be evaluated
	 * @param mid - middle index of the sub-array to be evaluated
	 * @param high - higher index of the sub-array to be evaluated
	 * @return TheMaximumSubAarrayProblemResult result - an object that contains the lower
	 * index of the maximum sub-array, the highest index of the maximum sub array, the maximum sum
	 */
	private static TheMaximumSubAarrayProblemResult findMaxCrossingSubArray(Double[]a,int low,int mid,int high){
		Double leftSum=null;
		Double sum=0.0;
		int maxLeft=-1;
		for(int i=mid;i>=low;i--){
			sum+=a[i];
			if(leftSum==null||sum>leftSum){
				leftSum=sum;
				maxLeft=i;
			}
		}
		Double rightSum=null;
		sum=0.0;
		int maxRight=-1;
		for(int i=mid+1;i<=high;i++){
			sum+=a[i];
			if(rightSum==null||sum>rightSum){
				rightSum=sum;
				maxRight=i;
			}
		}
		return new TheMaximumSubAarrayProblemResult(maxLeft,maxRight,leftSum+rightSum);
	}
	
	/**
	 * This method solves the problem of find the maximum sub-array 
	 * The array must have at least one element
	 * Worst case running time complexity: O(n log_2 n).
	 * Average case running time complexity: O(n log_2 n).
	 * Worst case extra-spatial complexity: O(1).
	 * @param a - complete array
	 * @param low - lower index of the array
	 * @param high - higher index of the array to be evaluated
	 * @return TheMaximumSubAarrayProblemResult result - an object that contains the lower
	 * index of the maximum sub-array, the highest index of the maximum sub array, the maximum sum
	 */
	public static TheMaximumSubAarrayProblemResult findTheMaximumSubArray(Double[]a,int low,int high){
		if(high==low){
			return new TheMaximumSubAarrayProblemResult(low,high,a[low]);
		}else{
			int mid=low+(high-low)/2;
			TheMaximumSubAarrayProblemResult left=findTheMaximumSubArray(a,low,mid);
			TheMaximumSubAarrayProblemResult right=findTheMaximumSubArray(a,mid+1,high);
			TheMaximumSubAarrayProblemResult cross=findMaxCrossingSubArray(a,low,mid,high);
			if(left.sum>=right.sum && left.sum>=cross.sum){return left;}
			else if(right.sum>=left.sum && right.sum>=cross.sum){return right;}
			else{return cross;}
		}
	}
	
	
	public static void main(String[] args) {
		Double a[]={13.0,-3.0,-25.0,20.0,-3.0,-16.0,-23.0,18.0,20.0,-7.0,12.0,-5.0,-22.0,15.0,-4.0,-7.0};
		System.out.println(findTheMaximumSubArray(a,0,a.length-1));
		Double aa[]={-3.0,3.0};
		System.out.println(findTheMaximumSubArray(aa,0,aa.length-1));
	}

}
