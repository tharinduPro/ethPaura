
// Include required libraries
#include <Adafruit_CC3000.h>
#include <ccspi.h>
#include <SPI.h>
#include <string.h>
#include "utility/debug.h"

#include<stdlib.h>

// Define CC3000 chip pins
#define ADAFRUIT_CC3000_IRQ   3
#define ADAFRUIT_CC3000_VBAT  5
#define ADAFRUIT_CC3000_CS    10

// Buffer for float to String conversion
// The conversion goes from a float value to a String with two numbers after the decimal.  That means a buffer of size 10 can accommodate a float value up to 999999.99 in order for the last entry to be \0
char buffer[10];

// WiFi network (change with your settings !)
#define WLAN_SSID       "local"
#define WLAN_PASS       "rilekez5"
#define WLAN_SECURITY   WLAN_SEC_WPA2 // This can be WLAN_SEC_UNSEC, WLAN_SEC_WEP, WLAN_SEC_WPA or WLAN_SEC_WPA2

const unsigned long
dhcpTimeout     = 60L * 1000L, // Max time to wait for address from DHCP
connectTimeout  = 15L * 1000L, // Max time to wait for server connection
responseTimeout = 15L * 1000L; // Max time to wait for data from server

uint32_t   t;
Adafruit_CC3000 cc3000 = Adafruit_CC3000(ADAFRUIT_CC3000_CS, ADAFRUIT_CC3000_IRQ, ADAFRUIT_CC3000_VBAT,
SPI_CLOCK_DIV2);

// PHP's server IP, port, and repository (change with your settings !)
uint32_t ip = cc3000.IP2U32(192,168,211,1);
int port = 8888;
//MAKE SURE TO SET THIS TO THE FOLDER YOU ARE USING IN htdocs FOR THE SERVER SIDE FILES
String repository = "/wifi/";

Adafruit_CC3000_Client client;

void setup(void)
{


  Serial.begin(56700);

//digitalWrite(13, HIGH);

  Serial.print(F("Initializing..."));
  if(!cc3000.begin()) {
    Serial.println(F("failed. Check your wiring?"));
    return;
  }

  Serial.print(F("OK.\r\nConnecting to network..."));
  cc3000.connectToAP(WLAN_SSID, WLAN_PASS, WLAN_SECURITY);
  Serial.println(F("connected!"));

  Serial.print(F("Requesting address from DHCP server..."));
  for(t=millis(); !cc3000.checkDHCP() && ((millis() - t) < dhcpTimeout); delay(500)) {
    Serial.println("....waiting");
  }
  if(cc3000.checkDHCP()) {
    Serial.println(F("OK"));
  } 
  else {
    Serial.println(F("failed"));
    return;
  }
  //ADDED RANDOM NUMBER TO USE IN PLACE OF SENSOR READING
  randomSeed(analogRead(0));

}



void loop(void)
{
 if((analogRead(0) < 500)&&(analogRead(1) < 500)&&(analogRead(2) > 500)&&(analogRead(3) > 500)){
            Serial.println("entering....");
            delay(500);
  if((analogRead(3) < 500)&&(analogRead(0) < 500)&&(analogRead(1) < 500)){
          Serial.println("Elephant Entered....");
          pinMode(13, OUTPUT);
          digitalWrite(13, LOW);
          pinMode(12, OUTPUT);
          digitalWrite(12, LOW);
          delay(3000);
 

  //Open Socket
  Serial.println("...Connecting to server");
  t = millis();
  do {
    client = cc3000.connectTCP(ip, port);
  } 
  while((!client.connected()) &&
    ((millis() - t) < connectTimeout));
  // Send request
  if (client.connected()) {
    Serial.println("Connected"); 
    String request = "GET "+ repository + "test.php?dir=west&village=mihintale";
    Serial.print("...Sending request:");
    Serial.println(request);
    send_request(request);
  } 
  else {
    Serial.println(F("Connection failed"));    
    return;
  }
  Serial.println("...Reading response");
  show_response();

  Serial.println(F("Cleaning up..."));
  Serial.println(F("...closing socket"));
  client.close();
  //wait some amount of time before sending temperature/humidity to the PHP service.
  delay(10000);
}
 }
 


else{

  Serial.println(F("...no elephant...."));
  pinMode(13, OUTPUT);
  digitalWrite(13, HIGH);
  pinMode(12, OUTPUT);
  digitalWrite(12, HIGH);

}

}
/*******************************************************************************
 * send_request
 ********************************************************************************/
bool send_request (String request) {
  // Transform to char
  char requestBuf[request.length()+1];
  request.toCharArray(requestBuf,request.length()); 
  // Send request
  if (client.connected()) {
    client.fastrprintln(requestBuf); 
  } 
  else {
    Serial.println(F("Connection failed"));    
    return false;
  }
  return true;
  free(requestBuf);
}
/*******************************************************************************
 * show_response
 ********************************************************************************/
void show_response() {
  Serial.println(F("-------------------------------------"));
  while (client.available()) {
    // Read answer and print to serial debug
    char c = client.read();
    Serial.print(c);
  }
}
/*******************************************************************************
 * floatToString()
 ********************************************************************************/
// Float to String conversion
String floatToString(float number) {
  //  dtostrf(floatVar, minStringWidthIncDecimalPoint, numVarsAfterDecimal, charBuf);
  dtostrf(number,5,2,buffer);
  return String(buffer);

}
/*******************************************************************************
 * timedRead()
 ********************************************************************************/
// comment from Adafruit's GeoLocation sketch:
// Read from client stream with a 5 second timeout.  Although an
// essentially identical method already exists in the Stream() class,
// it's declared private there...so this is a local copy.
char timedRead(void) {
  unsigned long start = millis();
  while((!client.available()) && ((millis() - start) < responseTimeout));
  return client.read();  // -1 on timeout
}

