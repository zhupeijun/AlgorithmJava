#!/bin/sh
PROJ_ROOT=$MY_ALGO_ROOT
SRC_FILE=$1

# check if PROJECT_ROOT setted from environment variable
if [ "$PROJ_ROOT" == "" ]; then
  echo "Please sepcify the MY_ALGO_ROOT root at environment."
  exit 1
fi

# if no file specified, the default is Main.java
if [[ "$SRC_FILE" == "" ]]; then
  SRC_FILE="Main.java"
fi

# check if source file exist
if [[ ! -e "$SRC_FILE" ]]; then
  echo "Source file not found."
  exit 1
fi

CUR_DIR=`pwd`
SRC_FILE="$CUR_DIR/$SRC_FILE"

cd $PROJ_ROOT
python3 generator/generate_source.py $SRC_FILE

