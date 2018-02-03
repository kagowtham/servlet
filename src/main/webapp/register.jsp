<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
  h1,h3{
    color : #000000;
    text-align : center;
    font-family: "SIMPSON";
  }
   form {
    width: 300px;
    margin: 0 auto;
}
</style>
<script>
  function val(){
	  var devid=document.f1.devid.value;
	  var usr=document.f1.usr.value;
	  var pwd1=document.f1.pwd1.value;
	  var pwd=document.f1.pwd.value;
	  if(devid.length==0){
		  alert("enter the id");
		  return false;
	  }else if(usr.length==0){
		  alert("enter the username");
		  return false;
	  }else if(pwd1.length==0){
		  alert("enter the password");
		  return false;
	  }else if(pwd1!=pwd){
		  alert("recheck the password");
		  return false;
	  }else{
		  return true;
	  }
  }
</script>
<body>
 <h1> security preemption system</h1>
 <h3>Enter the details</h3>
 <form name="f1" method="post" onsubmit="return val()" action="Register">
 <div class="form-group">
        <label> Enter device id :</label>
        <input name="devid" class="form-control"></input>
      </div>
    <div class="form-group">
        <label> Enter user name :</label>
        <input name="usr" class="form-control"></input>
      </div>
      <div class="form-group">
        <label>Enter password :</label>
        <input name="pwd1" type="password" class="form-control"></input>
      </div>
      <div class="form-group">
        <label> ReEnter password :</label>
        <input name="pwd" class="form-control"></input>
      </div>
      <div class="form-group" align="center">
        <input type="submit" value="register" class="btn btn-primary"></input>
      </div>
 </form>
</body>
</html>