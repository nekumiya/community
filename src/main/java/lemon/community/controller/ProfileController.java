package lemon.community.controller;

import lemon.community.dto.PaginationDTO;
import lemon.community.mapper.UserMapper;
import lemon.community.model.User;
import lemon.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 欲隐君。 on 2019/12/10
 */
@Controller
public class ProfileController {

    @Autowired
    public UserMapper userMapper;

    @Autowired
    public QuestionService questionService;

    @GetMapping("/profile/{action}")      //动态切换路径
    public String profile(@PathVariable(name = "action") String action, Model model, HttpServletRequest request,
                          @RequestParam(name = "page",defaultValue = "1") Integer page,
                          @RequestParam(name = "size",defaultValue = "5") Integer size){


        User user = (User)request.getSession().getAttribute("user");
        if (user == null){
            return  "redirect:/";
        }


        if(action.equals("questions")){
            model.addAttribute("section","questions");
            model.addAttribute("sectionName","我的提问");
        }else if(action.equals("replies")){
            model.addAttribute("section","replies");
            model.addAttribute("sectionName","最新回复");
        }

        PaginationDTO paginationDTO = questionService.list(user.getId(), page, size);

        model.addAttribute("pagination",paginationDTO);
        return "profile";
    }

}
