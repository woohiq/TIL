# 2023-03-29 그래프심화

## 서로소집합 (Disjoint Sets)

make, union, find연산이 있어 union-find집합이라고도 함

- 서로 중복된 원소가 없는 집합
- 하나의 특성 멤버로 구분 : 대표자

### 표현방법

연결리스트

트리

### 연산

Make-Set(x) : x라는 원소를 대표자로 갖는 생성

Find-Set(x) : x의 대표자 탐색

Union(x,y) : x라는 원소를 대표자로 갖는 그룹과 와 y라는 … 를 하나의 그룹으로 만듦

P[] 라는 배열을 만들어서

P[i] 는 i의 부모 노드를 가르킨다고 하면

```java
Make-set(x) {
 P[x] = x ;
}
//x번째 노드는 자기 자신을 부모로 갖게 해서 만듬
Find-set(x) {
 if (x==p[x]) return x ;
 else return Find-set(p[x]) ;
}
//자기자신이 부모면 자기자신은 대표자
//그렇지 않다면 자기 자신의 부모를 계속해서 호출해 나가서 대표자 찾기
Union(x, y) {
 P[find-set(y)] = find-set(x) ;
}
//y의 대표자를 x의 대표자로 선정, 
//즉, x그룹을 부모로 y그룹을 자식으로 더함
```

문제 : find-set연산은 최대 O(N)의 시간이 걸린다 ( 직선으로 연결된 경우 )

해결법 : Rank를 이용한 Union, Path compression

- Rank를 이용한 Union : 각 노드는 자신을 루트로 하는 subtree의 높이를 rank로 저장 rank가 낮은 집합을 rank가 높은 집합에 붙임
- 모든 node들이 대표자를 가리키도록 바꿈

그럼 위 두 방법을 쓴다면 위의 세 개의 연산은

```java
Make-set(x) {
 P[x] = x ;
 rank[x] = 0;
}
Find-set(x) {
 if (x==p[x]) return x ;
 else p[x] = Find-set(p[x]) ;
 return p[x];
}
Union(x, y) {
 if (rank[Find-set(x)] > rank[Find-set(y)] p[Find-set(y)] = Find-set(x);
 else {
	p[Find-set(x)] = Find-set(y);
	rank[Find-set(y)] = Math.max(rank[Find-set(x)]+1, rank[Find-set(y)]);
	}
}
```

## 최소 비용 신장 트리 Minimum Spanning Tree

### 신장 트리

그래프의 모든 정점과 간선의 부분 집합으로 구성되는 트리

### 최소 신장 트리

- 무방향 가중치 그래프
- 그 중에서 간선들의 가중치의 합이 최소
- N개의 정점을 가지는 그래프에 대해서 N-1개의 간선을 이용
- 사이클 포함 X
- `Kruskal` `Prim` 의 방법등이 있음

## 크루스칼 알고리즘

간선을 하나씩 선택해서 MST를 찾는 알고리즘

1. 모든 간선을 가중치에 따라서 오름차순으로 정렬
2. 가중치가 낮은 간선부터 선택하면서 트리를 증가 사이클이 존재한다면, 다음 가중치의 간선으로 넘어감
3. N-1개 간선이 선택될 때 까지 반복

사이클 판단은 위에서 Find-set을 해서 부모가 같다면 : 같은그룹이므로 사이클