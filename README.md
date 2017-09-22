cli java application to validate/verify VAT numbers.
See https://en.wikipedia.org/wiki/VAT_identification_number for what a VAT number is.

Validating is aginst a SOAP based webservice provided by the European Comission, see http://ec.europa.eu/taxation_customs/vies/

WDSL is at: http://ec.europa.eu/taxation_customs/vies/checkVatService.wsdl 

<strong>To Build This App <br /></strong>
  1- Install Java 1.7 or later <br />
  2- Install Maven Build tool version 3.0 or later <br />
  3- After pull/clone projct move to root dirctory - that contains pom.xml - <br />
  4- cmd/shell execute command "mvn clean install" <br /><br />
<strong>To Run This App <br /></strong>
  cmd/shell execute command "java -jar target/App.jar XXXXXXXXXXX" <br /><br />
  
Note: Replace XXXXXXX with VAT CODE <br />
Note: if you want to move executable from target directory move "App.jar and lib directory" <br />
