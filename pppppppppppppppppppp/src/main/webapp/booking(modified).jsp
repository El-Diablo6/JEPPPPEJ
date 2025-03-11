<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="com.model.User"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Parcel Management - Booking Service</title>
    <style>
    
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;

            padding: 0;
            background-color: #f0f4f8;
            color: #333;
        }

        /* Header */
        header {
            background-color: #fff;
            padding: 20px;
            display: flex;

            justify-content: space-between;
            align-items: center;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        footer {
            position: fixed;
            left: 0;
            bottom: 0;
            width: 100%;
            background-color: red;
            color: white;
            text-align: center;
        }

        .logo-container {

            display: flex;
            align-items: center;


        }

        .logo {
            max-height: 50px;
        }

        nav ul {
            list-style: none;
            padding: 0;
            margin: 0;
            display: flex;
            gap: 20px;
        }

        nav a {
            text-decoration: none;
            color: #333;
            font-weight: 600;
        }

        .user-info {
            display: flex;
            align-items:
                center;
            gap: 20px;
        }

        .user-info #welcomeMessage {
            font-weight: bold;
        }

        #logoutLink {
            text-decoration: none;
            color: #2c67a7;
            font-weight:
                bold;
        }

        /* Main Content */
        main {
            padding: 20px;
        }

        .booking-form {
            background-color: #fff;
            padding: 100px;
            width: 500px;
            margin: 0 auto;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            margin-bottom: 20px;
        }

        .booking-form h2 {
            color: #2c67a7;
            text-align: center;
            margin-bottom: 20px;
        }

        .form-section {
            margin-bottom: 20px;
        }

        .form-section h3 {
            color: #2c67a7;
            margin-bottom: 10px;
        }

        .form-group {
            margin-bottom: 15px;
        }

        .form-group label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }

        .form-group input[type="text"],
        .form-group input[type="number"],
        .form-group input[type="date"],
        .form-group input[type="time"],
        .form-group select,
        .form-group textarea {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        .form-group textarea {
            height: 80px;
        }

        .button {
            background-color: #2c67a7;
            color: white;
            padding: 10px 15px;
            border-radius: 4px;
            text-decoration: none;
            display: inline-block;
            transition: background-color 0.3s;

            border: none;
            cursor: pointer;
        }

        .button:hover {
            background-color: #1e4a79;
        }

        .error-message {
            color: red;
            font-size: 0.9em;
            display: block;
            margin-top: 5px;
        }

        #uservalidate {
            color: red;
            font-size: 0.8em;
            display: none;
        }

        #mobilevalidate {
            color: red;
            font-size: 0.8em;
            display: none;
        }

        #pincodevalidate {
            color: red;
            font-size: 0.8em;
            display: none;
        }

       .form-section .form-group .datetime{
        display: flex;
        justify-content:flex-start;
        align-items:flex-start;
        gap: 20px;
       }

        #heading{
color:#d5636d;
font-style:italic;
display:flex;
justify-content:center;

}
   

    </style>
</head>

<body>

	<%
		HttpSession sess = request.getSession();

		User obj = (User) sess.getAttribute("user");
			String role = obj.getRole();
		 
	
	%>
		
 <jsp:include page="header.jsp"></jsp:include>
 
