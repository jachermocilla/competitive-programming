/*
 * Author: jachermocilla@gmail.com
 * URL: https://www.codechef.com/status/SUBINC,jachermocilla
 */

#include <iostream>
#include <sstream>
using namespace std;

#define ull unsigned long long


ull count(ull A[],ull l){
    ull i,j,k,count=0;
    for (i=0;i<l;i++)
        for (j=0;j<l;j++){
            for (k=i;k<j;k++){
                if (A[k]>A[k+1])
                    break;
            }
            if (k==j)
                count++;    
        }
    return count;
}


int main(){
    ull T,N,a;
    ull i,j,ans;
    ull A[10000];

    cin >> T;
    //cout << T << endl;
    for (j=0;j<T;j++){
        cin >> N;
        for (i=0;i<N;i++){
            cin >> A[i];
        }
        cout << count(A,N);        

/*
        for (i=0;i<N;i++){
            cout << A[i];
        }
*/
        cout << endl;
    }   
}
