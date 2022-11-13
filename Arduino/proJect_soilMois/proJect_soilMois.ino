#include "DHT.h"
#define DHTPIN 4 // what pin we're connected to
#define DHTTYPE DHT11 // DHT 11 
DHT dht(DHTPIN, DHTTYPE);

int digitalPin2 = 2;
int digitalPin3 = 3;
int analogPin = 5;
int soilMosi = 0;

void setup() {
  pinMode(digitalPin2, OUTPUT);  
  pinMode(digitalPin3, OUTPUT);
  Serial.begin(9600);  //ความเร็วในการติดต่อสื่อสาร
  dht.begin();
}

void loop() {
  soilMosi = analogRead(analogPin);
  soilMosi = map(soilMosi, 0, 1023, 100, 0);
  float humidity = dht.readHumidity();
  float temperature = dht.readTemperature();

   Serial.print(humidity);
   Serial.print(",");
   Serial.print(temperature);
   Serial.print(",");
   Serial.println(soilMosi);

  if (soilMosi < 40) {
    digitalWrite(digitalPin2, HIGH);
    digitalWrite(digitalPin3, HIGH);
  }else {
    digitalWrite(digitalPin2, LOW); 
    digitalWrite(digitalPin3, LOW); 
  }
  delay(1000);
}
