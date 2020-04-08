package com.articlemanager.controller;

import com.articlemanager.entity.Article;
import com.articlemanager.model.ArticleModel;

import java.util.ArrayList;
import java.util.Scanner;

public class ArticleController {

    private Scanner scanner = new Scanner(System.in);
    private ArticleModel model = new ArticleModel();

    public Article create() {
        try {
            System.out.println("Tạo mới thông tin bài viết.");
            System.out.println("-------------------------------");
            System.out.println("Please enter id: ");
            String code = scanner.nextLine();
            System.out.println("Please enter title: ");
            String title = scanner.nextLine();
            System.out.println("Please enter description: ");
            String descripsion = scanner.nextLine();
            System.out.println("Please enter content: ");
            String content = scanner.nextLine();
            System.out.println("Please enter dayWrite");
            String dayWrite =scanner.nextLine();
            System.out.println("Vui lòng nhập trạng thái (0. deactive | 1. active): ");
            int status = scanner.nextInt();
            scanner.nextLine();
            Article obj = new Article(title, descripsion, content, dayWrite, status);
            if (model.save(obj)) {
                return obj;
            }
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        return null;
    }

    public ArrayList<Article> getList() {
        return model.getList();
    }
}
