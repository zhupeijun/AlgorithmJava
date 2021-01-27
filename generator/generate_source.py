import sys
import os
import re

PROJECT_ROOT=os.getcwd()
OUR_DIR=PROJECT_ROOT+"/out";
OUT_FILE=OUR_DIR+"/Main.java"
LIB_DIR=PROJECT_ROOT+"/src/library"
LIB_BASIC_DIR=LIB_DIR+"/basic"
LIB_ALGORITHM_DIR=LIB_DIR+"/algorithm"

source_code_path = sys.argv[1]

def read_source(path):
    with open(path, 'r') as f:
        code = f.read()
        return code

def read_lib(path):
    with open(path, "r") as f:
        code = f.read()
        # remove package name
        code = re.sub(r'package [\w\.]+;\n\n', "", code)
        # remove import
        code = re.sub(r'import [\w\.\*]+;\n', "", code)
        # make class to private
        code = code.replace("public class", "class")
        # strip
        code = code.strip()
        return code

# read source code
content = read_source(source_code_path)

# add special library
for lib_name in re.findall(r'import library.algorithm.([\w]+);', content):
    print(lib_name)
    lib_path = LIB_ALGORITHM_DIR+"/"+lib_name+".java"
    content = content + "\n\n" + read_lib(lib_path)

# add basic library
for lib_name in os.listdir(LIB_BASIC_DIR):
    lib_path = LIB_BASIC_DIR + "/" + lib_name
    content = content + "\n\n" + read_lib(lib_path)

# remove basic import
content = content.replace("import library.basic.*;\n", "")

# remove package name
content = re.sub(r'package [\w\.]+;\n\n', "", content)

# remove import
content = re.sub(r'import [\w\.\*]+;\n', "", content)

# strip
content = content.strip()

# add normal import
import_code = "import java.io.*;\nimport java.util.*;\n\n"
content = import_code + content

# output source code to out directory
with open(OUT_FILE, "w") as f:
    f.write(content)
