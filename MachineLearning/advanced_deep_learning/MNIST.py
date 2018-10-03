from tensorflow.examples.tutorials.mnist import input_data

# TensorFlow 라이브러리를 추가한다.
import tensorflow as tf
import os

os.environ['TF_CPP_MIN_LOG_LEVEL'] = '2'
mnist = input_data.read_data_sets("MNIST_data/", one_hot=True)

# 변수들을 설정한다.
x = tf.placeholder(tf.float32, [None, 784])
y_ = tf.placeholder(tf.float32, [None, 10])

W1 = tf.Variable(tf.zeros([784, 512]))
b1 = tf.Variable(tf.zeros([512]))
layer1 = tf.matmul(x, W1) + b1

W2 = tf.Variable(tf.zeros([512, 512]))
b2 = tf.Variable(tf.zeros([512]))
layer2 = tf.matmul(layer1, W2) + b2

W3 = tf.Variable(tf.zeros([512, 512]))
b3 = tf.Variable(tf.zeros([512]))
layer3 = tf.matmul(layer2, W3) + b3

W4 = tf.Variable(tf.zeros([512, 10]))
b4 = tf.Variable(tf.zeros([10]))
hypothesis = tf.matmul(layer3, W4) + b4

cost_i = tf.nn.softmax_cross_entropy_with_logits_v2(logits=hypothesis, labels='cost')
cost = tf.reduce_mean(cost_i)
train_step = tf.train.AdamOptimizer(0.1).minimize(cost)

# 경사하강법으로 모델을 학습한다.
sess = tf.Session()
sess.run(tf.global_variables_initializer())
for i in range(20001):
    batch_xs, batch_ys = mnist.train.next_batch(100)
    sess.run(train_step, feed_dict={x: batch_xs, y_: batch_ys})

# 학습된 모델이 얼마나 정확한지를 출력한다.
correct_prediction = tf.equal(tf.argmax(hypothesis, 1), tf.argmax(y_, 1))
accuracy = tf.reduce_mean(tf.cast(correct_prediction, tf.float32))
print(sess.run(accuracy, feed_dict={x: mnist.test.images, y_: mnist.test.labels}))
