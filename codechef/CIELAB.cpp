/**
 * vim: set cindent:
 * author: jachermocilla@gmail.com
 * url: 
*/

#include <iostream>
#include <sstream>

using namespace std;

#define ull unsigned long long

ull stack[1000000];
int top=0;

ull digits(ull n){
    ull c=0;
    ull q=0;

    top=-1;
    while ((n=n/10)>=10){
        //cout << (n%10);
        top++;
        stack[top]=(n%10);
    }
    //cout << (n%10);;
    top++;
    stack[top]=(n%10);

    return c;
}



int main(){
    ull n,j,k,t;
    ull T,N,M;
    ull A, B, C;
    int i;

    cin >> A >> B;
    C = A - B;
    cout << C << endl;
    digits(C);
    
    if (top > 0){
        for (i=top;i>=0;i--)
            cout << stack[i];
    }
    cout << 7;




    return 0;
}
