#!/bin/bash
#
set -o errexit -o pipefail # Exit on error

mvn -e -DskipTests deploy
