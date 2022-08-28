import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/** Программа имитирует работу банкомата.  Возможные операции: проверка баланса, внесение,
 снятие сумм, просмотр информации о счёте, просмотр лога операций проведённых со счётом */


public class Bank {


    // Создание массива аккаунтов
    private static Account[] account = new Account[10];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int accountNumber = 0;
        Random random = new Random();

        //Создание случайных сумм на счету
        for (int i = 0; i < 10; i++) {
            account[i] = new Account();
            account[i].setId(i);
            account[i].setBalance(random.nextInt(100000) / 100.0);
        }

        //Создаётся Список логов для каждого счёта
        ArrayList<BackLog> backLogs = new ArrayList<>();
        //Создаётся лог для счёта с id 0
        BackLog backLog = new BackLog();
        backLog.setId(0);
        backLogs.add(backLog);

        // Ветвящийся алгоритм управления

        while (true) { //Бесконечный цикл

            System.out.println("Введите ID счёта от 0 до " + (account.length - 1) + ". Введите -1, для завершения программы");

            accountNumber = input.nextInt();

            if (accountNumber == -1) {
                System.out.println("Остановлено");
                break;
            }
            // Проверка, что ID входит в диапазон значений
            if (accountNumber < 0 || accountNumber > account.length - 1) {
                System.out.println("Введите, пожалуйста, корректный id");
                continue;
            }

            //Условие создания нового Экземпляра в списке логов.
            // Если Id обрабатываемого счёта меньше существующего количества логов, то создаётся необходимое количество логов
            if (accountNumber >= backLogs.size()) {
                int k = backLogs.size() - accountNumber;
                for (int j = accountNumber; j >= k; j--) {
                    BackLog backLogNew = new BackLog(accountNumber);
                    backLogNew.setId(accountNumber);
                    backLogs.add(backLogNew);
                }
            }

                /* Введите номер функции программы
                1. Проверить баланс
                2. Внесение суммы на счёт
                3. Снятие суммы со счёта
                4. Вывод всей информации о счёте
                5. Выход
                 */

            int menuNumber;
            do {

                System.out.println(" Текущий счёт ID  " + accountNumber + "\n Введите номер функции программы \n"
                        + "1. Проверить баланс \n"
                        + "2. Внесение суммы на счёт \n"
                        + "3. Снятие суммы со счёта \n"
                        + "4. Вывод всей информации о счёте\n"
                        + "5. Показать историю операций \n"
                        + "6. Выход \n");

                menuNumber = input.nextInt();
                System.out.println(" Текущий счёт ID  " + accountNumber);
                if (menuNumber == 1) {
                    System.out.println("Баланс " + account[accountNumber].getBalance());
                    backLogs.get(accountNumber).setInLog("\t \t" + getDate() + "\t \t" + "Запрос баланса         " );
                } else if (menuNumber == 2) {
                    System.out.println("Укажите сумму, которую хотите внести ");
                    double amount = input.nextDouble();
                    account[accountNumber].deposit(amount);
                    backLogs.get(accountNumber).setInLog("\t \t" + getDate() + "\t \t" + "На счёт внесена сумма  " + amount  );
                } else if (menuNumber == 3) {
                    System.out.println("Укажите сумму, которую хотите снять ");
                    double amount1 = input.nextDouble();
                    account[accountNumber].withdraw(amount1);
                    backLogs.get(accountNumber).setInLog("\t \t" + getDate() + "\t \t" + "Со счёта списана сумма " + amount1);
                } else if (menuNumber == 4) {
                    System.out.println("Информация о счёте ");
                    account[accountNumber].printAccount1();

                } else if (menuNumber == 5) {
                    backLogs.get(accountNumber).printLog();

                } else if (menuNumber == 6) {
                    System.out.println("Приходите ещё!!!");
                }
                System.out.println();
            }
            while (menuNumber < 6);
        }
    }

    static Date getDate() {
        Date dateOfOperation = new Date();
        return dateOfOperation;
    }
}
