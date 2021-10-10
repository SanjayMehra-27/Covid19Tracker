<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title> Covid-19 Tracker </title>
  </head>
  <body class="bg-dark">
   
    <header>    
                <nav class="navbar navbar-expand-lg navbar-light sticky-top bg-white">
                    <div class="container">
                        <a class="navbar-brand text-uppercase" href="${pageContext.request.contextPath}"> <strong> Covid-19 Tracker </strong></a>
                    </div>
                </nav>
    
    </header>


    <section class="container mt-4">
        <header>    </header>

        <article class="">


            <div class="row">
                <div class="col-sm-6">
                
                 <c:forEach items="${covidGlobal}" var="covid">
                 
                    <div class="card m-3 text-center">
                        <div class="card-body">
                            <h5 class="card-title text-uppercase font-weight-bold text-success"> <strong>covid-19 global </strong></h5>
                            
                                <div class="row text-justify"> 
                            
                                    <div class="col-lg-4 ">
                                        <p class="text-muted font-weight-bold container text-center"><fmt:formatNumber type = "number" value = "${covid.confirmed}" /> <br><span class="badge badge-dark"> Positive </span></p>
                                    
                                    </div>
                                    <div class="col-lg-4"> 
                                        <p class="text-muted font-weight-bold container text-center"><fmt:formatNumber type = "number" value = "${covid.recovered}" /> <br><span class="badge badge-dark"> Recovered </span></p>
                                    </div>
                                    <div class="col-lg-4">
                                        <p class="text-muted font-weight-bold container text-center"><fmt:formatNumber type = "number" value = "${covid.deaths}" /><br><span class="badge badge-dark"> Deaths </span></p>
                                    </div>
                                    <div class="container mt-2">
									 
									 	<p class="font-weight-bold font-italic text-center"><span class="badge badge-secondary">${covid.date} </span> </p>
                                
                                	</div>
                                </div>
                                
                        </div>

                        <div class="card-footer bg-transparent">
                        	<p> <span class="badge badge-light float-right ">${covid.last_update}</span>  </p>
                           
                        </div>
                               
                            
                     </div>
                   
                   </c:forEach>
                </div>
                <div class="col-sm-6">
                   <c:forEach items="${IndiaCovid}" var="covid">
                    <div class="card m-3 text-center">
                        <div class="card-body">
                            <h5 class="card-title text-uppercase font-weight-bold text-success"> <strong>covid-19 India</strong></h5>
                
                            <div class="row text-justify">
                                <div class="col-lg-4 ">
                                    <p class="text-muted font-weight-bold container text-center"><fmt:formatNumber type = "number" value = "${covid.confirmed}" /><br><span class="badge badge-dark"> Positive </span>
                                    </p>
                                   
                                </div>
                                <div class="col-lg-4 ">
                                    <p class="text-muted font-weight-bold container text-center"><fmt:formatNumber type = "number" value = "${covid.recovered}" /><br><span class="badge badge-dark"> Recovered </span>
                                    </p>
                                </div>
                                <div class="col-lg-4 ">
                                    <p class="text-muted font-weight-bold container text-center"><fmt:formatNumber type = "number" value = "${covid.deaths}" /><br><span class="badge badge-dark"> Deaths </span></p>
                                </div>
                                <div class="container mt-2">
									 <p class="font-weight-bold font-italic text-center"><span class="badge badge-secondary">${covid.date} </span> </p>
                                </div>
                            </div>
                        </div>
                
                        <div class="card-footer bg-transparent">
                        
                        	<p> <span class="badge badge-light float-right ">${covid.last_update}</span>  </p>
                        
                        </div>
                    </div>
                </c:forEach>
                </div>
            </div>

        </article>



    </section>


    <section class="container mt-4">
        <header>

        </header>


        <article>

           <div class="card border-primary">
           
             <div class="card-body">
                
                <table class="table table-dark table-bordered">
                    <thead class="thead-light text-center">
                        <tr>
                            <th>State</th>
                            <th>Positive</th>
                            <th>Recovered</th>
                            <th>Deaths</th>
                        </tr>
                        
                    </thead>
                
                    <tfoot class="text-center">
                    <c:forEach items="${listCovidStates}" var="covid">

                        <tr>
                            <th class="text-left">${covid.province}</th>
                            <th><fmt:formatNumber type = "number" value = "${covid.confirmed}" /></th>
                            <th><fmt:formatNumber type = "number" value = "${covid.recovered}" /></th>
                            <th><fmt:formatNumber type = "number" value = "${covid.deaths}" /></th>
                        </tr>
                        
                      </c:forEach>
                      
                      
                    </tfoot>
                </table>
                

             </div>

           </div>

        </article>



    </section>






    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>