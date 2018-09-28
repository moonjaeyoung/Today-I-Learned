import tensorflow as tf
import os

os.environ['TF_CPP_MIN_LOG_LEVEL'] = '2'

a = tf.placeholder(tf.float32)
b = tf.placeholder(tf.float32)
# placeholder 를 사용하면 모델만 미리 만들어 놓은뒤 실행시에 값을 넣어서 사용가능.
# 만들어놓은 모델을 재사용하기에 편리하다는 장점이 있음.

add = a + b

sess = tf.Session()
print(sess.run(add, feed_dict={a: 10.7, b: 22.3}))
