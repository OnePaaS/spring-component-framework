#! /bin/sh

APP_HOME=$(cd `dirname $0`; cd ..; pwd)
APP_NAME=${app.name}
APP_PORT=${app.port}

BOOTSTRAP_JAR=${app.boot}
APP_TARGET=${app.target}
OPTIONS=-Dlogback.configurationFile=config/logback.xml

cd $APP_HOME
java -Dapp.home=$APP_HOME \
     -Dapp.name=$APP_NAME \
     -Dapp.port=$APP_PORT \
     $OPTIONS             \
     -jar $BOOTSTRAP_JAR  \
     $APP_TARGET          \
     --stop

process=`ps aux | grep $APP_NAME | grep -v grep | grep -v check.sh | awk '{print $2}'`
if [ "$process" == "" ]; then
    echo "$APP_NAME is stopped already"
else
  echo "Force to stop $APP_NAME by pid = $process"
  kill -9 $process
fi
