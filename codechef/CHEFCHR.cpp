/**
 * vim: set cindent:
 * author: jachermocilla@gmail.com
 * url: 
*/

#include <iostream>
#include <sstream>

using namespace std;

#define ull unsigned long long


int main(){
    ull n,i,j,k,t;
    ull T,N,M;
    string line;      

    char perm[24][5]={ "chef","hcef","echf","cehf","hecf","ehcf",
                     "ehfc","hefc","fehc","efhc","hfec","fhec",
                     "fceh","cfeh","efch","fech","cefh","ecfh",
                     "hcfe","chfe","fhce","hfce","cfhe","fche"    };

    cin >> T;

    for (t=0;t<T;t++){
      cin >> line;
      k=0;
      for (i=0;i<24;i++){
         size_t found=line.find(perm[i]);
         if (found != string::npos){
            //cout << "Found:" << perm[i] << endl;
            k++;
         }
      }
      if (k > 0)
         cout << "lovely " << k << endl;
      else
         cout << "normal" << endl;;
      //cout << line << endl;    
    }

    return 0;
}
