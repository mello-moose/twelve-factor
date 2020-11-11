# Docker Deploy Instructions:

1. Visit https://labs.play-with-docker.com/

1. `docker build https://github.com/mello-moose/twelve-factor.git#feature/backing_service -t twelve-factor:latest`

1. `curl https://raw.githubusercontent.com/mello-moose/twelve-factor/feature/backing_service/docker-compose.yml --output docker-compose.yml`

1. `curl https://raw.githubusercontent.com/mello-moose/twelve-factor/feature/backing_service/nginx.conf --output nginx.conf`

1. `docker-compose up --scale twelve-factor-app=5`
