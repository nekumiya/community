package lemon.community.service;

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


    public List<QuestionDTO> list() {

        List<Question> questionList = questionMapper.list();
        List<QuestionDTO> questionDTOList = new ArrayList<>();

        for (Question question:questionList){
            //System.out.println(question);
            User user =  userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);   //spring中通过反射可以将question的属性快速赋值一份到questionDTO内
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
            //System.out.println(questionDTO);
        }
        return questionDTOList;
    }
}
