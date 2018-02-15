//VoterSrv.java
package com.nt;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
public class VoterSrv extends HttpServlet
{
	public void  process(HttpServletRequest req,
		                            HttpServletResponse res)throws ServletException,  IOException
	{
		String name=null,tage=null;
		int age=0;
		List<String> listErrors=null;
             System.out.println("VoterSrv: process(-,-)");
		//General settings
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		// read form data(req param values)
		 name=req.getParameter("pname");
		 tage=req.getParameter("page").trim();
		 //read Vflag value  to enable or disable server side form validation validations
		 String vstatus=req.getParameter("vflag");
		 if(vstatus.equals("no")){
       	//write Form validation logic  (Server Side)
		System.out.println("Server Side Validations are done");
		 listErrors=new ArrayList<String>();
		if(name==null || name.equals("") || name.length()==0){  //required
     		listErrors.add(" Persion name is mandatory");
		}
		if(tage==null || tage.equals("") || tage.length()==0){ //required
    		listErrors.add(" Persion age is mandatory");
   		}
       else{  // age must be numeric value rule
	   try{
		   age=Integer.parseInt(tage);
	   }
	   catch(NumberFormatException nfe){
     		listErrors.add(" Persion age must be numberic value");
       }
   }//else

        // Display form validation errors
		if(listErrors.size()!=0){
		
             for(String errMsg: listErrors){
				 pw.println("<font color='red' size='4'><li>"+errMsg+"</font></li>");
			 }//for
			 return ;
 		}//if */
	 }
	 else{
		 System.out.println("Server side form validations are not done");
		 age=Integer.parseInt(tage);
	 }

			//write request processing logic
  if(age<18)
	 pw.println("<h1 style='color:red'>"+name +" u  r  not elgible to vote</h1>");
	else
	pw.println("<h1 style='color:green'>"+name +" u  r  elgible to vote</h1>");
//add graphical hyperlink
	pw.println("<a href='input.html'><img src='tips.gif' /></a>");
	//close stream
	pw.close();
  }//doGet(-,-)

  public void  doGet(HttpServletRequest req,
		                            HttpServletResponse res)throws ServletException,   IOException{
	     System.out.println("VoterSrv:doGet(-,-)");
	    process(req,res);
}

 public void  doPost(HttpServletRequest req,
		                            HttpServletResponse res)throws ServletException,   IOException{
	     System.out.println("VoterSrv:doPost(-,-)");
	    process(req,res);
}



}//class
//>javac -d . VoterSrv.java
