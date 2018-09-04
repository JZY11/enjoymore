#!/bin/bash -xe
sleep 10s
if [ "$(curl http://127.0.0.1:8099/health/alive -#)" != '{"status":"UP"}' ]; then
  echo "The result of a HTTP GET request to 127.0.0.1/health/alive is not 'OK'."
  echo "It was:"
  echo $(curl http://127.0.0.1:8099/health/alive -#)
  exit 1
fi