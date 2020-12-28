package vtb.baranovdv;
//Написать программу, которая будет считывать документы (акты и договора) с консоли, сохранять их в массив и выводить конкретный документ по запросу:
// 1) Предусмотреть ввод информации: количество считываемых документов, для каждого документа - тип и необходимую информацию.
// 2) Документы хранить в общем массиве (Подумать про использование полиморфизма)
// 3) Предусмотреть вывод конкретного i-го документа на консоль. Для этого написать перегрузку метода toString().

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] agrs) {
        Scanner dogovorCount = new Scanner(System.in);
        System.out.println("Введите количество договоров:");
        int sizeDogovor = dogovorCount.nextInt();

        Scanner actCount = new Scanner(System.in);
        System.out.println("Введите количество актов:");
        int sizeAct = actCount.nextInt();

        String[][] dogovory = new String[sizeDogovor + sizeAct][2];

        Scanner in = new Scanner(System.in);

        for (int i = 0; i < sizeDogovor; i++) {
            System.out.print("Введите название " + (i + 1) + "-го договора: ");
            dogovory[i][1] = in.nextLine();
            dogovory[i][0] = "Договор";
        }
        int k = 0;
        for (int j = sizeDogovor; j < sizeDogovor + sizeAct; j++) {
            System.out.print("Введите название " + (k + 1) + "-го акта: ");
            dogovory[j][1] = in.nextLine();
            dogovory[j][0] = "Акт";
            k++;
        }
        System.out.println(Arrays.deepToString(dogovory));

        Scanner docNumber = new Scanner(System.in);
        System.out.println("Введите номер документа для просмотра:");
        int nomer = docNumber.nextInt();

        if(nomer <= (sizeDogovor + sizeAct) && nomer >= 0)
            System.out.println(dogovory[nomer-1][0] + " " + dogovory[nomer-1][1]);
        else {
            System.out.println("Введен несуществующий тип документа или номер");
        }

    }
}