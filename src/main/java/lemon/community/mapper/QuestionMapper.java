package lemon.community.mapper;

import lemon.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by 欲隐君。 on 2019/12/7
 */
@Mapper
public interface QuestionMapper {

    @Insert("insert into question (title,description,gmt_create,gmt_modify,creator,tag) value (#{title},#{description},#{gmt_create},#{gmt_modify},#{creator},#{tag})")
    public void create(Question question);
}
