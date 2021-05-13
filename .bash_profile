alias ll="ls -al"
alias kafka_start="sh zookeeper-server-start /usr/local/etc/kafka/zookeeper.properties &sh kafka-server-start /usr/local/etc/kafka/server.properties &"
alias kafka_stop="sh zookeeper-server-stop /usr/local/etc/kafka/zookeeper.properties &sh kafka-server-stop /usr/local/etc/kafka/server.properties &"
alias kafka_topics="sh /usr/local/Cellar/kafka/2.7.0/bin/kafka-topics --list --zookeeper localhost:2181"
alias kafka_topic_describe="sh kafka-topics /usr/local/Cellar/kafka/2.7.0/bin  --zookeeper localhost:2181 --describe --topic"
alias kafka_consumers="sh kafka-consumer-groups /usr/local/Cellar/kafka/2.7.0/bin/ --bootstrap-server localhost:9092 --list"
alias kafka_consumer_describe="sh kafka-consumer-groups /usr/local/Cellar/kafka/2.7.0/bin --bootstrap-server localhost:9092 --describe --group"

alias es_kibana_start="brew services start elasticsearch & brew services start kibana"
alias es_kibana_stop="brew services stop elasticsearch & brew services stop kibana" 
alias es_head_start="cd /Users/pengyi/Documents/elasticsearch-head & npm run start"
alias es_head_stop="cd /Users/pengyi/Documents/elasticsearch-head & npm run stop"

export PATH=/usr/local/bin:$PATH

export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_271.jdk/Contents/Home
export PATH=$JAVA_HOME/bin:$PATH:.

##hive
export HIVE_HOME=/usr/local/Cellar/hive/3.1.2_3
