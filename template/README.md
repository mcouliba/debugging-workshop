== to run it 
oc process -f coolstore-app-with-params.yaml -p COOLSTORE_PROJECT=staging-project1 -p APPS_HOSTNAME_SUFFIX=apps.cluster-montpell-6d86.montpell-6d86.sandbox52.opentlc.com -p IMAGE_CATALOG=quay.io/dwojciec/catalog-coolstore:v1 -p IMAGE_GATEWAY=quay.io/dwojciec/gateway-coolstore:v1 -p IMAGE_INVENTORY=quay.io/dwojciec/inventory-coolstore:v1 -p IMAGE_WEB=quay.io/dwojciec/web-coolstore:v1 | oc create  -f -

