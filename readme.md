# Prerequisites: 

### This project uses Apache Kafka with ZooKeeper.

## Note:

Newer versions of Kafka (≥ 2.8) support KRaft mode and do not require ZooKeeper.
This setup uses ZooKeeper, so Kafka is configured in the traditional mode.
Required Services

## Ensure the following services are running:

1. ZooKeeper → Port 2181
2. Kafka → Port 9092
3. Running Kafka and ZooKeeper using Docker (Optional) (You can run them as standalone services if you prefer, but Docker provides an easy way to set them up without manual installation.)

## You can run both ZooKeeper and Kafka using Docker.

1. Start ZooKeeper
```
   docker run -d \
   --name zookeeper \
   -p 2181:2181 \
   confluentinc/cp-zookeeper:7.5.0 \
   bash -c "echo 'clientPort=2181' > /etc/kafka/zookeeper.properties && zookeeper-server-start /etc/kafka/zookeeper.properties"
```
2. Start Kafka
```
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
## Notes
   1. Make sure ZooKeeper is running before starting Kafka.
   2. The --link zookeeper option allows Kafka to communicate with ZooKeeper.
   3. If you are using newer Kafka versions, consider switching to KRaft mode to remove ZooKeeper dependency.