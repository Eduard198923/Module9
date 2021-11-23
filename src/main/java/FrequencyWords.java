


import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FrequencyWords {

    public Map<String, Integer> frequencyWords(String file){
        Map<String, Integer> frequency = new HashMap<>();
        List<String> words = new ArrayList<>();
        try (FileReader reader = new FileReader(file)) {
            Scanner scanner = new Scanner(reader);
            while(scanner.hasNext()) {
                String[] temp = scanner.nextLine().split(" ");
                words.addAll(List.of(temp));
            }
            for(String s : words){
                if(frequency.get(s) == null){
                    frequency.put(s, 1);
                } else {
                    int counter = frequency.get(s)+1;
                    frequency.put(s, counter);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return frequency;
    }

    public void sortOut(Map map){
        Map<String, Integer> frequency;
        map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).forEach(System.out::println);
    }

}

class FrequencyWordsTest{
    public static void main(String[] args) {
        FrequencyWords wc = new FrequencyWords();
        wc.sortOut(wc.frequencyWords("words.txt"));
    }
}

