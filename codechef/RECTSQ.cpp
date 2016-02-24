/**
 * author: jachermocilla@gmail.com
 * url: 
*/

#include <iostream>
#include <sstream>

using namespace std;

#define ull unsigned long long

int main(){
    ull i=0,j=0,k=0;

    ull T,N,M,min,max,lcd;

    cin >> T;
    for (i=0;i<T;i++){
        cin >> N >> M;
        min=(N<=M)?N:M;
        max=(N>=M)?N:M;
        lcd=1;
        for (j=min;j>1;j--){
            if (((N%j)==0) && ((M%j)==0)){
                lcd=j;    
                //break; 
           }
        }
        //cout << "lcd:" << lcd << endl;    
        if (lcd == 1){
            cout << (max*min)  << endl;
        }else{
            cout << ((N/lcd)*(M/lcd)) << endl;
        }
    }
    return 0;
}
