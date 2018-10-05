from abc import *


class Perceptron:

    @abstractmethod
    def __init__(self, rate=0.01, iteration=10, thresholds=0.0):
        pass

    @abstractmethod
    def fit(self, x, y):
        pass

    @abstractmethod
    def net_input(self, x):
        pass

    @abstractmethod
    def predict(self, x):
        pass
