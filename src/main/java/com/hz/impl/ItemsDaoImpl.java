package com.hz.impl;

import com.hz.dao.ItemsDao;
import com.hz.domain.Items;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ItemsDaoImpl implements ItemsDao {
    public List<Items> findAll() throws  Exception {
        List<Items> list =new ArrayList<Items>();
        Connection connection=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
      try {
          //加载驱动类
          Class.forName("com.mysql.cj.jdbc.Driver");
          //先获取connection对象
          connection= DriverManager.getConnection("jdbc:mysql://localhost/test2?useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true", "root","123456");
          //获取真正的操作数据对象

         pst=connection.prepareCall("select * from test");


         rs=pst.executeQuery();
          while(rs.next()){
              Items items=new Items();
              items.setId(rs.getInt("id"));
              items.setName(rs.getString("name"));
              list.add(items);
          }
      }catch (Exception e)
      {
          e.printStackTrace();
      }
      finally {
                connection.close();
                pst.close();
                rs.close();
      }
        return list;
    }
}
