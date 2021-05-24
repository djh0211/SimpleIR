import csv

f=open('/Users/hadongjun/Desktop/tmoney.csv', encoding='utf-8-sig')
data = csv.reader(f)
next(data)
max_station=['']
min_station=['']
max_user=[-999]
min_user=[9999999]
line=[]
for row in data:
    if len(line)==0:
        line.append(row[1])
    if line[-1]!=row[1] : #노선 바뀔 때

        print("----------<", line[-1], ">----------")
        print("이용객이 가장 많은 역 순위")
        for i in range(3):
            print("{0:d}. {1:s} (이용객 수: {2:d})".format(i + 1, max_station[i], max_user[i]))
        print("이용객이 가장 적은 역 순위")
        for i in range(3):
            print("{0:d}. {1:s} (이용객 수: {2:d})".format(i + 1, min_station[i], min_user[i]))

        line.append(row[1])
        max_user=[-999]
        min_user=[9999999]
    row[-1]=row[-1].replace(',','')
    row[-2]=row[-2].replace(',','')
    users=int(row[-1])+int(row[-2])
    for i in range(3):
        if max_user[i]<users:
            max_user.insert(i,users)
            max_station.insert(i,row[3])
            break
    for i in range(3):
        if min_user[i]>users:
            min_user.insert(i,users)
            min_station.insert(i,row[3])
            break

print("----------<",line[-1],">----------")
print("이용객이 가장 많은 역 순위")
for i in range(3):
    print("{0:d}. {1:s} (이용객 수: {2:d})".format(i+1,max_station[i],max_user[i]))
print("이용객이 가장 적은 역 순위")
for i in range(3):
    print("{0:d}. {1:s} (이용객 수: {2:d})".format(i+1,min_station[i],min_user[i]))