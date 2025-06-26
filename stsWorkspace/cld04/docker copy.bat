podman run -d ^
--net=net01 ^
--name=zookeeper ^
-e ZOOKEEPER_CLIENT_PORT=32181 ^
-e ZOOKEEPER_TICK_TIME=2000 ^
-e ZOOKEEPER_SYNC_LIMIT=2 ^
confluentinc/cp-zookeeper:6.1.15

podman run -d ^
    --net=net01 ^
    --name=kafka ^
    -p 29092:29092 ^
    -e KAFKA_ZOOKEEPER_CONNECT=zookeeper:32181 ^
    -e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://localhost:29092 ^
    -e KAFKA_BROKER_ID=2 ^
    -e KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR=1 ^
    confluentinc/cp-kafka:6.1.15