from impliment.linear_regression import linear_regression as lr

rg = lr.LinearRegression()

rg.set_x([1, 2, 3, 4, 5, 6])
rg.set_y([2, 4, 6, 8, 10, 12])
rg.set_repeat(1800)

rg.run(rg.w, rg.cost)
