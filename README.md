# Earthquake Ingestion Service

A Java-based data ingestion service that retrieves real-time earthquake data from the **U.S. Geological Survey (USGS)** and publishes earthquake events to **Apache Kafka**.

This project is the ingestion component of a real-time streaming pipeline:

```text
USGS Earthquake API
        ↓
Java Ingestion Service
        ↓
Apache Kafka
        ↓
Kafka Streams
        ↓
Redis
```

## Project Goals

The goal of this project is to build a practical real-time data engineering pipeline while learning:

* Java
* Apache Kafka
* Kafka Producer API
* Kafka Streams
* Redis
* Docker
* Event-driven architecture
* Real-time data processing

## Architecture

The `earthquake-ingestion` service is responsible for:

1. Polling the USGS earthquake feed
2. Parsing the returned GeoJSON data
3. Extracting relevant earthquake information
4. Transforming the data into a structured event
5. Publishing earthquake events to a Kafka topic

The downstream Kafka Streams application will be responsible for processing and aggregating these events.

## Data Source

Earthquake data is provided by the **U.S. Geological Survey (USGS) Earthquake Hazards Program**.

USGS Earthquake Feeds:

https://earthquake.usgs.gov/earthquakes/feed/

USGS Earthquake Catalog API:

https://earthquake.usgs.gov/fdsnws/event/1/
