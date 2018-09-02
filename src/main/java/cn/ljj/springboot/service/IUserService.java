package cn.ljj.springboot.service;

import cn.ljj.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Auther: ljj
 * @Date: 2018/9/2 13:32
 * @Description:
 */
public interface IUserService extends JpaRepository<User,Integer> {
}
