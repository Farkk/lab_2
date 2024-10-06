import java.util.Scanner;

public class Main {
    private static Main instance;

    private int choice;
    private int consoleWidth;
    private String text;
    private int operation;
    
    ////dfgdfgfdgdf

    private Main() {
        // Приватный конструктор
    }

    public static Main getInstance() {
        if (instance == null) {
            instance = new Main();
        }
        return instance;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public void setConsoleWidth(int consoleWidth) {
        this.consoleWidth = consoleWidth;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        // Проверяем, все ли поля установлены
        if (choice == 0) {
            while (choice == 0) {
                System.out.println("Выберите вариант \n1)Работа с символами\n2)Работа со строками");
                String choiceStr = scanner.nextLine();
                choice = selectionOfOperation(choiceStr);
            }
        }

        if (consoleWidth == 0) {
            while (consoleWidth == 0) {
                System.out.print("Введите ширину консоли: ");
                String consoleWidthStr = scanner.nextLine();
                try {
                    consoleWidth = Integer.parseInt(consoleWidthStr);
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка, вы ввели не число. Попробуйте снова!");
                }
            }
        }

        if (text == null) {
            System.out.println("Введите текст:");
            text = scanner.nextLine();
        }

        if (operation == 0) {
            while (operation == 0) {
                System.out.println("Выберите операцию \n1)Определение количества символов\n2)Определение количества строк");
                String operationStr = scanner.nextLine();
                operation = selectionOfOperation(operationStr);
            }
        }

        // Выполняем основную логику только если все поля установлены
        if (choice != 0 && consoleWidth != 0 && text != null && operation != 0) {
            if (choice == 1) {
                FindingCountRowsToOutConsole ConsoleManager = new FindingCountRowsToOutConsole();

                switch (operation) {
                    case 1:
                        int charsToFillLastLine = ConsoleManager.calculateCharsToFillLastLine(consoleWidth, text);

                        System.out.println("Текст построчно:");
                        printTextLineByLine(text, consoleWidth);

                        System.out.println("Количество символов для заполнения последней строки: " + charsToFillLastLine);
                        break;
                    case 2:
                        int countLines = ConsoleManager.calculateRowsToOutConsole(text, consoleWidth);
                        System.out.println("Текст построчно:");
                        printTextLineByLine(text, consoleWidth);

                        System.out.println("Количество строк для вывода: " + countLines);
                        break;
                }

            } else if (choice == 2) {
                FindingCountSymbolOnLastRows ConsoleManager = new FindingCountSymbolOnLastRows();

                switch (operation) {
                    case 1:
                        int charsToFillLastLine = ConsoleManager.calculateCharsToFillLastLine(consoleWidth, text);

                        System.out.println("Текст построчно:");
                        printTextLineByLine(text, consoleWidth);

                        System.out.println("Количество символов на последней строке: " + charsToFillLastLine);
                        break;
                    case 2:
                        int countLines = ConsoleManager.calculateRowsToOutConsole(text, consoleWidth);

                        System.out.println("Текст построчно:");
                        printTextLineByLine(text, consoleWidth);

                        System.out.println("Количество строк для вывода: " + countLines);
                        break;
                }
            }
        } else {
            System.out.println("Ошибка: Не все поля установлены. Пожалуйста, установите значения для всех полей.");
        }
    }

    private static void printTextLineByLine(String text, int consoleWidth) {
        while (!text.isEmpty()) {
            String line = text.substring(0, Math.min(consoleWidth, text.length()));
            System.out.println(line.trim());
            text = text.substring(line.length());
        }
    }

    private static int selectionOfOperation(String operationStr) {
        int operation;
        try {
            operation = Integer.parseInt(operationStr);
            if (operation == 1 || operation == 2) return operation;
            else System.out.println("Неверный выбор. Введите число 1 или 2.");
        } catch (NumberFormatException e) {
            System.out.println("Неверный выбор. Введите число 1 или 2.");
        }
        return 0;
    }

    public static void main(String[] args) {
        Main main = Main.getInstance();

        // Создаем первый экземпляр и устанавливаем значение его поля
        FindingCountCharactersToFillConsole firstInstance = new FindingCountCharactersToFillConsole();
        firstInstance.setConsoleWidth(100); // Устанавливаем ширину консоли для первого экземпляра

        // Создаем второй экземпляр без установки значения его поля
        FindingCountCharactersToFillConsole secondInstance = new FindingCountCharactersToFillConsole();

        // Проверяем, что значение поля второго экземпляра соответствует значению поля первого экземпляра
        System.out.println("Ширина консоли второго экземпляра: " + secondInstance.getConsoleWidth());
        System.out.println("Ширина консоли первого экземпляра: " + firstInstance.getConsoleWidth());

        // Устанавливаем значения через сеттеры
        main.setChoice(1);
        main.setConsoleWidth(80);
        main.setText("Метод определения количества символов необходимого для полного заполнения последней строки консоли. Ширина консоли задается пользователем в виде числа влезающих символов. Вывести текст построчно.");
        main.setOperation(1);

        // Запускаем основную логику
        main.run();
    }
}
