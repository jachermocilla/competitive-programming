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
   ull n,i,j,k,t;
   ull T,N,M;
   string s,sub;
   char ch;

   cin >> T;

   for (t=0;t<T;t++){
      cin >> N;
      cin >> s;
      cin >> ch;
            
      if (s.find(ch)==string::npos){
         cout << "0" << endl;
         continue;
      }

      k=0;
      for ( i = 0; i < N; i++)  
         for (ull len = 1; len <= N - i; len++){
            sub=s.substr(i,len);
            //cout << sub << endl;
            if (sub.find(ch)!=string::npos)
               k++;
         }
      

      //cout << N*(N+1)/2 << endl;
      cout << k << endl;
   }

   return 0;
}
