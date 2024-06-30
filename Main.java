import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scr = new Scanner(System.in);
        String str = scr.nextLine();
        char action;
        String[] data;
        if (str.contains(" + ")) {
            data = str.split(" \\+ ");
            action = '+';
        } else if (str.contains(" - ")) {
            data = str.split(" - ");
            action = '-';
        } else if (str.contains(" * ")) {
            data = str.split(" \\* ");
            action = '*';
        } else if (str.contains(" / ")) {
            data = str.split(" / ");
            action = '/';
        } else {
            throw new Exception("Input + - * /");
        }

        if (action == '*' || action == '/') {
            if (data[1].contains("\"")) {
                throw new Exception("Action second for only number.");
            }
        }
        for (int i = 0; i < data.length; i++) {

            data[i] = data[i].replace("\"", "");
        }
        if (action == '+') {
            printSum(data[0] + data[1]);
        } else if (action == '-') {
            int index = data[0].indexOf(data[1]);
            if (index == -1) {
                printSum(data[0]);
            } else {
                String result = data[0].substring(0, index);
                result += data[0].substring(index + data[1].length());
                printSum(result);
            }
        } else if (action == '*') {
            int multy = Integer.parseInt(data[1]);
            String result = "";
            for (int i = 0; i < multy; i++) {
                result += data[0];
            }
            printSum(result);
        }else{
            int newLen = data[0].length()/Integer.parseInt(data[1]);
            String result = data[0].substring(0,newLen);
            printSum(result);
        }


    } static void printSum(String text) {
        System.out.println("\""+text+"\"");

    }
}


