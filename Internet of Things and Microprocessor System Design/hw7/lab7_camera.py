# Origin : http://blog.miguelgrinberg.com/post/video-streaming-with-flask

import cv2
import base64
import RPi.GPIO as GPIO
import requests
import random
import time



BTN_PIN = 12
GPIO.setmode(GPIO.BOARD)
GPIO.setup(BTN_PIN, GPIO.IN, pull_up_down=GPIO.PUD_UP)

class Camera(object):
    def __init__(self):
        if cv2.__version__.startswith('2'):
            PROP_FRAME_WIDTH = cv2.cv.CV_CAP_PROP_FRAME_WIDTH
            PROP_FRAME_HEIGHT = cv2.cv.CV_CAP_PROP_FRAME_HEIGHT
        elif cv2.__version__.startswith('3') or cv2.__version__.startswith('4'):
            PROP_FRAME_WIDTH = cv2.CAP_PROP_FRAME_WIDTH
            PROP_FRAME_HEIGHT = cv2.CAP_PROP_FRAME_HEIGHT

        self.video = cv2.VideoCapture(0, cv2.CAP_V4L)
        #self.video.set(PROP_FRAME_WIDTH, 640)
        #self.video.set(PROP_FRAME_HEIGHT, 480)
        self.video.set(PROP_FRAME_WIDTH, 320)
        self.video.set(PROP_FRAME_HEIGHT, 240)
        # limit buffer size
        # self.video.set(cv2.CAP_PROP_BUFFERSIZE, 1)
    def __del__(self):
        self.video.release()
    def get_frame(self,rotate):
        success, image = self.video.read()
        # clear buffer
        # success, image = self.video.read()

#        ret, jpeg = cv2.imencode('.jpg', image)
#        cv2.imshow('a',jpeg)
#        cv2.waitKey(0)

        rows, cols = image.shape[:2]
        M = cv2.getRotationMatrix2D((cols/2, rows/2), rotate, 1)
        image = cv2.warpAffine(image, M, (cols, rows))
        ret, jpeg = cv2.imencode('.jpg', image)

        return jpeg.tostring()
#        return jpeg

    def get_frame_b64(self):
        success, image = self.video.read()
        # clear buffer
        # success, image = self.video.read()
        # resize image
        image = cv2.resize(image, (120, 90), interpolation=cv2.INTER_AREA)
        ret, jpeg = cv2.imencode('.jpg', image)
        return base64.b64encode(jpeg)
