## Initial Setup

### Prerequisites

Ensure that Java Development Kit (JDK) and Maven 
are installed on your system. If they are not installed, 
you will need to download and install them. 

## Running the Tests
### Install dependencies
Before running the tests, we need to install all 
necessary dependencies. Maven, a software 
project management tool, can do this for us. 
Run the following command:

```bash
mvn clean install
```

### Run all tests
To verify if everything is installed correctly and 
functioning properly, we should run all 
available tests. This can be done with the following command:

```bash
mvn test
```

Please be patient! If this is your first time running these tests, 
it might take a while to download and verify all necessary browser drivers.

## Execute a specific example
To run a specific Selenium Java example, use the following command:

Example:
```bash
mvn test -Dtest="FileUploadTest"
mvn test -Dtest="InteractionTest"
mvn test -Dtest="LocatorsTest"
```

### Dockerize the test suite

## Docker build
First build the image

```
docker build -t image-name .
```

Make sure to replace `image-name` with the name you want to give the image.

## Docker run

Now run the image

```
docker run --rm -it  --memory=6g --shm-size=2g --dns=8.8.8.8 image-name bash
```

Make sure to replace `image-name` with the name of the image you want to run. 

Now run the tests of your choice!