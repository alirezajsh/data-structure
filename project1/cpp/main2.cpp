#include<iostream>

using namespace std;


int main(){
    long long n, total = 0, answer = 0;
    cin >> n;
    long long* arr = new long long[n];
    for(long long i = 0;i < n;i++){
        cin >> arr[i];
        total += arr[i];
    }
    
    if(total % 3 != 0 || n < 3){
        cout << 0;
        return 0;
    }else{
        long long target = total / 3;
        total = 0;
        long long firstDevide = 0;
        for(long long i = 0;i < n-1;i++){
            total += arr[i];
            if(total == target){
                firstDevide++;
            }
            if(total == 2*target){
                answer += firstDevide;
            }
        }

    }
    cout << answer << endl;

}