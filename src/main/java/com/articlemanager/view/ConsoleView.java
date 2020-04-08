package com.articlemanager.view;

import com.articlemanager.controller.ArticleController;
import com.articlemanager.entity.Article;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleView {
    private Scanner scanner = new Scanner(System.in);
    private ArticleController controller = new ArticleController();

    public void generateMenu() {
        while (true) {
            System.out.println("------------Article Management-----------");
            System.out.println("1. Tạo mới thông tin article.");
            System.out.println("2. In danh sách article.");
            System.out.println("3. Thoát chương trình.");
            System.out.println("-------------------------------------");
            System.out.println("Vui lòng nhập lựa chọn của bạn (1 đến 3) : ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    Article article = controller.create();
                    if(article == null){
                        System.out.println("Thao tác thất bại.");
                    }else{
                        System.out.println("Thao tác thành công.");
                    }
                    break;
                case 2:
                    ArrayList<Article> list = controller.getList();
                    printList(list);
                    break;
                case 3:
                    System.out.println("Thoát chương trình. Hẹn lại bạn sau!");
                    break;
                default:
                    System.out.println("Vui lòng lựa chọn trong khoảng từ 1 đến 3.");
                    break;
            }
            if (choice == 3) {
                break;
            }
        }
    }

    public void printList(ArrayList<Article> listGame) {
        if (listGame.size() == 0) {
            System.out.println("Hiện tại không có Chó trong danh sách.");
            return;
        }
        System.out.println("------------------------------------------------------------Danh sách các article----------------------------------------------------");
        System.out.printf("%5s %20s %5s %s %5s %20s %5s %s %5s %20s %5s %s %5s %20s %5s %s %5s %20s %5s %s %5s %20s %5s\n"
                , "", "id", "", "|"
                , "", "Title", "", "|"
                , "", "Description", "", "|"
                , "", "Content", "", " | "
                , "", "DayWrite", "", " | "
                , "", "Status", "");
        for (int i = 0; i < listGame.size(); i++) {
            System.out.printf("%5s %20d %5s %s %5s %20s %5s %s %5s %20s %5s %s %5s %20s %5s %s %5s %20s %5s %s %5s %20s %5s\n"
                    , "", listGame.get(i).getId(), "", "|"
                    , "", listGame.get(i).getTitle(), "", "|"
                    , "", listGame.get(i).getDescription(), "", "|"
                    , "", listGame.get(i).getContent(), "", "|"
                    , "", listGame.get(i).getDayWrite(), "", "|"
                    , "", listGame.get(i).getStatusInString(), "");
        }
    }
}
