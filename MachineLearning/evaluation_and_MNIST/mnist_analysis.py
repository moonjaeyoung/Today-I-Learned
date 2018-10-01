import os

import tensorflow as tf
from tensorflow.examples.tutorials.mnist import input_data

os.environ['TF_CPP_MIN_LOG_LEVEL'] = '2'

mnist = input_data.read_data_sets("MNIST_data/", one_hot=True)

nb_classes = 10

# 28 x 28
X = tf.placeholder(tf.float32, [None, 784])
# 0 - 9 = 10 classes
Y = tf.placeholder(tf.float32, [None, nb_classes])

W = tf.Variable(tf.random_normal([784, nb_classes]))
b = tf.Variable(tf.random_normal([nb_classes]))

legits = tf.matmul(X, W) + b
hypothesis = tf.nn.softmax(legits)
cross_entropy = -tf.reduce_sum(Y * tf.log(hypothesis), axis=1)
cost = tf.reduce_mean(cross_entropy)

train = tf.train.GradientDescentOptimizer(learning_rate=0.1).minimize(cost)

isCorrect = tf.equal(tf.argmax(hypothesis, 1), tf.argmax(Y, 1))
accuracy = tf.reduce_mean(tf.cast(isCorrect, tf.float32))

batch_size = 100
# 한번에 백개씩 읽어옴
epochs = 15
# 저 백개를 한번 읽어오면 1 epochs 이라고 할 수 있음.
# 배치를 15번 돌아야 전부 데이터를 학습 할 수 있다는 것 임.

with tf.Session() as sess:
    sess.run(tf.global_variables_initializer())

    for epoch in range(epochs):
        avg_cost = 0
        total_batch = int(mnist.train.num_example / batch_size)

        for i in range(total_batch):
            batch_xs, batch_ys = mnist.train.next_batch(100)
            c_, _ = sess.run([cost, train], feed_dict={X: batch_xs, Y: batch_ys})
            avg_cost += c_ / total_batch

        print(epoch, "번쨰", format(avg_cost))

    print("Accuracy: ", accuracy.eval(session=sess, feed_dict={
        X: mnist.test.images, Y: mnist.test.labels}))
