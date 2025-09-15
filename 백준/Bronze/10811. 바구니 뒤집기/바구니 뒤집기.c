#include <stdio.h>

int main() {
	int N, M, tmp;
	int i, j;
	int map[100] = {0, };

	scanf("%d %d", &N, &M);
	for (int a = 1; a <= N; a++)
    {
		map[a] = a;
	}
	for (int a = 0; a < M; a++)
    {
		scanf("%d %d", &i, &j);
		for (int b = 0 ; b < (j-i+1)/2; b++)
        {
			tmp = map[i + b];
			map[i + b] = map[j - b];
			map[j - b] = tmp;
		}
	}
	for (int a = 1; a <= N; a++)
    {
        printf("%d ", map[a]);
    }
    
	return 0;
}