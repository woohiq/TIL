package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_1206 {
	public static void main(String[] args) throws Exception {
		
		// ����� ���� ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// testcase : 10ȸ
		for (int i = 0; i<10; i++) {
			
			// N : �� �׽�Ʈ���̽��� ���� �Է��� ����
			// buildings : N��ŭ�� ���Ҹ� �����Ҽ� �ִ� �迭, ������ ���� ������ ��� ����
			// cnt : ������ ����ϱ� ���� ����
			int N = Integer.parseInt(br.readLine());
			int[] buildings = new int[N];
			int cnt = 0;
			
			// buildings �迭�� ���� �Է¹ޱ�
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j<N; j++) {
				buildings[j] = Integer.parseInt(st.nextToken());
			}
			
			// �� ���� �� �ڸ��� 0�̹Ƿ� j�� 2���� N-2������ Ȯ��
			// ������ 4������ ũ���
			// (�ڽ��� ũ��) (������ 4���� ���� ���� ���� ũ��) �� ��
			// �ڽ��� ���� ũ�ٸ� �� ���̸� cnt�� �߰�
			for (int j = 2; j<N-2; j++) {
				int max = Math.max(buildings[j-2], buildings[j-1]);
				max = Math.max(max, buildings[j+1]);
				max = Math.max(max, buildings[j+2]);
				if (buildings[j] > max) cnt += buildings[j]-max;
			}
			// ��� ���
			bw.append("#"+(i+1)+" "+cnt+"\n");
		}
		bw.flush();
	}
}
