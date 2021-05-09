#/bin/sh

# if error skip out
set -eu

# setup common variables
PROJ_ROOT=${MY_ALGO_ROOT}
CUR_DIR=`pwd`
TEMP_PATH="$PROJ_ROOT/generator/Main.java"

# check current path under src folder
if [[ ! "$CUR_DIR" =~ "src" ]]; then
  echo "[ERROR] Not in src folder."
  exit 1
fi

# construct package name
PKG_NAME=`echo $CUR_DIR | sed -e "s/.*\/src\///g" | sed -e "s/\//./g"`

# check if file exist
if [[ -e "Main.java" ]]; then
  echo "[ERROR] File already exist."
  exit 1
fi

# copy template to current directory
cp $TEMP_PATH ./

# replace package name
sed -i -e "s|\\\$PACKAGE_NAME\\\$|$PKG_NAME|g" Main.java

echo "Created."

