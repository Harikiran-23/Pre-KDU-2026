passWord = input("Enter password : ")
cPassWord = input("Confirm Password : ")

print('Length 1 : ', len(passWord))
print('Length 2 : ', len(cPassWord))
print('Lengths match : ', len(passWord)==len(cPassWord))
print('Strings match : ', passWord==cPassWord)