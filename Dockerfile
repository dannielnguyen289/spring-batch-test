FROM openjdk:17

ADD ./build/libs/sample-0.0.1-SNAPSHOT-plain.jar sample.jar

ENTRYPOINT ["java","-jar","sample.jar"]