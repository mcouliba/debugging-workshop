FROM registry.access.redhat.com/ubi8/ubi-minimal

RUN microdnf install -y \
        java-11-openjdk-headless && \
        microdnf clean all

COPY target/*.jar /ROOT.jar

CMD ["java", "-jar", "/ROOT.jar"]