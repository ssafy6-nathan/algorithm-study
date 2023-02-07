## 1535. 안녕

- 인사할 때마다 체력↓, 기쁨↑
- 체력 > 0, 기쁨의 최댓값 찾기

``` java
dp = new int[N+1][101];

		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= 100; j++) {
				if(arr[i][0] < j)  // 해당 체력이 소모되는 체력보다 클 때 
					dp[i][j] = Math.max(dp[i-1][j-arr[i][0]]+ arr[i][1], dp[i-1][j]);
				else
					dp[i][j] = dp[i-1][j];
			}
		}
```

</br>

## 2631. 줄세우기

- 순서대로 줄 세우는데 옮겨지는 아이의 최소 횟수
- 3 7 5 2 6 1 4 → 3 7 **4** 5 2 6 1 → 3 4 5 2 6 1 **7** → **1** 3 4 5 2 6 7 → 1 **2** 3 4 5 6 7

```java
int Max = 0;

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < i; j++) {
				if(line[i] > line[j]) 
					dp[i] = Math.max(dp[j]+1, dp[i]);
			}
			Max = Math.max(Max, dp[i]); //최대 정렬 개수
		}
	
	answer = N - Max - 1;
```

| 3    | 7    | 5    | 2    | 6    | 1    | 4    |
| ---- | ---- | ---- | ---- | ---- | ---- | ---- |
| 0    | 1    | 1    | 0    | 2    | 0    | 1    |

</br>

## 1958. LCS3

- 3개의 문자열을 통해 LCS 구하는 문제

- dp 3차원 배열을 통해 구현

- ```
  Str1 : abcdefghijklmn
  Str2 : bdefg
  Str3 : efg
  ```

```java
for(int i = 1; i <= str1.length(); i++) {
    for(int j = 1; j <= str2.length(); j++) {
        for(int k = 1; k <= str3.length(); k++) {
            
            //3개의 문자가 모두 같으면 해당 인덱스 전까지의 dp값 + 1
            if(str1.charAt(i-1) == str2.charAt(j-1) && str2.charAt(j-1) == str3.charAt(k-1))
                dp[i][j][k] = dp[i-1][j-1][k-1]+1;
            
            else //아니면 해당 인덱스 전까지들의 값 중 최댓값
                dp[i][j][k] = Math.max(Math.max(dp[i-1][j][k], dp[i][j-1][k]),dp[i][j][k-1]);
			
        }
	}
}
```

</br>

## 1520. 내리막길

- 숫자가 점점 작아져야 이동 가능
- 이동 시 사방만 가능
- 마지막 지점까지 가는데 이동 가능한 모든 경로의 수 출력

``` java
	for(int i = 0; i < N; i++)
			Arrays.fill(dp[i], -1); //-1로 초기화 => 방문여부를 알기 위해

		answer = dfs(0,0);


	private static int dfs(int r, int c) {

		if(r == N-1 && c == M-1) {
			return 1; //맨 끝까지 온 경우
		}

		if(dp[r][c] > -1) return dp[r][c]; //방문한 적이 있는 곳이면 해당 값 리턴

		dp[r][c] = 0;

		for(int d = 0; d < 4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];

			if(!check(nr, nc)) continue; //맵의 범위를 벗어나면 나가
			
            if(map[r][c] > map[nr][nc]) //내리막길이면 가
				dp[r][c] += dfs(nr, nc);

		}
		return dp[r][c];
	}
```

