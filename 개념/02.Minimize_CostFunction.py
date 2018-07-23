# CostFunction = {Σ 1->n (n번째 가설데이터 - n번째 실제데이터)^2} / n
# y = Wx 를 예시로 들어보자

# TrainingDataSet =
# x = 1 , y = 1
# x = 2 , y = 2
# x = 3 , y = 3

# CostFunction =
# {Σ 1->3 (n번째 가설데이터 - n번째 실제 데이터)^2} / 3

# W = 1 일때
# {(1x1 - 1)^2 + (2x1 - 2)^2 + (3x1 - 3)^2} / 3
# (0 + 0 + 0) / 3
# Cost = 0

# W = 0 일때
# {(1x0 - 1)^2 + (2x0 - 2)^2 + (3x0 - 3)^2} / 3
# (1 + 4 + 9) / 3
# Cost = 14 / 3

# W = 2 일때
# {(1x2 - 1)^2 + (2x2 - 2)^2 + (3x2 - 3)^2} / 3
# (1 + 4 + 9) / 3
# Cost = 14/3

# CostFunction 을 그래프로 그리면 x = 1 일 때 최솟값을 갖는 2차 방정식의 그래프가 그려짐

# cost
#  ...
#   o                        o
#    o                      o
#      o                  o
#         o            o
#                o
#
#         0     1     2    ...   W

# 여기에서 사용되는 것이 Gradient descent algorithm (경사 감소 알고리즘)
# 해당 W 에서 기울기의 절댓값을 구한 뒤, 기울기가 최소가 되는 지점으로 이동
# 미분을 이용 !

# CostFunction
# = {Σ 1->n (n번째 가설데이터 - n번째 실제데이터)^2} / n
# = {Σ 1->n (W(x) - y)^2} / n

# -> 미분을 위해 약간 변형.
# = {Σ 1->n (W(x) - y)^2} / 2n

# W = W - rate x (d/dW) cost(W)
# rate 는 상수 (Learning Rate)
# 이것이 무슨 의미냐면 (d/dW) cost(W) 가 기울기이므로
# 기울기가 양수이면 (- rate) 가 곱해져있기 때문에 전체값이 음수가 되어 W를 음수쪽으로 이동시키고
# 기울기가 음수이면 (- rate) 가 곱해져있기 때문에 전체값이 양수가 되어 W를 양수쪽으로 이동시킴.

# 이제 미분을 해보자
# W = W - rate x (d/dW) cost(W)
# W = W - rate x (d/dW) {Σ 1->n (Wx - y)^2} / 2n

# 즉, W = W - (rate / n)  {Σ 1->n (Wx - y) * x}
# (여기에선 x가 상수고 W가 미지수임, 그래서 Wx 를 다시 미분해서 전체에 곱하면 x가 곱해짐)
