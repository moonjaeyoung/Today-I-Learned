import numpy as np
from perceptron.perceptron import Perceptron


class PerceptronImpl(Perceptron):
    def __init__(self, rate=0.01, iteration=10, thresholds=0.0):
        super().__init__(rate, iteration, thresholds)
        self.thresholds = thresholds  # 임계값
        self.rate = rate  # 러닝 레이트
        self.iteration = iteration  # 반복 횟수

    def fit(self, x, y):
        self.w_ = np.zeros(1 + x)  # weight
        self.errors_ = []  # 에러 횟수를 담는 배열

        for i in range(self.iteration):
            errors = 0  # 에러 횟수 초기화
            for X in zip(x, y):
                # zip 함수 : 두개의 배열의 같은 인덱스를 잘라 새로운 배열로 만들어냄.

                update = self.rate * (y - self.predict(X))
                # 러닝레이트 * (y - H(x))

                self.w_[1:] += update * X
                self.w_[0] += update

                errors += int(update != 0.0)
            self.errors_.append(errors)
            print(self.w_)

    def net_input(self, x):
        return np.dot(x, self.w_[1:]) + self.w_[0]

    def predict(self, x):
        return np.where((self.net_input(x)) > self.thresholds, 1, -1)
