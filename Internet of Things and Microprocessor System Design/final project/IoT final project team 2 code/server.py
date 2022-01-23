
from gtts import gTTS
import RPi.GPIO as GPIO
import time
import os
import readchar
import speech_recognition as sr
import threading
import subprocess
from pymouse import PyMouse
from pykeyboard import PyKeyboard
import random
from datetime import datetime,timezone,timedelta
import requests
import json
from flask import Flask, render_template, Response

app = Flask(__name__)

ENDPOINT = "things.ubidots.com"
DEVICE_LABEL = "car"
VARIABLE_LABEL = "command"

TOKEN = "BBFF-PU42vI1fknawh6gthF0di6wlfTSgF7"
DELAY = 1 # Delay in seconds

URL = "http://{}/api/v1.6/devices/{}/{}/values/?page_size=1".format(ENDPOINT, DEVICE_LABEL, VARIABLE_LABEL)
HEADERS = {"X-Auth-Token": TOKEN, "Content-Type": "application/json"}

command = {"車輛移動" : 0, "結束" : 0, "提醒" : 0, "音樂" : 0, "清單" : 0, "時間" : 0}


@app.route('/')
def index():
    get_var()
    global command

    return render_template('abc.html', user_template=command)


def get_var():
    global command
    try:
        attempts = 0
        status_code = 400
        while status_code >= 400 and attempts < 5:
            req = requests.get(url=URL, headers=HEADERS)
            status_code = req.status_code
            attempts += 1
            time.sleep(1)
        tmp = req.json()
        command = tmp['results'][0]['context']
        print(command)
    except Exception as e:
        print("[ERROR] Error posting, details: {}".format(e))


if __name__ == "__main__":

    app.run(host='0.0.0.0', port=8000, debug=True)


