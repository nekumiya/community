package lemon.community.service;

import lemon.community.dto.PaginationDTO;
import lemon.community.dto.QuestionDTO;
import lemon.community.mapper.QuestionMapper;
import lemon.community.mapper.UserMapper;
import lemon.community.model.Question;
import lemon.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 欲隐君。 on 2019/12/8
 */
@Service
public class QuestionService {

    @Autowired
    public QuestionMapper questionMapper;

    @Autowired
    public UserMapper userMapper;


    public PaginationDTO list(Integer page, Integer size) {
        PaginationDTO paginationDTO = new PaginationDTO();

        Integer totalCount = questionMapper.count();
        paginationDTO.setPagination(totalCount,page,size);

        if (page < 1){
            page = 1;
        }
        if(page > paginationDTO.getTotalPage()){
            page = paginationDTO.getTotalPage();
        }

        Integer offset = size*(page-1);    //对应sql中limit的第一个参数

        List<Question> questionList = questionMapper.list(offset,size);
        List<QuestionDTO> questionDTOList = new ArrayList<>();


        for (Question question:questionList){
            Integer userId = question.getCreator();
            User user =  userMapper.findById(userId);
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);   //spring中通过反射可以将question的属性快速赋值一份到questionDTO内
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }

        paginationDTO.setQuestions(questionDTOList);

        return paginationDTO;
    }
}
