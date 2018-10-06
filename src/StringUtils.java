public class StringUtils {

    /**
     * makePurdueUsername -- <= 8-letter-long lowercase username creator
     * <p>
     * Usernames may be AT MOST 8 letters in length, and should
     * <p>
     * consist of the first letter of one's first name, and the
     * <p>
     * amount of their last name that will fit into the remaining
     * <p>
     * 7 characters. All should be lowercase.
     * <p>
     * Ex: a = "Sean ", b = "Flannery", returns "sflanner"
     */

    public static String makePurdueUsername(String firstName, String lastName) {

        /* Generate the long version of the name first:

            Ex: firstName = "Sean", lastName = "Flannery"

                    --> res = "SFlannery"

         */

        String res = firstName.substring(0, 1) + lastName;

        /* Shorten the string to 8 characters

            Ex: res = "SFlannery"

                    --> res = "SFlanner"

         */
        if (res.length() > 8) {
            res = res.substring(0, 8);
        }

        /* Convert the name to lower-case

            Ex: res = "SFlanner"

                    --> res = "sflanner"

         */

        res = res.toLowerCase();

        /* return the result of our calculation */

        return res;

    }


    /**
     * replaceStudentUsername -- replace student usernames in sensitive text
     * <p>
     * We want to make sure student information is expunged from sensitive
     * <p>
     * documents as much as possible.
     * <p>
     * Ex: text = "jframes was among the students whose SSNs were leaked.",
     * <p>
     * username = "[DATA EXPUNGED] was among the students whose SSNs were leaked.",
     */

    public static String replaceStudentUsername(String text, String username) {

        String[] textWords = text.split(" ");
        for (int i = 0; i < textWords.length; i++) {
            if (textWords[i].equals(username)) {
                textWords[i] = "[DATA EXPUNGED]";
            } else if (textWords[i].contains(username) && textWords[i].length() == username.length() + 1) {
                textWords[i] = "[DATA EXPUNGED]" + textWords[i].charAt(textWords[i].length() - 1);
            } else if (textWords[i].contains(username)) {
                textWords[i] = "([DATA EXPUNGED]@purdue.edu),";
            }
        }
        text = "";
        for (int i = 0; i < textWords.length; i++) {
            text += textWords[i];
            if (i != textWords.length - 1) {
                text += " ";
            }
        }
        return text;
    }
}
