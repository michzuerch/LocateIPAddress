FROM gitpod/workspace-mongodb

USER gitpod
RUN mkdir -p /workspace/data && mongod --dbpath /workspace/data
RUN mongod
# Give back control
USER root

