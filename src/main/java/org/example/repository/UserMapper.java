package org.example.repository;

import org.apache.ibatis.annotations.*;
import org.example.domain.Searchable;
import org.example.domain.User;
import org.example.domain.UserSqlProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    @Insert("INSERT INTO Users(EMAIL, NAME, PASSWORD, AGE) VALUES (#{email}, #{name}, #{password}, #{age})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before=false, resultType=int.class)
    void insert(User user);

    @Update("UPDATE Users SET EMAIL=#{email}, NAME=#{name}, PASSWORD=#{password}, AGE=#{age} WHERE ID=#{id}")
    void update(User user);

    @Select("SELECT * FROM Users")
    List<User> selectAll();

    @Select("SELECT * FROM Users WHERE ID=#{id}")
    User findOne(@Param("id") int id);

    @Delete("DELETE FROM Users WHERE ID=#{id}")
    void delete(@Param("id") int id);

    @Select("SELECT * FROM USERS WHERE EMAIL=#{email}")
    User findByEmail(@Param("email") String email);

    @SelectProvider(type= UserSqlProvider.class, method="findAllByProvider")
    List<User> findByProvider(Searchable searchable);

    //@formatter off
    @Select("<script>"
        + "SELECT * FROM USERS"
        + "<if test='name != null'> WHERE NAME=#{name}</if>"
        + "<if test='name != null and email != null'> OR EMAIL=#{email}</if>"
        + "<if test='orderParam != null'>ORDER BY ${orderParam} DESC</if>"
        + "</script>")
    //@formatter on
    List<User> findByScript(Searchable searchable);

    //@formatter off
    @Select("<script>"
            + "SELECT * FROM USERS"
            + "<if test='stringList != null and !stringList.empty'> WHERE NAME IN <foreach item='item' collection='stringList' open='(' separator=',' close=')'>#{item}</foreach></if>"
            + "</script>")
    //@formatter on
    List<User> findByList(@Param("stringList") List<String> stringList);
}
