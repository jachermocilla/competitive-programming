/**
 * vim: set cindent:
 * author: jachermocilla@gmail.com
 * url: 
*/

#include <iostream>
#include <sstream>
#include <vector>

#include <stdlib.h>

using namespace std;

#define ull unsigned long long


int main(){
    ull n,i,j,k;
    ull T,N,M,K;
    int tmp;

    vector <int> A;
    vector <int> B;

    cin >> T;

    for (i=0;i<T;i++){
        A.clear();
        B.clear();
        
        cin >> N >> K;

        for (j=0;j<N;j++){
            cin >> tmp;
            A.push_back(tmp);
        }
        for (j=0;j<N;j++){
            cin >> tmp;
            B.push_back(tmp);
        }
        
        /*
        for (j=0;j<N;j++)
            cout << A[j] << endl;
        for (j=0;j<N;j++)
            cout << B[j] << endl;
        */

        ull maxindex=0;
        int max=-99999999;
        for (j=0;j<N;j++){
            if (abs(A[j])>max){
                if ( (A[j]<=0) && (B[j]<=0) ){
                    max=A[j];
                    maxindex=j;
                }
                else if ( (A[j]>=0) && (B[j]>=0) ){
                    max=A[j];
                    maxindex=j;
                }
            }
        }  
        //cout << "max:" << maxindex << endl; 
        for (j=0;j<K;j++){
            if (A[maxindex] >= 0)
                A[maxindex]++;
            else if (A[maxindex] < 0){
                if (maxindex!=0)
                    A[maxindex]--;
            }
        }

        double sum=0;
        for (j=0;j<N;j++){
            sum+=A[j]*B[j];
        }
        cout << sum << endl;
    

    }

    return 0;
}
