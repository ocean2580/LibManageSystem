package book.manage;
import book.manage.entity.Book;
import book.manage.entity.Student;
import book.manage.sql.SqlUtil;
import lombok.extern.java.Log;
import org.apache.ibatis.io.Resources;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.LogManager;

@Log
public class Main {
    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            LogManager manager = LogManager.getLogManager();
            manager.readConfiguration(Resources.getResourceAsStream("logging.properties"));

            while (true) {
                System.out.println("=============================");
                System.out.println("1.录入学生信息");
                System.out.println("2.录入书籍信息");
                System.out.print("输入操作（其他数字退出）");
                int input;
                try {
                    input = scanner.nextInt();

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                scanner.nextLine();
                switch (input) {
                    case 1 :
                        addStudent(scanner);
                        break;
                    case 2 :
                        addBook(scanner);
                        break;
                    default:
                        return;
                }
            }
        }
    }

    private static void addStudent(Scanner scanner) {
        System.out.print("名字");
        String name = scanner.nextLine();
        System.out.print("性别（男/女）");
        String sex = scanner.nextLine();
        System.out.print("年级");
        String grade = scanner.nextLine();
        int g = Integer.parseInt(grade);
        Student student = new Student(null, name, sex, g);
        // lambda
        SqlUtil.doSqlWork(mapper -> {
            int i = mapper.addStudent(student);
            if (i>0) {
                System.out.println("信息录入成功！！！");
                log.info("新添加了一条学生信息："+student);
            } else {
                System.out.println("信息录入失败！");
            }
        });
    }

    private static void addBook(Scanner scanner) {
        System.out.print("标题");
        String title = scanner.nextLine();
        System.out.print("介绍");
        String desc = scanner.nextLine();
        System.out.print("价格");
        String price = scanner.nextLine();
        Double p = Double.parseDouble(price);
        Book book = new Book(null, title, desc, p);
        // lambda
        SqlUtil.doSqlWork(mapper -> {
            int i = mapper.addBook(book);
            if (i>0) {
                System.out.println("信息录入成功！！！");
                log.info("新添加了一条书籍信息："+book);
            } else {
                System.out.println("信息录入失败！");
            }
        });
    }
}
