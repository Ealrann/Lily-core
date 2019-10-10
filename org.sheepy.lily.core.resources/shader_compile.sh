#!/bin/bash

optimize='true'

for i in `find -regex '.*\.\(frag\|comp\|vert\)' ! -path "*/bin/*" ! -path "*/build/*" | grep "/src/main/shader" 2>/dev/null`
do
	target="${i/shader/resources}.spv"
	rm $target 2>/dev/null
	if [ $optimize == 'true' ]
	then
		dir=`dirname $target`
		name=`basename $target`
		glslangValidator -V $i -o /tmp/$name
		spirv-opt -O /tmp/$name -o /tmp/$name
		spirv-remap --strip all --dce all -i /tmp/$name -o $dir
		rm /tmp/$name
	else
		glslangValidator -V $i -o $target
	fi
done
