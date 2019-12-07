package lemon.community.dto;

import lombok.Data;

/**
 * Created by 欲隐君。 on 2019/11/24
 */
@Data
public class AccessTokenDto {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;

}
