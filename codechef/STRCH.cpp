/**
 * vim: set cindent:
 * author: jachermocilla@gmail.com
 * url: 
*/

#include <iostream>
#include <sstream>
#include<bits/stdc++.h> 

using namespace std;

#define ull unsigned long long

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
      //cout << "pos:" << pos << endl;

      k=0;

      for (ull len=1; len <= N; len++){
         for (i = 0; i <= N - len; i++){
            j=i+len-1;

            //cout << "start: " << s.at(i) << endl;
            //cout << "end: " << s.at(j) << endl;
            //if ( i <= pos && j >= pos)
            //   k++;
            //else if (s.at(i) == ch || s.at(j) == ch) 
            //   k++;


            int found=0;
            for (m=i;m<=j;m++){ 
               cout << s.at(m);
               if (s.at(m)==ch && !found){
                  k++;
                  found=true;
                  continue;
               }
            }
            cout << endl;

         }
      }
      cout << k << endl;

      
      cout << "----------" << endl;
      //cout << N*(N+1)/2 << endl;
      for (i=1;i<=N;i++){
         k=i;
         cout << (N-k+1) << endl;
      }


   }
   return 0;
}
