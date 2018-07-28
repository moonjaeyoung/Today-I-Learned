# 복습한번 하자

# 선형 회귀 모델 (Linear Regression Model)
# Hypothesis : H(x) = Wx + b
# Cost function : {∑(H(x) - y)}^2 / n
# Gradient descent algorithm : W = W - (rate * (d/dW) cost(W))


# 논리 회귀 모델 (Logistic Classification Model)
# Spam detection : Spam or Ham
# 0 or 1 encoding
# w값에 따라 x값이 무한히 커지거나 작아질 수 있음.
# 우리가 사용할 식 : logistic function
# : g(z) = 1 / (1 + e^-z)


# Hypothesis (sigmoid) : 1 / 1 + e^-(W^T * X)
# 기존 방식의 Cost function : {∑(H(x) - y)}^2 / n
# 완벽한 2차 함수의 곡선이 아닌 울퉁불퉁한 모양이 됨.
# 기존 방식은 선형적이기 때문에 항상 일정한 최저 점을 찾을 수 있었지만
# 논리 회귀모델에서는 그렇지 않음 -> Cost function 을 바꿔야 할 필요가 있음.

# 새로운 Cost function
# cost(W) = {∑ C(H(x) , y)} / n
#
# C(H(x) , y) =    1. -log(H(x)) : y = 1
#                       2. -log(1-H(x)) : y = 0
#
# 새롭게 만들어진 Cost function 에 대해 이해해보자
# 지수함수가 들어가기 때문에 그 것을 상쇄시키기 위해 log 함수를 사용

# Cost 의 의미 ? : 우리의 예측과 실제 데이터의 차이 -> 최적화 필요
# (y = 1) z가 0일 때 cost 는 ∞  / z가 1일 때 cost 는 0
# (y = 0) z가 0일 때 cost 는 1 / z가 1일 때 cost 는 ∞
# 이렇게 새로운 cost function 에 gradient descent algorithm 을 적용함.

# C(H(x) , y) = -y * log(H(x)) -(1-y)log(1-H(x))
# 왜 이렇게?
# y가 0이면 앞의 -y * log(H(x)) 가 사라지고 뒤의 값만 남음
# y 가 1이면 뒤의 -(1-y) log(1-H(x)) 가 사라지게 됨.
# 그러면 우리가 만든 C 함수가 조건에 따라 드러나게 되어있음.

# 이제 이 cost function 에 gradient descent algorithm 을 적용하면
# W = W - (rate * (d/dW) cost (W))



