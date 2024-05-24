# QR Code Payment Generator

This project is a Spring Boot application that generates QR codes for UPI payments. The QR code can be scanned by any UPI-compatible payment application to initiate a payment with the provided details.

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven

### Installing

1. **Clone the repository**:
   ```sh
   git clone https://github.com/your-username/qr-code-payment-generator.git
   cd qr-code-payment-generator
2.  **Build the project**:
     ```sh
mvn clean install
3.  **Run the application** : 
```sh
mvn spring-boot:run

The application will start on http://localhost:8080.

### API Documentation
**Overview**
This API allows you to generate a QR code for payment using UPI (Unified Payments Interface) details. The QR code can be scanned by any UPI-compatible payment application to initiate a payment with the provided details.

Base URL
arduino
Copy code
http://localhost:8080
Endpoint
Generate QR Code
Generates a QR code based on the provided UPI payment information.

URL: /generateQRCode
Method: GET
Headers: None
Response Format: PNG image
**Query Parameters**
![image](https://github.com/rakeshsonkar/phonepaqrgenrator/assets/92536736/9c940179-a616-4d4d-a34c-0e6d27491a4f)

GET /generateQRCode?pa=someone@bank&pn=Someone&am=100&cu=INR&tn=Payment+for+services

Success Response
Code: 200 OK
Content: PNG image of the QR code
Example Response
The response is a PNG image file representing the QR code.

Error Responses
Bad Request
Code: 400 Bad Request
Content: Error message indicating what went wrong.
Example Error Response
json
Copy code
{
    "error": "Invalid parameters provided"
}
