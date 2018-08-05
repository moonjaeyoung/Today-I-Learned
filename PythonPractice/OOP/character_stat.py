class character_stat:
    def __init__(self):
        self.hp = 0
        self.mp = 0

    def set_all(self, hp, mp):
        self.hp = hp
        self.mp = mp

    def print(self):
        print(self.hp)
        print(self.mp)

