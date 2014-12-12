package ie.gmit;

import java.io.IOException;
import java.rmi.*;
import java.rmi.registry.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	FibService fibService;

	public void init() throws ServletException {

		fibService = new FibService();
		try {

			RemoteFibonacci compute = new RemoteFibonacciImpl();
			LocateRegistry.createRegistry(1099);
			Naming.rebind("fibonacci", compute);
			System.out.println("Server Registered");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}


		protected void doGet(HttpServletRequest request,
							HttpServletResponse response) throws ServletException, IOException {
			
			
			String rType=request.getParameter("rType");
			
			
			RemoteFibonacci remoteFibonacci=null;
			// get the max if the request-type is "Add"
			if (rType.equals("Add")){
				String max = request.getParameter("max");
				System.out.println(max);
			
				int jobNum = fibService.add(Integer.parseInt(max));
				System.out.println(jobNum);
				
			try {
				
				remoteFibonacci = (RemoteFibonacci) Naming.lookup("rmi://localhost:1099/fibonacci");
			} catch (NotBoundException e) {
				System.out.println("rmi wong");
				e.printStackTrace();
			}
			
			String result = remoteFibonacci.getFibonacciSequence(Integer.parseInt(max));
			System.out.println("result is "+result);
			fibService.put(jobNum, result);
			
			
		//	request.setAttribute("jobnumber", jobNumber);
			
			System.out.println("--------------");
			response.sendRedirect("Response.jsp?jobnum="+jobNum);
			
			}
		
		else if (rType.equals("Poll")){
			//System.out.println("This is Poll");
	
			try {
				remoteFibonacci = (RemoteFibonacci) Naming.lookup("rmi://localhost:1099/fibonacci");
			} 
			catch (NotBoundException e) {
			
				e.printStackTrace();
			}
			int jobNum = Integer.valueOf(request.getParameter("a")) ;
			
			
			//System.out.println("jjjj"+jobNum);
			
			String fibResult=fibService.getResult(jobNum);
			System.out.println("fib...."+fibResult);
			//request.setAttribute("fibresult", result);
			response.sendRedirect("Result.jsp?fibresult="+fibResult);
			//System.out.println("..................");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
