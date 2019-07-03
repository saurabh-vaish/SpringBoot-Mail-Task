<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
 integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
 
 
<script src="https://use.fontawesome.com/c550de2b7c.js"></script>

<style>
label{
	font-weight:bold;
}

</style>

</head>
<body>

<div class="container">

    <div class="row mt-2">
        <div class="col-11 mx-auto">
            <div class="card border-primary bg-light">
                <div class="card-header text-center bg-primary text-white">
                   <span class="card-text h3">Mail UI</span>
                   <span>
                    <a href="/mail/reg" class="btn btn-outline-light float-right">New Email</a> </span>
                </div>
                <div class="card-body">
				<form:form action="save" method="post" modelAttribute="mailTask" enctype="multipart/form-data">
                    <div class="row">
                        <div class="col-6">
                            <div class="form-group">
                                <label for="to">To</label>
                                <form:input path="to" class="form-control" placeholder="enter email addreess"/>
                                 <form:errors  path="to" class="text-danger"/>
                            </div>
                            <div class="form-group">
                                <label for="subject">Subject</label>
                                <form:input path="subject" class="form-control" placeholder="subejct"/>
                                 <form:errors  path="subject" class="text-danger"/>
                            </div>
                        </div>
                         <div class="col-6">
                             <div class="form-group">
                                <label for="cc">Cc</label>
                                <form:input path="cc" class="form-control" placeholder="sperate email with , only"/>
                                 <form:errors  path="cc" class="text-danger"/>
                            </div>
                             <div class="form-group">
                                <label for="bcc">Bcc</label>
                                <form:input path="bcc" class="form-control" placeholder="sperate email with , only"/>
                                 <form:errors  path="bcc" class="text-danger"/>
                            </div>
                         </div>
                   	 </div>
				   	 <div class="row">
						<div class="form-group col-12">
						  <label for="text">Text</label>
							<form:textarea path="text" class="form-control" placeholder="enter text" />
							<form:errors path="text" class="text-danger" />
						</div>
					 </div>
					  <div class="row">
						  <label for="fileOb" class="ml-3">Attachment</label>
						<div class="form-group col-12">
							 <input type="file" name="fileOb" class="custom-file-input"/>
							<label class="custom-file-label mx-3" for="fileOb">Choose file</label>
							<small class="form-text text-muted" id="fileHelp">Max 3mb size</small>
						</div>
					 </div>
					 
					 <button type="submit" class="btn btn-block btn-success">Send&nbsp;<i class="fa fa-paper-plane-o" ></i></button>
				 
				 </form:form>    
                </div>
                	
                <c:if test="${mail ne null}">
		          <div class="card-footer bg-success text-center" style="padding: .40rem;">
                	  <h5 class="text-white">${mail}</h5>
		          </div>
                </c:if>
                <c:if test="${msg ne null}">
		          <div class="card-footer bg-info text-center" style="padding: .40rem;">
                	  <h5 class="text-white">${msg}</h5>
		          </div>
                </c:if>
                 <c:if test="${error ne null}">
		          <div class="card-footer bg-danger text-center" style="padding: .40rem;">
                	  <h5 class="text-white">${error}</h5>
		          </div>
                </c:if>
            </div>
        </div>
    </div>        
</div>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
 integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" 
integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" 
integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</body>
</html>