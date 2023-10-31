## 1. Generate keystore

```bash
keytool -genkeypair -alias basic -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore basic.p12 -validity 3650
```

## 2. Generate certificate 

```bash
keytool -importkeystore -srckeystore basic.jks -destkeystore basic.p12 -deststoretype pkcs12
```
