package cn.ljj.springboot.controller;

import cn.ljj.springboot.entity.User;
import cn.ljj.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: ljj
 * @Date: 2018/9/2 09:38
 * @Description: springboot测试
 */
@RestController
@RequestMapping("/springboot/")
public class TestSpringboot {
    @Value("${name}")
    private String name;
    @Value("${age}")
    private Integer age;
    @Value("${content}")
    private String content;

    private IUserService userService;

    @RequestMapping(value="say",method = RequestMethod.GET)
    public String say(){
//        return "hello springboot " + "name: " + name + " age: " + age;
        return "hello springboot" + content;
    }

    /**
     * 添加用户信息
     * @param name 名称
     * @param age 年龄
     * @param sex 性别
     * @return 用户信息
     */
    @Transactional
    @PostMapping(value = "addUser")
    public User addUser(@RequestParam("name") String name, @RequestParam("age") Integer age, @RequestParam("sex") String sex){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setSex(sex);
        return userService.save(user);
    }

    /**
     * 查询用户信息
     * @param id 用户id
     * @return 用户信息
     */
    @PostMapping(value = "getUserById")
    public User getUserById(@RequestParam(value = "id",required = false) Integer id){
        return userService.getOne(id);
    }

    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }
}
