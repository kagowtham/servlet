<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page isELIgnored="false" %>    
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>HOME</title>
    <style>
   .navbar {
      border-radius: 0;
      margin-bottom: 0;
    }
     footer {
      background-color: #f2f2f2;
      padding: 25px;
    }
    .cen{
      margin-bottom: 5px;
    }
    </style>
    <script>
       var imageSrc;
       var dateDelete;
       function startRefresh() {
    	   if(!$('#myModal').is(':visible')){
    	     $.get('', function(data) {
    	    	 console.log("refresh called");
    	        $(document.body).html(data);    
    	     });
    	   }
    	}
    	$(function() {
    	    setTimeout(startRefresh,7000);
    	});
       function image(src,date){
        $("#myModal").modal();
        $("#myimage").attr("src",src);
        imageSrc=src;
        dateDelete=date;
       }
       function save(){
    	   var link = document.createElement('a');
           link.href = imageSrc;
           link.download = 'Image.jpg';
           document.body.appendChild(link);
           link.click();     
       }
       function delete1(){
    	        $.post("Delete?date="+dateDelete, function(data) {
    			    console.log(data);
    		        if(data=="true"){
    		        	$('#myModal').modal('toggle');
    		        }else{
    		        	alert(" not deleted");
    		        }
    		    });
       }
</script>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <label class="navbar-brand" href="#">Intruder detection security system</label>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="index.jsp"><span class="glyphicon glyphicon-log-in"></span> signout</a></li>
      </ul>
    </div>
  </div>
</nav>
<div class="jumbotron">
 <div class="container text-center">
  <h3>Photos taken by sensor</h3> 
  </div>
</div>
<div class="container">
  <div class="container-fluid">
          <div class="row">
    <c:forEach items="${pictureList}" var="picture" varStatus="status">
        
            <div class="col-lg-3">
            <center class="cen">
              <div class="thumbnail">
              <img id="myBtn"  onclick="image('data:image/jpg;base64,${picture}','${dateList[status.index]}');" src="data:image/jpg;base64,${picture}"/>
               <div class="caption">
              ${dateList[status.index]}
              </div>
              </div>
             </center> 
            </div>
            <div id="myModal" class="modal fade" role="dialog">
            <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal">&times;</button>
            <h4 class="modal-title">Image</h4>
           </div>
          <div class="modal-body">
           <img id="myimage" class="img-responsive"/>
           </div>
           <div class="modal-footer">
           <button type="button" onclick="delete1()" class="btn btn-default" >Delete</button>
           <button type="button" onclick="save()" class="btn btn-default" >Save</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>
    </c:forEach>
     </div>
   </div>
</div>
<br><br>

<footer class="container-fluid text-center">
  <p>designed by team members of security theft preemtion system</p>
</footer>
</body>
</html>