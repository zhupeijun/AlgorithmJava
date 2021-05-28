#!/bin/sh

# exist when error
set -e

PROJ_ROOT=$MY_ALGO_ROOT

# check if PROJ_ROOT is settled
if [ "$PROJ_ROOT" == "" ]; then
  echo "Please speficy the MY_ALGO_ROOT at environment."
  exit 1
fi

# generate source file
sh $PROJ_ROOT/generator/generate.sh

# go to out folder, comple and run
OUT_DIR=$PROJ_ROOT/out
cd $OUT_DIR

# clear .class file
[ -n "$(find . -maxdepth 1 -name '*.class' -print -quit)" ] && rm *.class

# compile
javac Main.java
echo "Compile succeed."

# run
# java Main
