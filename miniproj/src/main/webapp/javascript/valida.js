function validateForm()
    {
        var email=document.forms["Form"]["email"].value;
        var pswd=document.forms["Form"]["password"].value;
        if (email==null ||email=="")
        {
            alert("Email can't be null,Please enter email address.");
            return false;
        }
        else if(pswd==null || pswd=="")
        	{
        	  alert("Password can't be null,please enter password.");
              return false;
        	}
    }