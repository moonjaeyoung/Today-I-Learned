import tensorflow as tf
import os

os.environ['TF_CPP_MIN_LOG_LEVEL'] = '2'

a = tf.placeholder(tf.float32)
b = tf.placeholder(tf.float32)

add = a + b

sess = tf.Session()
print(sess.run(add, feed_dict={a: 10.7, b: 22.3}))
