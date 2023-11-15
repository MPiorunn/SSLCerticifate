## 1. Generate self-signed certificate

```bash
keytool -genkeypair -alias basic -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore basic.p12 -validity 3650
```

