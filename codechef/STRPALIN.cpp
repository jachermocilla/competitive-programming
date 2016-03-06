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

void all_substrings(string s,int start,int end, vector<string> &v){
    if ((start==s.size()) && (end==s.size())){
        return;
    }else{
        if (end == s.size()+1){
            all_substrings(s,start+1,start+1,v);
        }else{
            //cout << s.substr(start,end-start) << endl;
            if (s.substr(start,end-start) != "\0")
                v.push_back(s.substr(start,end-start));
            all_substrings(s,start,end+1,v);
        }
    }

}


int main(){
    ull n,i,j,k;
    ull T,N,M;
    string s1, s2;
    vector<string> v1,v2;
    int palin=0;

    cin >> T;

    for (k=0;k<T;k++){
        cin >> s1;
        cin >> s2;

        v1.clear();
        v2.clear();

        //cout << s1 << endl;
        //cout << s2 << endl;
        all_substrings(s1,0,1,v1);
        all_substrings(s2,0,1,v2);

        palin=0;
        for (i=0;i<v1.size();i++){
            for (j=0;j<v2.size();j++){
                s1 = v1[i] + v2[j];
                if (s1 == string(s1.rbegin(), s1.rend())) {
                    //cout << s1 << endl ;
                    palin++;
                }
            }
        }
        
        for (i=0;i<v2.size();i++){
            for (j=0;j<v1.size();j++){
                s1 = v2[i] + v1[j];
                if (s1 == string(s1.rbegin(), s1.rend())) {
                    //cout << s1 << endl ;
                    palin++;
                }
            }
        }
        
        if (palin>0)
            cout << "Yes" << endl;
        else 
            cout << "No" << endl;
        palin=0;
    }

    return 0;
}
