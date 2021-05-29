import matplotlib.pyplot as plt
import csv


f=open('/Users/hadongjun/Desktop/birth.csv', encoding='utf-8-sig')
data = csv.reader(f)
next(data)

date = []
maxC = []
minC = []

for row in data:
    if row[0].split('.')[1] == '2' and row[0].split('.')[2] == '11':
        date.append(row[0])
        maxC.append(float(row[4]))
        minC.append(float(row[3]))

f.close()
print("년도 : \n",date)
print("최고 : \n",maxC)
print("최저 : \n",minC)


plt.title('max min')
plt.plot(maxC, color='pink', label = 'maxTemp')
plt.plot(minC, color='skyblue', label='minTemp')
plt.legend()
plt.show()
