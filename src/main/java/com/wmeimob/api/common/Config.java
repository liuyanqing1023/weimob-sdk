package com.wmeimob.api.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: LYQ
 * @create: 2020-07-31 12:41
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Config {
    private String clientId;
    private String clientSecret;
    private String redirectUri;

}
