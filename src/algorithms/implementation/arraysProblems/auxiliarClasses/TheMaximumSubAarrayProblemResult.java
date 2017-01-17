package algorithms.implementation.arraysProblems.auxiliarClasses;
/**
 * This class represents the result for the problem of find maximum sub-array.
 * @author Claudia Daniela Bedoya Motta
 *
 */
public class TheMaximumSubAarrayProblemResult{
	//----------------------------------------------------------------------------
	// ATRIBUTES
	//----------------------------------------------------------------------------
	/**
	 * low- the lowest index of the maximum sub-array
	 */
	public int low;
	
	/**
	 * high - the highest index of the maximum sub-array
	 */
	public int high;
	
	/**
	 * sum - the maximum sum
	 */
	public Double sum;
	
	//----------------------------------------------------------------------------
	// CONSTRUCTOR
	//----------------------------------------------------------------------------
	/**
	 * The constructor of the class
	 * @param low - the lower index
	 * @param high - the highest index
	 * @param sum - the sum
	 */
	public TheMaximumSubAarrayProblemResult(int low,int high,Double sum){
		this.low=low;
		this.high=high;
		this.sum=sum;
	}
	//----------------------------------------------------------------------------
	// METHODS
	//----------------------------------------------------------------------------
	public String toString(){
		return "{low:"+low+", high:"+high+", sum:"+sum+"}";
	}
}