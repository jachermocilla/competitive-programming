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
    int n,i,j,k,t,pmax,cmax;
    int T,N,M,sum;
    int nope=0;

    cin >> T;
    for (t=0;t<T;t++){
      cin >> N;
      sum=0;
      pmax=-1;
      for (j=0;j<N;j++){
         cmax=-1;
         for (k=0;k<N;k++){
            cin >> n;
            //cout << t;
            if (n > cmax)
               cmax=n;
         }
         if (pmax>cmax){
            nope=1;
            break;
         }
         pmax=cmax;
         sum+=pmax;
         //cout << endl;
      }
      if (!nope)
         cout << sum << endl;
      else 
         cout << "-1" << endl;
    }

    return 0;
}
