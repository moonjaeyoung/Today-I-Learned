import tensorflow as tf
import os

os.environ['TF_CPP_MIN_LOG_LEVEL'] = '2'

hello = tf.constant("hello")
# 상수노드 만들기

sess = tf.Session()
# 실행 세션

print(sess.run(hello))
# 실행후 리턴값 출력
