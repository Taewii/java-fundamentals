import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.in;

public class p03_Genome {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Pattern pattern = Pattern.compile("^([a-z!@#$?]+)=([0-9]+)+--([0-9]+)<<([a-z]+)$");
        Map<String, Integer> genes = new LinkedHashMap<>();

        String input;
        while (!"Stop!".equals(input = reader.readLine())) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                char[] geneNameChars = matcher.group(1).toCharArray();
                String geneName = removeSymbolsFromName(geneNameChars);
                int lengthOfName = Integer.parseInt(matcher.group(2));
                int countOfGenes = Integer.parseInt(matcher.group(3));
                String organism = matcher.group(4);

                if (geneName.length() != lengthOfName) {
                    continue;
                }

                genes.putIfAbsent(organism, 0);
                genes.put(organism, genes.get(organism) + countOfGenes);
            }
        }

        genes.entrySet().stream().sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
                .forEach(x -> System.out.printf("%s has genome size of %d%n", x.getKey(), x.getValue()));
    }

    private static String removeSymbolsFromName(char[] geneNameChars) {
        StringBuilder geneName = new StringBuilder();
        for (char geneNameChar : geneNameChars) {
            if (Character.isLetter(geneNameChar)) {
                geneName.append(geneNameChar);
            }
        }
        return geneName.toString();
    }
}
