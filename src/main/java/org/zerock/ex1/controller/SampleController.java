package org.zerock.ex1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * packageName : org.zerock.ex1.controller
 * className : SampleController
 * user : jwlee
 * date : 2022/09/15
 */
@RestController
public class SampleController {

    @GetMapping("/hello")
    public String[] hello() {
        return new String[]{"Hello", "World"};
    }

}
