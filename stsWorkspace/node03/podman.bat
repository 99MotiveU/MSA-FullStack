podman network create -d bridge net01
podman run -it -d --network net01 -p 27017:27017 --name mongodb mongo