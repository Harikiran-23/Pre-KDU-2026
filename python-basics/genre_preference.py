genreList = []
for i in range(10):
    currentGenre = input(f'Enter Preference No {i+1} : ')
    genreList.append(currentGenre)

genreSet = set(genreList)

genreDict = { (x, genreList.count(x)) for x in genreSet}

print('\nList : ', genreList, '\n')
print('Set : ', genreSet, '\n')
print('Dictionary : ', genreDict)