package com.ifzm.mapper;

import com.ifzm.domain.User;
import org.apache.ibatis.jdbc.SQL;

public class UserDynamicSqlProvider {

    public String find(User user) {
        return new SQL() {{
            SELECT("*");
            FROM("user");
            if (user.getId() != null) {
                WHERE("id = #{id}");
            }
            if (user.getUsername() != null) {
                WHERE("username = #{username}");
            }
            if (user.getEmail() != null) {
                WHERE("email = #{email}");
            }
        }}.toString();
    }
}
