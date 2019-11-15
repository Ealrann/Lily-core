#!/bin/bash

count=0
error_count=0
for i in `find -regex '.*\.\(frag\|comp\|vert\)' ! -path "*/bin/*" ! -path "*/build/*" | grep "/src/main/shader" 2>/dev/null`
do
	target="${i/shader/resources}.spv"
	rm $target 2>/dev/null

	dir=`dirname $target`
	name=`basename $target`
	res=$(glslc -O --target-env="vulkan1.0" -c $i -o $target)
	if [ $? -ne 0 ]; then
		((error_count++))
	fi
	echo "$target"
	((count++))
done

echo ""
echo "Compilation finished"
echo "$count file(s) compiled successfully"
if [[ $error_count -ne 0 ]]; then
	echo "$error_count file(s) failed to compile"
fi
echo ""
