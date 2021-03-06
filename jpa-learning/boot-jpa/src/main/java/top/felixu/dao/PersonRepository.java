package top.felixu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import top.felixu.entity.Person;

import java.util.List;

/**
 * @author : felixu
 * @createTime : 2017/11/27.
 */
public interface PersonRepository extends JpaRepository<Person, Integer> {

    /**
     * 通过地址查询
     * @param address
     * @return
     */
    List<Person> findByAddress(String address);

    /**
     * 根据名字查询
     * @param name
     * @return
     */
    String findByName(String name);

    /**
     * 查询符合条件的前二十条记录
     * @param name
     * @return
     */
    List<Person> findFirst20ByName(String name);

    /**
     * 根据名字和地址查询
     * @param name
     * @param address
     * @return
     */
    @Query("select p from Person p where p.name= :name and p.address= :address")
    Person withNameAndAddressQuery(@Param("name") String name, @Param("address") String address);

    /**
     * 更新名字
     * @param name
     * @return
     */
    @Modifying
    @Query("update Person p set p.name=?1 ")
    int setName(String name);
}
