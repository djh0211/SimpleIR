import csv

f=open('/Users/hadongjun/Desktop/seoul.csv', encoding='utf-8-sig')
data = csv.reader(f)
next(data)
gap = 0
tempgap = 0
maxC = 0
minC = 0
g_date = ''
max_date = ''
min_date = ''


for row in data:
    for i in range(3,5) :
        row[i] = float(row[i])
    tempgap = row[4] - row[3]

    if tempgap > gap :
        gap = tempgap
        g_date = row[0]
    if row[4]>maxC :
        maxC = row[4]
        max_date = row[0]
    if minC>row[3] :
        minC = row[3]
        min_date = row[0]

f.close()
print("일교차가 가장 큰 날\n",g_date)
print("최저기온이 가장 낮은 날\n",min_date)
print("최고기온이 가장 높은 날\n",max_date)
