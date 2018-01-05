/**
 * vim: set cindent:
 * author: jachermocilla@gmail.com
 * url: 
*/

#include <iostream>
#include <sstream>
#include <algorithm>

using namespace std;

#define ull unsigned long long
#define ul unsigned long 

int main(){
    ull n,i,j,k,t,pmax,cmax;
    ull T,N,M,sum;
    ull row[700],nope=0;
    ull row_max=0,prev_max=0;

    cin >> T;
    for (t=0;t<T;t++){
      cin >> N;
      sum=0;
      prev_max=0;
      for (j=0;j<N;j++){
         cmax=0;
         for (k=0;k<N;k++){
            cin >> row[k];
         }
         sort(row,row+N);
         row_max=row[N-1];
         if (row_max>prev_max){
            prev_max=row_max;
            sum+=row_max;
         }
         else{
            nope=1;
            break;
         }

/*
         for (k=0;k<N;k++){
            cout << row[k] << " ";
         }
         cout << endl;
*/
      }
      if (!nope)
         cout << sum << endl;
      else
         cout << "-1" << endl;

    }

    return 0;
}
