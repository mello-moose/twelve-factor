Docker Deploy Instructions

docker build https://github.com/mello-moose/twelve-factor.git -t twelve-factor:latest

docker run --publish 8000:8080 -t twelve-factor:latest
