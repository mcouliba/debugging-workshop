FROM registry.access.redhat.com/ubi8/ubi-minimal

# Set permissions on /home to allow arbitrary users to write
RUN chgrp -R 0 /home && chmod -R g=u /home

RUN microdnf install -y \
        java-11-openjdk-headless && \
        microdnf clean all

WORKDIR /home

COPY target/*.jar /ROOT.jar

CMD ["java", "-jar", "/ROOT.jar"]