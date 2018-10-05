my_list = [1, 2, 3, 4]
# 리스트 : 변경 가능한 리스트

my_tuple = (1, 2, 3, 4)
my_tuple2 = 1, 2, 3, 4, 5
# 튜플 : 변경 불가능한 리스트

my_dict = {'key1': 'val1', 'key2': 'val2'}
# 딕셔너리 : Map 이랑 비슷 / Key : Value 쌍으로 저장
# 수정가능

my_set = set("hello")
# 셋 : 순서가 없고, 중복이 허용되지 않는 자료형

##########################
##########################

print(my_list[0], my_list[1])
print(my_tuple[0], my_tuple[1])
# 데이터를 불러올 때는 대괄호에 인덱스를 써줌

print(my_dict['key1'])
# 데이터를 불러올 때는 대괄호에 키를 써줌

print(my_set)
# set 을 출력하면 중복데이터가 사라짐
