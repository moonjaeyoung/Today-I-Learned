import numpy as np


class Perceptron:

    def __init__(self, th=0.0, eta=0.01, n=10):
        self.prediction = [n]
        self.w = np.zeros(n)
        self.error = []
        # numpy.zeros -> 모든원소가 0인 파라미터의 크기만큼의 배열을 만듬
        self.th = th
        self.eta = eta
        self.n = n

    def fit(self, x, y):
        errors = 0

        # zip : 리스트 x와 y의 같은 인덱스끼리 짝지어서 배열형성
        for i, target in zip(x, y):
            update = self.eta = (target - self.prediction[i])
            self.w[1:] += update * i
            self.w[0] += update
            errors += int(update != 0.0)
        self.error.append(errors)
        print(self.w)
        return self

    def net_input(self, x):
        return np.dot(x, self.w[1:]) + self.w[0]

    def predict(self, x):
        return np.where(self.net_input(x) > self.th, 1, -1)
