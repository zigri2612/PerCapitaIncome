#!/bin/bash
fileidl a="11YG5okUSFiH8kUSYAWQMza226edh78pJ"
filename="AppleSchoolWeb"
curl -c ./cookie -s -L "https://drive.google.com/uc?export=download&id=${fileid}" > /dev
curl -Lb ./cookie "https://drive.google.com/uc?export=download&confirm=`awk '/download/ {print $NF}' ./cookie`&id=${fileid}" -o ${filename}