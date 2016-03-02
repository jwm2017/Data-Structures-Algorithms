class MergeSort:
    "Takes a list to sort in the constructor"
    def __init__(self, list):
        self.list = list

    """
    start and end indices optional so object can call
    sort with no parameters initially: 'self.sort()'
    """
    def sort(self):
        mergeSort(self.list)
    """
    def mergeSort(arr):
        if len(arr) == 1
            return arr
        else:
            leftArr =
        if start is None:
            start = 0
        if end is None:
            end = len(self.list) - 1
        mid = (end-start)/2

        if (mid == 0): #start and end indices are the same
            return self.list[mid]
        if mid > 0:
            sort(start, mid)
            sort(mid + 1, end)

        elif: #start and end indices are the same


        indOfRightArr = mid + 1
        indOfLeftArr = start
        while (index)
    """



def main():
    """
    intList = MergeSort([4, 1, 5, 8, 9, 3, 3, 6, 7, 10, -5, -12])
    print('intList before sorting: \n' + intList + '\n\n')
    intList.sort()
    print('intList after sorting: \n' + intList + '\n\n')
    print(intList)

    charList = MergeSort(['a', 'z', 'c', 'b', 'f', 'e', 'y', 'p'])
    print('charList before sorting: \n' + charList + '\n\n')
    charList.sort()
    print('charList after sorting: \n' + charList + '\n\n')
    """
    data = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    left = [data:[x:x+1] for x in range(0, (len(data)/2))]
    right = [data:[x:x+1] for x in range((len(data)/2), len(data))]
    print("Data: " + data)
    print("Left: " + left)
    print("Right: " + right)

if __name__ == '__main__':
    main()
