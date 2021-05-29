import matplotlib.pyplot as plt
import csv

f=open('/Users/hadongjun/Desktop/birth.csv', encoding='utf-8-sig')
data = csv.reader(f)
next(data)
max1 = []
max8 = []

for row in data:
    if row[0].split('.')[1] == '1':
        max1.append(float(row[-1]))
    if row[0].split('.')[1] == '8':
        max8.append(float(row[-1]))

f.close()
print("1월 : \n",max1)
print("8월 : \n",max8)

plt.title('Aug Jan maxTemp')
plt.hist(max1,bins=100, color='r', label= 'Aug')
plt.hist(max8, bins=100, color='b', label= 'Jan')
plt.legend()
plt.show()




