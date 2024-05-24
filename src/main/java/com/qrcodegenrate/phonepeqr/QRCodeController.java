package com.qrcodegenrate.phonepeqr;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RestController
public class QRCodeController {

	@Autowired
	private QrCodeGeneratorService qrCodeGeneratorService;

	@GetMapping("/generate-qr1")
	public ResponseEntity<byte[]> generateQRCode(@RequestParam String data) throws WriterException, IOException {
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, 250, 250);

		ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
		MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
		byte[] pngData = pngOutputStream.toByteArray();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_PNG);

		return ResponseEntity.ok().headers(headers).body(pngData);
	}

	@GetMapping("/generateQRCode")
	public ResponseEntity<byte[]> generateQRCode(@RequestParam String pa, @RequestParam String pn,
			@RequestParam String am, @RequestParam String cu, @RequestParam String tn) {
		try {
			String upiUrl = String.format("upi://pay?pa=%s&pn=%s&am=%s&cu=%s&tn=%s", pa, pn, am, cu, tn);
			byte[] qrCode = qrCodeGeneratorService.generateQRCode(upiUrl, 350, 350);
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.IMAGE_PNG);
			return ResponseEntity.ok().headers(headers).body(qrCode);
		} catch (WriterException | IOException e) {
			return ResponseEntity.badRequest().build();
			//http://localhost:8080/generateQRCode?pa=91@ybl&pn=Someone&am=100&cu=INR&tn=Paymen20forservices
		}
	}
}
