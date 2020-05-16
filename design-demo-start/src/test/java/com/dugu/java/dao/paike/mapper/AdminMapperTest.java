package com.dugu.java.dao.paike.mapper;

import com.dugu.java.design.demo.Application;
import com.dugu.java.dao.paike.domain.AdminDO;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdminMapperTest {

    @Autowired
    private AdminMapper adminMapper;

    private static Long ID = 1L;

    @Test
    public void test001Insert() {
        AdminDO adminDO = new AdminDO();
        adminDO.setName("独孤九剑");
        adminDO.setEmail("zhhdugujiujian@163.com");
        adminDO.setQq("364360613");
        adminDO.setWechat("zhaohaihua_82");
        adminDO.setPass("123456");
        adminDO.setMobile("13758116709");
        adminDO.setId(ID);
        adminDO.setRoleId(0L);
        Long id = adminMapper.insertSelective(adminDO);
        Assert.assertTrue(id != null);
        Assert.assertTrue(id > 0L);

    }

    @Test
    public void test002SelectByPrimaryKey() {
        AdminDO adminDO = adminMapper.selectByPrimaryKey(ID);
        Assert.assertTrue(adminDO != null);
    }

    @Test
    public void test003Delete() {
        int n = adminMapper.deleteByPrimaryKey(ID);
        Assert.assertTrue(n > 0);
    }

}