#!/bin/bash

PORT="5005"
AMBIENTE="h2"
DEBUG="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address="
RUN="mvn spring-boot:run"
PROJETO="Prova Tinnova"

#echo "Escolha o ambiente: dev ou tst ?"
#read AMBIENTE
#$RUN -P=$AMBIENTE -Dspring-boot.run.jvmArguments=$DEBUG$PORT

echo "Subindo "$PROJETO "no ambiente $AMBIENTE"



$RUN -Dspring-boot.run.jvmArguments=$DEBUG$PORT

echo "Tchau :)"

