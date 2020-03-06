import java.util.ArrayList;
class TwelveDays {

    private String verse = "On the %s day of Christmas my true love gave to me: ";
    
    private static ArrayList<String> dayNumbers = new ArrayList<String>();
    private static ArrayList<String> phrases = new ArrayList<String>();

    static {
        dayNumbers.add("first");
        dayNumbers.add("second");
        dayNumbers.add("third");
        dayNumbers.add("fourth");
        dayNumbers.add("fifth");
        dayNumbers.add("sixth");
        dayNumbers.add("seventh");
        dayNumbers.add("eighth");
        dayNumbers.add("ninth");
        dayNumbers.add("tenth");
        dayNumbers.add("eleventh");
        dayNumbers.add("twelfth");
        phrases.add("a Partridge in a Pear Tree");
        phrases.add("two Turtle Doves");
        phrases.add("three French Hens");
        phrases.add("four Calling Birds");
        phrases.add("five Gold Rings");
        phrases.add("six Geese-a-Laying");
        phrases.add("seven Swans-a-Swimming");
        phrases.add("eight Maids-a-Milking");
        phrases.add("nine Ladies Dancing");
        phrases.add("ten Lords-a-Leaping");
        phrases.add("eleven Pipers Piping");
        phrases.add("twelve Drummers Drumming");
    }
    
    String buildOpener(int verseNumber) {
        StringBuilder builder = new StringBuilder();
        
        builder.append(String.format(verse, dayNumbers.get(verseNumber)));
        builder.append(phrases.get(verseNumber));

        return builder.toString();
    }

    String verse(int verseNumber) {
        
        StringBuilder builder = new StringBuilder();

        if (verseNumber == 1) {
            builder.append(buildOpener(0));
            builder.append(".\n");
            return builder.toString();
        }

        final int lastVerse = verseNumber - 1;

        builder.append(buildOpener(lastVerse));


        for (int i=lastVerse-1; i>=0; i--) {
            if (i == 0) {
                builder.append(", and ");
            } else {
                builder.append(", ");
            }
            builder.append(phrases.get(i));
        }

        builder.append(".\n");

        return builder.toString();

    }

    String verses(int startVerse, int endVerse) {
        
        StringBuilder builder = new StringBuilder();
        for (int i = startVerse; i <= endVerse; i++) {
            builder.append(verse(i));
            if (i != endVerse) builder.append("\n");
        }
        return builder.toString();
    }
    
    String sing() {
        return verses(1,12);
    }
}
