#include <iostream>
using namespace std;

int search(int* arr, int item, int start, int end) {
    for (int i = start; i < end; i++) {
        if (arr[i] == item)
            return i;
    }
    return -1;
}

int main() {
    int n;
    cin >> n;

    int* arr = new int[n];
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    int maxLen = 0;
    int start = 0;
    int end = 0;

    while (end < n) {
        int index = search(arr, arr[end], start, end);
        if (index == -1) {
            end++;
        } else {
            if (end - start > maxLen)
                maxLen = end - start;
            start = index + 1;
        }
    }

    if (end - start > maxLen)
        maxLen = end - start;

    cout << maxLen << endl;

    delete[] arr;
    return 0;
}