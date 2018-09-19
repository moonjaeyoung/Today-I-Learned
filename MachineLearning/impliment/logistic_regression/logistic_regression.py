import os

import numpy
import tensorflow

os.environ['TF_CPP_MIN_LOG_LEVEL'] = '2'


class LogisticRegression:

    xy = numpy.loadtxt('data.csv', delimiter=', ', dtype=numpy.float32)

    x_data = xy[:, 0:-1]
    y_data = xy[:, [-1]]

    x = tensorflow.placeholder(tensorflow.float32, shape=[None, 8])
    y = tensorflow.placeholder(tensorflow.float32, shape=[None, 1])
    w = tensorflow.Variable(tensorflow.random_normal([8, 1]))

    hypothesis = tensorflow.sigmoid(tensorflow.matmul(x, w))
    cost = tensorflow.reduce_mean(
        -y * tensorflow.log(hypothesis)
        -(1-y) * tensorflow.log(1 - hypothesis)
    )

    training = tensorflow.train\
        .GradientDescentOptimizer(learning_rate=0.1)\
        .minimize(cost)

    predicted = tensorflow\
        .cast(hypothesis > 0.5, dtype=tensorflow.float32)

    accuracy = tensorflow\
        .reduce_mean(tensorflow
                     .cast(tensorflow
                           .equal(predicted, y), dtype=tensorflow.float32))

    sess = tensorflow.Session()
    sess.run(tensorflow.global_variables_initializer())

    def run(self, *data):
        for i in range(3500+1):
            self.sess.run(self.training, feed_dict={self.x: self.x_data, self.y: self.y_data})
            print(i, self.sess.run(data, feed_dict={self.x: self.x_data, self.y: self.y_data}))
