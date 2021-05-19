import sys
import shutil
from collections import Counter

def count_words(text):
    splitdata = text.split()
    return len(splitdata)

if len(sys.argv) <2 :
    print("인자값이 없습니다.")
else:
    f = open(sys.argv[1],'r')
    text = f.read()
    print("# of lines : %d" %(text.count("\n")+1))


    print("# of words : ", count_words(text))

    f.close()
