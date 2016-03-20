class MergeSort:
    "Takes a list to sort in the constructor"
    def __init__(self, list):
        self.list = list

    def sort(self):
        self.mergeSort(self.list)

    def mergeSort(self, arr):
        if (len(arr) == 1):
            return arr
        else:
            leftArr = arr[:len(arr)/2]
            rightArr = arr[len(arr)/2:]
            self.mergeSort(leftArr)
            self.mergeSort(rightArr)
            return self.merge(leftArr, rightArr)

    def merge(self, leftArr, rightArr):
        mergedArray = []
        leftIndex = 0
        rightIndex = 0
        while (leftIndex < len(leftArr) and rightIndex < len(rightArr)):
            if (leftArr[leftIndex] > rightArr[rightIndex]):
                mergedArray.append(rightArr[rightIndex])
                rightIndex += 1
            else:
                mergedArray.append(leftArr[leftIndex])
                leftIndex += 1
        while (leftIndex < len(leftArr)):
            mergedArray.append(leftArr[leftIndex])
            leftIndex += 1
        while (rightIndex < len(rightArr)):
            mergedArray.append(rightArr[rightIndex])
            rightIndex += 1
        print ([str(item) for item in mergedArray])
        return mergedArray

def main():
    intList = MergeSort([4, 1, 5, 8, 9, 3, 3, 6, 7, 10, -5, -12])
    intList.sort()

if __name__ == '__main__':
    main()
