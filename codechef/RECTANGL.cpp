/**
 * vim: set cindent:
 * author: jachermocilla@gmail.com
 * url: https://www.codechef.com/JAN18/status/RECTANGL,jachermocilla 
*/

#include <iostream>
#include <sstream>

using namespace std;

#define ull unsigned long long


int main(){
    ull n,i,j,k,t;
    ull T,N,M;
    int sides[4];
    int found[4];

    cin >> T;

    for (t=0;t<T;t++){
      cin >> sides[0] >> sides[1] >> sides[2] >> sides[3];
      //cout << sides[0] << sides[1] << sides[2] << sides[3] << endl;
      
      for (i=0;i<4;i++)
         found[i]=0;
      
      for (i=0;i<4;i++){
         for (j=0;j<4;j++){
            if (i!=j){
               //cout << sides[i] << " " << sides[j];
               if ((found[i]==0) && (found[j]==0)){
                  if (sides[i]==sides[j]){
                     //cout << "match found" << endl;
                     found[i]=1;
                     found[j]=1;
                  }
               }
               //cout << endl;
            }     
         }
      }
      if ((found[0]+found[1]+found[2]+found[3]) == 4)
         cout << "YES" << endl;
      else
         cout << "NO" << endl;
    }

    return 0;
}
