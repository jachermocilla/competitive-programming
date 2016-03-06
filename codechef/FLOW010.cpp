/**
 * vim: set cindent:
 * author: jachermocilla@gmail.com
 * url: https://www.codechef.com/status/FLOW010,jachermocilla 
*/

#include <iostream>
#include <sstream>

using namespace std;

#define ull unsigned long long


int main(){
    ull n,i,j,k;
    ull T,N,M;
    char type;

    cin >> T;

    for (i=0;i<T;i++){
        cin >> type;
        switch (type) {
            case 'b':
            case 'B': cout << "BattleShip" << endl; break;
            case 'c':
            case 'C': cout << "Cruiser" << endl; break;
            case 'd':
            case 'D': cout << "Destroyer" << endl; break;
            case 'f':
            case 'F': cout << "Frigate" << endl; break;
        }

    }

    return 0;
}
