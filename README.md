# Real-Time Indoor Line Tracking
Georgia Institute of Technology

School of Electrical and Computer Engineering

ECE4012 Spring2020 CapstoneProject

  While public buildings provide documented busy hours of operation for customers to determine 
the best times to come, it is difficult to know the expected wait-time at any given moment. Real- 
time Indoor Line Tracking will utilize Time-of-Flight sensors to indicate the length of lines at 
popular restaurants and gather this information in an Android application for users to see the 
current calculated wait-times. The entire system consists of a sensor network and a mobile 
application; the centrally powered sensor network will send data to an online database via WiFi. 
The mobile application will then retrieve the data, calculate the expected wait times, and display 
a visual representation of the line so that users can decide when to come to the restaurant or 
where better to eat. 
  The system setup consists of Time-of-Flight sensors which will each be connected with wires to 
the microcontroller along with the ESP8266 WiFi chip to provide WiFi connectivity. The system 
will be powered by a rechargeable power source. The sensor-wire setup will be covered with a 
protective casing and will be attached to the top of the retractable belt-barrier poles which forms 
the lines. When only the first sensor is on and is triggered for two seconds, it will communicate 
to the next sensor in line and start collecting data, and so on forth. The microcontroller will 
organize the sensor data and send the information to the Firebase database, where the phone app 
will collect the data and use it to provide a visual of the line length and calculate estimated wait-time.

## Motivation
  Most systems that track building occupancy in real-time, such as Google’s implementation, rely on tracking users’ locations at all times. 
This is generally seen as an invasion of privacy and is also only reliable if every user agrees to share their location with the system. 
By using sensors to keep track of the number of people in the measured location, real-time tracking can be done without relying on the user 
and also without raising privacy concerns. Although the scope of the tracking is reduced to confined spaces, the system can still efficiently 
cover areas where overcrowding is an issue, and the need for knowing immediate availability is high. By implementing this system, the team 
hopes to drastically reduce overcrowding in popular locations by providing users a convenient way of instantly knowing estimated wait times 
and line lengths.

##

## Authors
- Dimitrios Kosmakos, Electrical Engineering
- Won Jun Lee, Computer Engineering
- Aksaya Manickandan, Computer Engineering
- Ulrica Wang, Computer Engineering

