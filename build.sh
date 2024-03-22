#!/bin/bash

echo "start build..."

mvn clean install -DskipTests -T 4

docker compose up
