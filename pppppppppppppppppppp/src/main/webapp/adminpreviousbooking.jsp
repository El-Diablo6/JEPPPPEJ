<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Parcel Management - PreviousBooking</title>
    
    <!-- Corrected CSS Path -->
    <link rel="stylesheet" href="./CSS/tracking.css">
    <style>
       #heading{
color:#d5636d;
font-style:italic;
display:flex;
justify-content:center;

}
    </style>
  
</head>

<body>
   
    <jsp:include page="header.jsp"></jsp:include>
     <% 
 String error=(String) request.getAttribute("error");
 if(error!=null) { %>
  <h2 id="heading">Booking ID not found</h2>
 <% } %>

    <main>
        <section class="tracking-page">
        <form action="trackingservlet" method="get">
        <h2>Previous Bookings</h2>
            <div class="tracking-form">
                <div class="form-group">
                    <label for="UserId">User ID:</label>
                    <input type="text" id="UserId" name="UserId" maxlength="20" required>
                    <span class="error-message" id="UserIdError"></span>
                </div>
                <div class="form-group">
                    <button id="searchButton" class="button" name="action" value="history">Search</button>
                </div>
            </div>
           
        </form>
            
        </section>
    </main>

    <jsp:include page="footer.jsp"></jsp:include>
    <!-- Corrected JavaScript Path -->
    <script src="./JavaScript Files/tracking.js"></script>

</body>

</html>
 
