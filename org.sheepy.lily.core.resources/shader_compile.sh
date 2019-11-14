#!/bin/bash


for i in `find -regex '.*\.\(frag\|comp\|vert\)' ! -path "*/bin/*" ! -path "*/build/*" | grep "/src/main/shader" 2>/dev/null`
do
	target="${i/shader/resources}.spv"
	rm $target 2>/dev/null

	dir=`dirname $target`
	name=`basename $target`
	glslc -O -c $i -o $target
	echo "$target"
done
