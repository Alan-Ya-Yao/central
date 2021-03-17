alias ll="ls -al"
alias kafka_start="sh zookeeper-server-start /usr/local/etc/kafka/zookeeper.properties &sh kafka-server-start /usr/local/etc/kafka/server.properties &"
alias kafka_stop="sh zookeeper-server-stop /usr/local/etc/kafka/zookeeper.properties &sh kafka-server-stop /usr/local/etc/kafka/server.properties &"
alias kafka_topics="sh /usr/local/Cellar/kafka/2.7.0/bin/kafka-topics --list --zookeeper localhost:2181"
alias kafka_topic_describe="sh kafka-topics /usr/local/Cellar/kafka/2.7.0/bin  --zookeeper localhost:2181 --describe --topic"
alias kafka_consumers="sh kafka-consumer-groups /usr/local/Cellar/kafka/2.7.0/bin/ --bootstrap-server localhost:9092 --list"
alias kafka_consumer_describe="sh kafka-consumer-groups /usr/local/Cellar/kafka/2.7.0/bin --bootstrap-server localhost:9092 --describe --group"


export PATH=/usr/local/bin:$PATH

export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_271.jdk/Contents/Home
export PATH=$JAVA_HOME/bin:$PATH:.
