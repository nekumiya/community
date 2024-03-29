package lemon.community.controller;

import lemon.community.mapper.QuestionMapper;
import lemon.community.model.Question;
import lemon.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 欲隐君。 on 2019/11/24
 */
@Controller
public class PublishController {

    @Autowired
    private QuestionMapper questionMapper;



    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }

    @PostMapping("/publish")
    public String doPublish(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("tag") String tag,
            HttpServletRequest request,
            Model model){

        model.addAttribute("title",title);
        model.addAttribute("description",description);
        model.addAttribute("tag",tag);

        if (title.isEmpty()){
            model.addAttribute("error","标题不能为空");
            return "publish";
        }
        if (description.isEmpty()){
            model.addAttribute("error","问题补充不能为空");
            return "publish";
        }
        if (tag.isEmpty()){
            model.addAttribute("error","标签不能为空");
            return "publish";
        }


        User user = (User)request.getSession().getAttribute("user");
        if (user == null){
            model.addAttribute("error","用户未登录");
            return "publish";
        }


        Question question = new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setCreator(user.getId());
        question.setGmt_create(System.currentTimeMillis());
        question.setGmt_modify(question.getGmt_create());
        questionMapper.create(question);
        return "redirect:/";
    }
}
