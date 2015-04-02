http://sanjeev-technology.blogspot.in/2015/03/maf-take-picture-and-upload.html

To run application
1. Open application Code\Service_11.1.1.7.1\RESTServices\RESTServices.jws in 11.1.1.7.1 and deploy on a weblogic server
2. Configure you weblogic server with jersey libraries (http://sanjeev-technology.blogspot.in/2014/09/rest-service-on-weblogic-1034.html)
3. Deploy ViewController project war file on weblogic server. 
4. Check if service is working fine using REST client(http://<server>:<port>/<context>/rest/employees/postImage)
5. Open MAF application Code\MAF_12.1.3\MobileAppForBlog210\MobileAppForBlog210.jws in 12.1.3 
6. Change REST-Konnect connection accordingly
7. Generate apk file 
8. Move you apk to mobile and test

(NOTE: You musth have connectivity to REST server from mobile. You may need to use Cisco VPN client on your mobile for that. Otherwise try with emulator.)
    