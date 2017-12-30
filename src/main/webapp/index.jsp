<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style>
.switch {
  position: relative;
  display: inline-block;
  width: 60px;
  height: 34px;
}

.switch input {display:none;}

.slider {
  position: absolute;
  cursor: pointer;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: #ccc;
  -webkit-transition: .4s;
  transition: .4s;
}

.slider:before {
  position: absolute;
  content: "";
  height: 26px;
  width: 26px;
  left: 4px;
  bottom: 4px;
  background-color: white;
  -webkit-transition: .4s;
  transition: .4s;
}

input:checked + .slider {
  background-color: #2196F3;
}

input:focus + .slider {
  box-shadow: 0 0 1px #2196F3;
}

input:checked + .slider:before {
  -webkit-transform: translateX(26px);
  -ms-transform: translateX(26px);
  transform: translateX(26px);
}

/* Rounded sliders */
.slider.round {
  border-radius: 34px;
}

.slider.round:before {
  border-radius: 50%;
}
</style>
</head>
<body>
<script type="text/javascript">
   function func(){
	   var checkBox = document.getElementById("check");
	   if (checkBox.checked == true){
		   $.ajax({
			     url: "<%=request.getContextPath()%>/Test?status=on",              
			     type: "GET", 
			     success: function(data){
			        console.log(data);
			       } 
			     });
	   } else {
		   $.ajax({
			     url: "<%=request.getContextPath()%>/Test?status=off",              
			     type: "GET", 
			     success: function(data){
			        console.log(data);
			       } 
			     });
	   }
   }


</script>
<h2>Switch</h2>

<label class="switch">
  <input type="checkbox" id="check" onclick="func()">
  <span class="slider round"></span>
</label>

</body>
</html> 
