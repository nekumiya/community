package lemon.community.dto;

import lemon.community.model.User;
import lombok.Data;

/**
 * Created by 欲隐君。 on 2019/12/8
 */
@Data
public class QuestionDTO {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmt_create;
    private Long gmt_modify;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private User user;
}
