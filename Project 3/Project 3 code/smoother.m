points = csvread("Final_Graph.csv")
windowLength = 100
yPoints = points(:, 2)
saltedPoints = yPoints;
smoothedPoints = movmean(yPoints, windowLength)

gLines = [saltedPoints, smoothedPoints]
plot(gLines)
title ("Salted y=x and Smoothed");
hl = legend("Salted", "Smoothed")




