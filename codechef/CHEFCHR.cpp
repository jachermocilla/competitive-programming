/**
 * vim: set cindent:
 * author: jachermocilla@gmail.com
 * url: https://www.codechef.com/viewsolution/17328497 
 * source: https://codereview.stackexchange.com/questions/29611/finding-the-number-of-occurrences-of-a-string-in-another-string?rq=1
*/

#include <iostream>
#include <sstream>

using namespace std;

#define ull unsigned long long

int key_search(const std::string& s, const std::string& key)
{
       int count = 0;
           size_t pos=0;
               while ((pos = s.find(key, pos)) != std::string::npos) {
                          ++count;
                                  ++pos;
                                      }
                   return count;
}


int main(){
    ull n,i,j,k,t;
    ull T,N,M;
    string line;      

    char perm[24][5]={
                        "chef","chfe","cehf","cefh","cfhe","cfeh",
                        "hcfe","hcef","hefc","hecf","hfec","hfce",
                        "echf","ecfh","ehcf","ehfc","efch","efhc",
                        "fceh","fche","fhec","fhce","fehc","fech" 
                     };

    cin >> T;

    for (t=0;t<T;t++){
      cin >> line;
      k=0;
      for (i=0;i<24;i++){
         k+=key_search(line,perm[i]);
 /*
         size_t found=line.find(perm[i]);
         if (found != string::npos){
            //cout << "Found:" << perm[i] << endl;
            k++;
         }
*/
      }
      if (k > 0)
         cout << "lovely " << k << endl;
      else
         cout << "normal" << endl;;
      //cout << line << endl;    
    }

    return 0;
}
