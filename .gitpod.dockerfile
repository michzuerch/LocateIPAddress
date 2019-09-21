FROM gitpod/workspace-mongodb

RUN mkdir -p /workspace/data && mongod --dbpath /workspace/data
