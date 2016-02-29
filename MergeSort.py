class MergeSort:
    "Takes a list to sort in the constructor"
    def __init__(self, list[]):
        self.list = list

    """
    start and end indices optional so object can call
    sort with no parameters initially: 'self.sort()'
    """
    def sort(self, start=None, end=None):
        if start is None:
            start = 0
        if end is None:
            end = len(self.list) - 1
        mid = (end-start)/2
        if mid > 0:
            sort(start, mid)
            sort(mid + 1, end)
        indOfRightArr = mid + 1
        indOfLeftArr = start
        while (index)




def main():


if __name__ == '__main__':
    main()
