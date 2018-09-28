import tensorflow as tf
import os

os.environ['TF_CPP_MIN_LOG_LEVEL'] = '2'

x = [1, 2, 3]
y = [1, 2, 3]

w = tf.Variable(tf.random_normal([1]), name='weight')

hypothesis = w * x
cost = tf.reduce_min(tf.square(y - hypothesis))

trainer = tf.train.GradientDescentOptimizer(learning_rate=0.01).minimize(cost)

sess = tf.Session()
sess.run(tf.global_variables_initializer())

for i in range(0, 1000):
    sess.run(trainer)

    print(sess.run(w), sess.run(cost))


