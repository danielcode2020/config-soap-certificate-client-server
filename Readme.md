
# Getting started

1 clone repo on local
2 open it 
3 some imports are in red, to solve them click on maven profiles, choose
generate and run maven clean and package

4 generate keys from intellij terminal or linux terminal

server

keytool -genkeypair -alias server-app -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore server-app.p12 -validity 3650

pass : server-parola

client

keytool -genkeypair -alias client-app -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore client-app.p12 -validity 3650

pass :  client-parola

5 move files client-app.p12 and server-app.p12 to folder resources/keystore

6 cd into folder keystore

7 extract certificates

keytool -export -file client.cert -keystore client-app.p12 -storepass client-parola -alias client-app

keytool -export -file server.cert -keystore server-app.p12 -storepass server-parola -alias server-app

8 import

keytool -import -file client.cert -alias client -keystore server-app.p12

pass : server-parola

Trust this ... : y

keytool -import -file server.cert -alias server -keystore client-app.p12

pass : client-parola

Trust this ... : y


9 check entries (must have trustedCertEntry)

keytool -list -keystore client-app.p12

keytool -list -keystore server-app.p12

10 run server profile

11

