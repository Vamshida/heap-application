# Heap Application

## Problem Statement

This application implements MinHeap and MaxHeap data structures and exposes them as Spring Reactive Web Flux REST endpoints. You can use this application to insert and delete values from the heaps and retrieve their current state.

## Setup Instructions

### Prerequisites

- Java JDK 8 or higher
- Maven (for building and running the application)

### OS Compatibility

This application should work on various operating systems, including Windows, macOS, and Linux.

### Installation Steps

1. **Java Development Kit (JDK):** If you don't have Java installed, you can download and install it from the official 
   Oracle website (https://www.oracle.com/java/technologies/javase-downloads.html) or use an OpenJDK distribution.

2. **Maven:** If you don't have Maven installed, you can download it from the official Apache Maven website 
   (https://maven.apache.org/download.cgi) and follow the installation instructions.

3. **Clone the Repository:** Clone this repository to your local machine using Git:
   
   git clone https://github.com/your-username/heap-application.git
   
### Build the Application:
Navigate to the project directory and build the application using Maven:

-cd heap-application
-mvn clean package

### Run the Application: 
After a successful build, you can run the application using the following command:

-java -jar target/heap-application.jar

### How to Use the Application

The application exposes two sets of REST endpoints: one for the MinHeap and another for the MaxHeap.

### MinHeap Endpoints
Insert a Value into MinHeap:

Endpoint: POST /minheap/insert?value=<value>

Example: http://localhost:8081/minheap/insert?value=42

Delete a Value from MinHeap:

Endpoint: DELETE /minheap/delete/<value>

Example: http://localhost:8081/minheap/delete/42

Delete a MinValue from MinHeap:

Endpoint: DELETE /minheap/deletemin

Example: http://localhost:8081/minheap/deletemin

Retrieve the Current State of MinHeap:

Endpoint: GET /minheap/getHeap

Example: http://localhost:8081/minheap/getHeap


### MaxHeap Endpoints
Insert a Value into MaxHeap:

Endpoint: POST /maxheap/insert?value=<value>

Example: http://localhost:8081/maxheap/insert?value=42

Delete a Value from MaxHeap:

Endpoint: DELETE /maxheap/delete/<value>

Example: http://localhost:8081/maxheap/delete/42

Delete a Value from MaxHeap:

Endpoint: DELETE /maxheap/deletemax

Example: http://localhost:8081/maxheap/deletemax

Retrieve the Current State of MaxHeap:

Endpoint: GET /maxheap/getHeap
Example: http://localhost:8081/maxheap/getHeap


