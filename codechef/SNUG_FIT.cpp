/**
 * vim: set cindent:
 * author: jachermocilla@gmail.com
 * url: 
*/

#include <iostream>
#include <sstream>
#include <algorithm>
#include <vector>

using namespace std;

#define ull unsigned long long


int main(){
   ull n,i,j,k,t,sum=0;
   ull T,N,M;
   ull A[10001];
   ull B[10001];

   cin >> T;

   for (t=0;t<T;t++){
      cin >> N;
      for (n=0;n<N;n++)
         cin >> A[n];
      for (n=0;n<N;n++)
         cin >> B[n];
      sort(B,B+N);
      sum=0;
      for (n=0;n<N;n++){
         k=B[n];
         if (k > A[n])
            k = A[n];
         //cout << k << endl;
         sum+=k;
      }
      cout << sum << endl;
//      for (n=0;n<N;n++)
//         cout << B[n];
   }

   return 0;
}
