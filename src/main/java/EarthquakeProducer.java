import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class EarthquakeProducer {
	String bootstrapServers = "localhost:9092";
	final String topic ="earthquakes";
	
	Properties properties = new Properties() {{
		put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		put(ProducerConfig.ACKS_CONFIG, "1");
	}};
	
	Producer<String, String> producer = new KafkaProducer<>(properties);
	
	public void send(String key, String value) {
		ProducerRecord<String, String> record = new ProducerRecord<>(topic, key, value);
		 try {
		       RecordMetadata metadata = producer.send(record).get();
		       System.out.println("Delivered: partition " + metadata.partition() + ", offset " + metadata.offset());
		 } catch (Exception e) {
		       System.out.println("FAILED to send " + key + ": " + e);
		 }
	}
	
	public void close() {
	    producer.close();
	}
}
