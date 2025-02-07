import java.util.ArrayList;

public class HiddenWord {
    private String hiddenWord;
    private String[] words;

    public HiddenWord() {
        words = new String[]{"Blaze", "Crimp", "Gloom", "Flick", "Stuck", "Crate", "Fable", "Spark", "Mirth", "Blend",
                "Dread", "Plumb", "Wager", "Smear", "Bison", "Crave", "Flake", "Blush", "Creak",
                "Fates", "Gloom", "Mirth", "Prong", "Latch","Flint"};
        hiddenWord = chooseWord(); 
    }

    public String chooseWord() {
        int index = (int) (Math.random() * words.length);
        return words[index].toLowerCase(); 
    }

    public String getHiddenWord() { 
        return hiddenWord;
    }
    
    private ArrayList<Character> printClue(String guess) {
        String results = "";
        ArrayList<Character> usedLetters = new ArrayList<>();
        for (int i = 0; i < guess.length(); i++) {
            char guessChar = guess.charAt(i);
            char hiddenChar = hiddenWord.charAt(i);

            if (guessChar == hiddenChar) {
                results += Character.toUpperCase(guessChar);
                usedLetters.add(Character.toUpperCase(guessChar));
            } else if (hiddenWord.contains(String.valueOf(guessChar))) {
                results += Character.toLowerCase(guessChar);
                usedLetters.add(Character.toLowerCase(guessChar));
            } else {
                results += "_";
                usedLetters.add('_');
            }
        }

        for (int i = 0; i < usedLetters.size(); i++) {
            if (usedLetters.get(i) == '_') {
            continue;
            }
            for (int j = i + 1; j < usedLetters.size(); j++) {
            if (usedLetters.get(i) != '_' && Character.toLowerCase(usedLetters.get(i)) == Character.toLowerCase(usedLetters.get(j))) {
                if (Character.isUpperCase(usedLetters.get(i)) && Character.isLowerCase(usedLetters.get(j))) {
                usedLetters.set(j, '_');
                } else if (Character.isLowerCase(usedLetters.get(i)) && Character.isUpperCase(usedLetters.get(j))) {
                usedLetters.set(i, '_');
                break;
                } else if (Character.isLowerCase(usedLetters.get(i)) && Character.isLowerCase(usedLetters.get(j))) {
                usedLetters.set(j, '_');
                }
            }
            }
        }
        return usedLetters;
    }

    public void getWord(String g) {
        ArrayList<Character> clues = printClue(g);
        for(int i=0; i < clues.size(); i++) {
            System.out.print(clues.get(i) + " ");
        }
        System.out.println();
    }
}
