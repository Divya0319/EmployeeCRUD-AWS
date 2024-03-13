FROM openjdk:17
ADD target/employeecrud-aws-eks.jar employeecrud-aws-eks.jar
EXPOSE 8000
ENTRYPOINT [ "java","-jar","employeecrud-aws-eks.jar" ]