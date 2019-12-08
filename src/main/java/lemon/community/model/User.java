package lemon.community.model;

import lombok.Data;

/**
 * Created by 欲隐君。 on 2019/11/24
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String account_id;
    private String token;
    private Long gmt_create;
    private Long gmt_modified;
    private String avatar_url;

}
