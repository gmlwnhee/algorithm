public class lengthofLastWord_java_58 {
    public static void main(String[] args) {
        String input = "hello everyone";
        int result = lengthOfLastWord(input);
        System.out.println(result);
    }

    public static int lengthOfLastWord(String s) {
        String[] strArray = s.split(" ");
        return strArray[strArray.length-1].length();
    }
}
