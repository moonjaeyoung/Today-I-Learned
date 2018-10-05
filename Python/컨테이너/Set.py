set1 = set("hello")
set2 = set("holo")

# 교집합 구하기
print('교집합 : ', set1 & set2)
print('교집합 : ', set1.intersection(set2))

# 합집합 구하기
print('합집합 : ', set1 | set2)
print('합집합 : ', set1.union(set2))

# 차집합 구하기
print('차집합 : ', set1 - set2)
print('차집합 : ', set1.difference(set2))
