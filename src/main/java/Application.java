import java.io.IOException;
import java.util.Scanner;

class Application {

    //Вход: "C:/Users/ivanm/IdeaProjects/Testovoe_zadanie_maven/src/main/resources/data.xml"
    //Выход: "C:/Users/ivanm/IdeaProjects/Testovoe_zadanie_maven/src/main/resources/result.csv"

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите входной файл");
        String input = in.nextLine();
        System.out.println("Введите выходной файл");
        String output = in.nextLine();
        try {
            XmlToCsv xmlToCsv = new XmlToCsv("src/main/java/style.xsl");
            xmlToCsv.execute(input, output);
            System.out.println("Операция выполнена успешно");
        } catch (IOException ex) {
            System.out.println("Один из файлов не найден " + ex.getLocalizedMessage());
        } catch (Exception ex) {
            System.out.println("Один из файлов имеет некорректное содержимое " + ex.getLocalizedMessage());
        }
    }
}