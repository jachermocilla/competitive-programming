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
    ull nact;
    string act, origin;
    ull total,c;

    cin >> T;

    for (t=0;t<T;t++){
        cin >> nact >> origin;
        total=0;
        for (i=0;i<nact;i++){
            cin >> act;
            if (act.compare("CONTEST_WON")==0){
                cin >> c;
                total += (300 + (20-c));
            }
            else if (act.compare("TOP_CONTRIBUTOR")==0){
                total += 300;
            }
            else if (act.compare("BUG_FOUND")==0){
                cin >> c;
                total += c;
            }
            else if (act.compare("CONTEST_HOSTED")==0){
                total+=50;
            }
        }

        if (origin.compare("INDIAN")==0)
            cout << (total/200) << endl;
        else if (origin.compare("NON_INDIAN")==0)
            cout << (total/400) << endl;
    }

    return 0;
}
