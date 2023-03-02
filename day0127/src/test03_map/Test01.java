package test03_map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Test01 {
	public static void main(String[] args) {
		// Map
		// 사전과 같은 자료구조
		// key , value 쌍으로 저장
		// 키로 구별
		//Map<String, String> map = new HashMap<>();
		Map<String, String> map = new TreeMap<>();
		
		map.put("Hong","010-2222-2222");
		map.put("Yang","010-3333-3333");
		map.put("Lee","010-4444-4444");
		map.put("Lee","010-4444-5555"); // 중복되면 값이 대체됨
		System.out.println(map);
		
		// 값을 가져오기
		System.out.println(map.get("Lee"));
		System.out.println(map.get("L35325ee"));
		
		System.out.println(map.containsKey("Lee"));
		System.out.println(map.containsValue("010-3333-3333"));
		
		for (Map.Entry<String, String> entry: map.entrySet()) {
			System.out.println(entry.getKey()+" : "+entry.getValue());
		}
		
		Iterator<String> e = map.keySet().iterator();
		while(e.hasNext()) {
			String ket = e.next();
			System.out.printf("키 : %s, 값: %s \n", ket, map.get(ket));
		}
		
		for (String key : map.keySet()) {
			System.out.println(map.get(key));
		}
	}
}
