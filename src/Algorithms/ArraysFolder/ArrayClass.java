package Algorithms.ArraysFolder;

import Algorithms.ArraysFolder.AuxiliarClasses.*;

public class ArrayClass {

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

}
