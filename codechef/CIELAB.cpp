/**
 * vim: set cindent:
 * author: jachermocilla@gmail.com
 * url: https://www.codechef.com/status/CIELAB,jachermocilla 
*/

#include <iostream>
#include <sstream>

using namespace std;

#define ull unsigned long long

ull stack[10];
int top=0;

void digits(ull n){
    while(n != 0){
        int d = n % 10;
        n = n / 10;
        stack[top++]=d;
    }
}



int main(){
    ull n,j,k,t;
    ull T,N,M;
    ull A, B, C;
    int i;

    cin >> A >> B;
    if (((A-B)%10)<9)
        cout << (A-B+1);
    else
        cout << (A-B-1);
    return 0;
}
