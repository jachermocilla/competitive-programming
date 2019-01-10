/**
 * vim: set cindent:
 * author: jachermocilla@gmail.com
 * url: 
*/

#include <iostream>
#include <sstream>

using namespace std;

#define ull unsigned long long
#define MAXLINE 200000



int main(){
    ull n,i,j,k,t,nowinner=1;
    ull T,N,M,a,b,p,f;

    int data[MAXLINE];

    cin >> T;

    for (t=0;t<T;t++){
      cin >> N >> a >> b;
      for (i=0; i< N;i++){
         cin >> data[i];
      }

      nowinner=1; 
      p=0;
      while (nowinner){
         for (i=0; i< N;i++){
            //cout << data[i] << " ";
         }
         //cout << endl;
         if (p==0){
            //cout << "Player: Bob" << endl;
            f=0;
            for (i=0; i< N;i++){
               if ((data[i]!=0)&&((data[i]%a)==0)){
                  //cout << data[i] << endl;
                  data[i] = 0;
                  f=1;
                  //break;
               }
            }
            if (i==N && f==1){
               p=1;
            }
            else if (i==N && f==0){
               cout << "ALICE" << endl;
               nowinner=0;
            }
         }
         else 
         if (p==1){
            //cout << "Player: Alice" << endl;
            f=0;
            for (i=0; i< N;i++){
               if ((data[i]!=0)&&((data[i]%b)==0)){
                  //cout << data[i] << endl;
                  data[i] = 0;
                  f=1;
                  //break;
               }
            }
            if (i==N && f==1){
               p=0;
            }
            else{
               cout << "BOB" << endl;
               nowinner=0;
            }
         }    
      }
    }

    return 0;
}
