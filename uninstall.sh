#!/bin/bash

docker compose down

# Stop and remove all containers
docker stop $(docker ps -a -q)
docker rm $(docker ps -a -q)

# Remove all images
docker rmi jakarta-ee-application-product-service
docker rmi jakarta-ee-application-order-service
docker rmi jakarta-ee-application-nginx
docker rmi jakarta-ee-application-db
docker rmi jakarta-ee-application-messaging

