<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Parcel Management - Booking Service</title>
     <link rel="stylesheet" href="./CSS/booking.css">
</head>
<body>


   <jsp:include page="header.jsp"></jsp:include>

    <main>
        <section class="booking-form">
            <h2>Book a Parcel</h2>
            <form action="bookingservlet" method="post">
                <div class="form-section">
                    <h3>Sender Information</h3>
                    <div class="form-group">
                        <label for="senderName">Name:</label>
                        <input type="text" id="senderName" name="senderName" 
                               value="" >
                    </div>
                    <div class="form-group">
                        <label for="senderAddress">Address:</label>
                        <input type="text" id="senderAddress" name="senderAddress"
                               >
                    </div>
                    <div class="form-group">
                        <label for="senderContact">Contact Details:</label>
                        <input type="text" id="senderContact" name="senderContact"
                             >
                    </div>
                </div>

                <div class="form-section">
                    <h3>Receiver Information</h3>
                    <div class="form-group">
                        <label for="receiverName">Name:</label>
                        <input type="text" id="receiverName" name="receiverName" required>
                    </div>
                    <div class="form-group">
                        <label for="receiverAddress">Address:</label>
                        <input type="text" id="receiverAddress" name="receiverAddress" required>
                    </div>
                    <div class="form-group">
                        <label for="receiverPincode">Pin Code:</label>
                        <input type="text" id="receiverPincode" name="receiverPincode" required>
                    </div>
                    <div class="form-group">
                        <label for="receiverContact">Contact Details:</label>
                        <input type="text" id="receiverContact" name="receiverContact" required>
                    </div>
                </div>

                <div class="form-section">
                    <h3>Parcel Details</h3>
                    
                    <div class="form-group">
                        <label for="parcelWeight">Weight (g):</label>
                        <input type="number" id="parcelWeight" name="parcelWeight" required>
                    </div>
                    <div class="form-group">
                        <label for="parcelContents">Contents Description:</label>
                        <textarea id="parcelContents" name="parcelContents" required></textarea>
                    </div>
                    
                    <div class="form-group">
                        <label for="preference">Packaging Preference:</label>
                        <textarea id="preference" name="preference" required></textarea>
                    </div>
                </div>

                <div class="form-section">
                    <h3>Shipping Options</h3>
                    <div class="form-group">
                        <label for="deliverySpeed">Delivery Type:</label>
                        <select id="deliverySpeed" name="deliverySpeed">
                            <option value="standard">Standard</option>
                            <option value="express">Express</option>
                             <option value="standard">Standard</option>
                            <option value="express">Normal</option>
                        </select>
                           <br>
                           
                         <br>
                         <label for="pickupTime">Pickup Time:</label>
                         <input type="datetime-local" id="pickupTime" name="pickupTime">
                         <br>
                         <br>
                          <label for="dropTime">Drop Time:</label>
                         <input type="datetime-local" id="dropTime" name="dropTime">
                          <br>
                          
                         <br>
                         
                        
                    </div>
                </div>

                <div class="form-section">
                    <h3>Payment</h3>
                    <div class="form-group">
                         <label for="parcelCost">Parcel Service Cost:</label>
                         <input type="text" name="parcelCost">
                      
                        
                    </div>
                </div>
                
              

                <div class="form-group">
                    <button type="submit" class="button" name="action" value="booking">Submit Booking</button>
                </div>
            </form>
        </section>
    </main>

    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>

