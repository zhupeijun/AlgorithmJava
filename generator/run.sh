#!/bin/sh

# exist when error
set -e

PROJ_ROOT=$MY_ALGO_ROOT

# check if PROJ_ROOT is settled
if [ "$PROJ_ROOT" == "" ]; then
  echo "Please speficy the MY_ALGO_ROOT at environment."
  exit 1
fi

# go to out folder and run
OUT_DIR=$PROJ_ROOT/out
cd $OUT_DIR

# run
java Main
