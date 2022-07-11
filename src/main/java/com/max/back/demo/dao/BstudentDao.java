package com.max.back.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.max.back.demo.entity.Bstudent;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author max
 * @since 2021-07-29
 */
public interface BstudentDao extends BaseMapper<Bstudent> {

    @Select({
            "<script> " +
            "SELECT "   +
            "    bstudent.id, "   +
            "    bstudent.stucode, "   +
            "    bstudent.stuname, "   +
            "    bstudent.stuschid, "   +
            "    bschool.schoolname, "   +
            "    bstudent.stuage, "   +
            "    bstudent.stubrithday, "   +
            "    bstudent.codenameid, "   +
            "    bcodename.name "   +
            "FROM   bstudent"   +
            "   INNER JOIN bschool ON   bstudent.stuschid =  bschool.id "   +
            "   INNER JOIN bcodename ON bstudent.codenameid = bcodename.id "   +
            "WHERE  1=1 " +
            "  <if test='stuName != null and stuName != \"\" '>" +
            "     AND stuname LIKE CONCAT('%',#{stuName},'%') " +
            "  </if>"   +
            "  <if test='schId != null and schId != \"\" '>" +
            "     AND stuschid = #{schId}" +
            "  </if>"   +
            "  <if test='sexCode != null and sexCode != \"\" '>" +
            "     AND codenameid = #{sexCode}" +
            "  </if> "   +
            " ORDER BY bstudent.stucode"   +
            "</script>"
    })
    public List<Map<String, Object>> selectByCond(@Param("stuName") String stuName,
                                                  @Param("schId") String schId,
                                                  @Param("sexCode") String sexCode);

    @Select({
            "<script> " +
            "SELECT "   +
            "    MAX(stucode) AS maxstucode "   +
            "FROM  bstudent"   +
            "</script>"
    })
    public Map<String, String> selectMaxStuCode();

    public List<Bstudent> getmstu();
}
