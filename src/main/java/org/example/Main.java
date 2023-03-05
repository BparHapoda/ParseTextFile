package org.example;

import java.io.*;



public class Main {
    public static void main(String[] args) {
createNewTextFile();
      parseText("text1.txt");
    }
    public static void createNewTextFile(){
        File file = new File("text1.txt");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try (
            PrintWriter printWriter=new PrintWriter(new FileWriter(file))) {
            printWriter.write("\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\""+"\n");
            printWriter.write("\"фамилия\":\"Петров\",\"оценка\":\"4\",\"предмет\":\"Информатика\""+"\n");
            printWriter.write("\"фамилия\":\"Сидоров\",\"оценка\":\"3\",\"предмет\":\"Физика\""+"\n");
            printWriter.write("\"фамилия\":\"Хренов\",\"оценка\":\"2\",\"предмет\":\"История\""+"\n");
            printWriter.write("\"фамилия\":\"Рюрикович\",\"оценка\":\"1\",\"предмет\":\"Физкультура\""+"\n");
            printWriter.write("\"фамилия\":\"Романов\",\"оценка\":\"5\",\"предмет\":\"Химия\""+"\n");
            printWriter.write("\"фамилия\":\"Грозный\",\"оценка\":\"4\",\"предмет\":\"Астрономия\""+"\n");
printWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        }
public static void parseText(String name){
    try {
        BufferedReader bufferedReader=new BufferedReader(new FileReader(name));
        String line = bufferedReader.readLine();
        while (line!=null){
            System.out.println(getParseLine(line));
            line = bufferedReader.readLine();
        }

    } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}
public static String getParseLine(String line){
        String [] parse=line.split(",");
        String [] surname =parse[0].split(":");
        String [] ball =parse[1].split(":");
        String [] item =parse[2].split(":");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Студент ");
        stringBuilder.append(trim(surname[1]));
        stringBuilder.append(" получил ");
        stringBuilder.append(trim(ball[1]));
        stringBuilder.append(" по предмету ");
        stringBuilder.append(trim(item[1]));
        return stringBuilder.toString();
}
public static String trim (String string){
        return string.substring(1,string.length()-1);
}
}