#!/usr/bin/python 
#+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
#|R|a|s|p|b|e|r|r|y|P|i|.|c|o|m|.|t|w|
#+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
# Copyright (c) 2016, raspberrypi.com.tw
# All rights reserved.
# Use of this source code is governed by a BSD-style license that can be
# found in the LICENSE file.
#
# move_car.py
# control car with argument [w=forward/a=left/s=backward/d=right]
# usage: sudo python move_car.py [w/a/s/d]
#
# Author : sosorry
# Date   : 08/01/2015

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
import cv2


GPIO.setwarnings(False)

#obtain audio from the microphone
r=sr.Recognizer()

Motor_R1_Pin = 16
Motor_R2_Pin = 18
Motor_L1_Pin = 15
Motor_L2_Pin = 13
t = 0.5
voll = "-2000"

thing = ""
app = Flask(__name__)

ENDPOINT = "things.ubidots.com"
DEVICE_LABEL = "car"
VARIABLE_LABEL = "command"

TOKEN = "BBFF-PU42vI1fknawh6gthF0di6wlfTSgF7"
DELAY = 1 # Delay in seconds

URL = "http://{}/api/v1.6/devices/{}/{}/values/?page_size=1".format(ENDPOINT, DEVICE_LABEL, VARIABLE_LABEL)
HEADERS = {"X-Auth-Token": TOKEN, "Content-Type": "application/json"}

GPIO.setmode(GPIO.BOARD)
GPIO.setup(Motor_R1_Pin, GPIO.OUT, initial=GPIO.LOW)
GPIO.setup(Motor_R2_Pin, GPIO.OUT, initial=GPIO.LOW)
GPIO.setup(Motor_L1_Pin, GPIO.OUT, initial=GPIO.LOW)
GPIO.setup(Motor_L2_Pin, GPIO.OUT, initial=GPIO.LOW)

command = {"車輛移動" : 0, "結束" : 0, "提醒" : 0, "音樂" : 0, "清單" : 0, "時間" : 0}
upload = ""

def stop():
    GPIO.output(Motor_R1_Pin, False)
    GPIO.output(Motor_R2_Pin, False)
    GPIO.output(Motor_L1_Pin, False)
    GPIO.output(Motor_L2_Pin, False)


def forward():
    GPIO.output(Motor_R1_Pin, True)
    GPIO.output(Motor_R2_Pin, False)
    GPIO.output(Motor_L1_Pin, True)
    GPIO.output(Motor_L2_Pin, False)
    time.sleep(t)
    stop()


def backward():
    GPIO.output(Motor_R1_Pin, False)
    GPIO.output(Motor_R2_Pin, True)
    GPIO.output(Motor_L1_Pin, False)
    GPIO.output(Motor_L2_Pin, True)
    time.sleep(t)
    stop()


def turnRight():
    GPIO.output(Motor_R1_Pin, False)
    GPIO.output(Motor_R2_Pin, False)
    GPIO.output(Motor_L1_Pin, True)
    GPIO.output(Motor_L2_Pin, False)
    time.sleep(t)
    stop()

def turnLeft():
    GPIO.output(Motor_R1_Pin, True)
    GPIO.output(Motor_R2_Pin, False)
    GPIO.output(Motor_L1_Pin, False)
    GPIO.output(Motor_L2_Pin, False)
    time.sleep(t)
    stop()

def set_interval(func,sec):
    def func_wrapper():

        func()
    t = threading.Timer(sec, func_wrapper)
    t.start()
    return t

def call():
    tts = gTTS(text='記得'+thing, lang='zh-TW')
    tts.save('timer.mp3')
    os.system('omxplayer --vol -100  -o local -p timer.mp3 > /dev/null 2>&1')

def post_var(payload, url=ENDPOINT, device=DEVICE_LABEL, token=TOKEN):
    try:
        url = "http://{}/api/v1.6/devices/{}".format(url, device)
        headers = {"X-Auth-Token": token, "Content-Type": "application/json"}

        attempts = 0
        status_code = 400

        while status_code >= 400 and attempts < 5:
            print("[INFO] Sending data, attempt number: {}".format(attempts))
            req = requests.post(url=url, headers=headers,json=payload)
            status_code = req.status_code
            attempts += 1
            time.sleep(1)

        print("[INFO] Results:")
        print(req.text)
    except Exception as e:
        print("[ERROR] Error posting, details: {}".format(e))

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

@app.route('/')
def index():
    return "Hello World"

if __name__ == "__main__":

    print("\n\nubidots資料庫數據:\n")
    get_var()
    print("\n\n")


    while True:

        with sr.Microphone(device_index=2,sample_rate = 48000) as source:
            print("Please wait. Calibrating microphone...")

            r.energy_threshold=1000
            print("Say something!")
            audio=r.listen(source)

        try:
            print("Google Speech Recognition thinks you said:")
            words = r.recognize_google(audio, language='zh-TW')
            print(words)
            if "前進" in words:
                command["車輛移動"] += 1
                tts = gTTS(text='前進中', lang='zh-TW')
                tts.save('car.mp3')
                os.system('omxplayer --vol -100  -o local -p car.mp3 > /dev/null 2>&1')
                print("\n前進中\n")
                forward()
            elif "左轉" in words:
                command["車輛移動"] += 1
                tts = gTTS(text='車輛左轉', lang='zh-TW')
                tts.save('car.mp3')
                os.system('omxplayer --vol -100  -o local -p car.mp3 > /dev/null 2>&1')
                turnLeft()
                print("\n車輛左轉\n")
            elif "右轉" in words:
                command["車輛移動"] += 1
                tts = gTTS(text='車輛右轉', lang='zh-TW')
                tts.save('car.mp3')
                os.system('omxplayer --vol -100  -o local -p car.mp3 > /dev/null 2>&1')
                turnRight()
                print("\n車輛右轉\n")
            elif "後退" in words:
                command["車輛移動"] += 1
                tts = gTTS(text='倒車中', lang='zh-TW')
                tts.save('car.mp3')
                os.system('omxplayer --vol -100  -o local -p car.mp3 > /dev/null 2>&1')
                backward()
                print("\n倒車中，後方車輛請注意\n")
            elif "結束" in words:
                command["結束"] += 1
                print("\nQuit\n")
