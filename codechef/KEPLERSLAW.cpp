/**
 * vim: set cindent:
 * author: jachermocilla@gmail.com
 * url: https://www.codechef.com/JAN221C/status/KEPLERSLAW,jachermocilla 
*/

#include <iostream>
#include <sstream>

using namespace std;

#define ull unsigned long long


int main(){
   ull n,i,j,k,t;
   ull T,N,M;
   ull T1, T2, R1, R2;
   double A,B;

   cin >> T;

   for (t=0;t<T;t++){
      cin >> T1 >> T2 >> R1 >> R2;
      //cout << T1 << T2 << R1 << R2 << endl;

      A = (double)(T1*T1)/(R1*R1*R1);
      B = (double)(T2*T2)/(R2*R2*R2);

      if (A == B)
         cout << "Yes" << endl;
      else
         cout << "No" << endl;

      //cout << A << " " << B << endl;





   }

   return 0;
}
