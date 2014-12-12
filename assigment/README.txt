A Fibonacci Sequence Pull Service
==========================================================
Programmer: LU JIANG(Ethan)G00307216
Summary:  This program ask user for a Number(1-100).By doing this,we can indicate how random Job Number,and page will refresh in 10 seconds.After 10 seconds indicate how many number of Fibonacci Sequence same with user input.


INPUT:  From CONSOLE/keyboard -- one number(1-100).
        If this number is greater than 94,it will be negative, because the number appearing at this moment, exceeded the maximum number of "Long" can store.
        
OUTPUT: A JobNumber(random),and page will refresh in 10 seconds.After 10 seconds display how many number of Fibonacci Sequence same with user input.

        
===Simple output===
input:
4

output:
--------------------------------------
Fibonacci Request
 
Job Number: XXX(It is random)

Page will refresh in  10 seconds  

--------------------------------------
Result
0,1,1,2  

Return to Start(Button)
--------------------------------------
The working principle:    The first page after Max input values, passed to the corresponding to the Servlet.Invoke the add method of FibonacciService,generate random jobnumber and added to the In-Queue.And invoke to the remote object getFibonacciSequence method.Introduced to the first page of input values(max),calculate the Fibonacci sequence,then invoke FibonacciService put method,the results and jobnumber deposit Out-Queue.The second page shows jobnumber.Page will refresh in  10 seconds.The second page after 10 seconds pass jonnumber to servlet.Invoke FibonacciService getResult method ,to the second page jobnumber from Out-Queue to get results.Finally, as shown in the third page.


===================
"""