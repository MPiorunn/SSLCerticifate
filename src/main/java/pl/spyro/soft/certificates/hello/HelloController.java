package pl.spyro.soft.certificates.hello;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    String path = "C:\\Users\\mpu\\IdeaProjects\\certificates\\src\\main\\resources\\certificates\\basic.crt";

    @GetMapping("/hello")
    public HelloDto hello() {

        try (InputStream inStream = new FileInputStream(path)) {
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            X509Certificate cert = (X509Certificate) cf.generateCertificate(inStream);
            System.out.println(Arrays.toString(cert.getSignature()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new HelloDto("Hello from HelloController");
    }
}

