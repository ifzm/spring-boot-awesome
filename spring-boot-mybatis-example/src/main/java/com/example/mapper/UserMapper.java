package com.example.mapper;

import com.example.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Mapper
@Component
public interface UserMapper {

    /**
     * @param email email
     * @return users
     */
    @Select("select * from user where email = #{email}")
    List<User> findByEmail(@Param("email") String email);

    /**
     * @param id id
     * @return user
     */
    @Select("select * from user where id = #{id}")
    User findOne(@Param("id") Serializable id);

    /**
     * @param user user
     * @return users
     */
    @SelectProvider(type = UserDynamicSqlProvider.class, method = "find")
    List<User> find(User user);
}
