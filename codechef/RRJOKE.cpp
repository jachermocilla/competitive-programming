/**
 * vim: set cindent:
 * author: jachermocilla@gmail.com
 * url: 
*/

#include <iostream>
#include <sstream>

using namespace std;

#define ull unsigned long long

int main(){
    ull n,i,j,k;
    ull T,N,M;
    ull PX,PY;
    ull H;

    cin >> T;

    for (i=0;i<T;i++){
        cin >> N;

        H=0;
        for(j=1;j<=N;j++){            
            cin >> PX >> PY;
            H=H^j;
        }
        cout << H << endl;
    }

    return 0;
}
