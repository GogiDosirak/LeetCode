class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 아나그램의 집합을 return 하는 문제
        // 아나그램 - 순서를 달리해서 같은 문자열로 표현할 수 있는 문자들의 모음
        // ex) bat, tab, abt -> 모두 bat, tab, abt로 표현 가능
        // 1 <= strs.length <= 10^4 -> N^2 버겁다. 하나 문자열 잡고 돌고 돌면서 아나그램인지 확인하면 time out
        
        // 아나그램인지 확인하는 방법 -> map에 넣고 key값이 존재해야하고, 개수도 같아야함, 문자열을 돌면서 O(N) * Map을 만들고 O(L) * 비교 O(1) - 더 빠르다.
        // 또는 정렬을 이용 -> Map에 해당 문자열이 있는지 확인 O(N*LlogL) -> 있다면 넣어주기

        List<List<String>> list = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for(int i = 0; i < strs.length; i++) {
            // String을 정렬하기 위해선 char 배열로 바꾸고 Arrays.sort()로 정렬
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);

            // 포함한다면 아나그램이므로 넣기
            if(map.containsKey(sorted)) {
                map.get(sorted).add(strs[i]);
            } else {
                // 아니라면 새로운 Key값과 배열 생성
                map.put(sorted, new ArrayList<>());
                map.get(sorted).add(strs[i]);            
            }
        }

        for(List<String> ana : map.values()) {
            list.add(ana);
        }

        return list;
    }
}