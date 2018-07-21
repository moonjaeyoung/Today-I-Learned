import tensorflow as tf
import os
os.environ['TF_CPP_MIN_LOG_LEVEL'] = '2'

X = [1, 2, 3]
Y = [1, 2, 3]
W = tf.Variable(3.0)

hypothesis = X * W

cost = tf.reduce_mean(tf.square(hypothesis - Y))

optimizer = tf.train.GradientDescentOptimizer(learning_rate=0.1)
train = optimizer.minimize(cost)

session = tf.Session()

session.run(tf.global_variables_initializer())

for step in range(10):
    print(step, session.run(W))
    session.run(train)

