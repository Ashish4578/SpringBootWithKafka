### Prerequisite before running the code
1. Zookeeper should be running on port 2181
2. Kafka should be running on port 9092

## I used here Docker to run both Zookeeper and Kafka, you can use the following commands to run them:
1. To install Zoopkeeper and Kafka using Docker, you can use the following commands:

```bash
# Run Zookeeper
docker run -d \                                        
--name kafka \
-p 9092:9092 \
-e KAFKA_BROKER_ID=1 \
-e KAFKA_ZOOKEEPER_CONNECT=zookeeper:2181 \
-e KAFKA_ADVERTISIED_LISTENERS=PLAINTEXT://localhost:9092 \
-e KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR=1 \
--link zookeeper \
confluentinc/cp-kafka:7.5.0

# Run Kafka
docker run -d \                                        
--name kafka \
-p 9092:9092 \
-e KAFKA_BROKER_ID=1 \
-e KAFKA_ZOOKEEPER_CONNECT=zookeeper:2181 \
-e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://localhost:9092 \
-e KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR=1 \
--link zookeeper \
confluentinc/cp-kafka:7.5.0

```
