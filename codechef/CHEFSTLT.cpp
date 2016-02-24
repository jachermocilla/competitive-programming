/**
 * author: jachermocilla@gmail.com
 * url: https://www.codechef.com/status/CHEFSTLT,jachermocilla
*/

#include <iostream>
#include <sstream>

using namespace std;

#define ull unsigned long long

ull min_difference(string s1,string s2){
    ull i,j,k,l=0;
    ull smaller_len=(s1.size()<s2.size())?s1.size():s2.size();
    for (i=0;i<smaller_len;i++){
        if (s1.at(i)!=s2.at(i)){
            if((s1.at(i)!='?') && (s2.at(i) !='?'))
                l++;
        }
    }
    return l;
}

ull max_difference(string s1,string s2){
    ull i,j,k,l=0;
    ull smaller_len=(s1.size()<s2.size())?s1.size():s2.size();
    for (i=0;i<smaller_len;i++){
        if (s1.at(i)!=s2.at(i)){
            l++;
        }else if((s1.at(i)=='?') && (s2.at(i) =='?')){
            l++;
        }
    }
    return l;
}



int main(){
    ull n,i,j,k;
    ull T,N,M;

    string s1,s2;


    cin >> T;
    for (i=0;i<T;i++){
        cin >> s1;
        cin >> s2;        
        cout << min_difference(s1,s2) << " " << max_difference(s1,s2) << endl;      
    }
    

    return 0;
}
