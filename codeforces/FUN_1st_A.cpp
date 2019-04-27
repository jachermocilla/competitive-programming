/**
 * vim: set cindent:
 * author: jachermocilla@gmail.com
 * url: 
*/

#include <iostream>
#include <sstream>
#include <vector>
#include <algorithm>
#include <iterator>

using namespace std;

#define ull unsigned long long

//note the const
void display_vector(const vector<ull> &v)
{
       std::copy(v.begin(), v.end(),
                     std::ostream_iterator<int>(std::cout, " "));
       cout << endl;
}

int main(){
   ull n,i,j,k,t;
   ull T,N,M;
   ull op,y;
   char x;
   vector<ull> q;

   cin >> T;

   for (t=0;t<T;t++){
      cout << "Case: " << (t+1) << endl;
      q.clear();
      cin >> N;
      for (n=0;n<N;n++){
         //display_vector(q);

         cin >> op;

         //cout << "OP: "<< op << endl;
         switch (op){
            case 1:
               cin >> x >> y;
               if (x=='F')
                  q.insert(q.begin(),y);
               else if (x=='B')
                  q.insert(q.end(),y);
               break;
            case 2:
               cin >> x;
               //cout << x << " here" << endl;
               if (x=='F')
                  q.erase(q.begin());
               else if (x=='B')
                  q.erase(q.end()-1);
               //cout << "there";
               break;
            case 3:
               cin >> x >> y;
               if (x=='D'){
                  //cout << y << "dsad" << endl;
                  cout << q.at(y-1) << endl;
               }
               else if (x=='P'){
                  std::vector<ull>:: iterator it = find(q.begin(), q.end(), y);
                  cout << (std::distance(q.begin(), it)+1);
               }
               break;
         }
         //cout << op << x << y <<endl;


      }


   }

   return 0;
}
