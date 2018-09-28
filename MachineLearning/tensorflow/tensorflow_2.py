import tensorflow as tf
import os

os.environ['TF_CPP_MIN_LOG_LEVEL'] = '2'

node1 = tf.constant(3.0, tf.float32)
node2 = tf.constant(4.0, tf.float32)
node_adder = tf.add(node1, node2)
# 두개의 노드를 add 노드로 연결함

sess = tf.Session()
print(sess.run(node_adder))
