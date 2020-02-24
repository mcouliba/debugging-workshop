# Quarkus Cart Service

## Prerequisites

1. Maven 3.5x +
2. GraalVM
3. Docker
4. Catalog Service up and running

## How to build

~~~bash
$ cd cart-quarkus
$ mvn package -Pnative -Dnative-image.docker-build=true
~~~

## How to deploy on Openshift

~~~bash
# To build the image on OpenShift
$ oc new-build --binary --name=cart -l app=cart
$ oc patch bc/cart -p '{"spec":{"strategy":{"dockerStrategy":{"dockerfilePath":"src/main/docker/Dockerfile"}}}}'
$ oc start-build cart --from-dir=. --follow

# To instantiate the image
$ oc new-app --image-stream=cart:latest

# To configure Catalog Service Endpoint
$ oc set env dc/cart CATALOG_ENDPOINT=http://catalog:8080

# To create the route
$ oc expose svc cart
~~~