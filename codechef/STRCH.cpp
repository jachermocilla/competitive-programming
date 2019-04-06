/**
 * vim: set cindent:
 * author: jachermocilla@gmail.com
 * url: 
*/

#include <iostream>
#include <sstream>

using namespace std;

#define ull unsigned long long

// C++ program to find number of distinct 
// permutations of a string. 
#include<bits/stdc++.h> 
using namespace std; 
const int MAX_CHAR = 26; 

int main(){
   ull n,i,j,k,t,m;
   ull T,N,M,pos;
   string s,sub;
   char ch;

   cin >> T;

   for (t=0;t<T;t++){
      cin >> N;
      cin >> s;
      cin >> ch;

      if ((pos=s.find(ch))==string::npos){
         cout << "0" << endl;
         continue;
      }

      k=0;

      for (ull len=1; len <= N; len++){
         for (i = 0; i <= N - len; i++){
            j=i+len-1;
            for (m=i;m<=j;m++){ 
               //cout << s.at(m);
               if (s.at(m)==ch){
                  k++;
                  break;
               }
            }

            //cout << endl;
         }
      }
   
      //cout << N*(N+1)/2 << endl;
      cout << k << endl;
   }

   return 0;
}
