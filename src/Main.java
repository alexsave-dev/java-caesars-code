/** The class to display decoded strings for the input string encoded by the Caesar's code*/
public class Main {

    private static char[] alphabet = new char[]{'а', 'б', 'в', 'г', 'д', 'е', 'ё','ж', 'з', 'и', 'й', 'к', 'л',
        'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я'};

    private static int findCharPositionInArray(char symbol) {
        symbol = String.valueOf(symbol).toLowerCase().charAt(0);
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == symbol) {
                return i;
            }
        }
        return -1;
    }

    private static boolean isUpperCase(char symbol) {
        return symbol == String.valueOf(symbol).toUpperCase().charAt(0);
    }

    private static void decodeString(String encodedString) {
        if (encodedString == null || encodedString.length() == 0) {
            System.out.println("Incorrect string value.");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int key = 0;
        while(++key <= alphabet.length) {
            for (int i = 0; i < encodedString.length(); i++) {
                int encodedCharPosition = findCharPositionInArray(encodedString.charAt(i));
                if (encodedCharPosition >= 0) {
                    int decodedCharPosition = encodedCharPosition + key;
                    if (decodedCharPosition >= alphabet.length) {
                        decodedCharPosition -= alphabet.length;
                    }
                    if (isUpperCase(encodedString.charAt(i))) {
                        stringBuilder.append(String.valueOf(alphabet[decodedCharPosition]).toUpperCase());
                    } else {
                        stringBuilder.append(alphabet[decodedCharPosition]);
                    }
                } else {
                    stringBuilder.append(encodedString, i, i+1);
                }
            }
            System.out.println("Key = " + key + " " + stringBuilder.toString());
            stringBuilder.delete(0,stringBuilder.toString().length());
        }
    }

    public static void main(String[] args) {
        decodeString("Еъёчхф Вхзёюлх, адздёиу ф ждэщхб, црбх еёдюэчъщъгюъв южаижжзчх, ждчъёнъгжзчдв. Ъы зёюивй жёхчгюв бюнс ж ъы вдгивъгзхбсгрв аёхкдв. Зъеъёс вгъ дмъчющгд, мзд гъюэцъьгджзс тздшд аёхкх фчбфъзжф жбъщжзчюъв гъждчъёнъгжзчх мъбдчъмъжадшд югщючющиивх. Ф юэимюб чхни южздёюу ю чгыж юэвъгъгюф, здмгъъ дзёхэюч еджздфггиу юэвъгмючджзс мъбдчъмъжаюк едёдадч. Ю зъв гъ въгъъ, еджбъщдчхбх гъищхмх. Ф еёюнъб а чрчдщи, мзд чюгдя чжъви вдя югзъббъаз, х чдэвдьгд, вды мёъэвъёгдъ жзёъвбъгюъ ад чжъви шхёвдгюмгдви. Гхязю ёънъгюъ вгъ едвдшбх еёдшёхввх югзиюзючгдшд зюех, жеълюхбсгд ждэщхггхф щбф юэимъгюф деёъщъбъггрк жздёдг мъбдчъмъжадя щиню. Въгф вдьгд гхэчхзс дзлдв Вхзёюлр, х ъы, цъэ еёъичъбюмъгюф, вхзъёсу.");
    }

}
