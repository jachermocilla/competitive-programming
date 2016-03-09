/**
 * vim: set cindent:
 * author: jachermocilla@gmail.com
 * url: https://www.codechef.com/MARCH16/status/STRPALIN,jachermocilla 
*/

#include <iostream>
#include <sstream>
#include <string>
#include <vector>

using namespace std;

#define ull unsigned long long


int main(){
    ull n,i,j,k,t;
    ull T,N,M;
    string s1, s2;
    vector<string> v1,v2;
    int palin=0;

    cin >> T;

    for (t=0;t<T;t++){
        cin >> s1;
        cin >> s2;

        palin=0;
        for (i=0;i<s1.size();i++){
            for (j=0;j<s2.size();j++){
                //cout << s1[i] << ":" << s2[j] << endl;
                if (s1[i] == s2[j]){
                    palin=1;
                }
            }
        }
        if (palin)
            cout << "Yes" << endl;
        else
            cout << "No" << endl;
    }
    return 0;
}
