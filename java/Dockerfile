# Use Ubuntu 18.04 as the base image
# Use latest image if your system (Docker) supports it 
# https://hub.docker.com/layers/library/ubuntu/25.04/images/sha256-82386eb29995fda7c3d7b24835a4d3cf134cdbe39f46464ca2b11684e87a02c7?context=explore
FROM ubuntu:18.04

# Prevent interactive prompts during installation
ENV DEBIAN_FRONTEND=noninteractive

# Install necessary dependencies, including Java 11, Maven, and tools for browsers
RUN apt-get update && apt-get install -y \
    wget \
    curl \
    gnupg2 \
    libgbm-dev \
    libatk-bridge2.0-0 \
    libnspr4 \
    libnss3 \
    libxss1 \
    libappindicator3-1 \
    libgdk-pixbuf2.0-0 \
    libasound2 \
    fonts-liberation \
    libx11-xcb1 \
    xdg-utils \
    libu2f-udev \
    libdrm2 \
    xvfb \
    unzip \
    dbus-x11 \
    tar \
    ca-certificates \
    openjdk-11-jdk \
    && rm -rf /var/lib/apt/lists/*

# Set the JAVA_HOME environment variable for OpenJDK 11
ENV JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64

# Ensure JAVA_HOME is added to the PATH
ENV PATH="${JAVA_HOME}/bin:${PATH}"

# Verify that Java 11 is installed
RUN java -version

# Install Maven 3.6.3
RUN wget https://archive.apache.org/dist/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.tar.gz -P /tmp \
    && tar -xvzf /tmp/apache-maven-3.6.3-bin.tar.gz -C /opt \
    && ln -s /opt/apache-maven-3.6.3/bin/mvn /usr/bin/mvn

# Add Maven to PATH
ENV PATH="/opt/apache-maven-3.6.3/bin:${PATH}"

# Generate machine ID and start DBus
RUN dbus-uuidgen > /etc/machine-id

# Set up Xvfb for running the browser
ENV DISPLAY=:99
RUN Xvfb -ac :99 -screen 0 640x512x16 &

# Copy all current code to the /app directory
COPY . /app

# Set working directory to /app for convenience
WORKDIR /app
