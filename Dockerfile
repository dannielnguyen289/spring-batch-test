FROM openjdk:17

ADD ./build/libs/sso-services-1.5.1.jar sso_internal_api.jar

ENTRYPOINT ["java","-jar","sso_internal_api.jar"]