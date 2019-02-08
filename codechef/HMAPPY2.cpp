/**
 * vim: set cindent:
 * author: jachermocilla@gmail.com
 * url: https://www.codechef.com/viewsolution/22962675 
*/

#include <iostream>
#include <sstream>

using namespace std;

#define ull unsigned long long

int gcd(ull a, ull b){  
   // do until the two numbers become equal
   while (a != b){
      // replace larger number by its difference with the smaller number
      if (a > b)
         a = a - b;
      else
         b = b - a; 
   }
   return a;      // or b (since both are equal)
} 
  
   
// Function to return LCM of two numbers  
int lcm(ull a, ull b){  
   return (a*b)/gcd(a, b);  
}  


int main(){
    ull n,i,j,k,t;
    ull T,N,M,A,B,K;
    ull nA,nB;

    cin >> T;

    for (t=0;t<T;t++){
      nA=0;
      nB=0;

      cin >> N >> A >> B >> K;
      //cout << N << A << B << K << endl;      

      M=(N/A)+(N/B)-2*(N/lcm(A,B));
      //cout << M << endl;
      if (M >= K)
         cout << "Win" << endl;
      else
         cout << "Lose" << endl;

/*
      for (i=1;i<=N;i++){
         if ((i%A)==0){
            if ((i%B)!=0){
               nA++;
               //cout << i << " A" << endl;
            }
         }
         
         if ((i%B)==0){
            if ((i%A)!=0){
               nB++;
               //cout << i << " B" << endl;;
            }
         }
      }
      if (nA+nB >= K)
         cout << "Win" << endl;
      else
         cout << "Lose" << endl;
*/
    }
    return 0;
}
