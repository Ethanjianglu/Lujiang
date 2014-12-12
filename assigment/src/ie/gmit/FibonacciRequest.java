package ie.gmit;

public class FibonacciRequest {
	
	private int jobNumber;
    private int max;
    
    public FibonacciRequest(int jobNumber, int max){
    	super();
    	this.jobNumber=jobNumber;
    	this.max=max;
    }
	

	public int getjobNumber() {
		return jobNumber;
	}
	
    public void setjobNumber(int jobNumber) {
		this.jobNumber = jobNumber;
	}
	
    public int getmax() {
		return max;
	}
	
    public void setmax(int max) {
		this.max = max;
	}
}