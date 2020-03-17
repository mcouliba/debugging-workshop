FROM registry.access.redhat.com/ubi8/nodejs-10

COPY --chown=default:root . /opt/app-root/src

RUN chgrp -R 0 /opt/app-root/src && chmod -R g=u /opt/app-root/src

WORKDIR /opt/app-root/src

RUN npm install

EXPOSE 8080
CMD ["npm", "start"]