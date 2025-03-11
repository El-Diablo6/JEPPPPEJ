<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.text.*, com.model.Booking" %>

<%! 

public String convertToDateTimeLocal(String dateTimeString) {
    try {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm a");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        Date date = inputFormat.parse(dateTimeString);
        return outputFormat.format(date);
    } catch (Exception e) {
        return "";
    }
}
%>

<%
    Booking booking = (Booking) request.getAttribute("booked");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pick-up Schedule</title>
    <link rel="stylesheet" href="./CSS/pickupdata.css">
</head>
<body>
     <jsp:include page="header.jsp"></jsp:include>

    <div class="container">
        <h2>Pick-up Schedule</h2>
        <% if (booking == null) { %>
            <p class="error">Error: Booking details not found!</p>
        <% } else { %>
            <p><strong>Booking ID:</strong> <%= booking.getBookingID() %></p>
            <p><strong>Full Name:</strong> <%= booking.getName() %></p>
            <p><strong>Address:</strong> <%= booking.getAddress() %></p>
            <p><strong>Recipient Name:</strong> <%= booking.getRecipientName() %></p>
            <p><strong>Recipient Address:</strong> <%= booking.getRecipienAddress() %></p>
            <p><strong>Date of Booking:</strong> <%= booking.getPaymentTime() %></p>
            <p><strong>Parcel Status:</strong> <%= booking.getParcelStatus() %></p>

            <form action="updateservlet" method="get">
                <input type="hidden" name="bookingId" value="<%= booking.getBookingID() %>">
                
                <label for="pickupTime">Pick-up Time:</label>
                <input type="datetime-local" id="pickupTime" name="pickupTime" 
                        value="<%=booking.getParcelPickupTime() %>" required>
                
                <label for="dropoffTime">Drop-off Time:</label>
                <input type="datetime-local" id="dropoffTime" name="dropoffTime" 
                       value="<%=booking.getParcelDropoffTime() %>" required>

                <button type="submit" name="action" value="timeupdate1">Update</button>
            </form>

            <form action="pickupscheduling.jsp" method="get">
                <button type="submit">Back</button>
            </form>
        <% } %>
    </div>
    
     <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>