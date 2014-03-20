Red Hat IoT BOF/Hackfest
====================
Summary: A collection of projects that interfaces with the
[Sensinode Developer](https://silver.arm.com/browse/SEN00) NanoService 1.11 Developer
Release to expose the sensors of [mbed LPC1768](https://mbed.org/platforms/mbed-LPC1768/) +
[mbed Application Board](https://mbed.org/components/mbed-Application-Board/) combination
as POJOs in the JBoss Wildfly server.

Introduction
---------------------

This project includes EE7 component projects that illustrate connecting to the ARM
NSP server

* iotbof-ear : The EE7 EAR containing the project EJB, WAR
* iotbof-ejb : An EE7 singleton EJB that connects to the NSP
* iotbof-rest : A wrapper api that communicates with the NSP endpoints using REST
* iotbof-test : Tests for the project elements
* iotbof-web : A web application that receives push notifications of sensor information
as well as simple web pages for viewing the sensor data.

Wildfly Configuration
---------------------

    <subsystem xmlns="urn:jboss:domain:naming:2.0">
       <bindings>
          <simple name="java:global/NSPDomain" value="domain" type="java.lang.String"/>
          <simple name="java:global/NSPURL" value="http://red-hat-summit.cloudapp.net:8081/" type="java.net.URL"/>
          <simple name="java:global/NotificationCallbackURL" value="http://reponsehost:port/events/..." type="java.net.URL"/>
       </bindings>
    </subsystem>

