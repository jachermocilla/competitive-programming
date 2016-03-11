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
    ull n,i,j,k,t;
    ull T,N,M,K;
    int tmp;
    long long asum, bsum;

    vector <int> A;
    vector <int> B;

    cin >> T;

    for (t=0;t<T;t++){
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
        //cout << maxprod << endl;

        while(K>0){
            /*
            for(i=0;i<N;i++){
                cout << A[i] << " ";
            }
            cout << endl;
            
            for(i=0;i<N;i++){
                cout << B[i] << " ";
            }
            cout << endl;
            */

            long long prod=0;
            long long maxprod=-99999999;
            long long maxindex=0;
            for (i=0;i<N;i++){
                prod=A[i]*B[i];
                if (prod>maxprod){
                    maxprod=prod;
                    maxindex=i;
                }
            }
            //cout << maxprod << endl; 
            if (((A[maxindex]+1)*B[maxindex]) > maxprod){
                A[maxindex]++;
            }
        
            else if (((A[maxindex]-1)*B[maxindex]) > maxprod){
                A[maxindex]--;
            }
            K--;
        }
        
        int sum=0;
        for (i=0;i<N;i++){
            sum+=A[i]*B[i];
        }
        cout << sum << endl;
    }

    return 0;
}