<% 
 String error=(String) request.getAttribute("error");
 if(error!=null) { %>
  <h2 id="heading"> User mail or Phone number already exist</h2>
 <% } %>
    <main>
        <section class="booking-form">
            <h2>Book a Parcel :</h2>
             <form action="bookingservlet" method="post">
                <div class="form-section">
                
                <% if(role.equalsIgnoreCase("customer" )) { %> 
               
                    <h3>Sender Information</h3>
                    <div class="form-group">
                        <label for="senderName">Name:</label>
                        <input type="text" id="senderName" name="senderName" value="<%= obj.getName() %>" readonly>
                    </div>
                    <div class="form-group">
                        <label for="senderAddress">Address:</label>
                        <input type="text" id="senderAddress" name="senderAddress" value="<%= obj.getAddress() %>" readonly>
                    </div>
                    <div class="form-group">
                        <label for="senderContact">Contact Details:</label>
                        <input type="text" id="senderContact" name="senderContact" value="<%= obj.getMobile() %>" readonly>
                    </div>
                    
                    <% }  %>
                    
                    
                    
                    
                    
                </div>

                <div class="form-section">
                    <h3>Receiver Information</h3>
                    <div class="form-group">
                        <label for="receiverName">Name:</label>
                        <input type="text" id="receiverName" name="receiverName" required>
                    </div>
                    <div id="uservalidate">
                        <p> Please enter a valid user name. </p>
                    </div>
                    <div class="form-group">
                        <label for="receiverAddress">Address:</label>
                        <input type="text" id="receiverAddress" name="receiverAddress" required>
                    </div>
                    <div class="form-group">
                        <label for="receiverPincode">Pin Code:</label>
                        <input type="text" id="receiverPincode" name="receiverPincode" required>
                    </div>
                    <div id="pincodevalidate">
                        <p> Please enter a valid pin code. </p>
                    </div>
                    <div class="form-group">
                        <label for="receiverContact">Contact Details:</label>
                        <input type="text" id="receiverContact" name="receiverContact" required>
                    </div>
                    <div id="mobilevalidate">
                        <p> Please enter a valid phone number. </p>
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


                </div>
                <div class="form-section">
                    <h3>Shipping Options</h3>
                    <div class="form-group">
                        <label for="deliverySpeed">Delivery Speed:</label>
                        <select id="preference" name="preference">
                            <option value="standard">Standard Delivery</option>
                            <option value="express">Express Delivery</option>
                            <option value="same-Day">Same-Day Delivery</option>
                            <option value="overnight">Overnight Shipping</option>
                            <option value="international">International Delivery</option>

                        </select>

                        <br>
                        <br>


                        <label for="deliverySpeed">Packaging Preference:</label>
                        <select id="deliverySpeed" name="deliverySpeed">
                            <option value="standard">Standard</option>
                            <option value="fragile">Fragile</option>
                            <option value="waterproof">Waterproof</option>
                            <option value="eco">Eco-Friendly</option>
                            <option value="gift">Gift Wrap</option>
                            <option value="temperature">Temperature-Controlled</option>
                        </select>
                        <br>

                        <br>
                        <div class="datetime">
                            <div class="pickup">
                        <label for="pickupTime">Pickup Time:</label>
                        <input type="datetime-local" id="pickupTime" name="pickupTime" required>
                    </div>
                        <br>
                        <br>
                        <div class="dropoff">
                        <label for="dropTime">Dropoff Time:</label>
                        <input type="datetime-local" id="dropTime" name="dropTime" required>
                    </div>
                    </div>
                      


                    </div>
                </div>

                <div class="form-section">
                    <h3>Payment</h3>
                    <div class="form-group">
                        <label for="parcelCost">Parcel Service Cost:</label>
                        <input type="text" id="parcelCost" name="parcelCost" readonly>

                        <div id="parcelError" class="error-message" style="display: none;"></div>

                    </div>
                </div>



                <div class="form-group">
                    <button type="submit" class="button" name="action" value="booking">Make Payment</button>
                </div>
            </form>
        </section>
    </main>
 <jsp:include page="footer.jsp"></jsp:include>
    <script>


        document.addEventListener('DOMContentLoaded', function () {
            const parcelWeight = document.getElementById('parcelWeight');
            const deliverySpeed = document.getElementById('deliverySpeed');
            const preference = document.getElementById('preference');
            const parcelCostTextarea = document.getElementById('parcelCost');
            const parcelErrorDiv = document.getElementById('parcelError');
            const receiverName = document.getElementById('receiverName');
            const uservaliddiv = document.getElementById('uservalidate');
            const receiverpin = document.getElementById('receiverPincode');
            const receiverContact = document.getElementById('receiverContact');
            const mobileValidateDiv = document.getElementById('mobilevalidate');
            const pincodeValidateDiv = document.getElementById('pincodevalidate');


            receiverName.addEventListener('input', function () {
                const user1 = receiverName.value.trim();
                const user = user1.toLowerCase();
                if (user === "" || user === "null" || user === "nan" || user === "undefined") {
                    uservaliddiv.style.display = "block";
                }
                else if (user.length < 3) {
                    uservaliddiv.style.display = "block";
                }
                else {
                    uservaliddiv.style.display = "none";
                }
            });

            receiverContact.addEventListener('input', function () {
                const mobile = receiverContact.value;
                const mobilePattern = /^[6-9]\d{9}$/;

                if (!mobilePattern.test(mobile)) {
                    mobileValidateDiv.style.display = 'block';
                    mobileValidateDiv.querySelector('p').textContent = 'Please enter a valid phone number.';

                }
                else if (/(.)\1{5,}/.test(mobile)) {
                    mobileValidateDiv.style.display = 'block';
                    // More than 6 consecutive identical digits
                }
                else {
                    mobileValidateDiv.style.display = 'none';

                }
            });
            receiverpin.addEventListener('input', function () {
                const pin = receiverpin.value;
                const pinPattern = /^[1-9][0-9]{5}$/;

                if (!pinPattern.test(pin)) {
                    pincodeValidateDiv.style.display = 'block';
                    pincodeValidateDiv.querySelector('p').textContent = 'Please enter a valid pin code.';

                } else {
                    pincodeValidateDiv.style.display = 'none';

                }
            });


            function calculateParcelCost() {
                const weight = parseFloat(parcelWeight.value);
                const selectedDeliverySpeed = deliverySpeed.value;
                const selectedPreference = preference.value;

                let cost = 50;
                let error = '';

                if (isNaN(weight) || weight <= 0) {
                    error = 'Please enter a valid parcel weight.';
                } else {

                    cost = (weight * 0.01) * cost;

                    if (selectedPreference === "standard") { // Corrected the selector here
                        cost *= 1;
                    } else if (selectedPreference === "express") {
                        cost *= 1.5;
                    } else if (selectedPreference === "same-Day") {
                        cost *= 2.5;
                    } else if (selectedPreference === "overnight") {
                        cost *= 2;
                    } else if (selectedPreference === "international") {
                        cost *= 3;
                    }

                    if (selectedDeliverySpeed === "standard") {  //Corrected the selector here
                        cost *= 1; // No extra cost for basic
                    } else if (selectedDeliverySpeed === "fragile") {
                        cost *= 1.1; // Add 10% for fragile
                    } else if (selectedDeliverySpeed === "waterproof") {
                        cost *= 1.07; // Add 7% for waterproof
                    } else if (selectedDeliverySpeed === "eco") {
                        cost *= 1.05; // Add 5% for eco-friendly
                    } else if (selectedDeliverySpeed === "gift") {
                        cost *= 1.12; // Add 12% for gift wrap
                    } else if (selectedDeliverySpeed === "temperature") {
                        cost *= 1.2; // Add 20% for temperature-controlled
                    }

                }

                if (error) {
                    parcelErrorDiv.textContent = error;
                    parcelErrorDiv.style.display = 'block';
                    parcelCostTextarea.value = '';
                } else {
                    parcelErrorDiv.style.display = 'none';
                    parcelCostTextarea.value = 'Rs.'+cost.toFixed(2);
                    console.log(cost.toFixed(2));
                }
            }

            parcelWeight.addEventListener('input', calculateParcelCost);
            deliverySpeed.addEventListener('change', calculateParcelCost);
            preference.addEventListener('change', calculateParcelCost);



        });
    </script>
</body>

</html>