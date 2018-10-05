my_str = "hello"

my_str2 = """
너가
알아
둬야
할게
하나
있어
"""
print(my_str2)
# 따옴표 3개를 사용하면 자동 줄바꿈 기능을 사용 할 수 있음.
# Documentation string (String 자체를 주석으로)으로도 사용할 수 있음


# 파이썬 스트링 포맷팅 1 : % 연산자
age = 25
string2 = 'my age is %d' % age
print(string2)
# % 연산자 : c언어 처럼 사용 가능
# %d , %s, %f 등 존재


# 파이썬 스트링 포맷팅 2 : format 메소드
name = 'woong'
string3 = 'my name is {}'.format(name)
print(string3)
# 중괄호 안에 format 뒤의 문자열이 대입됨.

string4 = '{} + {} = {}'.format(2, 4, 6)
print(string4)
# 여러개도 가능

string4 = '{2} - {0} = {1}'.format(2, 4, 6)
print(string4)
# 중괄호 안에 숫자를 써주면 순서도 변경할 수 있음.


string5 = "my name is python"
print(string5.split())
string5 = 'A:B:C:D'
print(string5.split(':'))
# split 은 자바와 동일함


string6 = '안녕하세요. 파이썬입니다.'
print(string6[2])
print(string6[2:9])
# 문자열 인덱싱 , 슬라이싱