#                blind()
                payload = {VARIABLE_LABEL:{"value" : 0, "context" : command}}
                post_var(payload)
                GPIO.cleanup()
                quit()
            elif "提醒我" in words:
                command["提醒"] += 1
                time1 = ""
                thread_time = 0
                index = 0
                thing = words[words.find('提醒我')+3:]
                if "秒" in words:
                    index = words.find('秒')
                    print("index: ",index)
                    for i in range((int)(index-1), -1, -1):
                        if words[i].isdigit(): 
                            time1 = words[i]+time1
                        else:
                            break;
                    thread_time += int(time1)
                if "分" in words:
                    index = words.find('分')
                    time1 = ""
                    print("index: ",index)
                    for i in range((int)(index-1), -1, -1):
                        if words[i].isdigit():
                            time1 = words[i]+time1
                        else:
                            break;
                    thread_time += int(time1)*60
                print('\n已設定',thread_time,'秒後的提醒\n')
                set_interval(call,int(thread_time))
            elif "隨機放音樂" in words or "隨機播音樂" in words or "隨機播放" in words:
                command["音樂"] += 1
                print('enter:')
                tmp = random.randint(1,10)
                cnt = 1
                for s in os.listdir('music'):
                    if tmp == cnt:
                        print('\n現在播放 ' + s[0:-4] + '\n')
                        tts = gTTS(text="現在播放"+s[0:-4], lang='zh-TW')
                        tts.save('music.mp3')
                        os.system('omxplayer -o local -p music.mp3 --vol -5000 > /dev/null 2>&1')
                        proc1 = subprocess.Popen(args=['omxplayer','--no-osd','-b','--aspect-mode','fill', "./music/"+s ,'--vol',voll])
                        break
                    cnt+=1
            elif "停止播放" in words:
                print('\n停止播放\n')
                subprocess.call(['pkill','-P',str(proc1.pid)])
                proc1.kill()
            elif "播放" in words or "聽" in words:
                command["音樂"] += 1
                index = 0
                name = ""
                if "播放" in words:
                    index = words.find("播放")
                    index += 2
                else:
                    index = words.find("聽")
                    index += 1
                name = words[index:]
#                print(name)
                proc1 = subprocess.Popen(args=['omxplayer','--no-osd','-b','--aspect-mode','fill', "./music/"+name+".mp3" ,'--vol',voll])
                exist = False
                for s in os.listdir('music'):
                    if name in s:
                        exist = True
                if exist == False:
                    print('\n查無歌曲\n')
                    tts = gTTS(text="查無歌曲", lang='zh-TW')
                    tts.save('music.mp3')
                    os.system('omxplayer -o local -p music.mp3 --vol -5000 > /dev/null 2>&1')
                else:
                    print('\n播放 ' + name + '\n')
            elif "音樂清單" in words:
                command["清單"] += 1
                cnt = 1
                for s in os.listdir('music'):
                    print(s)
                    tts = gTTS(text="第"+str(cnt)+"首是"+s[0:-4], lang='zh-TW')
                    tts.save('music.mp3')
                    os.system('omxplayer -o local -p music.mp3 --vol -5000 > /dev/null 2>&1')
                    cnt += 1
            elif "指令清單" in words:
                command["清單"] += 1
                print('\n前進、左轉、右轉、後退、提醒我、隨機播放、播放、停止播放、音樂清單、指令清單、現在時間\n')
                tts = gTTS(text="前進、左轉、右轉、後退、提醒我、隨機播放、播放、停止播放、音樂清單、指令清單、現在時間", lang='zh-TW')
                tts.save('music.mp3')
                os.system('omxplayer -o local -p music.mp3 --vol -5000 > /dev/null 2>&1')
            elif "現在幾點" in words or "現在時間" in words or "現在的時間" in words:
                command["時間"] += 1
                localtime = time.localtime()
                result = datetime.utcnow().replace(tzinfo=timezone.utc)
                result2 = result.astimezone(timezone(timedelta(hours=8)))
                tts = gTTS(text=result2.strftime("%Y-%m-%d %H:%M:%S"), lang='zh-TW')
                tts.save('time.mp3')
                os.system('omxplayer -o local -p time.mp3 --vol -5000 > /dev/null 2>&1')
            elif "清空資料庫" in words:
                command = {"車輛移動" : 0, "結束" : 0, "提醒" : 0, "音樂" : 0, "清單" : 0, "時間" : 0}
                payload = {VARIABLE_LABEL:{"value" : 0, "context" : command}}
                post_var(payload)
            else:
                print("\n00000")

        except sr.UnknownValueError:
            print("Google Speech Recognition could not understand audio")

        except sr.RequestError as e:
            print("No response from Google Speech Recognition service: {0}".format(e))
            subprocess.call(['pkill','-P',str(proc1.pid)])
            proc1.kill()
            payload = {VARIABLE_LABEL:{"value" : 0, "context" : command}}
            post_var(payload)

