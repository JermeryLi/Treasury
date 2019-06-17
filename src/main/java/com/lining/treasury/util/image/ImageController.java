package com.lining.treasury.util.image;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lining
 * @date 2019/5/9
 * @description ImageController
 */
@Controller
@RequestMapping("image")
public class ImageController {
    /**
     *
     * @return
     */
    @RequestMapping("Cut")
    public String imagCut(){
        return "image";
    }
}
