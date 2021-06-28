<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<style>
	body {
	    font-family: "Lato", sans-serif;
	}
	
	
	
	.main-head{
	    height: 150px;
	    background: #FFF;
	   
	}
	
	.sidenav {
	    height: 100%;
	    background-color: #000;
	    overflow-x: hidden;
	    padding-top: 20px;
	}
	
	
	.main {
	    padding: 0px 10px;
	}
	
	@media screen and (max-height: 450px) {
	    .sidenav {padding-top: 15px;}
	}
	
	@media screen and (max-width: 450px) {
	    .login-form{
	        margin-top: 10%;
	    }
	
	    .register-form{
	        margin-top: 10%;
	    }
	}
	
	@media screen and (min-width: 768px){
	    .main{
	        margin-left: 40%; 
	    }
	
	    .sidenav{
	        width: 40%;
	        position: fixed;
	        z-index: 1;
	        top: 0;
	        left: 0;
	    }
	
	    .login-form{
	        margin-top: 50%;
	    }
	
	    .register-form{
	        margin-top: 20%;
	    }
	}
	
	
	.login-main-text{
	    margin-top: 20%;
	    padding: 60px;
	    color: #fff;
	}
	
	.login-main-text h2{
	    font-weight: 300;
	}
	
	.btn-black{
	    background-color: #000 !important;
	    color: #fff;
	}
</style>
</head>
<body>
	<div class="sidenav">
         <div class="login-main-text">
            <h2>BANCO UTN<br></h2>
            <p>Ingrese usuario y contraseña para ingresar.</p>
         </div>
      </div>
      <div class="main">
         <div class="col-md-6 col-sm-12">
            <div class="login-form">
               <form>
                  <div class="form-group">
                     <label>Nombre</label>
                     <input type="text" class="form-control" >
                  </div>
                  <div class="form-group">
                     <label>Contraseña</label>
                     <input type="password" class="form-control">
                  </div>
                  <div style="margin-top:10px;">
	                  <button type="submit" name="login" class="btn btn-black">Login</button>
	                  <a class="btn btn-primary" href="AñadirUsuario.jsp" role="button">Registrarse</a>
                  </div>	
               </form>
            </div>
         </div>
      </div>
</body>
</html>