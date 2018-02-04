<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
 function func(){
	 $.post("Login?usr="+document.f1.usr.value+"&pwd="+document.f1.pwd.value, function(data) {
		 console.log(data);
	        if(data=="true"){

	        	console.log("correct");
	        	document.f1.submit();
	        	
	        }else{
	        	alert("username is not matches with password");
	        }
	    });
	
 }
</script>

</head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
  h1 {
    color : #000000;
    text-align : center;
    font-family: "SIMPSON";
  }
   form {
    width: 300px;
    margin: 0 auto;
}
</style>

<body>
   <h1>Security Preemtion System</h1>
   <form accept-charset=utf-8 name="f1" action="Image"  >
      <div class="form-group">
        <label>user name :</label>
        <input name="usr" class="form-control"></input>
      </div>
      <div class="form-group">
        <label>password :</label>
        <input name="pwd" type="password" class="form-control"></input>
      </div>
      <div class="form-group">
        <input type="button" value="register" onclick="location.href='register.jsp';" class="btn btn-primary"></input>
        <input type="button" value="login" onclick="func()" class="btn btn-success"></input>
      </div>
   </form>

</body>
</html> 
