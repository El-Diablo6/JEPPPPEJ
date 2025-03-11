<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Parcel Management - Booking History</title>
    <link rel="stylesheet" href="./CSS/history.css">
</head>

<body>
    <jsp:include page="header.jsp"></jsp:include>

    <main>
        <section class="booking-history-page">
            <h2>Booking History</h2>
            <div class="table-container">
                <table id="bookingTable">
                    <thead>
                        <tr>
                            <th>Customer ID</th>
                            <th>Booking ID</th>
                            <th>Booking Date</th>
                            <th>Receiver Name</th>
                            <th>Delivered Address</th>
                            <th>Amount</th>
                            <th>Status</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%-- Sample static data, replace with dynamic data from DB --%>
                        <tr>
                            <td>1</td>
                            <td>100</td>
                            <td>2025-11-20</td>
                            <td>Dinesh</td>
                            <td>Nallurhalli Flat No 401</td>
                            <td>25.00</td>
                            <td>Booked</td>
                        </tr>
                        
                        <tr>
                            <td>1</td>
                            <td>101</td>
                            <td>2025-10-20</td>
                            <td>Dinesh</td>
                            <td>Nallurhalli Flat No 401</td>
                            <td>205.00</td>
                            <td>Delivered</td>
                        </tr>
                        
                        <tr>
                            <td>1</td>
                            <td>102</td>
                            <td>2025-19-20</td>
                            <td>Dinesh</td>
                            <td>Nallurhalli Flat No 401</td>
                            <td>155.00</td>
                            <td>Delivered</td>
                        </tr>
                        
                    </tbody>
                </table>
            </div>
            <div class="pagination">
                <button id="prevPage" disabled>Previous</button>
                <span id="currentPage">1</span>
                <button id="nextPage">Next</button>
            </div>
        </section>
    </main>

     <jsp:include page="footer.jsp"></jsp:include>

    
</body>

</html>

