import tensorflow as tf
import os

os.environ['TF_CPP_MIN_LOG_LEVEL'] = '2'

hello = tf.constant('hello , TensorFlow !')

node1 = tf.constant(3.0)
node2 = tf.constant(4.0)
node3 = tf.add(node1, node2)

session = tf.Session()

a = tf.placeholder(tf.float32)
b = tf.placeholder(tf.float32)
adder = a + b

print(session.run(adder, feed_dict={a: 3, b: 4}))
