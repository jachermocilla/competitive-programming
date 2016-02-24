/**
 * author: jachermocilla@gmail.com
 * url: https://www.codechef.com/status/MNMX,jachermocilla 
*/

#include <iostream>
#include <sstream>

using namespace std;

#define ull unsigned long long


int main(){
    ull T,N,M;
    ull A[50001];

    ull n,i,j,k;
    
    ull smallest;


    cin >> T;
    for (i=0;i<T;i++){
        cin >> M;
        for (j=0;j<M;j++){
            cin >> A[j];
        }

        smallest=A[0];
        for (j=0;j<M;j++){
            if (A[j]<smallest){
                smallest=A[j];
            } 
        }
        cout << (M-1)*smallest << endl;
    }

    return 0;
}
