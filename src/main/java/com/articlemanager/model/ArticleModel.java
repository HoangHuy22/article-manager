package com.articlemanager.model;

import com.articlemanager.entity.Article;
import com.articlemanager.helper.ConnectionHelper;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.concurrent.Callable;

public class ArticleModel {
    public boolean save(Article article) {
        try {
            PreparedStatement preparedStatement = ConnectionHelper.getConnection()
                    .prepareStatement("insert into articles (id, title, description, content, dayWrite, status) values (?,?,?,?,?,?)");
            preparedStatement.setInt(1, article.getId());
            preparedStatement.setString(2, article.getTitle());
            preparedStatement.setString(3, article.getDescription());
            preparedStatement.setString(4, article.getContent());
            Date date = Date.valueOf(article.getDayWrite()); // dần chuyển sang Calendar.
            preparedStatement.setDate(5, date);
            preparedStatement.setInt(6, article.getStatus());
            preparedStatement.execute();
            return true;
        }catch (Exception ex){
            System.err.println("Error" + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
        }

    public ArrayList<Article> getList() {
        ArrayList<Article> list = new ArrayList<>();
        try {
            String cmd = "select * from articles"; // chưa có phân trang.
            PreparedStatement preparedStatement = ConnectionHelper.getConnection().prepareStatement(cmd);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                String content =resultSet.getString("content");
                Date date = resultSet.getDate("dayWrite");
                String dayWrite = date.toString();
                int status = resultSet.getInt("status");

                Article obj = new Article(title, description, content, dayWrite, status);
                obj.setId(id);
                list.add(obj);
            }
        } catch (Exception ex) {
            System.err.println("Không thể lấy dữ liệu từ database. Message: " + ex.getMessage());
        }
        return list;
    }
}
