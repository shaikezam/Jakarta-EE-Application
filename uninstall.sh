#!/bin/bash

docker compose down

# Stop and remove all containers
docker stop $(docker ps -a -q)
docker rm $(docker ps -a -q)

# Remove all images
docker rmi $(docker images -a -q)

# Remove all layers
docker system prune --all --force --volumes
