FROM gitpod/workspace-mongodb

USER gitpod
RUN bash -c ". /home/gitpod/.sdkman/bin/sdkman-init.sh && sdk default java 12.0.2-open"
RUN mkdir -p /workspace/data
RUN mongod --dbpath /workspace/data
RUN mongod
# Give back control
USER root

