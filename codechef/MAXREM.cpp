/**
 * vim: set cindent:
 * author: jachermocilla@gmail.com
 * url: https://www.codechef.com/APRIL19B/status/MAXREM,jachermocilla
*/

#include <iostream>
#include <sstream>
#include <algorithm>
#include <vector>

using namespace std;

#define ull unsigned long long

#define MAXN 100001


int main(){
   ull n,i,j,k,t;
   ull max;
   ull T,N,M;
   ull data[MAXN];

   cin >> T;
   

   for (t=0;t<T;t++){
      cin >> data[t];
   }
  
   sort(data,data+T); 
   /*
   for (t=0;t<T;t++){
      cout << data[t];
   }
   */

   max = data[T-1];
   for (t=T-1; t>0;t--){
      if (data[t] < max)
         break;
   }

   cout << (data[t]%max);

   return 0;
}
