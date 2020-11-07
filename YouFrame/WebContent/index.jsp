<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%> 
<%@page import="java.util.Iterator"%> 
<%@page import="com.model.ImageData"%> 

<!DOCTYPE html>
<html>
<head>
<title>
YouFrame
</title>
<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script> 
<script>
    $(document).ready(function(){
    	var fileupload = $("#FileUpload1");
		var filePath = $("#spnFilePath");
		var button = $("#btnFileUpload");
		
		button.click(function (event) {
			event.preventDefault()
			fileupload.click();
		});
		
		fileupload.change(function () {
			//alert("hello");
			$("#uploadForm").submit();
		});
    });
</script>
<link rel="stylesheet" href="css/style.css">
</head>
<body>

<header class="header">
   <p class="header_p">Gallery</p>
</header>

  <div >
     <form action="upload_image" id="uploadForm" method="post" enctype="multipart/form-data">
	  <button  id="btnFileUpload" class="upload">
		<img class="btnimg" src="img/upload.svg" alt="" />
		Upload
	  </button>
	<input type="file" accept="image/*" id="FileUpload1" name = "file" style="display: none" />
	</form>
</div>
<div class="vertical-center">
<%
		try{
			ArrayList<ImageData> accountstatusmodelData = (ArrayList)request.getAttribute("imageRecord");
			if(request.getAttribute("imageRecord") != null)  // Null check for the object
			{
				int count =0;
				%>
				
				<div class="row">
		      <%
				Iterator<ImageData> iterator = accountstatusmodelData.iterator();  // Iterator interface
				
				while(iterator.hasNext())  // iterate through all the data until the last record
				{
					ImageData patient = iterator.next(); //assign individual employee record to the employee class object
					if(count < 3){
				%>
				  <div class="column">
					<div class="content">
					<img id="<%=patient.getImageName() %>" src="<%= patient.getImagePath() %>" class="preview-image">
					<div class="text"><%=patient.getImageName() %></div>
					</div>
				  </div>
				<%
				  count++;
				  } else {
					  count=0;
				    
				%>
				  
				</div>
				<div class="row">
				<%
				  }
				}
			}else{
				%>
				
				<%
				
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		
		}
		%>
		
</div>
</div>

<footer class="footer">
<p class="footer_p">
Fullstack Challenge - 2020
</p>
</footer>
</body>
</html>