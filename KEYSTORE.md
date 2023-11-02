## 1. Generate keystore

```bash
keytool -genkeypair -alias basic -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore basic.p12 -validity 3650
```

## 2. Generate certificate 

```bash
keytool -importkeystore -srckeystore basic.jks -destkeystore basic.p12 -deststoretype pkcs12
```
openssl pkcs12 -in basic2.p12 -out basic.crt.pem -clcerts -nokeys
openssl pkcs12 -in basic2.p12 -out basic.key.pem -nocerts -nodes
