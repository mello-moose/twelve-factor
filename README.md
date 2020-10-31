# Docker Deploy Instructions:

1. Visit https://labs.play-with-docker.com/

1. `docker build https://github.com/mello-moose/twelve-factor.git -t twelve-factor:latest`

1. `docker run --publish 8000:8080 -t twelve-factor:latest`

1. Access public api through provided endpoint

## Docker Compose:

1. `docker build https://github.com/mello-moose/twelve-factor.git#feature/backing_service -t twelve-factor:latest`

1. `curl https://raw.githubusercontent.com/mello-moose/twelve-factor/feature/backing_service/docker-compose.yml --output docker-compose.yml`

1. `docker-compose up -d`
