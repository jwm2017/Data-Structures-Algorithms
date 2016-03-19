class MergeSort:
    "Takes a list to sort in the constructor"
    def __init__(self, list):
        self.list = list

    def sort(self):
        mergeSort(self.list)

    def mergeSort(arr):
        if len(arr) == 1
            return arr
        else:
            leftArr = arr[:len(arr)/2]
            rightArr = arr[len(arr)/2:]
            merge(leftArr)
            merge(rightArr)
            return merge(leftArr, rightArr)

    def merge(leftArr, rightArr):
        mergedArray
        leftIndex, rightIndex
        while (leftIndex < len(leftArr) && rightIndex < len(rightArr)):
            if (leftArr[leftIndex] > rightArr[rightIndex]):
                mergedArray.append(rightArr[rightIndex])
                rightIndex++
            else:
                mergedArray.append(leftArr[leftIndex])
                leftIndex++
        while (leftIndex < len(leftArr)):
            mergedArray.append(leftArr[leftIndex])
            leftIndex++
        while (rightIndex < len(rightArr)):
            mergedArray.append(rightArr[rightIndex])
            rightIndex++
        return mergedArray

def main():
    intList = MergeSort([4, 1, 5, 8, 9, 3, 3, 6, 7, 10, -5, -12])
    print('intList before sorting: \n' + intList + '\n\n')
    intList.sort()
    print('intList after sorting: \n' + intList + '\n\n')
    print(intList)

    charList = MergeSort(['a', 'z', 'c', 'b', 'f', 'e', 'y', 'p'])
    print('charList before sorting: \n' + charList + '\n\n')
    charList.sort()
    print('charList after sorting: \n' + charList + '\n\n')

if __name__ == '__main__':
    main()
