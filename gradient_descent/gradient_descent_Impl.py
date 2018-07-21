import tensorflow as tf
import os
os.environ['TF_CPP_MIN_LOG_LEVEL'] = '2'

x_data = [1, 2, 3]
y_data = [1, 2, 3]

W = tf.Variable(tf.random_normal([1]) , name='weight')
X = tf.placeholder(tf.float32)
Y = tf.placeholder(tf.float32)

hypothesis = X * W

cost = tf.reduce_mean(tf.square(hypothesis - Y))

learning_rate = 0.1
gradient = tf.reduce_mean((W*X-Y) * X)
descent = W - learning_rate * gradient
update = W.assign(descent)

session = tf.Session()

session.run(tf.global_variables_initializer())
for step in range(21):
    session.run(update, feed_dict={X: x_data, Y : y_data})
    print(step, session.run(cost, feed_dict={X: x_data, Y: y_data}), session.run(W))
