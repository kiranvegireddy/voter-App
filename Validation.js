   function  validate(frm){
	   // Set vflag to yes indicating  client side form validations are done
	   frm.vflag.value="yes";
	 
	  // Empty Error messages
	  document.getElementById("nameErr").innerHTML="";
     document.getElementById("ageErr").innerHTML="";
	  document.getElementById("nameErr").style.color='red';
     document.getElementById("ageErr").style.color='red';




	  //read form data
	  var name=frm.pname.value;
	  var age=frm.page.value;
	  // Perform Client side form validations
	  if(name==""){  //required rule
	    document.getElementById("nameErr").innerHTML="Name is mandatory";
		 frm.pname.focus();
		 return false;
		 }
		if(age==""){  //required rule
	    document.getElementById("ageErr").innerHTML="age is mandatory";
		 frm.page.focus();
		 return false;
		 }
		 else{
		    if(isNaN(age)){
			    document.getElementById("ageErr").innerHTML="Age must be numeric value";

			 frm.page.value="";
			 frm.page.focus();
			 return false;
			 } //if
		}//else
		return true;
   }//function
