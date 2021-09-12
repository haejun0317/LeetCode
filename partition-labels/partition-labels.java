class Solution {
    public List<Integer> partitionLabels(String s) {
        // return 할 arrayList
        List<Integer> ans = new ArrayList();
        
        // 배열 값에 마지막 값 넣기
        // aba 라면 a는 가장 뒤에 있는 순서로 저장 됌
        int[] arr = new int[26];
        for(int i=0; i<s.length(); i++) arr[s.charAt(i)-'a'] = i;
        
        // 현재 순서, 리스트에 저장하고 난 이후 부터 count 순서
        int idx = 0;
        int beforeIdx = 0;
        for(int i=0; i<s.length(); i++){
            // 현재 순서와 해당 알파벳의 가장 뒤에 있는 수를 비교
            idx = Math.max(idx, arr[s.charAt(i)-'a']);
            // 현재 순서가 해당 알파벳의 가장 뒤에 있는 수라면 리스트에 추가
            if(i==idx){
                ans.add(i-beforeIdx+1);
                beforeIdx = i +1;
            }
        }
        
        return ans;
    }
}