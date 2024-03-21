#!/bin/bash

echo "start build..."

cd order-service
mvn clean install -DskipTests -T 4

docker compose up