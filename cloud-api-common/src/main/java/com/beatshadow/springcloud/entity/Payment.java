package com.beatshadow.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author : <a href="mailto:gnehcgnaw@gmail.com">gnehcgnaw</a>
 * @since : 2020/4/21 00:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    private Long id;

    private String serial;
}