# 복습 한번 해보자

# 기존
# Hypothesis = H(x) = Wx

# CostFunc =  {Σ 1->n (Wx - y)^2} / n

# Gradient descent Algorithm
# W = W - rate x (d/dW) cost(W)

# 그런데, 입력 값이 여러개라면??

# H(x1, x2, x3) = w1x1 + w2x2 + w3x3

# CostFunc = {Σ 1->n (H(x1, x2, x3) - y)^2} / n

# = {Σ 1->n (w1x1 + w2x2 + w3x3 - y)^2} / n

# 만약에 입력의 갯수가 100개면
# H(x1, x2, x3) = w1x1 + w2x2 + w3x3 + ... + w99x99 + w100x100

# 너무 복잡하니까 Matrix (행렬)로 만들어 사용하자 !

#                         (w1)
# (x1  x2  x3)   *  (w2) = (x1w1 + x2w2 + x3w3)
#                         (w3)

# H(X) = X * W (행렬 곱)

# 데이터의 수가 많아지면
# (x11,  x12,  x13)
# (x21, x22, x23)        (w1)
# (x31, x32, x33)   *   (w2)        =       결과
# (x41, x42, x43)        (w2)
# (x51, x52, x53)
#       [N, 3]                  [3,1]      ->    [N,1]

# 이런식의 연산도 가능해짐
# H(X) = X * W (행렬 곱)

