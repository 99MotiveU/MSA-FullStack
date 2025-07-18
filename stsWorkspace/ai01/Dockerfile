FROM docker.elastic.co/elasticsearch/elasticsearch:8.13.3

ENV discovery.type=single-node
ENV xpack.security.enabled=false
EXPOSE 9200
RUN bin/elasticsearch-plugin install analysis-nori
