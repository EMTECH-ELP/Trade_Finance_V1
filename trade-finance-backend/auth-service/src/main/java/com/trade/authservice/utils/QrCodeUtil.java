package com.trade.authservice.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
@Component
@Slf4j
public class QrCodeUtil {
    public ByteArrayResource generateQRCodeImage(String qrCodeContent) {
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(qrCodeContent, BarcodeFormat.QR_CODE, 200, 200);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);

            // Convert the byte array to a ByteArrayResource
            ByteArrayResource resource = new ByteArrayResource(outputStream.toByteArray());
            return resource;
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
            return null;
        }
    }


    public byte[] readByteArrayFromResource(Resource resource) throws IOException {
        byte [] byteArray = new byte[(int) resource.contentLength()];
        try{
            resource.getInputStream().read(byteArray);
        }catch (IOException e){
            log.info("caught io exception",e.getMessage());

        }
        return byteArray;
    }
}
