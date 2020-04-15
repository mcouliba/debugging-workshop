# Pragmatic Approach to Debug Microservices Applications on Openshift
## Red Hat Summit 2020 - April 28th and 29th

## Purpose
Distributed microservices introduce new challenges like failure modes that are harder to anticipate and resolve. Deploying and managing microservices architecture is becoming easier with a container orchestration platform like Red Hat OpenShift, raising critical questions: 
How do you debug a distributed system? 
How do you ensure the good health of your application? 
How do you increase your microservices’ “immunity” to issues?


## Background
This hands-on workshop will introduce and help you to get familiar with the common 
tracing/debugging techniques using Jaeger/OpenTracing, Istio, Kiali and Istio-workspaces in 
a microservice context

# Agenda
* Deployment of "Mysterious Apps" apps using argoCD tool.
* Kiali to visualize the service mesh topology, to provide visibility into features like circuit breakers, request rates and more. It offers insights about the mesh components at different levels, from abstract Applications to Services and Workloads.
* Opentracing - Jaeger is a distributed tracing system released as open source by Uber Technologies. It is used for monitoring and troubleshooting microservices-based distributed systems
* Realtime Debugging with Istio-workspaces
