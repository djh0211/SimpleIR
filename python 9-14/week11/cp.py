# This is a sample Python script.

# Press ⌃R to execute it or replace it with your code.
# Press Double ⇧ to search everywhere for classes, files, tool windows, actions, and settings.

import sys
import shutil

if len(sys.argv) <3 :
    print("인자값이 없습니다.")
else:
    src = sys.argv[1]
    dst = sys.argv[2]
    shutil.copy(src, dst)







# See PyCharm help at https://www.jetbrains.com/help/pycharm/
