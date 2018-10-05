# for 변수 in 컨테이너(리스트, 튜플 등등...)
# 기본적으로 foreach 의 컨셉을 따라간다고 보면 될 듯

for i in [1, 2, 3]:  # 리스트
    print('안녕')

for j in 1, 2, 3, 4:   # 튜플
    print('반가워')

animals = '고양이',  '코뿔소', '호랑이', '강아지', '토끼'
for animal in animals:
    print(animal)

for string in "hello":
    print('인데스 : ' + string)


# range 문
# 기존 카운터 방식의 포문처럼 사용 가능

for n in range(0, 10):
    print(n)

for m in range(10):
    print(m)

# range 문에서 인덱스를 하나만 넣으면 자동으로 시작 인덱스는 0이 됨

