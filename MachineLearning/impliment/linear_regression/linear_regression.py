import tensorflow
import os
os.environ['TF_CPP_MIN_LOG_LEVEL'] = '2'


class LinearRegression:
    repeat = 0
    x_data = []
    y_data = []

    x = tensorflow.placeholder(tensorflow.float32)
    y = tensorflow.placeholder(tensorflow.float32)
    w = tensorflow.Variable(tensorflow.random_normal([1]))

    hypothesis = w * x
    cost = tensorflow.reduce_mean(tensorflow.square(hypothesis - y))

    sess = tensorflow.Session()
    sess.run(tensorflow.global_variables_initializer())

    train = tensorflow.train\
        .GradientDescentOptimizer(learning_rate=0.0001)\
        .minimize(cost)

    def set_x(self, *x):
        self.x_data = x

    def set_y(self, *y):
        self.y_data = y

    def set_repeat(self, repeat):
        self.repeat = repeat

    def run(self, *data):
        for i in range(self.repeat+1):
            self.sess.run(self.train, feed_dict={self.x: self.x_data, self.y: self.y_data})
            print(i, self.sess.run(data, feed_dict={self.x: self.x_data, self.y: self.y_data}))
