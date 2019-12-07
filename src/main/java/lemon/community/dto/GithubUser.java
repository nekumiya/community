package lemon.community.dto;

import lombok.Data;

/**
 * Created by 欲隐君。 on 2019/11/24
 */
@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatar_url;
}
