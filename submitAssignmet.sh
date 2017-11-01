#!/bin/bash
cd ~/workspace/assignment-submission
./gradlew $1 \
    -PmovieFunUrl=https://moviefun-uranitic-hexad.apps.longs.pal.pivotal.io
