package Algorithm;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class 요세푸스 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

		// 사람의 수 N
		// K번째마다 사람을 없앨 것
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

		// K번째에 도달했는지 셀 cnt
        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        StringBuffer sb = new StringBuffer();
        for(int i = 1; i<=N; i++) q.offer(i);
        while(!(q.isEmpty())){
            int tmp = q.poll();
            if (++cnt == K) {sb.append(tmp).append(" "); cnt=0; continue;}
            else q.offer(tmp);
        }
        System.out.println(sb);
    }
}