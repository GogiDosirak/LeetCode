class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> start = new HashSet<>();

        for(List<String> list : paths) {
            start.add(list.get(0));
        }

        for(int i = 0; i < paths.size(); i++) {
            for(int j = 0; j < paths.get(0).size(); j++) {
                if(!start.contains(paths.get(i).get(j))) {
                    return paths.get(i).get(j);
                }
            }
        }
        return "good";
    }
}