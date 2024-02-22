#!/bin/bash

echo "start build..."

cd my-app
mvn clean install -DskipTests -T 4

docker compose up