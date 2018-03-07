FROM openjdk:8-jre

# Timezone
RUN ln -sf /usr/share/zoneinfo/Europe/Zurich /etc/localtime
RUN echo "Europe/Zurich" > /etc/timezone

# WildFly Swarm
ADD target/scale-app-swarm.jar /opt/scale-app-swarm.jar

EXPOSE 8580

CMD ["sh", "-c", "java -jar /opt/scale-app-swarm.jar"]

