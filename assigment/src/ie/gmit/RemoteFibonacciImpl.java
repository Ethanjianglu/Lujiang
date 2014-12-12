package ie.gmit;
import java.rmi.*;
import java.rmi.server.*;



public class RemoteFibonacciImpl extends UnicastRemoteObject implements RemoteFibonacci {


	protected RemoteFibonacciImpl() throws RemoteException {
		super();
	}

	public String getFibonacciSequence(int max) throws RemoteException {
		long sum = 0;
		StringBuffer fib =   new StringBuffer("");
		for (int i=1;i<max;i++)
		{
			fib.append(sum);
			fib.append(",");
			sum=fibonacciNormal(i);
		}
		fib.append(sum);
		
		return fib.toString();
	}

	public static long fibonacciNormal(int n){  
        if(n <= 2){  
            return 1;  
        }  
        else{
        long n1 = 1, n2 = 1, sn = 0;  
        for(int i = 0; i < n - 2; i ++){  
            sn = n1 + n2;  
            n1 = n2;  
            n2 = sn;  
        }  
        return sn;  
        }
	}
}