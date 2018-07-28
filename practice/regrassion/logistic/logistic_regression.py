import tensorflow
import os

os.environ['TF_CPP_MIN_LOG_LEVEL'] = '2'

x_data = [
    [1, 2],
    [2, 3],
    [4, 3],
    [5, 3],
    [6, 2]]
# x값은 n * 2 행렬

y_data = [[0], [0], [0], [1], [1]]
# y 값은 n * 1 행렬

x = tensorflow.placeholder(tensorflow.float32, shape=[None, 2])
y = tensorflow.placeholder(tensorflow.float32, shape=[None, 1])
w = tensorflow.Variable(tensorflow.random_normal([2, 1]), name='weight')

hypothesis = tensorflow.sigmoid(tensorflow.matmul(x, w))
# Hypothesis = 1 / 1 + (e^WX)
# sigmoid = 1 / 1 + e^z      <---   z 값만 넣어주면 됨.
# matmul : 행렬곱 연산자

cost_function = tensorflow.reduce_mean(
    -y * tensorflow.log(hypothesis)
    - (1 - y) * tensorflow.log(1 - hypothesis)
)
# Cost function = { ∑ (-y *log (H(x)) - (1-y) * log (1 - H(x))) } / n

training = tensorflow.train.GradientDescentOptimizer(learning_rate=0.001).minimize(cost_function)
# W = W - (rate * (d/dW) cost(W)) (gradient descent algorithm)
# 기존에 쓰던 방식과 동일, 미분을 해서 기울기를 점점 줄여나감

predicted = tensorflow.cast(hypothesis > 0.5, dtype=tensorflow.float32)
accuracy = tensorflow.reduce_mean(tensorflow.cast(tensorflow.equal(predicted, y), dtype=tensorflow.float32))
# cast : 타입 캐스팅 함수
# hypothesis > 0.5 를 출력하면 True, False 가 나오는데 그것을 float32 타입으로 변환해줌

sess = tensorflow.Session()
sess.run(tensorflow.global_variables_initializer())

for i in range(20001):
    sess.run(training, feed_dict={x: x_data, y: y_data})
    print("hypothesis", sess.run(hypothesis, feed_dict={x: x_data, y: y_data}))
    print("predicted", sess.run(predicted, feed_dict={x: x_data, y: y_data}))
    print("accuracy", sess.run(accuracy, feed_dict={x: x_data, y: y_data}))
    print()
