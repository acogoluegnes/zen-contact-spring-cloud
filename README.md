# ZenContact with Spring Cloud and Netflix OSS

Simple web app implements as microservices with Spring Cloud and Netflix OSS.
Used at the Distributed Matters conference in Berlin, September 2015.

## How to use

* import in your IDE as Maven projects
* start the EurekaServer class (http://localhost:8761, http://localhost:8761/eureka/apps)
* start the BackendServiceApplication class. You can launch the class twice, but be careful to switch the profiles (instance1 and instance2) to listen on different ports (http://localhost:9000/contacts and http://localhost:9001/contacts)
* start the FrontApplication class (http://localhost:8080/home)

Enjoy!

