# Docker Deploy Instructions:

1. Visit https://labs.play-with-docker.com/

1. `docker build https://github.com/mello-moose/twelve-factor.git -t twelve-factor:latest`

1. `curl https://raw.githubusercontent.com/mello-moose/twelve-factor/master/docker-compose.yml --output docker-compose.yml`

1. `curl https://raw.githubusercontent.com/mello-moose/twelve-factor/master/nginx.conf --output nginx.conf`

1. `docker-compose up --scale twelve-factor-app=5`
