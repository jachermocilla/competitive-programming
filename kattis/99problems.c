//https://open.kattis.com/submissions/9240909
#include<stdio.h>
int main(){
	int n,ones,tens,hund,thou,tenthou, temp, left,right;
	scanf("%d",&n);
	ones=(n)%10;
	tens=(n/10)%10;
	hund=(n/100)%10;
	temp=(tens*10+ones);
	if (n<10000)
		right=(n-temp)+99;
	else
		right=9999;

	left = (n-temp-1);
	//printf("%d %d",left,right);

	if (n < 100)
		printf("%d",right);
	else{
		if ((n-left) >= (right-n))
			printf("%d",right);
		else
			printf("%d",left);
	}


	return 0;
}
