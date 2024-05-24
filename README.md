# QR Code Payment Generator

This Spring Boot application generates QR codes for UPI (Unified Payments Interface) payments. The QR code can be scanned by any UPI-compatible payment application to initiate a payment with the provided details.

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven

### Building and Running the Application

1. **Clone the repository**:

    ```sh
    git clone https://github.com/rakeshsonkar/phonepaqrgenrator.git
    cd phonepaqrgenrator
    ```

2. **Build the project**:

    ```sh
    mvn clean install
    ```

3. **Run the application**:

    ```sh
    mvn spring-boot:run
    ```

The application will start on `http://localhost:8080`.

## API Documentation

### Overview

This API allows you to generate a QR code for payment using UPI (Unified Payments Interface) details. The QR code can be scanned by any UPI-compatible payment application to initiate a payment with the provided details.

### Base URL

### Endpoint

#### Generate QR Code

Generates a QR code based on the provided UPI payment information.

- **URL**: `/generateQRCode`
- **Method**: `GET`
- **Headers**: None
- **Response Format**: PNG image

#### Query Parameters

| Parameter | Type   | Required | Description                      |
|-----------|--------|----------|----------------------------------|
| `pa`      | String | Yes      | Payee address (UPI ID)           |
| `pn`      | String | Yes      | Payee name                       |
| `am`      | String | Yes      | Amount to be paid                |
| `cu`      | String | Yes      | Currency code (e.g., INR)        |
| `tn`      | String | Yes      | Transaction note or description |

#### Example Request
### Success Response

- **Code**: 200 OK
- **Content**: PNG image of the QR code

#### Example Response

The response is a PNG image file representing the QR code.

### Error Responses

#### Bad Request

- **Code**: 400 Bad Request
- **Content**: Error message indicating what went wrong.

#### Example Error Response

```json
{
    "error": "Invalid parameters provided"
}
