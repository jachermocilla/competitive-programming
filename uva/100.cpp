/**
 * vim: set cindent:
 * author: jachermocilla@gmail.com
 * url: 
*/

#include <iostream>
#include <sstream>

using namespace std;

#define ull unsigned long long

ull cycle_length(ull n){
   ull k=0;
   while(1){
      k++;
      if (n==1)
         break;
      else if ((n % 2) != 0)
         n=3*n+1;
      else
         n=n/2;
   }
   return k;
}

int main(){
   ull n,i,j,k,t;
   ull T,N,M,a,b,a_orig,b_orig;
   ull max,cl;

   while (cin >> a >> b){
      max=0;
      a_orig=a;
      b_orig=b;
      if (a > b){
         t=a;
         a=b;
         b=t;
      }

      for (i=a;i<=b;i++){
         cl = cycle_length(i);
         if (cl > max)
            max=cl;
      }
      cout << a_orig << " " << b_orig << " " << max << endl;
   }

   return 0;
}
