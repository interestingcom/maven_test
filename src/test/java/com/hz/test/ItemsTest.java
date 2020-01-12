package com.hz.test;

import com.hz.dao.ItemsDao;
import com.hz.domain.Items;
import com.hz.impl.ItemsDaoImpl;
import org.junit.Test;
// i have changed it
//项目经理
import java.util.List;

public class ItemsTest {
     @Test
    public void findAll() throws Exception{
         ItemsDao itemsDao=new ItemsDaoImpl();
         List<Items> list =itemsDao.findAll();
         for (Items items: list
              ) {
             System.out.println(items.getName());
         }
     }
}
