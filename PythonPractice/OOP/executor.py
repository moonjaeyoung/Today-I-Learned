from OOP import character_stat as cs


class executor:

    def method(self, num1, num2):
        ch1 = cs.character_stat()
        ch1.set_all(num1, num2)
        ch1.print()

        return self

    @staticmethod
    def staticMethod():
        print("정적 메서드")


executors = executor()
executors.method(500, 600)

executor.staticMethod()
