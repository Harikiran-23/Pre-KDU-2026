with open('watchlist.csv') as f:
    line = f.readline().split(',')
    watchCount = [(line.count(x),x) for x in set(line)]
    watchCount.sort(reverse = True)
    

    print('Top 3 Mosted watched movies are : ')
    if len(watchCount) < 3:
        for x,y in watchCount:
            print(x, end = '')
    else:   
        for i in range(3):
            print(watchCount[i][1], end='')