#!/bin/bash

find -type f \( -name *.java -o -name *.xcore \) ! -name package-info.java ! -path "*emf*" ! -path "*generated*" | xargs wc -l
