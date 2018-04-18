#!/bin/bash

if [[ $TRAVIS_PULL_REQUEST == "false" ]]; then
    mvn clean deploy --settings $GPG_DIR/settings.xml -Dci=true
    exit $?
fi
