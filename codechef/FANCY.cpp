/**
 * vim: set cindent:
 * author: jachermocilla@gmail.com
 * url: https://www.codechef.com/viewsolution/22315229 
*/

#include <iostream>
#include <sstream>

using namespace std;

#define ull unsigned long long


int main(){
   ull n,i,j,k,t;
   ull T,N,M;
   string s1;
   string s2=" not ";   
   string s3="not ";   
   string s4=" not";   

   cin >> T;
   //cout << T;
   getline(cin,s1);
   for (t=0;t<T;t++){
      getline(cin,s1);
      //cout << s1 << "\n";
      if (s1.find(s2) != std::string::npos){
         cout << "Real Fancy" << '\n';
      }
      else if (s1.find(s3) == 0){
         cout << "Real Fancy" << '\n';
      }
      else if (s1.find(s4) == s1.length()-4){
         cout << "Real Fancy" << '\n';
      }
      else{
         cout << "regularly fancy" << '\n';
      }    
   }

   return 0;
}
